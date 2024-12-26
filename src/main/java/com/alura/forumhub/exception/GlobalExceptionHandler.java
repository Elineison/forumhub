package com.alura.forumhub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErroValidacaoDTO> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(ErroValidacaoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErroDTO erro = new ErroDTO(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    // DTOs de erro
    public static class ErroValidacaoDTO {
        private String campo;
        private String mensagem;

        public ErroValidacaoDTO(FieldError erro) {
            this.campo = erro.getField();
            this.mensagem = erro.getDefaultMessage();
        }

        // Getters
        public String getCampo() {
            return campo;
        }

        public String getMensagem() {
            return mensagem;
        }
    }

    public static class ErroDTO {
        private int status;
        private String mensagem;
        private LocalDateTime timestamp;

        public ErroDTO(int status, String mensagem, LocalDateTime timestamp) {
            this.status = status;
            this.mensagem = mensagem;
            this.timestamp = timestamp;
        }

        // Getters
        public int getStatus() {
            return status;
        }

        public String getMensagem() {
            return mensagem;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }
    }
}
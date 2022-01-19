package br.com.banco.exeption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExeptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(CpfJaCadastrado.class) // serve para tratar todos os erros sem exibir mensagens desnecessarias na tela com apenas a mensagem configurada
    public ResponseEntity<StandardError> handle(CpfJaCadastrado exception) {
        StandardError erros = new StandardError(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erros);
    }

    @ExceptionHandler(CpfNaoEncontrado.class)
    public ResponseEntity<StandardError> handle(CpfNaoEncontrado exception) {
        StandardError erros = new StandardError(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erros);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<StandErrosMetodos>> handle(MethodArgumentNotValidException exception) {
        List<StandErrosMetodos> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            StandErrosMetodos erro = new StandErrosMetodos(e.getField(), message);
            dto.add(erro);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}

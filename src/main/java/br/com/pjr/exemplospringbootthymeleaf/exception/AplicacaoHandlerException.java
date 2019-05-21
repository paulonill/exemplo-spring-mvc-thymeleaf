package br.com.pjr.exemplospringbootthymeleaf.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class AplicacaoHandlerException {

	@ExceptionHandler({EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String emptyResultDataAccessException(final Model model) {

        model.addAttribute("errorMessage", "Recurso não encontrado!");
        
        return "erro";
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String dataIntegrityViolationException(final Model model) {

        model.addAttribute("errorMessage", "Erro ao realizar a operação!");

        return "erro";
    }
}

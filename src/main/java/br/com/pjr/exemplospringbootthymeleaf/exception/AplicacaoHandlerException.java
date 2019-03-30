package br.com.pjr.exemplospringbootthymeleaf.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AplicacaoHandlerException {

	@ExceptionHandler({EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Model model) {

        model.addAttribute("errorMessage", "Recurso não encontrado!");
        
        return "erro";
    }
}

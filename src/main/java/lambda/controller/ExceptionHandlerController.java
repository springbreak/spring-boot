package lambda.controller;

import lambda.exception.NonExistsBookException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionHandlerController {

	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(NonExistsBookException.class)
	@ResponseBody
	ResponseEntity NonExistsBook(NonExistsBookException e) {
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}

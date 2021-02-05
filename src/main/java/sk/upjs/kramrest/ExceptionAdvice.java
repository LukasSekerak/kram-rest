package sk.upjs.kramrest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kram.storage.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody()
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiError handleEntityNotFoundException(EntityNotFoundException e) {
		return new ApiError(e.getMessage());
	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseBody()
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleNullPointerException(NullPointerException e) {
		return new ApiError(e.getMessage());
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody()
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new ApiError(e.getMessage());
	}

	@ExceptionHandler(NumberFormatException.class)
	@ResponseBody()
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleNumberFormatException(NumberFormatException e) {
		return new ApiError("Nepodarilo sa skonvertovať id  z URL");
	}
}

package br.com.wa.config.http;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.wa.http.domain.response.DefaultResponse;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@RestController
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<br.com.wa.http.domain.response.DefaultResponse> handleAllExceptions(Exception ex, WebRequest request) {
        Optional<ResponseStatus> annotationResponse = getResponseAnnotation(ex.getClass());
        return baseHandler(ex, annotationResponse, INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<DefaultResponse> baseHandler(Exception ex, Optional<ResponseStatus> annotationResponse, HttpStatus httpStatus) {
        String status = httpStatus.name();

        try {
            if (annotationResponse.isPresent()) {
                httpStatus = annotationResponse.get().value();

                log(ex, httpStatus);

                if (isEmpty(annotationResponse.get().reason())) {
                    status = httpStatus.name();
                } else {
                    status = annotationResponse.get().reason();
                }
            } else {
                log(ex);
            }

        } catch (Exception e) {
            log(e);
        }

        return new ResponseEntity<>(new DefaultResponse(status, extractMessage(ex)), httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors())
            errors.add(error.getField() + ": " + error.getDefaultMessage());

        for (ObjectError error : ex.getBindingResult().getGlobalErrors())
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());

        DefaultResponse response = new DefaultResponse(BAD_REQUEST.name(), errors);

        return handleExceptionInternal(ex, response, headers, BAD_REQUEST, request);
    }

    private boolean isEmpty(String valor) {
        return valor == null || valor.isEmpty();
    }

    private Optional<ResponseStatus> getResponseAnnotation(Class<?> exceptionClass) {
        return Optional.ofNullable(AnnotationUtils.findAnnotation(exceptionClass, ResponseStatus.class));
    }

    private void log(Exception ex, HttpStatus httpStatus) {
        if(httpStatus.is4xxClientError()){
            log.warn(ex.getMessage(), ex);
        }else{
            log.error(ex.getMessage(), ex);
        }
    }

    private void log(Exception ex) {
        log.error(ex.getMessage(), ex);
    }

    private String extractMessage(Exception ex) {
        return isEmpty(ex.getMessage()) ? ex.getClass().getSimpleName() : ex.getMessage();
    }

}

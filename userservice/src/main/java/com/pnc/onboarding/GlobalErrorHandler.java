package com.pnc.onboarding;

import com.pnc.onboarding.api.ApiError;
import com.pnc.onboarding.api.ApiStatus;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResponseStatusException.class})
    protected ResponseEntity<ApiStatus> handleGlobalException(ResponseStatusException ex, WebRequest request) {
        ApiStatus error = new ApiStatus();
        error.setStatus("fail");
        HashMap<String,Object> map = new HashMap();
        map.put("title",ex.getReason());
        error.setData(map);
        return new ResponseEntity(error,ex.getStatus());
    }

    @ExceptionHandler({HttpServerErrorException.InternalServerError.class,Exception.class})
    protected ResponseEntity<ApiStatus> handleInternalServerException(Exception ex, WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus("fail");
        error.setData(ex.getMessage());
        return new ResponseEntity(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError error = new ApiError();
        error.setStatus("fail");
        error.setData(ex.getMessage());
        return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
    }
}

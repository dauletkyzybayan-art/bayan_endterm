package com.example.libraryapi.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleNotFound(NotFoundException ex, HttpServletRequest req) {
        return new ApiErrorResponse(Instant.now(), 404, "NOT_FOUND", ex.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleBadRequest(BadRequestException ex, HttpServletRequest req) {
        return new ApiErrorResponse(Instant.now(), 400, "BAD_REQUEST", ex.getMessage(), req.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String msg = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");
        return new ApiErrorResponse(Instant.now(), 400, "VALIDATION_ERROR", msg, req.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleAny(Exception ex, HttpServletRequest req) {
        return new ApiErrorResponse(Instant.now(), 500, "INTERNAL_ERROR", ex.getMessage(), req.getRequestURI());
    }
}
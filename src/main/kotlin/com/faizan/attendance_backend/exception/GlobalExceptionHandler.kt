package com.faizan.attendance_backend.exception

import com.faizan.attendance_backend.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import tools.jackson.databind.exc.UnrecognizedPropertyException

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(
        ex: UserNotFoundException
    ): ResponseEntity<ErrorResponse> {
        println("Exception Handler Called")
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    message = ex.message!!
                )
            )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        val error = mutableMapOf<String, String>()
        ex.bindingResult.fieldErrors.forEach { errors ->
            error[errors.field] = errors.defaultMessage ?: "Invalid Value"
        }
        return ResponseEntity
            .badRequest()
            .body(
                ErrorResponse(
                    message = "Validation Failed",
                    errors = error
                )
            )
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(
        ex: HttpMessageNotReadableException
    ): ResponseEntity<ErrorResponse> {
        val cause = ex.cause

        return if (cause is UnrecognizedPropertyException) {
            ResponseEntity.badRequest().body(
                ErrorResponse(
                    message = "Unknown field '${cause.propertyName}'"
                )
            )
        } else {
            ResponseEntity.badRequest().body(
                ErrorResponse(
                    message = "Invalid request body"
                )
            )
        }
    }

}
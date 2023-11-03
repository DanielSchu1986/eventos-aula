package br.upf.sistemadeeventos.exceptions

import br.upf.sistemadeeventos.dtos.ErrorResponseDTO
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFoundHandler (
        exception: NotFoundException,
        request: HttpServletRequest
    ): ErrorResponseDTO {
        return ErrorResponseDTO(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = exception.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequestHandler (
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorResponseDTO {
        val errorMessage = hashMapOf<String, String>()
        exception.bindingResult.fieldErrors.forEach{
            errorMessage[it.field] = it.defaultMessage ?: "Erro desconhecido!"
        }
        return ErrorResponseDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorMessage.toString(),
            path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun exceptionHandler (
        exception: Exception,
        request: HttpServletRequest
    ): ErrorResponseDTO {
        return ErrorResponseDTO(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = exception.message ?: "Erro desconhecido",
            path = request.servletPath
        )
    }

}
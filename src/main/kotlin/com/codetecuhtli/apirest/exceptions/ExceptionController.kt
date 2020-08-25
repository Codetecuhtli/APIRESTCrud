package com.codetecuhtli.apirest.exceptions

import com.codetecuhtli.apirest.constants.Messages
import com.codetecuhtli.apirest.models.BaseResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionController: ResponseEntityExceptionHandler() {

    @Autowired
    private lateinit var messageSource: MessageSource

    @ExceptionHandler(value = [ NotFoundException::class ])
    fun handleNotFoundException(exception: NotFoundException, request: WebRequest): ResponseEntity<BaseResponse>{
        val message = exception.message ?:
        messageSource.getMessage(
                exception.key ?: Messages.NOT_FOUND_MESSAGE_KEY,
                null,
                request.locale)
        return ResponseEntity(BaseResponse(message), HttpStatus.NOT_FOUND)
    }

    override fun handleMethodArgumentNotValid(
            ex: MethodArgumentNotValidException,
            headers: HttpHeaders,
            status: HttpStatus,
            request: WebRequest): ResponseEntity<Any> {
        
        val errorMessage = ex.bindingResult.fieldErrors.map { it.defaultMessage }.first() ?: ex.message
        return ResponseEntity(BaseResponse(errorMessage), HttpStatus.BAD_REQUEST)
    }

}
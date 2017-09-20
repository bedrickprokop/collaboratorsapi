package br.com.collaboratorsapi.exception;

import br.com.collaboratorsapi.model.dto.ApplicationExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

    @Autowired
    private MessageSource messageSource;

    public Response toResponse(Exception e) {

        String keyMessage = "internal.error.server";
        if (null != e.getMessage()) {
            keyMessage = e.getMessage();
        }

        //Recupera a mensagem no arquivo de texto pela sua chave
        String errorMessage = messageSource.getMessage(keyMessage, null,
                LocaleContextHolder.getLocale());

        ApplicationExceptionDTO dto = new ApplicationExceptionDTO();
        dto.setErrorMessage(errorMessage);

        int statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        if (e instanceof ApplicationException) {
            ApplicationException exception = (ApplicationException) e;
            if (null != exception.getStatusCode()) {
                statusCode = exception.getStatusCode();
            }
        }
        return Response.status(statusCode)
                .type(MediaType.APPLICATION_JSON)
                .entity(dto)
                .build();
    }
}
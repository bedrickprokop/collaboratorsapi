package br.com.collaboratorsapi.exception;

import br.com.collaboratorsapi.model.dto.ApplicationExceptionDTO;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

    public Response toResponse(Exception e) {

        ApplicationExceptionDTO dto = new ApplicationExceptionDTO();
        dto.setErrorMessage(e.getMessage());

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
package br.com.collaboratorsapi.exception;

import br.com.collaboratorsapi.model.dto.ValidationExceptionDTO;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException e) {
        ArrayList<ValidationExceptionDTO> entityArrayList = new
                ArrayList<ValidationExceptionDTO>();

        for (ConstraintViolation<?> cv : ((ConstraintViolationException) e)
                .getConstraintViolations()) {

            ValidationExceptionDTO dto = new ValidationExceptionDTO();
            dto.setFieldName(null != cv.getPropertyPath() ?
                    cv.getPropertyPath().toString() : null);

            dto.setInvalidValue(null != cv.getInvalidValue() ?
                    cv.getInvalidValue().toString() : null);

            dto.setErrorMessage(cv.getMessage());
            entityArrayList.add(dto);
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .type(MediaType.APPLICATION_JSON)
                .entity(entityArrayList)
                .build();
    }
}
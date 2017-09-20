package br.com.collaboratorsapi.exception;

import br.com.collaboratorsapi.model.dto.ValidationExceptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

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

    @Autowired
    private MessageSource messageSource;

    @Override
    public Response toResponse(ValidationException e) {
        ArrayList<ValidationExceptionDTO> entityArrayList = new
                ArrayList<ValidationExceptionDTO>();

        for (ConstraintViolation<?> cv : ((ConstraintViolationException) e)
                .getConstraintViolations()) {

            //Recupera a mensagem no arquivo de texto pela sua chave
            String errorMessage = messageSource.getMessage(cv.getMessage(), null,
                    LocaleContextHolder.getLocale());

            //Monta o DTO de error para enviar para o client passando a mensagem
            ValidationExceptionDTO dto = new ValidationExceptionDTO();
            dto.setFieldName(null != cv.getPropertyPath() ?
                    cv.getPropertyPath().toString() : null);
            dto.setInvalidValue(null != cv.getInvalidValue() ?
                    cv.getInvalidValue().toString() : null);
            dto.setErrorMessage(errorMessage);

            entityArrayList.add(dto);
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .type(MediaType.APPLICATION_JSON)
                .entity(entityArrayList)
                .build();
    }
}
package br.com.collaboratorsapi.helper;

import br.com.collaboratorsapi.model.entity.Collaborator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CollaboratorSerializerHelper extends StdSerializer<Collaborator> {

    public CollaboratorSerializerHelper() {
        this(null);
    }

    public CollaboratorSerializerHelper(Class<Collaborator> t) {
        super(t);
    }

    @Override
    public void serialize(Collaborator collaborator, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("code", collaborator.getCode());
        jsonGenerator.writeStringField("name", collaborator.getName());
        jsonGenerator.writeStringField("login", collaborator.getLogin());
        jsonGenerator.writeStringField("profile", collaborator.getProfile().toString());
        jsonGenerator.writeEndObject();
    }
}

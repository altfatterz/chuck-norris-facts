package com.altfatterz;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

@JsonComponent // registering custom JsonSerializer and JsonDeserializer
class ChuckNorrisFactJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChuckNorrisFactJson.class);

    public static class Serializer extends JsonObjectSerializer<ChuckNorrisFact> {

        @Override
        protected void serializeObject(ChuckNorrisFact value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            LOGGER.debug("custom serializer called");
            jgen.writeStringField("fact", value.getText());
        }
    }

    public static class Deserilizer extends JsonObjectDeserializer<ChuckNorrisFact> {

        @Override
        protected ChuckNorrisFact deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
            LOGGER.debug("custom deserializer called");
            String fact = tree.get("fact").asText();
            return new ChuckNorrisFact(fact);
        }
    }
}

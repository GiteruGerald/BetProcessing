package com.betnare.configs;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JsonDeserializer extends StdDeserializer<String> {
    public JsonDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        JsonNode node = parser.getCodec().readTree(parser);
        String result = null;
        if (node.isObject()) {
            result = node.toString();
        }
        return result;
    }
}

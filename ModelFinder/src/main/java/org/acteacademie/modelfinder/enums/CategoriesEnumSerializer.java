package org.acteacademie.modelfinder.enums;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CategoriesEnumSerializer  extends JsonSerializer<CategoriesEnum>{

	  @Override
	  public void serialize(CategoriesEnum value, JsonGenerator generator,
	            SerializerProvider provider) throws IOException,
	            JsonProcessingException {

	    generator.writeStartObject();
	    generator.writeFieldName("categoryService");
	    generator.writeString(value.getCategory());
	    generator.writeEndObject();
	  }
}

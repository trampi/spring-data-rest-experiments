package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hello.validator.PersonValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;

@SpringBootApplication
public class Application extends SpringBootRepositoryRestMvcConfiguration {

    @Override
    protected void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("beforeSave", new PersonValidator());
        validatingListener.addValidator("beforeCreate", new PersonValidator());
    }

    @Override
    protected void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        objectMapper.enable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

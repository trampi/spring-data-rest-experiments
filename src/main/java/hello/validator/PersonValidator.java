package hello.validator;

import hello.domain.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreatePersonValidator")
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (((Person) target).getFirstName() == null) {
            errors.reject("");
        }

        if (((Person) target).getLastName() == null) {
            errors.reject("");
        }
    }

}

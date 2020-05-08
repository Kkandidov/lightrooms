package org.astashonok.validator;

import org.astashonok.model.Room;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RoomValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Room.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Room product = (Room) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roomName", "Required");
    }
}

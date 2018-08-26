package controller.ValidationControl;

import model.LivingElements.LiveEntity;

import javax.validation.*;
import java.util.Set;

public class playerValidation {
    private static LiveEntity validEntity(LiveEntity entity){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<LiveEntity>> constraintViolations = validator.validate(entity);

        return entity;
    }
}
0
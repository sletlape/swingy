package za.co.wethinkcode.sletlape.swingy.controller.ValidationControl;

import za.co.wethinkcode.sletlape.swingy.model.LivingElements.LiveEntity;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class PlayerValidation {

    public static Set<ConstraintViolation<LiveEntity>> validEntity(LiveEntity entity){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<LiveEntity>> constraintViolations = validator.validate(entity);

        return constraintViolations;
    }
}
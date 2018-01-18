package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;


public class YearOfBirthValidator implements ConstraintValidator<YearOfBirth, String> {


    private Integer ageLimit;

    @Override
    public void initialize(YearOfBirth constraintAnnotation) {
        this.ageLimit = Integer.valueOf(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        int currentYear = LocalDate.now().getYear();

        if (currentYear - Integer.valueOf(s) >= ageLimit) {
            return true;
        } else {
            return false;
        }
    }
}

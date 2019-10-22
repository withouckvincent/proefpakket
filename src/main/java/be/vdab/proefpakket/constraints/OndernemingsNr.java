package be.vdab.proefpakket.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.springframework.messaging.handler.annotation.Payload;

@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = OndernemingsNrValidator.class)
public @interface OndernemingsNr {
	String message() default "{be.vdab.proefpakket.constraints.OndernemingsNummer.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
package tech.dev.commons.utils;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * DUtilitaire pour les validations
 * <p>
 * Date: 07/02/2019
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

public class ValidationUtil {

    //1.sans properties file
    //private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    //2.with properties file
    private static final Validator VALIDATOR = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(
                    new ResourceBundleMessageInterpolator(
                            new PlatformResourceBundleLocator("messages/common")
                    )
            )
            .buildValidatorFactory()
            .getValidator();

    /**
     * Valide un objet et retourne une InvalidDataException si l'objet n'est pas valide
     * @param objectToValidate l'objet à valider
     * @param groups les groupes pour lesquels effectuer la validation
     * @throws Exception exception si objet non valide
     */
    public static <T> void validData(T objectToValidate, java.lang.Class<?>... groups) throws Exception {

        String messError = null;
        Set<ConstraintViolation<T>> errors = VALIDATOR.validate(objectToValidate, groups);

        if (errors.size() > 0) {
            for (ConstraintViolation<T> error : errors) {
                // On ajoute la propriété avant le message d'erreur s'il n'y a pas de message d'erreur directement associé dans l'anotation avec message =
                messError = (messError != null ? messError + System.getProperty("line.separator") : "") +
                        ((error.getMessageTemplate().contains("org.hibernate") || (error.getMessageTemplate().contains("javax.validation"))) ? error.getPropertyPath() + " -> " : "") +
                        error.getMessage();
            }
            if (messError != null) {
                // Les messages d'erreur doivent avoir une double quote pour s'afficher correctement dans spring (tag form:errors),
                // mais on n'en tient pas compte lors de l'utilisation de ValidationUtil
                messError = messError.replaceAll("''", "'");
                throw new Exception(messError);
            }
        }
    }
}

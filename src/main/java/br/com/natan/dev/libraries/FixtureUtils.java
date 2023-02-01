package br.com.natan.dev.libraries;

import br.com.natan.dev.libraries.enums.FieldType;
import br.com.natan.dev.libraries.enums.PackageType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collection of methods that will assist in the creation of unit tests.
 *
 * <p>
 * this library has static and generic methods
 * that receive a class as a parameter and return an instantiation of that class
 * with all fields filled with default values and within the business rules of the odin project.
 * </p>
 *
 * @version 1.0
 */
public class FixtureUtils {

    public static final String DEFAULT_STRING = (String) FieldType.STRING.getValue();
    public static final Integer DEFAULT_INTEGER = (Integer) FieldType.INTEGER.getValue();
    public static final Long DEFAULT_LONG = (Long) FieldType.LONG.getValue();
    public static final LocalDate WRONG_DATE = LocalDate.now().minusDays(1);

    /**
     *
     * @param type class
     * @param <T> target type
     * @return instance of T
     */
    public static <T> T raiseStartDateException(Class<T> type) {
        T object = instanceOf(type);
        Utils.invokeSet(Objects.requireNonNull(object),
                FieldType.START_DATE.getName(), WRONG_DATE);

        return object;
    }

    /**
     *
     * @param type class
     * @param <T> target type
     * @return instance of T
     */
    public static <T> T raiseEndDateException(Class<T> type) {
        T object = instanceOf(type);
        Utils.invokeSet(Objects.requireNonNull(object),
                FieldType.END_DATE.getName(), WRONG_DATE);

        return object;
    }

    /**
     *
     * @param type class
     * @param field field name
     * @param value field value
     * @param <T> target type
     * @return instance of T
     */
    public static <T> T customInstanceOf(Class<T> type, String field, Object value) {
        T object = instanceOf(type);
        Utils.invokeSet(Objects.requireNonNull(object), field, value);

        return object;
    }

    /**
     *
     * @param type class
     * @param validityIndicator boolean
     * @param <T> target type
     * @return instance of T
     */
    public static <T> T instanceOfWithValidityIndicator(Class<T> type, boolean validityIndicator) {
        T object = instanceOf(type);
        Utils.invokeSet(Objects.requireNonNull(object),
                FieldType.VALIDITY_INDICATOR.getName(), validityIndicator);

        return object;
    }

    /**
     *
     * @param type class
     * @param validityIndicator boolean
     * @param <T> target type
     * @return List of T
     */
    public static <T> List<T> instanceListWithValidityIndicator(Class<T> type, boolean validityIndicator) {
        T object = instanceOf(type);
        Utils.invokeSet(Objects.requireNonNull(object),
                FieldType.VALIDITY_INDICATOR.getName(), validityIndicator);

        return Stream.of(object).collect(Collectors.toList());
    }

    /**
     *
     * @param type class
     * @param <T> target type
     * @return instance of T
     *
     */
    public static <T> T instanceOf(Class<T> type) {
        try {
            T object = type.getConstructor().newInstance();
            Stream.of(object.getClass().getDeclaredFields()).forEach(field -> {
                if (!field.getType().getPackageName().startsWith(PackageType.HIBERNATE.getName())) {
                    Utils.invokeSet(object, field.getName(), fillField(field));
                }
            });

            Utils.invokeSet(object, FieldType.ENTITY_CODE.getName(), FieldType.ENTITY_CODE.getValue());
            return object;
        } catch (InvocationTargetException | InstantiationException
                 | IllegalAccessException | NoSuchMethodException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param field field of T
     * @return object
     */
    private static Object fillField(Field field) {
        Class<?> type = field.getType();
        if(Objects.equals(type, String.class)) {
            return FieldType.STRING.getValue();
        }
        if (Objects.equals(type, LocalDate.class)) {
            return field.getName().equals(FieldType.START_DATE.getName()) ?
                    FieldType.START_DATE.getValue() : FieldType.END_DATE.getValue();
        }
        if (Objects.equals(type, LocalDateTime.class)) {
            return FieldType.REGISTRATION_DATE.getValue();
        }
        if (Objects.equals(type, Integer.class)) {
            return FieldType.INTEGER.getValue();
        }
        if (Objects.equals(type, Long.class) || Objects.equals(field.getName(), "serialVersionUID")) {
            return FieldType.LONG.getValue();
        }
        if (Objects.equals(type, Boolean.class)) {
            return FieldType.BOOLEAN.getValue();
        }

        return instanceOf(field.getType());
    }
}

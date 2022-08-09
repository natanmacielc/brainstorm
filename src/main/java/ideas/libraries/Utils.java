package ideas.libraries;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Utils {
    public static Object invokeGet(Object obj, String fieldName) {
        try {
            return obj.getClass()
                    .getMethod("get".concat(StringUtils.capitalize(fieldName)))
                    .invoke(obj);
        } catch (IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | NoSuchMethodException |
                 SecurityException e) {
            return null;
        }
    }

    public static void invokeSet(Object obj, String fieldName, Object param) {
        try {
            obj.getClass()
                    .getMethod("set".concat(StringUtils.capitalize(fieldName)), param.getClass())
                    .invoke(obj, param);
        } catch (IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException | NoSuchMethodException |
                 SecurityException e) {
            e.printStackTrace();
        }
    }

    public static <E, R> E mergeObjects(E entity, R request) {
        Stream.of(request.getClass().getDeclaredFields()).forEach(field -> {
            Object value = invokeGet(request, field.getName());

            if (Objects.nonNull(value))
                invokeSet(entity, field.getName(), value);
        });

        return entity;
    }

    public static Object firstNonNull(Object... objects) {
        for (Object obj : objects) {
            if (Objects.nonNull(obj)) return obj;
        }

        return null;
    }

    public static Map<String, Object> createMapId(Object... obj) {
        Map<String, Object> mapId = new HashMap<>();

        for(int index = 0; index < obj.length; index += 2) {
            mapId.put(obj[index].toString(), obj[index + 1]);
        }

        return mapId;
    }
}


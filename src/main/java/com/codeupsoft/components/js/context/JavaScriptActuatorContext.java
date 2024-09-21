package com.codeupsoft.components.js.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行器上下文
 *
 * @author dongdong.liu@codeupsoft.com
 */
public class JavaScriptActuatorContext {

    /**
     * 存储空间
     */
    private static final ThreadLocal<Map<String, Object>> ACTUATOR_CONTEXT = ThreadLocal.withInitial(HashMap::new);


    public static Map<String, Object> getContext() {
        return ACTUATOR_CONTEXT.get();
    }

    public static <T> T getMapContext(String key) {
        return (T) ACTUATOR_CONTEXT.get().get(key);
    }

    public static void setActuatorContext(String key, Object value) {
        ACTUATOR_CONTEXT.get().put(key, value);
    }

    public static void removeActuatorContext(String key) {
        ACTUATOR_CONTEXT.get().remove(key);
    }

    public static void clear() {
        ACTUATOR_CONTEXT.remove();
    }

}

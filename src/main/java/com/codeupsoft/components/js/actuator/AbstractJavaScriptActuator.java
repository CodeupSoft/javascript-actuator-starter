package com.codeupsoft.components.js.actuator;

import com.codeupsoft.components.js.context.JavaScriptActuatorContext;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

/**
 * JavaScript Actuator
 *
 * @author didi.liu@codeupsoft.com
 */
public abstract class AbstractJavaScriptActuator<T, K> {

    @Resource
    private Context context;

    /**
     * 清除上下文
     */
    protected void clearContext() {
        JavaScriptActuatorContext.clear();
    }

    /**
     * 获取JS脚本
     *
     * @param scriptCondition 获取脚本条件
     */
    protected abstract T getScript(@Nonnull K scriptCondition);

    /**
     * 执行JS
     *
     * @param script     js代码
     * @param funcName   函数名称
     * @param arguments js参数
     */
    protected Value execScript(@Nonnull String script, @Nonnull String funcName, @Nonnull Object... arguments) {
        context.eval("js", script);
        final Value func = context.getBindings("js").getMember(funcName);
        return func.execute(arguments);
    }

    /**
     * 执行JS
     *
     * @param script js代码
     */
    protected Value execScript(@Nonnull String script) {
        return context.eval("js", script);
    }

}

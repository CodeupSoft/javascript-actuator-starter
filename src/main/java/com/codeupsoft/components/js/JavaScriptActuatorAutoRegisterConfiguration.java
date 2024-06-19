package com.codeupsoft.components.js;

import org.graalvm.polyglot.Context;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * AutoRegisterConfiguration
 *
 * @author didi.liu@codeupsoft.com
 */

@EnableConfigurationProperties(JavaScriptContextProperties.class)
class JavaScriptActuatorAutoRegisterConfiguration {

    private final JavaScriptContextProperties contextProperties;

    public JavaScriptActuatorAutoRegisterConfiguration(JavaScriptContextProperties contextProperties) {
        this.contextProperties = contextProperties;
    }

    @Bean
    Context context(){
        return Context.newBuilder("js").allowAllAccess(contextProperties.getAllowAllAccess()).build();
    }


}

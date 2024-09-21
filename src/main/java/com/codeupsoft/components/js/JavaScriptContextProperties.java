package com.codeupsoft.components.js;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Context Properties
 *
 * @author dongdong.liu@codeupsoft.com
 */

@ConfigurationProperties(prefix = "code-up-soft.javascript.actuator")
class JavaScriptContextProperties {

    /**
     * 脚本资源控制， 限制访问主机资源
     */
    private Boolean allowAllAccess = false;

    public Boolean getAllowAllAccess() {
        return allowAllAccess;
    }

    public void setAllowAllAccess(Boolean allowAllAccess) {
        this.allowAllAccess = allowAllAccess;
    }
}

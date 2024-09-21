# JavaScript-Actuator-Starter

![Static Badge](https://img.shields.io/badge/version-0.0.1-brightgreen?style=flat)
![Static Badge](https://img.shields.io/badge/jdk-17-brightgreen?style=flat)
![Static Badge](https://img.shields.io/badge/SpringBoot-3.2.5-brightgreen?style=flat)
![Static Badge](https://img.shields.io/badge/graalvmJs-32.0.4-brightgreen?style=flat)
> Spring Boot JavaScript 执行器提供简单的Java执行JS封装


### Getting started
```xml
<dependency>
    <groupId>com.codeupsoft.components</groupId>
    <artifactId>javascript-actuator-starter</artifactId>
    <version>${latestVersion}</version>
</dependency>
```

### Properties
```properties
# 访问主机权限,默认false
code-up-soft.javascript.actuator.allow-all-access=false
```

### Demo
```java

@Component
public class SimpleDemo extends AbstractJavaScriptActuator<Integer, Void> {

    @Override
    protected Integer getScript(@Nonnull Void scriptCondition) {
        String script = "1 + 1";
        return execScript(script).asInt();
    }

}

@Component
public class SimpleFunctionDemo extends AbstractJavaScriptActuator<Integer, SimpleFunctionDemo.DemoCondition> {

    public record DemoCondition(String script, String functionName, Object... arguments){}
    
    
    @Override
    protected Integer getScript(@Nonnull SimpleFunctionDemo.DemoCondition scriptCondition) {
        
        Value value = execScript(scriptCondition.script, scriptCondition.functionName, scriptCondition.arguments);
        return value.asInt();
    }
    
    public void test(){
        System.out.println(getScript(new DemoCondition("function sum(a, b) { return a + b; }", sum, 1, 2)));
    }
    

}


```

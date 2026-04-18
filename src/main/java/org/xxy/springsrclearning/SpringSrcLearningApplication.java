package org.xxy.springsrclearning;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.xxy.springsrclearning.applicationeventpublishertraining.UserService;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
public class SpringSrcLearningApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringSrcLearningApplication.class, args);
        System.out.println(context);

//        int x = 10;
//
//        x = 100;
//        x = 1002;
//        x = 1040;
//        x = 1050;
//        x = 17800;

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);

        map.forEach((k, v) -> System.out.println(k + "========" + v));

        map.entrySet().stream().filter(e -> e.getKey().startsWith("test")).forEach(e -> System.out.println(e.getKey() + "*****======****" + e.getValue()));

        // 国际化
        // 系统默认语言 context.getMessage("hi", null, Locale.getDefault())， 无后缀配置文件仅做兜底
        System.out.println(context.getMessage("hi", null, null));

        System.out.println(context.getMessage("hi", null, Locale.CHINA));
        System.out.println(context.getMessage("hi", null, Locale.ENGLISH));
        System.out.println(context.getMessage("hi", null, Locale.JAPAN));

        // 资源文件
        System.out.println(context.getResource("classpath:messages.properties"));

        // 环境变量
        System.out.println(context.getEnvironment().getProperty("JAVA_HOME"));
        System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("spring.application.name"));

        Long userId = 1L;
        String userName = "xxy";
//        context.getBean("userservice").UserRegister(userId, userName);
        context.getBean(UserService.class).UserRegister(userId, userName);
        ((UserService) context.getBean("userService")).UserRegister(userId, userName);


    }

}

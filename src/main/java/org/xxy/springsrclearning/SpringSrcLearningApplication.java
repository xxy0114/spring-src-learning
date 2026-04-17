package org.xxy.springsrclearning;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
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



    }

}

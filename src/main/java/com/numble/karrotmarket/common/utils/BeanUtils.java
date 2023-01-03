package com.numble.karrotmarket.common.utils;

import com.numble.karrotmarket.common.component.jwt.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

public class BeanUtils {
    public static Object getBean(Class<?> clazz) {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        return applicationContext.getBean(clazz);
    }
}

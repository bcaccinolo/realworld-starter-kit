package org.qbeek.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BeanService {

    @Autowired
    private ApplicationContext applicationContext;

    public void listBeans() {
        System.out.println("🔥 List Application Context Beans");

        String[] beanList = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanList);

        for (String beanName : beanList) {
            System.out.println(beanName);
        }
    }
}

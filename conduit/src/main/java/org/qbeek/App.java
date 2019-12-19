package org.qbeek;

import org.qbeek.entites.Tag;

import org.qbeek.entites.TagRepository;
import org.qbeek.services.BeanService;
import org.qbeek.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App {

    @Autowired private TagService tagService;
    @Autowired private BeanService beanService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner dumpSomeCode() {
        return (args) -> {

            // list all the beans of the application context of the spring app
            //beanService.listBeans();

            // creates some tags
            tagService.createTags();

            // list all the saved tags
            ArrayList<Tag> tags = tagService.get();
            tags.forEach((t) -> {
                System.out.println(t.getName());
            });
        };
    }
}

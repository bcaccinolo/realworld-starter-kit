package org.qbeek;

import org.qbeek.services.ArticleService;
import org.qbeek.services.BeanService;
import org.qbeek.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class App {

    @Autowired private TagService tagService;
    @Autowired private BeanService beanService;
    @Autowired private ArticleService articleService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner dumpSomeCode() {
        return (args) -> {

            //beanService.listBeans();

            tagService.createSome();
            tagService.listAll();

            articleService.createSome();
            articleService.listAll();
        };
    }
}

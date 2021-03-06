package org.qbeek.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.qbeek.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class ArticleService {

    @Autowired private ArticleRepository articleRepository;
    @Autowired private ProfileRepository profileRepository;
    @Autowired private TagRepository tagRepository;

    /**
     * Fetch all Articles
     */
    public ArrayList<Article> get() {
        return (ArrayList<Article>) articleRepository.findAll();
    }

    /**
     * Load test articles from a json file
     */
    public void createSome() throws IOException {
        String fileName = "articles.json";
        URL fileUrl = getClass().getClassLoader().getResource(fileName);
        assert fileUrl != null;

        ObjectMapper jsonMapper = new ObjectMapper();
        Article[] articles = jsonMapper.readValue(fileUrl, Article[].class);

        Profile profile = profileRepository.findFirstByUsername("celeb_benoit");

        ArrayList<Tag> ttt = (ArrayList<Tag>) tagRepository.findAll();
        Tag t = ttt.get(0);
        System.out.println("the tag name is " + t.getName());

        // a nice way to iterate over arrays
        for (Article article : articles) {
            article.setAuthor(profile);
            article.getTagList().add(t);

            articleRepository.save(article);
        }
    }

    /**
     * Get json file content
     *
     * NOT USED - HERE FOR DOCUMENTATION
     */
    private String getJSonFileContent() throws URISyntaxException, IOException {
        String fileName = "articles.json";

        URL fileUrl = getClass().getClassLoader().getResource(fileName);
        assert fileUrl != null;
        URI uri = fileUrl.toURI();

        Path p = Paths.get(uri);
        byte[] content = Files.readAllBytes(p);
        return new String(content);
    }

    /**
     * List all saved ones
     */
    public void listAll() {
        ArrayList<Article> articles = this.get();
        articles.forEach((a) -> System.out.println(a.getTitle()));
    }
}

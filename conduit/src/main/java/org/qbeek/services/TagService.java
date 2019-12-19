package org.qbeek.services;

import org.qbeek.entites.Tag;
import org.qbeek.entites.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    public ArrayList<Tag> get() {
        return (ArrayList<Tag>) repository.findAll();
    }

    public void createTags() {
        Tag tag;
        String[] names = {"tag1", "tag2", "tag3", "tag5", "tag5"};

        for (String name : names) {
            tag = new Tag();
            tag.setName(name);
            repository.save(tag);
        }
    }

}

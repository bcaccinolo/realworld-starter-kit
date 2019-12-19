package org.qbeek.controller;

import lombok.Data;
import org.qbeek.entites.Tag;
import org.qbeek.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TagsController {

    @Autowired private TagService tagService;

    @GetMapping("tags")
    public TagsResponse all() {
        TagsResponse response = new TagsResponse();
        response.setTags(tagService.get());

        return response;
    }
}

@Data
class TagsResponse {
    private ArrayList<Tag> tags;
}

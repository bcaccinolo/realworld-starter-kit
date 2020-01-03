package org.qbeek.controller;

import lombok.Data;
import org.qbeek.entites.Profile;
import org.qbeek.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilesController {

    @Autowired private ProfileService profileService;

    @GetMapping("profiles/{username}")
    public ProfileResponse get(@PathVariable String username) {
        Profile profile = profileService.getByUsername(username);
        ProfileResponse response = new ProfileResponse();
        response.setProfile(profile);

        return response;
    }
}

@Data
class ProfileResponse {
    private Profile profile;
}
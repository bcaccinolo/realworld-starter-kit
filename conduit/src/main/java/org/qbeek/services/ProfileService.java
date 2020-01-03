package org.qbeek.services;

import com.github.javafaker.Faker;
import org.qbeek.entites.Profile;
import org.qbeek.entites.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    final Faker faker = new Faker();

    public Profile getByUsername(String username) {
        return repository.findFirstByUsername(username);
    }

    /**
     * Fetch all Profiles
     */
    public ArrayList<Profile> get() {
        return (ArrayList<Profile>) repository.findAll();
    }

    /**
     * Load test profiles from a json file
     */
    public void createSome() {
        createFakeOne("celeb_benoit");

        for (int i = 0; i < 10; i++) {
            createFakeOne();
        }
    }

    /**
     * Generate random Profile with Faker
     */
    private void createFakeOne() {
        createFakeOne(faker.name().username());
    }

    private void createFakeOne(String username) {
        Profile profile = new Profile();

        profile.setUsername(username);
        profile.setEmail(faker.internet().emailAddress());
        profile.setToken(faker.idNumber().valid());
        profile.setImage(faker.internet().avatar());
        profile.setBio(faker.lebowski().quote());
        profile.setFollowing(true);

        repository.save(profile);
    }

    /**
     * List all saved ones
     */
    public void listAll() {
        ArrayList<Profile> profiles = this.get();
        profiles.forEach(p -> System.out.println(p.getUsername()));
    }
}

package org.qbeek.entites;

import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Profile findFirstByUsername(String username);

}

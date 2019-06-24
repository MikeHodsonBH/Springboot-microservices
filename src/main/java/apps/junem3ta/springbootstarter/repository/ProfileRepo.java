package apps.junem3ta.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;

import apps.junem3ta.springbootstarter.profilemodel.Profile;

public interface ProfileRepo extends CrudRepository<Profile, Integer> {
	Profile findByEmail(String email);
}

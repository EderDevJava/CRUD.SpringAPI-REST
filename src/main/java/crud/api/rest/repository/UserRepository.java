package crud.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.api.rest.model.appUser;

@Repository
public interface UserRepository extends JpaRepository<appUser, Long>{

}

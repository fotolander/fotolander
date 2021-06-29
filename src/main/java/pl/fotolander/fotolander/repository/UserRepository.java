package pl.fotolander.fotolander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.fotolander.fotolander.entity.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    List<User> findAll();

    @Query("select u from User u where u.isRegistered = true")
    User  findRegisteredUser();



}

package pl.fotolander.fotolander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fotolander.fotolander.entity.Photo;

@Repository
public interface PhotoRepository extends JpaRepository <Photo, Long> {
}

package pl.fotolander.fotolander.repository;
import org.cloudinary.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fotolander.fotolander.entity.Place;
import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository <Place, Long> {
    List<Place> findByName(String name);
    List<Place> findByVoivodeship(String voivodeship);
}
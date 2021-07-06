package pl.fotolander.fotolander.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    @NotNull
    private String name;
    private String address;
    private String description;
    private double longitude;
    private double latitude;
    private String voivodeship;


    public Map<String, Object> getPropertiesAsMap() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("id", getId());
        properties.put("name", getName());
        properties.put("address", getAddress());
        properties.put("description", getDescription());
        properties.put("longitude", getLongitude());
        properties.put("latitude", getLatitude());
        properties.put("voivodeship", getVoivodeship());

        return properties;
    }
}

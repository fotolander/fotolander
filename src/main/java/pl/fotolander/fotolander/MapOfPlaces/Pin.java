package pl.fotolander.fotolander.MapOfPlaces;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Pin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double longitude; //dług
    private double latitude; //szer
    private String message;


}

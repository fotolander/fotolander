package pl.fotolander.fotolander.entity;
/**
 * nazwa
 * adres
 * lat / lon - współrzędne geograficzne
 * opis
 */

import lombok.*;

import javax.persistence.*;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;
    private String description;

    private double latitude;
    private double longitude;



}

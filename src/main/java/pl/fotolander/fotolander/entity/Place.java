package pl.fotolander.fotolander.entity;

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

    @Column(unique = true)
    private String name;
    private String address;
    private String description;
    private double latitude;
    private double longitude;

}

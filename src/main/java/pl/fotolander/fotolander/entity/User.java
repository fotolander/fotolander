package pl.fotolander.fotolander.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id//dane pole jest identyfikatorem unikalnym obiektu
    private long id;
    //generowanie identyfikatora automatycznie w momencie zapisu bazy danych
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String EmailAddress;
    private String password;
    private boolean isRegistered;

}

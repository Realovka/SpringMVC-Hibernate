package by.realovka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String login;
    private String password;

}



package tn.devops.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeureSup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    private double nb_heures;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employe employe;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tarif tarif;
}

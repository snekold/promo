package com.snekold.promo.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "prize")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameWinner;
    private String number;
    private String email;

    @Column(nullable = false)
    private boolean status = false;

    @Column(nullable = false)
    private String cod;

    @Column( nullable = false)
    private String namePrize;

    @Column
    private String imagePath;
}

package com.mapenda.architecture_netflix_uber.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MS")
public class MS {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @Column(name = "a")
    private String mincroentity1;

    @Column(name = "b")
    private String mincroentity2;

    @Column(name = "c")
    private String mincroentity3;


    @Column(name = "d")
    private String mincroentity4;
}

package com.finartz.firebase.springfirebaseproject.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "roles")
public class RolesEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;
}

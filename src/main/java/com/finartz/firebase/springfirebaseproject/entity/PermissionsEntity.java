package com.finartz.firebase.springfirebaseproject.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permissions")
public class PermissionsEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name = "permission_name")
    private String name;

}

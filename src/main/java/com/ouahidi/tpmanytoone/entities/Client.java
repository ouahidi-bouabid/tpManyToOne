package com.ouahidi.tpmanytoone.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder

public class Client {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdClient;
    private String nom;



}

package com.enigma.challengedatapenduduk.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "penduduk")
@Data
public class Penduduk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nik")
    private Long Nik;
    @Column(name = "nama",nullable = false)
    private String nama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "kota")
    private final String kota = "Jakarta Selatan";
    @ManyToOne
    private Kelurahan kelurahan;
}

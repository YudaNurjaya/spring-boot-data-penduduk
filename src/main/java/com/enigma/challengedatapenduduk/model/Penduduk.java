package com.enigma.challengedatapenduduk.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "penduduk")
@Data
public class Penduduk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nik",nullable = false,unique = true)
    private String nik;
    @Column(name = "nama",nullable = false)
    private String nama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "kota")
    private final String kota = "Jakarta Selatan";
    @Column(name = "tanggal_lahir")
    @Temporal(TemporalType.DATE)
    private LocalDate tanggalLahir;
    @ManyToOne
    private Kelurahan kelurahan;
}

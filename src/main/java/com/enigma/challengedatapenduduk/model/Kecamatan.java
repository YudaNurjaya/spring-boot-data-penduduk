package com.enigma.challengedatapenduduk.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "kecamatan")
@Data
public class Kecamatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_kecamatan",nullable = false, unique = true)
    private String namaKecamatan;
}

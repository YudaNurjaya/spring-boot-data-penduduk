package com.enigma.challengedatapenduduk.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "kelurahan")
@Data
public class Kelurahan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nama_kelurahan",nullable = false,unique = true)
    private String namaKelurahan;
    @Column(name = "kode_pos",nullable = false)
    private String kodePos;
    @ManyToOne
    @JoinColumn(name = "kecamatanId")
    private Kecamatan kecamatan;
}

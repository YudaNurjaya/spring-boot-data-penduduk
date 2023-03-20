package com.enigma.challengedatapenduduk.model.request;


import com.enigma.challengedatapenduduk.model.Kelurahan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

import java.util.Date;

@Data
public class PendudukRequest {
    @NotBlank(message = "Nik is required")
    @Pattern(regexp = "[0-9]{16,}")
    private String nik;
    @NotBlank(message = "nama is required")
    @Pattern(regexp = "[^0-9]+",message = "Minimum 2 character")
    private String nama;
    @NotBlank(message = "alamat is required")
    private String alamat;
    private Date tanggalLahir;
    private Kelurahan kelurahan;
}

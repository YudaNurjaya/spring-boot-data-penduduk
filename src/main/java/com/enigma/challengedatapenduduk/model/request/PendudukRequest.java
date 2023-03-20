package com.enigma.challengedatapenduduk.model.request;


import com.enigma.challengedatapenduduk.model.Kelurahan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PendudukRequest {
    @NotBlank(message = "nama is required")
    @Pattern(regexp = "^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)",message = "Minimum 2 character")
    private String nama;
    @NotBlank(message = "alamat is required")
    private String alamat;
    private Kelurahan kelurahan;
}

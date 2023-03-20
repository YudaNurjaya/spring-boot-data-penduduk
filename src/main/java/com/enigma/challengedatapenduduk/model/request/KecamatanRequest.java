package com.enigma.challengedatapenduduk.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class KecamatanRequest {
    @NotBlank(message = "Kecamatan is required")
    private String namaKecamatan;
}

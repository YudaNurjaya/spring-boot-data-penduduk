package com.enigma.challengedatapenduduk.model.request;

import com.enigma.challengedatapenduduk.model.Kecamatan;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class KelurahanRequest {
    @NotBlank(message = "Kelurahan is required")
    private String namaKelurahan;
    @NotBlank(message = "Kode Pos is required")
    private String kodePos;
    private Kecamatan kecamatan;
}

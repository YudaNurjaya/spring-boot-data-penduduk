package com.enigma.challengedatapenduduk.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class CommonResponse {
    private String status;
    private String message;
    private String code;

    public CommonResponse(String message) {
        this.message = message;
    }

    public CommonResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }
}

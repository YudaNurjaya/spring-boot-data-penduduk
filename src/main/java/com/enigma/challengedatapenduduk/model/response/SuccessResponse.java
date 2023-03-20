package com.enigma.challengedatapenduduk.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter @Getter
public class SuccessResponse<T> extends CommonResponse {
    private T data;
    public SuccessResponse(String message, T data){
        super(message);
        super.setCode("200");
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

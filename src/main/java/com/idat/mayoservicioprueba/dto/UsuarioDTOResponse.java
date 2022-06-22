package com.idat.mayoservicioprueba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*2*/
@Getter
@Setter
/*@AllArgsConstructor*//*se recibe y se devuelve datos*/
public class UsuarioDTOResponse {
    private String token;

    public UsuarioDTOResponse() {
        super();
    }

    public UsuarioDTOResponse(String token) {
        super();
        this.token = token;
    }
}

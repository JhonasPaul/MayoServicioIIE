package com.idat.mayoservicioprueba.controller;

import com.idat.mayoservicioprueba.dto.UsuarioDTOResponse;
import com.idat.mayoservicioprueba.dto.UsuarioDTOResquest;
import com.idat.mayoservicioprueba.security.JWTUtil;
import com.idat.mayoservicioprueba.security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*3*/
@RestController
//@RequestMapping( "")
public class UsuarioController {
    /*9*/
    @Autowired
    private JWTUtil util;
    @Autowired
    private UserDetailService service;
    /*---------------------------------------------*/

    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
    public ResponseEntity<?> crearToken(@RequestBody UsuarioDTOResquest resquest) {
        UserDetails user = service.loadUserByUsername(resquest.getUsuario());
        return  ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
    }
}

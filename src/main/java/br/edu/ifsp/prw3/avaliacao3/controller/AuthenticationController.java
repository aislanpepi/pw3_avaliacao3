package br.edu.ifsp.prw3.avaliacao3.controller;

import br.edu.ifsp.prw3.avaliacao3.dto.AuthenticationDTO;
import br.edu.ifsp.prw3.avaliacao3.dto.JWTTokenDTO;
import br.edu.ifsp.prw3.avaliacao3.model.UserMechanic;
import br.edu.ifsp.prw3.avaliacao3.util.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity toLogin(@RequestBody @Valid AuthenticationDTO data){

        var token = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.generateToken((UserMechanic) authentication.getPrincipal());

        return ResponseEntity.ok(new JWTTokenDTO(tokenJWT));
    }
}

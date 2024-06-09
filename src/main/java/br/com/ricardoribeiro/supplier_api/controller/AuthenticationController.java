package br.com.ricardoribeiro.supplier_api.controller;

import br.com.ricardoribeiro.supplier_api.domain.User;
import br.com.ricardoribeiro.supplier_api.dto.DataAuthentication;
import br.com.ricardoribeiro.supplier_api.dto.DataToken;
import br.com.ricardoribeiro.supplier_api.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DataAuthentication dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        Authentication authenticate = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((User) authenticate.getPrincipal());
        return ResponseEntity.ok(new DataToken(tokenJWT, ((User) authenticate.getPrincipal()).getName()));
    }


}

package br.com.pizzaria.controller;

import br.com.pizzaria.domain.dto.DadosAutenticacao;
import br.com.pizzaria.domain.entity.Usuario;
import br.com.pizzaria.infra.security.DadosTokenJWT;
import br.com.pizzaria.infra.security.TokenService;
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
@RequestMapping("login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao){

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
            Authentication authenticate = manager.authenticate(authenticationToken);
            var token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(token));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}

package com.app.urna.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.urna.entity.Apuracao;
import com.app.urna.entity.Voto;
import com.app.urna.service.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoController {
    @Autowired
    private VotoService votoService;

    @PostMapping("/votar/{id}")
    public ResponseEntity<?> votar(@PathVariable Long id, @RequestBody Voto voto) {
        try {
            String hash = this.votoService.votar(id, voto);
            return new ResponseEntity<>(hash, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/realizarApuracao")
    public ResponseEntity<?> realizarApuracao() {
        try {
            Apuracao apuracao = this.votoService.realizarApuracao();
            return new ResponseEntity<>(apuracao, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

package com.app.urna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.urna.entity.Eleitor;
import com.app.urna.service.EleitorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eleitores")
public class EleitorController {

	@Autowired
    private EleitorService eleitorService;

    @PostMapping
    public ResponseEntity<Eleitor> criarEleitor(@Valid @RequestBody Eleitor eleitor) {
        Eleitor criado = eleitorService.salvar(eleitor);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Eleitor>> obterTodosEleitores() {
        List<Eleitor> eleitores = eleitorService.listarAtivos();
        return new ResponseEntity<>(eleitores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleitor> obterEleitor(@PathVariable Long id) {
        Optional<Eleitor> eleitor = eleitorService.buscarPorId(id);
        if (eleitor.isPresent()) {
            return new ResponseEntity<>(eleitor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEleitor(@PathVariable Long id) {
        try {
            eleitorService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
}

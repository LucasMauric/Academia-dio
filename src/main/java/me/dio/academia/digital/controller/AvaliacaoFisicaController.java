package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
    @Autowired
    AvaliacaoServiceImpl avaliacaoService;
    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@RequestBody AvaliacaoFisicaForm form){
        return ResponseEntity.ok().body(avaliacaoService.create(form));
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<AvaliacaoFisica> get(@PathVariable Long id){
        return ResponseEntity.ok().body(avaliacaoService.get(id));
    }
    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAll(){
        return ResponseEntity.ok().body(avaliacaoService.getAll());
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@RequestBody AvaliacaoFisicaUpdateForm form, @PathVariable Long id){
       return ResponseEntity.ok().body(avaliacaoService.update(id,form));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        avaliacaoService.delete(id);
        return ResponseEntity.ok().build();
    }

}

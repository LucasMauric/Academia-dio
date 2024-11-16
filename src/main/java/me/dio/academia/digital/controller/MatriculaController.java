package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.aspectj.weaver.ast.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    MatriculaServiceImpl matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> create(@Valid @RequestBody MatriculaForm form){
        return ResponseEntity.ok().body(matriculaService.create(form));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Matricula> get(@PathVariable Long id){
        return ResponseEntity.ok().body(matriculaService.get(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Matricula>> getAll(@RequestParam(value = "bairro", required = false)
                                                      String bairro){
        return ResponseEntity.ok().body( matriculaService.getAll(bairro));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        matriculaService.delete(id);
        return ResponseEntity.ok().build();
    }

}

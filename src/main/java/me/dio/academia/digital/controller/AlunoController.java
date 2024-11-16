package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;
    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok().body(alunoService.getAll());
    }
    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm form){
        return ResponseEntity.ok().body(alunoService.create(form));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@RequestBody AlunoUpdateForm alunoUpdateForm, @PathVariable Long id){
        alunoService.update(id,alunoUpdateForm);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<Aluno>> findAll(@RequestParam (value = "dataDeNascimento", required = false)
                                                   String dataDeNascimento){
            return ResponseEntity.ok().body(alunoService.findAll(dataDeNascimento));
    }
}
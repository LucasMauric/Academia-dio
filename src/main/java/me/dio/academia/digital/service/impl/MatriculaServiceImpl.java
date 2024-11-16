package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MatriculaServiceImpl implements IMatriculaService {
    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
        Matricula matricula = new Matricula();
        aluno.ifPresent(aluno1 -> {
            matricula.setAluno(aluno1);
            matriculaRepository.save(matricula);
        });
        return matricula;
    }

    @Override
    public Matricula get(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);
        return matricula.orElse(null);
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
             return  matriculaRepository.findByAlunoBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Matricula> remove = matriculaRepository.findById(id);
        remove.ifPresent(r ->{
            matriculaRepository.delete(r);
        });
    }
}

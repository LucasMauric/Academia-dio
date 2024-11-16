package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements IAlunoService {
    @Autowired
    AlunoRepository alunoRepository;
    @Override
    public Aluno create(AlunoForm form) {

        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        aluno.setBairro(form.getBairro());
        alunoRepository.save(aluno);
        return aluno;
    }

    @Override
    public Aluno get(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    @Override
    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        aluno.ifPresent(a -> {
            a.setBairro(formUpdate.getBairro());
            a.setDataDeNascimento(formUpdate.getDataDeNascimento());
            a.setNome(formUpdate.getNome());
        });
        return alunoRepository.save(aluno.get());

    }

    @Override
    public void delete(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        aluno.ifPresent(value -> alunoRepository.delete(value));
    }

    @Override
    public List<Aluno> findAll(String dataDeNascimento) {
        if(dataDeNascimento == null){
            return alunoRepository.findAll();
        }
        else{
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(localDate);
        }
    }
}
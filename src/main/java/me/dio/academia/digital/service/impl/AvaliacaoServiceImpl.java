package me.dio.academia.digital.service.impl;


import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoServiceImpl implements IAvaliacaoFisicaService {
    @Autowired
    AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        Optional<Aluno> aluno = alunoRepository.findById(form.getAlunoId());
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        aluno.ifPresent( aluno1 ->{
            avaliacaoFisica.setAltura(form.getAltura());
            avaliacaoFisica.setPeso(form.getPeso());
            avaliacaoFisica.setAluno(aluno1);
            avaliacaoFisicaRepository.save(avaliacaoFisica);
        } );
        return avaliacaoFisica;
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        Optional<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findById(id);
        return avaliacaoFisica.orElse(null);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        Optional<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findById(id);
        avaliacaoFisica.ifPresent(avaliacao ->{
            avaliacao.setPeso(formUpdate.getPeso());
            avaliacao.setAltura(formUpdate.getAltura());
        });
        return avaliacaoFisica.orElse(null);
    }

    @Override
    public void delete(Long id) {
        Optional<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findById(id);
        avaliacaoFisica.ifPresent(avaliacao -> {
            avaliacaoFisicaRepository.deleteById(avaliacao.getId());
        });
    }
}

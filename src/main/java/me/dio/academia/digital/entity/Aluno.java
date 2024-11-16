package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  @Column(unique = true)
  private String cpf;
  private String bairro;
  private LocalDate dataDeNascimento;
  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)//fetch = FetchType.LAZY ignora as informações da lista de avaliação fisica
  @JsonIgnore//tratando excepltions do json
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}

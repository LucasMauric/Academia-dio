package me.dio.academia.digital.entity.form;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaForm {
  @NotEmpty(message = "Preencha o campo corretamente.")
  private Long alunoId;
  @NotEmpty(message = "Preencha o campo corretamente.")
  @Positive(message = "'${validateValue}' precisa ser positivo.")
  private double peso;
  @NotEmpty(message = "Preencha o campo corretamente.")
  @Positive(message = "'${validateValue}' precisa ser positivo.")
  private double altura;

}

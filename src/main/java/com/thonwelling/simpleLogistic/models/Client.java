package com.thonwelling.simpleLogistic.models;

import com.thonwelling.simpleLogistic.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
public class Client {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull(groups = ValidationGroups.ClientId.class)
  private Long id;

  @NotEmpty(message = "O Campo Name Não Pode Ser Vazio.")
  @NotBlank(message = "Preencha o Campo Nome")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String name;

  @NotBlank(message = "Preencha o Campo Email")
  @Size(max = 80)
  @Email(message = "Utilize um Email Válido")
  private String email;

  @NotBlank(message = "Preencha o Campo  Telefone")
  @Size(min = 7, max = 18, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  @Column(name = "phone")
  private String phoneNumber;
}
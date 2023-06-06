package com.thonwelling.simpleLogistic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
  private Long id;

  @NotEmpty(message = "O Campo Name Não Pode Ser Vazio.")
  @NotBlank
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String name;

  @NotBlank
  @Size(max = 80)
  @Email
  private String email;

  @NotBlank
  @Size(max = 18)
  @Column(name = "phone")
  private String phoneNumber;
}
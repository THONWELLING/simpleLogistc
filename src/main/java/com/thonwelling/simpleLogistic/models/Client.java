package com.thonwelling.simpleLogistic.models;

import jakarta.persistence.*;
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
  private String name;
  private String email;
  @Column(name = "phone")
  private String phoneNumber;
}

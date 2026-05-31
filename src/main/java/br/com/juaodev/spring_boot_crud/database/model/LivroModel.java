package br.com.juaodev.spring_boot_crud.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LivroModel {

    private Integer id;
    private String name;
    private Integer quantidade;
    private BigDecimal preco;
}

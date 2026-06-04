package br.com.juaodev.spring_boot_crud.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class LivroDto {

    private String name;
    private Integer quantidade;
    private BigDecimal preco;
}

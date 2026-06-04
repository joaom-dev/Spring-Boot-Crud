package br.com.juaodev.spring_boot_crud.service;

import br.com.juaodev.spring_boot_crud.database.model.LivroModel;
import br.com.juaodev.spring_boot_crud.dto.LivroDto;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
//array mais poderoso
import java.util.ArrayList;
import java.util.List;

@Service
@Builder

public class BibliotecaService {
    //Mock de um banco de dados so para mostrar
    private static final List<LivroModel> LIVROS = new ArrayList();

    static {
        LIVROS.add(
                LivroModel.builder()
                        .id(1)
                        .name("Codigo Limpo")
                        .quantidade(22)
                        .preco(new BigDecimal("57.90"))
                        .build()
        );

        LIVROS.add(
                LivroModel.builder()
                        .id(2)
                        .name("Arquitetura De Computadores")
                        .quantidade(49)
                        .preco(new BigDecimal("21.90"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(3)
                        .name("Mestre Guardiao")
                        .quantidade(3)
                        .preco(new BigDecimal("90.90"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(4)
                        .name("Java Para Todos")
                        .quantidade(84)
                        .preco(new BigDecimal("107.80"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(5)
                        .name("Spring Boot na Prática")
                        .quantidade(30)
                        .preco(new BigDecimal("89.90"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(6)
                        .name("Logicamente Logico")
                        .quantidade(50)
                        .preco(new BigDecimal("120.00"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(7)
                        .name("Estruturas de Dados em Java")
                        .quantidade(40)
                        .preco(new BigDecimal("75.50"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(8)
                        .name("Algoritmos Descomplicados")
                        .quantidade(25)
                        .preco(new BigDecimal("65.00"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(9)
                        .name("Java Avançado")
                        .quantidade(60)
                        .preco(new BigDecimal("150.00"))
                        .build());

        LIVROS.add(
                LivroModel.builder()
                        .id(10)
                        .name("Programação Orientada a Objetos")
                        .quantidade(35)
                        .preco(new BigDecimal("95.90"))
                        .build());

    }

    //metodo para mostrar todos os produtos do banco
    public List<LivroModel> findAll() {
        return new ArrayList<>(LIVROS);
    }

    //metodo para mostrar os livros so por ID
    public LivroModel buscarPorId(Integer id) {
        //stream serve para percorrer a lista e achar um valor especifico
        return LIVROS.stream()
                .filter(livro -> livro.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //metodo para mostrar os livros pelo nome
    public LivroModel buscarPorName(String name) {
        return LIVROS.stream()
                .filter(livro -> livro.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    //metodo de criacao do Post para criar um novo livro
    public LivroModel postLivro(LivroDto LivroDto) {
        Integer ids = LIVROS.stream()
                .mapToInt(LivroModel::getId)
                .max()
                .orElse(0) + 1;

        LivroModel postLivro = LivroModel.builder()
                .id(ids)
                .name(LivroDto.getName())
                .quantidade(LivroDto.getQuantidade())
                .preco(LivroDto.getPreco())
                .build();

        LIVROS.add(postLivro);
        return (postLivro);
    }

    public LivroModel attLivro(LivroDto livroDto, Integer id) {
        LivroModel livro = LIVROS.stream()
                .filter(livros -> livros.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("produto nao encontrado no nosso banco de dados"));

        livro.setName(livroDto.getName());
        livro.setPreco(livroDto.getPreco());
        livro.setQuantidade(livroDto.getQuantidade());


        return livro;
    }

    public void deleteLivro(Integer id) {
        LIVROS.removeIf(livros -> livros.getId().equals(id));
    }


}

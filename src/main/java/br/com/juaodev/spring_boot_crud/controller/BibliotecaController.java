package br.com.juaodev.spring_boot_crud.controller;

import br.com.juaodev.spring_boot_crud.database.model.LivroModel;
import br.com.juaodev.spring_boot_crud.service.BibliotecaService;
import io.micrometer.common.KeyValues;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//injecao de dependencia do service
@RequiredArgsConstructor
@RequestMapping("/br/biblioteca")
@Getter
@Setter

public class BibliotecaController {

    //injecao de dependencia do service
    private final BibliotecaService bibliotecaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LivroModel> findAll(){
        return bibliotecaService.findAll();
    }

    //buscar livro pelo id
    @GetMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroModel get (@PathVariable Integer id) {
        return bibliotecaService.buscarPorId(id);
    }

    //buscar livro pelo nome
    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public LivroModel get(@PathVariable String name) {
        return bibliotecaService.buscarPorName(name);
    }

}

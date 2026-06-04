package br.com.juaodev.spring_boot_crud.controller;

import br.com.juaodev.spring_boot_crud.database.model.LivroModel;
import br.com.juaodev.spring_boot_crud.dto.LivroDto;
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

    //endpoint buscar livro pelo id
    @GetMapping(value = "/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroModel get (@PathVariable Integer id) {
        return bibliotecaService.buscarPorId(id);
    }

    //endpoint buscar livro pelo nome
    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public LivroModel get(@PathVariable String name) {
        return bibliotecaService.buscarPorName(name);
    }

    //endpoint para criar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel postLivro(@RequestBody LivroDto LivroDto) {
        return bibliotecaService.postLivro(LivroDto);
    }

    //endpoint para atualizar
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LivroModel putLivro(@PathVariable Integer id,
                                   @RequestBody LivroDto LivroDto) {
        return bibliotecaService.attLivro(LivroDto, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@PathVariable Integer id) {
         bibliotecaService.deleteLivro(id);
    }
}

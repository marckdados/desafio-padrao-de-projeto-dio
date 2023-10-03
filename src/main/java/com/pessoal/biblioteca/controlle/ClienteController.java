package com.pessoal.biblioteca.controlle;

import com.pessoal.biblioteca.model.Cliente;
import com.pessoal.biblioteca.service.ClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente){
        clienteService.adicionar(cliente);
        return ResponseEntity.ok(cliente);
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathParam("id") Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PutMapping(value = "/{id}")
    public HttpStatus atualizar(@PathParam("id") Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "/{id}")
    public  HttpStatus deletar(@PathParam("id") Long id){
        clienteService.deletar(id);
        return HttpStatus.OK;
    }

    @PostMapping(value = "/{id}")
    public HttpStatus adicionarLivrosCliente(@PathParam("id") Long id, @RequestBody String livro){
        clienteService.adicionarLivrosCliente(id,livro);
        return HttpStatus.OK;
    }
}

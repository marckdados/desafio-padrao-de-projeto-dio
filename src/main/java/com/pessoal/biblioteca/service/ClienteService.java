package com.pessoal.biblioteca.service;

import com.pessoal.biblioteca.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void adicionar(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
    void adicionarLivrosCliente(Long id, String livro);
}

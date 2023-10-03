package com.pessoal.biblioteca.service.impl;

import com.pessoal.biblioteca.model.Cliente;
import com.pessoal.biblioteca.repository.ClienteRepository;
import com.pessoal.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            return cliente;
        }
        System.out.println("Cliente não encontrado !");
       return null;
    }

    @Override
    public void adicionar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteAtualizado.getNome());
            clienteRepository.save(cliente);
        }
        System.out.println("Cliente não encontrado !");
    }

    @Override
    public void deletar(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            clienteRepository.delete(cliente);
        }
        System.out.println("Cliente não encontrado !");
    }

    @Override
    public void adicionarLivrosCliente(Long id, String livro) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            List<String> lista = cliente.getLivros();
            lista.add(livro);
            cliente.setLivros(lista);
            clienteRepository.save(cliente);
            return;
        }
        System.out.println("Cliente não encontrado !");
    }


}

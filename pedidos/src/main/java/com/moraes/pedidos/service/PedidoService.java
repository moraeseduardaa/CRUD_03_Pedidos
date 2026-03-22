package com.moraes.pedidos.service;

import com.moraes.pedidos.model.PedidoModel;
import com.moraes.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criarPedido(PedidoModel pedidoModel){
        return pedidoRepository.save(pedidoModel);
    }

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> buscarPedidos(Long id){
        return pedidoRepository.findById(id);
    }

    public void deletarPedidos(Long id){
        pedidoRepository.deleteById(id);
    }

}

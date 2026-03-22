package com.moraes.pedidos.controller;

import com.moraes.pedidos.model.PedidoModel;
import com.moraes.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoModel pedidoModel){
        return pedidoService.criarPedido(pedidoModel);
    }

    @GetMapping
    public List<PedidoModel> listarPedidos(){
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> buscarPedidos(@PathVariable  Long id){
        return pedidoService.buscarPedidos(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPedidos(@PathVariable Long id){
        pedidoService.deletarPedidos(id);
    }

}


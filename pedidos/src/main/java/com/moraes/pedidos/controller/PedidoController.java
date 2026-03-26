package com.moraes.pedidos.controller;

import com.moraes.pedidos.model.PedidoModel;
import com.moraes.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){

        PedidoModel request = pedidoService.criarPedido(pedidoModel);

        URI uri = URI.create("/pedidos/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> request = pedidoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> buscarPedidos(@PathVariable  Long id){
        return pedidoService.buscarPedidos(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedidos(@PathVariable Long id){
        pedidoService.deletarPedidos(id);
        return ResponseEntity.noContent().build();
    }
}


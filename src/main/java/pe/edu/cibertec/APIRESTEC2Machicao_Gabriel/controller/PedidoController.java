package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoCabecera;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoCabecera> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public PedidoCabecera getPedidoById(@PathVariable Integer id) {
        return pedidoService.getPedidoById(id);
    }

    @PostMapping
    public PedidoCabecera createPedido(@RequestBody PedidoCabecera pedidoCabecera) {
        return pedidoService.createPedido(pedidoCabecera);
    }

    @PutMapping("/{id}")
    public PedidoCabecera updatePedido(@PathVariable Integer id, @RequestBody PedidoCabecera pedidoCabecera) {
        return pedidoService.updatePedido(id, pedidoCabecera);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Integer id) {
        pedidoService.deletePedido(id);
    }
}

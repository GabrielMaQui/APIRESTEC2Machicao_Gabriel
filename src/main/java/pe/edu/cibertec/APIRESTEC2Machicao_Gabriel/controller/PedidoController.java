package pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoCabecera;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.model.bd.PedidoDetalle;
import pe.edu.cibertec.APIRESTEC2Machicao_Gabriel.service.PedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoCabecera> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoCabecera> obtenerPedidoPorId(@PathVariable Integer id) {
        Optional<PedidoCabecera> pedido = pedidoService.obtenerPedidoPorId(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PedidoCabecera guardarPedido(@RequestBody PedidoCabecera pedidoCabecera) {
        return pedidoService.guardarPedido(pedidoCabecera);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{pedidoId}/detalles")
    public List<PedidoDetalle> obtenerDetallesPorPedidoId(@PathVariable Integer pedidoId) {
        return pedidoService.obtenerDetallesPorPedidoId(pedidoId);
    }
}

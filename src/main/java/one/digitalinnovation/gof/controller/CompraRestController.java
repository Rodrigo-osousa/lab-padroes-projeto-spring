package one.digitalinnovation.gof.controller;

import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.gof.model.Compra;
import one.digitalinnovation.gof.model.DadosCompra;
import one.digitalinnovation.gof.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("compras")
public class CompraRestController {

    @Autowired
    private CompraService compraService;


    @PostMapping
    @ApiOperation(value = "Realiza Compras")
    public ResponseEntity<DadosCompra> comprar(@RequestBody Compra compra) throws Exception {
        DadosCompra dadosCompra = compraService.comprarProduto(compra);
        return ResponseEntity.ok(dadosCompra);
    }

    @GetMapping
    @ApiOperation(value = "Buscar todas as Compras")
    public ResponseEntity<Iterable<DadosCompra>> buscarTodos() {
        return ResponseEntity.ok((compraService.buscarTodos()));
    }

}

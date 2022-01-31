package one.digitalinnovation.gof.controller;

import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @ApiOperation(value = "Buscar todos os Clientes")
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok((clienteService.buscarTodos()));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar Cliente por ID")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    @ApiOperation(value = "Inserir Cliente")
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Editar dados do Cliente")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar Cliente")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

package one.digitalinnovation.gof.controller;


import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @ApiOperation(value = "Buscar todos os Produtos cadastrados")
    public ResponseEntity<Iterable<Produto>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca Produtos por ID")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PostMapping
    @ApiOperation(value = "Insere novo Produto")
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
        produtoService.inserir(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza Produto o buscando por ID")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produtoService.atualizar(id, produto);
        return ResponseEntity.ok(produto);

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um Produto através do ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}

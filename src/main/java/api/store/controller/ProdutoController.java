package api.store.controller;

import api.store.dto.ProdutoDto;
import api.store.service.ProdutoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public Page<ProdutoDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return produtoService.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> detalhar(@PathVariable @NotNull Long id){
        ProdutoDto produtoDto = produtoService.obterPorId(id);
        return ResponseEntity.ok(produtoDto);

    }

    @PostMapping
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody ProdutoDto produtoDto) {
        ProdutoDto product = produtoService.criarProduto(produtoDto);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody  ProdutoDto produtoDto) {
        ProdutoDto produto = produtoService.atualizarProduto(id, produtoDto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDto> remover(@PathVariable @NotNull Long id){
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }

}

package api.store.service;


import api.store.dto.ProdutoDto;
import api.store.model.Produto;
import api.store.respository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<ProdutoDto> obterTodos(Pageable paginacao){
        return produtoRepository.findAll(paginacao).map(p -> modelMapper.map(p, ProdutoDto.class));
    }

    public ProdutoDto obterPorId(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(produto, ProdutoDto.class);
    }

    public  ProdutoDto criarProduto(ProdutoDto ProdutoDto){
        Produto Produto = modelMapper.map(ProdutoDto, Produto.class);
        produtoRepository.save(Produto);
        return modelMapper.map(Produto, ProdutoDto.class);
    }

    public ProdutoDto atualizarProduto(Long id, ProdutoDto produtoDto){
        Produto produto = modelMapper.map(produtoDto, Produto.class);
        produto.setId(id);
        produto.setCategoria(produtoDto.getCategoria());
        produto = produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoDto.class);
    }

    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }
    

}

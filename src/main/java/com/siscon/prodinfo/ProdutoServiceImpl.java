package com.siscon.prodinfo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //informa que essa classe é um serviço
public class ProdutoServiceImpl implements ProdutoService{

    //declaração da variável e inserção da anotação @Autowired
    @Autowired
    private ProdutoRepository produtoRepository;

    //construtor
    public ProdutoServiceImpl(ProdutoRepository produtoRepository){
        super();
        this.produtoRepository = produtoRepository;
    }

    //IMPLEMENTAÇÕES
    @Override
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public List<Produto> listaProd() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto listaOneProd(Long codigo) {
        return produtoRepository.findById(codigo).get();
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void excluirProdutoById(Long codigo) {
        produtoRepository.deleteById(codigo);
    }
}

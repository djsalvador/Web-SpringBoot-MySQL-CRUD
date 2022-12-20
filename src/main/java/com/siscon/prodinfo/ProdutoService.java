package com.siscon.prodinfo;

import java.util.List;

public interface ProdutoService {

    //salva objeto (produtos)
    Produto salvarProduto(Produto produto);
    
    //retorna lista de objetos (produtos)
    List<Produto> listaProd();

    //retorna objeto produto pelo id (codigo)
    Produto listaOneProd(Long codigo);

    //atualiza dados do objeto produto
    Produto atualizarProduto(Produto produto);

    //exclui objeto produto pela id (codigo)
    void excluirProdutoById(Long codigo);
}
package com.siscon.prodinfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Anotações Spring definem a configuração
@Controller 
@RequestMapping("/")
public class ProdutoController {
    
    //declaração de variável
    private ProdutoService produtoService;

    //construtor
    public ProdutoController(ProdutoService produtoService){
        super();
        this.produtoService = produtoService;
    }

// MAPEAMENTO DAS PÁGINAS
    // Mapeamento do index.html (Chama a página HTML com a tabela total)
    @RequestMapping(value = "/")
    public String listaProdutos(Model model){
        model.addAttribute("produto", produtoService.listaProd());
        return "index";
    }

    //Mapeamento do login.html (Chama a página HTML)
    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("/login");
    }

    //Mapeamento do admin.html (Chama a página HTML e lista todos os produtos)
    @GetMapping("/admin")
    private String listaProd(Model model){
        model.addAttribute("produto", produtoService.listaProd());
        return "admin";
    }

    //Mapeamento do adminOne.html (Chama a página HTML e lista um produto)
    @GetMapping("/produtos/busca/{codigo}")
    public String buscarProduto(@PathVariable Long codigo, Model model) {
        model.addAttribute("produto", produtoService.listaOneProd(codigo));
        return "adminOne";
    }

    // Mapeamento do cadastrar.html (puxa a página)
    @GetMapping("/produtos/cadastro")
    public String cadastrarProduto(Model model){
        Produto produto = new Produto();
        model.addAttribute("produto", produto);
        return "cadastrar";
    }
    
    // Mapeamento do cadastrar.html (salva no BD e retorna pra tabela)
    @PostMapping("/produtos")
    public String salvarProduto(@ModelAttribute("produto") Produto produto){
        produtoService.salvarProduto(produto);
        return "redirect:/admin";
    }

    // Mapeamento do editar.html (Chama a página HTML)
    @GetMapping("/produtos/editar/{codigo}")
    public String editarProduto(@PathVariable Long codigo, Model model) {
        model.addAttribute("produto", produtoService.listaOneProd(codigo));
        return "editar";
    }
    
    // Mapeamento do editar.html (salva no BD e retorna pra tabela)
    @PostMapping("produtos/{codigo}")
    public String atualizarProduto(@PathVariable Long codigo, @ModelAttribute("produto") Produto produto, Model model) {
        Produto existenciaDeProduto = produtoService.listaOneProd(codigo);
        existenciaDeProduto.setCodigo(codigo);
        existenciaDeProduto.setNomeProd(produto.getNomeProd());
        existenciaDeProduto.setMarcaProd(produto.getMarcaProd());
        existenciaDeProduto.setDescricaoProd(produto.getDescricaoProd());
        existenciaDeProduto.setValorProd(produto.getValorProd());
        produtoService.atualizarProduto(existenciaDeProduto);
        return "redirect:/admin";
    }

    // Mapeamento do botão excluir (exclui a linha no BD e retorna pra tabela)
    @GetMapping("/produtos/excluir/{codigo}")
    public String excluirProduto(@PathVariable Long codigo){
        produtoService.excluirProdutoById(codigo);
        return "redirect:/admin";
    }


// MAPEAMENTO DOS PRODUTOS
    //Mapeamento do monitorgamerlg.html (Chama a página HTML)
    @RequestMapping(value = "/monitorgamerlg")
    public ModelAndView monitorgamerlg(){
        return new ModelAndView("/monitorgamerlg");
    }

    //Mapeamento do headsetgamersennheiser.html (Chama a página HTML)
    @RequestMapping(value = "/headsetgamersennheiser")
    public ModelAndView headsetgamersennheiser(){
        return new ModelAndView("/headsetgamersennheiser");
    }
}

package com.checkpoint.livestock.controller;

import com.checkpoint.livestock.dto.request.ProdutoRequest;
import com.checkpoint.livestock.model.Categoria;
import com.checkpoint.livestock.service.ArmazemService;
import com.checkpoint.livestock.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ArmazemService armazemService;

    public ProdutoController(ProdutoService produtoService, ArmazemService armazemService) {
        this.produtoService = produtoService;
        this.armazemService = armazemService;
    }

    @GetMapping("/cadastrar")
    public ModelAndView formularioCadastro() {
        ModelAndView mv = new ModelAndView("cadastroProduto");
        mv.addObject("produtoRequest", new ProdutoRequest());
        mv.addObject("categorias", Categoria.values());
        mv.addObject("armazens", armazemService.listarArmazens()); // lista para o select suspenso
        return mv;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrarProduto(@ModelAttribute ProdutoRequest produtoRequest) {
        produtoService.cadastrarProduto(produtoRequest);
        return new ModelAndView("redirect:/produto/lista");
    }

    @GetMapping("/lista")
    public ModelAndView listaProdutos() {
        ModelAndView mv = new ModelAndView("listaProdutos");
        mv.addObject("produtos", produtoService.listarProdutos());
        System.out.println("Produtos retornados: " + produtoService.listarProdutos()); //DEBUG
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return new ModelAndView("redirect:/produto/lista");
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editarProduto");
        mv.addObject("produtoRequest", produtoService.buscarPorId(id)); // método opcional se quiser popular para edição
        mv.addObject("categorias", Categoria.values());
        mv.addObject("armazens", armazemService.listarArmazens());
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public ModelAndView atualizarProduto(@PathVariable Long id, @ModelAttribute ProdutoRequest produtoRequest) {
        produtoService.atualizarProduto(id, produtoRequest);
        return new ModelAndView("redirect:/produto/lista");
    }
}

package com.checkpoint.livestock.controller;

import com.checkpoint.livestock.dto.request.ArmazemRequest;
import com.checkpoint.livestock.dto.response.ArmazemResponse;
import com.checkpoint.livestock.service.ArmazemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/armazem")
public class ArmazemController {

    private final ArmazemService armazemService;

    public ArmazemController(ArmazemService armazemService) {
        this.armazemService = armazemService;
    }

    @GetMapping("/cadastrar")
    public ModelAndView exibirFormularioCadastro() {
        ModelAndView mv = new ModelAndView("cadastroArmazem");
        mv.addObject("armazemRequest", new ArmazemRequest());
        return mv;
    }


    @PostMapping("/cadastrar")
    public ModelAndView cadastrarArmazem(@ModelAttribute ArmazemRequest armazemRequest) {
        armazemService.cadastrarArmazem(armazemRequest);
        return new ModelAndView("redirect:/armazem/lista");
    }


    @GetMapping("/lista")
    public ModelAndView listarArmazens() {
        ModelAndView mv = new ModelAndView("listaArmazens");
        mv.addObject("armazens", armazemService.listarArmazens());
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public ModelAndView deletarArmazem(@PathVariable Long id) {
        armazemService.deletarArmazem(id);
        return new ModelAndView("redirect:/armazem/lista");
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView exibirFormularioEdicao(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("editarArmazem");
        ArmazemResponse armazemResponse = armazemService.buscarPorId(id);
        mv.addObject("armazemRequest", armazemResponse);
        return mv;
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarArmazem(@PathVariable Long id, @ModelAttribute ArmazemRequest armazemRequest) {
        armazemService.atualizarArmazem(id, armazemRequest);
        return "redirect:/armazem/lista";
    }

}

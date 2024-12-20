package pe.edu.cibertec.Proyecto_BonaVenture_Bazar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.dto.ArticuloDto;
import pe.edu.cibertec.Proyecto_BonaVenture_Bazar.service.ManageService;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class ArticuloController {
    @Autowired
    private ManageService manageService;

    @GetMapping("/start")
    public String start(Model model) {

        try {
            List<ArticuloDto> articulos = manageService.getAllArticulos();
            model.addAttribute("articulos", articulos);
            model.addAttribute("error",null);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error","No se obtuvieron los articulos debido a un error");
        }

        return "manage";
    }

}
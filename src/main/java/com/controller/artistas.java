package com.controller;

import com.entity.concierto;
import com.entity.artista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class artistas {

    @Autowired

    private IartistasService artistasService;

    @GetMapping("/artistas")
    public String index(Model model) {
        List<artistas> listaartistas = artistasService.getAll();
        model.addAttribute("titulo", "artistas");
        return "artistas";
    }
    @GetMapping ("/artistasN")
  public String crearartista (Model model){
model.addAttribute ("artistas", new artistas () ) ;
return "crear";
  }
@PostMapping ("/save")
public String guardarListas(@ModelAttribute artistas artista){
artistasService.save(artista) ;
return "redirect:/artista";
}
@GetMapping ("/delte/(id)")
public String eliminarartista(@PathVariable("id")Long idartistas){
artistasService.delete(idartistas);
return"redirect:/artista";
}
}
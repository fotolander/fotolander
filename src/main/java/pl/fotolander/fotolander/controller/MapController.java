package pl.fotolander.fotolander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.fotolander.fotolander.entity.Place;
import pl.fotolander.fotolander.service.PlaceService;

import java.util.Arrays;

@RequestMapping("/map")
@Controller
public class MapController {

    private final PlaceService placeService;

    @Autowired
    public MapController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("placePin", new Place(1L, "Agro", "Mladz 20", "lorem ipsum", 50.945, 15.423, "dolnośląskie"));
        model.addAttribute("places", placeService.findAllPlaces());
        model.addAttribute("something", "Witaj w FotolanderDemo");
        return "map";
    }
}

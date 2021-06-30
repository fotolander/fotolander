package pl.fotolander.fotolander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.fotolander.fotolander.entity.Place;
import pl.fotolander.fotolander.service.PlaceService;

import java.util.Arrays;


@Controller
public class MapController {

    private final PlaceService placeService;

    @Autowired
    public MapController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("placePin", new Place(1L, "Agro", "Mladz 20", "lorem ipsum", 50.945, 15.423));
        model.addAttribute("places", Arrays.asList(new Place(1L, "Agro", "Mladz 20", "lorem ipsum", 50.945, 15.423)));
        model.addAttribute("something", "Witaj w FotolanderDemo");
        return "map";
    }
}

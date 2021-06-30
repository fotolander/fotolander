package pl.fotolander.fotolander.MapOfPlaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.fotolander.fotolander.places.Place;
import pl.fotolander.fotolander.places.PlaceService;

import java.util.Arrays;
import java.util.List;

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
        model.addAttribute("placePin", new Place(1L, "Agro", "Mladz 20", "lorem ipsum", 50.945, 15.423, "WITAMY W MLĄDZ"));
        model.addAttribute("places", Arrays.asList(new Place(1L, "Agro", "Mladz 20", "lorem ipsum", 50.945, 15.423, "WITAMY W MLĄDZ")));
        model.addAttribute("something", "Witaj w FotolanderDemo");
        return "map";
    }


}
//    private Long id;
//    private String name;
//    private String address;
//    private String description;
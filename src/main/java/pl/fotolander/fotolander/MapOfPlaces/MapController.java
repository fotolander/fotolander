package pl.fotolander.fotolander.MapOfPlaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.fotolander.fotolander.places.Place;

@RequestMapping("/map")
@Controller
public class MapController {

    @GetMapping
    public String getMap(Model model) {
        Model model1 = model.addAttribute("placePin", new Place(1L, "Agro", "Mladz 20", "lorem ipsum" ,50.945, 15.423, "WITAMY W MLĄDZ"));
        return "map";
    }
}

//    private Long id;
//    private String name;
//    private String address;
//    private String description;
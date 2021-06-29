package pl.fotolander.fotolander.MapOfPlaces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MapController {

    @GetMapping
    public String getMap(Model model) {
        model.addAttribute("placePin", new Pin(50.945, 15.423, "WITAMY W MLĄDZ"));
        return "map";
    }
}

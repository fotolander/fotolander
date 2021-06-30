package pl.fotolander.fotolander.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/places")
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

//    @GetMapping("/all")
//    public String showAll(Model model) {
//        model.addAttribute("places", placeService.findAllPlaces());
//        return "allPlaces";
//    }

    @GetMapping
    public void getAllPlaces(){
        placeService.findAllPlaces();
    }

    @PutMapping
    public void addPlace(Place place){
        placeService.addPlace(place);
    }

    @GetMapping("/{name}")
    public void getSelectedPlaceByName(@PathVariable String name){
        placeService.findPlaceByName(name);
    }

    @DeleteMapping("/{id}")
    public void deletePlaceById(@PathVariable Long id){
        placeService.deletePlaceById(id);
    }
}

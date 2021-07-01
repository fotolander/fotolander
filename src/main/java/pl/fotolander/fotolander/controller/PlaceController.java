package pl.fotolander.fotolander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.fotolander.fotolander.entity.Place;
import pl.fotolander.fotolander.service.PlaceService;

import java.util.List;

@RequestMapping("/places")
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/all")
    public List<Place> getAllPlaces(){
        return placeService.findAllPlaces();
    }

    @PostMapping("/add")
    public void addPlace(@RequestBody Place place){
        placeService.addPlace(place);
    }

    @GetMapping("/{name}")
    public Place getSelectedPlaceByName(@PathVariable String name){
        return placeService.findPlaceByName(name);
    }

    @DeleteMapping("/{id}")
    public void deletePlaceById(@PathVariable Long id){
        placeService.deletePlaceById(id);
    }
}

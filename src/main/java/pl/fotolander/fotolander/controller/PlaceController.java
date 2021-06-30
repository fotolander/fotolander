package pl.fotolander.fotolander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.fotolander.fotolander.entity.Place;
import pl.fotolander.fotolander.service.PlaceService;

@RequestMapping("/places")
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

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

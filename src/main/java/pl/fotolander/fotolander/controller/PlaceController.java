package pl.fotolander.fotolander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> allPlaces = placeService.findAllPlaces();
        return new ResponseEntity<>(allPlaces, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Place> addPlace(@RequestBody Place place) {
        Place place1 = placeService.addPlace(place);
        return new ResponseEntity<>(place1, HttpStatus.CREATED);
    }

    @GetMapping("/all/{name}")
    public ResponseEntity<Place> getSelectedPlaceByName(@PathVariable String name) {
        Place placeByName = placeService.findPlaceByName(name);
        return new ResponseEntity<>(placeByName, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaceById(@PathVariable Long id) {
        placeService.deletePlaceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{voivodeship}")
    public ResponseEntity<List<Place>> findPlacesByVoivodeship(@PathVariable String voivodeship) {
        List<Place> placesByVoivodeship = placeService.findPlacesByVoivodeship(voivodeship);
        return new ResponseEntity<>(placesByVoivodeship, HttpStatus.OK);
    }
}
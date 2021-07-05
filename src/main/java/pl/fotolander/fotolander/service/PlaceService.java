package pl.fotolander.fotolander.service;

import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fotolander.fotolander.entity.Place;
import pl.fotolander.fotolander.repository.PlaceRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final JsonToGeoJsonTransformer jsonToGeoJsonTransformer;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, JsonToGeoJsonTransformer jsonToGeoJsonTransformer) {
        this.placeRepository = placeRepository;
        this.jsonToGeoJsonTransformer = jsonToGeoJsonTransformer;
    }

    public Place findPlaceByName(String name){
        return placeRepository.findAll().stream()
                .filter(place -> place.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> {
                    throw new NoSuchElementException("Nie znaleziono miejsca o podanej nazwie");
                });
    }

    public List<Place> findAllPlaces(){
        return placeRepository.findAll();
    }

    public JSONObject findAllPlacesGeoJson(){
        return jsonToGeoJsonTransformer.transformJsonToGeoJson(placeRepository.findAll());
    }

    public Place addPlace(Place place){
        placeRepository.findByName(place.getName()).stream().findAny()
                .ifPresent(v->{
                    throw new IllegalArgumentException(String.format("Miejsce o podanej nazwie $s już istnieje", place.getName()));
                });
        placeRepository.save(place);
        return place;
    }

    public Place deletePlaceById(Long id){
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("Nie znaleziono miejsca o podanym id");
                });
        placeRepository.delete(place);
        return place;
    }

    //NEW METHOD
    public List<Place> findPlacesByVoivodeship(String voivodeship){
        return placeRepository.findByVoivodeship(voivodeship);
    }
}

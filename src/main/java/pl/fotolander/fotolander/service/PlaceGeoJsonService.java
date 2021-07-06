//package pl.fotolander.fotolander.service;
//
//import org.cloudinary.json.JSONArray;
//import org.cloudinary.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import pl.fotolander.fotolander.entity.Place;
//import pl.fotolander.fotolander.repository.PlaceRepository;
//
//import java.util.List;
//
//@Component
//public class PlaceGeoJsonService {
//
//    private final PlaceRepository placeRepository;
//
//    @Autowired
//    public PlaceGeoJsonService(PlaceRepository placeRepository) {
//        this.placeRepository = placeRepository;
//    }
//
//    public JSONObject getGeoJsonFromPlaces() {
//        JSONObject featureCollection = new JSONObject();
//        featureCollection.put("type", "FeatureCollection");
//        JSONObject crs = new JSONObject();
//        crs.put("type", "name");
//        JSONObject properties = new JSONObject();
//        properties.put("name", "ESPG:4326");
//        crs.put("properties", properties);
//        featureCollection.put("crs", crs);
//        JSONArray features = new JSONArray();
//        List<Place> all = placeRepository.findAll();
//        for (Place place : all) {
//            JSONObject feature = new JSONObject();
//            feature.put("type", "Feature");
//            JSONObject geometry = new JSONObject();
//            geometry.put("type", "Point");
//            JSONArray JSONArrayCoord = new JSONArray("[" + place.getLongitude() + "," + place.getLatitude() + "]");
//            geometry.put("coordinates", JSONArrayCoord);
//            feature.put("geometry", geometry);
//            JSONObject desc = new JSONObject();
//            feature.put("properties", desc);
//            desc.put("name", place.getName());
//            features.put(feature);
//            featureCollection.put("features", features);
//        }
//        return featureCollection;
//    }
//}
//
//

package pl.fotolander.fotolander.entity;

import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class JsonObjectFromPlaces {

//    private String name;
//    private double longitude;
//    private double latitude;
public static void main(String[] args) {

    Place place1 = Place.builder().name("Gdansk").latitude(54.22).longitude(17.88).build();
    Place place2 = Place.builder().name("Lublin").latitude(52.56).longitude(18.14).build();
    List<Place> all = Arrays.asList(place1, place2);

    JSONObject featureCollection = new JSONObject();
    featureCollection.put("type", "FeatureCollection");
    JSONObject crs = new JSONObject();
    crs.put("type", "name");
    JSONObject properties = new JSONObject();
    properties.put("name", "ESPG:4326");
    crs.put("properties", properties);
    featureCollection.put("crs", crs);
    JSONArray features = new JSONArray();
    for (Place place : all) {
        JSONObject feature = new JSONObject();
        feature.put("type", "Feature");
        JSONObject geometry = new JSONObject();
        geometry.put("type", "Point");
        JSONArray JSONArrayCoord = new JSONArray("[" + place.getLongitude() + "," + place.getLatitude() + "]");
        geometry.put("coordinates", JSONArrayCoord);
        feature.put("geometry", geometry);
        JSONObject desc = new JSONObject();
        feature.put("properties", desc);
        desc.put("name", place.getName());
        features.put(feature);
        featureCollection.put("features", features);
    }
    System.out.println(featureCollection);
}
}

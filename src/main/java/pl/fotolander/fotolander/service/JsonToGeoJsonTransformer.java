package pl.fotolander.fotolander.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.springframework.stereotype.Component;
import pl.fotolander.fotolander.entity.Place;
import java.util.List;

@Component
public class JsonToGeoJsonTransformer {

    public JSONObject transformJsonToGeoJson(List<Place> all) {
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
        return featureCollection;
    }

    public JSONObject transformJsonToGeoJson(Place place) {



        return null;
    }
}



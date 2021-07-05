package pl.fotolander.fotolander.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.fotolander.fotolander.entity.Place;
import org.cloudinary.json.JSONObject;

import static org.junit.jupiter.api.Assertions.*;

class JsonToGeoJsonTransformerTest {


    @Test
    void shouldConvertSinglePlaceToGeojson() throws JsonProcessingException {
        Place sdaSushiPlace = Place.builder()
                .address("Piotrkowska 102")
                .id(1)
                .description("Best meal in the town")
                .name("SDA Sushi")
                .latitude(51.75326375798958)
                .longitude(19.45979118347168)
                .build();

        JsonToGeoJsonTransformer transformer = new JsonToGeoJsonTransformer();
        FeatureCollection geojson = transformer.transformJsonToGeoJson(sdaSushiPlace);

        assertEquals(1, geojson.getFeatures().size());
        assertEquals("Best meal in the town", geojson.getFeatures().get(0).getProperties().get("description"));
        System.out.println(new ObjectMapper().writeValueAsString(geojson));
    }

}


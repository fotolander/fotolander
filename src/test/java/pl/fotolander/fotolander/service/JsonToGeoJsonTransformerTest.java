package pl.fotolander.fotolander.service;

import org.junit.jupiter.api.Test;
import pl.fotolander.fotolander.entity.Place;
import org.cloudinary.json.JSONObject;

import static org.junit.jupiter.api.Assertions.*;

class JsonToGeoJsonTransformerTest {


    @Test
    void shouldConvertSinglePlaceToGeojson() {
        Place sdaSushiPlace = Place.builder()
                .address("Piotrkowska 102")
                .id(1)
                .description("Best meal in the town")
                .name("SDA Sushi")
                .latitude(19.45979118347168)
                .longitude(51.75326375798958)
                .build();

        JsonToGeoJsonTransformer transformer = new JsonToGeoJsonTransformer();


        JSONObject geojson = transformer.transformJsonToGeoJson(sdaSushiPlace);

//        assertEquals(geojson.);

//        geojson.toString()

    }

}


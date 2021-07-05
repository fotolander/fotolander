//package pl.fotolander.fotolander.controller;
//
//import org.cloudinary.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import pl.fotolander.fotolander.service.PlaceGeoJsonService;
//
//@RequestMapping("/geo")
//@RestController
//public class GeoJsonController {
//
//    private final PlaceGeoJsonService service;
//
//    @Autowired
//    public GeoJsonController(PlaceGeoJsonService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<JSONObject> getGeoJsons(){
//
//
//        return new ResponseEntity<>(, HttpStatus.OK);
//    }
//}

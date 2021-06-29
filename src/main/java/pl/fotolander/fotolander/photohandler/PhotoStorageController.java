package pl.fotolander.fotolander.photohandler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PhotoStorageController {

    private final PhotoStorageService photoStorageService;

    public PhotoStorageController(PhotoStorageService photoStorageService) {
        this.photoStorageService = photoStorageService;
    }



}

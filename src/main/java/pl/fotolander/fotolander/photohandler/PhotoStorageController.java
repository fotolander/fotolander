package pl.fotolander.fotolander.photohandler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PhotoStorageController {

    private final PhotoStorageService photoStorageService;

    public PhotoStorageController(PhotoStorageService photoStorageService) {
        this.photoStorageService = photoStorageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("photos", photoStorageService.getPhoto());
        return "photos";
    }


    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("photo")MultipartFile photo) {
        photoStorageService.uploadPhoto(new UploadPhoto(photo, photo.getOriginalFilename()));
        return "redirect:/";
    }
}

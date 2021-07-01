package pl.fotolander.fotolander.domain;

import org.springframework.web.multipart.MultipartFile;
import pl.fotolander.fotolander.entity.Photo;

public class UploadPhoto {
    private MultipartFile photo;
    private String name;

    public UploadPhoto(MultipartFile photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public Photo toPhoto(String urlToPhoto) {
        return new Photo(name, urlToPhoto);
    }
}

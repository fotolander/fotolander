package pl.fotolander.fotolander.service;


import org.springframework.stereotype.Service;
import pl.fotolander.fotolander.entity.Photo;
import pl.fotolander.fotolander.domain.UploadPhoto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotoStorageService {

    private final CloudinaryService cloudinaryService;
    private Map<String, Photo> photoStorage;

    public PhotoStorageService(CloudinaryService cloudinaryService, Map<String, Photo> photoStorage) {
        this.cloudinaryService = cloudinaryService;
        this.photoStorage = new HashMap<>();
    }

    public Photo uploadPhoto(UploadPhoto upload) {
        String urlToPhoto = cloudinaryService.uploadPhoto(upload.getPhoto());
        Photo photo = upload.toPhoto(urlToPhoto);
        photoStorage.put(UUID.randomUUID().toString(), photo);
        return photo;
    }

    public Collection<Photo> getPhoto() {
        return photoStorage.values();
    }
}

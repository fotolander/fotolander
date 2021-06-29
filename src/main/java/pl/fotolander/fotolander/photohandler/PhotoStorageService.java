package pl.fotolander.fotolander.photohandler;


import org.springframework.stereotype.Service;

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

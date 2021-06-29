package pl.fotolander.fotolander.photohandler;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadPhoto(MultipartFile photo) {
        try {
            File uploadedPhoto = convertMultiPartToPhoto(photo);
            Map uploadResult = cloudinary.uploader().upload(uploadedPhoto, ObjectUtils.emptyMap());
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private File convertMultiPartToPhoto(MultipartFile photo) throws IOException {
        File convPhoto = new File(photo.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convPhoto);
        fos.write(photo.getBytes());
        fos.close();
        return convPhoto;
    }


}

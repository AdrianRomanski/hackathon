package pl.edu.pja.hackathon.services.image;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FunctionalInterface
public interface ImageService<T> {

    void saveImageFile(T object, MultipartFile file) throws IOException;
}

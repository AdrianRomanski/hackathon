package pl.edu.pja.hackathon.services.image;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.repositories.CategoryRepository;

import java.io.IOException;

@Service
public class ImageServiceCategory implements ImageService<Category> {

    private final CategoryRepository categoryRepository;

    public ImageServiceCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveImageFile(Category category, MultipartFile file) throws IOException {
        var byteObjects = new Byte[file.getBytes().length];

        var i = 0;

        for(byte b: file.getBytes()) {
            byteObjects[i++] = b;
        }
        category.setImage(byteObjects);
        categoryRepository.save(category);
    }
}

package pl.pja.edu.hackathon.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.pja.edu.hackathon.services.CategoryService;


import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.google.common.io.ByteStreams.copy;


@Controller
@AllArgsConstructor
public class ImageCategoryController {

    private final CategoryService categoryService;


    @GetMapping("category/{id}/categoryImage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        var category = categoryService.getCategoryById(Long.valueOf(id));
        if (category.getImage() != null) {
            byte[] byteArray = new byte[category.getImage().length];
            int i = 0;

            for (Byte wrappedByte : category.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            copy(is, response.getOutputStream());
        }
    }
}

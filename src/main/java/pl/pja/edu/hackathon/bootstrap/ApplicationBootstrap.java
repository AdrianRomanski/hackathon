package pl.pja.edu.hackathon.bootstrap;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.pja.edu.hackathon.model.Category;
import pl.pja.edu.hackathon.repositories.CategoryRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Byte[] horrorImage = getBytes("src/main/resources/static/pictures/kiwi_oil.jpg");

        Category category = Category.builder().name("kredki").image(horrorImage).build();
        Category category1 = Category.builder().name("kredki").image(horrorImage).build();
        Category category2 = Category.builder().name("kredki").image(horrorImage).build();
        Category category3 = Category.builder().name("kredki").image(horrorImage).build();
        Category category4 = Category.builder().name("kredki").image(horrorImage).build();
        Category category5 = Category.builder().name("kredki").image(horrorImage).build();


        categoryRepository.saveAll(Arrays.asList(category, category1, category2, category3, category4, category5));
    }

    private Byte[] getBytes(String path) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(path));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        Byte[] bytes = new Byte[data.length];
        Arrays.setAll(bytes, n -> data[n]);
        return bytes;
    }
}

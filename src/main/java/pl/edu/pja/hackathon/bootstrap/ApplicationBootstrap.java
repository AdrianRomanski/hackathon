package pl.edu.pja.hackathon.bootstrap;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.model.memocard.MemoCard;
import pl.edu.pja.hackathon.repositories.CategoryRepository;
import pl.edu.pja.hackathon.repositories.MemoCardRepository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final MemoCardRepository memoCardRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Byte[] horrorImage = getBytes("src/main/resources/static/pictures/kiwi_oil.jpg");

        // Categories
        Category colors = Category.builder().name("Kolory").image(horrorImage).build();
        Category countries = Category.builder().name("Państwa").image(horrorImage).build();
        Category furniture = Category.builder().name("Meble").image(horrorImage).build();
        Category animals = Category.builder().name("Zwierzęta").image(horrorImage).build();
        Category family = Category.builder().name("Rodzina").image(horrorImage).build();
        Category buildings = Category.builder().name("Budynki").image(horrorImage).build();
        Category food = Category.builder().name("Jedzenie").image(horrorImage).build();
        Category vehicles = Category.builder().name("Pojazdy").image(horrorImage).build();
        Category items = Category.builder().name("Przedmioty").image(horrorImage).build();
        Category cities = Category.builder().name("Miasta").image(horrorImage).build();
        Category weather = Category.builder().name("Pogoda").image(horrorImage).build();
        Category work = Category.builder().name("Praca").image(horrorImage).build();
        Category drinks = Category.builder().name("Napoje").image(horrorImage).build();

        categoryRepository.saveAll(Arrays.asList(colors, countries, furniture, animals, family, buildings, food, vehicles, items, cities, weather, work, drinks));

        // Colors
        MemoCard black = MemoCard.builder().name("black").definition("czarny").category(colors).build();
        MemoCard white = MemoCard.builder().name("white").definition("biały").category(colors).build();
        MemoCard orange = MemoCard.builder().name("orange").definition("pomarańczowy").category(colors).build();
        MemoCard red = MemoCard.builder().name("red").definition("czerwony").category(colors).build();
        MemoCard blue = MemoCard.builder().name("blue").definition("niebieski").category(colors).build();
        MemoCard grey = MemoCard.builder().name("grey").definition("szary").category(colors).build();

        memoCardRepository.saveAll(Arrays.asList(black, white, orange, red, blue, grey));
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
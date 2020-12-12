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
import java.util.Set;

@Component
@AllArgsConstructor
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final MemoCardRepository memoCardRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Byte[] horrorImage = getBytes("src/main/resources/static/pictures/kiwi_oil.jpg");

        Category colors = Category.builder().name("kolory").image(horrorImage).build();
        Category countries = Category.builder().name("nazwy państw").image(horrorImage).build();
        Category furnitures = Category.builder().name("meble").image(horrorImage).build();
        Category animals = Category.builder().name("zwierzęta").image(horrorImage).build();
        Category family = Category.builder().name("rodzina").image(horrorImage).build();
        Category fruits = Category.builder().name("owoce").image(horrorImage).build();
        Category vegetables = Category.builder().name("warzywa").image(horrorImage).build();
        Category vehicles = Category.builder().name("pojazdy").image(horrorImage).build();

        categoryRepository.saveAll(Arrays.asList(colors, countries, furnitures, animals, family, fruits, vegetables, vehicles));

        MemoCard black = MemoCard.builder().name("black").definition("czarny").category(colors).build();
        MemoCard white = MemoCard.builder().name("white").definition("biały").category(colors).build();
        MemoCard orange = MemoCard.builder().name("orange").definition("pomarańczowy").category(colors).build();
        MemoCard red = MemoCard.builder().name("red").definition("czerwony").category(colors).build();
        MemoCard blue = MemoCard.builder().name("blue").definition("niebieski").category(colors).build();
        MemoCard grey = MemoCard.builder().name("grey").definition("szary").category(colors).build();
        MemoCard pink = MemoCard.builder().name("pink").definition("różowy").category(colors).build();
        MemoCard brown = MemoCard.builder().name("brown").definition("brązowy").category(colors).build();

        List<MemoCard> colorMemoCards = Arrays.asList(black, white, orange, red, blue, grey, pink, brown);

        memoCardRepository.saveAll(colorMemoCards);
        colors.setMemoCardList(colorMemoCards);
        categoryRepository.save(colors);
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

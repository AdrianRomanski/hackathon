package pl.edu.pja.hackathon.bootstrap;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.repositories.CategoryRepository;

@Component
@AllArgsConstructor
@Profile("development")
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Category category = Category.builder().name("test").build();

        categoryRepository.save(category);
    }
}

package pl.edu.pja.hackathon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/categories/page/{page}")
    public ModelAndView getAllCategoriesPaged(@PathVariable int page) {
        ModelAndView modelAndView = new ModelAndView("showCategories");
        PageRequest pageable = PageRequest.of(page - 1, 6);
        Page<Category> categoryPage = categoryService.getAllCategoriesPaged(pageable);
        System.out.println(categoryPage.get().count());
        int totalPages = categoryPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("activeCategoryList", true);
        modelAndView.addObject("categories", categoryPage.getContent());
        System.out.println("Am i here");
        return modelAndView;
    }
}

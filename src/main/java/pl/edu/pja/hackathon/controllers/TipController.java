package pl.edu.pja.hackathon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pja.hackathon.model.Category;
import pl.edu.pja.hackathon.model.tip.Tip;
import pl.edu.pja.hackathon.services.CategoryService;
import pl.edu.pja.hackathon.services.TipService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class TipController {

    private final TipService tipService;


    @GetMapping("/tips/page/{page}")
    public ModelAndView getAllTipsPaged(@PathVariable int page) {
        ModelAndView modelAndView = new ModelAndView("showTips");
        PageRequest pageable = PageRequest.of(page - 1, 8);
        Page<Tip> tipPage = tipService.getAllTipsPaged(pageable);
        System.out.println(tipPage.get().count());
        int totalPages = tipPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("activeTipList", true);
        modelAndView.addObject("tips", tipPage.getContent());
        System.out.println("Am i here");
        return modelAndView;
    }
}
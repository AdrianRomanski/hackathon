package pl.edu.pja.hackathon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pja.hackathon.services.CategoryService;
import pl.edu.pja.hackathon.services.UserService;

@Controller
@AllArgsConstructor
@RequestMapping("/rankings")
public class RankingsController {


    private final UserService userService;

    @GetMapping
    private String getTop20(Model model) {
        model.addAttribute("users", userService.getTop20Users());
        return "rankings";
    }
}

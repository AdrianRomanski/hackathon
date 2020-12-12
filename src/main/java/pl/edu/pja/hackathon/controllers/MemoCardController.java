package pl.edu.pja.hackathon.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.pja.hackathon.model.CorrectAnswer;
import pl.edu.pja.hackathon.model.User;
import pl.edu.pja.hackathon.model.memocard.MemoCard;
import pl.edu.pja.hackathon.services.MemoCardService;
import pl.edu.pja.hackathon.services.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class MemoCardController {

    private final MemoCardService memoCardService;
    private final UserService userService;

    @GetMapping("/memocards/showAll/page/{page}")
    public ModelAndView getAllMemoCardsPaged(@PathVariable int page) {
        ModelAndView modelAndView = new ModelAndView("showMemoCards");
        PageRequest pageable = PageRequest.of(page - 1, 8);
        Page<MemoCard> memoCardPage = memoCardService.getAllMemoCardsPaged(pageable);
        return getModelAndView(modelAndView, memoCardPage);
    }

    @GetMapping("/memocards/{category}/page/{page}")
    public ModelAndView getAllForCategory(@PathVariable int page, @PathVariable String category) {
        ModelAndView modelAndView = new ModelAndView("showMemoCardsForCategory");
        PageRequest pageable = PageRequest.of(page - 1, 8);
        Page<MemoCard> memoCardPage = memoCardService.getAllForCategory(category, pageable);
        ModelAndView modelAndView1 = getModelAndView(modelAndView, memoCardPage);
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("memocards/{id}")
    public String getByID(@PathVariable String id, Model model){
        model.addAttribute("user", userService.getUserByID(1L));
        model.addAttribute("card", memoCardService.getMemoCardById(Long.valueOf(id)));
        model.addAttribute("answers", memoCardService.getRandomAnswers(Long.valueOf(id)));
        return "showSingleMemoCard";
    }

    @GetMapping("memocards/{id}/{answer}")
    public String checkAnswer(@PathVariable String id,  @PathVariable String answer, Model model) {
        User user = userService.getUserByID(1L);
        long nextID = Long.parseLong(id)+1;
        String nextMove = "redirect:/memocards/" + nextID + "/nextMove";
        if(memoCardService.checkAnswer(answer, Long.valueOf(id))) {
            user.incrementPoints();
            return nextMove;
        }
        else
            return "redirect:/memocards/" + id;
    }

    @GetMapping("memocards/{id}/nextMove")
    public String getByIDChecked(@PathVariable String id, Model model){
        model.addAttribute("user", userService.getUserByID(1L));
        model.addAttribute("card", memoCardService.getMemoCardById(Long.valueOf(id)));
        model.addAttribute("answers", memoCardService.getRandomAnswers(Long.valueOf(id)));
        return "showSingleMemoCard";
    }

    private ModelAndView getModelAndView(ModelAndView modelAndView, Page<MemoCard> memoCardPage) {
        int totalPages = memoCardPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("activeMemoCardList", true);
        modelAndView.addObject("memocards", memoCardPage.getContent());
        return modelAndView;
    }
}

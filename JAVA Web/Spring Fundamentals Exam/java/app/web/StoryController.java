package app.web;

import app.story.model.Story;
import app.story.service.StoryService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.AddStory;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/stories")
public class StoryController {

    private final UserService userService;
    private final StoryService storyService;

    @Autowired
    public StoryController(UserService userService, StoryService storyService) {
        this.userService = userService;
        this.storyService = storyService;
    }

    @GetMapping("/new")
    public ModelAndView addStory(AddStory addStory) {
        ModelAndView mav = new ModelAndView("add-story");

        mav.addObject("addStory", AddStory.builder().build());

        return mav;
    }

    @PostMapping("/new")
    public ModelAndView addStory(@Valid AddStory addStory, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-story");
        }

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = this.userService.getById(userId);

        this.storyService.newStory(user, addStory);

        return new ModelAndView("redirect:/home");
    }

    @DeleteMapping("/{storyId}/delete")
    public String deleteStory(@PathVariable UUID storyId) {
        storyService.deleteStory(storyId);
        return "redirect:/home";
    }

    @PostMapping("/{storyId}/visibility")
    public String shareStory(@PathVariable UUID storyId) {
        storyService.shareStory(storyId);
        return "redirect:/home";
    }

    @GetMapping("/{storyId}")
    public ModelAndView readStory(@PathVariable UUID storyId) {
        Optional<Story> byId = storyService.findById(storyId);  // Fetch the story by ID
        if (byId.isEmpty()) {
            throw new RuntimeException("Story not found");
        }

        ModelAndView mav = new ModelAndView("story");
        mav.addObject("story", byId.get());

        return mav;
    }


}

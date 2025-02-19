package app.web;

import app.story.service.StoryService;
import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.LoginRequest;
import app.web.dto.RegisterRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class IndexController {

    private final UserService userService;
    private final StoryService storyService;

    @Autowired
    public IndexController(UserService userService, StoryService storyService) {
        this.userService = userService;
        this.storyService = storyService;
    }

    @GetMapping
    public String getIndexPage() {

        return "index";
    }

    @GetMapping("/register")
    public ModelAndView registerPage(RegisterRequest registerRequest) {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("registerRequest", RegisterRequest.builder().build());

        return mav;
    }

    @PostMapping("/register")
    public ModelAndView registerPage(@Valid RegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        this.userService.register(registerRequest);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/login")
    public ModelAndView loginPage(LoginRequest loginRequest) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("loginRequest", LoginRequest.builder().build());

        return mav;
    }

    @PostMapping("/login")
    public ModelAndView loginPost(@Valid LoginRequest loginRequest, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        User user = this.userService.login(loginRequest);
        session.setAttribute("user_id", user.getId());

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(HttpSession session) {
        ModelAndView mav = new ModelAndView("home");

        UUID userId = (UUID) session.getAttribute("user_id");
        User user = this.userService.getById(userId);

        mav.addObject("allStories", this.storyService.findAll());
        mav.addObject("user", user);

        return mav;
    }



}

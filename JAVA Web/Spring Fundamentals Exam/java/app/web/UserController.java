package app.web;

import app.user.model.User;
import app.user.service.UserService;
import app.web.dto.EditProfile;
import app.web.mapper.DtoMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    @GetMapping("/users/{userId}/profile")
    public ModelAndView editProfilePage(@PathVariable UUID userId) {
        ModelAndView mav = new ModelAndView("edit-profile");

        User user = this.userService.getById(userId);
        mav.addObject("userEditProfile", DtoMapper.mapUserToUserEditProfile(user));

        return mav;
    }

    @PutMapping("/users/{userId}/profile")
    public ModelAndView updateProfile(@PathVariable UUID userId, @ModelAttribute("userEditProfile") @Valid EditProfile editProfile, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mav = new ModelAndView("edit-profile");
            return mav;
        }

        this.userService.updateUserProfile(userId, editProfile);
        return new ModelAndView("redirect:/home");
    }


}

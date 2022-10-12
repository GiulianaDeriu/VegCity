package com.VegCity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.VegCity.model.User;
import com.VegCity.services.RecipeService;
import com.VegCity.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService; // (iniezione classe UserService nella classe UserController)
                             // motivo=principio riutilizzabilità
    @Autowired
    RecipeService recipeService;

    @PostMapping(value = "/registrazione/submit")
    public ModelAndView registrazione(HttpServletRequest request) {
        var model = new ModelAndView("registrazione");
        try {
            var user = new User(request.getParameter("name"), request.getParameter("password"),
                    request.getParameter("email"));
            userService.registrazione(user);
        } catch (Exception e) {
            model.addObject("errore", false);
        }
        return model;
    }

    @PostMapping(value = "/profile")
    public ModelAndView login(HttpServletRequest request) { // Object oggetto generico così posso mappare la response
        // per catturare eventuali eccezioni
        var model = new ModelAndView("registrazione");
        try {
            var u = userService.login(request.getParameter("name"), request.getParameter("password"));
            model = new ModelAndView("profile");
            var sessione = request.getSession();
            sessione.setAttribute("user", u);
            model.addObject("user", u);
            model.addObject("tue", u.getRecipe());
            model.addObject("tutte", recipeService.getAll());
            return model;
        } catch (Exception e) {
            model.addObject("errore", false);
        }
        return model;
    }
}

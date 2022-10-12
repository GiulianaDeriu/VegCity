package com.VegCity.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.VegCity.model.Recipe;
import com.VegCity.model.User;
import com.VegCity.services.RecipeService;
import com.VegCity.utility.Utility;

@RestController
@RequestMapping("/ricetta")
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    Utility utility;

    @RequestMapping("/getAllRecipes")
    @ResponseBody
    public List<Recipe> getAllRecipes() {
        List<Recipe> list = recipeService.getAll();

        return list;
    }

    @PostMapping("/newRecipe")
    public ModelAndView newRecipe() {
        var model = new ModelAndView("form");
        Recipe recipe = new Recipe();
        model.addObject("recipe", recipe);
        return model;
    }

    @RequestMapping(value = "/createRecipe", method = RequestMethod.POST)
    public ModelAndView createRecipe(HttpServletRequest request, HttpSession session)
            throws SerialException, SQLException {
        var user = (User) session.getAttribute("user");
        var model = new ModelAndView("profile");
        var recipe = utility.populateRecipe(request);
        recipe.setUser(user);
        try {
            System.out.println("creazione ricetta");
            recipeService.createRecipe(recipe);
            model.addObject("tutte", recipeService.getAll());
            model.addObject("tue", recipeService.getAllByUsername(user.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @RequestMapping(value = "/updateRecipe", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request, HttpSession session)
            throws NumberFormatException, Exception {
        var model = new ModelAndView("form");
        var user = (User) session.getAttribute("user");
        var recipe = recipeService.findById(Long.parseLong(request.getParameter("id")));
        recipe.setUser(user);
        try {
            System.out.println("modifica ricetta");
            model.addObject("recipe", recipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    @RequestMapping(value = "/deleteRecipe", method = RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request, HttpSession session) throws Exception {
        var user = (User) session.getAttribute("user");
        var model = new ModelAndView("profile");
        var id = request.getParameter("id");
        try {
            System.out.println("cancella ricetta");
            recipeService.delete(id);
            model.addObject("tutte", recipeService.getAll());
            model.addObject("tue", recipeService.getAllByUsername(user.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    @RequestMapping("/getAllByUsername")
    @ResponseBody
    public List<Recipe> getAllByUsername(@RequestBody User user) {

        List<Recipe> list = recipeService.getAllByUsername(user.getName());

        return list;
    }
}

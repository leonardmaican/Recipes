package ro.siit.recipes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.recipes.model.Category;
import ro.siit.recipes.model.Recipe;
import ro.siit.recipes.model.RecipesRepository;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * The controller class used to interact with the database and the html pages
 * Even though the sort by category method in the repository interface orders the recipes by their last modified date,
 * I sorted them again just to be sure
 */

@Controller
@RequestMapping("recipes")
public class RecipesController {

    @Autowired
    private RecipesRepository repo;


    @GetMapping(path = "home")
    public ModelAndView getRecipes() {
        ModelAndView modelAndView = new ModelAndView("recipes-main");
        List<Recipe> recipeList = repo.findAll();
        recipeList.sort(Recipe::compareTo);
        modelAndView.addObject("allRecipes", recipeList);

        return modelAndView;

    }

    @GetMapping(path = "add")
    public ModelAndView addRecipe() {
        ModelAndView modelAndView = new ModelAndView("recipe-add");
        Recipe recipe = new Recipe();
        modelAndView.addObject("newRecipe", recipe);
        modelAndView.addObject("category", Arrays.asList(Category.values()));
        return modelAndView;
    }

    @PostMapping(path = "add")
    public String recipeSubmit(@ModelAttribute(name = "newRecipe") @Valid Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "recipe-add";
        }
        repo.save(recipe);
        return "redirect:/recipes/home";

    }

    @GetMapping(path = "about")
    public ModelAndView getAboutPage() {
        return new ModelAndView("about");
    }

    @GetMapping(path = "/{id}")
    public ModelAndView getViewPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view-page");
        Recipe recipeToView = repo.findById((long) Math.toIntExact(id)).get();
        modelAndView.addObject("recipeToView", recipeToView);
        return modelAndView;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteRecipe(@RequestParam(name = "id") Long id) {
        repo.deleteById(id);
        return "redirect:/recipes/home";
    }

    @GetMapping(path = "soup")
    public ModelAndView getSoup() {
        ModelAndView modelAndView = new ModelAndView("soup-page");
        List<Recipe> soupList = repo.findByCategoryOrderByDateCreated(Category.SOUP);
        soupList.sort(Recipe::compareTo);
        modelAndView.addObject("soupList", soupList);
        return modelAndView;
    }

    @GetMapping(path = "maindish")
    public ModelAndView getMainDish() {
        ModelAndView modelAndView = new ModelAndView("mainDish-page");
        List<Recipe> mainDishList = repo.findByCategoryOrderByDateCreated(Category.MAINDISH);
        mainDishList.sort(Recipe::compareTo);
        modelAndView.addObject("mainDishList", mainDishList);
        return modelAndView;
    }

    @GetMapping(path = "salad")
    public ModelAndView getSalad() {
        ModelAndView modelAndView = new ModelAndView("salad-page");
        List<Recipe> saladList = repo.findByCategoryOrderByDateCreated(Category.SALAD);
        saladList.sort(Recipe::compareTo);
        modelAndView.addObject("saladList", saladList);
        return modelAndView;
    }

    @GetMapping(path = "dessert")
    public ModelAndView getDessert() {
        ModelAndView modelAndView = new ModelAndView("dessert-page");
        List<Recipe> dessertList = repo.findByCategoryOrderByDateCreated(Category.DESSERT);
        dessertList.sort(Recipe::compareTo);
        modelAndView.addObject("dessertList", dessertList);
        return modelAndView;
    }

    @GetMapping(path = "miscellaneous")
    public ModelAndView getMiscellaneous() {
        ModelAndView modelAndView = new ModelAndView("miscellaneous-page");
        List<Recipe> miscellaneousList = repo.findByCategoryOrderByDateCreated(Category.MISCELLANEOUS);
        miscellaneousList.sort(Recipe::compareTo);
        modelAndView.addObject("miscellaneousList", miscellaneousList);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView getEditPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("edit-page");
        Recipe recipeToEdit = repo.findById((long) Math.toIntExact(id)).get();
        modelAndView.addObject("recipeToEdit", recipeToEdit);
        return modelAndView;
    }

    @PostMapping(path = "/{id}/edit")
    public String editRecipe(@ModelAttribute(name = "recipeToEdit") @Valid Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-page";
        }
        repo.save(recipe);
        return "redirect:/recipes/{id}";

    }


}

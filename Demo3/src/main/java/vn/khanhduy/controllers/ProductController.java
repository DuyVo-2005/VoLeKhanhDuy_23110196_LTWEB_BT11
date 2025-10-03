package vn.khanhduy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import vn.khanhduy.entities.Product;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private vn.khanhduy.services.ProductServices service;

    @RequestMapping("/")
    public String viewHomePage(ModelMap model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductForm(ModelMap model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

}


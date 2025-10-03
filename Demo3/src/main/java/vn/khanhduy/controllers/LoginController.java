package vn.khanhduy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import vn.khanhduy.entities.Product;
import vn.khanhduy.services.ProductServices;

@Controller
public class LoginController {

    private final SecurityFilterChain filterChain;

	@Autowired
	private ProductServices service;

    LoginController(SecurityFilterChain filterChain) {
        this.filterChain = filterChain;
    }
	
	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Logging user login success ...");
		return "index";
	}
	
	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
		System.out.println("Login failure handler....");
		return "login";
	}
	
	@RequestMapping("/")
	public String viewHomePage(ModelMap model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(ModelMap model, @ModelAttribute("product") Product product) {
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("edit_product");
		Product product = service.get(id);
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
}

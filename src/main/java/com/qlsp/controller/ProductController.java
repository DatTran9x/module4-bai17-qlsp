package com.qlsp.controller;

import com.qlsp.model.Product;
import com.qlsp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/home")
    public ModelAndView show(){
        ModelAndView mav = new ModelAndView("/views/homepage");
        mav.addObject("list",productService.findAll());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView mav = new ModelAndView("/views/create");
        mav.addObject("product",new Product());
        return mav;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/views/edit");
        mav.addObject("product",productService.findById(id));
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/views/delete");
        mav.addObject("product",productService.findById(id));
        return mav;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        productService.delete(id);
        return "redirect:/home";
    }
}

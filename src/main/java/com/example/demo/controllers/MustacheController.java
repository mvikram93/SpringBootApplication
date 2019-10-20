package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Product;

@Controller
public class MustacheController {

	

	    @GetMapping("/products")
	    public String getProducts(final Model model){

	        List productList = IntStream.range(0,7).mapToObj(i->getProduct(i)).collect(Collectors.toList());
	        model.addAttribute("productList",productList);
	        return "products";
	    }

	    private Product getProduct(int i){
	        return new Product(String.valueOf(i),"Product"+i, "Sample Description "+i, 100+i);
	    }
	
}

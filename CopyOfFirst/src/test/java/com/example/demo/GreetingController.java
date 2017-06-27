package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
        
    }
    @RequestMapping("/")
    public String index(){ 
    	return "Greeting grom Spring!";
    }
    @RequestMapping("/firstgreeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name, Model model) {
        model.addAttribute("greeting",new Greeting(counter.incrementAndGet(),
                String.format(template, name)) );

    	return "Hello";
        
    }
    
}
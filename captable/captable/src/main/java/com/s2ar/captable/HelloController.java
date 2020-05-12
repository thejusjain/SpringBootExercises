package com.s2ar.captable;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World")  String name) {
        model.addAttribute("id", name);
        return "hello";
    }

    /*
    * The @GetMapping annotations is used to fetch parameters from the url using the ? and the @ RequestParam variable. @GetMapping and @RequestMapping
    * work together, such that the variable used in the @RequestParam is used to fetch the values from the url.
    * The @RequestMapping annotation is used to display something at the url
    *
    * Adding Model model in the hello method is dependency injection which allows the model to be used inside the controller. // Refer more
    *  The model.addAttribute provides the values to the view, i here the jsp file (html), the string parameter is the variable used in the view and the
    * object is the variable to be passed to the string variable
    *
    * The return of the method provides the file name of the view to be displayed. The path and the extension is provided in the application.properties file
    * */

//    public String name = "Thejus";
//    @RequestMapping("/")
//    public String hello(Model model) {
//        model.addAttribute("default", name);
//        return "/hello";
//    }
}

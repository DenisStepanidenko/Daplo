package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerToFunctionAndDesign {
    @GetMapping("/Function_Or_Design")
    public String controllerToFandD(){
        return "Function_And_Design";
    }

    @GetMapping("/create_app_of_color")
    public String controllerToColor(){
        return "create_app_of_color";
    }
}

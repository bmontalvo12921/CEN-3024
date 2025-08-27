package com.example.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller// controller to map any errors that might arrise
public class CustomErrorController{

    @GetMapping
    public String handleError() {
        // Custom error page (templates/error.html)
        return "error";
    }

    // Deprecated but recommended for clarity
    public String getErrorPath() {
        return "/error";
    }
}

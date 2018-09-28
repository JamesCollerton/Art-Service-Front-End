package com.artservicefrontend.artservicefrontend.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiOperation;

@Controller
public class HomeController {

    @ApiOperation(
            httpMethod = "GET",
            value = "Get the home view",
            notes = "Returns the home template for the web front end.",
            response = String.class
    )
    @GetMapping("/")
    public String home() {
        return "home";
    }

}

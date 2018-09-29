package com.artservicefrontend.artservicefrontend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(
            httpMethod = "GET",
            value = "Get the home view",
            notes = "Returns the home template for the web front end.",
            response = String.class
    )
    @GetMapping("/")
    public String home() {
        String allPieceInformationJSONString = restTemplate.getForObject("http://art-service-manipulating-data-service-application/pieces", String.class);

        return "home";
    }

}

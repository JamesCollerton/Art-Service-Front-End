package com.artservicefrontend.artservicefrontend.controllers;

import com.artservicefrontend.artservicefrontend.domain.PieceInformation;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This is the controller for the home page of the site.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Autowired rest template to allow us to use the Eureka intelligent
     * service routing.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * This returns the view for the home page.
     *
     * @return
     */
    @ApiOperation(
            httpMethod = "GET",
            value = "Get the home view",
            notes = "Returns the home template for the web front end.",
            response = String.class
    )
    @GetMapping
    public String home(Model model) {
        ResponseEntity<List<PieceInformation>> pieceInformationResponse =
                restTemplate.exchange(
                        "http://art-service-manipulating-data-service/pieces",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<PieceInformation>>(){}
                );

        List<PieceInformation> pieces = pieceInformationResponse.getBody();

        model.addAttribute("pieces", pieces);

        return "home";
    }

}

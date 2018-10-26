package com.artservicefrontend.artservicefrontend.controllers;

import com.artservicefrontend.artservicefrontend.clients.ArtServiceManipulatingDataClient;
import com.artservicefrontend.artservicefrontend.domain.PieceInformation;
import feign.Feign;
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
     * Autowired client for retrieving piece information from the manipulating data service
     */
    @Autowired
    private ArtServiceManipulatingDataClient artServiceManipulatingDataClient;

    /**
     * This returns the view for the home page. It adds all of the piece information to the Thymeleaf model
     * and then returns the view.
     *
     * @return The view name
     */
    @ApiOperation(
            httpMethod = "GET",
            value = "Get the home view",
            notes = "Returns the home template for the web front end.",
            response = String.class
    )
    @GetMapping
    public String home(Model model) {
        List<PieceInformation> pieces = artServiceManipulatingDataClient.getAllPieceInformation();

        model.addAttribute("pieces", pieces);

        return "home";
    }

}

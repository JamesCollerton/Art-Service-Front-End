package com.artservicefrontend.artservicefrontend.Controllers;

import com.artservicefrontend.artservicefrontend.Domain.MutablePieceInformation;
import com.artservicefrontend.artservicefrontend.Domain.PieceInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        ResponseEntity<List<PieceInformation>> pieceInformationResponse =
                restTemplate.exchange(
                        "http://art-service-manipulating-data-service-application/pieces",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<PieceInformation>>(){}
                );

        List<PieceInformation> pieceInformationList = pieceInformationResponse.getBody();

        return "home";
    }

}

package com.artservicefrontend.artservicefrontend.Domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MutablePieceInformation implements PieceInformation {
    
    private Long id;

    @NotBlank(message = "Title required")
    private String title;

    @NotBlank(message = "Description required")
    private String description;

    @NotBlank(message = "Image URL required")
    private String imageUrl;

}

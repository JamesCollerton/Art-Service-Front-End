package com.artservicefrontend.artservicefrontend.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * This is the concrete implementation class for information around artwork pieces.
 */
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

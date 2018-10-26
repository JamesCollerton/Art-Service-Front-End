package com.artservicefrontend.artservicefrontend.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.artservicefrontend.artservicefrontend.domain.PieceInformation;

/**
 * The Feign client for interacting with the manipulating data service
 */
@FeignClient("art-service-manipulating-data-service")
public interface ArtServiceManipulatingDataClient {

    /**
     * This is used to retrieve all of the piece information from the manipulating data service
     *
     * @return Returns a list of piece information
     */
    @RequestMapping(method = RequestMethod.GET, value = "/pieces", consumes = "application/json")
    List<PieceInformation> getAllPieceInformation();
}

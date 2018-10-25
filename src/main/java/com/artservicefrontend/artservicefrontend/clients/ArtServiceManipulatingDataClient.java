package com.artservicefrontend.artservicefrontend.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.artservicefrontend.artservicefrontend.domain.PieceInformation;

@FeignClient("art-service-manipulating-data-service")
public interface ArtServiceManipulatingDataClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pieces", consumes = "application/json")
    List<PieceInformation> getAllPieceInformation();
}

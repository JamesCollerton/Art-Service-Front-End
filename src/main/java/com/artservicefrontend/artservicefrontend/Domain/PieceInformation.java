package com.artservicefrontend.artservicefrontend.Domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = MutablePieceInformation.class)
public interface PieceInformation {
}

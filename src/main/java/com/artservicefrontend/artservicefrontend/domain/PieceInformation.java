package com.artservicefrontend.artservicefrontend.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * This is the interface class for information around artwork pieces.
 */
@JsonDeserialize(as = MutablePieceInformation.class)
public interface PieceInformation {
}

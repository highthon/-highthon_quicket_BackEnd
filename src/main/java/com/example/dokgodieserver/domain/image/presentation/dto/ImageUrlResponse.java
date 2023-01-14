package com.example.dokgodieserver.domain.image.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ImageUrlResponse {

    private final List<String> imageUrl;
}

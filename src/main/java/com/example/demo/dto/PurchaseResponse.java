package com.example.demo.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PurchaseResponse {

    @NonNull
    private String orderTrackingNumber;

}

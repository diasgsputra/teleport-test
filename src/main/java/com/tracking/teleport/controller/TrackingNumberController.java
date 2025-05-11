package com.tracking.teleport.controller;

import com.tracking.teleport.response.TrackingNumberResponse;
import com.tracking.teleport.service.TrackingNumberService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tracking-number")
@RequiredArgsConstructor
public class TrackingNumberController {
  @Autowired
  private TrackingNumberService trackingNumberService;

  @GetMapping
  public ResponseEntity<TrackingNumberResponse> getTrackingNumber(
      @RequestParam("origin_country_id")
      @Parameter(description = "ID origin country", example = "MY")
      String originCountryId,

      @RequestParam("destination_country_id")
      @Parameter(description = "ID destination country", example = "ID")
      String destinationCountryId,

      @RequestParam("weight")
      @Parameter(description = "weight in kg", example = "1.234")
      Double weight,

      @RequestParam("created_at")
      @Parameter(
          description = "Time created on RFC 3339",
          example = "2025-05-10T18:06:46.5206666+07:00"
      )
      String createdAt,

      @RequestParam("customer_id")
      @Parameter(description = "UUID Customer", example = "de619854-b59b-425e-9db4-943979e1bd49")
      UUID customerId,

      @RequestParam("customer_name")
      @Parameter(description = "Customer Name", example = "RedBox Logistics")
      String customerName,

      @RequestParam("customer_slug")
      @Parameter(description = "Customer Slug", example = "redbox-logistics")
      String customerSlug
  ){
    return ResponseEntity.ok(trackingNumberService.generateTrackingNumber(originCountryId,
        destinationCountryId,
        weight,
        createdAt,
        customerId,
        customerName,
        customerSlug));
  }
}

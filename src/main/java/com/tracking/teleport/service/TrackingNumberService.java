package com.tracking.teleport.service;

import com.tracking.teleport.response.TrackingNumberResponse;

import java.util.UUID;

public interface TrackingNumberService {
  TrackingNumberResponse generateTrackingNumber(
      String originCountryId,
      String destinationCountryId,
      Double weight,
      String createdAtStr,
      UUID customerId,
      String customerName,
      String customerSlug
  );
}

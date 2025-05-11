package com.tracking.teleport.service;

import com.tracking.teleport.response.TrackingNumberResponse;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class TrackingNumberServiceImpl implements TrackingNumberService{

  public TrackingNumberResponse generateTrackingNumber(
      String originCountryId,
      String destinationCountryId,
      Double weight,
      String createdAtStr,
      UUID customerId,
      String customerName,
      String customerSlug
  ){
    // UUID → unique, similar length, and thread-safe
    String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

    // Add prefix
    String prefix = (originCountryId + destinationCountryId).toUpperCase();

    // Tracking number final: get 32 character
    String trackingNumber = (prefix + uuid).substring(0, 32);

    String now = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    TrackingNumberResponse response = new TrackingNumberResponse();
    response.setTrackingNumber(trackingNumber);
    response.setCreatedAt(now);
    return response;
  }


}

package com.tracking.teleport.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class TrackingNumberRequest {
  @JsonProperty("country_id")
  private String countryId;
  @JsonProperty("destination_country_id")
  private String destinationCountryId;
  private Double weight;
  @JsonProperty("customer_id")
  private UUID customerId;
  @JsonProperty("customer_name")
  private String customerName;
  @JsonProperty("customer_slug")
  private String customerSlug;

}

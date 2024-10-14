package guru.springframework.springaiintro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

/**
 * Created by jt, Spring Framework Guru.
 */
public record GetCapitalWithInfoResponse(
        @JsonProperty(required = true) @JsonPropertyDescription("The name of the city") String city,
        @JsonProperty(required = true)  @JsonPropertyDescription("The population of the city") Integer population,
        @JsonProperty(required = true)  @JsonPropertyDescription("The region the city is located in") String region,
        @JsonProperty(required = true)  @JsonPropertyDescription("The primary language spoken") String language,
        @JsonProperty(required = true)  @JsonPropertyDescription("The currency used") String currency){
}

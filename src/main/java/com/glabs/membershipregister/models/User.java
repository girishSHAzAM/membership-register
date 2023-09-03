package com.glabs.membershipregister.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String membershipId;
    private String name;
    private String mobileNumber;
    private String email;
    private MealPlan mealPlan;
    private Long startDate;
    private Boolean approved;
    private Boolean isActive;
    private Boolean chanceToApprove;
    private Long createdAt;
    private Long modifiedAt;
}

package com.glabs.membershipregister.Entity;

import com.glabs.membershipregister.models.MealPlan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.glabs.membershipregister.constants.Constants.MEMBERSHIP_REGISTER_COLLECTION;

@Data
@Document(collection = MEMBERSHIP_REGISTER_COLLECTION)
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String membershipId;
    private String name;
    private String mobileNumber;
    private String email;
    private MealPlan mealPlan;
    private Long startDate;
    private Long createdAt;
    private Long modifiedAt;
    private Boolean approved;
    private Boolean isActive;
    private Boolean chanceToApprove;
}

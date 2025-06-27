package com.example.backend_chat.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class SimpleUserDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("profilePicture")
    private String profilePicture;
    @JsonProperty("isOnline")
    private Boolean isOnline;
    public SimpleUserDTO(Long id, String firstName, String lastName, String email, String profilePicture, Boolean isOnline) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.isOnline = isOnline;
    }


}

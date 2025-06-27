package com.example.backend_chat.DTO;

import com.example.backend_chat.model.ENUM.ContactStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("contact")
    private SimpleUserDTO contact;
    @JsonProperty("status")
    private String status;
    public ContactResponse(Long id, SimpleUserDTO contact, ContactStatus status) {
        this.id = id;
        this.contact = contact;
        this.status = status.name(); // Convert enum to String if needed
    }

}

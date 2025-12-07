package io.shaikezam.model;

import lombok.Builder;

@Builder
public record UserDTO(
        Integer id,
        String firstName,
        String lastName,
        String city,
        String country,
        String phone1,
        String phone2,
        String email
) {
}
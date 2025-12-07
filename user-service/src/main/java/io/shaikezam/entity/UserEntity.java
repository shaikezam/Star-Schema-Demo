package io.shaikezam.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1)
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @NotNull
    @Size(min = 1)
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;

    @Column(name = "city", columnDefinition = "TEXT")
    private String city;

    @Column(name = "country", columnDefinition = "TEXT")
    private String country;

    @Column(name = "phone_1", columnDefinition = "TEXT")
    private String phone1;

    @Column(name = "phone_2", columnDefinition = "TEXT")
    private String phone2;

    @Email
    @Column(name = "email", columnDefinition = "TEXT")
    private String email;
}

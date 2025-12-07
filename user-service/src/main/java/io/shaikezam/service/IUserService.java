package io.shaikezam.service;

import io.shaikezam.model.UserDTO;

import java.util.Optional;

public interface IUserService {
    Optional<UserDTO> getUser(Integer userId);
}

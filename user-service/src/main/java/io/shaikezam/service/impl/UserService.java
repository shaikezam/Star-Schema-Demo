package io.shaikezam.service.impl;

import io.shaikezam.entity.UserEntity;
import io.shaikezam.mapper.IUserMapper;
import io.shaikezam.model.UserDTO;
import io.shaikezam.repository.UserRepository;
import io.shaikezam.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserService implements IUserService {

    private final UserRepository repository;
    private final IUserMapper mapper;

    @Override
    public Optional<UserDTO> getUser(Integer userId) {
        Objects.requireNonNull(userId);

        log.info("will get product productId {}", userId);
        Optional<UserEntity> entity = repository.findById(userId);
        return entity.map(mapper::toProductDTO);
    }
}

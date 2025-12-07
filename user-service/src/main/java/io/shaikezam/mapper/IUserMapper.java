package io.shaikezam.mapper;

import io.shaikezam.entity.UserEntity;
import io.shaikezam.model.UserDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IUserMapper {

    UserDTO toProductDTO(UserEntity userEntity);

    UserEntity toPUserEntity(UserDTO userDTO);

    List<UserDTO> toUserDTOs(List<UserEntity> entities);
}

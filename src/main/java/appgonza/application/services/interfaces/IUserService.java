package appgonza.application.services.interfaces;

import appgonza.application.dtos.UserDto;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserDto> getUsers();
    UserDto create(UserDto userDto);
    String delete(BigInteger userId);

    Optional<UserDto> getByDni(String dni);
    Optional<UserDto> getUserById(String userId);
}

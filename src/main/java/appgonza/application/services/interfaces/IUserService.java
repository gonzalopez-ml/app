package appgonza.application.services.interfaces;

import appgonza.application.dtos.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getUsers();
}

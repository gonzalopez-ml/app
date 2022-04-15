package appgonza.application.services;

import appgonza.application.dtos.UserDto;
import appgonza.application.models.User;
import appgonza.application.repositories.UserRepository;
import appgonza.application.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getUsers() {
        //mapeo al DTO
        return userRepository.findAll().stream().map(User -> mapper.map(User, UserDto.class)).collect(Collectors.toList());
    }
}

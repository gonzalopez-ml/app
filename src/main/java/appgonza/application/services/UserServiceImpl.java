package appgonza.application.services;

import appgonza.application.dtos.UserDto;
import appgonza.application.exceptions.UserAlReadyExistInDb;
import appgonza.application.exceptions.UsersNotFoundInDbException;
import appgonza.application.models.User;
import appgonza.application.repositories.UserRepository;
import appgonza.application.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        return this.userRepository.findAll().stream().map(User -> mapper.map(User, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(String userId) {
        return userRepository.findById(BigInteger.valueOf(Long.parseLong(userId))).map(user -> mapper.map(user, UserDto.class));
    }

    public Optional<UserDto> getByDni(String dni) {
        return userRepository.findByDni(dni).map(user -> mapper.map(user, UserDto.class));
    }

    @Override
    public UserDto create(UserDto userDto) {
        try {
            User userSave = this.userRepository.insert(mapper.map(userDto, User.class));
            return mapper.map(userSave, UserDto.class);
        }
        catch (Exception e) {
            throw new UserAlReadyExistInDb(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "User already exist in DB");
        }
    }

    @Override
    public String delete(BigInteger userId) {
        userRepository.deleteById(userId);
        return "Success";
    }
}

package appgonza.application.controllers;

import appgonza.application.dtos.UserDto;
import appgonza.application.exceptions.UsersNotFoundInDbException;
import appgonza.application.models.User;
import appgonza.application.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }


    @GetMapping("/list")
    @ResponseBody
    public List<UserDto> getUsers() {
        List<UserDto> list = iUserService.getUsers();
        if (!list.isEmpty()) {
            return list;
        } throw new UsersNotFoundInDbException(HttpStatus.NOT_FOUND.toString(), "Users not found in DB");
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public Optional<UserDto> getUserById(@PathVariable String userId) {
        Optional<UserDto> userDb = iUserService.getUserById(userId);
        if (userDb.isPresent()) {
            return userDb;
        } throw new UsersNotFoundInDbException(HttpStatus.NOT_FOUND.toString(), "Users not found in DB");
    }

    @GetMapping("/dni/{dni}")
    @ResponseBody
    public Optional<UserDto> getByDni(@PathVariable String dni) {
        Optional<UserDto> userDb = iUserService.getByDni(dni);
        if (userDb.isPresent()) {
            return userDb;
        } throw new UsersNotFoundInDbException(HttpStatus.NOT_FOUND.toString(), "Users not found in DB");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public UserDto create(@Valid @RequestBody UserDto userDto) {
        return iUserService.create(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/delete/{userId}")
    public String delete(@Valid @PathVariable("userId") BigInteger userId) {
        return iUserService.delete(userId);
    }

    //ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

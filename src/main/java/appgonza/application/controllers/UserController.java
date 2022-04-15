package appgonza.application.controllers;

import appgonza.application.dtos.UserDto;
import appgonza.application.exceptions.UsersNotFoundInDbException;
import appgonza.application.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

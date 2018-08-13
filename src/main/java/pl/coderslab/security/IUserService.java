package pl.coderslab.security;

import pl.coderslab.entity.security.User;
import pl.coderslab.model.security.UserDto;
import pl.coderslab.validation.security.EmailExistsException;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto)
            throws EmailExistsException;
}
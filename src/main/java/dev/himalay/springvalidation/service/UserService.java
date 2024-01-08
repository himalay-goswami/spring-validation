package dev.himalay.springvalidation.service;

import dev.himalay.springvalidation.dao.UserRepository;
import dev.himalay.springvalidation.dto.UserRequestDto;
import dev.himalay.springvalidation.entity.User;
import dev.himalay.springvalidation.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequestDto userRequestDto){

        User user = User.build(0, userRequestDto.getName(),
                userRequestDto.getEmail(), userRequestDto.getMobile(),
                userRequestDto.getGender(), userRequestDto.getAge(),
                userRequestDto.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public User getUserById(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("user not found with id: " +id);
        }
    }
}

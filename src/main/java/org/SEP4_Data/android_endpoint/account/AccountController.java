package org.SEP4_Data.android_endpoint.account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.AccountService;
import org.SEP4_Data.service.model.source.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    @NonNull
    private AccountService service;


    @PostMapping(path ="/login",consumes = "application/json")
    public boolean login(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        boolean valid = service.validateLogin(user);
        return valid;
    }


    @PostMapping(path = "/createAccount",consumes = "application/json") //localhost:8080/createAccount?username=C &password=c
    public ResponseEntity createAccount(@RequestBody UserDTO userDTO)
    {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        System.out.println("user  " + user.getUsername());
        if (service.validateCreateAccount(user))
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

}

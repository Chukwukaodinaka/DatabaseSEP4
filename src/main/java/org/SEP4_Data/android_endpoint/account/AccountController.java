package org.SEP4_Data.android_endpoint.account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.SEP4_Data.service.AccountService;
import org.SEP4_Data.service.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    @NonNull
    private AccountService service;

    @GetMapping("/login")
    public boolean login(@RequestBody User user){
        boolean valid = service.validateLogin(user);

        return valid;
    }


    @PostMapping(path = "/createAccount",consumes = "application/json") //localhost:8080/createAccount?username=C &password=c
    public HttpStatus createAccount(@RequestBody User user)
    {
        System.out.println("user  " + user.getUsername());
        if (service.validateCreateAccount(user))
        {
            return HttpStatus.CREATED;
        }
        else
        {
            return HttpStatus.BAD_REQUEST;
        }

    }

}

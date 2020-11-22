package org.SEP4_Data.android_endPoint_createAccount;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAccountController
{
    @ResponseBody
    @GetMapping("/createAccount") //localhost:8080/createAccount?username=C &password=c
    public HttpStatus createAccount(@RequestParam String username,@RequestParam String password)
    {
        System.out.println("user  " + username + password);
        if (true) //todo account doesnt exist)
        {

            return HttpStatus.CREATED;
        }
        else
        {
            return HttpStatus.IM_USED;
        }

    }
}

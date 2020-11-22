package org.SEP4_Data.service;

import org.SEP4_Data.service.model.User;
import org.SEP4_Data.service.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repository;

    public boolean validateLogin(User user){

        User searchU = repository.findUser(user.getUsername(), user.getPassword());

        if (searchU!=null)
            return true;
        else
            return false;
    }

    public boolean validateCreateAccount(User user)
    {
        if (repository.findUsername(user.getUsername()) == null)
        {
            repository.createAccount(user.getId(),user.getUsername(),user.getPassword());
            System.out.println(repository.findUsername(user.getUsername()));
            return true;
        }
        return false;
    }


}

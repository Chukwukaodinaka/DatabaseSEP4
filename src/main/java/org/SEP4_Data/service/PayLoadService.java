package org.SEP4_Data.service;

import org.SEP4_Data.service.model.PayLoad;
import org.SEP4_Data.service.repository.PayLoadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayLoadService {

    @Autowired
    private PayLoadRepo payLoadRepo;


    public void addToDataBase(PayLoad payLoad){
        payLoadRepo.save(payLoad);

    }
}

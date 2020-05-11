package com.shop.uid.service;

import com.xfvape.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UidService {
    @Autowired
    UidGenerator uidGenerator;

    public long getUID(){
        return uidGenerator.getUID();
    }


}

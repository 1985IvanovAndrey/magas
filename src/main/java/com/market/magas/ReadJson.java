package com.market.magas;

import com.market.magas.services.GetBirdFromFarmServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class ReadJson {
    @Autowired
    private GetBirdFromFarmServices getBirdFromFarmServices;


    @PostConstruct
    public void readFromJson(){
        getBirdFromFarmServices.getBirdFromFarInDB();
    }
}

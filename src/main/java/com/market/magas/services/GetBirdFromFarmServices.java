package com.market.magas.services;

import com.market.magas.dto.BirdDto;
import com.market.magas.dto.BirdListDto;
import com.market.magas.entity.BirdEntityInMagaz;
import com.market.magas.repository.BirdEntityInMagazReposiotory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
@Log4j2
public class GetBirdFromFarmServices {

    @Autowired
    private BirdEntityInMagazReposiotory birdEntityInMagazReposiotory;

    private static final String FARM_ULR = "http://localhost:8081/getall";


    public List<BirdDto> getBirdFromFarInDB() {
        RestTemplate restTemplate = new RestTemplate();

        BirdListDto birdListDto = restTemplate
                .getForObject(FARM_ULR, BirdListDto.class);

        log.info(" restTemplate result {}", birdListDto);

        List<BirdDto> birdDtos = new ArrayList<>();
        for (BirdDto birdDto : birdListDto.getBirdDtoList()) {
            birdDtos.add(birdDto);
        }
        for (BirdDto birdDto : birdListDto.getBirdDtoList()) {
            BirdEntityInMagaz birdEntityInMagaz=new BirdEntityInMagaz();
            birdEntityInMagaz.setBirdType(birdDto.getType());
            birdEntityInMagaz.setWeight(birdDto.getWeight());
            birdEntityInMagaz.setPricePerUnit(birdDto.getPricePerUnit()+5);
            birdEntityInMagazReposiotory.save(birdEntityInMagaz);
        }
        return birdDtos;
    }
    public List<BirdDto>getBird(String type){
        List<BirdDto>birdDtoList=new ArrayList<>();
        for (BirdEntityInMagaz birdEntityInMagaz : birdEntityInMagazReposiotory.findAll()){
            if (birdEntityInMagaz.getBirdType().equals(type)) {
                BirdDto birdDto = new BirdDto();
                birdDto.setWeight(birdEntityInMagaz.getWeight());
                birdDto.setPricePerUnit(birdEntityInMagaz.getPricePerUnit());
                birdDto.setType(birdEntityInMagaz.getBirdType());
                //System.out.println(birdDto.getType());
                birdDtoList.add(birdDto);
            }
        }
      log.info("Print birds={}",type);
        return birdDtoList;
    }
    public List<BirdDto>getAll(){
        List<BirdDto>birdDtoList1=new ArrayList<>();
        for (BirdEntityInMagaz birdEntityInMagaz : birdEntityInMagazReposiotory.findAll()){
                BirdDto birdDto = new BirdDto();
                birdDto.setWeight(birdEntityInMagaz.getWeight());
                birdDto.setPricePerUnit(birdEntityInMagaz.getPricePerUnit());
                birdDto.setType(birdEntityInMagaz.getBirdType());
                birdDtoList1.add(birdDto);
        }
        return birdDtoList1;
    }
}

package com.market.magas.controller;

import com.market.magas.dto.BirdDto;
import com.market.magas.services.GetBirdFromFarmServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/magazine")
public class MagazineController {

    @Autowired
    private GetBirdFromFarmServices getBirdFromFarmServices;
    List<BirdDto>parrotList=new ArrayList<>();
    List<BirdDto>duckList=new ArrayList<>();
    List<BirdDto>eaglList=new ArrayList<>();
    List<BirdDto>birdList=new ArrayList<>();
    String comment=null;
    String comment1=null;



    @GetMapping()
    private String listBirds(Model model) {
        model.addAttribute("birdList",birdList);
        model.addAttribute("parrotList",parrotList);
        model.addAttribute("duckList",duckList);
        model.addAttribute("eaglList",eaglList);
        model.addAttribute("comment",comment);
        comment=comment1;
        return "index";
    }
    @GetMapping("/getBirdByType")
    public String getBird(@RequestParam("type")String type){
      birdList=getBirdFromFarmServices.getBird(type);
      if (birdList.size()==0)
        comment="No this type birds in shop";
        return "redirect:/magazine";
    }
}

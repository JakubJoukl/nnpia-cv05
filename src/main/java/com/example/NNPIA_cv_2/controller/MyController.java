package com.example.NNPIA_cv_2.controller;

import com.example.NNPIA_cv_2.service.KittenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.NNPIA_cv_2.entity.Kitten;

import java.util.List;

@RestController
@RequestMapping("/kittens")
public class MyController {

    @Autowired
    private KittenService kittenService;

    @GetMapping(value = "")
    public List<Kitten> kittens(){
        return kittenService.getKittens();
    }

    @GetMapping(value = "/kitten")
    public Kitten kittens(@RequestParam int kittenId){
        return kittenService.getKitten(kittenId);
    }
}

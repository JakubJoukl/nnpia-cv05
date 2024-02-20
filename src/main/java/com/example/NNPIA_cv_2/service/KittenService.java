package com.example.NNPIA_cv_2.service;

import com.example.NNPIA_cv_2.entity.Kitten;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class KittenService implements IKittenService {
    private HashMap<Integer, Kitten> kittens = new HashMap<>();

    public KittenService(){
        kittens.put(1, new Kitten("Pawns", 1, 5));
        kittens.put(2, new Kitten("Mittens", 2, 4));
        kittens.put(3,new Kitten("Shadow", 3, 10));
    }

    public Kitten getKitten(int id){
        return kittens.get(id);
    }

    public List<Kitten> getKittens(){
        List<Kitten> kittens = new ArrayList<>();
        this.kittens.forEach((integer, kitten) -> kittens.add(kitten));
        return kittens;
    }
}

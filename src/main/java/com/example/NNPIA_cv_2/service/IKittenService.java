package com.example.NNPIA_cv_2.service;

import com.example.NNPIA_cv_2.entity.Kitten;

import java.util.List;

public interface IKittenService {
    public List<Kitten> getKittens();
    public Kitten getKitten(int id);
}

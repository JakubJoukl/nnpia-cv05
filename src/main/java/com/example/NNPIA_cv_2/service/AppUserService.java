package com.example.NNPIA_cv_2.service;

import com.example.NNPIA_cv_2.entity.AppUser;
import com.example.NNPIA_cv_2.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    public List<AppUser> findByActive(boolean active){
        return appUserRepository.findByActive(active);
    }

    public Optional<AppUser> findById(int id){
        return appUserRepository.findById(id);
    }
    public List<AppUser> findUsersByRole(int roleId){
        return appUserRepository.findUsersByRole(roleId);
    }
}

package com.example.NNPIA_cv_2.repository;

import com.example.NNPIA_cv_2.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private AppUserRepository appUserRepository;

    @Autowired
    public DataLoader(AppUserRepository userRepository) {
        this.appUserRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        /*AppUser appUser = new AppUser();
        appUser.setActive(true);
        appUser.setPassword("passwordddddddd");
        appUser.setUsername("Jmeno dlouheasdaasd");
        appUser.setCreationDate(new Date(2024,2,5));
        appUserRepository.save(appUser);

        AppUser appUser2 = new AppUser();
        appUser2.setActive(true);
        appUser2.setPassword("adsjdidfa");
        appUser2.setUsername("DalsiUser");
        appUser2.setCreationDate(new Date(2024,2,10));
        appUserRepository.save(appUser2);*/
    }
}
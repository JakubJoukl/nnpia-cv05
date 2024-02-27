package com.example.NNPIA_cv_2.controller;

import com.example.NNPIA_cv_2.entity.AppUser;
import com.example.NNPIA_cv_2.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Rozdíl mezi anotacemi je, že anotace @RestController slouží k označení kontrolerů, které vrací odpovědi ve formátu JSON, SOAP, XML, slouží ke komunikaci s jinou službou nebo stránkou
//Anotace @Controller slouží ke zpracování a vracení HTTP požadavků pro zobrazení HTML stránek například pro návštěvníka stránky
/*
* syntaxe XML, JSON a se liší strukturou
* XML - připomíná formát HTML dokumentů, atributy (případně vnořené třídy) jsou jako tagy, ve kterých je hodnota, značkovací jazyk, velký overhead
* JSON - menší overhead než XML, atributy jsou jako key: value v mapě
* YAML - nejmenší overhead - atributy jsou jako key: value, data formátována pomocí odsazení
* */
@RestController
public class HelloController {

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("")
    public String helloWorld() {
        return "Hello world from Spring Boot application.";
    }

    @GetMapping("/snow")
    public String snow(@RequestParam String name) {
        return "Hello Snow owner " + name;
    }

    @RequestMapping(value = "/mittens", method = RequestMethod.GET)
    public String mittens(@RequestParam String name) {
        return "Hello Mittens owner " + name;
    }

    @RequestMapping(value = "/pawns")
    public String pawns(@RequestParam String name) {
        return "Hello Pawns owner " + name;
    }

    @GetMapping(value = "/appUsers")
    public List<AppUser> appUsers(@RequestParam boolean active){
        return appUserRepository.findByActive(active);
    }

    @PostMapping(value = "/insertAppUser")
    public boolean insertAppUser(@RequestBody AppUser appUser){
        if(appUserRepository.existsById(appUser.getId())){
            return false;
        } else {
            appUserRepository.save(appUser);
            return true;
        }
    }

    @GetMapping(value = "/getUsersByRole")
    public List<AppUser> getUsersByRole(@RequestParam int roleId){
        return appUserRepository.findUsersByRole(roleId);
    }
}

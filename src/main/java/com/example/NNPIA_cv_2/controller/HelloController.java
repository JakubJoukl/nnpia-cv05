package com.example.NNPIA_cv_2.controller;

import org.springframework.web.bind.annotation.*;


//Rozdíl mezi anotacemi je, že anotace @RestController slouží k označení kontrolerů, které vrací odpovědi ve formátu JSON, SOAP, XML, slouží ke komunikaci s jinou službou nebo stránkou
//Anotace @Controller slouží ke zpracování a vracení HTTP požadavků pro zobrazení HTML stránek například pro návštěvníka stránky
@RestController
@RequestMapping("/api/v1")
public class HelloController {
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
}

package com.sipas.app.controller;

import com.sipas.app.service.DiagnosisPenyakitService;
import com.sipas.app.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasienController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;

    @GetMapping("/")
    public String home(){
        return "beranda";
    }
}

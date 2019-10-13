package com.sipas.app.controller;

import com.sipas.app.service.DiagnosisPenyakitService;
import com.sipas.app.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiagnosisPenyakitController {

    @Autowired
    private PasienService pasienService;

    @Autowired
    private DiagnosisPenyakitService diagnosisPenyakitService;
}

package com.sprint2.src.dataBase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class Api_dataBase {

    private int id_con ;
    private int id_cha ;
    GuardaInfo infoPuxada = new GuardaInfo(id_con,id_cha);

    @GetMapping("/pegar")
    public String info(@RequestParam int id_con , @RequestParam int id_cha) {
        this.id_con = id_con;
        this.id_cha = id_cha;

        return "";
    }


}

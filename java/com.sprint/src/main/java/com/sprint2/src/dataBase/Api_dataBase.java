package com.sprint2.src.dataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class Api_dataBase {

    private int id_con ;
    private int id_clie ;
    private String id_meet;
    private LocalDateTime dt_conv;

    GuardaInfo infoPuxada = new GuardaInfo(id_con,id_clie,id_meet,dt_conv);

    @Autowired
    private JdbcTemplate jdbc;

    @GetMapping("/pegar")
    public List<Map<String, Object>> pegar(@RequestParam int id_con) {

        //Scanner input = new Scanner(System.in);
        //System.out.println("escreva o indice da conversa que quiser saber os dados: ");
        id_con = 1;

        String sql = "SELECT id_conv, id_clie, id_meet, dt_conv FROM conv WHERE id_conv = ?";

        return jdbc.queryForList(sql, id_con);
    }


}

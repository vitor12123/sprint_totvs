package com.sprint2.src.dataBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class GuardaInfo {
    private int id_conversa;
    private String id_cliente;
    private int id_reuniao;
    private Date data_conversa;

    public GuardaInfo(int id_conversa, String id_clie, int id_meet, Date dt_conv) {
        this.id_conversa = id_conversa;
        this.id_cliente = id_clie;
        this.id_reuniao = id_meet;
        this.data_conversa = dt_conv;
    }

    public String getId_clie() {
        return id_cliente;
    }

    public int getId_meet() {
        return id_reuniao;
    }

    public Date getDt_conv() {
        return data_conversa;
    }

    public int getId_conversa() {
        return id_conversa;
    }
}

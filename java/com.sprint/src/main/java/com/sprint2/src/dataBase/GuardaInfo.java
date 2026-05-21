package com.sprint2.src.dataBase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GuardaInfo {
    private int id_conversa;
    private int id_cliente;
    private String id_reuniao;
    private LocalDateTime data_conversa;

    public GuardaInfo(int id_conversa, int id_clie, String id_meet, LocalDateTime dt_conv) {
        this.id_conversa = id_conversa;
        this.id_cliente = id_clie;
        this.id_reuniao = id_meet;
        this.data_conversa = dt_conv;
    }

    public int getId_clie() {
        return id_cliente;
    }

    public String getId_meet() {
        return id_reuniao;
    }

    public LocalDateTime getDt_conv() {
        return data_conversa;
    }

    public int getId_conversa() {
        return id_conversa;
    }
}

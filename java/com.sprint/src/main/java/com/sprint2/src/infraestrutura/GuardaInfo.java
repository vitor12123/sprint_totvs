package com.sprint2.src.infraestrutura;

import java.util.Date;

public class GuardaInfo {
    private int id_conversa;
    private String id_cliente;
    private String nota_nps_reu;
    private Date data_conversa;
    private String transcricao;

    public GuardaInfo(int id_conversa, String id_clie, String nota, Date dt_conv, String transcricao) {
        this.id_conversa = id_conversa;
        this.id_cliente = id_clie;
        this.nota_nps_reu = nota;
        this.data_conversa = dt_conv;
        this.transcricao = transcricao;
    }

    public String getId_clie() {
        return id_cliente;
    }

    public String getNota_nps() {
        return nota_nps_reu;
    }

    public Date getDt_conv() {
        return data_conversa;
    }

    public int getId_conversa() {
        return id_conversa;
    }

    public String getTranscricao() {
        return transcricao;
    }
}

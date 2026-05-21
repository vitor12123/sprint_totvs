package com.sprint2.src.dataBase;

public class GuardaInfo {
    private int id_conversa;
    private int id_chamada;

    public GuardaInfo(int id_conversa, int id_chamada) {
        this.id_conversa = id_conversa;
        this.id_chamada = id_chamada;
    }

    public int getId_chamada() {
        return id_chamada;
    }

    public int getId_conversa() {
        return id_conversa;
    }
}

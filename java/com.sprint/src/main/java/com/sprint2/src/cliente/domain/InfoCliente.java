package com.sprint2.src.cliente.domain;

public class InfoCliente {

    private static String email;
    private String senha;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


}

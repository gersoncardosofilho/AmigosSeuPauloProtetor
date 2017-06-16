package com.example.gerso.amigosseupauloprotetor.activity.models;

/**
 * Created by gerso on 6/16/2017.
 */

public class Banco {
    String nomeBanco;
    String numeroAgencia;
    String numeroConta;
    String tipoConta;
    String cpf;
    int imageBanco;

    public Banco(String nomeBanco, String numeroAgencia, String numeroConta, String tipoConta, String cpf, int imageBanco) {
        this.nomeBanco = nomeBanco;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.cpf = cpf;
        this.imageBanco = imageBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getImageBanco() {
        return imageBanco;
    }

    public void setImageBanco(int imageBanco) {
        this.imageBanco = imageBanco;
    }
}

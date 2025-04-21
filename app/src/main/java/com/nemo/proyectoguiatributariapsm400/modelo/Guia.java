package com.nemo.proyectoguiatributariapsm400.modelo;

public class Guia {
    public int nroGuia;
    public String descripsionGuia;
    public String imgGuia;

    public Guia(int nroGuia, String descripsionGuia, String imgGuia) {
        this.nroGuia = nroGuia;
        this.descripsionGuia = descripsionGuia;
        this.imgGuia = imgGuia;
    }

    public int getNroGuia() {
        return nroGuia;
    }

    public void setNroGuia(int nroGuia) {
        this.nroGuia = nroGuia;
    }

    public String getDescripsionGuia() {
        return descripsionGuia;
    }

    public void setDescripsionGuia(String descripsionGuia) {
        this.descripsionGuia = descripsionGuia;
    }

    public String getImgGuia() {
        return imgGuia;
    }

    public void setImgGuia(String imgGuia) {
        this.imgGuia = imgGuia;
    }
}

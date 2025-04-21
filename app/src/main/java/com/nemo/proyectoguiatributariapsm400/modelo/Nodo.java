package com.nemo.proyectoguiatributariapsm400.modelo;

public class Nodo {
    public Guia dato;
    public Nodo sig;

    public Nodo() {
        this.sig = null;
    }

    public Guia getDato() {
        return dato;
    }

    public void setDato(Guia dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}

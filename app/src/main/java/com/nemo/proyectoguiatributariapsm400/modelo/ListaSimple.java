package com.nemo.proyectoguiatributariapsm400.modelo;

public class ListaSimple {
    public Nodo p;

    public ListaSimple() {
        this.p = null;
    }

    public Nodo getP() {
        return p;
    }

    public void setP(Nodo p) {
        this.p = p;
    }

    public boolean esVacia() {
        return this.getP() == null;
    }

    public void adiInicio(Guia guia) {
        Nodo nue = new Nodo();
        nue.setDato(guia);
        nue.setSig(this.getP());
        this.setP(nue);
    }

    public void adiFinal(Guia guia) {
        Nodo nue = new Nodo();
        nue.setDato(guia);
        if (esVacia()) {
            this.setP(nue);
        } else {
            Nodo r = this.getP();
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.setSig(nue);
        }
    }

    public void eliInicio() {
        if (this.getP() != null) {
            Nodo r = this.getP();
            this.setP(this.getP().getSig());
            r = null;
        }
    }

    public void eliFinal() {
        if (this.getP() != null) {
            Nodo r = this.getP();
            Nodo w = this.getP();
            if (r.getSig() == null) {
                this.setP(null);
            } else {
                while (r.getSig() != null) {
                    w = r;
                    r = r.getSig();
                }
                w.setSig(null);
                r = null;
            }
        }
    }
}

package com.nemo.proyectoguiatributariapsm400.modelo;

public class DatosGuia {

    public ListaSimple guiaInicioSecion;
    public ListaSimple guiaForm110;
    public ListaSimple guiaForm610;
    public ListaSimple guiaForm200;
    public ListaSimple guiaForm400;
    public ListaSimple guiaRCIVA;

    public DatosGuia() {
        this.guiaInicioSecion = new ListaSimple();
        this.guiaForm110 = new ListaSimple();
        this.guiaForm610 = new ListaSimple();
        this.guiaForm200 = new ListaSimple();
        this.guiaForm400 = new ListaSimple();
        this.guiaRCIVA = new ListaSimple();
        cargarDatosInicioSecion();
        cargarDatosForm110();
        cargarDatosForm610();
        cargarDatosForm200();
        cargarDatosForm400();
        cargarDatosRCIVA();
    }

    public void cargarDatosInicioSecion() {
        this.guiaInicioSecion.adiFinal(new Guia(1, "Debe ingresar al siguiente sitio web https://www.impuestos.gob.bo", "imgform110_01"));
        this.guiaInicioSecion.adiFinal(new Guia(2, "Seleccione la opcion \"Siat en linea\".", "imgform110_01"));
        this.guiaInicioSecion.adiFinal(new Guia(3, "En la Siguiente seccion elija la opcion: \"Sistema integrado de la administracion tributaria\".","imgform110_02"));
    }

    public void cargarDatosForm110() {

    }

    public void cargarDatosForm610() {

    }

    public void cargarDatosForm200() {

    }

    public void cargarDatosForm400() {

    }

    public void cargarDatosRCIVA() {

    }

    public int obtenerCantidadGuias(ListaSimple listaGuia){
        int cont=0;
        Nodo r = listaGuia.getP();
        while (r != null){
            cont++;
            r = r.getSig();
        }
        return cont;
    }

    public String obtenerDescripsionGuia(int nroGuia, ListaSimple listaGuia) {
        String descripsion = "";
        Nodo r = listaGuia.getP();
        while (r != null) {
            Guia x = r.getDato();
            if (x.getNroGuia() == nroGuia) {
                descripsion = x.getDescripsionGuia();
            }
            r = r.getSig();
        }
        return descripsion;
    }

    public String obtenerRutaImgGuia(int nroGuia, ListaSimple listaGuia) {
        String rutaImgGuia = "";
        Nodo r = listaGuia.getP();
        while (r != null) {
            Guia x = r.getDato();
            if (x.getNroGuia() == nroGuia) {
                rutaImgGuia = x.getImgGuia();
            }
            r = r.getSig();
        }
        return rutaImgGuia;
    }

    public ListaSimple getGuiaInicioSecion() {
        return guiaInicioSecion;
    }

    public ListaSimple getGuiaForm110() {
        return guiaForm110;
    }

    public ListaSimple getGuiaForm610() {
        return guiaForm610;
    }

    public ListaSimple getGuiaForm200() {
        return guiaForm200;
    }

    public ListaSimple getGuiaForm400() {
        return guiaForm400;
    }

    public ListaSimple getGuiaRCIVA() {
        return guiaRCIVA;
    }
}

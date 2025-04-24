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
        this.guiaInicioSecion.adiFinal(
                new Guia(1, "Debe ingresar al siguiente sitio web https://www.impuestos.gob.bo", "imgforminicio_01"));
        this.guiaInicioSecion.adiFinal(
                new Guia(2, "Seleccione la opcion \"Siat en linea\".", "imgforminicio_01"));
        this.guiaInicioSecion.adiFinal(
                new Guia(3, "En la siguiente seccion elija la opcion: \"Sistema integrado de la administracion tributaria\".", "imgforminicio_02"));
        this.guiaInicioSecion.adiFinal(
                new Guia(4, "En la parte inferior del inicio de secion presione en: \"Autenticarse SIAT en linea v2\".", "imgforminicio_03"));
        this.guiaInicioSecion.adiFinal(
                new Guia(5, "Finalmente para iniciar secion introdusca sus datos de usuario", "imgforminicio_04"));
        this.guiaInicioSecion.adiFinal(
                new Guia(6, "Posteriormente se le enviara un codigo de verificacion a su correo electronico de inicio de sesion.", "imgforminicio_05"));
        this.guiaInicioSecion.adiFinal(
                new Guia(7, "Revise su correo y debe de recivir un codigo de validacion como en el siguiente ejemplo.", "imgforminicio_06"));
        this.guiaInicioSecion.adiFinal(
                new Guia(8, "Por ultimo, una ves validado el codigo de verificacion se abrira la siguiente seccion de opciones", "imgforminicio_07"));
    }

    public void cargarDatosForm110() {
        this.guiaForm110.adiFinal(
                new Guia(1, "Una ves que usted haya seleccionado la opcion RC-IVA se abrira la siguiente ventana y seleccione \"Formulario 110 de Dependientes\":", "imgform110_01"));
        this.guiaForm110.adiFinal(
                new Guia(2, "Luego se abrira el formulario 110 de Dependientes en el cual se observa el formulario de cada gestion y seleccione:", "imgform110_02"));
        this.guiaForm110.adiFinal(
                new Guia(3, "Posteriormente se desplegara una lista de formularios de la gestion seleccionada", "imgform110_03"));
        this.guiaForm110.adiFinal(
                new Guia(4, "Si desea imprimir el informe a un periodo especifico, debe seleccionar los tres puntos que se encuentran al final de cada fila.", "imgform110_03"));
        this.guiaForm110.adiFinal(
                new Guia(5, "Para crear un nuevo formulario 110 seleccione la opcion \"Nuevo formulario Dependiente\".", "imgform110_03"));
        this.guiaForm110.adiFinal(
                new Guia(6, "Llene los datos solicitados y presione en \"guardar cambios\".", "imgform110_04"));
        this.guiaForm110.adiFinal(
                new Guia(7, "Una ves confirmada la operacion se mostrara la siguiente notificacion.", "imgform110_05"));
        this.guiaForm110.adiFinal(
                new Guia(8, "Luego podremos observar las facturas electronicas de compras registradas.", "imgform110_06"));
        this.guiaForm110.adiFinal(
                new Guia(9, "Asi mismo podremos registrar facturas seleccionando la opcion \"Registrar Factura\".", "imgform110_06"));
        this.guiaForm110.adiFinal(
                new Guia(10, "Se abrira la siguiente seccion para agregar el registro de compra y procedemos a llenar los campos.", "imgform110_07"));
        this.guiaForm110.adiFinal(
                new Guia(11, "Finalmente presionamos en \"Registrar\".", "imgform110_07"));
    }

    public void cargarDatosForm610() {

    }

    public void cargarDatosForm200() {

    }

    public void cargarDatosForm400() {

    }

    public void cargarDatosRCIVA() {

    }

    public int obtenerCantidadGuias(ListaSimple listaGuia) {
        int cont = 0;
        Nodo r = listaGuia.getP();
        while (r != null) {
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

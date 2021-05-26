class Sugerencia {
    Prenda prendaDeSugerencia;
    Boolean aceptado;
    Usuario destinatario;

    void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    void aceptar() {
        aceptado = true;
    }

    void rechazar() {
        aceptado = false;
    }

    void revertirEfecto() {
        aceptado = !aceptado;
    }
}

class Agregar extends Sugerencia {

    void aceptar() {
        destinatario.agregarPrenda(prendaDeSugerencia);
        super.aceptar();
    }

    void revertirEfecto() {
        destinatario.quitarPrenda(prendaDeSugerencia);
        super.revertirEfecto();
    }
}

class Remover extends Sugerencia {

    void aceptar() {
        destinatario.quitarPrenda(prendaDeSugerencia);
        super.aceptar();
    }

    void revertirEfecto() {
        destinatario.agregarPrenda(prendaDeSugerencia);
        super.revertirEfecto();
    }
}
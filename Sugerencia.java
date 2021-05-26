

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
}

class Agregar extends Sugerencia {
    void aceptar() {
        destinatario.agregarPrenda(prendaDeSugerencia);
        super.aceptar();
    }
}

class Remover extends Sugerencia {
    void aceptar() {
        destinatario.quitarPrenda(prendaDeSugerencia);
        super.aceptar();
    }
}
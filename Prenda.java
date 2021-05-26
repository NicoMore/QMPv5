
abstract class Prenda {
    String tipo;
    String material;
    String trama;
    String color;
    String colorSecundario;
    Temperatura temperatura;

    void setSiNullMaterial(String material) {
        if (this.material == null) {
            this.material = material;
        }
    }

    void setSiNullColor(String color) {
        if (this.color == null) {
            this.color = color;
        }
    }

    void setSiNullColorSecundario(String colorSecundario) {
        if (this.colorSecundario == null) {
            this.colorSecundario = colorSecundario;
        }
    }

    void setSiNullTemperatura(Temperatura temperatura) {
        if (this.temperatura == null) {
            this.temperatura = temperatura;
        }
    }

    public float getGradosMaximos() {
        return temperatura.getGrados();
    }
}

class PrendaSuperior extends Prenda {
    PrendaSuperior(String tipo) {
        this.tipo = tipo;
    }
}

class PrendaInferior extends Prenda {
    PrendaInferior(String tipo) {
        this.tipo = tipo;
    }
}

class Calzado extends Prenda {
    Calzado(String tipo) {
        this.tipo = tipo;
    }
}

class Accesorio extends Prenda {
    Accesorio(String tipo) {
    this.tipo = tipo;
    }
}

class PrendaFallada extends Prenda {
}
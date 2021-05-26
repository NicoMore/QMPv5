import java.util.ArrayList;
import java.util.List;

class Guardarropa {
    List<Atuendo> atuendos = new ArrayList<>();
    String descripcion;

    Guardarropa(List<Atuendo> atuendos) {
        this.atuendos = atuendos;
    }

    Guardarropa(List<Atuendo> atuendos, String descripcion) {
        this.atuendos = atuendos;
        this.descripcion = descripcion;
    }
}

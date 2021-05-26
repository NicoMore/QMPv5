import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Atuendo {
    PrendaSuperior prendaSuperior;
    PrendaInferior prendaInferior;
    Calzado calzado;
    List<Accesorio> accesorios = new ArrayList<>();

    Atuendo(PrendaSuperior prendaSuperior, PrendaInferior prendaInferior, Calzado calzado, List<Accesorio> accesorios) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
        this.accesorios = accesorios;
    }
}

class Uniforme extends Atuendo {

    Uniforme(PrendaSuperior prendaSuperior, PrendaInferior prendaInferior, Calzado calzado) {
        super(prendaSuperior, prendaInferior, calzado, Collections.emptyList());
    }

    static Uniforme fabricarUniforme(Sastre sastre) {
        return new Uniforme(sastre.fabricarPrendaSuperior(), sastre.fabricarPrendaInferior(), sastre.fabricarCalzado());
    }

}
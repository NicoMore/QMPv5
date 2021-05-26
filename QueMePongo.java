import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class QueMePongo { 
    ArrayList<Prenda> prendasCreadas = new ArrayList<>();
    ArrayList<Uniforme> uniformesSugeridos = new ArrayList<>();
    
    List<Prenda> getPrendasSuperiores() {
        return prendasCreadas.stream().filter(unaPrenda -> unaPrenda.getClass() == PrendaSuperior.class).collect(Collectors.toList());
    }

    List<Prenda> getPrendasInferiores() {
        return prendasCreadas.stream().filter(unaPrenda -> unaPrenda.getClass() == PrendaInferior.class).collect(Collectors.toList());
    }

    List<Prenda> getCalzados() {
        return prendasCreadas.stream().filter(unaPrenda -> unaPrenda.getClass() == Calzado.class).collect(Collectors.toList());
    }

    List<Prenda> getAccesorios() {
        return prendasCreadas.stream().filter(unaPrenda -> unaPrenda.getClass() == Accesorio.class).collect(Collectors.toList());
    }

    void agregarUniforme(Uniforme unUniforme) {
        uniformesSugeridos.add(unUniforme);
    }

    void agregarPrenda(Prenda unaPrenda) {
        prendasCreadas.add(unaPrenda);
    }

    List<Prenda> filtrarPorTemperatura(List<Prenda> unaListaDePrendas, Temperatura unaTemperatura) {
        return unaListaDePrendas.stream().filter(unaPrenda -> unaPrenda.getGradosMaximos() < unaTemperatura.getGrados()).collect(Collectors.toList());
    }

    Prenda crearPrenda() {
        Prenda prenda = BuilderPrenda.crearPrenda();
        agregarPrenda(prenda);
        
        return prenda;
    }

    Uniforme recibirSugerenciaUniforme() {
        return uniformesSugeridos.get(numeroRandomSegunLista(uniformesSugeridos.size()));
    }

    Atuendo recibirSugerenciaAtuendoPorTemperatura(Temperatura unaTemperatura) {
        List<Accesorio> accesorio = new ArrayList<>();
        accesorio.add(filtrarPorTemperatura(getAccesorios(), unaTemperatura).get(numeroRandomSegunLista(getAccesorios().size())));
        return new Atuendo( (PrendaSuperior) filtrarPorTemperatura(getPrendasSuperiores(), unaTemperatura).get(numeroRandomSegunLista(getPrendasSuperiores().size())),
                            (PrendaInferior) filtrarPorTemperatura(getPrendasInferiores(), unaTemperatura).get(numeroRandomSegunLista(getPrendasInferiores().size())),
                            (Calzado) filtrarPorTemperatura(getCalzados(), unaTemperatura).get(numeroRandomSegunLista(getCalzados().size())), 
                            accesorio);
    }

    int numeroRandomSegunLista(int tamanioLista) {
        return new Random().nextInt(tamanioLista);
    }
}
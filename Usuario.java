import java.security.Guard;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Usuario {
    List<Guardarropa> guardarropas = new ArrayList<>();
    List<Guardarropa> guardarropasDeAmigos = new ArrayList<>();
    List<Prenda> misPrendas = new ArrayList<>();
    List<Sugerencia> sugerenciasRecibidas = new ArrayList<>();
    List<Sugerencia> sugerenciasAceptadas = new ArrayList<>();

    void compartirGuardarropas(Guardarropa unGuardarropa, Usuario destinatario) {
        destinatario.recibirGuardarropas(unGuardarropa);
    }

    void recibirGuardarropas(Guardarropa unGuardarropa) {
        guardarropasDeAmigos.add(unGuardarropa);
    }

    void enviarSugerencia(Sugerencia unaSugerencia, Usuario destinatario) {
        unaSugerencia.setDestinatario(destinatario);
        destinatario.recibirSugerencia(unaSugerencia);
    }

    void recibirSugerencia(Sugerencia unaSugerencia) {
        sugerenciasRecibidas.add(unaSugerencia);
    }

    void decidirSobreSugerencias() {
        for(Sugerencia unaSugerencia : sugerenciasRecibidas) {
            mostrar(unaSugerencia);
            decidir(unaSugerencia);
            sugerenciasRecibidas.remove(unaSugerencia);
        }
    }

    void mostrar(Sugerencia unaSugerencia){
        // TODO
    }

    void decidir(Sugerencia unaSugerencia) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea aceptar o rechazar la sugerencia?");
        String decision = scan.nextLine();

        if (decision.startsWith("a") || decision.startsWith("A")) {
            aceptarSugerencia(unaSugerencia);
        }
        else {
            rechazarSugerencia(unaSugerencia);
        }

        scan.close();
    }

    void aceptarSugerencia(Sugerencia unaSugerencia) {
        unaSugerencia.aceptar();
        sugerenciasAceptadas.add(unaSugerencia);
    }

    void rechazarSugerencia(Sugerencia unaSugerencia) {
        unaSugerencia.rechazar();
    }

    void revertirSugerencia(Sugerencia unaSugerencia) {
        if (sugerenciasAceptadas.contains(unaSugerencia)) {
            unaSugerencia.revertirEfecto();
            sugerenciasAceptadas.remove(unaSugerencia);
        }
    }

    Atuendo recibirSugerenciaAtuendoPorTemperatura(Temperatura unaTemperatura) {
        List<Accesorio> accesorio = new ArrayList<>();
        accesorio.add(QueMePongo.filtrarPorTemperatura(QueMePongo.getAccesorios(), unaTemperatura).get(QueMePongo.numeroRandomSegunLista(QueMePongo.getAccesorios().size())));
        return new Atuendo( (PrendaSuperior) QueMePongo.filtrarPorTemperatura(QueMePongo.getPrendasSuperiores(), unaTemperatura).get(QueMePongo.numeroRandomSegunLista(QueMePongo.getPrendasSuperiores().size())),
                            (PrendaInferior) QueMePongo.filtrarPorTemperatura(QueMePongo.getPrendasInferiores(), unaTemperatura).get(QueMePongo.numeroRandomSegunLista(QueMePongo.getPrendasInferiores().size())),
                            (Calzado) QueMePongo.filtrarPorTemperatura(QueMePongo.getCalzados(), unaTemperatura).get(QueMePongo.numeroRandomSegunLista(QueMePongo.getCalzados().size())), 
                            accesorio);
    }

    Uniforme recibirSugerenciaUniforme() {
        return QueMePongo.getUniformesSugeridos().get(QueMePongo.numeroRandomSegunLista(QueMePongo.getUniformesSugeridos().size()));
    }

    void iniciarCreacionDePrenda() {
        BuilderPrenda.cargarPrenda();
    }

    void crearPrenda() {
        Prenda prenda = BuilderPrenda.crearPrenda();
        QueMePongo.agregarPrenda(prenda);
        agregarPrenda(prenda);
    }

    void agregarPrenda(Prenda prenda) {
        misPrendas.add(prenda);
    }

    void quitarPrenda(Prenda prenda) {
        misPrendas.remove(prenda);
    }
}

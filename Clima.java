import java.time.LocalDate;

class Clima {
    Temperatura temperatura;
    float probabilidadDeLluvia;
    String condiciones;
    LocalDate fecha;

    Clima(Temperatura temperatura, float probabilidadDeLluvia, String condiciones, LocalDate fecha){
        this.temperatura = temperatura;
        this.probabilidadDeLluvia = probabilidadDeLluvia;
        this.condiciones = condiciones;
        this.fecha = fecha;
    }
}

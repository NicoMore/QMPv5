import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import del api de AccuWeather

interface Servicio {
    Temperatura obtenerTemperatura();
    float obtenerProbabilidadDeLluvia();
    String obtenerCondiciones();
    LocalDate obtenerFecha();
    LocalDate asLocalDate(String fechaEnOtroFormato);
}

class AccuWeather implements Servicio {

    AccuWeatherAPI api = new AccuWeatherAPI();

    List<Map<String, Object>> condicionesClimaticasBsAs = api.getWeather("Buenos Aires, Argentina"); // Por 12 horas

    void actualizarCondicionesClimaticasBsAs() {
        condicionesClimaticasBsAs = api.getWeather(“Buenos Aires, Argentina”);
    }

    @Override
    public Temperatura obtenerTemperatura() {
        return new Temperatura(condicionesClimaticasBsAs.get(0).get("Temperature"));
    }

    @Override
    public float obtenerProbabilidadDeLluvia() {
        return condicionesClimaticasBsAs.get(0).get("PrecipitationProbability");
    } 

    @Override
    public String obtenerCondiciones() { 
        return condicionesClimaticasBsAs.get(0).get("IconPhrase");
    }

    @Override
    public LocalDate obtenerFecha() {
        String fechaEnDateTime = condicionesClimaticasBsAs.get(0).get("DateTime");
        return asLocalDate(fechaEnDateTime);
    
    }

    @Override
    public LocalDate asLocalDate(String fechaEnOtroFormato) {
        // TODO Auto-generated method stub
        return null;
    }
}
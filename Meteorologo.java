class Meteorologo {
    static Servicio servicio;

    Servicio getServicio() {
        return servicio;
    }

    static void setServicio(Servicio unServicio) {
        servicio = unServicio;
    }

    static Clima obtenerClimaActual() {
        return new Clima(servicio.obtenerTemperatura(), servicio.obtenerProbabilidadDeLluvia(), servicio.obtenerCondiciones(), servicio.obtenerFecha());
    }
}
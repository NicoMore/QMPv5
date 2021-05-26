import java.util.HashMap;

class Temperatura {
    HashMap<String, Object> temperaturaAsHashMap;

    public Temperatura(HashMap<String, Object> temperaturaAsHashMap) {
        this.temperaturaAsHashMap = temperaturaAsHashMap;
    }

    public float getGrados() {
        return (float) temperaturaAsHashMap.get("Grados");
    }

    public String getUnidad() {
        return (String) temperaturaAsHashMap.get("Unidad");
    }

    public String getTipoUnidad() {
        return (String) temperaturaAsHashMap.get("Tipo de Unidad");
    }

    public void setGrados(float grados) {
        temperaturaAsHashMap.put("Grados", grados);
    }

    public void setUnidad(String unidad) {
        temperaturaAsHashMap.put("Unidad", unidad);
    }

    public void setTipoUnidad(int tipoUnidad) {
        temperaturaAsHashMap.put("Tipo de Unidad", tipoUnidad);
    }
}

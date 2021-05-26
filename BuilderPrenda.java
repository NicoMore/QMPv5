import java.util.ArrayList;
import java.util.Scanner;

enum Categoria { Superior, Inferior, Calzado, Accesorio; }

class BuilderPrenda {
    static ArrayList<String> tiposSuperiores = new ArrayList<>();
    static ArrayList<String> tiposInferiores = new ArrayList<>();
    static ArrayList<String> tiposCalzados = new ArrayList<>();
    static ArrayList<String> tiposAccesorios = new ArrayList<>();

    static Prenda tipo; 
    static String material;
    static String trama;
    static String color;
    static String colorSecundario;
    static Temperatura temperatura;

    static ArrayList<String> getTiposSuperiores() {
        return tiposSuperiores;
    }

    static ArrayList<String> getTiposInferiores() {
        return tiposInferiores;
    }

    static ArrayList<String> getTiposCalzados() {
        return tiposCalzados;
    }

    static ArrayList<String> getTiposAccesorios() {
        return tiposAccesorios;
    }

    public static void cargarPrenda() {
        tipo = indicarTipo();
        elegirMaterial();
        elegirColor();
        elegirColorSecundario();
        indicarTemperatura();
    }
    
    static Prenda crearPrenda() {
        tipo.setSiNullColor(color);
        tipo.setSiNullColorSecundario(colorSecundario);
        tipo.setSiNullMaterial(material);
        return tipo;
    }

    private static void indicarTemperatura() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea agregar indicar una temperatura?");

        boolean deseaTemperatura = scan.nextBoolean();
        if (deseaTemperatura) {
            try {
                System.out.println("Indique temperatura:");

                float grados = scan.nextFloat();
                String unidad = scan.nextLine();
                int tipoUnidad = scan.nextInt();

                temperatura.setGrados(grados);
                temperatura.setUnidad(unidad);
                temperatura.setTipoUnidad(tipoUnidad);

                scan.close();
            }
            catch (IllegalArgumentException tipoErroneo) {
                System.out.println("No se introdujo una temperatura valida.");
            }
        }
    }

    static Prenda indicarTipo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Indique el tipo de prenda que desea crear:");
        String tipoElegido = scan.nextLine();
        scan.close();

        return identificarTipo(tipoElegido);
    }

    static Prenda identificarTipo(String unTipo) { // Se podria hacer una funcion getter mas sencilla
        try {
            if (getTiposSuperiores().contains(unTipo))
                return new PrendaSuperior(unTipo);
            else if (getTiposInferiores().contains(unTipo))
                return new PrendaInferior(unTipo);
            else if (getTiposCalzados().contains(unTipo))
                return new Calzado(unTipo);
            else if (getTiposAccesorios().contains(unTipo))
                return new Accesorio(unTipo);
            else
                return new PrendaFallada();
        }   
        catch (Exception noSeEncontroTipo) {
            System.out.print("No se indico un tipo correcto");
            return new PrendaFallada();
        }
    }

    static void elegirMaterial() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea agregar un material?");

        boolean deseaMaterial = scan.nextBoolean();
        if (deseaMaterial) {
            try {
                System.out.println("Indique material:");

                material = scan.nextLine();

                System.out.println("Desea indicar una trama?");
                if (scan.nextLine().startsWith("S")) {
                    System.out.println("Indique trama:");
                    trama = scan.nextLine();
                } 
                else 
                    trama = "Lisa";

                scan.close();
            }
            catch (IllegalArgumentException tipoErroneo) {
                System.out.println("Se introdujo un valor de material invalido.");
            }
        }
    }

    static void elegirColor() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea agregar un color?");

        boolean deseaColor = scan.nextBoolean();
        if (deseaColor) {
            try {
                System.out.println("Indique color:");

                color = scan.nextLine();
                scan.close();
            }
            catch (IllegalArgumentException tipoErroneo) {
                System.out.println("Se introdujo un valor de color invalido.");
            } 
        }
    }

    static void elegirColorSecundario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Desea agregar un color secundario?");

        boolean deseaColorSecundario = scan.nextBoolean();
        if (deseaColorSecundario) {
            try {
                System.out.println("Indique color secundario:");

                colorSecundario = scan.nextLine();
                scan.close();
            }
            catch (IllegalArgumentException tipoErroneo) {
                System.out.println("Se introdujo un valor de color invalido.");
            }
        }
    }
}


import java.util.*;

public class Main {

    // Diccionario inicial inglés → español
    private static Map<String, String> diccionario = new HashMap<>();

    public static void main(String[] args) {
        inicializarDiccionario();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==================== MENÚ ====================");
            System.out.println("1. Traducir una frase");
            System.out.println("2. Agregar palabras al diccionario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println(" Opción inválida. Intente de nuevo.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    traducirFrase(sc);
                    break;
                case 2:
                    agregarPalabra(sc);
                    break;
                case 0:
                    System.out.println(" Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }

    // Diccionario base
    private static void inicializarDiccionario() {
        diccionario.put("time", "tiempo");
        diccionario.put("person", "persona");
        diccionario.put("year", "año");
        diccionario.put("way", "camino");
        diccionario.put("day", "día");
        diccionario.put("thing", "cosa");
        diccionario.put("man", "hombre");
        diccionario.put("world", "mundo");
        diccionario.put("life", "vida");
        diccionario.put("hand", "mano");
        diccionario.put("part", "parte");
        diccionario.put("child", "niño");
        diccionario.put("eye", "ojo");
        diccionario.put("woman", "mujer");
        diccionario.put("place", "lugar");
        diccionario.put("work", "trabajo");
        diccionario.put("week", "semana");
        diccionario.put("case", "caso");
        diccionario.put("point", "punto");
        diccionario.put("government", "gobierno");
    }

    // Opción 1: Traducir una frase
    private static void traducirFrase(Scanner sc) {
        System.out.print("\nIngrese la frase a traducir: ");
        String frase = sc.nextLine().toLowerCase();

        String[] palabras = frase.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (diccionario.containsKey(palabra)) {
                resultado.append(diccionario.get(palabra)).append(" ");
            } else {
                resultado.append(palabra).append(" ");
            }
        }

        System.out.println("Traducción parcial: " + resultado.toString().trim());
    }

    // Opción 2: Agregar palabras al diccionario
    private static void agregarPalabra(Scanner sc) {
        System.out.print("\nIngrese la palabra en inglés: ");
        String ingles = sc.nextLine().toLowerCase();

        System.out.print("Ingrese su traducción al español: ");
        String espanol = sc.nextLine().toLowerCase();

        if (!diccionario.containsKey(ingles)) {
            diccionario.put(ingles, espanol);
            System.out.println("Palabra '" + ingles + "' agregada como '" + espanol + "'.");
        } else {
            System.out.println(" Esa palabra ya existe en el diccionario.");
        }
    }
}
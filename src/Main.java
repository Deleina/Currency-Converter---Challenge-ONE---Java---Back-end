import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String apiKey = "fb927f302a30ebd84c424657";
        ApiClient apiClient = new ApiClient(apiKey);
        CurrencyConverter currencyConverter = new CurrencyConverter(apiClient);

        System.out.println("*****************************************************");
        System.out.println("¡Bienvenid/a al Conversor de Monedas :D!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir Dolar a Peso Argentino");
            System.out.println("2. Convertir Peso Argentino a Dolar");
            System.out.println("3. Convertir Dolar a Real Brasileño");
            System.out.println("4. Convertir Real Brasileño a Dolar");
            System.out.println("5. Convertir Dolar a Peso Colombiano");
            System.out.println("6. Convertir Peso Colombiano a Dolar");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            if (opcion == 7) {
                System.out.println("*****************************************************");
                System.out.println("¡Gracias por usar nuestro convertidor de Monedas :D!");
                break;
            }

            try {
                double cantidad;
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dólares corresponden a " + currencyConverter.convert("USD", "ARS", cantidad) + " pesos argentinos.");
                        break;
                    case 2:
                        System.out.println("Ingrese la cantidad en pesos argentinos:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " pesos argentinos corresponden a " + currencyConverter.convert("ARS", "USD", cantidad) + " dólares.");
                        break;
                    case 3:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dólares corresponden a " + currencyConverter.convert("USD", "BRL", cantidad) + " reales brasileños.");
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad en reales brasileños:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " reales brasileños corresponden a " + currencyConverter.convert("BRL", "USD", cantidad) + " dólares.");
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad en dólares:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " dólares corresponden a " + currencyConverter.convert("USD", "COP", cantidad) + " pesos colombianos.");
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad en pesos colombianos:");
                        cantidad = scanner.nextDouble();
                        System.out.println(cantidad + " pesos colombianos corresponden a " + currencyConverter.convert("COP", "USD", cantidad) + " dólares.");
                        break;
                    default:
                        System.out.println("Opción no válida, por favor seleccione una opción válida.");
                        break;
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}

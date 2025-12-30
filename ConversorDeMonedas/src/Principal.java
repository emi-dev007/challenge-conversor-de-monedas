
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion = 0;

        while (opcion != 9) {
            System.out.println("*************************************************");
            System.out.println("Bienvenido al conversor de monedas =]");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("9) Salir");
            System.out.print("Elija una opción válida: ");
            System.out.println("\n*************************************************");

            try {
                opcion = lectura.nextInt();

                if (opcion == 9) {
                    System.out.println("Finalizando el programa. ¡Gracias por usar nuestros servicios!");
                    break;
                }

                if (opcion < 1 || opcion > 6) {
                    System.out.println("Opción no válida, intente de nuevo.");
                    continue;
                }

                System.out.println("Ingrese el valor que desea convertir:");
                double cantidad = lectura.nextDouble();


                String base = "";
                String target = "";


                switch (opcion) {
                    case 1:
                        base = "USD";
                        target = "ARS";
                        break;
                    case 2:
                        base = "ARS";
                        target = "USD";
                        break;
                    case 3:
                        base = "USD";
                        target = "BRL";
                        break;
                    case 4:
                        base = "BRL";
                        target = "USD";
                        break;
                    case 5:
                        base = "USD";
                        target = "COP";
                        break;
                    case 6:
                        base = "COP";
                        target = "USD";
                        break;
                }


                Moneda moneda = consulta.buscarMoneda(base, target, cantidad);


                System.out.println("El valor " + cantidad + " [" + base + "] " +
                        "corresponde al valor final de =>>> " +
                        moneda.conversion_result() + " [" + target + "]");

            } catch (Exception e) {
                System.out.println("Ocurrió un error (ingresaste una letra en vez de número, o falló la conexión).");

                lectura.nextLine();
            }
        }
        lectura.close();
    }
}

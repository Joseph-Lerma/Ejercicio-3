import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private ArrayList<Vuelo> vuelos;
    private Scanner scanner;

    public App() {
        vuelos = new ArrayList<>();
        vuelos.add(new Vuelo("Nueva York", 5));
        vuelos.add(new Vuelo("París", 4));
        vuelos.add(new Vuelo("Tokio", 3));
        vuelos.add(new Vuelo("Milán", 2));
        vuelos.add(new Vuelo("Ámsterdam", 1));
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de reserva de vuelos");
        System.out.println("1. Buscar vuelos disponibles");
        System.out.println("2. Salir");
    }

    public void vuelosdisponibles() {
        System.out.println("Vuelos disponibles:");
        for (int i = 0; i < vuelos.size(); i++) {
            System.out.println((i + 1) + ". " + vuelos.get(i).getdestino() + " - Asientos disponibles: " + vuelos.get(i).getasientosdisponibles());
        }
    }

    public void realizareserva() {
        vuelosdisponibles();
        System.out.print("Seleccione el número del vuelo al que desea reservar (ingrese 0 si quiere cancelar): ");
        try {
            int seleccion = scanner.nextInt();
            if (seleccion == 0) {
                System.out.println("Reserva cancelada.");
                return;
            }
            Vuelo vueloSeleccionado = vuelos.get(seleccion - 1);
            vueloSeleccionado.reservarasiento();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Opción inválida. Por favor, seleccione un vuelo válido.");
        } catch (faltadeasientosexcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void iniciarsistema() {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    realizareserva();
                    break;
                case 2:
                    System.out.println("Gracias por usar nuestro servicio de reservas de vuelos");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 2);
        scanner.close();
    }

    public static void main(String[] args) {
        App reservaDeVuelos = new App();
        reservaDeVuelos.iniciarsistema();
    }
}

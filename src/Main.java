//import java.io.EOFException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Visitante> listaVisitantes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("BIENVENIDO AL REGISTRO DE VISITANTES DE DEPARTAMENTOS");
            System.out.println("MENU");
            System.out.println("1. Ver visitantes");
            System.out.println("2. Agregar visitante");
            System.out.println("3. Editar visitante");
            System.out.println("4. Eliminar visitante");
            System.out.println("5. Salir");
            System.out.print("\nOPCION: ");
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcion = 100;
                scanner.next();
            }

            switch (opcion) {
                case 1:
                    verVisitante();
                    break;
                case 2:
                    agregarVisitante(scanner);
                    break;
                case 3:
                    editarVisitante(scanner);
                    break;
                case 4:
                    eliminarVisitante(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("ERR::Opcion invalida");
            }
        } while (opcion != 5);
    }

    private static void verVisitante() {
        for (Visitante visitante : listaVisitantes) {
            System.out.println("\n" + visitante);
            System.out.println("Nombre: " + visitante.getNombre());
            System.out.println("Apellido: " + visitante.getApellido());
            System.out.println("Edad: " + visitante.getEdad());
            System.out.println("Tipo de sangre: " + visitante.getTipodesangre());
            System.out.println("Visitas: " + visitante.getVisitas());
            System.out.println("Es jubilado?: " + visitante.getJubilado());
        }
    }

    private static void agregarVisitante(Scanner scanner) { //Si se agrega el mismo visitante (nombre y apellido), sus visitas aumentarán y además no registrará los demás atributos ya que se habían proporcionado antes

        System.out.print("Nombre del visitante: ");
        String nombre = scanner.next();
        System.out.print("Apellido del visitante: ");
        String apellido = scanner.next();

        for (Visitante visitante : listaVisitantes) {

            if (visitante.getNombre().equals(nombre)&&visitante.getApellido().equals(apellido)) { //La condicional evalúa si se había registrado a un visitante con el mismo nombre y apellido

                System.out.println("Bienvenido nuevamente," + nombre + " " + apellido);

                int visitas = visitante.getVisitas(); //Obtiene las veces que un inquilino ha visitado el departamento de la lista de colecciones
                visitas = visitas + 1; //A medida que el inquilino visita, su historial de visitas aumenta
                visitante.setVisitas(visitas); //Actualiza el nuevo contador de visitas del inquilino
                return;
            }
        }
        System.out.print("Edad del visitante: ");
        int edad;
        try {
            edad = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ERR::Entrada invalida. Edad debe ser numero.");
            scanner.next();
            return;
        }
        boolean jubilado = false;
        if (edad > 68) //Comprueba si el inquilino es jubilado o no
            jubilado = true;
        System.out.print("Tipo de sangre del visitante: ");
        char tipodesangre;
        try {
            tipodesangre = scanner.next().charAt(0);
        } catch (InputMismatchException e) {
            System.out.println("ERR::Entrada invalida. Tipo de sangre debe ser una letra.");
            scanner.next();
            return;
        }
        int visitas = 0;
        visitas = visitas + 1;
        listaVisitantes.add(new Visitante(nombre, apellido, edad, tipodesangre, visitas, jubilado));




    }

    private static void editarVisitante(Scanner scanner) {
        System.out.print("Nombre del visitante a editar: ");
        String nombre = scanner.next();
        System.out.print("Apellido del visitante a editar: ");
        String apellido = scanner.next();
        for (Visitante visitante : listaVisitantes) {
            if (visitante.getNombre().equals(nombre)&&visitante.getApellido().equals(apellido)) {
                System.out.println("Introduce nueva edad: ");
                int edad;
                try {
                    edad = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("ERR::Entrada invalida. Edad debe ser numero.");
                    scanner.next();
                    return;
                }
                boolean jubilado = false;
                if (edad > 68)
                    jubilado = true;
                visitante.setEdad(edad);
                visitante.setJubilado(jubilado); //Actualiza el estado de jubilación según la edad actualizada (Si pasa los 68)
                return;
            }
        }
        System.out.println("Visitante no encontrado.");
    }

    private static void eliminarVisitante(Scanner scanner) {


        System.out.print("Nombre del visitante a eliminar: ");
        String nombre = scanner.next();
        System.out.print("Apellido del visitante a eliminar: ");
        String apellido = scanner.next();
        listaVisitantes.removeIf(visitante -> visitante.getNombre().equals(nombre)&&visitante.getApellido().equals((apellido)));
        System.out.println("Visitante eliminado con éxito.");

        for (Visitante visitante : listaVisitantes) {
            if (nombre != visitante.getNombre() && apellido != visitante.getApellido()) {
                System.out.println("Visitante no encontrado.");
            }
        }




    }
}

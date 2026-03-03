import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase Contacto para almacenar la información de cada contacto
class Contacto {
    private String nombre;
    private String email;
    private String telefono;

    // Constructor
    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    // Método para mostrar la información del contacto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono;
    }
}

// Clase Agenda para manejar la lista de contactos
class Agenda {
    private List<Contacto> contactos;

    // Constructor
    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    // Método para agregar un contacto a la agenda
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    // Método para mostrar todos los contactos de la agenda
    public void mostrarAgenda() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("Agenda de Contactos:");
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }
}

// Clase principal con el método main para interactuar con la agenda
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            // Menú de opciones
            System.out.println("\n---- Agenda de Contactos ----");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar agenda");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    // Solicitar datos del contacto
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el email: ");
                    String email = scanner.nextLine();

                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();

                    // Crear el contacto y agregarlo a la agenda
                    Contacto contacto = new Contacto(nombre, email, telefono);
                    agenda.agregarContacto(contacto);
                    System.out.println("Contacto agregado exitosamente.");
                    break;

                case 2:
                    // Mostrar todos los contactos
                    agenda.mostrarAgenda();
                    break;

                case 3:
                    // Salir del programa
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
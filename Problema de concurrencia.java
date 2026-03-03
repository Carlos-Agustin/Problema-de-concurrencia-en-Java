import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Contacto {
    private String nombre;
    private String email;
    private String telefono;

    public Contacto(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Email: " + email + ", Teléfono: " + telefono;
    }
}

class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            System.out.println("\n---- Agenda de Contactos ----");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar agenda");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el email: ");
                    String email = scanner.nextLine();

                    System.out.print("Ingrese el teléfono: ");
                    String telefono = scanner.nextLine();

                    Contacto contacto = new Contacto(nombre, email, telefono);
                    agenda.agregarContacto(contacto);
                    System.out.println("Contacto agregado exitosamente.");
                    break;

                case 2:
                    agenda.mostrarAgenda();
                    break;

                case 3:
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

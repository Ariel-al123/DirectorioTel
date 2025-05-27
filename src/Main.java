import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Contacto> directorio = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
            scanner.nextLine(); //limpiar el buffer
            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    listarContactos();
                    break;
                case 3:
                    menuBuscar();
                    break;
                case 4:
                    System.out.println("\nSaliendo del sistema...");
                    break;
                default:
                    System.out.println("---Opción no válida. Intente de nuevo---");
            }
        } while (opcion != 4);
    }

    private static void agregarContacto() {
        System.out.println("\n[AGREGAR NUEVO CONTACTO] ");
        String nombre;
        do{
            System.out.print("Nombre completo: ");
            nombre = scanner.nextLine();
            if(nombre.isEmpty()){
                System.out.println("\nDebes poner un nombre para continuar el proceso");
            }
        }while(nombre.isEmpty());

        String telefono;
        do{
            System.out.print("Teléfono: ");
            telefono = scanner.nextLine();
            if(telefono.isEmpty()){
                System.out.println("\nDebes ingresar un número para continuar");
            }
        }while(telefono.isEmpty());

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nombre, telefono, email, direccion);
        directorio.add(nuevoContacto);
        System.out.println("Contacto agregado exitosamente!");
    }

    public static int menu(){
        System.out.println("\n[Menú de directorio telefónico]");
        System.out.println("1. Agregar nuevo contacto");
        System.out.println("2. Listar todos los contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Salir");
        System.out.println("----------------------------------------");
        System.out.print("Seleccione una opción: ");
        int opcion;
        do {
            opcion = scanner.nextInt();
            if(opcion<1||opcion>4){
                System.out.println("Opción no encontrada");
            }

        }while(opcion<1||opcion>4);
        return opcion;
    }

    private static void listarContactos() {
        if (directorio.isEmpty()) {
            System.out.println("\n---No hay contactos en el directorio---");
            return;
        }

        System.out.println("\n[LISTA DE TODOS LOS CONTACTOS] ");
        for (int i = 0; i < directorio.size(); i++) {
            System.out.println("Contacto #" + (i + 1));
            System.out.println(directorio.get(i));
        }
    }

    /**
     * Searches for a contact in the directory by either name or phone number.
     * If contacts exist, it displays all current contacts for reference.
     * Allows users*/
    private static void menuBuscar(){
        if (directorio.isEmpty()) {
            System.out.println("\n---No hay contactos en el directorio---");
            return;
        }

        System.out.println("\n[LISTA DE TODOS LOS CONTACTOS] \n");
        for (int i = 0; i < directorio.size(); i++) {
            System.out.println("-----------------------------------");
            System.out.println(directorio.get(i));
        }
        System.out.println("-----------------------------------");
        System.out.println("(Se acepta nombre o número del contacto)");
        System.out.println("[Ingrese el contacto a buscar]");
        String meta= scanner.nextLine();
        if(meta.isEmpty())scanner.nextLine();
        Contacto pesca= new Contacto("");
        boolean palanca=false;
        int pozo=0;
        for(Contacto cebo: directorio){
            if(cebo.getNombre().equals(meta)){
                pesca=cebo;
                palanca=true;
                break;
            }
            else if(cebo.getTelefono().equals(meta)){
                pesca=cebo;
                palanca=true;
                break;
            }else{
                pozo++;
            }
        }
        if(palanca) {
            System.out.println(pesca.toString());
            int opcion;
            do {
                opcion = menuPesca();
                switch(opcion){
                    case 1:
                        System.out.print("Ingresa un nuevo nombre: ");
                        String nombre=scanner.nextLine();
                        if(nombre.isEmpty())nombre=scanner.nextLine();
                        pesca.setNombre(nombre);
                        directorio.set(pozo,pesca);
                        break;
                    case 2:
                        System.out.print("Ingresa un nuevo telefono: ");
                        String telefono=scanner.nextLine();
                        if(telefono.isEmpty())telefono=scanner.nextLine();
                        pesca.setTelefono(telefono);
                        directorio.set(pozo,pesca);
                        break;
                    case 3:
                        System.out.print("Ingresa un nuevo email: ");
                        String email=scanner.nextLine();
                        if(email.isEmpty())email=scanner.nextLine();
                        pesca.setEmail(email);
                        directorio.set(pozo,pesca);
                        break;
                    case 4:
                        System.out.print("Ingresa un nuevo direccion: ");
                        String direccion=scanner.nextLine();
                        if(direccion.isEmpty())direccion=scanner.nextLine();
                        pesca.setDireccion(direccion);
                        directorio.set(pozo,pesca);
                        break;
                    case 5:
                        directorio.remove(pozo);
                        break;
                    case 6:
                        System.out.println("Entendido...\n");
                        break;
                }
            } while (opcion != 6&&opcion!=5);
        }
        else
            System.out.println("No se encontro");
    }

    public static int menuPesca(){
        System.out.println("\n¿Deseas?");
        System.out.println("1.Editar Nombre");
        System.out.println("2.Editar Telefono");
        System.out.println("3.Editar Email");
        System.out.println("4.Editar Direccion");
        System.out.println("5.Eliminar Contacto");
        System.out.println("6.No hacer nada");
        System.out.println("----------------------------------------");
        System.out.print("Seleccione una opción: ");
        int opcion;
        do {
            opcion = scanner.nextInt();
            if(opcion<1||opcion>6){
                System.out.println("Opción no encontrada");
            }

        }while(opcion<1||opcion>6);
        return opcion;
    }

}
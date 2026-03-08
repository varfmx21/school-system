import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class schoolSystem {
    // Parte 2 – Métodos //
    // Recursivo — suma las notas una por una
    private static double sumarNotas(List<Estudiante> estudiantes, int indice) {
        if (indice == estudiantes.size()) return 0;
        return estudiantes.get(indice).getNota() + sumarNotas(estudiantes, indice + 1);
    }

    // Retorna el promedio del grupo
    static double calcularPromedio(List<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) return 0;
        return sumarNotas(estudiantes, 0) / estudiantes.size();
    }

    // Retorna la nota máxima
    static double notaMasAlta(List<Estudiante> estudiantes) {
        double max = Double.NEGATIVE_INFINITY;
        for (Estudiante e : estudiantes) {
            if (e.getNota() > max) max = e.getNota();
        }
        return max;
    }

    // Retorna la nota mínima
    static double notaMasBaja(List<Estudiante> estudiantes) {
        double min = Double.MAX_VALUE;
        for (Estudiante e : estudiantes) {
            if (e.getNota() < min) min = e.getNota();
        }
        return min;
    }

    // Cuenta cuántos aprobaron (nota ≥ 6.0)
    static int contarAprobados(List<Estudiante> estudiantes) {
        int count = 0;
        for (Estudiante e : estudiantes) {
            if (e.obtenerEstado().equals("Aprobado")) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        // Parte 3 – Arreglos y Colecciones //
        List<Estudiante> estudiantes = new ArrayList<>();

        // Parte 1 – Fundamentos //
        while (!salir) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     SISTEMA ESTUDIANTIL v1.0     ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Registrar estudiantes        ║");
            System.out.println("║  2. Ver calificaciones           ║");
            System.out.println("║  3. Ver estadísticas             ║");
            System.out.println("║  4. Buscar estudiante            ║");
            System.out.println("║  5. Salir                        ║");
            System.out.println("╚══════════════════════════════════╝");
            try {

                System.out.print("\n[+] Escribe una de las opciones: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        sn.nextLine();
                        System.out.print("[?] Ingresa el nombre del estudiante: ");
                        String nombre = sn.nextLine();

                        System.out.print("[?] Ingresa la edad: ");
                        int edad = sn.nextInt();

                        System.out.print("[?] Ingresa la nota: ");
                        double nota = sn.nextDouble();

                        if (nota < 0.0 || nota > 10.0) {
                            System.out.println("[!] Nota inválida. Debe estar entre 0.0 y 10.0\n");
                            break;
                        }

                        System.out.print("[?] Tipo de estudiante (1: Regular, 2: Becado): ");
                        int tipo = sn.nextInt();

                        Estudiante nuevo;
                        if (tipo == 2) {
                            nuevo = new EstudianteBeca();
                        } else {
                            nuevo = new EstudianteRegular();
                        }

                        nuevo.setNombre(nombre);
                        nuevo.setEdad(edad);
                        nuevo.setNota(nota);
                        estudiantes.add(nuevo);
                        System.out.println("[+] Estudiante registrado: " + nuevo.obtenerTipo() + "\n");
                        break;
                    case 2:
                        if (estudiantes.isEmpty()) {
                            System.out.println("\n[!] No hay estudiantes registrados.\n");
                        } else {
                            System.out.println("\n╔══════════════════════════════════╗");
                            System.out.println("║        CALIFICACIONES            ║");
                            System.out.println("╚══════════════════════════════════╝");
                            System.out.printf("%-15s %-10s %-6s %-10s%n", "Nombre", "Tipo", "Nota", "Estado");
                            System.out.println("─".repeat(43));
                            for (Estudiante e : estudiantes) {
                                System.out.printf("%-15s %-10s %-6.1f %-10s%n",
                                    e.getNombre(),
                                    e.obtenerTipo(),
                                    e.getNota(),
                                    e.obtenerEstado());
                            }
                            System.out.println();
                        }
                        break;
                    case 3:
                        if (estudiantes.isEmpty()) {
                            System.out.println("\n[!] No hay estudiantes registrados.\n");
                        } else {
                            System.out.println("\n╔══════════════════════════════════╗");
                            System.out.println("║          ESTADÍSTICAS            ║");
                            System.out.println("╚══════════════════════════════════╝");
                            System.out.printf("  [+] Promedio de notas : %.2f%n", calcularPromedio(estudiantes));
                            System.out.printf("  [+] Nota más alta     : %.2f%n", notaMasAlta(estudiantes));
                            System.out.printf("  [+] Nota más baja     : %.2f%n", notaMasBaja(estudiantes));
                            System.out.printf("  [+] Aprobados         : %d / %d%n\n", contarAprobados(estudiantes), estudiantes.size());
                        }
                        break;
                    case 4:
                        sn.nextLine();
                        System.out.print("[?] Ingresa el nombre a buscar: ");
                        String buscar = sn.nextLine().trim().toLowerCase();

                        boolean encontrado = false;
                        for (Estudiante e : estudiantes) {
                            if (e.getNombre().toLowerCase().contains(buscar)) {
                                if (!encontrado) {
                                    System.out.println("\n╔══════════════════════════════════╗");
                                    System.out.println("║       RESULTADO BÚSQUEDA         ║");
                                    System.out.println("╚══════════════════════════════════╝");
                                    System.out.printf("%-15s %-10s %-6s %-10s%n", "Nombre", "Tipo", "Nota", "Estado");
                                    System.out.println("─".repeat(43));
                                }
                                System.out.printf("%-15s %-10s %-6.1f %-10s%n",
                                    e.getNombre(),
                                    e.obtenerTipo(),
                                    e.getNota(),
                                    e.obtenerEstado());
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.printf("%n[!] No se encontró ningún estudiante con \"%s\"%n%n", buscar);
                        } else {
                            System.out.println();
                        }
                        break;
                    case 5:
                        System.out.println("[!] Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

}
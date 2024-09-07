import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    private static final int NUM_ALUMNOS = 2; // Número de alumnos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaración de arrays
        String[] nombres = new String[NUM_ALUMNOS];
        double[] notas = new double[NUM_ALUMNOS];
        String[] calificaciones = new String[NUM_ALUMNOS];

        // Solicitar datos al usuario
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            System.out.print("Ingrese el nombre del alumno " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            double nota = -1;
            while (nota < 0 || nota > 10) {
                try {
                    System.out.print("Ingrese la nota de " + nombres[i] + " (0-10): ");
                    nota = scanner.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.println("La nota debe estar entre 0 y 10. Intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                    scanner.next(); // Limpiar el buffer
                }
            }
            scanner.nextLine(); // Limpiar el buffer después de leer la nota

            notas[i] = nota;
            calificaciones[i] = obtenerCalificacion(nota);
        }

        // Mostrar resultados
        for (int i = 0; i < NUM_ALUMNOS; i++) {
            System.out.println("Alumno: " + nombres[i]);
            System.out.println("Nota: " + notas[i]);
            System.out.println("Calificación: " + calificaciones[i]);
            System.out.println();
        }

        scanner.close(); // Cerrar el scanner
    }

    // Método para obtener la calificación en texto a partir de la nota
    public static String obtenerCalificacion(double nota) {
        if (nota >= 9 && nota <= 10) {
            return "Sobresaliente";
        } else if (nota >= 7 && nota < 9) {
            return "Notable";
        } else if (nota >= 5 && nota < 7) {
            return "Bien";
        } else {
            return "Suspenso";
        }
    }
}

import java.io.*;
import java.util.Scanner;

public class lanzarProceso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "C:\\Users\\oscar\\IdeaProjects\\ejer1Procesos\\out\\artifacts\\ejer1Procesos_jar\\ejer1Procesos.jar";

        System.out.println("Introduce el primer número:");
        int numero1 = sc.nextInt();
        System.out.println("Introduce el segundo número:");
        int numero2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el operando:");
        String operando = sc.nextLine();

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-jar", ruta
            );

            Process proceso = pb.start();

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                writer.write(numero1 + "\n");
                writer.write(numero2 + "\n");
                writer.write(operando + "\n");
                writer.flush();
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println("Salida del proceso: " + linea);
                }
            }

            try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()))) {
                String linea;
                while ((linea = errorReader.readLine()) != null) {
                    System.err.println("Error del proceso: " + linea);
                }
            }

            int exitCode = proceso.waitFor();
            System.out.println("El proceso terminó con el código: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
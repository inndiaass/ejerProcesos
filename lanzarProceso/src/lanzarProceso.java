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

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()))) {
                bw.write(numero1 + "\n");
                bw.write(numero2 + "\n");
                bw.write(operando + "\n");

            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println("Salida del proceso: " + linea);
                }
            }



        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
import java.io.*;
import java.util.Scanner;

public class lanzarProceso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "C:\\Users\\oscar\\IdeaProjects\\ejer1Procesos\\out\\artifacts\\ejer1Procesos_jar\\ejer1Procesos.jar";



        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-jar", ruta
            );

            Process proceso = pb.start();

            try(BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream())))  {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);

                    bw.write(sc.nextLine());
                    bw.write("/n");
                    bw.flush();

                    System.out.println(br.readLine());
                    bw.write(sc.nextLine());
                    bw.write("/n");
                    bw.flush();
                }
            }




        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
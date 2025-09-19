import java.util.Scanner;


    public class calculadora {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("introduce el primer numero");
            int num1 = sc.nextInt();
            System.out.println("introduce el segundo numero");
            int num2 = sc.nextInt();
            sc.nextLine();
            System.out.println("introduce el operando");
            String operando = sc.nextLine();
            int res=0;


            switch(operando){
                case "+" -> res = num1 + num2;
                case "-" -> res = num1 - num2;
                case "/" -> res = num1 / num2;
                case "*" -> res = num1 * num2;

            }
            System.out.println("el resultado es "+res);

        }
    }


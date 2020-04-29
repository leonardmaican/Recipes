package ro.gr5;

import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introdu primul numar: ");
        int a = sc.nextInt();
        System.out.print("Introdu al doilea numar: ");
        int b = sc.nextInt();
        System.out.print("Introdu operatia pe care vrei sa o faci: ");
        String operatia = sc.next();
        switch (operatia) {
            case "+":

                int suma = a + b;
                System.out.println("Rezultatul operatiei de adunare este: " + suma);
                break;
            case "-":
                int dif = a - b;
                System.out.println("Rezultatul operatiei de scadere este: " + dif);
                break;
            case "*":
                int prod = a * b;
                System.out.println("Rezultatul operatiei de inmultire este: " + prod);
                break;
            case "/":
                int rez = a / b;
                System.out.println("Rezultatul operatiei de impartire este: " + rez);
                break;

            default:
                System.out.println(operatia + " nu este o operatie valida!");
        }
    }
}

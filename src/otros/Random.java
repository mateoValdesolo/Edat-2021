package otros;

import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bin;
        int dec;

        System.out.println("Ingrese un numero Decimal");
        dec = sc.nextInt();
        System.out.println("El numero " + dec + " en Binario es: " + decToBin(dec));

        System.out.println("Ingrese un numero Binario");
        bin = sc.nextLine();
        System.out.println("El numero " + bin + " en Decimal es: " + binToDec(bin));
    }

    public static int binToDec(String bin) {
        // Convierte un Numero Binario a un Decimal.
        int dec = 0, cont = bin.length() - 1;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != '0') {
                dec += Math.pow(2, cont);
            }
            cont--;
        }
        return dec;
    }

    public static String decToBin(int dec) {
        // Convierte un Numero Decimal a Binario.
        String bin = "";
        int i = 2;
        while (dec > 0) {
            if (dec % i == 0) {
                bin = '0' + bin;
            } else {
                bin = '1' + bin;
            }
            dec = dec / i;
        }
        return bin;
    }
}

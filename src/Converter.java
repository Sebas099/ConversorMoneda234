import java.io.IOException;
import java.util.Scanner;

public final class Converter {
    private static Scanner keyboard = new Scanner(System.in);
    private static String[] availableOptions = {"1", "2", "3", "4", "5", "6"};
    private Converter() {}

    public static void convertCurrency() throws IOException, InterruptedException {
        String option = null;
        while (true) { 
            menu();
            option = optionChoose();
            if (option.equals("7")) {
                keyboard.close();
                break;
            }
            else if(option.equals("0")) {
                System.out.println("Opcion incorrecta. Enter para continuar.");
                keyboard.nextLine();
            }
            else {
                Request.makeRequest(option, amount());
                System.out.println("Enter para continuar.");
                keyboard.nextLine();
            }
        }
    }

    private static void menu() {
        System.out.println("****************************************************");
        System.out.println("Seleccione opción:\n");
        System.out.println("1) Dólar(USD) --> Peso argentino(ARS)");
        System.out.println("2) Peso Argentino(ARS) --> Dólar(USD)");
        System.out.println("3) Dólar(USD) --> Real brasileño(BRL)");
        System.out.println("4) Real brasileño(BRL) --> Dólar(USD)");
        System.out.println("5) Dólar(USD) --> Peso colombiano(COP)");
        System.out.println("6) Peso colombiano(COP) --> Dólar(USD)");
        System.out.println("7) Salir");
        System.out.println("****************************************************");
    }

    private static String optionChoose() {
        String input = keyboard.nextLine();

        if (input.equals("7")) return input;
        for (String s : availableOptions) {
            if (input.equals(s)){
                return Request.resource(Integer.parseInt(input) - 1);
            }
        }          
        return "0";
    } 
    
    private static String amount() {
        System.out.println("Ingrese cantidad a convertir.");;
        String input = keyboard.nextLine();
        return input;
    }
}

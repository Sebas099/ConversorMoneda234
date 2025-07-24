import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Converter {
    private static Scanner keyboard = new Scanner(System.in);
    private static String[] availableOptions = {"1", "2", "3", "4", "5", "6"};
    private Converter() {}

    public static void convertCurrency() throws IOException, InterruptedException {
        System.out.println("Bienvenido al conversor de monedas. Presione Enter para continuar.");
        while (true) { 
            menu();
            Request.makeRequest(optionChoose(), amount());
            System.out.println("Presione Enter para continuar.");       
        }
    }

    private static void menu() {
        keyboard.nextLine();
        String menu = """
            ****************************************************
            Elija la divisa a convertir.
            1) Dólar(USD) --> Peso argentino(ARS)
            2) Peso Argentino(ARS) --> Dólar(USD)
            3) Dólar(USD) --> Real brasileño(BRL)
            4) Real brasileño(BRL) --> Dólar(USD)
            5) Dólar(USD) --> Peso colombiano(COP)
            6) Peso colombiano(COP) --> Dólar(USD)
            7) Salir
            ****************************************************""";
        System.out.println(menu);        
    }

    private static String optionChoose() {     
        while(true) {
            String input = keyboard.nextLine();
            if (input.equals("7")) {
                keyboard.close();
                System.exit(0);
            }
            else {
                for (String s : availableOptions) {
                    if (input.equals(s)) {
                        return Request.resource(Integer.parseInt(input) - 1);
                    }
                }
                System.out.println("Opcion incorrecta. Intente nuevamente.");
            }
        }
    } 
    
    private static String amount(){
        System.out.println("Ingrese cantidad a convertir.");
        int input;
        while (true) {
            try {
                input = keyboard.nextInt();
                keyboard.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Intente nuevamente.");
                keyboard.nextLine();
            }
        }   
        return String.valueOf(input);
    }

    public static void closeScanner() {
        keyboard.close();
    }
}

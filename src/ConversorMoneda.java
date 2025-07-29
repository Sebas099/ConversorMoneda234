public class ConversorMoneda {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            String use = "\"\\;*.jar\\\"";
            System.out.println("Ingrese su API key como argumento en la ejecución. Uso: java -cp " + use + " ConversorMoneda API_KEY");
            System.exit(1);
        }
         
        Converter.convertCurrency(args[0]);
    }
}
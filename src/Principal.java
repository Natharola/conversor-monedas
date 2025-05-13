import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionMenu= 0;

        ConsultaConversionMoneda consulta = new ConsultaConversionMoneda();
        Calculos calculos = new Calculos(consulta);
        GeneradorDeArchivos generador = new GeneradorDeArchivos();

        List<String> conversion = new ArrayList<>();

        String menu = """
                \n***************************************************
                *** Conversor de Monedas ***
                
                1) Peso Chileno ==>> Dólar Estadounidense
                2) Peso Chileno ==>> Euro
                3) Peso Chileno ==>> Peso Mexicano
                4) Dólar Estadounidense ==>> Peso Chileno
                5) Euro ==>> Peso Chileno
                6) Peso Mexicano ==>> Peso Chileno
                7)Otras Conversiones
                8)Salir
                
       
                ***************************************************
                """;

        while (opcionMenu != 8) {
            try {
                System.out.println(menu);
                opcionMenu = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionMenu) {
                    case 1:
                        calculos.almacenarValores("CLP", "USD");
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("CLP", "EUR");
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("CLP", "MXN");
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("USD", "CLP");
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("EUR", "CLP");
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("MXN", "CLP");
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        calculos.almacenarValoresPersonalizados();
                        conversion.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println("Ingrese un número de opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }
        }
        generador.guardarJson(conversion);

        System.out.println("Finalizando programa");
    }
}
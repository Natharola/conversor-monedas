import java.util.Scanner;


public class Calculos {
    private String monedaBase;
    private String monedaObjetivo;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultaConversionMoneda conversion;


    public Calculos(ConsultaConversionMoneda conversion) {
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void almacenarValores(String monedaBase, String monedaObjetivo){
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;

        System.out.println("Ingrese el valor que deseas convertir");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }

    public void almacenarValoresPersonalizados(){
        String menuOtrasOpciones = """
                Código moneda    Nombre de la moneda                     País
                DEA              Dírham de los Emiratos Árabes Unidos	Emiratos Árabes Unidos
                AFN	             Afgano afgano	                        Afganistán
                TODO	         Lek albanés	                        Albania
                AMD	             Dram armenio	                        Armenia
                ANG	             Florín de las Antillas Neerlandesas    Antillas Neerlandesas
                AOA	             Kwanza angoleño	                    Angola
                ARS	             Peso argentino	                        Argentina
                AWG	             Florín de Aruba	Aruba
                AZN	             Manat azerbaiyano	                    Azerbaiyán
                BAM         	 Bosnia y Herzegovina Mark	            Bosnia y Herzegovina
                BBD	             Dólar de Barbados	                    Barbados
                BDT	             Taka de Bangladesh	                    Bangladés
                BGN	             Lev búlgaro	                        Bulgaria
                BHD	             Dinar bareiní	                        Baréin
                BIF	             Franco burundiano	                    Burundi
                DMO	             Dólar de Bermudas	                    islas Bermudas
                BND	             Dólar de Brunéi	                    Brunéi
                BRL	             Real brasileño	                        Brasil
                BSD	             dólar bahameño	                        Bahamas
                BTN	             Ngultrum butanés	                    Bután
                BWP	             Pula de Botsuana	                    Botsuana
                BYN	             Rublo bielorruso	                    Bielorrusia
                BZD	             Dólar de Belice	                    Belice
                CDF	             Franco congoleño	                    República Democrática del Congo
                CHF	             franco suizo	                        Suiza
                CLP	             Peso chileno	                        Chile
                CRC	             Colón costarricense	                Costa Rica
                CVE	             Escudo caboverdiano	                Cabo Verde
                DJF	             Franco yibutiano	                    Yibuti
                DZD	             Dinar argelino	                        Argelia
                EGP	             Libra egipcia	                        Egipto
                ERN	             Nakfa de Eritrea	                    Eritrea
                ETB	             Birr etíope	                        Etiopía
                FJD	             Dólar de Fiji	                        Fiyi
                FKP	             Libra de las Islas Malvinas	        Islas Malvinas
                FOK	             Corona feroesa	                        Islas Feroe
                GBP	             Libra esterlina	                    Reino Unido
                GEL	             Lari georgiano	                        Georgia
                GGP	             Libra de Guernsey	                    Guernsey
                SGA	             Cedi ghanés	                        Ghana
                GIP              Libra de Gibraltar	                    Gibraltar
                GMD	             Dalasi gambiano	                    Gambia
                GNF	             Franco guineano	                    Guinea
                GTQ	             Quetzal guatemalteco	                Guatemala
                HNL	             Lempira hondureña	                    Honduras
                HRK	             Kuna croata	                        Croacia
                HTG	             Gourde haitiano	                    Haití
                HUF	             florín húngaro	                        Hungría
                IDR	             Rupia indonesia	                    Indonesia
                ILS	             Nuevo shekel israelí	                Israel 
                INR	             Rupia india	                        India
                TIR	             Rial iraní	                            Irán
                JEP	             Libra de Jersey	                    Jersey
                JMD	             dólar jamaicano	                    Jamaica
                Yen              japonés	                            Japón
                KES	             chelín keniano	                        Kenia
                KGS	             Som kirguís	                        Kirguistán
                KHR	             Riel camboyano	                        Camboya
                KMF	             Franco comorense	                    Comoras
                WON              Won surcoreano	                        Corea del Sur
                KWD	             Dinar kuwaití	                        Kuwait
                KYD	             Dólar de las Islas Caimán	            Islas Caimán
                KZT	             Tenge kazajo	                        Kazajstán
                LAK	             Kip lao	                            Laos
                LKR	             Rupia de Sri Lanka	                    Sri Lanka
                LRD	             Dólar liberiano	                    Liberia
                LSL	             Loti de Lesoto	                        Lesoto
                LYD	             Dinar libio	                        Libia
                MDL	             Leu moldavo	                        Moldavia
                MGA	            Ariary malgache	                        Madagascar
                MKD	            Denar macedonio	                        Macedonia del Norte
                MMK	            Kyat birmano	                        Myanmar
                MNT	            Tögrög mongol	                        Mongolia
                MVR	            Rufiyaa de Maldivas             	    Maldivas
                MWK	            Kwacha de Malawi	                    Malawi
                MXN	            Peso mexicano	                        México
                Myr	            Ringgit de Malasia	                    Malasia
                MZN	            Metical mozambiqueño	                Mozambique
                NAD	            Dólar namibio	                        Namibia
                NGN	            naira nigeriana	                        Nigeria
                NIO	            Córdoba nicaragüense	                Nicaragua
                NPR         	Rupia nepalí	                        Nepal
                OMR	            Rial omaní	                            Omán
                PAB	            Balboa panameño	                        Panamá
                PGK	            Kina de Papúa Nueva Guinea	            Papúa Nueva Guinea
                PHP	            Peso filipino	                        Filipinas
                PKR	            Rupia pakistaní	                        Pakistán
                PLN	            Zloty polaco	                        Polonia
                PYG	            guaraní paraguayo	                    Paraguay
                QAR         	Riyal catarí	                        Katar
                RON	            Leu rumano	                            Rumania
                RSD	            Dinar serbio	                        Serbia
                SAR	            Riyal saudí	                            Arabia Saudita
                SBD	            Dólar de las Islas Salomón	            Islas Salomón
                SCR	            Rupia de Seychelles	                    Seychelles
                SHP	            Libra de Santa Elena	                Santa Elena
                LES	            Sierra Leona Leona	                    Sierra Leona
                SRD	            Dólar surinamés	                        Surinam
                SSP	            Libra sursudanesa	                    Sudán del Sur
                STN	            Santo Tomé y Príncipe Dobra	            Santo Tomé y Príncipe
                SYP	            Libra siria	                            Siria
                SZL	            Eswatini Lilangeni	                    Esuatini
                TJS	            Somoni tayiko	                        Tayikistán
                TND	            Dinar tunecino	                        Túnez
                TTD	            Dólar de Trinidad y Tobago	            Trinidad y Tobago
                TVD	            Dólar de Tuvalu	                        Tuvalu
                TWD	            Nuevo dólar taiwanés	                Taiwán
                TZS	            chelín tanzano	                        Tanzania
                UAH	            Grivna ucraniana	                    Ucrania
                UYU	            Peso uruguayo	                        Uruguay
                UZS	            So'm uzbeko	                            Uzbekistán
                VES	            Bolívar Soberano venezolano	            Venezuela
                VUV	            Vatu de Vanuatu	                        Vanuatu
                XAF	            Franco CFA de África Central	        CEMAC
                XCD	            Dólar del Caribe Oriental	            Organización de Estados del Caribe Oriental
                XDR	            Derechos especiales de giro	            Fondo Monetario Internacional
                XOF	            Franco CFA de                           África Occidental	CFA
                XPF	            Franco CFP	                            Colectividades de Outre-Mer
                ZAR	            Rand sudafricano	                    Sudáfrica
                ZMW	            Kwacha zambiano	                        Zambia
                ZWL	            dólar zimbabuense	                    Zimbabue
                """;
        System.out.println(menuOtrasOpciones);
        System.out.println("Ingrese la moneda base con 3 letras");
        this.monedaBase = lectura.next();
        System.out.println("Ingrese la moneda objetivo con 3 letras");
        this.monedaObjetivo = lectura.next();

        boolean entradaValida = false;
        do {
            System.out.println("Ingrese el valor que deseas convertir");
            if (lectura.hasNextDouble()) {
                this.cantidad = lectura.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Error. Ingrese un valor numérico.");
                lectura.next(); // Limpiar el buffer de entrada
            }
        } while (!entradaValida);
    }

    public String obtenerMensajeRespuesta() {
        String mensaje = getMonedaBase().toUpperCase() + " " + getCantidad() + " equivale a: " + getMonedaObjetivo().toUpperCase() + " " + conversion.buscaConversion(getMonedaBase(), getMonedaObjetivo(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}
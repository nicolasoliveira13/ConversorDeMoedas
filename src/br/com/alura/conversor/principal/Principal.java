package br.com.alura.conversor.principal;

import br.com.alura.conversor.consultas.ConsultaCambio;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("""
                Menu: 
                1 - Real
                2 - Dólar
                3 - Peso Argentino
                4 - Peso Boliviano
                5 - Peso Chileno
                6 - Peso Colombiano
                """);

        Scanner leitura = new Scanner(System.in);
        System.out.println("Escolha a moeda a ser convertida:");
        int primeiraEscolha = leitura.nextInt();
        String primeiraMoedaEscolhida;
        switch (primeiraEscolha){
            case 1:
                primeiraMoedaEscolhida = "BRL"; //Real
                break;
            case 2:
                primeiraMoedaEscolhida = "USD"; // Dolar
                break;
            case 3:
                primeiraMoedaEscolhida = "ARS"; // Peso Argentino
                break;
            case 4:
                primeiraMoedaEscolhida = "BOB"; // Peso Boliviano
                break;
            case 5:
                primeiraMoedaEscolhida = "CLP"; // Peso Chileno
                break;
            case 6:
                primeiraMoedaEscolhida = "COP"; // Peso Colombiano
                break;
            default:
                primeiraMoedaEscolhida = "Escolha uma opção válida!";
                break;
        }

        System.out.println("Escolha para qual moeda quer converter:");
        int segundaEscolha = leitura.nextInt();
        String segundaMoedaEscolhida = "";
        switch (segundaEscolha){
            case 1:
                segundaMoedaEscolhida = "BRL"; //Real
                break;
            case 2:
                segundaMoedaEscolhida = "USD"; // Dolar
                break;
            case 3:
                segundaMoedaEscolhida = "ARS"; // Peso Argentino
                break;
            case 4:
                segundaMoedaEscolhida = "BOB"; // Peso Boliviano
                break;
            case 5:
                segundaMoedaEscolhida = "CLP"; // Peso Chileno
                break;
            case 6:
                segundaMoedaEscolhida = "COP"; // Peso Colombiano
                break;
            default:
                segundaMoedaEscolhida = "Escolha uma opção válida!";
                break;
        }
        System.out.println("Qual valor quer converter: ");
        double valor = leitura.nextInt();

        ConsultaCambio novaConsulta = new ConsultaCambio();

        try {
            String novoCambio = novaConsulta.buscaCambio(primeiraMoedaEscolhida);

            JsonParser parser = new JsonParser();
            JsonObject object = parser.parse(novoCambio).getAsJsonObject();

            JsonObject cambioSelecionado = object.getAsJsonObject("conversion_rates");

            double valorDaSegundaMoeda = cambioSelecionado.get(segundaMoedaEscolhida).getAsDouble();
            double valorConvertido = valor * valorDaSegundaMoeda;
            System.out.println(valor + " " + primeiraMoedaEscolhida + " equivalem a " + valorConvertido + " " + segundaMoedaEscolhida);

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizado");
        }

    }
}
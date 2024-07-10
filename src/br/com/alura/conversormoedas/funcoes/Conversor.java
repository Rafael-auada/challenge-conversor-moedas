package br.com.alura.conversormoedas.funcoes;

import br.com.alura.conversormoedas.modelos.Moeda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Conversor {
    // criação do método público converterMoeda, que retorna um objeto do tipo Moeda, recebendo 2 strings moeda1 e 2 e a quantia do tipo double
    public Moeda converterMoeda(String moeda1, String moeda2, double quantia) {
        // declaração do URI endereço, criando um endereço dinamicamente de acordo com o parâmetro moeda1 (ex: BRL)
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/78215d129ef8b4e199333b37/latest/" + moeda1);

        // criação de uma request para o endereco criado anteriormente, para consumir dados da API Exchange-api
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        // inicia-se a tentativa de obter resposta da API com o try
        try {
            // cria-se o pedido de resposta para a API utilizando a request criada antes
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // cria-se uma string chamada json que recebe o corpo da resposta vinda da API
            String json = response.body();

            // criado objeto moeda do tipo Moeda recebendo um novo Gson, que passará a resposta json para o tipo Moeda.class
            Moeda moeda = new Gson().fromJson(json, Moeda.class);
            // cria-se um Map conversionRates que busca valores Double atribuídos a strings dentro do conversion-rates
            // encontrado pelo método getcConversionRates do objeto moeda (conversion-rates é um array do json da API)
            Map<String, Double> conversionRates = moeda.getConversionRates();
            // cria-se um double taxaDeConversao que busca o valor para conversão na moeda2 dentro do json da moeda1
            double taxaDeConversao = conversionRates.get(moeda2);

            System.out.println("Taxa de conversão de " + moeda1 + " para " + moeda2 + ": " + taxaDeConversao);
            System.out.println("Valor convertido em %s: %.2f".formatted(moeda2, quantia*taxaDeConversao));
            return moeda;
            // começa a identificação de Exceptions no código para imprimir mensagem caso houver
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço da primeira moeda", e);
        }
    }
}

package br.com.alura.conversormoedas.modelos;

import java.util.Map;

public class Moeda {
    // como o valor buscado na API para uma moeda sempre será 1 e as outras em relação a ela que mudam, precisamos apenas
    // do conversion_rates, que será do tipo Map e procura valores double atribuídos a strings no JSON da API
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
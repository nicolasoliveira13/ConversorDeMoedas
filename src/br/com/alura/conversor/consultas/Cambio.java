package br.com.alura.conversor.consultas;

import java.util.Map;

public record Cambio(Map<String, Double> conversion_rates) {
}
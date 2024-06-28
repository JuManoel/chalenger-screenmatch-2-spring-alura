package edu.alura.famousphrases.service;

public interface IConvertirDatos {
    <T> T obterDados(String json, Class<T> clase);
}

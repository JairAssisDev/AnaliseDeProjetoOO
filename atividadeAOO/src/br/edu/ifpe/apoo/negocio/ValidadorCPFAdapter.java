package br.edu.ifpe.apoo.negocio;

import java.util.regex.Pattern;

public class ValidadorCPFAdapter implements ValidadorCPF {
    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    @Override
    public boolean validarCPF(String cpf) {
        return CPF_PATTERN.matcher(cpf).matches();
    }
}
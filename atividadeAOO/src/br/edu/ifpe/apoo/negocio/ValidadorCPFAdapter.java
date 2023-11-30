package br.edu.ifpe.apoo.negocio;


import br.edu.ifpe.apoo.negocio.validar.CpfValidator;

public class ValidadorCPFAdapter implements ValidadorCPF {
    public ValidadorCPFAdapter() {}
    @Override
    public boolean validarCPF(String cpf) {
        return CpfValidator.isCPF(cpf);
    }
}
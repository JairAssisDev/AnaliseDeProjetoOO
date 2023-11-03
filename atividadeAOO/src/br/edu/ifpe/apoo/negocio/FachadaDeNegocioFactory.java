package br.edu.ifpe.apoo.negocio;

public class FachadaDeNegocioFactory {
	
	public static FachadaDeNegocio instancia;
	
	public static FachadaDeNegocio getInstancia() {
		return (instancia==null) ? new FachadaDeNegocio(): instancia;
	}
}

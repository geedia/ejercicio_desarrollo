package coop.tecso.examen.config;

public enum TipoTitular {
	
	PERSONA_FISICA("F"),
	PERSONA_JURIDICA("J");
	
	private final String tipo;
	
	TipoTitular(String tipo){
		this.tipo= tipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}

}

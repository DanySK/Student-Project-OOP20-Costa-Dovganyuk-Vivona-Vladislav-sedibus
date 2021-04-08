package model.utili;

public class Cliente  {

	private String nome;
	private String cognome;
	private String email;
	private String nTelefono;
	
	public Cliente(String nomeCliente, String cognomeCliente, String emailCliente, String telefonoCliente) {
		this.nome = nomeCliente;
		this.cognome = cognomeCliente;
		this.email = emailCliente;
		this.nTelefono = telefonoCliente;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getEmail() {
		return this.email;
	}

	public String getTelefono() {
		return this.nTelefono;
	}

}

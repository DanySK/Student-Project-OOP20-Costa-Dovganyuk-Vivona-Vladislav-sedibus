package model;

public class ClienteImpl implements Cliente {

	private String nome;
	private String cognome;
	private String email;
	private String nTelefono;
	
	public ClienteImpl(String nomeCliente, String cognomeCliente, String emailCliente, String telefonoCliente) {
		this.nome = nomeCliente;
		this.cognome = cognomeCliente;
		this.email = emailCliente;
		this.nTelefono = telefonoCliente;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getCognome() {
		return this.cognome;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getTelefono() {
		return this.nTelefono;
	}

}

package model.utili;

public class Cliente  {

	private static final String REGEX_NOME_COGN = ".*\\d.*";  //significa: un qualsiasi carattere è una cifra da 0 a 9
	private static final String REGEX_TEL = "[0-9]+";  //significa: solo cifre
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
	
	public boolean rispettaControlli() {
		return this.controlloNome(this.nome) && this.controlloCognome(this.cognome) && 
			   this.controlloEmail(this.email) && this.controlloTelefono(this.nTelefono);
	}
	
	private boolean controlloNome(String nome) {
		return !this.haNumeri(nome) && !this.campoVuoto(nome);
	}
	
	private boolean controlloCognome(String cognome) {
		return !this.haNumeri(cognome) && !this.campoVuoto(cognome);
	}
	
	private boolean controlloEmail(String email) {
		return email.contains("@") && email.contains(".") && !this.campoVuoto(email);
	}
	
	private boolean controlloTelefono(String telefono) {
		return telefono.matches(REGEX_TEL) && !this.campoVuoto(telefono);
	}
	
	private boolean haNumeri(String s) {
		return s.matches(REGEX_NOME_COGN);
	}
	
	private boolean campoVuoto(String s) {
		return s.isEmpty() || s.isBlank();
	}

}

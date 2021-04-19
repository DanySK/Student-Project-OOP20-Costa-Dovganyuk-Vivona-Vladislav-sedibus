package model.riepilogo;

public interface ModelRiepilogo {

	/**
	 * @return il nome preso dalla prenotazione del cliente
	 */
	String getNome();
	
	/**
	 * @return il cognome preso dalla prenotazione del cliente
	 */
	String getCognome();
	
	/**
	 * @return l'email presa dalla prenotazione del cliente
	 */
	String getEmail();
	
	/**
	 * @return il telefono preso dalla prenotazione del cliente
	 */
	String getTelefono();
	
	/**
	 * @return il numero dei posti occupati dal cliente
	 */
	String getPosti();
	
	/**
	 * @return il codice prenotazione del cliente
	 */
	String getCodice();
	
}

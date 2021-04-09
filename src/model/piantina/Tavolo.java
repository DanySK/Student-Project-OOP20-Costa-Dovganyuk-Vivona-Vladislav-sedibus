package model.piantina;



public class Tavolo  {
	
	private static final long serialVersionUID = 1L;
	private int name;
	private int maxPosti;
	
	public Tavolo(int name, int maxPosti) {
		this.name = name;
		this.maxPosti = maxPosti;
	}

	
	public int getName() {
		return this.name;
	}

	
	public int getMaxPosti() {
		return this.maxPosti;
	}
	

}

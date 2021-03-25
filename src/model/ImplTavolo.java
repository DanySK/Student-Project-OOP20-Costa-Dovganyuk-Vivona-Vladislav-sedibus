package model;



public class ImplTavolo implements Tavolo, java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int name;
	private int maxPosti;
	
	public ImplTavolo(int name, int maxPosti) {
		this.name = name;
		this.maxPosti = maxPosti;
	}

	@Override
	public int getName() {
		return this.name;
	}

	@Override
	public int getMaxPosti() {
		return this.maxPosti;
	}
	

}

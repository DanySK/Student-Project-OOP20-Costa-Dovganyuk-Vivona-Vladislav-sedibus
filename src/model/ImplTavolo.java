package model;

public class ImplTavolo implements Tavolo {

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

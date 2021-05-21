package q17;

public class Quadrado {
	private double alt;
	private double larg;
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public double getLarg() {
		return larg;
	}
	public void setLarg(double larg) {
		this.larg = larg;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj instanceof Quadrado) {
			Quadrado q = (Quadrado) obj;
			if( (this.getAlt() == q.getAlt()) && (this.getLarg() == q.getLarg()) ) {
				return true;
			}
		}
		return false;
	}
}

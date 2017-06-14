package fr.laposte.pizza;

public class Base {
	protected String nomB;
	protected int prix;
	
	public Base(String nomB) {
		super();
		this.nomB = nomB;
	}

	public int calculerPrixBase() {
		if (this.nomB.equals("BT")) {
			prix = 1;
		} else {
			prix = 2;
			System.out.println(this.nomB);
		}
		return prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomB == null) ? 0 : nomB.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Base other = (Base) obj;
		if (nomB == null) {
			if (other.nomB != null)
				return false;
		} else if (!nomB.equals(other.nomB))
			return false;
		return true;
	}
	
	

}

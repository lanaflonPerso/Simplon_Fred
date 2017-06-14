package co.simplon.laposte.bean;

public class Bselect {
	
	private Bproprio proprio;
	private Blogement logement;
	private Bresa planning;
	private boolean select;
	private int id;

	public Bproprio getProprio() {
		return proprio;
	}
	public Blogement getLogement() {
		return logement;
	}
	public Bresa getPlanning() {
		return planning;
	}
	public boolean isSelect() {
		return select;
	}
	public int getId() {
		return id;
	}

	public void setProprio(Bproprio proprio) {
		this.proprio = proprio;
	}
	public void setLogement(Blogement logement) {
		this.logement = logement;
	}
	public void setPlanning(Bresa planning) {
		this.planning = planning;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public void setId(int id) {
		this.id = id;
	}

}

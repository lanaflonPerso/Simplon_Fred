	import java.util.ArrayList;

	public class Chronopost {
		protected ArrayList<Transporteur> garage;
		protected ArrayList<Colis> stockColis;


		public Chronopost() {
			this.garage = new ArrayList<>();
			this.stockColis = new ArrayList<>();
		}

		public void creerVehicule() {
			this.garage.add(new Transporteur("Renault", "Kangoo", "345 WX 54", 100, 1));
			this.garage.add(new Transporteur("Renault", "Traffic", "987 AGF 74", 300, 2));
		}

		public void creerColis() {
			this.stockColis.add(new Colis(10));
			this.stockColis.add(new Colis(100));
		}

		public void afficherVoiture() {
			for (Transporteur voiture : garage) {
					System.out.println(voiture.getMarque() + " - " + voiture.getModele() + " - " + voiture.getEnergie());
			}
		}
		
		public void afficherColis() {
			for (Colis paquet : stockColis) {
				System.out.println(paquet.getTaille() + " - " + paquet.getGabarit());
			}
		}

	}

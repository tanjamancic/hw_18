package domaci;

public class Ocena {

	private int bodovi;
	private Predmet pr;
	private int ocena;

	public Ocena(int bodovi, Predmet pr) {
		super();
		this.bodovi = bodovi;
		this.pr = pr;
	}

	public int getBodovi() {
		return bodovi;
	}

	public Predmet getPr() {
		return pr;
	}

	public int getOcena() {
		if (bodovi > 0 && bodovi < 50) {
			ocena = 5;
		} else if (bodovi < 60) {
			ocena = 6;
		} else if (bodovi < 70) {
			ocena = 7;
		} else if (bodovi < 80) {
			ocena = 8;
		} else if (bodovi < 90) {
			ocena = 9;
		} else {
			ocena = 10;
		}
		return ocena;
	}

	public String ispisOcena() {
		return "Predmet: " + pr + " , Ocena: " + ocena;
	}
}

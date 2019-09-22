package domaci;

import java.util.Calendar;

public class Student {

	private String potpis;
	private String jmbg;
	private Ocena[] upisaneOcene;
	private String dan;
	private String mesec;
	private int god;
	public static final int godinaTekuca = Calendar.getInstance().get(Calendar.YEAR);
	private int starost;

	public Student(String potpis, String jmbg, Ocena[] upisaneOcene) {
		this.potpis = potpis;
		this.jmbg = jmbg;
		this.upisaneOcene = upisaneOcene;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		String[] splitovanPotpis = potpis.split(" ");
		return splitovanPotpis[0];
	}

	public String getPrezime() {
		String[] splitovanPotpis = potpis.split(" ");
		return splitovanPotpis[1];
	}

	public double getProsecnaOcena() {
		double suma = 0, brojacPrelaznih = 0;
		for (int i = 0; i < upisaneOcene.length; i++) {
			if (upisaneOcene[i].getOcena() > 5) {
				suma += upisaneOcene[i].getOcena();
				brojacPrelaznih++;
			}
		}
		return suma / brojacPrelaznih;
	}

	public String getDatumRodjenja() {
		dan = jmbg.substring(0, 2);
		mesec = jmbg.substring(2, 4);
		god = Integer.parseInt(jmbg.substring(4, 7));
		if (god % 100 < godinaTekuca % 100) {
			god = god + 2000;
		} else {
			god = god + 1000;
		}
		starost = godinaTekuca - god;
		return dan + ". " + mesec + ". " + god + ". ";
	}

	public String najboljaOcena() {
		Ocena najOcena = upisaneOcene[0];
		for (int i = 1; i < upisaneOcene.length; i++) {
			if (upisaneOcene[i].getBodovi() > najOcena.getBodovi()) {
				najOcena = upisaneOcene[i];
			}
		}
		return najOcena.getPr().getIme();
	}

	public static boolean starijiOd(Student s, int god) {
		s.getDatumRodjenja();
		return god <= s.starost;
	}

	public static Student[] prosekVeciOd(Student[] nizStudenata, double ocena) {
		int brojac = 0;
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i].getProsecnaOcena() > ocena) {
				brojac++;
			}
		}
		Student[] nizStudenataSaProsekomVecimOdZadatog = new Student[brojac];
		int i = 0;
		for (int j = 0; j < nizStudenata.length; j++) {
			if (nizStudenata[j].getProsecnaOcena() > ocena) {
				nizStudenataSaProsekomVecimOdZadatog[i] = nizStudenata[j];
				i++;
			}
		}
		return nizStudenataSaProsekomVecimOdZadatog;
	}
}

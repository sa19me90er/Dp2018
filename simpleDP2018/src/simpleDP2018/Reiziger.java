package simpleDP2018;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;



public class Reiziger {

	private int idNr;
	private String vLetter;
	private String tusVgls;
	private String naam;
	private Date gbdatum;
	private List<OvChipkaart> karten;

	public Reiziger(int id, String vLtr, String tusvgl, String nm, Date gbdtm) {
		idNr = id;
		vLetter = vLtr;
		tusVgls = tusvgl;
		naam = nm;
		gbdatum = gbdtm;
			}

	public List<OvChipkaart> getKarten() {
		return karten;
	}

	public void setKarten(List<OvChipkaart> karten) {
		this.karten = karten;
	}

	public int getIdNr() {
		return idNr;
	}

	public String getVLetter() {
		return vLetter;
	}

	public String getTusVgls() {
		return tusVgls;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getGBdatum() {
		return gbdatum;
	}

	public void setGBdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Reiziger) {
			Reiziger andereReiziger = (Reiziger) obj;

			if (this.idNr == andereReiziger.idNr) {

				return true;
			}

		}
		return false;
	}

	@Override
	public String toString() {
		if (tusVgls == null) {
			return "[" + idNr + ", " + vLetter + " " + naam + ", " + gbdatum + karten+"]";
		} else
			return "[" + idNr + ", " + vLetter + " " + tusVgls + " " + naam + ", " + gbdatum + karten+"]";
	}

	public String toString2() {
		if (tusVgls == null) {
			return "[" + idNr + ", " + vLetter + " " + naam + ", " + gbdatum +"]";
		} else
			return "[" + idNr + ", " + vLetter + " " + tusVgls + " " + naam + ", " + gbdatum + "]";
	}

}

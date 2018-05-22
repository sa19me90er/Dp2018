package simpleDP2018;

import java.sql.Date;

public class OvChipkaart {
	private int kaartNummer;
	private String geldigTot;
	private int klasse;
	private double saldo;
	private int reizegerID;
	private Reiziger ovhouder;
	
OvChipkaart(int knr, String gt, int kls, double sld, int rID ){
	kaartNummer=knr;
	geldigTot=gt;
	klasse=kls;
	saldo=sld;
	reizegerID=rID;	
	}



public Reiziger getOvhouder() {
	return ovhouder;
}



public void setOvhouder(Reiziger ovhouder) {
	this.ovhouder = ovhouder;
}



public int getKaartNummer(){
	return kaartNummer;	
}

public void setKaartNummer(int k){
	kaartNummer=k;	
}

public String getGeldigTot(){
	return geldigTot;	
}

public void setGeldigTot(String gl){
	geldigTot=gl;	
}

public int getKlasse(){
	return klasse;	
}

public void setKlasse(int kls){
	klasse=kls;	
}

public double getSaldo(){
	return saldo;	
}

public void setSaldo(double sld){
	saldo=sld;	
}

public int getReizegerID(){
	return reizegerID;	
}

public void setReizegerID(int rId){
	reizegerID=rId;	
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OvChipkaart other = (OvChipkaart) obj;
	if (kaartNummer != other.kaartNummer)
		return false;
	return true;
}

@Override
public String toString() {
	return "OvChipkaart [kaartNummer=" + kaartNummer + ", geldigTot=" + geldigTot + ", klasse=" + klasse + ", saldo="
			+ saldo + ", reizegerID=" + reizegerID + ", Reiziger= " +ovhouder.toString2()+ "]";
}



}

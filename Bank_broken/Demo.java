import java.util.ArrayList;

class Konto{
	private String name;
	private String adresseBesitzer;
	private String kontonummer;
	private int saldo;
	private int kreditLimit;

	public Konto(String name, String adresseBesitzer, String kontonummer, int saldo, int kreditLimit) {
		this.name = name;
		this.adresseBesitzer = adresseBesitzer;
		this.kontonummer = kontonummer;
		this.saldo = saldo;
		this.kreditLimit = kreditLimit;
	}

	public void einzahlen(int betrag){
		this.saldo += betrag;
	}

	public void auszahlen(int betrag){
		if (this.saldo <= this.kreditLimit){
			System.out.println("You are broke af");
		} else {
			this.saldo -= betrag;
		}
	}

	public void saldo(){
		System.out.println(saldo);
	}

	public void anpassenLimit(int limite){
		this.kreditLimit = limite;
	}

	public String holname(){
		return (this.name);
	}

	public String holadresseBesitzer(){
		return (this.adresseBesitzer);
	}

	public String holkontonummer(){
		return (this.kontonummer);
	}

	public int holsaldo(){
		return (this.saldo);
	}

	public int holkreditLimit(){
		return (this.kreditLimit);
	}
}

class Bank{
	//Das sind Objektfelder, leere Variablen, sind zur Zeit leer
	private String bankName;
	private int bankLeitzahl;
	private String iban;
	//Das ist ein Array, mit Konto objekten drinnen die er von der class Konto referemziert 
	private ArrayList<Konto> konti;
	
	//Das ist ein Template, mit diesem kann ich am ende 5 verschiedene Banken anzeigen anstelle von 5x die gleiche Variable zu überschreiben und mit der letzten zu bleiben
	public Bank(String bankName, int bankLeitzahl, String iban){
		this.bankName =  bankName;
		this.bankLeitzahl = bankLeitzahl;
		this.iban = iban;
	}

	//void ist wenn nichts zurückgegeben werden muss
	public void anlegen(Konto konto) {
		this.konti.add(konto);
	}

	public void löschen(Konto konto){
		this.konti.remove(konto);
	}

	public void auflisten(){
		for (Konto konto : konti){
			System.out.println(konto.holname());
			System.out.println(konto.holadresseBesitzer());
			System.out.println(konto.holkontonummer());
			System.out.println(konto.holsaldo());
			System.out.println(konto.holkreditLimit());
		}
	}
}

public class Demo{ 
	public static void main(String[] args){
	Bank postfinance = new Bank("Postfinance", 76, "666");
	postfinance.anlegen(new Konto("Hank Anderson", "Sumo 666 Detroit Michigan", "1", 313248, 10000000 ));
	postfinance.anlegen(new Konto("Connor Anderson", "Thirium 313 Detroit Michigan", "2", 5, 5000));
	postfinance.auflisten();
	}
}

import java.util.ArrayList; // Importiert die ArrayList-Klasse aus dem java.util-Paket

// Klassendefinition für Konto, repräsentiert ein Bankkonto
class Konto {
    private String name; // Variable zur Speicherung des Namens des Kontoinhabers
    private String adresseBesitzer; // Variable zur Speicherung der Adresse des Kontoinhabers
    private String kontonummer; // Variable zur Speicherung der Kontonummer
    private int saldo; // Variable zur Speicherung des Kontostands
    private int kreditLimit; // Variable zur Speicherung des Kreditlimits für das Konto

    // Konstruktor zur Initialisierung eines neuen Konto-Objekts mit den gegebenen Parametern
    public Konto(String name, String adresseBesitzer, String kontonummer, int saldo, int kreditLimit) {
        this.name = name; // Setzt den Namen des Kontoinhabers
        this.adresseBesitzer = adresseBesitzer; // Setzt die Adresse des Kontoinhabers
        this.kontonummer = kontonummer; // Setzt die Kontonummer
        this.saldo = saldo; // Setzt den anfänglichen Kontostand
        this.kreditLimit = kreditLimit; // Setzt das Kreditlimit für das Konto
    }

    // Methode, um einen bestimmten Betrag auf das Konto einzuzahlen
    public void einzahlen(int betrag) {
        this.saldo += betrag; // Erhöht den Kontostand um den eingezahlten Betrag
    }

    // Methode, um einen bestimmten Betrag vom Konto abzuheben
    public void auszahlen(int betrag) {
        // Prüft, ob der Kontostand innerhalb des Kreditlimits liegt, bevor die Abhebung erlaubt wird
        if (this.saldo <= this.kreditLimit) {
            System.out.println("You are broke af"); // Gibt eine Nachricht aus, wenn der Kontostand zu niedrig ist
        } else {
            this.saldo -= betrag; // Verringert den Kontostand um den abgehobenen Betrag
        }
    }

    // Methode, um den aktuellen Kontostand des Kontos auszugeben
    public void saldo() {
        System.out.println(saldo); // Gibt den aktuellen Kontostand aus
    }

    // Methode, um das Kreditlimit des Kontos anzupassen
    public void anpassenLimit(int limite) {
        this.kreditLimit = limite; // Setzt ein neues Kreditlimit für das Konto
    }

    // Getter-Methode, um den Namen des Kontoinhabers zurückzugeben
    public String holname() {
        return this.name; // Gibt den Namen des Kontoinhabers zurück
    }

    // Getter-Methode, um die Adresse des Kontoinhabers zurückzugeben
    public String holadresseBesitzer() {
        return this.adresseBesitzer; // Gibt die Adresse des Kontoinhabers zurück
    }

    // Getter-Methode, um die Kontonummer zurückzugeben
    public String holkontonummer() {
        return this.kontonummer; // Gibt die Kontonummer zurück
    }

    // Getter-Methode, um den Kontostand zurückzugeben
    public int holsaldo() {
        return this.saldo; // Gibt den aktuellen Kontostand zurück
    }

    // Getter-Methode, um das Kreditlimit zurückzugeben
    public int holkreditLimit() {
        return this.kreditLimit; // Gibt das Kreditlimit des Kontos zurück
    }
}

// Klassendefinition für Bank, repräsentiert eine Bank, die mehrere Konten verwaltet
class Bank {
    private String bankName; // Variable zur Speicherung des Namens der Bank
    private int bankLeitzahl; // Variable zur Speicherung der Bankleitzahl
    private String iban; // Variable zur Speicherung der IBAN der Bank
    private ArrayList<Konto> konti = new ArrayList<>(); // Liste zur Speicherung mehrerer Konto-Objekte (Konten)

    // Konstruktor zur Initialisierung eines neuen Bank-Objekts mit den gegebenen Parametern
    public Bank(String bankName, int bankLeitzahl, String iban) {
        this.bankName = bankName; // Setzt den Namen der Bank
        this.bankLeitzahl = bankLeitzahl; // Setzt die Bankleitzahl
        this.iban = iban; // Setzt die IBAN der Bank
    }

    // Methode, um ein neues Konto (Konto-Objekt) zur Bank hinzuzufügen
    public void anlegen(Konto konto) {
        this.konti.add(konto); // Fügt das Konto-Objekt zur Liste der Konten hinzu
    }

    // Methode, um ein Konto (Konto-Objekt) aus der Bank zu entfernen
    public void löschen(Konto konto) {
        this.konti.remove(konto); // Entfernt das Konto-Objekt aus der Liste der Konten
    }

    // Methode, um die Details aller Konten in der Bank aufzulisten und auszugeben
    public void auflisten() {
        // Schleife, die jedes Konto-Objekt in der Liste durchläuft und dessen Details ausgibt
        for (Konto konto : konti) {
            System.out.println(konto.holname()); // Gibt den Namen des Kontoinhabers aus
            System.out.println(konto.holadresseBesitzer()); // Gibt die Adresse des Kontoinhabers aus
            System.out.println(konto.holkontonummer()); // Gibt die Kontonummer aus
            System.out.println(konto.holsaldo()); // Gibt den Kontostand aus
            System.out.println(konto.holkreditLimit()); // Gibt das Kreditlimit des Kontos aus
        }
    }
}

// Hauptklasse mit dem Einstiegspunkt des Programms
public class Demo {
    public static void main(String[] args) {
        // Erstellt ein neues Bank-Objekt mit dem Namen "Postfinance"
        Bank postfinance = new Bank("Postfinance", 76, "666");

        // Fügt zwei neue Konto-Objekte zur "Postfinance"-Bank hinzu
        postfinance.anlegen(new Konto("Hank Anderson", "Sumo 666 Detroit Michigan", "1", 313248, 10000000));
        postfinance.anlegen(new Konto("Connor Anderson", "Thirium 313 Detroit Michigan", "2", 5, 5000));

        // Listet und gibt die Details aller Konten in der "Postfinance"-Bank aus
        postfinance.auflisten();
    }
}


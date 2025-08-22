package model;

public class Client {
    private String idCnp;
    private String nume;
    private String prenume;
    private String adresa;
    private String telefon;

    // Constructori, getteri și setteri
    public Client(String idCnp, String nume, String prenume, String adresa, String telefon) {
        this.idCnp = idCnp;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getIdCnp() {
        return idCnp;
    }

    public void setIdCnp(String idCnp) {
        this.idCnp = idCnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

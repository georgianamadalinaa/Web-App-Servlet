package model;

public class Contract {

    private int nrContract;
    private int idAngajat;
    private String codCnp;
    private int idDestinatie;
    private String dataPlecare;
    private String nrNopti;
    private String transport;
    private String sumaPlata;

    // Constructor gol
    public Contract() {}

    // Constructor cu parametri
    public Contract(int nrContract, int idAngajat, String codCnp, int idDestinatie, String dataPlecare,
                    String nrNopti, String transport, String sumaPlata) {
        this.nrContract = nrContract;
        this.idAngajat = idAngajat;
        this.codCnp = codCnp;
        this.idDestinatie = idDestinatie;
        this.dataPlecare = dataPlecare;
        this.nrNopti = nrNopti;
        this.transport = transport;
        this.sumaPlata = sumaPlata;
    }

    // Getter și setter pentru fiecare câmp

    public int getNrContract() {
        return nrContract;
    }

    public void setNrContract(int nrContract) {
        this.nrContract = nrContract;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getCodCnp() {
        return codCnp;
    }

    public void setCodCnp(String codCnp) {
        this.codCnp = codCnp;
    }

    public int getIdDestinatie() {
        return idDestinatie;
    }

    public void setIdDestinatie(int idDestinatie) {
        this.idDestinatie = idDestinatie;
    }

    public String getDataPlecare() {
        return dataPlecare;
    }

    public void setDataPlecare(String dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public String getNrNopti() {
        return nrNopti;
    }

    public void setNrNopti(String nrNopti) {
        this.nrNopti = nrNopti;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getSumaPlata() {
        return sumaPlata;
    }

    public void setSumaPlata(String sumaPlata) {
        this.sumaPlata = sumaPlata;
    }
}

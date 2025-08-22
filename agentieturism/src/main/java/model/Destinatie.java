package model;

public class Destinatie {

    private int idDestinatie;
    private String taraDes;
    private String orasDes;
    private String hotelDes;
    private String adresaDes;
    private String telefonDes;

    // Constructor gol
    public Destinatie() {}

    // Constructor cu parametri
    public Destinatie(int idDestinatie, String taraDes, String orasDes, String hotelDes, 
                      String adresaDes, String telefonDes) {
        this.idDestinatie = idDestinatie;
        this.taraDes = taraDes;
        this.orasDes = orasDes;
        this.hotelDes = hotelDes;
        this.adresaDes = adresaDes;
        this.telefonDes = telefonDes;
    }

    // Getter și setter pentru fiecare câmp

    public int getIdDestinatie() {
        return idDestinatie;
    }

    public void setIdDestinatie(int idDestinatie) {
        this.idDestinatie = idDestinatie;
    }

    public String getTaraDes() {
        return taraDes;
    }

    public void setTaraDes(String taraDes) {
        this.taraDes = taraDes;
    }

    public String getOrasDes() {
        return orasDes;
    }

    public void setOrasDes(String orasDes) {
        this.orasDes = orasDes;
    }

    public String getHotelDes() {
        return hotelDes;
    }

    public void setHotelDes(String hotelDes) {
        this.hotelDes = hotelDes;
    }

    public String getAdresaDes() {
        return adresaDes;
    }

    public void setAdresaDes(String adresaDes) {
        this.adresaDes = adresaDes;
    }

    public String getTelefonDes() {
        return telefonDes;
    }

    public void setTelefonDes(String telefonDes) {
        this.telefonDes = telefonDes;
    }
}

package pl.fotolander.fotolander.MapOfPlaces;

public class Pin {

    private double longitude; //dług
    private double latitude; //szer
    private String message;

    public Pin(double longitude, double latitude, String message) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.message = message;
    }

    public Pin() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

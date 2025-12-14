package AirlineJDBC;

public class Airline {
    private int flight_no;
    private String Airline_name;
    private int travel_duration;
    private String source_city;
    private String destination_city;
    private double fare_econ;
    private double fare_first;
    private double fare_bus;

    public Airline(int flight_no, String airline_name, int travel_duration, String source_city, String destination_city, double fare_econ, double fare_first, double fare_bus) {
        this.flight_no = flight_no;
        Airline_name = airline_name;
        this.travel_duration = travel_duration;
        this.source_city = source_city;
        this.destination_city = destination_city;
        this.fare_econ = fare_econ;
        this.fare_first = fare_first;
        this.fare_bus = fare_bus;
    }

    public Airline() {

    }

    public int getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(int flight_no) {
        this.flight_no = flight_no;
    }

    public String getAirline_name() {
        return Airline_name;
    }

    public void setAirline_name(String airline_name) {
        Airline_name = airline_name;
    }

    public int getTravel_duration() {
        return travel_duration;
    }

    public void setTravel_duration(int travel_duration) {
        this.travel_duration = travel_duration;
    }

    public String getSource_city() {
        return source_city;
    }

    public void setSource_city(String source_city) {
        this.source_city = source_city;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    public double getFare_econ() {
        return fare_econ;
    }

    public void setFare_econ(double fare_econ) {
        this.fare_econ = fare_econ;
    }

    public double getFare_first() {
        return fare_first;
    }

    public void setFare_first(double fare_first) {
        this.fare_first = fare_first;
    }

    public double getFare_bus() {
        return fare_bus;
    }

    public void setFare_bus(double fare_bus) {
        this.fare_bus = fare_bus;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "flight_no=" + flight_no +
                ", Airline_name='" + Airline_name + '\'' +
                ", travel_duration=" + travel_duration +
                ", source_city='" + source_city + '\'' +
                ", destination_city='" + destination_city + '\'' +
                ", fare_econ=" + fare_econ +
                ", fare_first=" + fare_first +
                ", fare_bus=" + fare_bus +
                '}';
    }
}
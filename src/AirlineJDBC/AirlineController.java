package AirlineJDBC;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
public class AirlineController {
    static Scanner sc = new Scanner(System.in);
    public static void flight() throws IOException, SQLException {
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("create table Airline (flight_no SERIAL, Airline_name varchar(50), travel_duration double Precision, source_city varchar(50), destination_city varchar(50), fare_econ double Precision, fare_first double Precision, fare_bus double Precision)");
        prepStat.executeUpdate();
        System.out.println("Table created.");
    }
    public static void create_Flight() throws IOException, SQLException {
        Airline al = new Airline();
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("insert into Airline (Airline_name, travel_duration, source_city, destination_city, fare_econ, fare_first, fare_bus) values(?,?,?,?,?,?,?) ");
        System.out.println(" Enter the Airline Company name");
        al.setAirline_name(sc.next());
        System.out.println(" Enter travel duration in hours: ");
        al.setTravel_duration(sc.nextInt());
        System.out.println(" Enter Source city ");
        al.setSource_city(sc.next());
        System.out.println(" Enter Destination city ");
        al.setDestination_city(sc.next());
        System.out.println(" Enter the fare for Economy Class of flight: ");
        al.setFare_econ(sc.nextDouble());
        System.out.println(" Enter the fare for First Class of flight: ");
        al.setFare_first(sc.nextDouble());
        System.out.println(" Enter the fare for Business Class of flight: ");
        al.setFare_bus(sc.nextDouble());
        prepStat.setString(1, al.getAirline_name());
        prepStat.setInt(2, al.getTravel_duration());
        prepStat.setString(3, al.getSource_city());
        prepStat.setString(4, al.getDestination_city());
        prepStat.setDouble(5, al.getFare_econ());
        prepStat.setDouble(6, al.getFare_first());
        prepStat.setDouble(7, al.getFare_bus());
        prepStat.executeUpdate();
        System.out.println( "Flight is Inserted.");
    }
    public static void find_Flight() throws IOException, SQLException {
        Airline al = new Airline();
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("select * from Airline where source_city=? and destination_city= ? ");
        System.out.println(" Enter the Source city ");
        al.setSource_city(sc.next());
        prepStat.setString(1, al.getSource_city());
        System.out.println(" Enter the Destination city");
        al.setDestination_city(sc.next());
        prepStat.setString(2, al.getDestination_city());
        ResultSet resultSet = prepStat.executeQuery();
        System.out.println(" Flight no. | Airline Name | Travel Duration | Source City | Destination City | Economy Class Fare | First Class Fare | Business Class Fare");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("flight_no") + " | " + resultSet.getString("Airline_name") + " | " + resultSet.getInt("travel_duration") + " | " + resultSet.getString("source_city") + " | " + resultSet.getString("destination_city") + " | " + resultSet.getDouble("fare_econ") + " | " + resultSet.getDouble("fare_first") + " | " + resultSet.getDouble("fare_bus"));
        }
        System.out.println(" Record is Shown.");
    }
    public static void change_Source() throws IOException, SQLException {
        Airline al = new Airline();
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("update Airline set source_city= ? where flight_no= ?");
        System.out.println(" Enter the Source city ");
        al.setSource_city(sc.next());
        System.out.println(" Enter the Flight no ");
        al.setFlight_no(sc.nextInt());
        prepStat.setString(1, al.getSource_city());
        prepStat.setInt(2, al.getFlight_no());
        prepStat.executeUpdate();
        prepStat = conn.prepareStatement("select * from Airline where flight_no = ? ;");
        prepStat.setInt(1, al.getFlight_no());
        ResultSet resultSet = prepStat.executeQuery();
        System.out.println(" Flight no. | Airline Name | Travel Duration | Source City | Destination City | Economy Class Fare | First Class Fare | Business Class Fare");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("flight_no") + " | " + resultSet.getString("Airline_name") + " | " + resultSet.getInt("travel_duration") + " | " + resultSet.getString("source_city") + " | " + resultSet.getString("destination_city") + " | " + resultSet.getDouble("fare_econ") + " | " + resultSet.getDouble("fare_first") + " | " + resultSet.getDouble("fare_bus"));
        }
        System.out.println(" Record Has Been Updated.");
    }

    public static void cheap_Flight() throws IOException, SQLException {
        Airline al = new Airline();
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("select * from  Airline where source_city=? and destination_city= ? order by fare_econ, fare_first, fare_bus asc limit 1;");
        System.out.println(" Enter the Source city ");
        al.setSource_city(sc.next());
        prepStat.setString(1, al.getSource_city());
        System.out.println(" Enter the Destination city");
        al.setDestination_city(sc.next());
        prepStat.setString(2, al.getDestination_city());
        ResultSet resultSet = prepStat.executeQuery();
        System.out.println(" Flight no. | Airline Name | Travel Duration | Source City | Destination City | Economy Class Fare | First Class Fare | Business Class Fare");
        boolean flag = false;
        while (resultSet.next()) {
            flag = true;
            System.out.println(resultSet.getInt("flight_no") + " | "  + resultSet.getString("Airline_name") + " | " + resultSet.getInt("travel_duration") + " | " + resultSet.getString("source_city") + " | " + resultSet.getString("destination_city") + " | " + resultSet.getDouble("fare_econ") + " | " + resultSet.getDouble("fare_first") + " | " + resultSet.getDouble("fare_bus"));
        }
        if(!flag)
            System.out.println(" No Flight Found between " + al.getSource_city() + " and " + al.getDestination_city());
    }
    public static void short_Duration() throws IOException, SQLException {
        Airline al = new Airline();
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("select * from  Airline where source_city=? and destination_city= ? order by travel_duration asc limit 1;");
        System.out.println(" Enter the Source city ");
        al.setSource_city(sc.next());
        prepStat.setString(1, al.getSource_city());
        System.out.println(" Enter the Destination city");
        al.setDestination_city(sc.next());
        prepStat.setString(2, al.getDestination_city());
        ResultSet resultSet = prepStat.executeQuery();
        System.out.println(" Flight no. | Airline  | Travel Duration | Source City | Destination City | Economy Class Fare | First Class Fare | Business Class Fare");
        boolean flag=false;
        while (resultSet.next()) {
            flag = true;
            System.out.println(resultSet.getInt("flight_no") + " | " + resultSet.getString("Airline_name") + " | " + resultSet.getInt("travel_duration") + " | " + resultSet.getString("source_city") + " | " + resultSet.getString("destination_city") + " | " + resultSet.getDouble("fare_econ") + " | " + resultSet.getDouble("fare_first") + " | " + resultSet.getDouble("fare_bus"));
        }
        if(!flag)
            System.out.println(" No data found.");
    }

    public static void update_Fare() throws IOException, SQLException {
        Airline al = new Airline();
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("update Airline set fare_econ = ?, fare_first = ?, fare_bus = ? where flight_no = ? ");
        System.out.println(" Enter the Fare for Flight in Economy Class ");
        al.setFare_econ(sc.nextDouble());
        System.out.println(" Enter the Fare for Flight in First Class ");
        al.setFare_first(sc.nextDouble());
        System.out.println(" Enter the Fare for Flight in Business Class ");
        al.setFare_bus(sc.nextDouble());
        System.out.println(" Enter the Flight no ");
        al.setFlight_no(sc.nextInt());
        prepStat.setDouble(1, al.getFare_econ());
        prepStat.setDouble(2, al.getFare_first());
        prepStat.setDouble(3, al.getFare_bus());
        prepStat.setInt(4, al.getFlight_no());
        prepStat.executeUpdate();
        prepStat = conn.prepareStatement("select * from Airline where flight_no = ? ;");
        prepStat.setInt(1, al.getFlight_no());
        ResultSet resultSet = prepStat.executeQuery();
        System.out.println(" Flight no. | Airline Name | Travel Duration | Source City | Destination City | Economy Class Fare | First Class Fare | Business Class Fare");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("flight_no") + " | " + resultSet.getString("Airline_name") + " | " + resultSet.getInt("travel_duration") + " | " + resultSet.getString("source_city") + " | " + resultSet.getString("destination_city") + " | " + resultSet.getDouble("fare_econ") + " | " + resultSet.getDouble("fare_first") + " | " + resultSet.getDouble("fare_bus"));
        }
        System.out.println(" The Fares of Classes of flight Has been Updated.");
    }
    public static void print_All() throws IOException, SQLException {
        Properties pro = new Properties();
        pro.load(new FileInputStream("connection.properties"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
        PreparedStatement prepStat;
        prepStat = conn.prepareStatement("select * from Airline ;");
        ResultSet resultSet = prepStat.executeQuery();
        System.out.println(" Flight no. | Airline Name | Travel Duration | Source City | Destination City | Economy Class Fare | First Class Fare | Business Class Fare");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("flight_no") + " | " + resultSet.getString("Airline_name") + " | " + resultSet.getInt("travel_duration") + " | " + resultSet.getString("source_city") + " | " + resultSet.getString("destination_city") + " | " + resultSet.getDouble("fare_econ") + " | " + resultSet.getDouble("fare_first") + " | " + resultSet.getDouble("fare_bus") );
        }
    }

    }



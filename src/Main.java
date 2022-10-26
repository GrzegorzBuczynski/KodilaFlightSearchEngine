package src;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    FlightDatabase database = new FlightDatabase();
    database.checkIfFlightExists("Berlin", "Tokyo");

    // ArrayList<Flight> fromCity = database.getFlightsFromCity("Berlin");
    // ArrayList<Flight> toCity = database.getFlightsToCity("Berlin");
    // database.displayFlights(fromCity);
    // database.displayFlights(toCity);
    // database.displayFlightsFromCity("Warsaw");
    // database.displayFlightsToCity("Tokyo");
    // System.out.println(database.getCities());
    // System.out.println("Cheapest flight : " +
    // database.getCheapestsFlightFromCity("Warsaw").getFlightInformation());
    ArrayList<Journey> journeys = database.getFlights("Paris", "Porto");
    System.out.println(journeys);
  }
}





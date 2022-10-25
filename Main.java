import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    FlightDatabase database = new FlightDatabase();
    database.checkIfFlightExists("Berlin", "Tokyo");

    // ArrayList<Flight> fromCity = database.getFlightsFromCity("Berlin");
    // ArrayList<Flight> toCity = database.getFlightsToCity("Berlin");
    // database.displayFlights(fromCity);
    // database.displayFlights(toCity);
    database.displayFlightsFromCity("Warsaw");
    database.displayFlightsToCity("Tokyo");
    System.out.println(database.getCities());
  }
}

class FlightDatabase {
  ArrayList<Flight> flights = new ArrayList<Flight>();

  public FlightDatabase() {
    this.flights.add(new Flight("Berlin", "Tokyo"));
    this.flights.add(new Flight("Paris", "Berlin"));
    this.flights.add(new Flight("Warsaw", "Paris"));
    this.flights.add(new Flight("Madrid", "Berlin"));
    this.flights.add(new Flight("Berlin", "Warsaw"));
    this.flights.add(new Flight("Paris", "Madrid"));
    this.flights.add(new Flight("Porto", "Warsaw"));
    this.flights.add(new Flight("Madrid", "Porto"));
    this.flights.add(new Flight("Warsaw", "Madrid"));
  }

  public void checkIfFlightExists(String departure, String arrival) {

    for (int i = 0; i < flights.size(); i++) {
      if (departure.equals(flights.get(i).getDeparture()) &&
          arrival.equals(flights.get(i).getArrival())) {
        System.out.println("Flight exists");
        return;
      }
    }
    System.out.println("Flight don't exists");
  }

  public ArrayList<Flight> getFlightsFromCity(String city) {
    ArrayList<Flight> results = new ArrayList<Flight>();
    for (int i = 0; i < this.flights.size(); i++) {
      Flight flight = this.flights.get(i);
      if (city.equals(flight.getDeparture())) {
        results.add(flight);
      }
    }
    return results;
  }

  public void displayFlightsFromCity(String city) {
    ArrayList<Flight> results = getFlightsFromCity(city);
    displayFlights(results);
  }

  public void displayFlightsToCity(String city) {
    ArrayList<Flight> results = getFlightsToCity(city);
    displayFlights(results);
  }

  public ArrayList<Flight> getFlightsToCity(String city) {
    ArrayList<Flight> results = new ArrayList<Flight>();
    for (int i = 0; i < this.flights.size(); i++) {
      Flight flight = this.flights.get(i);
      if (city.equals(flight.getArrival())) {
        results.add(flight);
      }
    }
    return results;
  }

  public void displayFlights(ArrayList<Flight> results) {
    if (results.isEmpty()) {
      System.out.println("Flight not found.");
    }
    for (int i = 0; i < results.size(); i++) {
      Flight flight = results.get(i);
      System.out.println(flight.getFlightInformation());
    }
  }

  public void displayList() {
    for (int i = 0; i < flights.size(); i++) {
      Flight element = flights.get(i);
      System.out.println("Flight form " + element.getDeparture() + " to " +
          element.getArrival());
    }
  }

  public ArrayList<String> getCities() {
    ArrayList<String> cities = new ArrayList<String>();
    for (int i = 0; i < this.flights.size(); i++) {
      Flight flight = this.flights.get(i);
      if (!cities.contains(flight.getDeparture())) {
        cities.add(flight.getDeparture());
      }
      if (!cities.contains(flight.getArrival())) {
        cities.add(flight.getArrival());
      }
    }
    return cities;
  }
}

class Flight {
  private String departure;
  private String arrival;
  private String price;

  // getters and setters
  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public String getArrival() {
    return arrival;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public Flight(String departure, String arrival) {
    this.departure = departure;
    this.arrival = arrival;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getFlightInformation() {
    String information;
    information = "This flight is from " + departure + " to " + arrival + ".";
    return information;
  }
}

class MobilePhone {
  private String weight;
  private int price;

  public MobilePhone(String weight, int price) {
    this.weight = weight;
    this.price = price;
  };

  public void checkPrice() {
    if (price < 200) {
      System.out.println("Price is very good");
    } else if (price < 300) {
      System.out.println("Price is good");
    } else if (price < 500) {
      System.out.println("Price could be lower");
    } else {
      System.out.println("this phone is too expensive");
    }
  }

  public String getWeight() {
    return weight;
  }

  public int getPrice() {
    return price;
  }

  public void increasePricePercentage(int value) {
    int price = this.price;
    price = price + price * value / 100;
    this.price = price;
  }

  public void decreasePricePercentage(int value) {
    int price = this.price;
    price = price - price * value / 100;
    this.price = price;
  }

  public void increasePriceAmount(int value) {
    int price = this.price;
    price = price + value;
    this.price = price;
  }

  public void decreasePriceAmount(int value) {
    int price = this.price;
    price = price - value;
    this.price = price;
  }

  public void displayEvenNumbers(int min, int max) {
    for (int i = min; i < max; i++) {
      if (i % 2 == 0) {
        System.out.println(i);
      }
    }
  }

}
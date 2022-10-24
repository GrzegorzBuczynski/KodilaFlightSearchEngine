import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    FlightDatabase flight1 = new FlightDatabase();
    flight1.checkIfFlightExists("Berlin", "Tokyo");
    // flight1.displayList();
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
    boolean flag = true;
    for (int i = 0; i < flights.size(); i++) {
      if (departure.equals(flights.get(i).getDeparture()) &&
          arrival.equals(flights.get(i).getArrival())) {
        System.out.println("Flight exsist");
        flag = false;
      }
    }
    if (flag) {
      System.out.println("Flight don't exist");
    } 
  }

  public void displayList() {
    for (int i = 0; i < flights.size(); i++) {
      Flight element = flights.get(i);
      System.out.println("Flight form " + element.getDeparture() + " to " +
          element.getArrival());
    }
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

  public String getflightInformation() {
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
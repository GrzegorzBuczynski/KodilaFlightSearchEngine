package src;
import java.util.ArrayList;

class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabase() {
        this.flights.add(new Flight("Berlin", "Tokyo", 200));
        this.flights.add(new Flight("Paris", "Berlin", 340));
        this.flights.add(new Flight("Warsaw", "Paris", 300));
        this.flights.add(new Flight("Madrid", "Berlin", 100));
        this.flights.add(new Flight("Berlin", "Warsaw", 2400));
        this.flights.add(new Flight("Paris", "Madrid", 120));
        this.flights.add(new Flight("Porto", "Warsaw", 800));
        this.flights.add(new Flight("Madrid", "Porto", 550));
        this.flights.add(new Flight("Warsaw", "Madrid", 300));
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
        for (Flight flight : this.flights) {
            if (!cities.contains(flight.getDeparture())) {
                cities.add(flight.getDeparture());
            }
            if (!cities.contains(flight.getArrival())) {
                cities.add(flight.getArrival());
            }
        }
        return cities;
    }

    public Flight getCheapestsFlight() {
        Flight cheapestFlight = null;
        for (Flight flight : this.flights) {
            if (cheapestFlight == null || flight.getPrice() < cheapestFlight.getPrice()) {
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestsFlightFromCity(String city) {
        ArrayList<Flight> fromCity = getFlightsFromCity(city);
        Flight cheapestFlight = null;
        for (Flight flight : fromCity) {
            if ((cheapestFlight == null || flight.getPrice() < cheapestFlight.getPrice())) {
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public ArrayList<Journey> getFlights(String start, String end) {
        ArrayList<Flight> starting = getFlightsFromCity(start);
        ArrayList<Flight> ending = getFlightsToCity(end);
        ArrayList<Journey> results = new ArrayList<Journey>();
        for (Flight first : starting) {
            for (Flight second : ending) {
                if (first.getArrival().equals(second.getDeparture())) {
                    results.add(new Journey(first, second));
                }
            }
        }
        return results;
    }
}

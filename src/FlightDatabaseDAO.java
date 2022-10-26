package src;

import java.util.ArrayList;

class FlightDatabaseDAO {
    FlightDatabase FlightDatabase = new FlightDatabase();
    ArrayList<Flight> flights = FlightDatabase.flights;

    public FlightDatabaseDAO() {
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

    public ArrayList<Flight> getFlightsFromTo(String departure, String arrival) {
        ArrayList<Flight> results = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (departure.equals(flight.getDeparture()) &&
                    arrival.equals(flight.getArrival())) {
                results.add(flight);
            }
        }
        return results;
    }

    public ArrayList<Journey> getJourneysFromTo(String start, String end) {
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

    public void displayFlightsFromCity(String city) {
        ArrayList<Flight> results = getFlightsFromCity(city);
        displayFlights(results);
    }

    public void displayFlightsToCity(String city) {
        ArrayList<Flight> results = getFlightsToCity(city);
        displayFlights(results);
    }

    public void displayFlightAndJourneysFromTo(String start, String end) {
        ArrayList<Flight> flights = getFlightsFromTo(start, end);
        ArrayList<Journey> journeys = getJourneysFromTo(start, end);
        if (flights.isEmpty() && journeys.isEmpty()) {
            System.out.println("Flight not exist");
        }
        if (!flights.isEmpty()) {
            System.out.println("We found: " + flights.size() + " direct flight(s): ");
            displayFlightsList(flights);
        }
        if (!journeys.isEmpty()) {
            System.out.println("We found: " + journeys.size() + " indirect flight(s): ");
            displayJourneysList(journeys);
        }
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

    public void displayFlightsList(ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Flight form: " + flight.getDeparture() + " to " +
                    flight.getArrival() + " cost " + flight.getPrice() + ".");
        }
    }

    public void displayJourneysList(ArrayList<Journey> journeys) {
        for (Journey journey : journeys) {
            System.out.println(journey);
        }
    }

}

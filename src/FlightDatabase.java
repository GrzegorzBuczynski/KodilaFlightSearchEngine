package src;

import java.util.ArrayList;

class FlightDatabase {
    public ArrayList<Flight> flights = new ArrayList<Flight>();

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
        this.flights.add(new Flight("Paris", "Porto", 300));
    }
}

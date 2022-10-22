class Main {
  public static void main(String[] args) {
    Flight flight1 = new Flight("Warsaw", "Tokyo");
    System.out.println(flight1.getflightInformation());

    MobilePhone phone1 = new MobilePhone("500g", 500);
    System.out.println("Phone price is " + phone1.getPrice());
    phone1.decreasePricePercentage(10);
    System.out.println("After discount phone price is " + phone1.getPrice());
    phone1.increasePriceAmount(10);
    System.out.println("Due to inflation, the price rose to " + phone1.getPrice());

  }
}

class Flight {
  private String departure;
  private String arrival;
  private String price;

  public Flight(String departure, String arrival) {
    this.departure = departure;
    this.arrival = arrival;
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

}
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ComputerItems computer = new ComputerItems();
    computer.displayList();
  }
}

class ComputerItems {
  ArrayList<String> list = new ArrayList<String>();

  public ComputerItems() {
    this.list.add("test");
    this.list.add("computer");
    this.list.add("mouse");
    this.list.add("keyboard");
  }

  public void displayList() {
    for (int i = 0; i < list.size(); i++) {
      String element = list.get(i);
      if (element.length() > 5) {
        System.out.println(element);
      }
    }
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
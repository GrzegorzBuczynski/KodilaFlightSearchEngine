package src;
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

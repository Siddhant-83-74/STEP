public class DynamicPricingCalculator {

    public static double getTrafficFactor(int customers, int capacity) {
        double ratio = (double) customers / capacity;
        double factor = 1 + ratio * 0.5;
        if (ratio > 0.7) {
            factor *= 1.2;
        }
        return factor;
    }

    public static double getInventoryFactor(int stock) {
        if (stock < 10) {
            return 1.15;
        } else if (stock > 100) {
            return 0.95;
        }
        return 1.0;
    }

    public static double getLoyaltyDiscount(int years) {
        double discount = years * 2.0;
        if (discount > 15.0) {
            discount = 15.0;
        }
        return discount / 100.0;
    }

    public static double getHourFactor(int hour) {
        if (hour >= 19 || hour <= 6) {
            return 1.1;
        }
        return 1.0;
    }

    public static double getFinalPrice(double basePrice, int customers, int capacity,
                                       int stock, int loyaltyYears, int hour) {
        double traffic   = getTrafficFactor(customers, capacity);
        double inventory = getInventoryFactor(stock);
        double discount  = getLoyaltyDiscount(loyaltyYears);
        double time      = getHourFactor(hour);

        double price = basePrice * traffic * inventory * time;
        price = price * (1 - discount);

        return Math.round(price * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        double base     = 100.0;
        int customers   = 80;
        int capacity    = 100;
        int stock       = 5;
        int loyalty     = 4;
        int hour        = 21;

        System.out.println("Traffic Factor   : " + getTrafficFactor(customers, capacity));
        System.out.println("Inventory Factor : " + getInventoryFactor(stock));
        System.out.println("Loyalty Discount : " + (getLoyaltyDiscount(loyalty) * 100) + "%");
        System.out.println("Hour Factor      : " + getHourFactor(hour));
        System.out.println("Final Price      : " + getFinalPrice(base, customers, capacity, stock, loyalty, hour));
    }
}
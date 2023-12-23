package main.java;

public class ShippingCostCalculator {

    // Constants representing the cost factors
    public static final double LOCAL_RATE = 1.0;
    public static final double INTERNATIONAL_RATE = 5.0;
    public static final double STANDARD_RATE = 1.0;
    public static final double EXPRESS_RATE = 2.5;

    /**
     * Calculates the shipping cost based on the weight, destination, and delivery
     * speed.
     *
     * @param weight        the weight of the package in kilograms
     * @param destination   the destination type ("Local" or "International")
     * @param deliverySpeed the speed of the delivery ("Standard" or "Express")
     * @return the total cost of shipping
     */
    public double calculateCost(double weight, String destination, String
            deliverySpeed) {
        double cost = 0.0;
// Determine the base cost by destination
        if ("Local".equalsIgnoreCase(destination)) {
            cost += weight * LOCAL_RATE;
        } else if ("International".equalsIgnoreCase(destination)) {
            cost += weight * INTERNATIONAL_RATE;
        }
// Apply the multiplier for delivery speed
        if ("Express".equalsIgnoreCase(deliverySpeed)) {
            cost *= EXPRESS_RATE;
        } else if ("Standard".equalsIgnoreCase(deliverySpeed)) {
            cost *= STANDARD_RATE;
        }
        return cost;
    }

}

package Property;

public class Property {

    private static String address;
    private static String vacant;
    private static double rentAmount;
    private static String propertyType;

    public Property (String address, String vacant, double rentAmount, String propertyType) {
        setAddress(address);
        setVacant(vacant);
        setRentAmount(rentAmount);
        setPropertyType(propertyType);
    }

    public static String getAddress() {
        return address;
    }

    public static String getVacant() {
        return vacant;
    }

    public static double getRentAmount() {
        return rentAmount;
    }

    public static String getPropertyType() {
        return propertyType;
    }

    public static void setAddress(String address) {
        Property.address = address;
    }

    public static void setVacant(String vacant) {
        Property.vacant = vacant;
    }

    public static void setRentAmount(double rentAmount) {
        Property.rentAmount = rentAmount;
    }

    public static void setPropertyType(String propertyType) {
        Property.propertyType = propertyType;
    }
}

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

    public String getAddress() {
        return address;
    }

    public String getVacant() {
        return vacant;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setAddress(String address) {
        Property.address = address;
    }

    public void setVacant(String vacant) {
        Property.vacant = vacant;
    }

    public void setRentAmount(double rentAmount) {
        Property.rentAmount = rentAmount;
    }

    public void setPropertyType(String propertyType) {
        Property.propertyType = propertyType;
    }
}

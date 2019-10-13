package Car;

public enum Brand {
    VW("VW", "blue"),
    SKODA("Skoda", "green"),
    SEAT("Seat", "red"),
    UNKNOWN("", "");

    private String brandName;
    private String color;

    Brand(String brand, String color) {
        this.brandName = brand;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getBrandName() {
        return brandName;
    }

    public static Brand getBrand(String brandName) {
        for (Brand brand : values()) {
            if (brand.brandName.equals(brandName)){
                return brand;
            }
        }
        return UNKNOWN;
    }
}

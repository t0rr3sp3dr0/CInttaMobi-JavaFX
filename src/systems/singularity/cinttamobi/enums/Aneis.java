package systems.singularity.cinttamobi.enums;

/**
 * Created by phts on 17/06/16.
 */
public enum Aneis {
    _null(null, -1),
    A("A", 2.80),
    B("B", 3.85),
    D("D", 3.00),
    G("G", 1.85);

    private String name;
    private double price;

    Aneis(String name, double value) {
        this.name = name;
        this.price = value;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name.replace("null", "");
    }
}

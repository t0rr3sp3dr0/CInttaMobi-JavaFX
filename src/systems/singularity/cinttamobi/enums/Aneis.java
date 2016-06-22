package systems.singularity.cinttamobi.enums;

/**
 * Created by phts on 17/06/16.
 * © 2016 Singularity Systems
 */
public enum Aneis {

    //ENUM com os valores dos aneis no grande recife
    _null(-1),
    A(2.80),
    B(3.85),
    D(3.00),
    G(1.85);

    private final double price;

    Aneis(double value) {
        this.price = value;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString().replace("_null", "");
    }
}

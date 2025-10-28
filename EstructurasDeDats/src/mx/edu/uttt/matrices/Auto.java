package mx.edu.uttt.matrices;

public class Auto {
    private String model;
    private int millesDriven;
    private double gallonsOfGas;

    public Auto() {
        this.model = "Unknow";
    }

    public Auto(String model, int millesDriven, double gallonsOfGas) {
        this.model = model;
        this.setMillesDriven(millesDriven);
        this.setGallonsOfGas(gallonsOfGas);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMillesDriven() {
        return millesDriven;
    }

    public void setMillesDriven(int millesDriven) {
        if (millesDriven >= 0)
        this.millesDriven = millesDriven;
        else {
            System.out.println("Miles driven cannot be negative");
            System.out.println("Value not changed");
        }
    }

    public double getGallonsOfGas() {
        return gallonsOfGas;
    }

    public void setGallonsOfGas(double gallonsOfGas) {
        if (gallonsOfGas >= 0)
        this.gallonsOfGas = gallonsOfGas;
        else {
            System.out.println("Gallons of gas cannot be negative");
            System.out.println("Gallons of gas no chenged");
        }
    }
    public double calculateMilesPerGallon(){
        if (gallonsOfGas != 0.0){
            return millesDriven/gallonsOfGas;
        }else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "model='" + model + '\'' +
                ", millesDriven=" + millesDriven +
                ", gallonsOfGas=" + gallonsOfGas +
                '}';
    }
}


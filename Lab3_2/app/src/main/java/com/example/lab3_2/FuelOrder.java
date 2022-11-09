package com.example.lab3_2;

public class FuelOrder {
    static double price_92 = 47.35;
    static double price_95 = 51.41;
    static double price_98 = 60.21;
    static double price_dt = 54.49;
    private String fuelType;
    private double value;

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public FuelOrder(String _fuelType, double _value) {
        fuelType = _fuelType;
        value = _value;
    }
    public String returnSumOrder(){
        String result = "";
        switch (fuelType) {
            case ("АИ 92 - 47.35р"):
                result = "Заказ на " + value + "л, тип топлива: " + fuelType + "\nСумма: " + price_92 * value + "\n\n";
            break;
            case ("АИ 95 - 51.41р"):
                result = "Заказ на " + value + "л, тип топлива: " + fuelType + "\nСумма: " + price_95 * value + "\n\n";
            break;
            case ("АИ 98 - 60.21р"):
                result = "Заказ на " + value + "л, тип топлива: " + fuelType + "\nСумма: " + price_98 * value + "\n\n";
            break;
            case ("ДТ - 54.49р"):
                result = "Заказ на " + value + "л, тип топлива: " + fuelType + "\nСумма: " + price_dt * value + "\n\n";
            break;
        }
        return result;
    }
}

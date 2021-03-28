package sample;

public class TemperatureConverter extends Converter{

    private final String[] TEMPERATURE_UNIT = {"Celsius", "Kelvin", "Fahrenheit"};

    private double kelvinToCelsius(double k){
        return k-273.15;
    }

    private double fahrenheitToCelsius(double f){
        return (f-32)*5/9;
    }

    private double celsiusToKelvin(double c){
        return c+273.15;
    }

    private double fahrenheitToKelvin(double f){
        return (f+459.67)*5/9;
    }

    private double celsiusToFahrenheit(double c){
        return c*9/5+32;
    }

    private double kelvinToFahrenheit(double k){
        return k*9/5-459.67;
    }

    public String convert(double input, int from, int to){
        double result = 0;

        if(from == 0){
            if(to == 0){
                result =  input;
            } else if(to == 1){
                result = celsiusToKelvin(input);
            } else if(to == 2){
                result = celsiusToFahrenheit(input);
            }
        } else if (from == 1){
            if(to == 0){
                result = kelvinToCelsius(input);
            } else if(to == 1){
                result = input;
            } else if(to == 2){
                result = kelvinToFahrenheit(input);
            }
        } else if (from == 2){
            if(to == 0){
                result = fahrenheitToCelsius(input);
            } else if(to == 1){
                result = fahrenheitToKelvin(input);
            } else if(to == 2){
                result = input;
            }
        }

        return Double.toString(result);
    }

    public String[] getUnit() {return TEMPERATURE_UNIT;};

}

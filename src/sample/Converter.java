package sample;

public abstract class Converter {

    Converter(){};

    abstract public String[] getUnit();

    abstract public String convert(double input, int from, int to);

    protected double validateInput(String input) throws Exception{
        double result = 0;
        if(!input.isEmpty())
            result = Double.parseDouble(input);
        else {
            throw new Exception("Invalid input");
        }
        return result;
    }
}

package sample;

public abstract class Converter {

    Converter(){};

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

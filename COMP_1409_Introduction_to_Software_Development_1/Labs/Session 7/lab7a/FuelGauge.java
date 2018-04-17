
/**
 * Write a description of class FuelGauge here.
 * 
 * @author  Alex Dai 
 * @version May 20 2014
 */
public class FuelGauge
{
    public final int MAX_FUEL_AMOUNT = 15;
    public final int MIN_FUEL_AMOUNT = 0;
    
    private int amountOfFuelInLitres;

    /**
     * Default constructor
     */
    public FuelGauge()
    {
        setAmountOfFuel(MAX_FUEL_AMOUNT);
    }

    /**
     * Non-default constructor
     * @param   fuelAmount
     */
    public FuelGauge(int fuelAmount)
    {
        setAmountOfFuel(fuelAmount);
    }
    
    /**
     * Set the amount of fuel in litres
     * @param   fuelAmount
     */
    public void setAmountOfFuel(int fuelAmount)
    {
        if(fuelAmount >= MIN_FUEL_AMOUNT && fuelAmount <= MAX_FUEL_AMOUNT) {
            this.amountOfFuelInLitres = fuelAmount;
        }
        else {
            this.amountOfFuelInLitres = MAX_FUEL_AMOUNT;
        }
    }
    
    /**
     * Get the amount of fuel in litres
     * @return  amountOfFuelInLitres
     */
    public int getAmountOfFuel()
    {
        return this.amountOfFuelInLitres;
    }
    
    /**
     * Decrement the amount of fuel by 1 litre
     * Display warning message if the tank is empty
     */
    public void useFuel()
    {
        if(this.amountOfFuelInLitres == MIN_FUEL_AMOUNT) {
            System.out.println("the tank is empty the fuel cannot go below 0");
        }
        else {
            this.amountOfFuelInLitres--;
        }
    }
    
    /**
     * Increment the amount of fuel by 1 litre
     * Display a warning message if the tank is full
     */
    public void addFuel()
    {
        if(this.amountOfFuelInLitres == MAX_FUEL_AMOUNT) {
            System.out.println("tank is full");
        }
        else {
            this.amountOfFuelInLitres++;
        }
    }
}

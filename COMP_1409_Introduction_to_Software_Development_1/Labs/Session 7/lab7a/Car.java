
/**
 * Write a description of class Car here.
 * 
 * @author Alex Dai
 * @version May 20 2014
 */
public class Car
{
    private String carMake;
    private String carColour;
    private FuelGauge fuelGauge;    
    
    /**
     * Default constructor
     */
    public Car()
    {
        setMake("");
        setColour("");
        setFuelGauge(new FuelGauge());
    }

    /**
     * Non-default constructor
     * @param   make
     * @param   colour
     * @param   amountOfFuel
     */
    public Car(String make, String colour, int amountOfFuel)
    {
        setMake(make);
        setColour(colour);
        setFuelGauge(new FuelGauge(amountOfFuel));
    }
    
    /**
     * Set car make
     * @param   make
     */
    public void setMake(String make)
    {
        if(make != null) {
            this.carMake = make;
        }
        else {
            this.carMake = "";
        }
    }
    
    /**
     * Set car colour
     * @param   colour
     */
    public void setColour(String colour)
    {
        if(colour != null) {
            this.carColour = colour;
        }
        else {
            this.carColour = "";
        }
    }
    
    /**
     * Set fuel gauge
     * @param   theFuelGauge
     */
    public void setFuelGauge(FuelGauge theFuelGauge)
    {
        if(null == theFuelGauge) {
            this.fuelGauge = new FuelGauge();
        }
        else {
            this.fuelGauge = theFuelGauge;
        }
    }
    
    /**
     * Get car make
     * @return  carMake
     */
    public String getMake()
    {
        return this.carMake;
    }
    
    /**
     * Get car colour
     * @return  carColour
     */
    public String getColour()
    {
        return this.carColour;
    }
    
    /**
     * Get fuel gauge
     * @return fuelGauge
     */
    public FuelGauge getFuelGauge()
    {
        return this.fuelGauge;
    }
    
    /**
     * decrement the fuel gauge
     */
    public void dive()
    {
        this.fuelGauge.useFuel();
    }
    
    /**
     * increment the fuel gauge
     */
    public void fillTank()
    {
        this.fuelGauge.addFuel();
    }
}

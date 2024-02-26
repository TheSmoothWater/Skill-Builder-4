/**
 * Groks are bad actors in a game.  Groks have the ability to ingest
 * a PowerPill to replenish their energy.  This makes them difficult
 * to kill.
 *
 * @author (You Again)
 * @version (0.1)
 */
class Grok
{
    private static final int DEFAULT_POWER_LEVEL=50;
    private static final int MAX_POWER_LEVEL = 100;

    // instance variables
    private int powerLevel;
    private boolean isAlive = true;

    /*
     * Initializes a Grok object to the default power level of 50.
     */
    public Grok()
    {
        powerLevel = DEFAULT_POWER_LEVEL;
    }

    /*
     * Initializes a Grok object to power powerLevel
     *
     * @param powerLevel power level of this Grok
     */
    public Grok(int powerLevel)
    {
        if(powerLevel < 1){
            powerLevel = 0;
            isAlive = false;
        }
        else {
            setPowerLevel(powerLevel);
        }
    }

// accessor methods

    /*
     * Returns the power level of this Grok.
     * @return returns the power level of this Grok
     */
    public int getPowerLevel() {
        return powerLevel;
    }
    public boolean isDead()
    {
        if(powerLevel < 1){
            isAlive = false;
            return true;
        }
        else if(powerLevel > 0){
            isAlive = true;
            return false;
        }
        return false;
    }

// mutator methods

    /*
     * Sets the power level of this Grok.
     * @param powerLevel the power value to set for this Grok.
     */
    public void setPowerLevel(int powerLevel)
    {
        if(!isAlive) {
            return;
        }
        if (powerLevel > MAX_POWER_LEVEL) {
            this.powerLevel = MAX_POWER_LEVEL;
        }
        else if (powerLevel < 1) {
            this.powerLevel = 0;
            isAlive = false;
        }
        else {
            this.powerLevel = powerLevel;
        }
    }

    /*
     * Set the power level of this Grok to the power level of
     * the pill.
     * @param pill The PowerPill that the this Grok.  The power
     * of the pill is added to the power level of this Grok.
     */
    public void takePowerPill(PowerPill pill)
    {
        if(isDead()){
            return;
        }
        else{
            setPowerLevel(powerLevel + pill.getPower());
        }
    }

    /*
     * Invoked when this Grok takes a hit.  The power level of
     * this Grok is reduced by 5.
     */
    public void tookHit() {
        setPowerLevel(powerLevel - 5);
    }

    //================== Do Not Touch Code Below this line =============================
    public String toString(){
        return "Grok:("+powerLevel+","+isAlive+")";
    }
}
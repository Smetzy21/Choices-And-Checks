package Handler;

/**
 *
 * @author Jake
 */
public class Var {
    
    
    // The var being handled
    private int var = 0;
    // The StringBuilder that keeps a history of the changes of the var
    private StringBuilder sb = new StringBuilder();
    // The name of the Var
    private final String name;
    
    // Boolean to track if the var has just been reset
    private boolean reset = true;

    public Var(String name) {
        this.name = name;
    }
    
    
    
    // Changes the value and stores a report of the history inside the StringBuilder
    public void Change (int change, String changeString) {
        if (reset) {
            this.getSb().append(change).append(" = ").append(changeString);
            reset = false;
        }
        else if (change < 0) this.getSb().append("\n-").append(change).append(" ").append(changeString);
        else this.getSb().append("\n+").append(change).append(" ").append(changeString);
        var += change;
    }
    
    public void Reset(){
        reset = true;
        var = 0;
        sb = new StringBuilder();
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public String getName() {
        return name;
    }
    

    @Override
    public String toString() {
        return var + "";
    }
    
    
    
}

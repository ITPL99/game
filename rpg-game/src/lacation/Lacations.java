package lacation;

public class Lacations<T> {
    protected T values;
    protected Lacations left;
    protected Lacations rights;
    protected Lacations up;
    protected Lacations down;
    protected Lacations leftUp;
    protected Lacations leftDown;
    protected Lacations rightsUp;
    protected Lacations rightsDown;

    public Lacations(T values) {
        this.values = values;
    }

    public void printValues(){
        System.out.print(values + " ");
    }

}

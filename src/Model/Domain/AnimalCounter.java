package Model.Domain;

public class AnimalCounter implements AutoCloseable{
    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Counter closed.");
    }
}

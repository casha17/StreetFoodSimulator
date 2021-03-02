public class Customer {

    public Customer(int id , double arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    private int id;
    private double arrivalTime;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}

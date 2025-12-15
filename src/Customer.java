public class Customer {
    private int id;
    private String fullName;
    public Customer(int id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }
}

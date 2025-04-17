package exonclass;

public class employee {
    private int id;
    private String name;
    private String lastname;
    private int salary;

   public employee(int id, String name, String lastname, int salary) {
       this.id = id;
       this.name = name;
       this.lastname = lastname;
       this.salary = salary;
   }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getAnnualSalary() {
       return salary*12;
    }
    public int raiseSalary(int percent) {
       return salary+salary*(percent/100);
    }
    public String toString() {
       return "employee [id=" + id + ", name=" + name + ", lastname=" + lastname+ ", salary=" + salary + "]";
    }
    public static class main1_4 {
        public static void main(String[] args) {
            // Test constructor and toString()
            employee e1 = new employee(8, "Peter", "Tan", 2500);
            System.out.println(e1);  // toString();

            // Test Setters and Getters
            e1.setSalary(999);
            System.out.println(e1);  // toString();
            System.out.println("id is: " + e1.getId());
            System.out.println("firstname is: " + e1.getName());
            System.out.println("lastname is: " + e1.getLastname());
            System.out.println("salary is: " + e1.getSalary());

            System.out.println("name is: " + e1.getName());
            System.out.println("annual salary is: " + e1.getAnnualSalary()); // Test method

            // Test raiseSalary()
            System.out.println(e1.raiseSalary(10));
            System.out.println(e1);
        }
}

}

public class manager {
    private String name;
    private String adresse;
    private double salary;
    private double teamPerformance;
    private double bonus;








    public String getName() {
    return name;
}

    public String getAdresse() {
        return adresse;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {


        if (name != null && !name.isEmpty()) {
            String[] words = name.split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    result.append(word.substring(0, 1).toUpperCase())
                            .append(word.substring(1).toLowerCase())
                            .append(" ");
                }
            }

            this.name = result.toString().trim();
        }


    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setSalary(double salary) {
    if (salary >= 0) {


        this.salary = salary ;
    }else
        salary = 0;


    }
    public double getAnnualSalary() {
        return salary * 12;
    }
    public double getTeamPerformance() {
        return teamPerformance;
    }

    public void setTeamPerformance(double teamPerformance) {
    if (teamPerformance >= 0&& teamPerformance <= 100) {
        this.teamPerformance = teamPerformance;



    }   else
        teamPerformance = 0;

    }

    public double getBonus() {
        return salary * teamPerformance / 100;
    }



    public static void main(String[] args) {
            manager manager = new manager();
            manager.setName("tran v an tung");
            manager.setAdresse("hue");
            manager.setSalary(10000);
            manager.setTeamPerformance(85);



        System.out.println("Manager Performance Report: ");
            System.out.println( " Name: "+manager.getName());
            System.out.println("Adresse: "+manager.getAdresse());
            System.out.println("Annual salary: " +manager.getAnnualSalary());
            System.out.println("Team Performance: "+manager.getTeamPerformance()+"%");
        System.out.println("Bonus: "+manager.getBonus());

        }

    @Override
    public String toString() {
        return this.name+ this.adresse + this.salary + this.teamPerformance + this.bonus;
    }




}

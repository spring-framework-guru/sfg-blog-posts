package guru.springframework.autowiringdemo;

public class Employee {
    private int eid;
    private String ename;
    private Department department;

    public Employee() {

    }

    /**
     * This constructor is used for autowire by constructor
     * @param department
     */
    public Employee(Department department) {
        System.out.println("*** Autowiring by using constructor ***");
        this.department = department;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Prints employee details to the console
     */
    public void showEployeeDetails(){
        System.out.println("Employee Id : " + eid);
        System.out.println("Employee Name : " + ename);
        System.out.println("Department : " + department.getDeptName());
    }
}

package guru.springframework.autowiringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBean {
    private int eid;
    private String ename;
    @Autowired
    private DepartmentBean deptBean;

    public EmployeeBean() {

    }

    /**
     * This constructor is used for @Autowired on constructor
     * @param deptBean
     */
    @Autowired
    public EmployeeBean(DepartmentBean deptBean) {
        System.out.println("*** Autowiring by using @Autowire annotation on constructor ***");
        this.deptBean = deptBean;
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

    public DepartmentBean getDeptBean() {
        return deptBean;
    }

    /**
     * This setter method is used for @Autowired on setter
     * @param deptBean
     */
    @Autowired
    public void setDeptBean(DepartmentBean deptBean) {
        this.deptBean = deptBean;
    }

    public void showEployeeDetails(){
        System.out.println("Employee Id : " + eid);
        System.out.println("Employee Name : " + ename);
        deptBean.setDeptName("Information Technology");
        System.out.println("Department : " + deptBean.getDeptName());
    }
}

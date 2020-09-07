package bean;

import java.util.Set;

public class DeptInfo {
    private  Integer deptNo;
    private String loc;
    private String dname;
    //描述一对多关系
    private Set<EmpInfo> empSet;

    public Set<EmpInfo> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<EmpInfo> empSet) {
        this.empSet = empSet;
    }

    public DeptInfo() {
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "deptNo=" + deptNo +
                ", loc='" + loc + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}

package bean;

public class EmpInfo {
    private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private String hireDate;
    private Double sal;
    private Double comm;
    private Integer deptNo;
    //模拟多对一关系
    private DeptInfo di ;

    public DeptInfo getDi() {
        return di;
    }

    public void setDi(DeptInfo di) {
        this.di = di;
    }

    public EmpInfo() {
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "EmpInfo{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hireDate='" + hireDate + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                ", di=" + di +
                '}';
    }
}

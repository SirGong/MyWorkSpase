package com.xzy.bean;


public class Stu {

  private long stuid;
  private String stuname;
  private long stuage;

    public Stu() {
    }

    public Stu(long stuid, String stuname, long stuage) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    public long getStuid() {
    return stuid;
  }

  public void setStuid(long stuid) {
    this.stuid = stuid;
  }


  public String getStuname() {
    return stuname;
  }

  public void setStuname(String stuname) {
    this.stuname = stuname;
  }


  public long getStuage() {
    return stuage;
  }

  public void setStuage(long stuage) {
    this.stuage = stuage;
  }

    @Override
    public String toString() {
        return "Stu{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }
}

package com.xzy.bean;


public class Score {

  private long scoreid;
  private long stuid;
  private long scorenum;

    public Score() {
    }

    public Score(long scoreid, long stuid, long scorenum) {
        this.scoreid = scoreid;
        this.stuid = stuid;
        this.scorenum = scorenum;
    }
    public long getScoreid() {
    return scoreid;
  }

  public void setScoreid(long scoreid) {
    this.scoreid = scoreid;
  }


  public long getStuid() {
    return stuid;
  }

  public void setStuid(long stuid) {
    this.stuid = stuid;
  }


  public long getScorenum() {
    return scorenum;
  }

  public void setScorenum(long scorenum) {
    this.scorenum = scorenum;
  }

    @Override
    public String toString() {
        return "Score{" +
                "scoreid=" + scoreid +
                ", stuid=" + stuid +
                ", scorenum=" + scorenum +
                '}';
    }
}

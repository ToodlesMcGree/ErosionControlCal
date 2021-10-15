package com.example.navcal;

public class Model {
    private String lbs_of_mulch;
    private String bags;
    private String bags_per_tank;
    private String tank_loads;
    private String sq_ft_tank;
    private String dateTime;
    private String project_name;

    public Model(String lbs_of_mulch, String bags, String bags_per_tank, String tank_loads, String sq_ft_tank,String dateTime,String project_name) {
        this.lbs_of_mulch = lbs_of_mulch;
        this.bags = bags;
        this.bags_per_tank = bags_per_tank;
        this.tank_loads = tank_loads;
        this.sq_ft_tank = sq_ft_tank;
        this.dateTime = dateTime;
        this.project_name = project_name;
    }
    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getLbs_of_mulch() {
        return lbs_of_mulch;
    }

    public void setLbs_of_mulch(String lbs_of_mulch) {
        this.lbs_of_mulch = lbs_of_mulch;
    }

    public String getBags() {
        return bags;
    }

    public void setBags(String bags) {
        this.bags = bags;
    }

    public String getBags_per_tank() {
        return bags_per_tank;
    }

    public void setBags_per_tank(String bags_per_tank) {
        this.bags_per_tank = bags_per_tank;
    }

    public String getTank_loads() {
        return tank_loads;
    }

    public void setTank_loads(String tank_loads) {
        this.tank_loads = tank_loads;
    }

    public String getSq_ft_tank() {
        return sq_ft_tank;
    }

    public void setSq_ft_tank(String sq_ft_tank) {
        this.sq_ft_tank = sq_ft_tank;
    }
}

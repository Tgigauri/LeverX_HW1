package model;


public class Tea {

    private String teaName;
    private int brewTime;

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getBrewTime() {
        return brewTime;
    }


    public Tea(String teaName, int brewTime) {
        this.teaName = teaName;
        this.brewTime = brewTime;
    }

}

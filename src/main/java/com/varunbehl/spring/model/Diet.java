package com.varunbehl.spring.model;

class Diet {

    private String dietId;
    private String dietName;
    private String dietType;
    private String dietDesc;
    private String gymId;
    private String dietPref;

    public String getDietId() {
        return dietId;
    }

    public void setDietId(String dietId) {
        this.dietId = dietId;
    }

    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public String getDietDesc() {
        return dietDesc;
    }

    public void setDietDesc(String dietDesc) {
        this.dietDesc = dietDesc;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getDietPref() {
        return dietPref;
    }

    public void setDietPref(String dietPref) {
        this.dietPref = dietPref;
    }

}
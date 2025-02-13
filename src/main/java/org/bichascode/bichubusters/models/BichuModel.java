package org.bichascode.bichubusters.models;


import java.time.LocalDate;

public class BichuModel {

    private String name;
    private Level level;
    private String danger;
    private String ability;
    private LocalDate currentDate;


    public BichuModel(
        String name,
        Level level,
        String danger,
        String ability) {
            this.name = name;
            this.level = level;
            this.danger = danger;
            this.ability = ability;
            this.currentDate = currentDate();
        }

    private LocalDate currentDate() {
        return LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public Level getBichuClass() {
        return level;
    }

    public String getDanger() {
        return danger;
    }

    public String getAbility() {
        return ability;
    }

    public LocalDate getDate() {
        return currentDate;
    }


}

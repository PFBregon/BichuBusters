package org.bichascode.bichubusters.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import org.bichascode.bichubusters.models.BichuModel;
import org.bichascode.bichubusters.models.HunterModel;
import org.bichascode.bichubusters.models.Level;
import org.bichascode.bichubusters.views.BichuListView;
import org.bichascode.bichubusters.views.CatchView;
import org.bichascode.bichubusters.views.ExitView;
import org.bichascode.bichubusters.views.MenuView;
import org.bichascode.bichubusters.views.ReleaseBichuView;

public class HunterController {

    private HunterModel hunterModel;
    private Scanner scanner;


    public HunterController() {
        this.hunterModel = new HunterModel();
        this.scanner = new Scanner(System.in);
    }

    public HunterModel getHunter() {
        return hunterModel;
    }

    public void catchBichu(String name, int level, String type, String ability) {
        Level classLevel;
        switch (level) {
            case 1:
                classLevel = Level.CLASS1;
                break;
            case 2:
                classLevel = Level.CLASS2;
                break;
            case 3:
                classLevel = Level.CLASS3;
                break;
            case 4:
                classLevel = Level.CLASS4;
                break;
            case 5:
                classLevel = Level.CLASS5;
                break;
            case 6:
                classLevel = Level.CLASS6;
                break;
            case 7:
                classLevel = Level.CLASS7;
                break;
            default:
                classLevel = null;
                break;
        }
        BichuModel bichuModel = new BichuModel(name, classLevel, type, ability);
        hunterModel.getBichuList().add(bichuModel);
        System.out.println("Has capturado a " + name + "! con nivel " + level + " y peligro " + type + " y habilidad " + ability);
        printMenuView();
    }

    public void printMenuView() {
        MenuView menuView = new MenuView(scanner, this);
        menuView.showMenuView();
    }

    public void handleMenuOption(int userOption) {
        if(userOption == 1) {
            CatchView catchView = new CatchView(scanner, this);
            catchView.showCatchView();
        }
        else if(userOption == 2) {
            ArrayList<BichuModel> bichuList = hunterModel.getBichuList();
            BichuListView bichuListView = new BichuListView(bichuList);
            bichuListView.showBichuListView();
            printMenuView();
        }
        else if(userOption == 3) {
            ArrayList<BichuModel> bichuList = hunterModel.getBichuList();
            BichuListView bichuListView = new BichuListView(bichuList);
            bichuListView.showBichuListView();
            ReleaseBichuView releaseBichuView = new ReleaseBichuView(scanner, this);
            releaseBichuView.showReleaseBichuListView();
        }
        else if(userOption == 6) {
            ExitView exitView = new ExitView(scanner, this);
            exitView.showExitView();

        }

    }

    public void releaseBichu(int bichuIndex) {
        hunterModel.getBichuList().remove(bichuIndex-1);
        System.out.println("Bichu liberado!");
        printMenuView();
    }

}

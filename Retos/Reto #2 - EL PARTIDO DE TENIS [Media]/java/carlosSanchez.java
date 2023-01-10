package com.example.reto2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static String puntos1, puntos2;
    public static void main(String[] args) {
        iniciarPartida();
        while (!finJuego()){
            System.out.println("quien gana punto?");
            Scanner scn=new Scanner(System.in);
            String quienGana=scn.next();
            quienGanaPunto(quienGana.toUpperCase());
            System.out.println(puntos1 +"-"+puntos2);


        }
        System.exit(0);

    }
    public static void iniciarPartida(){
        puntos1="0";
        puntos2="0";


    }
    public static void quienGanaPunto(String Quien){
       if(Quien.equals("P1")){

            switch (puntos1){
                case "0":
                    puntos1="15";
                    break;
                case "15":
                    puntos1="30";
                    break;
                case "30":
                    if(puntos2.equals("40")) {
                        puntos1 = "deuce";
                        puntos2 = "deuce";
                    }else {
                        puntos1="40";
                    }
                    break;
                case "40":
                    puntos1="ganaJ1";
                    break;
                case "deuce":
                    puntos1="ventaja";
                    puntos2="40";
                    break;
                case "ventaja":
                    puntos1="ganaJ1";
                    break;

            }

       }
       if(Quien.equals("P2")){
           switch (puntos2){
               case "0":
                   puntos2="15";
                   break;
               case "15":
                   puntos2="30";
                   break;
               case "30":
                   if(puntos1.equals("40")) {
                       puntos2 = "deuce";
                       puntos1 = "deuce";
                   }else {
                       puntos2="40";
                   }
                   break;
               case "40":
                   puntos2="ganaJ2";
                   break;
               case "deuce":
                   puntos2="ventaja";
                   puntos1="40";
                   break;
               case "ventaja":
                   puntos2="ganaJ2";
                   break;

           }
       }
    }

    public static boolean finJuego(){
        if (puntos1.equals("ganaJ1")){
            return true;
        } else if (puntos2.equals("ganaJ2")) {
            return true;
        }
        else {
            return false;
        }

    }





}
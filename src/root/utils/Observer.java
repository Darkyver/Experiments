package root.utils;

import root.model.Model;

import java.util.ArrayList;

public class Observer {

    private static ArrayList<Model> models = new ArrayList<>();




    public static void addModel(Model m){
        if(m != null){
            models.add(m);
        }
    }

    public static void remove(Model m){
        if(m != null){
            models.remove(m);
        }
    }


}

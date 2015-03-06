package com.mobileappscompany.android.trainerapplibrary.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Claudiordgz on 1/28/2015.
 */
public class TaskManager {
    private HashMap<Trainer, ArrayList<Trainee>> mTasks;

    public TaskManager() {
        mTasks = new HashMap<>();
    }

    public TaskManager(ArrayList<AssignedTask> tasks){
        for(AssignedTask t : tasks){
            t.getAssigner();
        }
    }
}

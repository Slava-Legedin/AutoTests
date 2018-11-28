package com.company;

import java.util.*;

public class Task5 {


    public static List<DailyTask> tasks = new ArrayList<>();
    public static void Tasks() {
        Scanner scanner = new Scanner(System.in);
        //System.out::println(String.valueOf(ArrayList[]));
        String s = "";


        while (!s.equals("n")) {
            System.out.println("Enter Task name");
            String name = scanner.next();
            System.out.println("Enter priority:\n 1-HIGH \n 2-MIDDLE \n 3-LOW");
            String priority = scanner.next();
            System.out.println("Enter complexity:\n 1-HARD \n 2-MEDIUM \n 3-EASY");
            String complaxity = scanner.next();
            //String v = "";

            //priority.toUpperCase();
            //complaxity.toUpperCase();

            DailyTask dt = new DailyTask(name, priority, complaxity);
            tasks.add(dt);

            System.out.println("Enter 'Y' to continue or 'N' to stop");
            s = scanner.next();

        }
        //System.out.println();
        /*for (DailyTask dt : tasks) {
            System.out.println(dt.comp);
        }*/
//Calculate hours for all tasks
        int hours = 0;
        for (DailyTask tasks : tasks  )
        {
            hours += tasks.comp;

        }
                System.out.println("Total hours for all tasks: " + hours);

        String name;
        System.out.println("Please enter Priority: ");
        name = scanner.next();
        System.out.println("You have next tasks with yours priority:");
        for (DailyTask tasks : tasks)
        {
            name =tasks.name;
            System.out.println(name);

        }
//
//       System.out.println("You have next tasks with "+ name + " Priority \n");
    }

   // public static void AllTasksTime(){
   //     DailyTask

    }


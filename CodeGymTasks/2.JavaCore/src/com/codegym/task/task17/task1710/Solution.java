package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws ParseException {
        // Start here

        String argument = args[0];
        int id = 0, index = 1;
        String name = "", dob = "", s = "";
        Calendar calendar;
        Person person;
        Sex sex = Sex.MALE;
        SimpleDateFormat inputFormat = new SimpleDateFormat("MM dd yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM dd yyyy");

        if (argument.equals("-u") || argument.equals("-d") || argument.equals("-i")) {
            id = Integer.parseInt(args[index++]);
        }

        if (argument.equals("-c") || argument.equals("-u")) {

            name = args[index++];
            s = args[index++];
            dob = args[index++];

            if (s.equals("f")) {
                sex = Sex.FEMALE;
            }
        }

        switch (argument) {

            case "-c":
                if (sex == Sex.MALE) {
                    allPeople.add(Person.createMale(name, inputFormat.parse(dob)));
                } else {
                    allPeople.add(Person.createFemale(name, inputFormat.parse(dob)));
                }
                System.out.println(allPeople.size() - 1);
                break;

            case "-u":

                person = allPeople.get(id);
                person.setName(name);
                person.setSex(sex);
                person.setBirthDate(inputFormat.parse(dob));
                allPeople.set(id, person);
                break;

            case "-d":
                person = allPeople.get(id);
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                allPeople.set(id, person);
                break;

            case "-i":
                person = allPeople.get(id);
                s = "m";
                if (person.getSex() == Sex.FEMALE) {
                    s = "f";
                }

                System.out.println(String.format("%s %s %s", person.getName(), s, outputFormat.format(person.getBirthDate())));
                break;
        }
    }
}

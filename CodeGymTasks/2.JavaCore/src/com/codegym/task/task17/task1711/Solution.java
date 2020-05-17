package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws ParseException {
        // Start here

        int counter = 1, length = args.length, id;
        String name, sex, dob;
        Person person;

        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM dd yyyy");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd yyyy");

        switch (args[0]) {

            case "-c":
                synchronized (allPeople) {

                    while (counter < length) {

                        name = args[counter++];
                        sex = args[counter++];
                        dob = args[counter++];

                        if (sex.equals("m")) {
                            person = Person.createMale(name, inputDateFormat.parse(dob));
                        } else {
                            person = Person.createFemale(name, inputDateFormat.parse(dob));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {

                    while (counter < length) {

                        id = Integer.parseInt(args[counter++]);
                        name = args[counter++];
                        sex = args[counter++];
                        dob = args[counter++];

                        person = allPeople.get(id);
                        person.setName(name);
                        person.setSex(sex.equals("m") ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(inputDateFormat.parse(dob));
                        allPeople.set(id, person);
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {

                    while (counter < length) {

                        id = Integer.parseInt(args[counter++]);

                        person = allPeople.get(id);
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(id, person);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {

                    while (counter < length) {

                        id = Integer.parseInt(args[counter++]);

                        person = allPeople.get(id);
                        sex = person.getSex() == Sex.MALE ? "m" : "f";
                        System.out.println(String.format("%s %s %s", person.getName(), sex, outputDateFormat.format(person.getBirthDate())));
                    }
                }
                break;
        }
    }
}

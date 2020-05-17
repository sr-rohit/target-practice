package com.codegym.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

/* 
Reading and writing to a file: CodeGym

*/
public class Solution {
    public static void main(String[] args) {
        // You can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            CodeGym codeGym = new CodeGym();
            // Initialize users field for the codeGym object here
            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);
            // Here check that the codeGym object is equal to the loadedObject object

            System.out.println(yourFile.getAbsolutePath());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class CodeGym {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            // Implement this method
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String value;
            
            writer.write(users.size() + "\n");
            for (User user : users) {

                value = user.getFirstName() != null ? user.getFirstName() : "";
                writer.write(value + "\n");

                value = user.getLastName() != null ? user.getLastName() : "";
                writer.write(value + "\n");

                value = user.getBirthDate() != null ? String.valueOf(user.getBirthDate().getTime()) : "";
                writer.write(value + "\n");

                writer.write((user.isMale() ? "1" : "0") + "\n");

                value = user.getCountry() != null ? user.getCountry().toString() : "";
                writer.write(value + "\n");
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            // Implement this method
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String value;
            int length = Integer.parseInt(reader.readLine());
            for (int i = 0; i < length; i++) {
                
                User user = new User();

                value = reader.readLine();
                if (value.length() > 0) {
                    user.setFirstName(value);
                }

                value = reader.readLine();
                if (value.length() > 0) {
                    user.setLastName(value);
                }

                value = reader.readLine();
                if (value.length() > 0) {
                    user.setBirthDate(new Date(Long.parseLong(value)));
                }

                user.setMale(reader.readLine().equals("1"));
                
                value = reader.readLine();
                for (User.Country country : User.Country.values()) {
                    if (value.equals(country.toString())) {
                        user.setCountry(country);
                        break;
                    }
                }

                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CodeGym codeGym = (CodeGym) o;

            return users != null ? users.equals(codeGym.users) : codeGym.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

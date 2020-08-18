package com.test;

public class HashSet {

    public class Employee {

        public int id;

        public Employee(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}

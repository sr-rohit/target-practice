package com.codegym.task.task18.task1815;

import java.util.List;

/* 
Table

*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {

        TableInterface tableInterface;

        public TableInterfaceWrapper(TableInterface tableInterface) {
            this.tableInterface = tableInterface;
        }

        public void setModel(List rows) {
            System.out.println(rows.size());
            this.tableInterface.setModel(rows);
        }

        public String getHeaderText() {
            return this.tableInterface.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText) {
            this.tableInterface.setHeaderText(newHeaderText);
        }

    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}
package com.codegym.task.task17.task1714;

/* 
Comparable

*/

public class Beach implements Comparable<Beach> {
    private String name;
    private float distance;
    private int quality;

    @Override
    public synchronized int compareTo(Beach o) {
        int quality = this.quality - o.quality;
        quality += this.distance - o.distance;
        return quality;
    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4;

public class Hospital implements Comparable<Hospital> {

    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Hospital anotherHospital) {
        return anotherHospital.getName().compareTo(this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

}

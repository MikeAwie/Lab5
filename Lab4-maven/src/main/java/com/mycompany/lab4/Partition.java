package com.mycompany.lab4;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Partition {

    private Hospital hospital;
    private int capacity;
    private List<Element> elements;

    public Partition(Hospital hospital, int capacity) {
        this.hospital = hospital;
        this.capacity = capacity;
        this.elements = new ArrayList<>();
    }

    /**
     * @return the hospital
     */
    public Hospital getHospital() {
        return hospital;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the elements
     */
    public List<Element> getElements() {
        return elements;
    }

    public void subscribeElement(Element element) {
        elements.add(element);
    }

    public boolean isUnderSubscribed() {
        return elements.size() != capacity;
    }
}

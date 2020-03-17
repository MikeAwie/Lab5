/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4;

public class Element {

    private Resident resident;
    private Partition partition;

    public Element(Resident resident) {
        this.resident = resident;
    }

    /**
     * @return the resident
     */
    public Resident getResident() {
        return resident;
    }

    /**
     * @return the partition
     */
    public Partition getPartition() {
        return partition;
    }

    /**
     * @param partition the partition to set
     */
    public void setPartition(Partition partition) {
        this.partition = partition;
    }

}

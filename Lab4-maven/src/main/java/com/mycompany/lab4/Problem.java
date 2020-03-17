/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4;

import com.github.javafaker.Faker;

/**
 *
 * @author mike
 */
public class Problem {

    static public void solve() {

        Faker faker = new Faker();
        Resident resident = new Resident(faker.name().fullName());
        Hospital hospital = new Hospital(faker.company().name());

        System.out.println(resident);
        System.out.println(hospital);

        //Create a matching
    }

}

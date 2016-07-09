/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.website.forgetPassword;

import java.util.Random;

/**
 *
 * @author NABEEL
 */
public class RandomNumberGenrator {

    Random random;
    static RandomNumberGenrator rd = null;

    private RandomNumberGenrator() {
        this.random = new Random();
    }

    public static RandomNumberGenrator objectCreater() {
        if (rd == null) {
            rd = new RandomNumberGenrator();
        }
        return rd;
    }

    public int newNumber() {
        return random.nextInt(10000000);
        
    }

}

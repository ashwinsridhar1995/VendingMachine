/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ul;

import java.util.Scanner;

/**
 *
 * @author ashwinsridhar
 */
public class UserIOConsoleImpl implements UserIO {
    Scanner reader = new Scanner(System.in);
    
    @Override
    public void print(String message) {
         System.out.println(message);
    }

   
    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double number = reader.nextDouble();
        return number;
    }

  
    @Override
    public double readDouble(String prompt, double min, double max) {
        Boolean inrange = false;
        double number = 0;
        while(inrange == false){
            System.out.println(prompt);
            number = reader.nextDouble();
            if(number >= min && number <= max){
                inrange = true;
            }
        }
        return number;
        
    }

  
    @Override
    public float readFloat(String prompt) {
       System.out.println(prompt);
        float number = reader.nextFloat();
        return number; 
    }

   
    @Override
    public float readFloat(String prompt, float min, float max) {
        Boolean inrange = false;
        float number = 0;
        while(inrange == false){
            System.out.println(prompt);
            number = reader.nextFloat();
            if(number >= min && number <= max){
                inrange = true;
            }
        }
        return number;
    }

    
    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int number = reader.nextInt();
        return number;
    }

  
    @Override
    public int readInt(String prompt, int min, int max) {
        Boolean inrange = false;
        int number = 0;
        while(inrange == false){
            System.out.println(prompt);
            number = reader.nextInt();
            reader.nextLine();
            if(number >= min && number <= max){
                inrange = true;
            }
        }
        return number;
    }

    
    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long number = reader.nextLong();
        return number;
    }

    
    @Override
    public long readLong(String prompt, long min, long max) {
        Boolean inrange = false;
        long number = 0;
        while(inrange == false){
            System.out.println(prompt);
            number = reader.nextLong();
            if(number >= min && number <= max){
                inrange = true;
            }
        }
        return number;
    }

   
    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String characters = reader.nextLine();
        return characters;
    }
}

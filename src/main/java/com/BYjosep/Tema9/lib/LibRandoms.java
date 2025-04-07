package com.BYjosep.Tema9.lib;

import java.util.Random;

public class LibRandoms {
    private static Random random = new Random();


    /**
     * Randoms para ints
     **/
    public static int ranInt(){

        return ran(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static int ran(int min){

        return ran(min,Integer.MAX_VALUE);
    }


    public static int ran(int min, int max){

        return random.nextInt();
    }

    /**
     *
     * randoms para doubles
     *
     */

    public static double ranDouble(){
        return ran(Double.MIN_VALUE,Double.MAX_VALUE);
    }

    public static double ran(double min){
        return ran(min,Double.MAX_VALUE);
    }

    public static double ran(double min, double max) {

        return random.nextDouble() * (max - min);
    }

    /**
     *
     * randoms para floats
     *
     */

    public static float ranFloat(){
        return ran(Float.MIN_VALUE,Float.MAX_VALUE);
    }

    public static float ran(float min){
        return ran(min,Float.MAX_VALUE);
    }

    public static float ran(float min, float max){
        return random.nextFloat() * (max - min);
    }


    /**
     *
     * randoms de long
     *
     */

   public static long ranLong(){
       return ran(Long.MIN_VALUE,Long.MAX_VALUE);
   }

   public static long ranLong(long min){
       return ran(min,Long.MAX_VALUE);
   }

   public static long ran(long min, long max){
       return random.nextLong() * (max - min);
   }

}

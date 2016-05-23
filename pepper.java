/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;

import java.util.Random;


/**
 *
 * @author Dominic
 */
public class pepper {
    
    public static void main(String[] args) {
        Random rand = new Random();
        
        String val = "-656";
        String val2 = "67897";
        HugeInteger m = new HugeInteger(val);
        //m.printList();
        HugeInteger y = new HugeInteger(val2);
        
        //HugeInteger sum = m.add(y);
        //sum.printList();
        
        HugeInteger diff = m.subtract(y);
        //diff.printList();
        //HugeInteger prod = m.multiply(y);
        //System.out.println(diff.toString());
        //System.out.println(m.compareTo(y));
        //HugeInteger j = new HugeInteger(6);
        //j.printList();
        HugeInteger huge1,huge2,huge3;
        double startTime, endTime;
        double runTime=0.0;
        int Maxnumints=100;
        int Maxrun = 150000000;
        int n=10000;
        
        /*for (int numints=0;numints<Maxnumints;numints++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            startTime = System.currentTimeMillis();
            for (int numRun=0;numRun<Maxrun;numRun++){
                huge3 = huge1.add(huge2);
            }
            endTime = System.currentTimeMillis();
            
            runTime +=(double) (endTime - startTime)/((double) Maxrun);
            System.out.println(endTime-startTime);
        }
        runTime = runTime/((double)Maxnumints);
        System.out.println(runTime);*/
        
        /*for (int numints=0;numints<Maxnumints;numints++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            startTime = System.currentTimeMillis();
            for (int numRun=0;numRun<Maxrun;numRun++){
                huge3 = huge1.subtract(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) Maxrun);
            System.out.println(endTime-startTime);
        }
        runTime = runTime/((double)Maxnumints);
        System.out.println(runTime);*/
        /*for (int numints=0;numints<Maxnumints;numints++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            startTime = System.currentTimeMillis();
            for (int numRun=0;numRun<Maxrun;numRun++){
                huge3 = huge1.multiply(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) Maxrun);
            System.out.println(endTime-startTime);
        }
        runTime = runTime/((double)Maxnumints);
        System.out.println(runTime);*/
        for (int numints=0;numints<Maxnumints;numints++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            startTime = System.currentTimeMillis();
            for (int numRun=0;numRun<Maxrun;numRun++){
                int r = huge1.compareTo(huge2);
            }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) Maxrun);
            System.out.println(endTime-startTime);
        }
        runTime = runTime/((double)Maxnumints);
        System.out.println(runTime);
        /*for (int numints=0;numints<Maxnumints;numints++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            java.math.BigInteger b1 = new java.math.BigInteger(huge1.toString());
            
            java.math.BigInteger b2 = new java.math.BigInteger(huge2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun=0;numRun<Maxrun;numRun++){
                java.math.BigInteger b3 = b1.add(b2);
            }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) Maxrun);
        }
        runTime = runTime/((double)Maxnumints);
        System.out.println(runTime);*/
        
        for (int numints=0;numints<Maxnumints;numints++){
            huge1 = new HugeInteger(n);
            huge2 = new HugeInteger(n);
            java.math.BigInteger b1 = new java.math.BigInteger(huge1.toString());
            
            java.math.BigInteger b2 = new java.math.BigInteger(huge2.toString());
            startTime = System.currentTimeMillis();
            for (int numRun=0;numRun<Maxrun;numRun++){
                int f = b1.compareTo(b2);
            }
            endTime = System.currentTimeMillis();
            runTime +=(double) (endTime - startTime)/((double) Maxrun);
        }
        runTime = runTime/((double)Maxnumints);
        System.out.println(runTime);
        
        
        
        
        
    }
    
}

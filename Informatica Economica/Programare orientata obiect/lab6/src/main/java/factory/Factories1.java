/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

/**
 *
 * @author alexandra
 */
public class Factories1 {
    public static void serviceConsumer(DoughnutFactory fact){
        Doughnut d=fact.createDoughnut();
        d.bake();
    }
     public static void main(String[] args){
     serviceConsumer(new RaisedDoughnutFactory());
      serviceConsumer(new FilledDoughnutFactory());
     }   
}

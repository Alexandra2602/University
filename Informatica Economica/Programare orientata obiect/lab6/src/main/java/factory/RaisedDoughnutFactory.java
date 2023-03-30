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
public class RaisedDoughnutFactory implements DoughnutFactory{
    public Doughnut createDoughnut(){
        return new RaisedDoughnut();
    }
    
}

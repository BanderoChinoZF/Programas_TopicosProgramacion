/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoClase;

import java.lang.Thread;
import java.lang.Runnable;
import java.util.Random;

public class Hilo4 implements Runnable{
    
	public void run()
        {
            
            contador();
		   
	}	
        
	public synchronized void contador()
        {
            System.out.println("Soy el hilo:" + Thread.currentThread().getName());
            for(int x = 1 ; x <= 20; x++)
            {
                System.out.print(" "+ x + " ");
		System.out.println();
            }
	}
}
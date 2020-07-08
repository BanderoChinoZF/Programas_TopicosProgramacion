package codigoClase;

import java.util.Random;

public class Hilo implements Runnable {
    
    int suma = 0;
    
    public void run()
    {
        Random rdm = new Random();
        int prioridad = rdm.nextInt(10)+1;
        
        if(prioridad < 5)
        {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        }
        else if(prioridad > 5)
        {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        }
        
        synchronized(this)
        {
            System.out.println("Soy el hilo: " + Thread.currentThread().getName() + " con la prioridad "+
                                Thread.currentThread().getPriority());
            
            int prio = Thread.currentThread().getPriority();
            
            suma = suma+prio;
            
            System.out.println("Variable: " + suma);
            
            
        }
        
        //System.out.println("Soy el hilo: " + Thread.currentThread().getName() + " con la prioridad "+ 
        //                    Thread.currentThread().getPriority());
        
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

package codigoClase;

import java.lang.Thread;
import java.lang.Runnable;
import java.util.Random;

public class Hilo3 implements Runnable{
    
	public void run()
        {
            contador();   
	}
        
	public void contador(){
            System.out.println("Soy el hilo:" + Thread.currentThread().getName());
            synchronized(this) {
                for(int x = 1 ; x <= 20; x++)
                {
                    System.out.print(" "+ x + " ");
                }
                
                System.out.println();
	}
	}
}



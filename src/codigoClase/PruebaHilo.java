package codigoClase;

public class PruebaHilo 
{
    public static void main(String []args)
    {
        Hilo h1 = new Hilo();
        
        for(int i=0;i<10;i++)
        {
            Thread t1 = new Thread(h1);
            t1.start();
            
        }
    }
    
}

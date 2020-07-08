package codigoClase;

public class PruebaHilo4{
	public static void main(String[] args){
            
		Hilo4 h1 = new Hilo4();
		for (int i = 0 ; i< 10; i++){
			Thread t1 = new Thread(h1);
			t1.start();
		}		
	} 
}

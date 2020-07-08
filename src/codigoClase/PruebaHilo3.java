package codigoClase;

public class PruebaHilo3{
	public static void main(String[] args){
		Hilo3 h1 = new Hilo3();
		for (int i = 0 ; i< 10; i++){
			Thread t1 = new Thread(h1);
			t1.start();
		}		
	} 
}

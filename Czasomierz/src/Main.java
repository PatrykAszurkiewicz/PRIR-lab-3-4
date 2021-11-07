
public class Main {

	public static void main(String[] args) {
		new Czasomierz().start();
	}
}

class Czasomierz extends Thread {
	
	private int a = 0;
	private int b = 0;
	private int c = 0;
	
	String aa;
	String bb; 
	String cc;
	
	public void run() 
	{
		while(true) 
		{
			try {
				sleep(1000);
				if(a < 10) {
					aa = Integer.toString(a);
					aa = "0" + aa;
				}
				else {
					aa = Integer.toString(a);
				}
				if(b < 10) {
					bb = Integer.toString(b);
					bb = "0" + bb;
				}
				else {
					bb = Integer.toString(b);
				}
				if(c < 10) {
					cc = Integer.toString(c);
					cc = "0" + cc;
				}
				else {
					cc = Integer.toString(c);
				}
				System.out.println(cc + ":" + bb + ":" + aa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a++;
			if(a == 60) {
				a = 0;
				b++;
			}
			if(b == 60) {
				b = 0;
				c++;
			}
		}
	}
}
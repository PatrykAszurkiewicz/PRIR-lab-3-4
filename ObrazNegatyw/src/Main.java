import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) throws IOException {
		File input = new File("file.jpg");
		BufferedImage image = ImageIO.read(input);
		int width = image.getWidth();
		int height = image.getHeight();
		Portion a = new Portion(image, 0, width / 2, 0, height / 2);
		Portion b = new Portion(image, width / 2, width, 0, height / 2);
		Portion c = new Portion(image, 0, width / 2, height / 2, height);
		Portion d = new Portion(image, width / 2, width, height / 2, height);
		
		a.negative();
		b.negative();
		c.negative();
		d.negative();
		
    	File ouptut = new File("grayscale.jpg");
    	ImageIO.write(image, "jpg", ouptut);
	}

}

class Portion extends Thread{
	
	private BufferedImage image;
    private int width_start;
    private int width_end;
    private int height_start;
    private int height_end;
    
    public Portion(BufferedImage image, int ws, int we, int hs, int he) {
    	this.image = image;
    	this.width_start = ws;
    	this.width_end = we;
    	this.height_start = hs;
    	this.height_end = he;	
    }
    
    
    public void negative() {
    	try 
    	{
	    	for(int i = height_start; i < height_end; i++)
	    	{
	    		for(int j = width_start; j < width_end; j++)
	    		{
	    			Color c = new Color(image.getRGB(j, i));
	    			int red = (int)(c.getRed());
	    			int green = (int)(c.getGreen());
	    			int blue = (int)(c.getBlue());
	    			int final_red, final_green, final_blue;
	    
	    			final_red = 255-red;
	    			final_green = 255-green;
	    			final_blue = 255-blue;
	    			Color newColor = new Color(final_red, final_green, final_blue);
	    			image.setRGB(j,i,newColor.getRGB());
	    		} 
	    	}
	
    	} 
    	catch (Exception e) {}
    }
    
    

}
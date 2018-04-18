import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
public class ImageUtilsTester {

	public static void main(String[] args) {
		
		ImageUtils utils = new ImageUtils();
		
		Color[][] origPic = utils.loadImage("src/LennaCV.png");
		
		utils.addImage(origPic, "Original PIcture", 1);
		
		Color[][] bright=enhance(origPic);
		utils.addImage(bright, "Brighter Picture", 1);
		
		utils.display();
	}
		
		public static Color[][] enhance(Color[][] img){
			Color[][] pic= ImageUtils.cloneArray(img);
			for( int i=0; i < pic.length; i++) {
				for( int j=0; j < pic[i].length; j++) {
					Color pixels = img[i][j];
					int r = pixels.getRed();
					int g = pixels.getGreen();
					int b = pixels.getBlue();
					int r1=0;
					int g1=0;
					int b1=0;
					
					if(r>g && r>b) {
						if(r<256-64) {
							r1=r+64;
							g1=g;
							b1=b;
						}
						else {
							r1=r;
							g1=g;
							b1=b;
						}
					}
					else if(g>r && g>b) {
						if(g<256-64) {
							g1=g+64;	
							r1=r;
							b1=b;
						}
						else {
							g1=g;
							r1=r;
							b1=b;
						}
					}
					else if(b>r && b>g) {
						if(b<256-64) {
							b1=b+64;
							r1=r;
							g1=g;
						}
						else {
							b1=b;
							r1=r;
							g1=g;
						}
					}
					pic[i][j]= new Color(r1,g1,b1);
				}
			}
			return pic;
	}
}

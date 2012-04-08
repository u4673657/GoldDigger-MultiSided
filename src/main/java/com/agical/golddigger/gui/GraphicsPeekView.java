package com.agical.golddigger.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;

import com.agical.golddigger.view.PeekView;

public class GraphicsPeekView implements PeekView {

	private static Image loadImage(String name) {
		URL url = FieldView.class.getResource("/images/"+name); 
		return Toolkit.getDefaultToolkit().getImage(url);
	}
	private static Image hexImage1 = loadImage("hexagon1.png");
	private static Image hexImage2 = loadImage("hexagon2.png");
	/*final static double hexR = 21.0;
	final static double hexH = Math.sqrt(3.0)*hexR/2.0;	
	
	public static int hexX (double x)
	{
		return (int) Math.round(3.0/2.0 * x * hexR);
	}
	public static int hexY (double x, double y, int c)
	{
		
		if (c % 2 == 0)
		{
			return (int) Math.round((2.0*y) * hexH + (x % 2) * hexH + hexH);
			
		}
		else
		{
			return (int) Math.round((2.0*y) * hexH + (x % 2) * hexH);
			
		}
	}*/
	
	
	
	
	private static Image GOLD1 = loadImage("gold1.png");
	private static Image GOLD2 = loadImage("gold2.png");
	private static Image GOLD3 = loadImage("gold3.png");
	private static Image GOLD4 = loadImage("gold4.png");
	private static Image GOLD5 = loadImage("gold5.png");
	private static Image GOLD6 = loadImage("gold6.png");
	private static Image GOLD7 = loadImage("gold7.png");
	private static Image GOLD8 = loadImage("gold8.png");
	private static Image GOLD9 = loadImage("gold9.png");
	
	private static Image BANK = loadImage("bank.png");
	private static Image SHADE = loadImage("shade.png");
	
	private static Image[] golds = new Image[]{GOLD1, GOLD2, GOLD3, GOLD4, GOLD5, GOLD6, GOLD7, GOLD8, GOLD9};
	
	private static Image DIGGER = loadImage("digger.png");
	private static Image EMPTY = hexImage1;//loadImage("empty.png");
	private static Image W_CENTER = hexImage2;//loadImage("center.png");
	private static Image SOLID = hexImage2;//loadImage("solid.png");
	private static Image W_NORTH = hexImage2;//loadImage("w_north.png");
	private static Image W_NORTHEAST = hexImage2;//loadImage("w_northeast.png");
	private static Image W_NORTHEAST_INVERTED = hexImage2;//loadImage("w_northeast_i.png");
	private static Image W_EAST = hexImage2;//loadImage("w_east.png");
	private static Image W_SOUTHEAST = hexImage2;//loadImage("w_southeast.png");
	private static Image W_SOUTHEAST_INVERTED = hexImage2;//loadImage("w_southeast_i.png");
	private static Image W_SOUTH = hexImage2;//loadImage("w_south.png");
	private static Image W_SOUTHWEST = hexImage2;//loadImage("w_southwest.png");
	private static Image W_SOUTHWEST_INVERTED = hexImage2;//loadImage("w_southwest_i.png");
	private static Image W_WEST = hexImage2;//loadImage("w_west.png");
	private static Image W_NORTHWEST = hexImage2;//loadImage("w_northwest.png");
	private static Image W_NORTHWEST_INVERTED = hexImage2;//loadImage("w_northwest_i.png");
	


	private final Graphics graphics;

	private ImageObserver imageObserver;

	public GraphicsPeekView(Graphics graphics, ImageObserver imageObserver) {
		this.graphics = graphics;
		this.imageObserver = imageObserver;
	}

	@Override
	public void drawCenterWall(int x, int y) {
		drawImage(x, y, W_CENTER);
	}

	@Override
	public void drawEmpty(int x, int y) {
		drawImage(x, y, EMPTY);
	}

	@Override
	public void drawSolidWall(int x, int y) {
		drawImage(x, y, SOLID);
	}

	@Override
	public void drawNorthWall(int x, int y) {
		drawImage(x, y, W_NORTH);
	}

	@Override
	public void drawSouthWall(int x, int y) {
		drawImage(x, y, W_SOUTH);
	}

	@Override
	public void drawEastWall(int x, int y) {
		drawImage(x, y, W_EAST);
	}

	@Override
	public void drawWestWall(int x, int y) {
		drawImage(x, y, W_WEST);
	}

	@Override
	public void drawNorthEastWall(int x, int y) {
		drawImage(x, y, W_NORTHEAST);
	}

	@Override
	public void drawSouthEastWall(int x, int y) {
		drawImage(x, y, W_SOUTHEAST);
	}

	@Override
	public void drawSouthWestWall(int x, int y) {
		drawImage(x, y, W_SOUTHWEST);
	}

	@Override
	public void drawNorthWestWall(int x, int y) {
		drawImage(x, y, W_NORTHWEST);
	}

	private boolean drawImage(int x, int y, Image image) {
	return graphics.drawImage(image, x, y, imageObserver);
	//	return graphics.drawImage(image, (int) hexX(x, 0.0), (int) hexY(x, y, 0.0), imageObserver);//(int) hexX(x, 0.0)*32, (int) hexY(x, y, 0.0)*32, imageObserver);
	}

	@Override
	public void drawInvertedNorthEastWall(int x, int y) {
		drawImage(x, y, W_NORTHEAST_INVERTED);
	}

	@Override
	public void drawInvertedNorthWestWall(int x, int y) {
		drawImage(x, y, W_NORTHWEST_INVERTED);
	}

	@Override
	public void drawInvertedSouthEastWall(int x, int y) {
		drawImage(x, y, W_SOUTHEAST_INVERTED);
	}

	@Override
	public void drawInvertedSouthWestWall(int x, int y) {
		drawImage(x, y, W_SOUTHWEST_INVERTED);
	}

	@Override
	public void drawDigger(int x, int y) {
		drawImage(x, y, DIGGER);
	}

	@Override
	public void drawGold(int x, int y, int count) {
		drawImage(x, y, golds[count-1]);
	}

    @Override
    public void drawShadow(int x, int y) {
    	drawImage(x, y, SHADE);
        
    }

    @Override
    public void drawBank(int x, int y) {
    	drawImage(x, y, BANK);
    }

}

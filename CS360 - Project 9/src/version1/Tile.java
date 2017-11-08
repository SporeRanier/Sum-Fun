package version1;
//Michael Wolgast
//Side Class - Tile

//This holds the tile object

import java.awt.*;
import java.io.*;

import javax.swing.*;


public class Tile extends JButton implements Serializable
{
	
	private static final long serialVersionUID = 6267786720361021881L;
	JButton tile;
	
	
	public Tile(){
		
		tile = new JButton("O");
		
		tile.setBackground(Color.RED);
		tile.setForeground(Color.WHITE);
		tile.setOpaque(true);
		tile.setPreferredSize(new Dimension (30, 20));
			
		
	}
	
	
}

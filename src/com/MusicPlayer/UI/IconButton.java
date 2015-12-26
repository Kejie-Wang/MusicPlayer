package com.MusicPlayer.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton{
	
	private final int buttonWidth = 30;
	private final int buttonHeight = 30;
	
	public IconButton() {
		// TODO Auto-generated constructor stub
		setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		setBorderPainted(false);
		setContentAreaFilled(false);
	}
	
	public IconButton(String url){
		setIcon(new ImageIcon(url));
		setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		setBorderPainted(false);
		setContentAreaFilled(false);
	}
	
	public void setIcon(String url){
		setIcon(new ImageIcon(url));
	}
}

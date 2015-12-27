package com.MusicPlayer.UI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Timer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 * 
 * @author Jack
 * @Date 2015/12/25
 */

public class MusicPlayBar extends JPanel{
	
	private static JSlider processBar;
	
	public MusicPlayBar() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(0, 0, 0));
		Box box = Box.createHorizontalBox();
		add(box);
		
		processBar = new JSlider();		
		processBar.setMinimum(0);
		processBar.setMaximum(100);	
		processBar.setBackground(new Color(0, 0, 0));
		processBar.setValue(0);
		
		box.add(Box.createHorizontalStrut(5));
		box.add(processBar);
		box.add(Box.createHorizontalStrut(5));
	}

	public static void setValue(int value){
		processBar.setValue(value);
	}

	public JSlider getProcessBar(){
		return processBar;
	}
}
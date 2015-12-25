package com.MusicPlayer.UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * 
 * @author Jack
 * @Date 2015/12/25
 */

public class MusicPlayBar extends JPanel{
	
	JProgressBar processBar;
	
	public MusicPlayBar() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box box = Box.createHorizontalBox();
		add(box);
		
		processBar = new JProgressBar();		
		processBar.setMinimum(0);
		processBar.setMaximum(100);	
		
		box.add(Box.createHorizontalStrut(5));
		box.add(processBar);
		box.add(Box.createHorizontalStrut(5));
	}
	
	public void setMax(int max){
		processBar.setMaximum(max);
	}
}

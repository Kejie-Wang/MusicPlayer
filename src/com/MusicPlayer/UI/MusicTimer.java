package com.MusicPlayer.UI;

import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class MusicTimer extends Panel {
	private JLabel totalTime;
	private JLabel nowTime;
	
	public MusicTimer() {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box box = Box.createHorizontalBox();
		add(box);
		
		totalTime = new JLabel("00:00");
		nowTime = new JLabel("00:00");
		
		box.add(Box.createHorizontalStrut(5));
		box.add(nowTime);
		box.add(Box.createHorizontalGlue());
		box.add(totalTime);
		box.add(Box.createHorizontalStrut(5));
	}
}

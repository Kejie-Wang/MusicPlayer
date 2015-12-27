package com.MusicPlayer.UI;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class MusicTimer extends Panel {
	private JLabel totalTime;
	private static JLabel nowTime;
	
	public MusicTimer() {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box box = Box.createHorizontalBox();
		add(box);
		
		totalTime = new JLabel("00:00");
		nowTime = new JLabel("00:00");
		
		totalTime.setForeground(new Color(67, 218, 215));
		nowTime.setForeground(new Color(67, 218, 215));
		
		box.add(Box.createHorizontalStrut(5));
		box.add(nowTime);
		box.add(Box.createHorizontalGlue());
		box.add(totalTime);
		box.add(Box.createHorizontalStrut(5));
	}
	
	public JLabel getTotalTime(){
		return totalTime;
	}
	
	public JLabel getnowTime(){
		return nowTime;
	}

	public static void setNowTime(String time){
		nowTime.setText(time);
	}
}

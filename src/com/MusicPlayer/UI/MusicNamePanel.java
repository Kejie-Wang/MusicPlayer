package com.MusicPlayer.UI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @brief 
 * @author Jack
 * @Date 2015/12/24
 */
public class MusicNamePanel extends JPanel{
	
	private JLabel musicName;
	
	public MusicNamePanel() {
		musicName = new JLabel("music");
		setLayout(new BorderLayout());
		add(musicName, BorderLayout.WEST);
	}
	
	public void setMusicName(String name){
		musicName.setText(name);
	}
}

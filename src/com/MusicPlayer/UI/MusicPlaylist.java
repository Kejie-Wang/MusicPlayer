package com.MusicPlayer.UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

public class MusicPlaylist extends  JScrollPane {
	JMenuBar musicList;
	
	public MusicPlaylist() {
		// TODO Auto-generated constructor stub
		musicList = new JMenuBar();
		
		JMenu menu = new JMenu("File");
		musicList.add(menu);
		
		add(musicList);
	}
	
	void addASong(){
		
	}
}

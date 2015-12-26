package com.MusicPlayer.UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.MusicPlayer.constant.PLAYSTATE;

public class MusicTools extends JPanel{
	
	private IconButton playMode;
	private IconButton last;
	private IconButton playState;
	private IconButton next;
	private IconButton voiceImage;
	private JSlider voiceCtrBar;

	
	public MusicTools() {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Box box = Box.createHorizontalBox();
		add(box);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));
		
		playMode = new IconButton("icon/play.png");
		box.add(playMode);
		
		box.add(Box.createRigidArea(new Dimension(30, 30)));
		
		last = new IconButton("icon/last.png");
		box.add(last);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));
		
		playState = new IconButton("icon/pause.png");
		box.add(playState);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));
		
		next = new IconButton("icon/next.png");
		box.add(next);
		
		box.add(Box.createRigidArea(new Dimension(20, 30)));
		
		voiceImage = new IconButton("icon/voice.png");
		box.add(voiceImage);
				
		voiceCtrBar = new JSlider();
		voiceCtrBar.setMaximum(100);
		voiceCtrBar.setMinimum(0);
		voiceCtrBar.setPreferredSize(new Dimension(50, 30));
		box.add(voiceCtrBar);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));	
	}
	
	public IconButton getPlayMode(){
		return playMode;
	}
	
	public IconButton getLast(){
		return last;
	}
	
	public IconButton getPlayState(){
		return playState;
	}
	
	public IconButton getNext(){
		return next;
	}
		
	public JSlider getVoiceCtrBar(){
		return voiceCtrBar;
	}
}

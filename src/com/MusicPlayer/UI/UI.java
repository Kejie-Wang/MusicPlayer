package com.MusicPlayer.UI;

import java.awt.*;
import javax.swing.*;

/**
 * @brief 
 * @author Jack
 * @Date 2015/12/24
 */
public class UI extends JFrame{
	
	static final int FrameWidth = 350;
	static final int FrameHeight = 650;
	
	static final int nameBoxHeight = 40;
	static final int processBarHeight = 30;
	static final int timerHeight = 10;
	static final int toolsHeight = 30;
	
	//components
	MusicNamePanel namePanel;
	MusicPlayBar playBar;
	MusicTimer	timer;
	MusicTools tools;
	MusicPlaylist playlist;
	
	public UI(){
		setSize(new Dimension(FrameWidth, FrameHeight));
		setMaximumSize(new Dimension(FrameWidth, FrameHeight));
		setMinimumSize(new Dimension(FrameWidth, FrameHeight));
		namePanel = new MusicNamePanel();
		playBar = new MusicPlayBar();
		timer = new MusicTimer();
		tools = new MusicTools();
		playlist = new MusicPlaylist();
		setResizable(false); 
		buildLayout();
		setVisible(true);
	}
	
	private void buildLayout(){
		/*
		 * a list of box	
		 */		
		Box nameBox = Box.createVerticalBox();
		Box processBarBox = Box.createHorizontalBox();
		Box timeBox = Box.createHorizontalBox();
		Box toolsBox = Box.createVerticalBox();
		Box listBox = Box.createVerticalBox();
		
		Container mainPanel = getContentPane();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		namePanel.setMinimumSize(new Dimension(FrameWidth, nameBoxHeight));	
		playBar.setMinimumSize(new Dimension(FrameWidth, processBarHeight));
		timer.setMinimumSize(new Dimension(FrameWidth, timerHeight));
		tools.setMinimumSize(new Dimension(FrameWidth, toolsHeight));
		playlist.setMinimumSize(new Dimension(FrameWidth, 400));
		
		namePanel.setMaximumSize(new Dimension(FrameWidth, nameBoxHeight));	
		playBar.setMaximumSize(new Dimension(FrameWidth, processBarHeight));
		timer.setMaximumSize(new Dimension(FrameWidth, timerHeight));
		tools.setMaximumSize(new Dimension(FrameWidth, toolsHeight));
		
		mainPanel.add(nameBox);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(processBarBox);
		mainPanel.add(timeBox);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(toolsBox);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(listBox);
		
		nameBox.add(namePanel);
		processBarBox.add(playBar);
		timeBox.add(timer);
		toolsBox.add(tools);
		listBox.add(playlist);
	}
	
}

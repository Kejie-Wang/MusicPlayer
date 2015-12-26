package com.MusicPlayer.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.MusicPlayer.constant.PLAYSTATE;
import com.MusicPlayer.music.Music;
import com.MusicPlayer.player.Player;

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
	private MusicNamePanel namePanel;
	private MusicPlayBar playBar;
	private MusicTimer	timer;
	private MusicTools tools;
	private MusicPlaylist playlist;
	private Player player;
	
	private PLAYSTATE state;
	
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
		
		player = new Player();
		state = PLAYSTATE.PAUSE;
		
		addAction();
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
		mainPanel.add(Box.createVerticalStrut(20));
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
	
	public void display(){
		setVisible(true);
	}
	
	public void addAction(){
		//add music components
		IconButton addASongFile = namePanel.getAddASongFile();
		IconButton addASongDir = namePanel.getAddASongDir();
		
		//music tools components
		IconButton playMode = tools.getPlayMode();
		IconButton last = tools.getLast();
		IconButton playState = tools.getPlayState();
		IconButton next = tools.getNext();
		JSlider voiceCtrBar = tools.getVoiceCtrBar();
			
		JTable musicShowList = playlist.getMusicShowList();
		
		
		addASongFile.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						//fileChooser.showDialog(new JLabel(), "添加一首歌曲");
						FileNameExtensionFilter songFilter = new FileNameExtensionFilter(
								"音频文件(*.mid;*.mp3;*.wav)", "mid", "MID", "mp3", "MP3", "wav", "WAV");
						fileChooser.setFileFilter(songFilter);
						fileChooser.setMultiSelectionEnabled(true);	//can select multiply files
						
						if(fileChooser.showOpenDialog(new JLabel()) != JFileChooser.APPROVE_OPTION ){
							return;
						}
						
						File[] songs = fileChooser.getSelectedFiles();
						
						playlist.addSongs(player.addSongs(songs));
					}
				});
		
		
		playMode.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		last.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		next.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		
		playState.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(state == PLAYSTATE.PAUSE){
							state = PLAYSTATE.PLAYING;
							playState.setIcon(new ImageIcon("icon/play.png"));
						}else{
							state = PLAYSTATE.PAUSE;
							playState.setIcon(new ImageIcon("icon/pause.png"));
						}
					}
				});

		
		musicShowList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() >= 2){
					int r = musicShowList.getSelectedRow();
					System.out.println(musicShowList.getModel().getValueAt(r, 3));
					player.setCurrentAudio((String) musicShowList.getModel().getValueAt(r, 3));
					player.play();

				}
			}
		});
	}
}

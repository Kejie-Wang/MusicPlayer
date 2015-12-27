package com.MusicPlayer.UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.MusicPlayer.constant.PLAYMODE;
import com.MusicPlayer.constant.PLAYSTATE;
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
	private PLAYMODE mode;
	boolean isInit = false;
	
	public UI(){
		setSize(new Dimension(FrameWidth, FrameHeight));
		setMaximumSize(new Dimension(FrameWidth, FrameHeight));
		setMinimumSize(new Dimension(FrameWidth, FrameHeight));
		setBackground(new Color(0, 0, 0));
		namePanel = new MusicNamePanel();
		playBar = new MusicPlayBar();
		timer = new MusicTimer();
		tools = new MusicTools();
		playlist = new MusicPlaylist();
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
		
		player = new Player(playlist);
		mode = PLAYMODE.LISTLOOP;
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
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(processBarBox);
		mainPanel.add(timeBox);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(toolsBox);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(listBox);
		mainPanel.setBackground(new Color(0, 0, 0));
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
		JLabel musicName = namePanel.getMusicName();
		IconButton addASongFile = namePanel.getAddASongFile();
		IconButton addASongDir = namePanel.getAddASongDir();
		
		//music tools components
		IconButton playMode = tools.getPlayMode();
		IconButton last = tools.getLast();
		IconButton playState = tools.getPlayState();
		IconButton next = tools.getNext();
		JSlider voiceCtrBar = tools.getVoiceCtrBar();
		
		JSlider progressBar = playBar.getProcessBar(); 
		
		//music time control 
		JLabel nowTime = timer.getnowTime();
		JLabel totalTime = timer.getTotalTime();
				
		JTable musicShowList = playlist.getMusicShowList();
		
		addASongFile.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
						FileNameExtensionFilter songFilter = new FileNameExtensionFilter(
								"ÒôÆµÎÄ¼þ(*.mid;*.mp3;*.wav)", "mid", "MID", "mp3", "MP3", "wav", "WAV");
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
						System.out.println(mode.toString());
						if(mode == PLAYMODE.LISTLOOP){
							mode = PLAYMODE.SEQUENTIAL;
							playMode.setIcon(new ImageIcon("icon/sequential.png"));
						}else if(mode == PLAYMODE.SEQUENTIAL){
							mode = PLAYMODE.RANDOOM;
							playMode.setIcon(new ImageIcon("icon/random.png"));
						}else if(mode == PLAYMODE.RANDOOM){
							mode = PLAYMODE.SINGLE;
							playMode.setIcon(new ImageIcon("icon/single.png"));
						}else{
							mode = PLAYMODE.LISTLOOP;
							playMode.setIcon(new ImageIcon("icon/listloop.png"));
						}
					}
				}
			);
		
		last.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(!isInit)
							return;
						if(mode == PLAYMODE.RANDOOM){
							Random r = new Random();
							int row = r.nextInt(playlist.getMusicNum());
							player.setCurrentAudio((String) musicShowList.getModel().getValueAt(row, 3));
						}else {
							int row = (playlist.getPlayingRow() + playlist.getMusicNum() - 1)%playlist.getMusicNum();			 
							player.setCurrentAudio((String) musicShowList.getModel().getValueAt(row, 3));
						}
						player.play();
					}
				});
		
		next.addActionListener(
				new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(!isInit)
							return;
						if(mode == PLAYMODE.RANDOOM){
							Random r = new Random();
							int row = r.nextInt(playlist.getMusicNum());
							playlist.setPlayingRow(row);
							musicName.setText((String)musicShowList.getModel().getValueAt(row, 0));
							totalTime.setText((String)musicShowList.getModel().getValueAt(row, 2));
							player.setCurrentAudio((String) musicShowList.getModel().getValueAt(row, 3));
						}else {
							int row = (playlist.getPlayingRow() + 1)%playlist.getMusicNum();			 
							playlist.setPlayingRow(row);
							musicName.setText((String)musicShowList.getModel().getValueAt(row, 0));
							totalTime.setText((String)musicShowList.getModel().getValueAt(row, 2));
							player.setCurrentAudio((String) musicShowList.getModel().getValueAt(row, 3));
						}
						player.play();
					}
				});
		
		playState.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(state == PLAYSTATE.PAUSE){
							if(!isInit && musicShowList.getRowCount() > 0){
								isInit = true;
								player.setCurrentAudio((String) musicShowList.getModel().getValueAt(0, 3));
								state = PLAYSTATE.PLAYING;
								playState.setIcon(new ImageIcon("icon/play.png"));
								musicName.setText((String)musicShowList.getModel().getValueAt(0, 0));
								totalTime.setText((String)musicShowList.getModel().getValueAt(0, 2));
								playlist.setPlayingRow(0);
								player.play();
							}else if(isInit){					
								state = PLAYSTATE.PLAYING;
								playState.setIcon(new ImageIcon("icon/play.png"));
								player.resume();
							}
						}else{
							state = PLAYSTATE.PAUSE;
							playState.setIcon(new ImageIcon("icon/pause.png"));
							player.pause();
						}
					}
				});
	
		voiceCtrBar.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				player.setVolume(voiceCtrBar.getValue());
			}
		}); 
		
		musicShowList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() >= 2){
					int r = musicShowList.getSelectedRow();
					System.out.println(musicShowList.getModel().getValueAt(r, 3));
					player.setCurrentAudio((String) musicShowList.getModel().getValueAt(r, 3));
					player.play();
					playState.setIcon(new ImageIcon("icon/play.png"));
					musicName.setText((String)musicShowList.getModel().getValueAt(r, 0));
					totalTime.setText((String)musicShowList.getModel().getValueAt(r, 2));
					playlist.setPlayingRow(musicShowList.getSelectedRow());
					state = PLAYSTATE.PLAYING;
					isInit = true;
				}
			}
		});
	}
}

package com.MusicPlayer.player;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.MusicPlayer.UI.MusicPlayBar;
import com.MusicPlayer.UI.MusicPlaylist;
import com.MusicPlayer.UI.MusicTimer;
import com.MusicPlayer.constant.PLAYMODE;
import com.MusicPlayer.music.Music;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class Player implements BasicPlayerListener {
	
	private Music currMusic;
	private BasicPlayer basicPlayer;
	private BasicController controller;
	private PLAYMODE mode;
	private MusicPlaylist playlist;
	
	private static HashMap<String, Music> musicList = new HashMap<String, Music>();
	
	public Player(MusicPlaylist playlist){
		currMusic = new Music();
		this.playlist = playlist;
		basicPlayer = new BasicPlayer();
		controller = (BasicController)basicPlayer;
		musicList = new HashMap<String, Music>();
		mode = PLAYMODE.SEQUENTIAL;
	}
	
	public ArrayList<Music> addSongs(File[] songs){
		ArrayList<Music> musicInfoList = new ArrayList<Music>();
		
		for(File song : songs){
			if(!song.exists()){
				continue;		
			}
			
			String path = song.getAbsolutePath();
			if(musicList.containsKey(path)){
				continue;
			}
			Music music = new Music(song);
			musicList.put(path, music);
			musicInfoList.add(music);
		}
		
		return musicInfoList;
	}
	
	public void setCurrentAudio(String path){
		this.currMusic = musicList.get(path);
	}
	
	public void play(){
		try {
			File f = new File(currMusic.getPath());
			basicPlayer.open(new File(currMusic.getPath()));
			basicPlayer.play();
			basicPlayer.addBasicPlayerListener(this);
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

	public void pause(){
		try {
			controller.pause();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resume(){
		try {
			controller.resume();
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVolume(int volume){
		try {
			controller.setGain(volume / 100.0);
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties){	   
	   double progressPrecent = microseconds / 10000.0 / currMusic.getTotalTime();
	   MusicPlayBar.setValue((int)progressPrecent);
	   
	   String nowTime = new String();
	   int min = (int) (microseconds / 1000000.0 / 60);
	   int sec = ((int) (microseconds / 1000000.0)) % 60;
		
		if(min < 10)
			nowTime += "0";
		nowTime += (new Integer(min)).toString() + ":";
		if(sec < 10)
			nowTime += "0";
		nowTime += (new Integer(sec)).toString();
		MusicTimer.setNowTime(nowTime);
	}
	
	@Override
	public void opened(Object arg0, Map arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(BasicController arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateUpdated(BasicPlayerEvent ue) {
		// TODO Auto-generated method stub
		
	}
	
	public void seekTime(int percentage){
		try {
			controller.seek((long) (percentage / 100.0 * currMusic.getTotalBytes()));
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void last(){
		if(mode == PLAYMODE.RANDOOM){
			Random r = new Random();
			int row = r.nextInt(playlist.getMusicNum());
			setCurrentAudio((String) playlist.getMusicShowList().getModel().getValueAt(row, 2));
		}else {
			int row = (playlist.getPlayingRow() + playlist.getMusicNum() + 1)%playlist.getMusicNum();
			setCurrentAudio((String) playlist.getMusicShowList().getModel().getValueAt(row, 2));
		}
		play();
	}
}

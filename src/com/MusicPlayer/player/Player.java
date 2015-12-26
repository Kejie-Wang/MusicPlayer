package com.MusicPlayer.player;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.MusicPlayer.music.Music;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Player {
	
	private Music currMusic;
	private BasicPlayer basicPlayer;
	
	private static HashMap<String, Music> musicList = new HashMap<String, Music>();
	
	public Player(){
		currMusic = new Music();
		basicPlayer = new BasicPlayer();
		musicList = new HashMap<String, Music>();
	}
	
	public static ArrayList<Music> addSongs(File[] songs){
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
		} catch (BasicPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
}

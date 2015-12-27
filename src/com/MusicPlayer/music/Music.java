package com.MusicPlayer.music;

import java.io.File;

import org.jaudiotagger.audio.*;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.id3.ID3v23Tag;

public class Music {
	
	private String path;
	private String musicName;
	private int duration;
	private int bitRate;
	private long totalBytes;
	private String artist;
	private String alnum;
	private String year;

	
	public Music() {
		// TODO Auto-generated constructor stub
	}
	
	public Music(File song){
		try{
			path = song.getAbsolutePath();
			MP3File file = (MP3File)AudioFileIO.read(song); 
			ID3v23Tag tag = (ID3v23Tag) file.getID3v2Tag();
			AudioHeader header = file.getAudioHeader();
			
			musicName = song.getName();
			duration = header.getTrackLength();
			bitRate = new Integer(header.getBitRate());
			totalBytes = duration * bitRate / 8;
			artist = tag.getFirst(FieldKey.ARTIST);
			alnum = tag.getFirst(FieldKey.ALBUM);
			year = tag.getFirst(FieldKey.YEAR);		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getMusicName(){
		return musicName;
	}
	
	public String getDuration(){
		String dura = new String();
		int min = duration / 60;
		int sec = duration % 60;
		
		if(min < 10)
			dura += "0";
		dura += (new Integer(min)).toString() + ":";
		if(sec < 10)
			dura += "0";
		dura += (new Integer(sec)).toString();
		
		return dura;
	}
	
	public int getTotalTime(){
		return duration;
	}
	
	public int getBitRate(){
		return bitRate;
	}
	
	public long getTotalBytes(){
		return totalBytes;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public String getAlbum(){
		return alnum;
	}
	
	public String getYear(){
		return year;
	}

	public String getPath(){
		return path;
	}
}

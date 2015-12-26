package com.MusicPlayer.UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.MusicPlayer.music.Music;

import com.MusicPlayer.player.*;

public class MusicPlaylist extends  JScrollPane {
	
	private JTable musicShowList;
	
	private static NonEditDefaultTableModel tableModel;
	private final int columnNum = 4;
	private final String[] header = {"∏Ë«˙", "∏Ë ÷", " ±≥§", ""};
	private Object[][] data = new Object[0][columnNum];
	
	public MusicPlaylist() {
		// TODO Auto-generated constructor stub
		tableModel = new NonEditDefaultTableModel(data, header);
		musicShowList = new JTable(tableModel);
		musicShowList.setRowHeight(32);
		setViewportView(musicShowList);
		musicShowList.setShowGrid(false);	
		musicShowList.getTableHeader().setBackground(new Color(238, 238, 238));
		musicShowList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		musicShowList.getColumnModel().getColumn(1).setMaxWidth(70);
		musicShowList.getColumnModel().getColumn(2).setMaxWidth(70);
		musicShowList.getColumnModel().getColumn(1).setMinWidth(70);
		musicShowList.getColumnModel().getColumn(2).setMinWidth(70);
		/*
		musicShowList.getColumnModel().getColumn(3).setMaxWidth(0);
		musicShowList.getColumnModel().getColumn(3).setMinWidth(0);
		musicShowList.getColumnModel().getColumn(3).setPreferredWidth(0);
		*/
		musicShowList.removeColumn(musicShowList.getColumnModel().getColumn(3));
	}
	
	public void addSongs(ArrayList<Music> musicArray){	
		for(Music music : musicArray){	
			tableModel.addRow(new Object[]{
					music.getMusicName(),
					music.getArtist(),
					music.getDuration(),
					music.getPath()
			});
		}
	}
	
	public JTable getMusicShowList(){
		return musicShowList;
	}
	
	public void addAction(){
		musicShowList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount() >= 2){
					int r =musicShowList.getSelectedRow();
					
				}
			}
		});
	}
}


class NonEditDefaultTableModel extends DefaultTableModel{
	public NonEditDefaultTableModel(Object[][] data, Object[] columnNames){
		super(data, columnNames);
	}
	
	public boolean isCellEditable(int row, int column){
		return false;
	}
}

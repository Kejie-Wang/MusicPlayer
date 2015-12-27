package com.MusicPlayer.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.MusicPlayer.music.Music;

import com.MusicPlayer.player.*;

public class MusicPlaylist extends  JScrollPane {
	
	private JTable musicShowList;
	
	private int playingRow = 0;
	private static NonEditDefaultTableModel tableModel;
	private final int columnNum = 4;
	private final String[] header = {"∏Ë«˙", "∏Ë ÷", " ±≥§", ""};
	private Object[][] data = new Object[0][columnNum];
	
	public MusicPlaylist() {
		// TODO Auto-generated constructor stub
		setBackground(new Color(0, 0, 0));
		getViewport().setBackground(new Color(0, 0, 0));
		getVerticalScrollBar().setBackground(new Color(0, 0, 0));
		getVerticalScrollBar().setForeground(new Color(67, 218, 215));
		
		tableModel = new NonEditDefaultTableModel(data, header);
		musicShowList = new JTable(tableModel);
		musicShowList.setRowHeight(32);
		setViewportView(musicShowList);
		musicShowList.setShowGrid(false);	
		musicShowList.getTableHeader().setBackground(new Color(238, 238, 238));
		musicShowList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		musicShowList.getColumnModel().getColumn(1).setMaxWidth(60);
		musicShowList.getColumnModel().getColumn(2).setMaxWidth(60);
		musicShowList.getColumnModel().getColumn(1).setMinWidth(60);
		musicShowList.getColumnModel().getColumn(2).setMinWidth(60);
				
		musicShowList.setDefaultRenderer(Object.class, new CellRender());
		musicShowList.getTableHeader().setDefaultRenderer(new HeaderRender());
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

	public int 	getMusicNum(){
		return musicShowList.getRowCount();
	}
	
	public int getPlayingRow(){
		return playingRow;
	}
	
	public void setPlayingRow(int row){
		this.playingRow = row;
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

class HeaderRender extends DefaultTableCellRenderer{
	public  Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
    	this.setHorizontalAlignment(SwingConstants.CENTER);
		Component com = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
    	
    	com.setBackground(new Color(0, 0, 0));
    	com.setForeground(new Color(67, 218, 215));
    	this.setFont(new Font("Courier", 0, 15));
       return com;
    }
}

class CellRender extends DefaultTableCellRenderer{
    
	public  Component getTableCellRendererComponent(JTable table, Object value, 
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		
		this.setHorizontalAlignment(SwingConstants.CENTER);	
		
		Component com = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
		this.setFont(new Font("Courier", 0, 12));
    	com.setBackground(new Color(0, 0, 0));
    	com.setForeground(new Color(67, 218, 215));
    	
       return com;
    }
}

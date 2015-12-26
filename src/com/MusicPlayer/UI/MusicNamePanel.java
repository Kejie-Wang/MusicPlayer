package com.MusicPlayer.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;


/**
 * @brief 
 * @author Jack
 * @Date 2015/12/24
 */
public class MusicNamePanel extends JPanel{
	
	private JLabel musicName;
	private IconButton addASongFile;
	private IconButton addASongDir;
		
	public MusicNamePanel() {	
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Box box = Box.createHorizontalBox();
		add(box);
		
		musicName = new JLabel("music");
		addASongFile = new IconButton("icon/add.png");
		addASongDir = new IconButton("icon/dir.png");
		
		box.add(musicName, BorderLayout.WEST);
		box.add(Box.createGlue());
		box.add(addASongFile);
		box.add(Box.createRigidArea(new Dimension(5, 30)));
		box.add(addASongDir);
	}
	
	public void setMusicName(String name){
		musicName.setText(name);
	}
		
	public IconButton getAddASongFile(){
		return addASongFile;
	}
	
	public IconButton getAddASongDir(){
		return addASongDir;
	}
	
}













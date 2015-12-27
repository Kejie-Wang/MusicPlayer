package com.MusicPlayer.main;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;

import com.MusicPlayer.UI.UI;

/**
 * @brief
 * @author Jack
 * @Date 2015/12/24
 */
public class Main{
	
	public static void main(String[] argv){
		try{
			UIManager
				.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");
		
			SubstanceLookAndFeel
				.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMosaicWatermark");

			SubstanceLookAndFeel
				.setCurrentGradientPainter("org.jvnet.substance.painter.WaveGradientPainter");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		
		UI u = new UI();
		u.display();
	}
	
}












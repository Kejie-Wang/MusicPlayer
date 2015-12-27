package com.MusicPlayer.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import com.MusicPlayer.constant.PLAYSTATE;

public class MusicTools extends JPanel{
	
	private IconButton playMode;
	private IconButton last;
	private IconButton playState;
	private IconButton next;
	private IconButton voiceImage;
	private JSlider voiceCtrBar;

	
	public MusicTools() {
		// TODO Auto-generated constructor stub
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(0, 0, 0));
		Box box = Box.createHorizontalBox();
		add(box);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));
		
		playMode = new IconButton("icon/sequential.png");
		box.add(playMode);
		
		box.add(Box.createRigidArea(new Dimension(30, 30)));
		
		last = new IconButton("icon/last.png");
		box.add(last);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));
		
		playState = new IconButton("icon/pause.png");
		box.add(playState);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));
		
		next = new IconButton("icon/next.png");
		box.add(next);
		
		box.add(Box.createRigidArea(new Dimension(20, 30)));
		
		voiceImage = new IconButton("icon/voice.png");
		box.add(voiceImage);
				
		voiceCtrBar = new JSlider();
		voiceCtrBar.setMaximum(100);
		voiceCtrBar.setMinimum(0);
		voiceCtrBar.setPreferredSize(new Dimension(50, 30));
		voiceCtrBar.setBackground(new Color(0, 0, 0));

		box.add(voiceCtrBar);
		
		box.add(Box.createRigidArea(new Dimension(10, 30)));	
	}
	
	public IconButton getPlayMode(){
		return playMode;
	}
	
	public IconButton getLast(){
		return last;
	}
	
	public IconButton getPlayState(){
		return playState;
	}
	
	public IconButton getNext(){
		return next;
	}
		
	public JSlider getVoiceCtrBar(){
		return voiceCtrBar;
	}
}

class MySliderUI extends BasicSliderUI{  
    public MySliderUI(JSlider b) {  
        super(b);  
    }  

    public void paintThumb(Graphics g) {  
        Graphics2D g2d = (Graphics2D) g;  
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                RenderingHints.VALUE_ANTIALIAS_ON);  
        // 填充椭圆框为当前thumb位置  
        g2d.fillOval(thumbRect.x, thumbRect.y, thumbRect.width,  
                thumbRect.height);    
    }  
  
    public void paintTrack(Graphics g) {  
        int cy, cw;  
        Rectangle trackBounds = trackRect;  
        if (slider.getOrientation() == JSlider.HORIZONTAL) {  
            Graphics2D g2 = (Graphics2D) g;  
            cy = (trackBounds.height / 2) - 2;  
            cw = trackBounds.width;  
  
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                    RenderingHints.VALUE_ANTIALIAS_ON);  
            g2.translate(trackBounds.x, trackBounds.y + cy);  
  
            // 背景设为灰色  
            g2.setPaint(Color.GRAY);  
            g2.fillRect(0, -cy, cw, cy * 2);  
  
            int trackLeft = 0;  
  
            int trackRight = 0;  
  
            trackRight = trackRect.width - 1;  
  
            int middleOfThumb = 0;  
  
            int fillLeft = 0;  
  
            int fillRight = 0;  
  
            // 坐标换算  
            middleOfThumb = thumbRect.x + (thumbRect.width / 2);  
            middleOfThumb -= trackRect.x;  
  
            if (!drawInverted()) {  
                fillLeft = !slider.isEnabled() ? trackLeft : trackLeft + 1;  
                fillRight = middleOfThumb;  
            } else {  
                fillLeft = middleOfThumb;  
                fillRight = !slider.isEnabled() ? trackRight - 1  
                        : trackRight - 2;  
            }  
            // 设定渐变  
            g2.setPaint(new GradientPaint(0, 0, new Color(0, 100, 100), cw, 0,  
                    new Color(0, 255, 100), true));  
            g2.fillRect(0, -cy, fillRight - fillLeft, cy * 2);  
  
            g2.setPaint(slider.getBackground());  
            Polygon polygon = new Polygon();  
            polygon.addPoint(0, cy);  
            polygon.addPoint(0, -cy);  
            polygon.addPoint(cw, -cy);  
            g2.fillPolygon(polygon);  
            polygon.reset();  
  
            g2.setPaint(Color.WHITE);  
            g2.drawLine(0, cy, cw - 1, cy);  
  
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                    RenderingHints.VALUE_ANTIALIAS_OFF);  
            g2.translate(-trackBounds.x, -(trackBounds.y + cy));  
        } else {  
            super.paintTrack(g);  
        }  
    }  
}

package com.shibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tankFrame extends Frame{

	 int x=50,y=50;
	 Direction dir = Direction.DOWN;
	private static final int SPEED = 10;
	 
	public tankFrame() {
		setSize(800,600);
		setResizable(false);
		setTitle("坦克大战");
		setVisible(true);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//关闭窗口
			}
		});
	}
	
	@Override
		public void paint(Graphics g) {
		
		 g.fillRect(x,y,50,50);//坦克位置初始值
		 
		 switch(dir) {//判断方向
		 case LEFT:
			 x-=SPEED;
			 break;}
		 switch(dir) {
			  case RIGHT:
			  x+=SPEED;
		      break;}
		  switch(dir) {
			   case UP:
		     	 y-=SPEED;
				 break;}
		   switch(dir) {
				case DOWN:
				y+=SPEED;
				break;	 
		   }//根据方向移动坦克
		   	 }

	     class MyKeyListener extends KeyAdapter{
	    	 boolean bL = false;
	    	 boolean bU = false;
	    	 boolean bR = false;
	    	 boolean bD = false;
	    	 //用四个布尔值来表示被按下的是哪个键
	    	 

	    	 @Override			
	    	 public void keyPressed(KeyEvent e) {
	    		 int key = e.getKeyCode();
		    		switch (key) {//判断被按下的是哪个键
					case KeyEvent.VK_LEFT:
						bL = true;		 
						break;
	                case KeyEvent.VK_UP:
	                	bU = true;						
						break;
	                case KeyEvent.VK_RIGHT:
	                	bR = true;
	                	break;
	                case KeyEvent.VK_DOWN:
	                	bD = true;
	                	break;

					default:
						break;
					}
		    		setMainTankDir();
	    		//x+=10;
	    		//repaint();
			}//keyPressed 中文状态下不触发，只在英文状态下可以触发
	    	
			@Override
			public void keyReleased(KeyEvent e) {
		    		 int key = e.getKeyCode();
			    		switch (key) {//被按下的键恢复
						case KeyEvent.VK_LEFT:
							bL = false;		 
							break;
		                case KeyEvent.VK_UP:
		                	bU = false;						
							break;
		                case KeyEvent.VK_RIGHT:
		                	bR = false;
		                	break;
		                case KeyEvent.VK_DOWN:
		                	bD = false;
		                	break;

						default:
							break;
						}
		      setMainTankDir();
			
			}//keyReleased中文状态下仍然可以触发

			private void setMainTankDir() {
				if(bL) dir = Direction.LEFT;
				if(bR) dir = Direction.RIGHT;
				if(bU) dir = Direction.UP;
				if(bD) dir = Direction.DOWN;
				//按上下左右键改变坦克方向
			}
	    		 
	}

}
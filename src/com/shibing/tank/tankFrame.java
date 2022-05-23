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
		setTitle("̹�˴�ս");
		setVisible(true);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//�رմ���
			}
		});
	}
	
	@Override
		public void paint(Graphics g) {
		
		 g.fillRect(x,y,50,50);//̹��λ�ó�ʼֵ
		 
		 switch(dir) {//�жϷ���
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
		   }//���ݷ����ƶ�̹��
		   	 }

	     class MyKeyListener extends KeyAdapter{
	    	 boolean bL = false;
	    	 boolean bU = false;
	    	 boolean bR = false;
	    	 boolean bD = false;
	    	 //���ĸ�����ֵ����ʾ�����µ����ĸ���
	    	 

	    	 @Override			
	    	 public void keyPressed(KeyEvent e) {
	    		 int key = e.getKeyCode();
		    		switch (key) {//�жϱ����µ����ĸ���
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
			}//keyPressed ����״̬�²�������ֻ��Ӣ��״̬�¿��Դ���
	    	
			@Override
			public void keyReleased(KeyEvent e) {
		    		 int key = e.getKeyCode();
			    		switch (key) {//�����µļ��ָ�
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
			
			}//keyReleased����״̬����Ȼ���Դ���

			private void setMainTankDir() {
				if(bL) dir = Direction.LEFT;
				if(bR) dir = Direction.RIGHT;
				if(bU) dir = Direction.UP;
				if(bD) dir = Direction.DOWN;
				//���������Ҽ��ı�̹�˷���
			}
	    		 
	}

}
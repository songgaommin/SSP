package com.shibing.tank;



public class TK {

	public static void main(String[] args) throws InterruptedException {
		tankFrame tf = new tankFrame() ;//throws�������ǵ�sleep�����쳣��ʱ�����ǲ�����ֱ��������
		
		while(true) {
		  Thread.sleep(50);//ÿ��50����ˢ�´���
		  tf.repaint();//����repaint���������Զ�����paint
		}
	}
	
}

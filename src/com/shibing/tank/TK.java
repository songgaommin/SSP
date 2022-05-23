package com.shibing.tank;



public class TK {

	public static void main(String[] args) throws InterruptedException {
		tankFrame tf = new tankFrame() ;//throws的作用是当sleep出现异常的时候我们不处理，直接往外扔
		
		while(true) {
		  Thread.sleep(50);//每隔50毫秒刷新窗口
		  tf.repaint();//调用repaint方法，会自动调用paint
		}
	}
	
}

package site.metacoding.bubble.ex06;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	private int x, y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;
	private boolean isRun;
	
	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;
	
	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}
	
	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}
	
	public Player() {
		initObject();
		initSetting();
	}
	
	private void initObject() {
		playerR = new ImageIcon("image/playerR.png");
		playerL = new ImageIcon("image/playerL.png");
	}
	
	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent를 호출해줌.
		
		isRight = false;
		isLeft = false;
		isJump = false;
		isRun = false;
	}
	
	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽 이동");
		
		new Thread(() -> {
			while(isLeft) {
				x = x - SPEED;
				setLocation(x, y); // paintComponent를 호출해줌.
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void right() {
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		
		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // paintComponent를 호출해줌.
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	// 키보드 윗방향키
	public void jump() {
		isJump = true;
		System.out.println("점프");
		
		new Thread(() -> {
			for(int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // paintComponent를 호출해줌.
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("다운");
			
			new Thread(() -> {
				for(int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y + JUMPSPEED;
					setLocation(x, y); // paintComponent를 호출해줌.
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}).start();
	}
	
	
}
package site.metacoding.bubble.test;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

	private int x, y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;
	
	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;
	
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
		setLocation(x, y); // paintComponent�� ȣ������.
		
		isRight = false;
		isLeft = false;
		isJump = false;
	}
	
	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("���� �̵�");
		
		new Thread(() -> {
			while(isLeft) {
				x = x - SPEED;
				setLocation(x, y); // paintComponent�� ȣ������.
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
		System.out.println("������ �̵�");
		
		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // paintComponent�� ȣ������.
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	// Ű���� ������Ű
	public void jump() {
		isJump = true;
		System.out.println("����");
		
		new Thread(() -> {
			for(int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // paintComponent�� ȣ������.
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("�ٿ�");
			
			new Thread(() -> {
				for(int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y + JUMPSPEED;
					setLocation(x, y); // paintComponent�� ȣ������.
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
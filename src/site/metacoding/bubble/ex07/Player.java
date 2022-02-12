package site.metacoding.bubble.ex07;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ��ȣ
 * �÷��̾�� �¿� �̵��� �����ϴ�.
 * ������ �����ϴ�.
 * ��� �߻�(���߿� ��������)
 *
 */

public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	private boolean isRight;
	private boolean isLeft;
	private boolean up; // ���� ����(up, down)
	private boolean down;
	
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	private static final int JUMPSPEED = 2;
	private static final int SPEED = 4;
	
	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean isup) {
		this.up = isup;
	}
	
	public boolean isDown() {
		return down;
	}

	public void setDown(boolean isdown) {
		this.down = isdown;
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
		x = 90;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // paintComponent ȣ������
		
		isRight = false;
		isLeft = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
	}

	public void left() {
		isLeft = true;
		setIcon(playerL);
		System.out.println("���� �̵�");
		
		new Thread(()->{
			while(isLeft) {
				x = x - SPEED;
				setLocation(x, y); // paintComponent ȣ������
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
		
		new Thread(()->{
			while(isRight) {
				x = x + SPEED;
				setLocation(x, y); // paintComponent ȣ������
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		}).start();
	}
	
	// Ű���� ������Ű
	public void up() {
		System.out.println("����");
		up = true;
		// ������ for���� ������ �ǿ�. -> 0~130
		// up�� ���� sleep(5)
		new Thread(()->{
			for(int i = 0; i < 130/JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y); // paintComponent ȣ������
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			up=false;
			down();
		}).start();
	}
			// down�� ���� sleep(3)
			public void down() {
				System.out.println("�ٿ�");
				down = true;
				new Thread(()->{
					while(down) {
						y = y + JUMPSPEED;
						setLocation(x, y); // paintComponent ȣ������
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
					down = false;
		}).start();
	}
}
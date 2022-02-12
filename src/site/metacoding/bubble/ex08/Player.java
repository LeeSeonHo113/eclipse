package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author 선호
 *  플레이어는 좌우 이동이 가능하다.
 *  점프가 가능하다.
 *  방울 발사 (나중에 생각하자)
 */

public class Player extends JLabel{
	
	private BubbleFrame context;
	private int x;
	private int y;
	private ImageIcon playerR, playerL;
	
	private boolean isRight;
	private boolean isLeft;
	private boolean up; // 점프 상태 (up, down)
	private boolean down;
	
	private int direction; // -1 은 왼쪽 방향, 1은 오른쪽 방향, 0 방향 없음
	
	
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

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

	public Player(BubbleFrame context) {
		this.context = context;
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
		setLocation(x, y); // paintComponent 호출해줌
		
		isRight = false;
		isLeft = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
		
		direction = 0; // 방향 없음
	}
	
	public void attack() {
		// 1. 버블 new
		Bubble bubble = new Bubble(context);
		// 2. 화면에 붙여야 함 ? 
		context.add(bubble);
	    // 3. 수평이동 (플레이어 방향)
	}
	
	public void left() {
		direction = -1;
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽 이동");
		
		new Thread(()->{
			
			// 맵 색깔 확인 - 정지
			while(isLeft) {
				x = x - SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	public void right() {
		direction = 1;
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		
		new Thread(()->{
			
			// 맵 색깔 확인 - 정지
			while(isRight) {
				x = x + SPEED;
				setLocation(x, y);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void up() {
		System.out.println("업");
		up = true;		
		// 점프는 for문을 돌려야 되요.
		// up 일때는 sleep(5) -> for
		
		// 2초라면
		new Thread(()->{
			
			// 맵 색깔 확인 - 정지
			// up
			for (int i = 0; i < 130/JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			up = false;
			down();
		}).start();
		// down 일때는 sleep(3) -> for		
	}
	
	public void down() {
		System.out.println("다운");
		down = true;		
		// 점프는 for문을 돌려야 되요.
		// up 일때는 sleep(5) -> for
		
		// 2초라면
		new Thread(()->{	
			
			// 맵 색깔 확인 - 정지
			
			// down
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				
				try {
					Thread.sleep(3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();

		// down 일때는 sleep(3) -> for		
	}

}
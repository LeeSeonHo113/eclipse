package site.metacoding.bubble.ex05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 선호 
 * 목적 : 점프!!
 *
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;
	
	int count = 0;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // 내부에 paintComponent() 호출 코드가 있다.
	}

	// new 하는 것
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // 백그라운드 화면 설정

		player = new Player();		
		add(player);
	}

	// 각종 모든 세팅
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드 릴리즈");
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	// isRight를 false
					player.setRight(false);
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					// isLeft를 false
					player.setLeft(false);
				}
			}
			
			// 조이스틱
			@Override
			public void keyPressed(KeyEvent e) {
				// 왼쪽 37, 오른쪽 39, 위쪽 38, 아래쪽 40
			//	System.out.println("키보드 프레스 : " + e.getKeyCode());
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// 키보드를 누르고 있는 동안 right() 메서드를 한번만 실행하고 싶다.
					if(player.isRight() == false) {
						player.right();
					}
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					// 키보드를 누르고 있는 동안 left() 메서드를 한번만 실행하고 싶다.
					if(player.isLeft() == false) {
						player.left();
					}
				} else if(e.getKeyCode() == KeyEvent.VK_UP){
					// 키보드를 누르고 있는 동안 jump() 메서드를 한번만 실행하고 싶다.
					if(player.isJump() == false) {
						System.out.println("카운트 : " + count);
						count++;
						player.jump(); // 메서드 내부에서 if 분기 처리는 이벤트 루프에 등록은 되는데 실행이 안 되는 것
					}
					player.setJump(false);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
package site.metacoding.bubble.ex06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}
	
	// new�ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����
		
		player = new Player();
		add(player);
		
		// �׽�Ʈ
		
	}
	
	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM���� �����ϱ�
	}
	
	private void initListener() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Ű���� ������");
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// isRight�� false
					player.setRight(false);
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isLeft�� false
					player.setLeft(false);
				}
			}
			
			// ���̽�ƽ
			@Override
			public void keyPressed(KeyEvent e) {
				// ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					// Ű���带 ������ �ִ� ���� right() �޼��带 �� ���� �����ϰ� �ʹ�.
					if(player.isRight() == false) {
						player.right();
					}
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					// Ű���带 ������ �ִ� ���� left() �޼��带 �� ���� �����ϰ� �ʹ�.
					if(player.isLeft() == false) {
						player.left();
					}
				} else if(e.getKeyCode() == KeyEvent.VK_UP) {
					// Ű���带 ������ �ִ� ���� up() �޼��带 �� ���� �����ϰ� �ʹ�.
					if(player.isJump() == false) {
						player.jump();
					}
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
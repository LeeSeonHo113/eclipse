package site.metacoding.bubble.ex08;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author ��ȣ 
 * ���� : ���� �߻��ϱ�(�浹? �� ��) ����߻�!!
 *
 */

// main�� ���� Ŭ������ �ش� ���α׷��� ���ؽ�Ʈ(����)�� �� �˰� �ִ�.
public class BubbleFrame extends JFrame{

	private BubbleFrame context = this;
	private JLabel backgroundMap;
	private Player player;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService();
		setVisible(true); // ���ο� paintComponent() ȣ�� �ڵ尡 �ִ�.
	}
	
	private void initService() {
		new Thread(new BackgroundMapService(player)).start();
	}

	// new �ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel();
		backgroundMap.setIcon(new ImageIcon("image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����

		player = new Player(context);
		add(player);
	}

	// ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
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
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					// isLeft�� false
					player.setLeft(false);
				}
			}
			
			// ���̽�ƽ
			@Override
			public void keyPressed(KeyEvent e) {
				// ���� 37, ������ 39, ���� 38, �Ʒ��� 40
				//	System.out.println("Ű���� ������ : " + e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && player.isRightWallCrash() == false) {
					// Ű���带 ������ �ִ� ���� right() �޼��带 �ѹ��� �����ϰ� �ʹ�.
					if(player.isRight() == false) {
						player.right();
					}
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT && player.isLeftWallCrash() == false){
					// Ű���带 ������ �ִ� ���� left() �޼��带 �ѹ��� �����ϰ� �ʹ�.
					if(player.isLeft() == false) {
						player.left();
					}
				} else if(e.getKeyCode() == KeyEvent.VK_UP){
					// Ű���带 ������ �ִ� ���� jump() �޼��带 �ѹ��� �����ϰ� �ʹ�.
					if(player.isUp() == false && player.isDown() == false) {
						player.up(); // �޼��� ���ο��� if �б� ó���� �̺�Ʈ ������ ����� �Ǵµ� ������ �� �Ǵ� ��
					}
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.attack();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}
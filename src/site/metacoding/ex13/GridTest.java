package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridTest extends MyFrame{
public GridTest() {
	setTitle("GridLayoutTest");
	setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
	
	setLayout(new GridLayout(0, 3)); // 3���� ���� �ʿ��� ��ŭ�� ��
	
	add(new JButton("Button1"));
	add(new JButton("Button2"));
	add(new JButton("Button3"));
	add(new JButton("B4"));
	add(new JButton("Long Button5"));
	
	pack();
	setVisible(true);
}
	public static void main(String[] args) {
		new GridLayout();
	}

}

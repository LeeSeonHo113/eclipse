package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// ��׶��� ���� (�������� ������� ������ �Ѵ�)
public class BackgroundMapService {
   
   // ��������
   private Player player;
   private BufferedImage image;
   
   // ���������� ���� ��� => ������ ���� (�����ڸ� ���ؼ� ����) = DI (Dependency Injection)
   public BackgroundMapService(Player player) {
      this.player = player;
      try {
         image = ImageIO.read(new File("image/backgroundMapService.png"));
         System.out.println(image);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
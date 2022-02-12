package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

// 백그라운드 서비스 (독립적인 스레드로 돌려야 한다)
public class BackgroundMapService {
   
   // 컴포지션
   private Player player;
   private BufferedImage image;
   
   // 컴포지션을 위한 기술 => 의존성 주입 (생성자를 통해서 주입) = DI (Dependency Injection)
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
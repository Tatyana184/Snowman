import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Snowman extends JFrame {

    public void paint(Graphics g) {

       Graphics2D g2D = (Graphics2D) g;

       // контур туловища
        Area area = new Area(new Ellipse2D.Double(220,200,150,150));
        Area temp = new Area(new Ellipse2D.Double(200,300,200,200));
        Area temp2 = new Area(new Ellipse2D.Double(240,120,100,100));
        temp.subtract(area);
        area.subtract(temp2);
        g2D.draw(temp);
        g2D.draw(area);

        // шляпа
        Area hat = new Area(new RoundRectangle2D.Float(255,95,70,30,10,10));
        Area hat2 = new Area(new Ellipse2D.Double(240,120,100,15));
        g2D.drawLine(255,115,325,115);
        hat2.subtract(hat);
        area.subtract(hat2);
        g2D.draw(hat);
        g2D.draw(hat2);
        temp2.subtract(hat2);
        temp2.subtract(hat);
        g2D.draw(temp2);

        // глаза и пуговицы
        g2D.setColor(Color.BLACK);

        g2D.fillOval(275,160,10,10);
        g2D.fillOval(305,160,10,10);

        g2D.fillOval(300,250,10,10);
        g2D.fillOval(300,270,10,10);
        g2D.fillOval(300,290,10,10);

        // нос
        g2D.setColor(Color.ORANGE);
        int x[] = {300,300,330};
        int y[] = {175,185,180};
        g2D.fillPolygon(x,y,3);

        // рот
        g2D.setColor(Color.BLACK);
        QuadCurve2D line = new QuadCurve2D.Double(287,195,297,199,307,195);
        g2D.draw(line);

        // руки
        g2D.setColor(new Color(121,85,61));
        int x1[] = {450,350,345,445,455,460,457,475,477,460,470,465};
        int y1[] = {250,290,275,240,220,223,235,230,237,245,260,265};

        int x2[] = {150,250,255,155,145,140,143,125,123,140,130,135};
        int y2[] = {250,290,275,240,220,223,235,230,237,245,260,265};
        Area hand = new Area(new Polygon(x2,y2, x2.length));
        Area hand2 = new Area(new Polygon(x1,y1, x1.length));
        hand.subtract(area);
        hand2.subtract(area);
        g2D.fill(hand2);
        g2D.fill(hand);
    }
}

package drawrectangle;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author HauNguyen
 */
public class demoDrawRectangle extends JFrame{

    public demoDrawRectangle(String title){
       super(title);
       addControls();
       addEvents();
    }
    
    private void addControls(){
        Container con = getContentPane();
        // Nếu không sử dụng Panel thì khi chúng ta ẩn chương trình và khi show lên thì giao diện sẽ có nền đen
        // If interface don't use Panel,the interface will have black background when it was showed after it was hided 
        Panel pn = new Panel();
        pn.setLayout(new BorderLayout());
        pn.add(new component(), BorderLayout.CENTER);
        con.add(pn);
    }
    private void addEvents(){
    
    }
    class component extends JComponent{
            @Override
            public void paint(Graphics g) {
                draw(g);
            }

            private void draw(Graphics g){
                Graphics2D graphics2D = (Graphics2D) g;
                graphics2D.draw3DRect(10, 40, 460, 150, false);

        //      drawRect(int x, int y, int width, int height)
        //      BasicStroke(độ dày)

        //      AffineTransform affineTransform = new AffineTransform();
        //      affineTransform.setToRotation(-0.5);
        //      graphics2D.setTransform(affineTransform);
                graphics2D.setColor(Color.red);
                graphics2D.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 35));
                graphics2D.drawString("Hello world".toUpperCase(), 75, 120);

                Stroke stroke = new BasicStroke(5f);
                graphics2D.setColor(Color.red);
                graphics2D.setStroke(stroke);

                graphics2D.drawRect(30, 50, 420, 120);

                Stroke stroke1 = new BasicStroke(5f);
                graphics2D.setColor(Color.GREEN);
                graphics2D.setStroke(stroke1);
                graphics2D.draw(new Rectangle2D.Float(50, 65, 320, 90));

        //        dashingPattern2 = {độ rộng, khoảng cách viền};
                float[] dashingPattern1 = {5f, 1f};
                Stroke stroke2 = new BasicStroke(4f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 1, dashingPattern1, 0);
                graphics2D.setColor(Color.red);
                graphics2D.setStroke(stroke2);
                graphics2D.drawRect(55, 70, 310, 80);

                float[] dashingPattern2 = {5f,6f};
                Stroke stroke3 = new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashingPattern2, 0);
                graphics2D.setColor(Color.blue);
                graphics2D.setStroke(stroke3);
                graphics2D.drawRect(60, 75, 300, 75);

                float[] dashingPattern3 = {5f,1f};
                Stroke stroke4 = new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, dashingPattern3, 0);
                graphics2D.setColor(Color.GREEN);
                graphics2D.setStroke(stroke4);
                graphics2D.drawRoundRect(65, 80, 290, 60, 20, 20);
            }   
    }
    
    private void showWindow(){
        this.setSize(500, 400);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
//       Nguyên lý hoạt động của một ứng dụng đồ họa trong Swing có thể mô tả vắn tắt như sau:
//
//       1. Khi user tương tác với giao diện thì với mỗi sự kiện trên GUI (như click mouse, press key,...)
//sẽ có 1 AWTEvent  object được tạo ra và lưu vào trong 1 cấu trúc dữ liệu kiểu queue
//
//       2. Có 1 thread (chính xác hơn là 1 nhóm thread) chạy vòng lặp vô hạn để xử lý lần lượt các 
//AWTEvent trong queue. Thread này được gọi là Event-Dispatch thread và chỉ kết thúc khi tắt JVM hoặc đóng giao diện 
//
//       Nếu đã từng làm việc với JavaScript trên web thì sẽ thấy mô hình event-programming này rất quen thuộc.
//       Quay trở lại câu hỏi của bạn thì có thể hiểu đơn giản là method invokeLater() cho phép chạy đoạn 
//code trong hàm run của object Runnable trên Event-Dispatch thread. Điều này sẽ đảm bảo giao diện đồ họa 
//được hiển thị đầy đủ trước khi bất kì tương tác nào giữa người dùng với GUI được xử lý 
//(do cách xử lý tuần tự các AWT event bằng vòng lặp vô hạn).
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                demoDrawRectangle draw = new demoDrawRectangle("Draw rectangle");
                draw.showWindow();
            }
        });
        
    }
    
}

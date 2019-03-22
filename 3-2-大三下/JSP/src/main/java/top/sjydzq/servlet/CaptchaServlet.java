package top.sjydzq.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CaptchaServlet", urlPatterns = "/captcha")
public class CaptchaServlet extends HttpServlet {
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (fc < 0)
            fc = 0;
        if (bc > 255)
            bc = 255;
        if (bc < 0)
            bc = 0;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");

        ServletOutputStream out = response.getOutputStream();

        int width = 60;
        int height = 20;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g =img.createGraphics();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);

        Random r = new Random();

        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 100; i++) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            int xl = r.nextInt(12);
            int yl = r.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        // 产生随机线

        g.setColor(getRandColor(120, 240));
        for (int i = 0; i < 100; i++) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        // 产生随机点

        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        String captcha = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(r.nextInt(10));
            captcha += rand;
            g.setColor(new Color(20 + r.nextInt(110), 20 + r.nextInt(110),
                    20 + r.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        request.getSession().setAttribute("SESSION_CAPTCHA", captcha);

        ImageIO.write(img, "JPEG", out);
        out.close();
    }
}

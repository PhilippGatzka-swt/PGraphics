package net.internalerror.pgraphics.main;

import javax.swing.*;
import java.awt.*;

public class PApplication extends JFrame {
    public String applicationTitle;
    public int width;
    public int height;

    public PApplication(String applicationTitle, int width, int height){
        super(applicationTitle);
        this.applicationTitle = applicationTitle;
        this.width = width;
        this.height = height;

        setLayout(new BorderLayout());
        add(new PApplicationManager(width,height),BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

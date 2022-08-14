package com.hello;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.*;

public class FrameWin extends Frame implements
        WindowListener,
        ActionListener,
        MouseListener,
        MouseMotionListener{

//----------------------------------
//    Data Members:
//----------------------------------

    /**
     * The Graphics object used in the drawing.
     *
     * @see java.awt.Graphics
     */

    int x, y;
    ArrayList<Integer> alX = new ArrayList<>();
    ArrayList<Integer> alY = new ArrayList<>();
    static String DrawMode = "";
    Point FirstPoint = new Point (0,0);
    Point SecondPoint = new Point (0,0);
    Label lblModeDisplay;
    Checkbox chkDragMode;

    public FrameWin(String FrameTitle) {
        super(FrameTitle);
        setSize(1100, 900);
        setResizable(false);
        setBackground(Color.yellow);
        setLocation(100, 20);
        addWindowListener(this);

        Panel CommandPanel = new Panel(new GridLayout(20,1));
        CommandPanel.setBackground(new Color(240,240,240));

        Button btnDrawLine = new Button("Draw Line Primary Color BLACK");
        Button btnDrawRect = new Button("Draw Rectangle");
        Button btnFreehand = new Button("Draw Line Secondary Color");
        btnDrawLine.setActionCommand("LineD");
        btnDrawRect.setActionCommand("RectD");
        btnFreehand.setActionCommand("FreeH");
        btnDrawLine.addActionListener(this);
        btnDrawRect.addActionListener(this);
        btnFreehand.addActionListener(this);

        Label lblMode = new Label("Mode");
        lblModeDisplay = new Label();
        Font f1 = new Font ("Verdana", Font.PLAIN, 20);
        lblMode.setFont(f1);
        lblModeDisplay.setFont(f1);
        lblModeDisplay.setForeground(Color.BLUE);

        Label lblToexplainPolygonDrawing = new Label("DRAW POLINES WITH MOUSE CLICKS THEN EXIT SCREEN");
        CommandPanel.add(lblToexplainPolygonDrawing);
        Font font = new Font("Courier", Font.BOLD,12);
        lblToexplainPolygonDrawing.setFont(font);

        JButton  whiteButtonPrimaryColor = new JButton("CHOOSE PRIMARY COLOR");
        CommandPanel.add(whiteButtonPrimaryColor);

        whiteButtonPrimaryColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.white);
            }
        });

        JButton  pinkButtonPrimaryColor = new JButton("CHOOSE SECONDARY COLOR");
        CommandPanel.add(pinkButtonPrimaryColor);
        pinkButtonPrimaryColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.pink);
            }
        });

        JButton  ButtonShadingTypemagenta = new JButton("CHOOSE SHADING TYPE MAGENTA");
        CommandPanel.add(ButtonShadingTypemagenta);
        ButtonShadingTypemagenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.magenta);
            }
        });
        JButton  ButtonShadingTypeOrange = new JButton("CHOOSE SHADING TYPE ORANGE");
        CommandPanel.add(ButtonShadingTypeOrange);
        ButtonShadingTypeOrange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.orange);
            }
        });

        JButton  ButtonMouseMode = new JButton("CHOOSE MOUSE MODE");
        CommandPanel.add(ButtonMouseMode);
        ButtonMouseMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.GREEN);
            }
        });
        JButton  ButtonUndo = new JButton("UNDO");
        CommandPanel.add(ButtonUndo);
        ButtonUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setBackground(Color.WHITE);
            }
        });

        JButton  ButtonRedo = new JButton("REDO");
        CommandPanel.add(ButtonRedo);
        ButtonUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.WHITE);
            }
        });
        JButton  clearButton = new JButton("CLEAR");
        CommandPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.WHITE);
            }
        });
        JButton  ButtonCopy = new JButton("COPY");
        CommandPanel.add(ButtonCopy);
        ButtonCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.WHITE);
            }
        });
        JButton  ButtonPASTE = new JButton("PASTE");
        CommandPanel.add(ButtonPASTE);
        ButtonCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(Color.WHITE);
            }
        });
        JButton  ButtonEllipse = new JButton("DRAW ELLIPSE");
        CommandPanel.add(ButtonEllipse);
        ButtonEllipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        CommandPanel.add(ButtonEllipse);
        CommandPanel.add(ButtonPASTE);
        CommandPanel.add(ButtonCopy);
        CommandPanel.add(ButtonRedo);
        CommandPanel.add(ButtonUndo);
        CommandPanel.add(ButtonMouseMode);
        CommandPanel.add(btnDrawLine);
        CommandPanel.add(btnDrawRect);
        CommandPanel.add(btnFreehand);
        CommandPanel.add(ButtonShadingTypemagenta);
        CommandPanel.add(ButtonShadingTypeOrange);
        CommandPanel.add(whiteButtonPrimaryColor);
        CommandPanel.add(pinkButtonPrimaryColor);
        CommandPanel.add(lblMode);
        CommandPanel.add(lblModeDisplay);


        this.add(BorderLayout.EAST, CommandPanel);
        //Register with Mouse Listener
        addMouseListener(this);
        //Register Mouse Motion Listener
        addMouseMotionListener(this);
    }
        public static void main(String[] args ) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameWin(DrawMode).setVisible(true);

            }
        });

    }


    public void mouseDragged(MouseEvent e) {


    }
    public void mouseMoved(MouseEvent e) {

    }
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        alX.add(x);
        alY.add(y);

        Graphics g = getGraphics();
        g.fillRect(x-3,y-3,6,6);


    }
    public void mousePressed(MouseEvent e) {
        //  Set the First Point
        FirstPoint.setLocation(0, 0);
        SecondPoint.setLocation(0, 0);
        FirstPoint.setLocation(e.getX(), e.getY());
    }
    public void mouseReleased(MouseEvent e) {
        // Set Second Point
        //And Condition Introduction
        if (DrawMode.compareTo("FreeH") != 0) {
            SecondPoint.setLocation(e.getX(), e.getY());
        }
        repaint();
    }
    // Relocate Rectangle Starting Point
    public void GetTopLeft() {
        Point TopLeft = new Point();
        TopLeft.x = Math.min(FirstPoint.x, SecondPoint.x);
        TopLeft.y = Math.min(FirstPoint.y, SecondPoint.y);
        return;
    }
    public void mouseEntered(MouseEvent e) {//  Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent e) {
        int[] xArray = new int[alX.size()];
        int[] yArray = new int[alY.size()];
        for (int i=0; i<alX.size(); i++){
            xArray[i] = alX.get(i);
            yArray[i] = alY.get(i);
        }
        Graphics g2 = getGraphics();
        g2.drawPolyline(xArray,yArray, alX.size());

    }
    public void actionPerformed(ActionEvent e) {
        // Set the draw mode
        DrawMode = e.getActionCommand();
        lblModeDisplay.setText(DrawMode);
        FirstPoint.setLocation(0, 0);
        SecondPoint.setLocation(0, 0);
    }
    public void windowOpened(WindowEvent e) {

    }
    public void windowClosing(WindowEvent e) {

    }
    public void windowClosed(WindowEvent e) {

    }
    public void windowIconified(WindowEvent e) {

    }
    public void windowDeiconified(WindowEvent e) {

    }
    public void windowActivated(WindowEvent e) {

    }
    public void windowDeactivated(WindowEvent e) {

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (FirstPoint.equals(SecondPoint))
            return;
        switch(DrawMode) {
            case "LineD":
                //Draw Line with Primary Color
                g.drawLine(FirstPoint.x,
                        FirstPoint.y,
                        SecondPoint.x,
                        SecondPoint.y);

                break;
            case "FreeH":
                //Draw Line with Secondary Color
                g.setColor (Color.green);
                g.drawLine(FirstPoint.x,
                        FirstPoint.y,
                        SecondPoint.x,
                        SecondPoint.y);
                break;
            case "RectD":
                //Draw Rectangle
                int width = Math.abs(SecondPoint.x - FirstPoint.x);
                int height = Math.abs(SecondPoint.y - FirstPoint.y);
                g.drawRect(FirstPoint.x, FirstPoint.y, width, height);
                break;
        }
    }

}

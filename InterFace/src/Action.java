import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Action extends JPanel {
    private List<Design.Drawable> shapes;

    public Action(List<Design.Drawable> shapes) {
        this.shapes = shapes;

        JButton moveTriangleButton = new JButton("三角形を平行移動");
        moveTriangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Design.Drawable shape : shapes) {
                    if (shape instanceof Triangle) {
                        ((Design.ParallelMovable) shape).parallelMove(1, 1);
                    }
                }
                repaint();
            }
        });

        JButton roundTriangleButton = new JButton("三角形を回転移動");
        roundTriangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Design.Drawable shape : shapes) {
                    if (shape instanceof Triangle) {
                        ((Design.Movable) shape).rotate(45);
                    }
                }
                repaint();
            }
        });

        JButton moveRectangleButton = new JButton("四角形を平行移動");
        moveRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Design.Drawable shape : shapes) {
                    if (shape instanceof Rectangle) {
                        ((Design.ParallelMovable) shape).parallelMove(1, 1);
                    }
                }
                repaint();
            }
        });

        JButton roundRectangleButton = new JButton("四角形を回転移動");
        roundRectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Design.Drawable shape : shapes) {
                    if (shape instanceof Rectangle) {
                        ((Design.Movable) shape).rotate(45);
                    }
                }
                repaint();
            }
        });

        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(moveTriangleButton);
        buttonPanel.add(roundTriangleButton);
        buttonPanel.add(moveRectangleButton);
        buttonPanel.add(roundRectangleButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setShapes(List<Design.Drawable> shapes) {
        this.shapes = shapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Design.Drawable shape : shapes) {
            shape.draw(g);
        }
    }
}

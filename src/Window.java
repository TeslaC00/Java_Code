import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Window extends JFrame implements ActionListener{

    JButton button;

    Window(){
        
        Color sky = new Color(90,178,235);
        Color orange = new Color(0xFF9800);
        Color luffyRibbon = new Color(202,53,74);
        Color luffyHat = new Color(0xE6D596);

        ImageIcon icon = new ImageIcon("C:/Vikas/VS Code/Codes/Media/One_Piece_Icon.png");
        ImageIcon luffy = new ImageIcon("C:/Vikas/VS Code/Codes/Media/luffy-one-piece.png");

        Border bluBorder = BorderFactory.createLineBorder(orange,5);

        JLabel label = new JLabel();
        label.setText("Luffy");
        label.setIcon(luffy);
        label.setOpaque(true); // set opacity of label else background color not visible
        label.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT, RIGHT, CENTRE of image icon
        label.setVerticalTextPosition(JLabel.BOTTOM); // set text TOP, BOTTOM, CENTRE of image icon
        label.setHorizontalAlignment(JLabel.CENTER); // set image+text LEFT, RIGHT, CENTRE relative to label
        label.setVerticalAlignment(JLabel.CENTER); // set image+text TOP, BOTTOM, CENTRE relative to label
        label.setFont(new Font("ink free", Font.BOLD, 30)); // set label font
        label.setIconTextGap(5); // set gap between text and image icon
        label.setForeground(luffyRibbon);
        label.setBackground(luffyHat);
        label.setBorder(bluBorder);
        label.setBounds(320, 180, 640, 380); // set label in frame

        JLabel title = new JLabel();
        title.setText("One Piece");
        title.setFont(new Font("Monospaced", Font.ITALIC, 15));
        title.setForeground(Color.white);
        title.setVerticalTextPosition(0);
        title.setHorizontalTextPosition(0);

        button = new JButton("Button");
        button.setBounds(150,120,150,50);
        button.setForeground(Color.black);
        button.setLayout(null);
        button.setBackground(Color.white);
        button.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,100,100);
        panel.setLayout(new  BorderLayout());
        panel.setBackground(sky);
        panel.add(title);

        this.setVisible(true);
        this.setDefaultCloseOperation(3); // action on clicking 'X'
        this.setSize(1280,720);
        this.setTitle("One Piece");
        this.setLocationRelativeTo(null);  // location of window
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setLayout(null);
        this.add(label);
        this.add(panel);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==button){
            System.out.println("button pressed");
        }
    }
}

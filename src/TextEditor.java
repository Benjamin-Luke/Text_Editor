import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static javax.swing.ScrollPaneConstants.*;

public class TextEditor extends JFrame implements ActionListener{
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane =new JScrollPane(textArea);
    JSpinner fontSizeSpinner= new JSpinner();
    JLabel fontLabel= new JLabel("Font : ");
    JButton fontColourButton = new JButton("Colour");
    TextEditor(){
        //Physical Properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Text Editor");
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);


        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));

        //Adding everything
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
            }
        });
        fontColourButton.addActionListener(this);
        this.add(fontSizeSpinner);
        this.add(fontColourButton);
        this.add(scrollPane);
        this.add(fontLabel);
        this.setVisible(true);
        this.add(textArea);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource()==fontColourButton){
               JColorChooser colorChooser =new JColorChooser();

               Color color = colorChooser.showDialog(null,"Choose a color",Color.black)
                       textArea.setForeground(color);
           }
    }
}

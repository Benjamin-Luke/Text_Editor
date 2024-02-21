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
    JComboBox fontBox ;

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

        String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontBox  = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");


        this.add(fontSizeSpinner);
        this.add(fontColourButton);
        this.add(scrollPane);
        this.add(fontLabel);
        //  this.add(textArea);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource()==fontColourButton){
               JColorChooser colorChooser =new JColorChooser();

               Color color = colorChooser.showDialog(null,"Choose a color",Color.BLACK);
                       textArea.setForeground(color);
           }
    }
}

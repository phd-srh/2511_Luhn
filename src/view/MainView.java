package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainView extends JFrame implements KeyListener {

    private final static Color MYRED = new Color(192, 0, 0);
    private final JTextField nummerFeld;
    private final JButton generiereButton, prüfeButton,
        findeButton;

    public MainView() {
        setTitle("Luhn-Zahl");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout( new BorderLayout() );
        JPanel contentPanel = new JPanel();
        JPanel controlPanel = new JPanel();
        add(contentPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        contentPanel.setLayout( new GridLayout(1,1) );
        contentPanel.setBorder( new EmptyBorder(5,5,5,5) );
        nummerFeld = new JTextField();
        contentPanel.add(nummerFeld);
        nummerFeld.setFont( new Font(Font.SANS_SERIF, Font.BOLD, 24 ) );
        nummerFeld.addKeyListener( this );

        controlPanel.setLayout( new FlowLayout());
        generiereButton = new JButton("Generiere");
        prüfeButton = new JButton("Prüfe");
        findeButton = new JButton("Finde*");
        controlPanel.add(generiereButton);
        controlPanel.add(prüfeButton);
        controlPanel.add(findeButton);

        setVisible(true);
        pack();
    }

    public void setGeneriereButtonListener(ActionListener listener) {
        generiereButton.addActionListener(listener);
    }

    public void setPrüfeButtonListener(ActionListener listener) {
        prüfeButton.addActionListener(listener);
    }

    public void setFindeButtonListener(ActionListener listener) {
        findeButton.addActionListener(listener);
    }

    public String getNummer() {
        return nummerFeld.getText();
    }

    public void setNummer(String nummer) {
        nummerFeld.setText(nummer);
    }

    public void setValid(boolean status) {
        if (status) {
            nummerFeld.setForeground( Color.BLACK );
            nummerFeld.setBackground( Color.WHITE );
        }
        else
        {
            nummerFeld.setForeground( Color.WHITE );
            nummerFeld.setBackground( MYRED );
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        setValid(true);
    }

    @Override
    public void keyPressed(KeyEvent ignored) {}

    @Override
    public void keyReleased(KeyEvent ignored) {}
}

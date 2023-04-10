import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class TrojuhelnikForm extends JFrame {
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton aBCButton;
    private JButton lzeSestrojitButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel mainPanel;
    private JMenu menuFile;
    private JMenuBar menuBar;
    private JMenu menuAction;
    private JMenuItem chooseFile;
    private JMenuItem miOpenFile;
    private JMenuItem miNacti;
    private JMenuItem miUloz;

    private JMenuItem miKopiruj;

    private JMenuItem miLzeSestrojit;
    private JFileChooser fileChooserOpen = new JFileChooser(".");

    public TrojuhelnikForm() {
        initComponents();

        aBCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("15");
                textField2.setText("3");
                textField3.setText("2");
            }
        });
        lzeSestrojitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Ze stran délek A:15, B:3 a C:2 nelze sestrojit trojúhelník ");
            }
        });
    }



    public void initComponents() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("Soubor");

        menuBar.add(menuFile);

        menuAction = new JMenu("Akce");
        menuBar.add(menuAction);





        miOpenFile = new JMenuItem("Open...", KeyEvent.VK_O);
        menuFile.add(miOpenFile);
        miOpenFile.addActionListener(e -> openFile());

        miNacti = new JMenuItem("Načti ze souboru...");
        menuFile.add(miNacti);
        miNacti.addActionListener(e -> nacti());

        miUloz = new JMenuItem("Ulož do souboru...");
        menuFile.add(miUloz);
        miUloz.addActionListener(e -> uloz());

        miKopiruj = new JMenuItem("Kopíruj A do B i C");
        menuAction.add(miKopiruj);
        miKopiruj.addActionListener(e -> kopiruj());

        miLzeSestrojit = new JMenuItem("Lze sestroji trojúhelník?");
        menuAction.add(miLzeSestrojit);
        miLzeSestrojit.addActionListener(e -> lzeSestrojit());




    }

    public void kopiruj(){
        textField1.setText("15");
        textField2.setText("1");
        textField3.setText("1");
    }

    public void lzeSestrojit(){
        JOptionPane.showMessageDialog(null, "Ze stran délek A:15, B:3 a C:2 nelze sestrojit trojúhelník ");
    }

    public void uloz(){
        int vysledek = fileChooserOpen.showOpenDialog(this);
        if (vysledek == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserOpen.getSelectedFile();
            try {

                Reader reader = new FileReader(selectedFile);
                reader.read();



            } catch (IOException e) {
                throw new RuntimeException();
            }


        }

    }



    public void nacti() {
        int vysledek = fileChooserOpen.showOpenDialog(this);
        if (vysledek == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserOpen.getSelectedFile();
            try {

                Writer writer = new FileWriter(selectedFile);
                writer.append(textField3 + "\n");
                writer.append(textField1 + "\n");
                writer.append(textField2 + "\n");


            } catch (IOException e) {
                throw new RuntimeException();
            }


    }}

    public void openFile() {

            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this);





    }




    public static void main(String[] args) {
        TrojuhelnikForm frame = new TrojuhelnikForm();
        frame.pack();
        frame.setVisible(true);
    }


}




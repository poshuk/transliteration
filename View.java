
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener{
    private JPanel jPanel;
    private Controller controller;
    private JButton resultButton;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField resultField;
    private JButton clipboard;


    public View(){
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        this.getContentPane().add(jPanel);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e){
            System.out.println(e.toString());
        } catch (InstantiationException e){
            System.out.println(e.toString());
        }catch (IllegalAccessException e){
            System.out.println(e.toString());
        }catch (ClassNotFoundException e){
            System.out.println(e.toString());
        }
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void initMenuBar(){
        GridBagConstraints menuLine = new GridBagConstraints();

        menuLine.fill = GridBagConstraints.HORIZONTAL;
        menuLine.gridx = 0;
        menuLine.gridy = 0;

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Действия");
        JMenuItem menuItem = new JMenuItem("Результат");
        JMenuItem about = new JMenuItem("О программе...");

        menuItem.addActionListener(this);
        about.addActionListener(this);

        menu.add(menuItem);

        menuBar.add(menu);
        menuBar.add(about);
        jPanel.add(menuBar, menuLine);
        this.getContentPane().add(menuBar,BorderLayout.NORTH);

    }


    public void initTextField(){
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.gridx = 0;
        gbs.gridy = 0;
        gbs.anchor = GridBagConstraints.FIRST_LINE_START;
        gbs.insets = new Insets(0,0,10,40);


        JLabel label = new JLabel("Имя");
        jPanel.add(label, gbs);

        JLabel label1 = new JLabel("Фамилия");
        gbs.gridy++;
        jPanel.add(label1, gbs);

        JLabel empty = new JLabel();
        gbs.gridy ++;
        jPanel.add(empty, gbs);

        JLabel empty2 = new JLabel();
        gbs.gridy ++;
        jPanel.add(empty2, gbs);

        JLabel label2 = new JLabel("Результат");
        gbs.gridy ++;
        gbs.insets = new Insets(0,0,40,40);
        jPanel.add(label2, gbs);

        resultButton = new JButton("Выполнить");
        resultButton.addActionListener(this);
        gbs.gridy++;
        gbs.insets = new Insets(0,0,10,40);
        jPanel.add(resultButton, gbs);


        firstName = new JTextField(15);
        gbs.gridx = 1;
        gbs.gridy = 0;
        jPanel.add(firstName, gbs);

        lastName = new JTextField(15);
        gbs.gridy ++;
        jPanel.add(lastName, gbs);

        JLabel empty1 = new JLabel();
        gbs.gridy ++;
        jPanel.add(empty1, gbs);

        JLabel empty3 = new JLabel();
        gbs.gridy ++;
        jPanel.add(empty3, gbs);

        resultField = new JTextField(30);

        gbs.gridy ++;
        gbs.insets = new Insets(0,0,40,40);
        jPanel.add(resultField, gbs);

        clipboard = new JButton("Копировать в буфер");
        clipboard.addActionListener(this);
        clipboard.setEnabled(controller.isTranslate());
        gbs.gridy++;
        gbs.insets = new Insets(0,0,10,40);
        jPanel.add(clipboard, gbs);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Выполнить":
                controller.translate();
                clipboard.setEnabled(controller.isTranslate());
                break;
            case "Копировать в буфер":
                controller.copyToClipboard();
                break;
            case "О программе...":
                break;

        }
    }

    public Controller getController() {
        return controller;
    }

    public JButton getResultButton() {
        return resultButton;
    }

    public JTextField getFirstName() {
        return firstName;
    }

    public JTextField getLastName() {
        return lastName;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton getClipboard() {
        return clipboard;
    }
}

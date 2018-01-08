import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class About extends JFrame {

    public JPanel panelAbout = new JPanel();

    public About(){
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
        panelAbout.setLayout(new GridBagLayout());
        this.getContentPane().add(panelAbout);
        setText();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

    }

    private void setText(){
        GridBagConstraints information = new GridBagConstraints();
        information.gridx = 0;
        information.gridy = 0;
        information.insets = new Insets(10,20,10,20);


        JLabel info1 = new JLabel("Developed by Dmytro");
        panelAbout.add(info1, information);

        information.gridy = 1;
        JLabel info2 = new JLabel("Version 1.0");
        panelAbout.add(info2, information);

        String hostname = "";
        information.gridy = 2;
        try{
            hostname = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e){
            System.out.println("oops");
        }
        JLabel hostInfo = new JLabel();
        if (!hostname.equals("")){
            hostInfo.setText("Domain name: " + hostname);
        }
        panelAbout.add(hostInfo, information);
    }

}

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private View view;
    private static final Map<Character, String> firstEl = new HashMap<>();
    private static final Map<String, String> lastEl = new HashMap<>();

    public Controller(View view){
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        view.setSize(500,300);
        view.setIconImage(Toolkit.getDefaultToolkit().getImage("src/vidi.jpg"));
        view.initMenuBar();
        view.initTextField();
        view.setVisible(true);
    }

    static {
        firstEl.put('є', "ye");
        firstEl.put('ї', "yi");
        firstEl.put('й', "y");
        firstEl.put('ю', "yu");
        firstEl.put('я', "ya");

        lastEl.put("а", "a");
        lastEl.put("б", "b");
        lastEl.put("в", "v");
        lastEl.put("г", "h");
        lastEl.put("ґ", "g");
        lastEl.put("д", "d");
        lastEl.put("е", "e");
        lastEl.put("є", "ie");
        lastEl.put("ж", "zh");
        lastEl.put("з", "z");
        lastEl.put("и", "y");
        lastEl.put("і", "i");
        lastEl.put("ї", "i");
        lastEl.put("й", "i");
        lastEl.put("к", "k");
        lastEl.put("л", "l");
        lastEl.put("м", "m");
        lastEl.put("н", "n");
        lastEl.put("о", "o");
        lastEl.put("п", "p");
        lastEl.put("р", "r");
        lastEl.put("с", "s");
        lastEl.put("т", "t");
        lastEl.put("у", "u");
        lastEl.put("ф", "f");
        lastEl.put("х", "kh");
        lastEl.put("ц", "ts");
        lastEl.put("ч", "ch");
        lastEl.put("ш", "sh");
        lastEl.put("щ", "shch");
        lastEl.put("ю", "iu");
        lastEl.put("я", "ia");
    }

    public void translate(){
        String firstName = view.getFirstName().getText();
        String lastName = view.getLastName().getText();

        if (!view.getFirstName().getText().isEmpty() && !view.getLastName().getText().isEmpty()){
            if (firstName.matches(".*\\d+.*") && !lastName.matches(".*\\d+.*")){
                JOptionPane.showMessageDialog(view, "А зачем в имя цифры пихать?");
                view.getFirstName().setText("");
            } else if (!firstName.matches(".*\\d+.*") && lastName.matches(".*\\d+.*")){
                JOptionPane.showMessageDialog(view, "А зачем в фамилию цифры пихать?");
                view.getLastName().setText("");

            } else if (firstName.matches(".*\\d+.*") && lastName.matches(".*\\d+.*")){
                JOptionPane.showMessageDialog(view, "А зачем в имя и фамилию цифры пихать?");
                view.getLastName().setText("");
                view.getFirstName().setText("");
            } else {
                StringBuilder sbFirstName = new StringBuilder();
                StringBuilder sbLastName = new StringBuilder();
                String f = firstName.toLowerCase().replaceAll("\\p{Punct}*[ь]*", "");
                String l = lastName.toLowerCase().replaceAll("\\p{Punct}*[ь]*", "");
                String zghFirstName = f.replaceAll("зг", "zgh");
                String zghLastName = l.replaceAll("зг", "zgh");
                for (Character c : zghFirstName.toCharArray()) {
                    int i = 0;
                    if (i==0 && firstEl.containsKey(c)){
                        sbFirstName.append(firstEl.get(c));
                        i++;
                    }
                    i++;
                }
                //view.getResultField().setText(zghFirstName + "." + zghLastName);

            }


        } else if (!firstName.isEmpty() && lastName.isEmpty()){
            JOptionPane.showMessageDialog(view, "Пропустил фамилию");
        } else if (firstName.isEmpty() && !lastName.isEmpty()){
            JOptionPane.showMessageDialog(view, "Пропустил имя");
        } else if (firstName.isEmpty() && lastName.isEmpty()){
            JOptionPane.showMessageDialog(view, "А где же имя и фамилия?");
        }


    }


}

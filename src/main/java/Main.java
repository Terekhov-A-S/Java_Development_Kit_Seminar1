import javax.swing.*;

public class Main {

//    public static final String PATH_ICON = "src/main/resources/icon.png";
//    public ImageIcon icon = new ImageIcon(Main.class.getResource(PATH_ICON));

    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}

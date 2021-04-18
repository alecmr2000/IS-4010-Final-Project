import javax.swing.*;

class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
}
//Note: This looks very similar to Main.java in Lab 7.
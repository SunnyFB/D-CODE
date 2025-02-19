

public class Main
{
    public static void main(String[] args) {
        // JFrame frame = new JFrame("Game");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        // frame.setSize(size.width, size.height);
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // // Create a panel with a button
        // JPanel panel = new JPanel();
        // JButton meal = new JButton("Feed Meal");
        // JButton treat = new JButton("Feed Treat");
        // panel.add(meal);
        // panel.add(treat);

        // // Add action to the button
        // meal.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         JOptionPane.showMessageDialog(frame, "Button Clicked!");
        //     }
        // });

        // // Create another panel with text
        // JPanel textPanel = new JPanel();
        // JLabel label = new JLabel("Geeks Premier League 2023");
        // textPanel.add(label);

        // // Set layout for the main frame
        // frame.setLayout(new BorderLayout());
        // frame.add(panel, BorderLayout.CENTER);
        // frame.add(textPanel, BorderLayout.SOUTH);

        // frame.setVisible(true);
        Game game = new Game();
    }
}

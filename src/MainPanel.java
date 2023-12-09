import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static java.lang.System.currentTimeMillis;

public class MainPanel extends JPanel{
    final int WIDTH;
    final int HEIGHT;

    ArrayList<String> menuSet;
    BufferedImage screen;

    BufferedImage screen1;
    BufferedImage screen2;
    BufferedImage screen3;
    BufferedImage screen4;
    BufferedImage screen5;
    BufferedImage screen6;
    BufferedImage screen7;
    BufferedImage screen8;
    BufferedImage[] screenArray;

    String currentItem;

    double[] scoreList;
    HashMap<String, Double> scores;

    long startTime = 0;
    double elapsedTime = 0;
    public MainPanel(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        {
            try {
                screen1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenOne.png")));
                screen2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenTwo.png")));
                screen3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenThree.png")));
                screen4 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenFour.png")));
                screen5 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenFive.png")));
                screen6 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenSix.png")));
                screen7 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenSeven.png")));
                screen8 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("ScreenEight.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        screenArray = new BufferedImage[] {screen1, screen2, screen3, screen4, screen5, screen6, screen7, screen8};
        this.screen = screen1;

        this.menuSet = new ArrayList<>();
        fillMenuSet();
        this.check();

        scores = new HashMap<>();
        fillScores();
    }

    private void fillScores() {
        String[] menu = menuItems();
        scoreList = new double[]{3.221, 3.364, 2.074, 2.517, 2.769, 3.932, 1.825, 2.513, 2.581, 4.006, 2.526, 1.775,
                2.306, 2.285, 2.903, 2.751, 1.881, 1.938, 1.745, 1.529, 2.23, 2.25, 2.043, 1.395, 2.665, 2.472, 2.666,
                1.775, 1.651, 5.351, 2.666, 3.565, 2.493, 4.29, 1.639, 2.313, 1.736, 11.533, 4.744, 3.869, 2.343, 2.521,
                3.044, 6.588, 3.493, 2.313, 10.744, 6.055, 3.906, 3.001, 2.687, 2.922, 2.589, 4.031, 3.917, 2.879, 2.345,
                2.39, 2.911, 2.19, 4.816, 2.788, 3.039, 3.015, 3.47, 2.645, 2.938, 5.733, 8, 2.928, 2.806, 2.487,
                3.351, 2.794, 4.538, 3.081, 2.768, 5.718, 3.767, 2.639, 4.498, 5.181, 4.963, 3.842, 4.137, 2.546, 4.05};

        for (int i = 0; i < 87; i ++) {
            scores.put(menu[i], scoreList[i]);
        }
    }

    private String[] menuItems() {
        return new String[]{"Bacon Cheese Double", "Bacon Cheese Triple", "Bacon Cheese Single", "Loaded Steakhouse Double",
                "Loaded Steakhouse Triple", "Loaded Steakhouse Single", "Two Cheese Double", "Two Cheese Triple",
                "Two Cheese Single", "Mushroom Cheeseburger Double", "Mushroom Cheeseburger Triple",
                "Mushroom Cheeseburger Single", "Flamethrower Double", "Flamethrower Triple",
                "Flamethrower Single", "Original Cheeseburger Double", "Original Cheeseburger Triple",
                "Original Cheeseburger Single", "Crispy Chicken Sandwich", "Grilled Chicken Sandwich",
                "4-piece Chicken Strip Basket", "6-piece Chicken Strip Basket", "Poutine", "Fries",
                "Onion Rings", "Crispy Chicken Strips Salad Bowl", "Rotisserie-style Chicken Bites Salad Bowl",
                "Side Salad", "Super Snack: Fries", "Super Snack: Medium Drink",
                "Super Snack: Original Cheeseburger", "Super Snack: Small Sundae", "Super Snack: Chicken Wrap",
                "Super Snack: Medium Misty Slush", "Soft Pretzel Sticks", "Shake",
                "Fountain Drink", "6-piece (Regular) Rotisserie Chicken Basket",
                "8-piece (large) Rotisserie Chicken Basket", "3-piece Chicken Strip Meal", "Blizzard",
                "Mini Blizzard", "Royal Blizzard", "Misty Float", "Misty Freeze", "Shake", "Moo-latte",
                "Misty Slush", "Vanilla Kid Cone", "Vanilla Cone", "Dipped Cone", "Sundae", "Soft-serve Cup", "Banana Split",
                "Peanut Buster Parfait", "Dilly Bar", "Buster Bar", "6-pack Dilly Bar", "6-pack Buster Bar",
                "Non-dairy Dilly Bar", "6-pack Non-dairy Dilly Bar", "Treatzza Pizza",
                "Original Cheeseburger Meal", "Coupon Redeem", "Kids Meal", "Basket of Fries", "Banana",
                "Regular Rotisserie Chicken Bites", "Large Rotisserie Chicken Bites", "Milk", "Orange Juice",
                "Apple Juice", "Premium Fruit Smoothie", "Coffee", "Decaf Coffee", "Tea", "Orange Julius",
                "8-inch Blizzard Cake", "8-inch Cake", "10-inch Blizzard Cake", "10-inch Cake", "Sheet Cake",
                "Log Cake", "Fudge Bar", "6-pack Fudge Bar", "DQ Sandwich", "6-pack DQ Sandwich"};
    }

    private void fillMenuSet() {
        if (menuSet.isEmpty()) {
            menuSet.addAll(List.of(menuItems()));
        }
    }

    public void switchImage(int n) {
        this.screen = screenArray[n - 1];
        repaint();
    }

    private void printStuff() {
        System.out.println("Scores: ");
        for (String item : menuItems()) {
            System.out.print(item + ": ");
            System.out.print(scores.get(item));
            if (scores.get(item) > 4) {
                System.out.println("*** *** ***");
            } else {
                System.out.println();
            }
        }
        System.out.print("\nScore List (*UPDATE SCORE LIST*): \n{");
        for (String item : menuItems()) {
            System.out.print(scores.get(item));
            System.out.print(", ");
        }
        System.out.println("};");
    }

    public void check() {
        if (startTime != 0) {
            elapsedTime = (double) (currentTimeMillis() - startTime)/1000;
            if (elapsedTime < scores.get(currentItem) && elapsedTime > 0.5) {
                scores.replace(currentItem, elapsedTime);
                printStuff();
            }
        }
        // choose a new item
        if (menuSet.isEmpty()) {
            currentItem = "Done!";
            fillMenuSet();
        } else {
            int i = (int) (Math.random() * menuSet.size());
            currentItem = menuSet.get(i);
            menuSet.remove(i);
            startTime = currentTimeMillis();
        }
        // set default screen
        this.screen = screen1;
        // repaint
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // check box
        Rectangle2D.Double checkBox = new Rectangle2D.Double(0, 0, 50, 50);
        g2d.setColor(Color.GREEN);
        g2d.fill(checkBox);
        // text
        g2d.setFont(new Font("Monospaced", Font.BOLD, 40));
        g2d.setColor(Color.BLACK);
        g2d.drawString(currentItem, 55, 40);
        g2d.drawString(String.valueOf(elapsedTime), WIDTH - 150, 40);
        // image
        g2d.drawImage(screen, 0, 50, WIDTH, HEIGHT - 50, null);
    }
}

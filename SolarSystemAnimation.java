import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* 
 * The positions of the planets refer to the actual position around the sun.
 * This is why they all start at 0. As shown in the actionPerformed() method, 
 * you will notice that the planets move along their orbits based on how long 
 * it takes to revolve around the sun compared to Earth.
*/
public class SolarSystemAnimation extends JPanel implements ActionListener {
    // Window Information
    private static final int width = 1100;
    private static final int height = 800;
    private static final int xCenter = width / 2;
    private static final int yCenter = height / 2;
    JFrame frame;

    // Sun
    private static final int sunSize = 40;

    // Mercury
    private static final int mercurySize = 3;
    private static final int mercuryDistance = 30;
    private double mercuryLocation = 0;
    private int orbCountMer = 0;
    private Label mercuryLabel;

    // Venus
    private static final int venusSize = 5;
    private static final int venusDistance = 50;
    private double venusLocation = 0;
    private int orbCountVe = 0;
    private Label venusLabel;

    // Earth
    private static final int earthSize = 8;
    private static final int earthDistance = 80;
    private double earthLocation = 0;
    private int orbCountErt = 0;
    private Label earthLabel;

    // Mars
    private static final int marsSize = 7;
    private static final int marsDistance = 110;
    private double marsLocation = 0;
    private int orbCountMar = 0;
    private Label marsLabel;

    // Jupiter
    private static final int jupSize = 20;
    private static final int jupDistance = 180;
    private double jupLocation = 0;
    private int orbCountJup = 0;
    private Label jupLabel;

    // Saturn
    private static final int satSize = 18;
    private static final int satDistance = 220;
    private double satLocation = 0;
    private int orbCountSat = 0;
    private Label satLabel;

    // Uranus
    private static final int urSize = 15;
    private static final int urDistance = 260;
    private double urLocation = 0;
    private int orbCountUr = 0;
    private Label urLabel;

    // Neptune
    private static final int nepSize = 14;
    private static final int nepDistance = 300;
    private double nepLocation = 0;
    private int orbCountNep = 0;
    private Label nepLabel;

    // Timer for how often to update orbits
    public final Timer timer;
    private static final int delay = 10;  // milliseconds
    public int timeCount = 0;

    public SolarSystemAnimation(JFrame window) {
        this.frame = window;
        this.timer = new Timer(delay, this);
        timer.start();

        // Init labels
        this.mercuryLabel = new Label("Mercury: 0");
        this.mercuryLabel.setForeground(Color.WHITE);
        this.mercuryLabel.setBackground(Color.BLACK);
        this.mercuryLabel.setBounds(50, 150, 100, 50);
        this.frame.add(this.mercuryLabel);

        this.venusLabel = new Label("Venus: 0");
        this.venusLabel.setForeground(Color.WHITE);
        this.venusLabel.setBackground(Color.BLACK);
        this.venusLabel.setBounds(50, 200, 100, 50);
        this.frame.add(this.venusLabel);

        this.earthLabel = new Label("Earth: 0");
        this.earthLabel.setForeground(Color.WHITE);
        this.earthLabel.setBackground(Color.BLACK);
        this.earthLabel.setBounds(50, 250, 100, 50);
        this.frame.add(this.earthLabel);

        this.marsLabel = new Label("Mars: 0");
        this.marsLabel.setForeground(Color.WHITE);
        this.marsLabel.setBackground(Color.BLACK);
        this.marsLabel.setBounds(50, 300, 100, 50);
        this.frame.add(this.marsLabel);

        this.jupLabel = new Label("Jupiter: 0");
        this.jupLabel.setForeground(Color.WHITE);
        this.jupLabel.setBackground(Color.BLACK);
        this.jupLabel.setBounds(50, 350, 100, 50);
        this.frame.add(this.jupLabel);

        this.satLabel = new Label("Saturn: 0");
        this.satLabel.setForeground(Color.WHITE);
        this.satLabel.setBackground(Color.BLACK);
        this.satLabel.setBounds(50, 400, 100, 50);
        this.frame.add(this.satLabel);

        this.urLabel = new Label("Uranus: 0");
        this.urLabel.setForeground(Color.WHITE);
        this.urLabel.setBackground(Color.BLACK);
        this.urLabel.setBounds(50, 450, 100, 50);
        this.frame.add(this.urLabel);

        this.nepLabel = new Label("Neptune: 0");
        this.nepLabel.setForeground(Color.WHITE);
        this.nepLabel.setBackground(Color.BLACK);
        this.nepLabel.setBounds(50, 500, 100, 50);
        this.frame.add(this.nepLabel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        // Draw Sun
        g.setColor(Color.RED);
        g.fillOval(xCenter - sunSize / 2, yCenter - sunSize / 2, sunSize, sunSize);

        // Calculate and draw the orbit of Mercury
        int xCoor = (int) (xCenter + mercuryDistance * Math.cos(Math.toRadians(mercuryLocation)));
        int yCoor = (int) (yCenter + mercuryDistance * Math.sin(Math.toRadians(mercuryLocation)));
        g.setColor(Color.WHITE);
        g.fillOval(xCoor - mercurySize / 2, yCoor - mercurySize / 2, mercurySize, mercurySize);

        // Calculate and draw the orbit of Venus
        xCoor = (int) (xCenter + venusDistance * Math.cos(Math.toRadians(venusLocation)));
        yCoor = (int) (yCenter + venusDistance * Math.sin(Math.toRadians(venusLocation)));
        g.setColor(Color.ORANGE);
        g.fillOval(xCoor - venusSize / 2, yCoor - venusSize / 2, venusSize, venusSize);

        // Calculate and draw the orbit of Earth
        xCoor = (int) (xCenter + earthDistance * Math.cos(Math.toRadians(earthLocation)));
        yCoor = (int) (yCenter + earthDistance * Math.sin(Math.toRadians(earthLocation)));
        g.setColor(Color.BLUE);
        g.fillOval(xCoor - earthSize / 2, yCoor - earthSize / 2, earthSize, earthSize);

        // Calculate and draw the orbit of Mars
        xCoor = (int) (xCenter + marsDistance * Math.cos(Math.toRadians(marsLocation)));
        yCoor = (int) (yCenter + marsDistance * Math.sin(Math.toRadians(marsLocation)));
        g.setColor(Color.YELLOW);
        g.fillOval(xCoor - marsSize / 2, yCoor - marsSize / 2, marsSize, marsSize);

        // Calculate and draw the orbit of Jupiter
        xCoor = (int) (xCenter + jupDistance * Math.cos(Math.toRadians(jupLocation)));
        yCoor = (int) (yCenter + jupDistance * Math.sin(Math.toRadians(jupLocation)));
        g.setColor(Color.ORANGE);
        g.fillOval(xCoor - jupSize / 2, yCoor - jupSize / 2, jupSize, jupSize);

        // Calculate and draw the orbit of Saturn
        xCoor = (int) (xCenter + satDistance * Math.cos(Math.toRadians(satLocation)));
        yCoor = (int) (yCenter + satDistance * Math.sin(Math.toRadians(satLocation)));
        g.setColor(Color.YELLOW);
        g.fillOval(xCoor - satSize / 2, yCoor - satSize / 2, satSize, satSize);

        // Calculate and draw the orbit of Uranus
        xCoor = (int) (xCenter + urDistance * Math.cos(Math.toRadians(urLocation)));
        yCoor = (int) (yCenter + urDistance * Math.sin(Math.toRadians(urLocation)));
        g.setColor(Color.CYAN);
        g.fillOval(xCoor - urSize / 2, yCoor - urSize / 2, urSize, urSize);

        // Calculate and draw the orbit of Neptune
        xCoor = (int) (xCenter + nepDistance * Math.cos(Math.toRadians(nepLocation)));
        yCoor = (int) (yCenter + nepDistance * Math.sin(Math.toRadians(nepLocation)));
        g.setColor(Color.BLUE);
        g.fillOval(xCoor - nepSize / 2, yCoor - nepSize / 2, nepSize, nepSize);
    }

    public void actionPerformed(ActionEvent e) {
        // Adjust Orbits, check if the orbit is completed, and repaint
        this.mercuryLocation += 4.15;    // (365 / 88)
        this.isOrbitCompleted(this.mercuryLocation, "Mercury", this.orbCountMer, this.mercuryLocation);

        this.venusLocation += 1.43;      // (365/225)
        this.isOrbitCompleted(this.venusLocation, "Venus", this.orbCountVe, this.venusLocation);

        this.earthLocation += 1;         // 365 days
        this.isOrbitCompleted(this.earthLocation, "Earth", this.orbCountErt, this.earthLocation);

        this.marsLocation += 0.53;       // (365/687)
        this.isOrbitCompleted(this.marsLocation, "Mars", this.orbCountMar, this.marsLocation);

        this.jupLocation += 0.083;       // 12 years
        this.isOrbitCompleted(this.jupLocation, "Jupiter", this.orbCountJup, this.jupLocation);

        this.satLocation += 0.034;       // 29 years
        this.isOrbitCompleted(this.satLocation, "Saturn", this.orbCountSat, this.satLocation);

        this.urLocation += 0.012;        // 84 years
        this.isOrbitCompleted(this.urLocation, "Uranus", this.orbCountUr, this.urLocation);

        this.nepLocation += 0.006;       // 165 years
        this.isOrbitCompleted(this.nepLocation, "Neptune", this.orbCountNep, this.nepLocation);

        repaint();
    }

    private void isOrbitCompleted(double orbit, String planet, int completed, double position) {
        if (position > 365 * (completed + 1)) {
            switch(planet) {
                case "Mercury":
                    this.orbCountMer++;
                    this.updateLabel(this.mercuryLabel, "Mercury: " + this.orbCountMer);
                    return;
                case "Venus":
                    this.orbCountVe++;
                    this.updateLabel(this.venusLabel, "Venus: " + this.orbCountVe);
                    return;
                case "Earth":
                    this.orbCountErt++;
                    this.updateLabel(this.earthLabel, "Earth: " + this.orbCountErt);
                    return;
                case "Mars":
                    this.orbCountMar++;
                    this.updateLabel(this.marsLabel, "Mars: " + this.orbCountMar);
                    return;
                case "Jupiter":
                    this.orbCountJup++;
                    this.updateLabel(this.jupLabel, "Jupiter: " + this.orbCountJup);
                    return;
                case "Saturn":
                    this.orbCountSat++;
                    this.updateLabel(this.satLabel, "Saturn: " + this.orbCountSat);
                    return;
                case "Uranus":
                    this.orbCountUr++;
                    this.updateLabel(this.urLabel, "Uranus: " + this.orbCountUr);
                    return;
                case "Neptune":
                    this.orbCountNep++;
                    this.updateLabel(this.nepLabel, "Neptune: " + this.orbCountNep);
                    return;
                default:
                    return;
            }
        }
    }

    private void updateLabel(Label label, String message) {
        label.setText(message);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Animation");
        SolarSystemAnimation animation = new SolarSystemAnimation(frame);

        // Time since start
        Label timeLabel = new Label("Total Time: " + animation.timeCount + " seconds");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setBounds(width / 2 - 64, 40, 128, 50);

        Timer total = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                animation.timeCount++;
                timeLabel.setText("Total Time: " + animation.timeCount + " seconds");
            }
        });
        total.start();

        Label name = new Label("Solar System Animation");
        name.setForeground(Color.WHITE);
        name.setBackground(Color.BLACK);
        name.setBounds(width / 2 - 64, 2, 128, 50);

        // Orbits completed label
        Label orbits = new Label("Orbits Completed");
        orbits.setForeground(Color.WHITE);
        orbits.setBackground(Color.BLACK);
        orbits.setBounds(50, 100, 100, 50);

        // Orbits Labels

        // Create Button to stop the orbits
        Button time = new Button("Start/Stop Orbits");
        time.setBounds(50,50,100,40);    
        time.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (animation.timer.isRunning()) {
                    total.stop();
                    animation.timer.stop();
                    return;
                }
                total.start();
                animation.timer.start();
                
            }
        });

        frame.add(orbits);
        frame.add(name);
        frame.add(timeLabel);
        frame.add(time);
        frame.add(animation);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
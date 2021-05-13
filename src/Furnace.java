import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Furnace extends JPanel implements ActionListener {

    private BufferedImage img;

    private JButton activeButton = new JButton();
    private int activeIndex = -1;


    // buffered image holds image data
    private BufferedImage rawPorkChop;
    private BufferedImage cookedPorkChop;

    private BufferedImage rawCod;
    private BufferedImage cookedCod;

    private BufferedImage ironOre;
    private BufferedImage ironIngot;

    private BufferedImage goldOre;
    private BufferedImage goldIngot;

    private BufferedImage dababy;
    private BufferedImage dababyConvertable;


    private JButton outputLabel = new JButton();

    //Creates the buttons
    private JButton rawPorkChopButton;
    private JButton rawCodButton;
    private JButton ironOreButton;
    private JButton goldOreButton;
    private JButton dababyButton;

    // store button indexes with it's button assigned to it.
    private HashMap<Integer, JButton> buttons = new HashMap<>();

    // HERE I GIVE THE IMAGE GUYS THEIR FILE PATH AND JUNK                                                       AAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHH PAIN. CONSTANT PAIN.
    public Furnace() throws IOException {
        this.img = ImageIO.read(this.getClass().getResourceAsStream("/furnace.png"));
        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
        rawPorkChop = ImageIO.read(this.getClass().getResourceAsStream("/rawporkchop.png"));
        cookedPorkChop = ImageIO.read(this.getClass().getResourceAsStream("/cookedporkchop.png"));

        rawCod = ImageIO.read(this.getClass().getResourceAsStream("/rawcod.png"));
        cookedCod = ImageIO.read(this.getClass().getResourceAsStream("/cookedcod.png"));

        ironOre = ImageIO.read(this.getClass().getResourceAsStream("/ironore.png"));
        ironIngot = ImageIO.read(this.getClass().getResourceAsStream("/ironingot.png"));

        goldOre = ImageIO.read(this.getClass().getResourceAsStream("/goldore.png"));
        goldIngot = ImageIO.read(this.getClass().getResourceAsStream("/goldingot.png"));

        dababy = ImageIO.read(this.getClass().getResourceAsStream("/dababy.png"));
        dababyConvertable = ImageIO.read(this.getClass().getResourceAsStream("/dababyConvertable.jpg"));

        // NULL layout to avoid making a layout manager *LAYOUTS ARE FOR CHUMPS*
        setLayout(null);


        //START OF CREATING BUTTONS FOR EACH ITEM OR HIT RAPPER/ARTIST DA BABY

        //porkchop index #0 because we count starting by 0 for some awesome epic swag reason POGGERS XDDDDD :DDD  AAAA AA AA
        rawPorkChopButton = new JButton();
        rawPorkChopButton.setIcon(new ImageIcon(rawPorkChop));
        rawPorkChopButton.setBounds(16, 284, 32, 32);
        rawPorkChopButton.setBorder(null);
        rawPorkChopButton.setBackground(null);
        rawPorkChopButton.addActionListener(this);

        // store the button and its reference id.
        buttons.put(0, rawPorkChopButton);

        add(rawPorkChopButton);

        ///////////////////////////////////////////////////

        // cod index #1
        rawCodButton = new JButton();
        rawCodButton.setIcon(new ImageIcon(rawCod));
        // imgWidth * index
        rawCodButton.setBounds(16 + imgWidth + itemXOffset, 284, 32, 32);
        rawCodButton.setBorder(null);
        rawCodButton.setBackground(null);
        rawCodButton.addActionListener(this);


        buttons.put(1, rawCodButton);

        add(rawCodButton);

        ///////////////////////////////////////////////////////////////////

        // iron ore is index 2 !!!!!!!! YAY!!
        ironOreButton = new JButton();
        ironOreButton.setIcon(new ImageIcon(ironOre));
        ironOreButton.setBounds(16 + (imgWidth * 2) + (itemXOffset * 2), 284, 32, 32);
        ironOreButton.setBorder(null);
        ironOreButton.setBackground(null);
        ironOreButton.addActionListener(this);

        // store the button and its reference id.
        buttons.put(2, ironOreButton);

        add(ironOreButton);

        //////////////////////////////////////////////////////////////////

        // gold ore is index 3!!!!!!!
        goldOreButton = new JButton();
        goldOreButton.setIcon(new ImageIcon(goldOre));
        goldOreButton.setBounds(16 + (imgWidth * 3) + (itemXOffset * 3), 284, 32, 32);
        goldOreButton.setBorder(null);
        goldOreButton.setBackground(null);
        goldOreButton.addActionListener(this);

        // store the button and its reference id.
        buttons.put(3, goldOreButton);

        add(goldOreButton);

        //////////////////////////////////////////////////////////////////
        // HIT RAPPER AND ARTIST DABABY IS INDEX 4 WOW!!!! DABABY THE RAPPER FROM CLEVLAND OHIO :O
        dababyButton = new JButton();
        dababyButton.setIcon(new ImageIcon(dababy));
        dababyButton.setBounds(16 + (imgWidth * 7) + (itemXOffset * 7), 168, 32, 32);
        dababyButton.setBorder(null);
        dababyButton.setBackground(null);
        dababyButton.addActionListener(this);

        // store the button and its reference id.
        buttons.put(4, dababyButton);

        add(dababyButton);


        // create an active button to display the active item.
        activeButton.setVisible(false);
        activeButton.setBounds(113, 34, 32, 32);
        activeButton.addActionListener(this);
        add(activeButton);

        // create a label for the output product.
        outputLabel.setBounds(224, 64, 46, 47);
        outputLabel.setVisible(false);
        add(outputLabel);
    }

    //offset for how far the icons should be to the right for each item slot
    private final int itemXOffset = 5;
    private final int imgWidth = 31;



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        // furnace image background
        g2d.drawImage(img, 0, 0, this);
    }

    //index jawn DETERMINES what do for when button IS CLICKY CLICKY on image!!!
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton) {
            if(source == activeButton && activeIndex != -1) {
                if(activeIndex == 0) {
                    rawPorkChopButton.setVisible(true);
                    activeButton.setVisible(false);
                    activeIndex = -1;
                }
                if(activeIndex == 1) {
                    rawCodButton.setVisible(true);
                    activeButton.setVisible(false);
                    activeIndex = -1;
                }
                if(activeIndex == 2) {
                    ironOreButton.setVisible(true);
                    activeButton.setVisible(false);
                    activeIndex = -1;
                }
                if(activeIndex == 3) {
                    goldOreButton.setVisible(true);
                    activeButton.setVisible(false);
                    activeIndex = -1;
                }
                if(activeIndex == 4) {
                    dababyButton.setVisible(true);
                    activeButton.setVisible(false);
                    activeIndex = -1;
                }
                // activeIndex is the map index above

            }
            //Displays the cooked ITEM!!!!!! OR RAPPER!!!!                                  Got me singin' likeNa na na na everydayIt's like my iPod's stuck on replay

            if(source == rawPorkChopButton && activeButton != rawPorkChopButton) {
                activeButton.setIcon(rawPorkChopButton.getIcon());
                activeButton.setVisible(true);
                rawPorkChopButton.setVisible(false);
                outputLabel.setIcon(new ImageIcon(cookedPorkChop));
                outputLabel.setVisible(true);
                activeIndex = 0;
                System.out.println("setting");


            } else if(source == rawCodButton && activeButton != rawCodButton) {
                activeButton.setIcon(rawCodButton.getIcon());
                activeButton.setVisible(true);
                rawCodButton.setVisible(false);
                outputLabel.setIcon(new ImageIcon(cookedCod));
                outputLabel.setVisible(true);
                activeIndex = 1;

            } else if(source == ironOreButton && activeButton != ironOreButton) {
                activeButton.setIcon(ironOreButton.getIcon());
                activeButton.setVisible(true);
                ironOreButton.setVisible(false);
                outputLabel.setIcon(new ImageIcon(ironIngot));
                outputLabel.setVisible(true);
                activeIndex = 2;

            } else if(source == goldOreButton && activeButton != goldOreButton) {
                activeButton.setIcon(goldOreButton.getIcon());
                activeButton.setVisible(true);
                goldOreButton.setVisible(false);
                outputLabel.setIcon(new ImageIcon(goldIngot));
                outputLabel.setVisible(true);
                activeIndex = 3;

            } else if(source == dababyButton && activeButton != dababyButton) {
                activeButton.setIcon(dababyButton.getIcon());
                activeButton.setVisible(true);
                dababyButton.setVisible(false);
                outputLabel.setIcon(new ImageIcon(dababyConvertable));
                outputLabel.setVisible(true);
                activeIndex = 4;




            } else {
                activeButton.setVisible(false);
                activeIndex = -1;
                outputLabel.setIcon(null);
                outputLabel.setVisible(false);
            }
        }
    }
}

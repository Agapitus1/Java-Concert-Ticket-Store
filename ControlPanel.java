import model.*;
import javax.swing.*;
import java.awt.event.*;
public class ControlPanel extends JPanel
{   
    private Concert concert;
    private JButton bandButton = new JButton("Set Band");
    private JButton priceButton = new JButton("Set Prices");
    private JButton sellButton = new JButton("Sell");
    private JButton exitButton = new JButton("Exit");

    public ControlPanel(Concert concert)
    {   
        setup();
        build();
        this.concert=concert;
        setVisible(true);
    }

    public void setup()
    {
        bandButton.addActionListener(new BandListener(concert.band()));
        priceButton.addActionListener(new PriceListener(concert.stadium()));
        sellButton.addActionListener(new SaleListener(concert.stadium()));
        exitButton.addActionListener(new ExitListener());
    }

    public void build()
    {
        add(bandButton);
        add(priceButton);
        add(sellButton);
        add(exitButton);
    }

    public void update()
    {
    }
    //////inner class
    private class BandListener implements ActionListener
    {   
        private Band band;

        public BandListener(Band band)
        {   
            this.band = band;   
        }

        public void actionPerformed(ActionEvent e)
        {   
            new BandWindow(band);   
        }
    }
    //////inner class
    private class PriceListener implements ActionListener
    {   
        private Stadium stadium;

        public PriceListener(Stadium stadium)
        {   
            this.stadium = stadium;   
        }

        public void actionPerformed(ActionEvent e)
        {   
            new PriceWindow(stadium);   
        }
    }
    //////inner class
    private class SaleListener implements ActionListener
    {   
        private Stadium stadium;

        public SaleListener(Stadium stadium)
        {   
            this.stadium = stadium;   
        }

        public void actionPerformed(ActionEvent e)
        {   
            new SaleWindow(stadium);   
        }
    }
    ////inner class
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {   
            System.exit(0);
        }
    }
}


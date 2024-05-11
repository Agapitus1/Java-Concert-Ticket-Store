import model.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class DisplayPanel extends JPanel implements MyObserver
{   
    private Concert concert;
    private JLabel incomeLabel = new JLabel("Income $ ");
    private JTextField incomeField = new JTextField(10);
    private JLabel costLabel = new JLabel("Cost $ ");
    private JTextField costField = new JTextField(10);
    private JLabel profitLabel = new JLabel("Profit $ ");
    private JTextField profitField = new JTextField(10);
    public DisplayPanel(Concert concert)
    {   
        this.concert=concert;
        setup();
        build();
        setVisible(true);
    }

    public void setup()
    {
        concert.attach(this);
        concert.band().attach(this);
        concert.stadium().attach(this);
        Iterator<Seat>it = concert.stadium().seats().iterator();
        while(it.hasNext())
            it.next().attach(this);
    }

    public void build()
    {
        add(incomeLabel);
        add(incomeField);
        add(costLabel);
        add(costField);
        add(profitLabel);
        add(profitField);
    }

    public void update()
    {
        incomeField.setText(concert.income());
        costField.setText(concert.cost());
        profitField.setText(concert.profit());
    }
}


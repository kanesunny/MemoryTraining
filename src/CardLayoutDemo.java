/*
 * CardLayoutDemo.java
 *
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;
import java.util.Timer;

public class CardLayoutDemo implements ItemListener,ActionListener {
	JMenuBar jmb1;
	JMenu menu,menu1;
	JMenuItem original,random;
	//JLabel label,label1;
//	JTextField text;

	JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";

	Traverse t = new Traverse();
	HashMap<Integer,ImageIcon> hs = t.traverseFolder1("C:\\Users\\kane\\Documents\\110Poker");
	JLabel label = new JLabel(hs.get(0));

	JLabel label1= new JLabel();
	JLabel label2= new JLabel(hs.get(1));
	JLabel label3= new JLabel(hs.get(2));
	JLabel label4= new JLabel(hs.get(3));
	int i=1;
	Timer timer = new Timer();
	JTextField jf= new JTextField("",20);
	
	
	
    public void actionPerformed(ActionEvent e) {
    	long period=Integer.parseInt(jf.getText())*1000;
    	Cards cards = new Cards();
    //	System.out.print(cards.arrList);
    	final ArrayList<Integer> cardsList = cards.arrList;
   /// 	final ArrayList<Integer> cardsList = cards.Shuffle(cards.arrList);
 //   	CardsList cards = new CardsList();
  //  	cardsList=t.Shuffle(cards.getCards());
		timer.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int j,k,idx=cardsList.get(i);
		    	String s=String.valueOf(idx);
		    	
		    	if(idx==52) s="小王";
		    	else if(idx==53) s="大王";
		    	else {
		    	j=idx/13;
		    	k=idx%13+1;
		    	switch(j){
		    	case 0: s="黑桃";break;
		    	case 1: s="红桃";break;
		    	case 2: s="草花";break;
		    	case 3: s="方块";break;
		    	}
		    	if(k<11){
		    		s=s+k;
		    	}
		    	else if(k==11) s=s+"J";
		    	else if(k==12) s=s+"Q";
		    	else if(k==13) s=s+"K";
		    	
		    	}
		    	label1.setText(s);
		    	label2.setText(s);
		    	label3.setText(s);
		    	label4.setText(s);
				ImageIcon val = hs.get(idx);
				label.setIcon(val);
				val = hs.get(idx+1);
				label2.setIcon(val);
				val = hs.get(idx+2);
				label3.setIcon(val);
				val = hs.get(idx+3);
				label4.setIcon(val);

				//i++;
				i=i+4;

				if(i>=54) i=0;
			}
		}, 0, period);   	
}
     
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        JPanel card1 = new JPanel();
		card1.add(label);
		JButton button = new JButton("Start");
		card1.add(button);
		button.addActionListener(this);
		card1.add(label1);
		card1.add(label2);
		card1.add(label3);
		card1.add(label4);
		card1.add(jf);

         
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
    	try{

    	}catch(Exception ex){
    		System.out.println(ex);
    	}
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

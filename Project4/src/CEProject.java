import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class CEProject{

	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem item;
	private JFrame frame;
	private JPanel content, breadPanel, wingPanel, delivery, info, west, center, east, south;
	private JLabel north;
	private JRadioButton regular, thin, hand, deep;
	private ButtonGroup crust;
	private JCheckBox pepperoni, sausage, cheese, peppers, onion, mushroom, olive, anchovie;
	private JTextField bread, wings, name, address, city;
	
	public static void main(String[] args) {
		
		CEProject project = new CEProject();
		project.start();
	}
	
	public void start() {
		frame = new JFrame("GUI Pizza");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		makeMenu();
		makeContent();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void makeContent() {
		content = (JPanel)frame.getContentPane();
		content.setLayout(new BorderLayout(6, 6));
		
		north();
		south();
		east();
		west();
		center();
	}
	
	private void center() {
		center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setBorder(BorderFactory.createTitledBorder("Select Toppings"));
		
		pepperoni = new JCheckBox("Pepperoni", false);
		sausage = new JCheckBox("Sausage", false);
		cheese = new JCheckBox("Extra Cheese", false);
		peppers = new JCheckBox("Bell Peppers", false);
		onion = new JCheckBox("Onions", false);
		mushroom = new JCheckBox("Mushrooms", false);
		olive = new JCheckBox("Olives", false);
		anchovie = new JCheckBox("Anchovies", false);
		
		center.add(pepperoni);
		center.add(sausage);
		center.add(cheese);
		center.add(peppers);
		center.add(onion);
		center.add(mushroom);
		center.add(olive);
		center.add(anchovie);
		
		content.add(center, BorderLayout.CENTER);
	}

	private void west() {
		west = new JPanel();
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));
		
		crust = new ButtonGroup();
		
		regular = new JRadioButton("Regular Crust", true);
		thin = new JRadioButton("Thin Crust", false);
		hand = new JRadioButton("Hand-Tossed Crust", false);
		deep = new JRadioButton("Deep-Dish Crust", false);
		
		crust.add(regular);
		crust.add(thin);
		crust.add(hand);
		crust.add(deep);
		
		west.add(regular);
		west.add(thin);
		west.add(hand);
		west.add(deep);
		
		content.add(west, BorderLayout.WEST);
	}

	private void east() {
		east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		east.setBorder(BorderFactory.createTitledBorder("Sides (Enter Quantity)"));
		east.setPreferredSize(new Dimension(150, 0));
		
		breadPanel = new JPanel();
		breadPanel.setLayout(new BoxLayout(breadPanel, BoxLayout.X_AXIS));
		breadPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		bread = new JTextField("", 2);
		bread.setMaximumSize(new Dimension(20, 24));
		breadPanel.add(bread);
		breadPanel.add(new JLabel(" Bread Sticks"));
		
		wingPanel = new JPanel();
		wingPanel.setLayout(new BoxLayout(wingPanel, BoxLayout.X_AXIS));
		wingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		wings = new JTextField("", 2);
		wings.setMaximumSize(new Dimension(20, 24));
		wingPanel.add(wings);
		wingPanel.add(new JLabel(" Buffalo Wings"));
		
		east.add(breadPanel);
		east.add(wingPanel);
			
		content.add(east, BorderLayout.EAST);
	}

	private void south() {
		south = new JPanel();
		south.setLayout(new BoxLayout(south, BoxLayout.X_AXIS));
		south.setBorder(BorderFactory.createTitledBorder("Deliver To:"));
		
		delivery = new JPanel();
		delivery.setLayout(new BoxLayout(delivery, BoxLayout.Y_AXIS));
		
		delivery.add(new JLabel("Name: "));
		delivery.add(new JLabel("Address: "));
		delivery.add(new JLabel("City, State, Zip: "));
		
		
		info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		info.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		name = new JTextField();
		address = new JTextField();
		city = new JTextField();
		
		info.add(name);
		info.add(address);
		info.add(city);
		
		south.add(delivery);
		south.add(info);
		
		content.add(south, BorderLayout.SOUTH);
	}

	private void north() {
		north = new JLabel(new ImageIcon("pizza.jpg"), JLabel.CENTER);
		content.add(north, BorderLayout.NORTH);
	}

	public void makeMenu() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		//Set up menus
		menuBar.add(fileMenu());
		menuBar.add(helpMenu());
	}
	
	private JMenu helpMenu(){
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		
		item = new JMenuItem("About GUI Pizza");
		item.setMnemonic(KeyEvent.VK_I);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "GUI Pizza\n\nVersion 1.0\nBuild B20080226-1746\n\n(c) Copyright Merrill Hall 2008\nAll rights reserved\n\nVisit http://www.ed2go.com/\nEducation To Go\nIntermediate Java Course");
			}
		});
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
		menu.add(item);
		
		return menu;
	}
	
	private JMenu fileMenu() {
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		
		//New Order option
		item = new JMenuItem("New Order");
		item.setMnemonic(KeyEvent.VK_N);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Set regular crust to selected
				regular.setSelected(true);
				
				//Deselect all toppings
				pepperoni.setSelected(false);
				sausage.setSelected(false);
				cheese.setSelected(false);
				peppers.setSelected(false);
				onion.setSelected(false);
				mushroom.setSelected(false);
				olive.setSelected(false);
				anchovie.setSelected(false);
				
				//Set textfields to blanks
				bread.setText("");
				wings.setText("");
				name.setText("");
				address.setText("");
				city.setText("");
			}
		});
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
		menu.add(item);
		
		//Save Order option
		item = new JMenuItem("Save Order");
		item.setMnemonic(KeyEvent.VK_S);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String order = "Pizza Order\n\n" + "==========\n" + "Crust:\n";
				
				//Crust selection
				if(regular.isSelected()) {
					order += "     Regular\n";
				}else if(thin.isSelected()) {
					order += "     Thin\n";
				}else if(deep.isSelected()) {
					order += "     Deep-Dish\n";
				}else if(hand.isSelected()) {
					order += "     Hand-Tossed\n";
				}else {
					JOptionPane.showMessageDialog(frame, "You must select a type!", "Crust Type Error", JOptionPane.ERROR_MESSAGE);
				}
				
				//Toppings selection
				order += "Toppings:\n";
				
				if(pepperoni.isSelected()) {
					order += "     Pepperoni\n";
				}
				
				if(sausage.isSelected()) {
					order += "     Sausage\n";
				}
				
				if(cheese.isSelected()) {
					order += "     Extra Cheese\n";
				}
				
				if(peppers.isSelected()) {
					order += "     Peppers\n";
				}
				
				if(onion.isSelected()) {
					order += "     Onions\n";
				}
				
				if(mushroom.isSelected()) {
					order += "     Mushrooms\n";
				}
				
				if(olive.isSelected()) {
					order += "     Olives\n";
				}
				
				if(anchovie.isSelected()) {
					order += "     Anchovies\n";
				}
				
				//Sides
				int sticks = 0, bwings = 0;
				
				try {
					if(!bread.getText().isEmpty()) {
						sticks = Integer.parseInt(bread.getText());
					}
					
					if(!wings.getText().isEmpty()) {
						bwings = Integer.parseInt(wings.getText());
					}
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(frame,  "Side order entries must be numeric,\n" + "and must be whole numbers", "Side Order Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if(sticks > 0 || bwings > 0) {
					order += "Sides:\n";
					
					if(sticks > 0) {
						order += "     " + sticks + " Bread Sticks\n";
					}
					
					if(bwings > 0) {
						order += "     " + bwings + " Buffalo Wings\n";
					}
				}
				
				if(name.getText().isEmpty() || address.getText().isEmpty() || city.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Address fields may not be empty.", "Address Error", JOptionPane.ERROR_MESSAGE);
				}else {
					order += "Deliver To:\n";
					order += "     " + name.getText() + "\n";
					order += "     " + address.getText() + "\n";
					order += "     " + city.getText() + "\n";
				}
				
				order += "\n*** END OF ORDER ***\n";
				
				try {
					PrintStream out = new PrintStream("PizzaOrder.txt");
					out.print(order);
					out.close();
					
				}catch(IOException ioe) {
					System.out.println("\n*** I/O Error ***\n" + ioe);
				}
			}
		});
		
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		menu.add(item);
		
		//Exit
		item = new JMenuItem("Exit");
		item.setMnemonic(KeyEvent.VK_X);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
		menu.add(item);
		
		return menu;
	}
}



package asgn2GUIs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import asgn2Restaurant.PizzaRestaurant;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;

/**
 * This class is the graphical user interface for the rest of the system.
 * Currently it is a 'dummy' class which extends JFrame and implements Runnable
 * and ActionLister. It should contain an instance of an
 * asgn2Restaurant.PizzaRestaurant object which you can use to interact with the
 * rest of the system. You may choose to implement this class as you like,
 * including changing its class signature as long as it maintains its core
 * responsibility of acting as a GUI for the rest of the system. You can also
 * use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Joshua Wong and Ziyang Wang
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2392702569043011705L;

	private PizzaRestaurant restaurant;

	/**
	 * Creates a new Pizza GUI with the specified title
	 * 
	 * @param title
	 *            - The title for the supertype JFrame
	 */

	// Variables declaration - do not modify
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel controlPanel;

	private javax.swing.JLabel logFileLable;
	private javax.swing.JTextField logFileField;
	private javax.swing.JButton attachLogButton;
	private javax.swing.JButton displayLogButtion;
	private javax.swing.JButton resetButton;

	private javax.swing.JLabel totalDistanceLable;
	private javax.swing.JTextField totalDistanceField;
	private javax.swing.JButton displayTotalDisanceButton;

	private javax.swing.JLabel totalProfitLable;
	private javax.swing.JTextField totalProfitField;
	private javax.swing.JButton displayTotalProfitButton;

	private javax.swing.JScrollPane customerScrollPane;
	private javax.swing.JTable customerTable;
	JFileChooser chooser = new JFileChooser(new File("logs"));

	private javax.swing.JScrollPane pizzaScrollPane;
	private javax.swing.JTable pizzaTable;
	// End of variables declaration

	public PizzaGUI(String title) {
		super(title);
		restaurant = new PizzaRestaurant();
		creatGUI();
	}

	private void creatGUI() {

		mainPanel = new javax.swing.JPanel();
		controlPanel = new javax.swing.JPanel();

		logFileLable = new javax.swing.JLabel();
		logFileField = new javax.swing.JTextField();
		attachLogButton = new javax.swing.JButton();
		displayLogButtion = new javax.swing.JButton();
		resetButton = new javax.swing.JButton();

		totalProfitLable = new javax.swing.JLabel();
		totalProfitField = new javax.swing.JTextField();
		displayTotalProfitButton = new javax.swing.JButton();

		totalDistanceLable = new javax.swing.JLabel();
		totalDistanceField = new javax.swing.JTextField();
		displayTotalDisanceButton = new javax.swing.JButton();

		customerScrollPane = new javax.swing.JScrollPane();
		customerTable = new javax.swing.JTable();

		pizzaScrollPane = new javax.swing.JScrollPane();
		pizzaTable = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Load and reset Field Part
		// ****************************************************************************************************
		mainPanel.setBackground(new java.awt.Color(0, 0, 0));
		mainPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		controlPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		logFileLable.setText("Choose Log File");

		attachLogButton.setText("Attach");
		attachLogButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				attachLogButtonActionPerformed(evt);
			}
		});

		displayLogButtion.setText("Display");
		displayLogButtion.setEnabled(false);
		displayLogButtion.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				displayLogButtionActionPerformed(evt);
			}
		});

		resetButton.setText("Reset");
		resetButton.setEnabled(false);
		resetButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resetButtonActionPerformed(evt);
			}
		});

		totalProfitLable.setText("Total Profit");

		displayTotalProfitButton.setText("Display");
		displayTotalProfitButton.setEnabled(false);
		displayTotalProfitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				displayTotalProfitButtonActionPerformed(evt);
			}
		});

		totalDistanceLable.setText("Total Distance");

		displayTotalDisanceButton.setText("Display");
		displayTotalDisanceButton.setEnabled(false);
		displayTotalDisanceButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				displayTotalDisanceButtonActionPerformed(evt);
			}
		});

		customerScrollPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		customerTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Customer Name", "Mobile Number", "Customer Type", "X and Y Location",
				"Distance from Restaurant" }));
		customerScrollPane.setViewportView(customerTable);

		pizzaScrollPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		pizzaTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit" }));
		pizzaScrollPane.setViewportView(pizzaTable);

		// ControlPanel set part
		// ****************************************************************************************************
		javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
		controlPanel.setLayout(controlPanelLayout);
		controlPanelLayout
				.setHorizontalGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(controlPanelLayout.createSequentialGroup().addContainerGap()
								.addGroup(controlPanelLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(logFileLable, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(logFileField)
										.addComponent(attachLogButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(displayLogButtion, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(displayTotalProfitButton, javax.swing.GroupLayout.PREFERRED_SIZE,
												120, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(displayTotalDisanceButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(totalDistanceField)
										.addComponent(totalDistanceLable, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(totalProfitField)
										.addComponent(totalProfitLable, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		controlPanelLayout
				.setVerticalGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(controlPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(logFileLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(logFileField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(attachLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(displayLogButtion, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(resetButton)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(totalProfitLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(totalProfitField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(displayTotalProfitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(totalDistanceLable, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(totalDistanceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(displayTotalDisanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		// mainPanel part set
		// ****************************************************************************************************
		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
								.addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(customerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE,
														832, Short.MAX_VALUE)
												.addComponent(pizzaScrollPane))
								.addContainerGap()));
		mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
						.addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(mainPanelLayout.createSequentialGroup()
										.addComponent(customerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 266,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pizzaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 263,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(mainPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	// GUI control part
	// *********************************************************************************************************

	private void attachLogButtonActionPerformed(java.awt.event.ActionEvent evt) {
		attachLogButton.setEnabled(false);
		resetButton.setEnabled(true);
		displayLogButtion.setEnabled(true);
		chooser.showOpenDialog(null);
		File f = chooser.getSelectedFile();
		String filename = f.getAbsolutePath();
		logFileField.setText(filename);
	}

	private void displayLogButtionActionPerformed(java.awt.event.ActionEvent evt) {
		displayLogButtion.setEnabled(false);
		displayTotalDisanceButton.setEnabled(true);
		displayTotalProfitButton.setEnabled(true);

		DefaultTableModel customerModel = (DefaultTableModel) customerTable.getModel();
		DefaultTableModel pizzaModel = (DefaultTableModel) pizzaTable.getModel();

		try {
			restaurant.processLog(String.valueOf(logFileField.getText()));

			for (int index = 0; index < restaurant.getNumCustomerOrders(); index++) {
				Object customerData[] = new Object[5];
				customerData[0] = restaurant.getCustomerByIndex(index).getName();
				customerData[1] = restaurant.getCustomerByIndex(index).getMobileNumber();
				customerData[2] = restaurant.getCustomerByIndex(index).getCustomerType();
				customerData[3] = restaurant.getCustomerByIndex(index).getLocationX() + " , "
						+ restaurant.getCustomerByIndex(index).getLocationY();
				customerData[4] = restaurant.getCustomerByIndex(index).getDeliveryDistance();
				customerModel.addRow(customerData);
			}

			for (int index = 0; index < restaurant.getNumPizzaOrders(); index++) {
				Object pizzaData[] = new Object[5];
				pizzaData[0] = restaurant.getPizzaByIndex(index).getPizzaType();
				pizzaData[1] = restaurant.getPizzaByIndex(index).getQuantity();
				pizzaData[2] = restaurant.getPizzaByIndex(index).getOrderPrice();
				pizzaData[3] = restaurant.getPizzaByIndex(index).getOrderCost();
				pizzaData[4] = restaurant.getPizzaByIndex(index).getOrderProfit();
				pizzaModel.addRow(pizzaData);
			}

		} catch (CustomerException | PizzaException | LogHandlerException e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {
		customerTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] {
				"Customer Name", "Mobile Number", "Customer Type", "X and Y Location", "Distance from Restaurant" }));
		pizzaTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit" }));
		controlPanel.add(attachLogButton);
		controlPanel.add(displayLogButtion);
		controlPanel.add(displayTotalDisanceButton);
		controlPanel.add(displayTotalProfitButton);
		logFileField.setText(null);
		totalDistanceField.setText(null);
		totalProfitField.setText(null);
		attachLogButton.setEnabled(true);
		resetButton.setEnabled(false);
		displayTotalProfitButton.setEnabled(false);
		displayTotalDisanceButton.setEnabled(false);
		restaurant.resetDetails();
	}

	private void displayTotalProfitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		displayTotalProfitButton.setEnabled(false);
		try {
			restaurant.processLog(String.valueOf(logFileField.getText()));
			totalProfitField.setText(String.valueOf(restaurant.getTotalProfit()));
		} catch (CustomerException | PizzaException | LogHandlerException e) {
			JOptionPane.showMessageDialog(null, e);
			totalProfitField.setText(null);
		}
	}

	private void displayTotalDisanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
		displayTotalDisanceButton.setEnabled(false);
		try {
			restaurant.processLog(String.valueOf(logFileField.getText()));
			totalDistanceField.setText(String.valueOf(restaurant.getTotalDeliveryDistance()));
		} catch (CustomerException | PizzaException | LogHandlerException e) {
			JOptionPane.showMessageDialog(null, e);
			totalDistanceField.setText(null);
		}
	}

	@Override
	public void run() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PizzaGUI("Pizza Place").setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}

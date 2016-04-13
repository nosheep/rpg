package com.nosheep.network;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class Register extends JFrame {
	
	private static final long serialVersionUID = -5484637492926405859L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	public Register() {
		JFrame frame = this;
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Register");
		
		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.inactiveCaptionBorder);
		
		JLabel lblEmail = new JLabel("E-mail");
		
		JLabel lblPassword = new JLabel("Password");
		
		JLabel lblUsername = new JLabel("Username");
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.inactiveCaptionBorder);
		textField_1.setColumns(10);
		
		JLabel lblTryingToRegister = new JLabel("Trying to register..");
		lblTryingToRegister.setVisible(false);
		JButton btnCancel = new JButton("Cancel");
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(SystemColor.inactiveCaption);
		btnRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText() == null || passwordField.getPassword() == null || textField_1.getText() == null){
					JOptionPane.showMessageDialog(null, "Please enter all fields.");
				}
				else{
					btnRegister.setVisible(false);
					btnCancel.setVisible(false);
					lblTryingToRegister.setVisible(true);
					Database db = new Database();
					if(db.register(textField.getText(), passwordField.getPassword(), textField_1.getText())){
						frame.dispose();
						JOptionPane.showMessageDialog(null, "Success! Login and play!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Something went wrong! Please try again!");
						lblTryingToRegister.setVisible(false);
						btnRegister.setVisible(true);
						btnCancel.setVisible(true);
					}
				}
			}
		});

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBackground(SystemColor.inactiveCaption);
		btnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(textField_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addComponent(lblUsername)
						.addComponent(lblPassword)
						.addComponent(lblEmail)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCancel)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(lblTryingToRegister)
							.addGap(18)
							.addComponent(btnRegister)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnRegister)
							.addComponent(lblTryingToRegister))
						.addComponent(btnCancel))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		requestFocus();
	}
}

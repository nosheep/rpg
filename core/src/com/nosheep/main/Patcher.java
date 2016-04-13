package com.nosheep.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Patcher extends JFrame {

	private static final long serialVersionUID = -4642935109726528650L;

	public JProgressBar progressBar = new JProgressBar();
	
	public Patcher() {
		getContentPane().setBackground(new Color(128, 128, 128));
	
		JLabel lblCheckingForUpdates = new JLabel("Checking for updates..");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCheckingForUpdates)
						.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
					.addContainerGap())
		);
		progressBar.setIndeterminate(true);
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 11));
		progressBar.setStringPainted(true);
		progressBar.setBackground(new Color(0, 0, 0));
		progressBar.setForeground(new Color(255, 140, 0));
		progressBar.setMaximum(10000);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCheckingForUpdates)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 99);
		setResizable(false);
		setTitle("Patcher");
		setFocusable(true);
		setVisible(true);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		requestFocus();
	}
}

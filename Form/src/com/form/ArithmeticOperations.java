package com.form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ArithmeticOperations {
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Frame");
		jframe.setSize(550,400);

		jframe.setLayout(null);
		
		JLabel jlabel = new JLabel("First Number:");
		jlabel.setBounds(10,10,100,30);
		jframe.add(jlabel);
		
		JTextField jtext = new JTextField();
		jtext.setBounds(120,10,100,30);
		jframe.add(jtext);
		
		JLabel jlabel2 = new JLabel("Second Number:");
		jlabel2.setBounds(10,70,100,30);
		jframe.add(jlabel2);
		
		JTextField jtext2 = new JTextField();
		jtext2.setBounds(120,70,100,30);
		jframe.add(jtext2);
		
		JLabel jlabel3 = new JLabel("Results:");
		jlabel3.setBounds(10,120,100,30);
		jframe.add(jlabel3);
		
		JTextField jtext3 = new JTextField();
		jtext3.setBounds(120,120,100,30);
		jtext3.setEditable(false);
		jframe.add(jtext3);
		
		JTextField jtext4 = new JTextField();
		jtext4.setBounds(220,120,100,30);
		jtext4.setEditable(false);
		jframe.add(jtext4);
		
		JTextField jtext5 = new JTextField();
		jtext5.setBounds(320,120,100,30);
		jtext5.setEditable(false);
		jframe.add(jtext5);
		
		JTextField jtext6 = new JTextField();
		jtext6.setBounds(420,120,100,30);
		jtext6.setEditable(false);
		jframe.add(jtext6);
		
		JButton jbutton = new JButton("Calculate");
		jbutton.setBounds(10,160,100,30);
		jframe.add(jbutton);
		
		JButton jbutton2 = new JButton("Clear");
		jbutton2.setBounds(120,160,100,30);
		jframe.add(jbutton2);
		
		
		ActionListener actionlistener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			System.out.println("Calculate button clicked");
			String number1 = jtext.getText();
			String number2 = jtext2.getText();
			
			int a = Integer.parseInt(number1);
			int b = Integer.parseInt(number2);
			int c= a+b;
			int d= a*b;
			int g= a/b;
			int f = a-b;
			
			String result1 = String.valueOf(c);
			String result2 = String.valueOf(d);
			String result3 = String.valueOf(g);
			String result4 = String.valueOf(f);
			
			jtext3.setText(result1);
			jtext4.setText(result2);
			jtext5.setText(result3);
			jtext6.setText(result4);
				
			}
		};
		jbutton.addActionListener(actionlistener);
		
		ActionListener action2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clear button clicked");
				jtext3.setText(null);
				jtext4.setText(null);
				jtext5.setText(null);
				jtext6.setText(null);
				jtext2.setText(null);
				jtext.setText(null);
			}
		};
		jbutton2.addActionListener(action2);
		jframe.setVisible(true);
	}

}


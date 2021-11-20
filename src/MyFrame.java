import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.*; //actionlistener
import java.text.DecimalFormat;

public class MyFrame implements ActionListener{
	JFrame frame = new JFrame();
	JPanel p1 = new JPanel();
	Border border3 = p1.getBorder();
	Border margin3 = new EmptyBorder(0,15,15,15);
	JLabel instruction1 = new JLabel("Numri i Sferave per ngjyre:", SwingConstants.CENTER);
	
	ImageIcon picIcon1 = new ImageIcon("s1s.png");
	JLabel picLabel1 = new JLabel(picIcon1);
	ImageIcon picIcon2 = new ImageIcon("s2s.png");
	JLabel picLabel2 = new JLabel(picIcon2);
	ImageIcon picIcon3 = new ImageIcon("s3s.png");
	JLabel picLabel3 = new JLabel(picIcon3);

	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	
	JSpinner redTotalNr = new JSpinner();
	JSpinner blueTotalNr = new JSpinner();
	JSpinner greenTotalNr = new JSpinner();
	
	JPanel p4 = new JPanel();
//	JLabel instruction2 = new JLabel("Perzgjidh dy sfera", SwingConstants.CENTER);
////	Border border1 = p4.getBorder();
////	Border margin1 = new EmptyBorder(-20, -20, -20, -20);
	
	JRadioButton ans1 = new JRadioButton("Merr te Kuqe");
	JRadioButton ans2 = new JRadioButton("Merr Blue");
	JRadioButton ans3 = new JRadioButton("Merr Jeshile");
	JButton meRrPaKBtn = new JButton("Me Rradhe Pa Kthim");
	JButton paRradheBtn = new JButton("Pa Rradhe");
	JButton meRrMeKBtn = new JButton("Me Rradhe Me Kthim");
	
	JPanel p5 = new JPanel();
	JButton calculateBtn = new JButton("Logarit");
	JLabel resultJLabel = new JLabel("Probabiliteti: ", SwingConstants.CENTER);
	JLabel warningJLabel = new JLabel("", SwingConstants.CENTER);
	Border border = calculateBtn.getBorder();
	Border margin = new EmptyBorder(0, 38, 0 , 38);
	boolean way1 = false;
	boolean way2 = false;
	boolean way3 = false;
	
	float totalNr = 0;
	float result = 0;
	DecimalFormat df = new DecimalFormat();
	float c1 = 1;
	float c2 = 1;
	float c3 = 1;
	
	MyFrame() {
		p1.setLayout(new BorderLayout(20, 10));
		p1.add(instruction1, BorderLayout.NORTH);
		instruction1.setFont(new Font("Nirmala UI Semilight",Font.BOLD, 18));
		
		p2.setLayout(new GridLayout(3, 1, 10, 10));
		p1.add(p2, BorderLayout.CENTER);
		
		p3.setLayout(new GridLayout(1, 3, 10, 10));	
		p3.add(picLabel1);
		p3.add(picLabel2);
		p3.add(picLabel3);
		p2.add(p3);
		
		redTotalNr.setValue(1);
		blueTotalNr.setValue(1);
		greenTotalNr.setValue(1);
		
//		redTotalNr.setBorder(new CompoundBorder(border, margin));
//		blueTotalNr.setBorder(new CompoundBorder(border, margin));
//		greenTotalNr.setBorder(new CompoundBorder(border, margin));
		
		p4.setLayout(new GridLayout(3, 3, 10, 10));
		p4.add(redTotalNr);
		p4.add(blueTotalNr);
		p4.add(greenTotalNr);
		p2.add(p4);
		
		p4.add(ans1);
		p4.add(ans2);
		p4.add(ans3);
		ans1.addActionListener(this);
		ans2.addActionListener(this);
		ans3.addActionListener(this);

		
		p4.add(meRrMeKBtn);
		p4.add(meRrPaKBtn);
		p4.add(paRradheBtn);
		meRrMeKBtn.addActionListener(this);
		meRrPaKBtn.addActionListener(this);
		paRradheBtn.addActionListener(this);
		
		p5.setLayout (new FlowLayout(FlowLayout.LEFT, 0, 10));
		p5.add(calculateBtn);
		p5.add(resultJLabel);
		p5.add(warningJLabel);
		calculateBtn.addActionListener(this);
		calculateBtn.setBorder(new CompoundBorder(border, margin));
		resultJLabel.setBorder(new CompoundBorder(border, margin));
		warningJLabel.setBorder(new CompoundBorder(border, margin));
		warningJLabel.setForeground(Color.RED);
    	p2.add(p5, BorderLayout.SOUTH);
		
		
		//p1.setBorder(new CompoundBorder(border3, margin3));
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		frame.add(p1);
		frame.setTitle("Llogarites Probabiliteti");
		frame.setSize(600, 520);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.setResizable(false); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		df.setMaximumFractionDigits(4);
		if (e.getSource() == meRrMeKBtn) {
			way2 = false;
			way3 = false;
			way1 = true;
			meRrMeKBtn.setBackground(Color.ORANGE);
			meRrPaKBtn.setBackground(null);
			paRradheBtn.setBackground(null);
		}
		else if (e.getSource() == meRrPaKBtn) {
			way2 = true;
			way1 = false;
			way3 = false;
			meRrPaKBtn.setBackground(Color.ORANGE);
			meRrMeKBtn.setBackground(null);
			paRradheBtn.setBackground(null);
		}
		else if (e.getSource() == paRradheBtn) {
			way3 = true;
			way2 = false;
			way1 = false;
			paRradheBtn.setBackground(Color.ORANGE);
			meRrMeKBtn.setBackground(null);
			meRrPaKBtn.setBackground(null);
		}
		

		if (e.getSource() == calculateBtn) {
			Object strRed = redTotalNr.getValue();
			String valRedStr = strRed.toString();
			int valRed = Integer.parseInt(valRedStr);
			Object strBlue = blueTotalNr.getValue();
			String valBlueStr = strBlue.toString();
			int valBlue = Integer.parseInt(valBlueStr);
			Object strGreen = greenTotalNr.getValue();
			String valGreenStr = strGreen.toString();
			int valGreen = Integer.parseInt(valGreenStr);
			
			if (valRed < 1 || valBlue < 1 || valGreen < 1) {
				warningJLabel.setText("Nr i Sferave > 0!!");
			}
			else if (!ans1.isSelected() && !ans2.isSelected() && !ans3.isSelected()) {
				warningJLabel.setText("Merr 2 Sfera!");
			}
			else if (ans1.isSelected() && ans2.isSelected() && ans3.isSelected()) {
				warningJLabel.setText("Merr vetem 2!");
			}
			else if ((ans1.isSelected() && !ans2.isSelected() && !ans3.isSelected()) 
					|| (!ans1.isSelected() && ans2.isSelected() && !ans3.isSelected())
					|| (!ans1.isSelected() && !ans2.isSelected() && ans3.isSelected())) {
				warningJLabel.setText("Merr 2 Sfera!");
			}
			else if (!way1 && !way2 && !way3) {
				warningJLabel.setText("Zgjidh menyren!");
			}
			else {
				warningJLabel.setText("");
				totalNr = valRed + valBlue + valGreen;
				
				if (way1) {
					if (ans1.isSelected() && ans2.isSelected()) {
						result = (valRed/totalNr) * (valBlue/totalNr); 
					}
					else if (ans2.isSelected() && ans3.isSelected()) {
						result = (valBlue/totalNr) * (valGreen/totalNr);
					}
					else if (ans1.isSelected() && ans3.isSelected()) {
						result = (valRed/totalNr) * (valGreen/totalNr);
					}
				}
				else if (way2) {
					if (ans1.isSelected() && ans2.isSelected()) {
						result = (valRed/totalNr) * (valBlue/(totalNr - 1)); 
					}
					else if (ans2.isSelected() && ans3.isSelected()) {
						result = (valBlue/totalNr) * (valGreen/(totalNr - 1));
					}
					else if (ans1.isSelected() && ans3.isSelected()) {
						result = (valRed/totalNr) * (valGreen/(totalNr - 1));
					}
				}
				else if (way3) {
					if (ans1.isSelected() && ans2.isSelected()) {
						c1 = valRed;
						c2 = valBlue;
					}
					else if (ans2.isSelected() && ans3.isSelected()) {
						c1 = valBlue;
						c2 = valGreen;
					}
					else if (ans1.isSelected() && ans3.isSelected()) {
						c1 = valRed;
						c2 = valGreen;
					}
					c3 = fact(totalNr)/(fact(2) * fact(totalNr-2));
					System.out.println(c1 + " " + c2 + " " + c3);
					result = (c1*c2)/c3;
				}
				System.out.println(valRed + " " + valBlue + " " + valGreen + " " + totalNr);
				resultJLabel.setText("Probabiliteti: " + df.format(result));
			}
			
		}
	}
	
	public float fact(float nr) {
		float s = 1;
		for (int i = 1; i <= nr; i++) {
			s *= i;
		}
		return s;
	}
}

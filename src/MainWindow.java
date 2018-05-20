/*
Base64 a base64 encoder/decoder
Copyright (C) 2017-2018 Davide Sestili

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea outputArea;

	public MainWindow()
	{
		super("Base64");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(3, 1));
		
		JTextArea inputArea = new JTextArea();
		getContentPane().add(inputArea);
		
		JPanel panel = new JPanel();
		JButton encodeButton = new JButton("Encode");
		encodeButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						byte[] encBytes = Base64.getEncoder().encode(inputArea.getText().getBytes());
						outputArea.setText(new String(encBytes));
					}
				});
		panel.add(encodeButton);
		JButton decodeButton = new JButton("Decode");
		decodeButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						byte[] decBytes = Base64.getDecoder().decode(inputArea.getText());
						outputArea.setText(new String(decBytes));
					}
				});
		panel.add(decodeButton);
		getContentPane().add(panel);
		
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		getContentPane().add(outputArea);
		
		setSize(1024, 768);
	}
	
	public static void main(String[] args) 
	{
		new MainWindow().setVisible(true);
	}

}

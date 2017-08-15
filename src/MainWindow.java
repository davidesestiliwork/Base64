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

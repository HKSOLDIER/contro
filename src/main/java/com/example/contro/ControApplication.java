package com.example.contro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class ControApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ControApplication.class, args);
//	}
//
//}
import javax.swing.*;
		import java.awt.*;
		import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SpringBootApplication
public class ControApplication extends JFrame {

	private JTextField searchField;
	private JPanel bubblePanel;
	private ArrayList<String> items;

	public ControApplication() {
		setTitle("Bubble Search App");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Initialize items
		items = new ArrayList<>();
		items.add("Apple");
		items.add("Banana");
		items.add("Cherry");
		items.add("Date");
		items.add("Elderberry");
		items.add("Fig");
		items.add("Grape");

		// Search bar
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(200, 30));

		// Search button
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchItems();
			}
		});

		// Panel to hold search components
		JPanel searchPanel = new JPanel();
		searchPanel.add(searchField);
		searchPanel.add(searchButton);

		// Bubble panel
		bubblePanel = new JPanel();
		bubblePanel.setLayout(new FlowLayout());

		// Add components to frame
		add(searchPanel, BorderLayout.NORTH);
		add(new JScrollPane(bubblePanel), BorderLayout.CENTER);

		// Initial display
		displayBubbles(items);
	}

	private void searchItems() {
		String query = searchField.getText().toLowerCase();
		ArrayList<String> filteredItems = new ArrayList<>();

		for (String item : items) {
			if (item.toLowerCase().contains(query)) {
				filteredItems.add(item);
			}
		}

		displayBubbles(filteredItems);
	}

	private void displayBubbles(ArrayList<String> itemsToShow) {
		bubblePanel.removeAll();

		for (String item : itemsToShow) {
			JButton bubble = new JButton(item);
			bubble.setMargin(new Insets(5, 10, 5, 10));
			bubblePanel.add(bubble);
		}

		bubblePanel.revalidate();
		bubblePanel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ControApplication().setVisible(true);
			}
		});
	}
}


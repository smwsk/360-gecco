package cn.succy.geccospider.engine;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cn.succy.geccospider.pipeline.TitlePipeline;

public class MainSplider extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField page;
	public static JTextField size;
	public static Integer count;
	private JLabel tip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSplider frame = new MainSplider();
					frame.setVisible(true);
					//frame.setIconImage((new ImageIcon("image/spilder.png").getImage()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainSplider() {
		setTitle("360\u70ED\u641C\u6392\u884C\u699C\u722C\u866B");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 195);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("\u9875\u6570:");
		label.setBounds(10, 90, 40, 15);
		panel.add(label);

		page = new JTextField();
		page.setText("1");
		page.setBounds(60, 87, 86, 21);
		panel.add(page);
		page.setColumns(10);

		size = new JTextField();
		size.setText("10");
		size.setBounds(210, 87, 95, 21);
		panel.add(size);
		size.setColumns(10);

		JLabel label_1 = new JLabel("\u6761\u6570:");
		label_1.setBounds(160, 90, 40, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("360\u70ED\u641C\u6392\u884C\u699C\u722C\u866B");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(50, 10, 348, 43);
		panel.add(label_2);

		JButton button = new JButton("\u5F00\u59CB\u722C\u866B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						tip.setText("爬取中.....");
						new Splider().StartSplider();
						tip.setText("爬取完毕");
					}
				}).start();
				;
			}
		});
		button.setBounds(331, 86, 93, 23);
		panel.add(button);

		tip = new JLabel("\u8FD0\u884C\u63D0\u793A");
		tip.setFont(new Font("宋体", Font.PLAIN, 12));
		tip.setHorizontalAlignment(SwingConstants.CENTER);
		tip.setBounds(34, 145, 364, 27);
		panel.add(tip);
	}
}

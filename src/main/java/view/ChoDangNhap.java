package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;

import constant.ColorConstants;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ChoDangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lblStatus;

	public ChoDangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 80);
		setUndecorated(true); // Loại bỏ thanh tiêu đề và nút điều khiển
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(ColorConstants.PRIMARY_COLOR);
		panel.setPreferredSize(new Dimension(0, 80));
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));
		contentPane.add(panel);
		panel.setLayout(null);

		progressBar = new JProgressBar(0, 100);
		progressBar.setBounds(10, 45, 580, 25);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		panel.add(progressBar);

		lblStatus = new JLabel("Đang khởi tạo...");
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(10, 10, 300, 25);
		panel.add(lblStatus);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}
}

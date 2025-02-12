package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;

public class Test1 extends JFrame {
	public Test1() {
		setTitle("Biểu đồ cột thống kê");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Tạo dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(10, "Doanh thu", "Tháng 1");
		dataset.addValue(15, "Doanh thu", "Tháng 2");
		dataset.addValue(20, "Doanh thu", "Tháng 3");

		// Tạo biểu đồ
		JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu", // Tiêu đề biểu đồ
				"Tháng", // Nhãn trục X
				"Doanh thu (triệu)", // Nhãn trục Y
				dataset);

		// Đưa biểu đồ vào panel
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(780, 570));
		setContentPane(chartPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Test1 example = new Test1();
			example.setVisible(true);
		});
	}
}

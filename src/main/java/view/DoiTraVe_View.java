package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import constant.ColorConstants;

import javax.swing.table.DefaultTableCellRenderer;

import other.DangerPrimaryButton;
import other.PrimaryButton;
import java.awt.event.ActionEvent;

public class DoiTraVe_View extends View {
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private JTextField txtMaVeTau;
	private JTable danhSachVeTable;
	private PrimaryButton timKiemButton;
	private PrimaryButton btn_TraVe;
	private JRadioButton rdbtnMaVeTau, rdbtnSDT;
	private ButtonGroup buttonGroup;
	private PrimaryButton lamMoiButton;
	private PrimaryButton btn_DoiVe;
	private JTextField txtSDT;
	private JTextField txtLocDanhSach;
	private PrimaryButton btnLocTheoDanhSach;
	private JLabel lbl_TongVeMotChieu;
	private JLabel lbl_TongSoVeDoiTra;
	private JLabel lbl_TongSoVe;
	private JComboBox<String> comboBoxLocDs;
	private DefaultTableModel tableModel;
	private JLabel lbl_TongVeKhuHoi;

	// Thêm sự kiện cho lớp hoàn tiền view
	public void addSuKien(ActionListener listener, MouseListener mouseListener) {
		rdbtnMaVeTau.addActionListener(listener);
		rdbtnSDT.addActionListener(listener);
		timKiemButton.addActionListener(listener);
		btn_TraVe.addActionListener(listener);
		lamMoiButton.addActionListener(listener);
		danhSachVeTable.addMouseListener(mouseListener);
		btn_DoiVe.addActionListener(listener);
		comboBoxLocDs.addActionListener(listener);
	}

	public DoiTraVe_View(String name, String iconPath) {
		super(name, iconPath);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 800);
		setLocationRelativeTo(null);

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(null);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setContentPane(mainPanel);

		// Phần trên dùng FlowLayout
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(0, 200));
		topPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200));
		topPanel.setBackground(Color.WHITE);
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		mainPanel.add(topPanel);

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.setPreferredSize(new Dimension(0, 55));
		titlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
		topPanel.add(titlePanel);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		JLabel lblTitle = new JLabel("Thông tin khách hàng");
		titlePanel.add(lblTitle);
		lblTitle.setOpaque(true);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		lblTitle.setBorder(new EmptyBorder(5, 10, 5, 20));
		lblTitle.setBackground(new Color(70, 130, 169));

		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.WHITE);
		inputPanel.setBorder(new EmptyBorder(0, 20, 0, 0));
		topPanel.add(inputPanel);
		inputPanel.setPreferredSize(new Dimension(0, 125));
		inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 125));
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new CompoundBorder(new LineBorder(ColorConstants.PRIMARY_COLOR), new EmptyBorder(5, 5, 5, 5)));
		panel_1.setBackground(Color.WHITE);
		inputPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		buttonGroup = new ButtonGroup();

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_4.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblMVTu = new JLabel("Mã vé tàu:");
		panel_8.add(lblMVTu);
		lblMVTu.setFont(new Font("Arial", Font.BOLD, 18));
		lblMVTu.setForeground(ColorConstants.PRIMARY_COLOR);
		txtMaVeTau = new JTextField(15);
		panel_4.add(txtMaVeTau);
		txtMaVeTau.putClientProperty("JTextField.placeholderText", "Nhập mã vé tàu");
		txtMaVeTau.setFont(new Font("Arial", Font.PLAIN, 16));

		Component horizontalStrut_1_5_11_1 = Box.createHorizontalStrut(80);
		panel_2.add(horizontalStrut_1_5_11_1);

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_2.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));

		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setBackground(Color.WHITE);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(new Color(70, 130, 169));
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 18));
		panel_10.add(lblSinThoi);

		txtSDT = new JTextField(15);
		txtSDT.setEnabled(false);
		txtSDT.putClientProperty("JTextField.placeholderText", "Nhập số điện thoại");
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_11.add(txtSDT);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		// Radio buttons for selecting search by phone or CCCD
		rdbtnMaVeTau = new JRadioButton("Mã vé tàu", true);
		panel_5.add(rdbtnMaVeTau);
		rdbtnMaVeTau.setBackground(Color.WHITE);
		rdbtnMaVeTau.setFont(new Font("Arial", Font.BOLD, 18));
		rdbtnMaVeTau.setForeground(ColorConstants.PRIMARY_COLOR);
		buttonGroup.add(rdbtnMaVeTau);

		Component horizontalStrut_1_5_11_2 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_1_5_11_2);
		rdbtnSDT = new JRadioButton("Số điện thoại");
		panel_5.add(rdbtnSDT);
		rdbtnSDT.setBackground(Color.WHITE);
		rdbtnSDT.setForeground(ColorConstants.PRIMARY_COLOR);
		rdbtnSDT.setFont(new Font("Arial", Font.BOLD, 18));
		buttonGroup.add(rdbtnSDT);

		Component horizontalStrut_1_5_11 = Box.createHorizontalStrut(80);
		panel_3.add(horizontalStrut_1_5_11);

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setBackground(Color.WHITE);
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));

		JPanel panel_InputThongTin1 = new JPanel();
		panel_7.add(panel_InputThongTin1);
		panel_InputThongTin1.setBorder(null);
		panel_InputThongTin1.setBackground(Color.WHITE);
		panel_InputThongTin1.setLayout(new BoxLayout(panel_InputThongTin1, BoxLayout.Y_AXIS));

		JPanel panel_InputThongTin = new JPanel();
		panel_InputThongTin
				.setBorder(new CompoundBorder(new LineBorder(new Color(70, 130, 169), 0), new EmptyBorder(0, 0, 0, 0)));
		panel_InputThongTin.setBackground(Color.WHITE);
		inputPanel.add(panel_InputThongTin);
		panel_InputThongTin.setLayout(new BoxLayout(panel_InputThongTin, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel_InputThongTin.add(panel);
		panel.setPreferredSize(new Dimension(180, 0));
		panel.setMaximumSize(new Dimension(180, Integer.MAX_VALUE));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));

		lamMoiButton = new PrimaryButton("Làm mới", "/Image/restore.png");
		panel.add(lamMoiButton);
		lamMoiButton.setFont(new Font("Arial", Font.BOLD, 18));
		lamMoiButton.setInsets(new Insets(4, 6, 4, 6));
		lamMoiButton.setBorderRadius(10);
		lamMoiButton.setIconTextGap(5);
		lamMoiButton.setIconSize(22, 22);
		lamMoiButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		lamMoiButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		lamMoiButton.setPreferredSize(new Dimension(135, 35));

		timKiemButton = new PrimaryButton("Tìm kiếm", "/Image/search.png");
		panel.add(timKiemButton);
		timKiemButton.setFont(new Font("Arial", Font.BOLD, 18));
		timKiemButton.setInsets(new Insets(4, 6, 4, 6));
		timKiemButton.setBorderRadius(10);
		timKiemButton.setIconTextGap(5);
		timKiemButton.setIconSize(22, 22);
		timKiemButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		timKiemButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
		timKiemButton.setPreferredSize(new Dimension(135, 35));

		PrimaryButton btn_XemDsHD = new PrimaryButton("Xem thêm", "/Image/excel.png");
		btn_XemDsHD.setText("Xuất Excel");
		btn_XemDsHD.setMaximumSize(new Dimension(2147483647, 50));
		btn_XemDsHD.setInsets(new Insets(4, 6, 4, 6));
		btn_XemDsHD.setIconTextGap(5);
		btn_XemDsHD.setFont(new Font("Arial", Font.BOLD, 18));
		btn_XemDsHD.setBorderRadius(10);
		btn_XemDsHD.setAlignmentX(0.0f);
		panel.add(btn_XemDsHD);

		// Phần giữa chứa bảng
		JPanel panel_center = new JPanel();
		panel_center.setBackground(Color.WHITE);
		mainPanel.add(panel_center);
		panel_center.setLayout(new BoxLayout(panel_center, BoxLayout.Y_AXIS));

		JPanel panel_TitleDanhSach = new JPanel();
		panel_TitleDanhSach.setBackground(Color.WHITE);
		panel_TitleDanhSach.setPreferredSize(new Dimension(0, 60));
		panel_TitleDanhSach.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
		panel_center.add(panel_TitleDanhSach);
		panel_TitleDanhSach.setLayout(new BoxLayout(panel_TitleDanhSach, BoxLayout.X_AXIS));

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_12.setBorder(new EmptyBorder(10, 5, 0, 0));
		panel_TitleDanhSach.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblDanhSach = new JLabel("Danh sách hóa đơn");
		panel_12.add(lblDanhSach);
		lblDanhSach.setOpaque(true);
		lblDanhSach.setForeground(Color.WHITE);
		lblDanhSach.setFont(new Font("Arial", Font.BOLD, 20));
		lblDanhSach.setBorder(new EmptyBorder(5, 10, 5, 20));
		lblDanhSach.setBackground(new Color(70, 130, 169));

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new EmptyBorder(10, 0, 0, 20));
		panel_13.setBackground(Color.WHITE);
		panel_TitleDanhSach.add(panel_13);
		panel_13.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		comboBoxLocDs = new JComboBox<String>();
		panel_13.add(comboBoxLocDs);
		comboBoxLocDs.setModel(new DefaultComboBoxModel<String>(new String[] { "Tất cả", "Lọc theo ngày tăng dần",
				"Lọc theo ngày giảm dần", "Lọc theo đổi / trả", "Lọc theo loại vé" }));
		comboBoxLocDs.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxLocDs.setPreferredSize(new Dimension(210, 35));

		txtLocDanhSach = new JTextField();
		txtLocDanhSach.putClientProperty("JTextField.placeholderText", "Nhập mã vé tàu");
		txtLocDanhSach.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_13.add(txtLocDanhSach);
		txtLocDanhSach.setPreferredSize(new Dimension(175, 35));
		txtLocDanhSach.setColumns(10);

		btnLocTheoDanhSach = new PrimaryButton("Tìm kiếm", "/Image/find_1.png");
		btnLocTheoDanhSach.setText("Lọc danh sách");
		btnLocTheoDanhSach.setPreferredSize(new Dimension(175, 35));
		btnLocTheoDanhSach.setMaximumSize(new Dimension(2147483647, 50));
		btnLocTheoDanhSach.setInsets(new Insets(4, 6, 4, 6));
		btnLocTheoDanhSach.setIconTextGap(5);
		btnLocTheoDanhSach.setFont(new Font("Arial", Font.BOLD, 18));
		btnLocTheoDanhSach.setBorderRadius(10);
		btnLocTheoDanhSach.setAlignmentX(0.0f);
		panel_13.add(btnLocTheoDanhSach);

		JPanel panel_Table = new JPanel();
		panel_Table.setBorder(new EmptyBorder(0, 20, 5, 15));
		panel_Table.setBackground(Color.WHITE);
		panel_Table.setPreferredSize(new Dimension(0, 530));
		panel_Table.setMaximumSize(new Dimension(Integer.MAX_VALUE, 530));
		panel_center.add(panel_Table);
		panel_Table.setLayout(new BoxLayout(panel_Table, BoxLayout.X_AXIS));

		String[] columnNames = { "STT", "Mã hóa đơn", "Mã vé tàu", "Tên khách hàng", "Ngày mua", "Trang thái vé",
				"Loại vé", "Thành Tiền" };
		tableModel = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		danhSachVeTable = new JTable(tableModel);
		danhSachVeTable.setRowHeight(25);
		danhSachVeTable.setFont(new Font("Arial", Font.PLAIN, 16));
		danhSachVeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		danhSachVeTable.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if (value instanceof java.util.Date) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd 'thg' MM, yyyy");
					setText(formatter.format((java.util.Date) value));
				}
				return c;
			}
		});

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < danhSachVeTable.getColumnCount(); i++) {
			danhSachVeTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		JTableHeader header = danhSachVeTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 18));
		header.setReorderingAllowed(false);
		for (int i = 0; i < danhSachVeTable.getColumnCount(); i++) {
			danhSachVeTable.getColumnModel().getColumn(i).setResizable(true);
		}
		danhSachVeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		danhSachVeTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		danhSachVeTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		danhSachVeTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		danhSachVeTable.getColumnModel().getColumn(3).setPreferredWidth(190);
		danhSachVeTable.getColumnModel().getColumn(4).setPreferredWidth(190);
		danhSachVeTable.getColumnModel().getColumn(5).setPreferredWidth(130);
		danhSachVeTable.getColumnModel().getColumn(6).setPreferredWidth(130);
		danhSachVeTable.getColumnModel().getColumn(7).setPreferredWidth(200);

		JScrollPane tableScrollPane = new JScrollPane(danhSachVeTable);
		tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel_Table.add(tableScrollPane);

		// Phần dưới dùng FlowLayout
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
		bottomPanel.setPreferredSize(new Dimension(0, 60));
		bottomPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
		bottomPanel.setBackground(Color.WHITE);
		mainPanel.add(bottomPanel);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		bottomPanel.add(panel_15);
		panel_15.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_15.add(panel_16);

		JLabel lblNewLabel = new JLabel("Tổng số vé:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(ColorConstants.PRIMARY_COLOR);
		panel_16.add(lblNewLabel);

		lbl_TongSoVe = new JLabel("0");
		lbl_TongSoVe.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16.add(lbl_TongSoVe);

		JPanel panel_16_1 = new JPanel();
		panel_16_1.setBackground(Color.WHITE);
		panel_15.add(panel_16_1);

		JLabel lblTngSV = new JLabel("Số vé đổi / trả:");
		lblTngSV.setForeground(new Color(70, 130, 169));
		lblTngSV.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16_1.add(lblTngSV);

		lbl_TongSoVeDoiTra = new JLabel("0");
		lbl_TongSoVeDoiTra.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16_1.add(lbl_TongSoVeDoiTra);

		JPanel panel_16_2 = new JPanel();
		panel_16_2.setBackground(Color.WHITE);
		panel_15.add(panel_16_2);

		JLabel lblTngSV_1 = new JLabel("Số vé một chiều:");
		lblTngSV_1.setForeground(new Color(70, 130, 169));
		lblTngSV_1.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16_2.add(lblTngSV_1);

		lbl_TongVeMotChieu = new JLabel("0");
		lbl_TongVeMotChieu.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16_2.add(lbl_TongVeMotChieu);

		JPanel panel_16_2_1 = new JPanel();
		panel_16_2_1.setBackground(Color.WHITE);
		panel_15.add(panel_16_2_1);

		JLabel lblTngSV_1_1 = new JLabel("Số vé khứ hồi:");
		lblTngSV_1_1.setForeground(new Color(70, 130, 169));
		lblTngSV_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16_2_1.add(lblTngSV_1_1);

		lbl_TongVeKhuHoi = new JLabel("0");
		lbl_TongVeKhuHoi.setFont(new Font("Arial", Font.BOLD, 18));
		panel_16_2_1.add(lbl_TongVeKhuHoi);

		JPanel panel_16_2_1_1 = new JPanel();
		panel_16_2_1_1.setBorder(new EmptyBorder(0, 30, 0, 0));
		panel_16_2_1_1.setBackground(Color.WHITE);
		panel_15.add(panel_16_2_1_1);

		JLabel lblTngSV_1_1_1 = new JLabel("Tìm nhanh:");
		lblTngSV_1_1_1.setFont(new Font("Arial", Font.ITALIC, 14));
		panel_16_2_1_1.add(lblTngSV_1_1_1);

		JLabel lbl_TongVeKhuHoi_1 = new JLabel("ALT + F");
		lbl_TongVeKhuHoi_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		panel_16_2_1_1.add(lbl_TongVeKhuHoi_1);

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		bottomPanel.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));

		btn_DoiVe = new PrimaryButton("Tìm kiếm");
		panel_14.add(btn_DoiVe);
		btn_DoiVe.setText("Đổi vé tàu");
		btn_DoiVe.setPreferredSize(new Dimension(150, 35));
		btn_DoiVe.setMaximumSize(new Dimension(2147483647, 50));
		btn_DoiVe.setInsets(new Insets(4, 6, 4, 6));
		btn_DoiVe.setIconTextGap(5);
		btn_DoiVe.setFont(new Font("Arial", Font.BOLD, 18));
		btn_DoiVe.setBorderRadius(10);
		btn_DoiVe.setAlignmentX(0.0f);

		btn_TraVe = new PrimaryButton("Xác nhận trả vé");
		panel_14.add(btn_TraVe);
		btn_TraVe.setBorderRadius(10);
		btn_TraVe.setText("Hoàn vé tàu");
		btn_TraVe.setNormalColor(new Color(70, 130, 180));
		btn_TraVe.setFont(new Font("Arial", Font.BOLD, 18));
		btn_TraVe.setInsets(new Insets(4, 6, 4, 6));
		btn_TraVe.setPreferredSize(new Dimension(150, 35));
	}

	public JPanel getHoanTien_view() {
		return mainPanel;
	}

	public JRadioButton getSoDienThoaiRadioButton() {
		return rdbtnMaVeTau;
	}

	public JTable getDanhSachVeTable() {
		return danhSachVeTable;
	}

	public PrimaryButton getTimKiemButton() {
		return timKiemButton;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JRadioButton getCccdRadioButton() {
		return rdbtnSDT;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public PrimaryButton getLamMoiButton() {
		return lamMoiButton;
	}

	// Custom renderer với JTextArea để xuống dòng cho nội dung dài
	class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
		public MultiLineCellRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
			setOpaque(true);
			setFont(new Font("Arial", Font.PLAIN, 14));
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value != null ? value.toString() : "");
			if (isSelected) {
				setBackground(table.getSelectionBackground());
				setForeground(table.getSelectionForeground());
			} else {
				setBackground(table.getBackground());
				setForeground(table.getForeground());
			}
			setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
			int preferredHeight = getPreferredSize().height;
			if (table.getRowHeight(row) != preferredHeight) {
				table.setRowHeight(row, preferredHeight);
			}
			return this;
		}
	}

	public JTextField getTxtMaVeTau() {
		return txtMaVeTau;
	}

	public PrimaryButton getBtn_TraVe() {
		return btn_TraVe;
	}

	public JRadioButton getRdbtnMaVeTau() {
		return rdbtnMaVeTau;
	}

	public JRadioButton getRdbtnSDT() {
		return rdbtnSDT;
	}

	public PrimaryButton getBtn_DoiVe() {
		return btn_DoiVe;
	}

	public JTextField getTxtSDT() {
		return txtSDT;
	}

	public JTextField getTxtLocDanhSach() {
		return txtLocDanhSach;
	}

	public PrimaryButton getBtnLocTheoDanhSach() {
		return btnLocTheoDanhSach;
	}

	public JLabel getLbl_TongSoVe() {
		return lbl_TongSoVe;
	}

	public JComboBox<String> getComboBoxLocDs() {
		return comboBoxLocDs;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public JLabel getLbl_TongVeMotChieu() {
		return lbl_TongVeMotChieu;
	}

	public JLabel getLbl_TongSoVeDoiTra() {
		return lbl_TongSoVeDoiTra;
	}

	public JLabel getLbl_TongVeKhuHoi() {
		return lbl_TongVeKhuHoi;
	}

}

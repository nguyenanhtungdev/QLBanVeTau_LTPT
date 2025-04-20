package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import connectDB.Database;
import model.KhachHang.LoaiKhachHang;

public class HoaDon_DAO {

	private static HoaDon_DAO instance;

	public static HoaDon_DAO getInstance() {
		return instance == null ? instance = new HoaDon_DAO() : instance;
	}

	// Lấy hóa đơn theo số điện thoại hoặc CCCD
	public ArrayList<ThongTinVe> getHoaDonBySoDienThoaiOrCCCD(String soDienThoaiOrMaVeTau) {
		ArrayList<ThongTinVe> thongTinVes = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = Database.getInstance().getConnection();
			String sql = "SELECT DISTINCT *" + "FROM HoaDon hd " + "JOIN KhachHang kh ON hd.maKH = kh.maKH "
					+ "JOIN ChiTiet_HoaDon cthd ON hd.maHoaDon = cthd.maHoaDon "
					+ "JOIN VeTau vt ON cthd.maVeTau = vt.maVeTau " + "WHERE (kh.soDienThoai = ? OR vt.maVeTau = ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, soDienThoaiOrMaVeTau);
			ps.setString(2, soDienThoaiOrMaVeTau);

			rs = ps.executeQuery();

			while (rs.next()) {
				Timestamp timestamp = rs.getTimestamp("ngayLapHoaDon");
				LocalDateTime ngayLapHoaDon = timestamp.toLocalDateTime();

				HoaDon hoaDon = new HoaDon();
				hoaDon.setMaHoaDon(rs.getString("maHoaDon"));
				hoaDon.setNgayLapHoaDon(ngayLapHoaDon);
				hoaDon.setThueVAT(rs.getFloat("thueVAT"));

				hoaDon.setKhachHang(KhachHang_DAO.getInstance().getByMaKhachHang(rs.getString("maKH")));
				VeTau veTau = VeTau_DAO.getInstance().getByMaVeTau(rs.getString("maVeTau"));

				// Thêm hóa đơn vào danh sách kết quả
				thongTinVes.add(new ThongTinVe(hoaDon, veTau));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return thongTinVes;
	}



	public List<HoaDon> getAll() {
		String sql = "SELECT * FROM HoaDon";

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);

			List<HoaDon> list = new ArrayList<>();
			while (resultSet.next()) {
				String maHoaDon = resultSet.getString("maHoaDon");
				Timestamp timestamp = resultSet.getTimestamp("ngayLapHoaDon");
				LocalDateTime ngayLapHoaDon = timestamp.toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maKH = resultSet.getString("maKH");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNV = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");

				KhachHang khachHang = new KhachHang(maKH);
				ThongTinTram thongTinTram = new ThongTinTram(maNhaGa);
				NhanVien nhanVien = new NhanVien(maNV);
				ThongTinGiuCho thongTinGiuCho = new ThongTinGiuCho(maThongTinGiuCho);

				list.add(new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon,
						khachHang, thongTinTram, nhanVien, thongTinGiuCho));
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public HoaDon getByMaHoaDon(String maHoaDon) {
		String sql = "SELECT * FROM HoaDon WHERE maHoaDon = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				LocalDateTime ngayLapHoaDon = resultSet.getTimestamp("ngayLapHoaDon").toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maKhachHang = resultSet.getString("maKH");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNhanVien = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");

				KhachHang khachHang = new KhachHang(maKhachHang);
				ThongTinTram thongTinTram = new ThongTinTram(maNhaGa);
				NhanVien nhanVien = new NhanVien(maNhanVien);
				ThongTinGiuCho thongTinGiuCho = new ThongTinGiuCho(maThongTinGiuCho);

				return new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon, khachHang,
						thongTinTram, nhanVien, thongTinGiuCho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public ArrayList<HoaDon> getalltbHDKH() {
		ArrayList<HoaDon> hoaDons = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();
			String sql = "SELECT hd.*, kh.hoTen, kh.soDienThoai " + "FROM HoaDon hd "
					+ "JOIN KhachHang kh ON hd.maKH = kh.maKH";
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maHoaDon = resultSet.getString("maHoaDon");
				Timestamp timestamp = resultSet.getTimestamp("ngayLapHoaDon");
				LocalDateTime ngayLapHoaDon = timestamp.toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maKH = resultSet.getString("maKH");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNV = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");
				String tenKhachHang = resultSet.getString("hoTen");
				String soDienThoai = resultSet.getString("soDienThoai");
				KhachHang khachHang = new KhachHang(maKH, tenKhachHang, soDienThoai);

				ThongTinTram thongTinTram = new ThongTinTram(maNhaGa);
				NhanVien nhanVien = new NhanVien(maNV);
				ThongTinGiuCho thongTinGiuCho = new ThongTinGiuCho(maThongTinGiuCho);

				HoaDon hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon,
						khachHang, thongTinTram, nhanVien, thongTinGiuCho);
				hoaDons.add(hoaDon);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hoaDons;
	}

	public HoaDon layTTHoaDonTheoMa(String maHoaDon) {
		HoaDon hoaDon = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();
			String sql = "SELECT hd.*, kh.hoTen, kh.soDienThoai " + "FROM HoaDon hd "
					+ "JOIN KhachHang kh ON hd.maKH = kh.maKH " + "WHERE hd.maHoaDon = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHoaDon);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String maKH = resultSet.getString("maKH");
				String tenKhachHang = resultSet.getString("hoTen");
				String soDienThoai = resultSet.getString("soDienThoai");

				Timestamp timestamp = resultSet.getTimestamp("ngayLapHoaDon");
				LocalDateTime ngayLapHoaDon = timestamp.toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNV = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");

				KhachHang khachHang = new KhachHang(maKH, tenKhachHang, soDienThoai);
				ThongTinTram thongTinTram = new ThongTinTram(maNhaGa);
				NhanVien nhanVien = new NhanVien(maNV);
				ThongTinGiuCho thongTinGiuCho = new ThongTinGiuCho(maThongTinGiuCho);

				hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon,
						khachHang, thongTinTram, nhanVien, thongTinGiuCho);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hoaDon;
	}

	public List<HoaDon> layTTHoaDonTheoSDT(String soDienThoai) {
		List<HoaDon> hoaDons = new ArrayList<>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();
			String sql = "SELECT hd.*, kh.hoTen, kh.soDienThoai " + "FROM HoaDon hd "
					+ "JOIN KhachHang kh ON hd.maKH = kh.maKH " + "WHERE kh.soDienThoai = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, soDienThoai);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String maHoaDon = resultSet.getString("maHoaDon");
				Timestamp timestamp = resultSet.getTimestamp("ngayLapHoaDon");
				LocalDateTime ngayLapHoaDon = timestamp.toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maKH = resultSet.getString("maKH");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNV = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");
				String tenKhachHang = resultSet.getString("hoTen");
				KhachHang khachHang = new KhachHang(maKH, tenKhachHang, soDienThoai);

				ThongTinTram thongTinTram = new ThongTinTram(maNhaGa);
				NhanVien nhanVien = new NhanVien(maNV);
				ThongTinGiuCho thongTinGiuCho = new ThongTinGiuCho(maThongTinGiuCho);

				HoaDon hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon,
						khachHang, thongTinTram, nhanVien, thongTinGiuCho);
				hoaDons.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hoaDons;
	}

	public List<HoaDon> layTTHoaDonTheoDate(LocalDateTime startDate, LocalDateTime endDate) {
		List<HoaDon> hoaDons = new ArrayList<>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();

			// Chuyển đổi LocalDateTime sang Timestamp
			Timestamp sqlStartDate = Timestamp.valueOf(startDate);
			Timestamp sqlEndDate = Timestamp.valueOf(endDate);

			// Truy vấn với thông tin khách hàng
			String sql = "SELECT hd.*, kh.hoTen, kh.soDienThoai " + "FROM HoaDon hd "
					+ "JOIN KhachHang kh ON hd.maKH = kh.maKH " + "WHERE hd.ngayLapHoaDon BETWEEN ? AND ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setTimestamp(1, sqlStartDate);
			preparedStatement.setTimestamp(2, sqlEndDate);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Phân tích kết quả
				String maHoaDon = resultSet.getString("maHoaDon");
				Timestamp timestamp = resultSet.getTimestamp("ngayLapHoaDon");
				LocalDateTime ngayLapHoaDon = timestamp.toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maKH = resultSet.getString("maKH");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNV = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");

				// Lấy thông tin khách hàng
				String tenKhachHang = resultSet.getString("hoTen");
				String soDienThoai = resultSet.getString("soDienThoai");
				KhachHang khachHang = new KhachHang(maKH, tenKhachHang, soDienThoai);

				// Tạo đối tượng HoaDon
				HoaDon hoaDon = new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon,
						khachHang, new ThongTinTram(maNhaGa), new NhanVien(maNV), new ThongTinGiuCho(maThongTinGiuCho));
				hoaDons.add(hoaDon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hoaDons;
	}

	public ThongTinTram layThongTinTramTheoMa(String maNhaGa) {
		ThongTinTram thongTinTram = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();

			// Truy vấn SQL để lấy thông tin trạm
			String sql = "SELECT * FROM ThongTinTram WHERE maNhaGa = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNhaGa);
			resultSet = preparedStatement.executeQuery();

			// Nếu tìm thấy kết quả, tạo đối tượng ThongTinTram
			if (resultSet.next()) {
				String tenNhaGa = resultSet.getString("tenNhaGa");
				String diaChi = resultSet.getString("diaChi");
				String dienThoai = resultSet.getString("dienThoai");
				String email = resultSet.getString("email");
				String tenNganHang = resultSet.getString("tenNganHang");
				String soTaiKhoan = resultSet.getString("soTaiKhoan");
				String maSoThue = resultSet.getString("maSoThue");

				// Tạo đối tượng ThongTinTram
				thongTinTram = new ThongTinTram(maNhaGa, tenNhaGa, diaChi, dienThoai, email, tenNganHang, soTaiKhoan,
						maSoThue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thongTinTram;
	}

	public KhachHang layKhachHangTheoMa(String maKH) {
		KhachHang khachHang = null;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();

			String sql = "SELECT * FROM KhachHang WHERE maKH = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maKH);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String hoTen = resultSet.getString("hoTen");
				String soDienThoai = resultSet.getString("soDienThoai");
				String email = resultSet.getString("email");
				boolean gioiTinh = resultSet.getBoolean("gioiTinh");
				String CCCD = resultSet.getString("CCCD");
				LocalDate ngaySinh = resultSet.getDate("ngaySinh").toLocalDate();
				LoaiKhachHang loaiKH = LoaiKhachHang.valueOf(resultSet.getString("loaiKH").toUpperCase());
				khachHang = new KhachHang(maKH, hoTen, soDienThoai, email, gioiTinh, CCCD, ngaySinh, loaiKH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return khachHang;
	}

	public String getMaHoaDonMaxTrongThang() {
		String sql = "SELECT MAX(maHoaDon) FROM HoaDon WHERE maHoaDon LIKE ?";
		Connection con;
		String maHoaDon = null;
		try {
			con = Database.getInstance().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyy");
			String prefix = today.format(formatter);

			preparedStatement.setString(1, "HD" + prefix + "%");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				maHoaDon = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maHoaDon;
	}

	public boolean addHoaDon(HoaDon hoaDon) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();

			String sql = "INSERT INTO HoaDon (maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon, maKH, maNhaGa, maNV, maThongTinGiuCho) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, hoaDon.getMaHoaDon());
			preparedStatement.setTimestamp(2, Timestamp.valueOf(hoaDon.getNgayLapHoaDon())); // Chuyển LocalDateTime
																								// thành Timestamp
			preparedStatement.setString(3, hoaDon.getGhiChu());
			preparedStatement.setFloat(4, hoaDon.getThueVAT());
			preparedStatement.setString(5, hoaDon.getPhuongThucThanhToan());
			preparedStatement.setString(6, hoaDon.getLoaiHoaDon());
			preparedStatement.setString(7, hoaDon.getKhachHang().getMaKhachHang());
			preparedStatement.setString(8, hoaDon.getThongTinTram().getMaNhaGa());
			preparedStatement.setString(9, hoaDon.getNhanVien().getMaNV());

			if (hoaDon.getThongTinGiuCho() != null) {
				preparedStatement.setString(10, hoaDon.getThongTinGiuCho().getMaThongTinGiuCho());
			} else {
				preparedStatement.setNull(10, java.sql.Types.VARCHAR);
			}

			int rowsInserted = preparedStatement.executeUpdate();

			return rowsInserted > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Map<String, Object>> getThongTinHoaDon(String maHoaDon) {
		List<Map<String, Object>> danhSachThongTinHoaDon = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();

			String sql = "SELECT " + "ttt.tenNhaGa, ttt.dienThoai, ttt.diaChi, " + "kh.hoTen, kh.soDienThoai, kh.CCCD, "
					+ "vt.maVeTau, vt.loaiVe, " + "ct.gaKhoiHanh, ct.gaDen, ct.thoiGianKhoiHanh, "
					+ "gt.soThuTuGhe, tt.soThuTuToa, t.maTau " + "FROM HoaDon hd "
					+ "INNER JOIN ThongTinTram ttt ON ttt.maNhaGa = hd.maNhaGa "
					+ "INNER JOIN ChiTiet_HoaDon cthd ON hd.maHoaDon = cthd.maHoaDon "
					+ "INNER JOIN VeTau vt ON cthd.maVeTau = vt.maVeTau "
					+ "INNER JOIN KhachHang kh ON kh.maKH = vt.maKH "
					+ "INNER JOIN GheTau gt ON gt.maGheTau = vt.maGheTau "
					+ "INNER JOIN ToaTau tt ON tt.maToaTau = gt.maToaTau " + "INNER JOIN Tau t ON t.maTau = tt.maTau "
					+ "INNER JOIN ChuyenTau ct ON ct.maChuyenTau = t.maChuyenTau " + "WHERE hd.maHoaDon = ?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, maHoaDon);

			rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, Object> thongTinHoaDon = new HashMap<>();
				thongTinHoaDon.put("tenNhaGa", rs.getString("tenNhaGa"));
				thongTinHoaDon.put("dienThoaiNhaGa", rs.getString("dienThoai"));
				thongTinHoaDon.put("diaChiNhaGa", rs.getString("diaChi"));
				thongTinHoaDon.put("hoTenKhachHang", rs.getString("hoTen"));
				thongTinHoaDon.put("soDienThoaiKH", rs.getString("soDienThoai"));
				thongTinHoaDon.put("cccdKH", rs.getString("CCCD"));
				thongTinHoaDon.put("maVeTau", rs.getString("maVeTau"));
				thongTinHoaDon.put("loaiVe", rs.getString("loaiVe"));
				thongTinHoaDon.put("gaKhoiHanh", rs.getString("gaKhoiHanh"));
				thongTinHoaDon.put("gaDen", rs.getString("gaDen"));
				thongTinHoaDon.put("thoiGianKhoiHanh", rs.getString("thoiGianKhoiHanh"));
				thongTinHoaDon.put("soThuTuGhe", rs.getString("soThuTuGhe"));
				thongTinHoaDon.put("soThuTuToa", rs.getString("soThuTuToa"));
				thongTinHoaDon.put("maTau", rs.getString("maTau"));

				danhSachThongTinHoaDon.add(thongTinHoaDon); // Thêm vào danh sách
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return danhSachThongTinHoaDon;
	}

	public List<HoaDon> getByFilters(LocalDateTime start, LocalDateTime end, KhachHang[] khachHangs,
			NhanVien[] nhanViens) {
		String sql = "SELECT * FROM HoaDon";
		List<Object> values = new ArrayList<>();
		boolean hasWhere = false;

		if (khachHangs != null && khachHangs.length > 0) {
			if (!hasWhere) {
				sql += " WHERE ";
				hasWhere = true;
			} else {
				sql += " AND ";
			}
			List<String> list = Stream.of(khachHangs).map(KhachHang::getMaKhachHang).toList();
			sql += "maKH IN (" + String.join(",", Collections.nCopies(list.size(), "?")) + ")";
			values.addAll(list);
		}

		if (nhanViens != null && nhanViens.length > 0) {
			if (!hasWhere) {
				sql += " WHERE ";
				hasWhere = true;
			} else {
				sql += " AND ";
			}
			List<String> list = Stream.of(nhanViens).map(NhanVien::getMaNV).toList();
			sql += "maNV IN (" + String.join(",", Collections.nCopies(list.size(), "?")) + ")";
			values.addAll(list);
		}

		if (start != null) {
			if (!hasWhere) {
				sql += " WHERE ";
				hasWhere = true;
			} else {
				sql += " AND ";
			}
			sql += "ngayLapHoaDon >= ?";
			values.add(start);
		}

		if (end != null) {
			if (!hasWhere) {
				sql += " WHERE ";
				hasWhere = true;
			} else {
				sql += " AND ";
			}
			sql += "ngayLapHoaDon <= ?";
			values.add(end);
		}

		sql += " ORDER BY ngayLapHoaDon ASC";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			for (int i = 0; i < values.size(); i++) {
				statement.setObject(i + 1, values.get(i));
			}
			resultSet = statement.executeQuery();

			List<HoaDon> list = new ArrayList<>();
			while (resultSet.next()) {
				String maHoaDon = resultSet.getString("maHoaDon");
				LocalDateTime ngayLapHoaDon = resultSet.getTimestamp("ngayLapHoaDon").toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");
				float thueVAT = resultSet.getFloat("thueVAT");
				String phuongThucThanhToan = resultSet.getString("phuongThucThanhToan");
				String loaiHoaDon = resultSet.getString("loaiHoaDon");
				String maKhachHang = resultSet.getString("maKH");
				String maNhaGa = resultSet.getString("maNhaGa");
				String maNhanVien = resultSet.getString("maNV");
				String maThongTinGiuCho = resultSet.getString("maThongTinGiuCho");

				KhachHang khachHang = new KhachHang(maKhachHang);
				ThongTinTram thongTinTram = new ThongTinTram(maNhaGa);
				NhanVien nhanVien = new NhanVien(maNhanVien);
				ThongTinGiuCho thongTinGiuCho = new ThongTinGiuCho(maThongTinGiuCho);

				list.add(new HoaDon(maHoaDon, ngayLapHoaDon, ghiChu, thueVAT, phuongThucThanhToan, loaiHoaDon,
						khachHang, thongTinTram, nhanVien, thongTinGiuCho));
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public int laySoLuongHoaDon(String maHoaDon) {
		String sql = "SELECT COUNT(*) FROM HoaDon hd " + "JOIN ChiTiet_HoaDon cthd ON hd.maHoaDon = cthd.maHoaDon "
				+ "WHERE hd.maHoaDon = ? ";
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int soLuong = 0;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				soLuong = resultSet.getInt("soLuong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return soLuong;
	}


}

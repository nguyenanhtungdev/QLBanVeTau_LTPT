package daos.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import model.*;

public class VeTau_DAOImpl {

	private static VeTau_DAOImpl instance;

	public static VeTau_DAOImpl getInstance() {
		return instance == null ? instance = new VeTau_DAOImpl() : instance;
	}

	public List<VeTau> getAll() {
		String sql = "Select * FROM VeTau";

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);

			List<VeTau> list = new ArrayList<>();
			while (resultSet.next()) {
				String maVeTau = resultSet.getString("maVeTau");
				boolean loaiVe = resultSet.getBoolean("loaiVe");
				LocalDateTime ngayHetHan = resultSet.getTimestamp("ngayHetHan").toLocalDateTime();
				boolean daHuy = resultSet.getBoolean("daHuy");
				String maKH = resultSet.getString("maKH");
				boolean isKhuHoi = resultSet.getBoolean("isKhuHoi");

				GheTau gheTau = new GheTau(resultSet.getString("maGheTau"));

				list.add(new VeTau(maVeTau, loaiVe, ngayHetHan, daHuy, gheTau, isKhuHoi, new KhachHang(maKH)));
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

	public String getVeTauMax() {
		String sql = "SELECT MAX(maVeTau) FROM VeTau";
		Connection con;
		String maVeTau = null;
		try {
			con = Database.getInstance().getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				maVeTau = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maVeTau;
	}

	public VeTau getByMaVeTau(String maVeTau) {
		String sql = "SELECT * FROM VeTau WHERE maVeTau = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maVeTau);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				boolean loaiVe = resultSet.getBoolean("loaiVe");
				LocalDateTime ngayHetHan = resultSet.getTimestamp("ngayHetHan").toLocalDateTime();
				boolean daHuy = resultSet.getBoolean("daHuy");
				String maKH = resultSet.getString("maKH");
				boolean isKhuHoi = resultSet.getBoolean("isKhuHoi");

				GheTau gheTau = new GheTau(resultSet.getString("maGheTau"));

				return new VeTau(maVeTau, loaiVe, ngayHetHan, daHuy, gheTau, isKhuHoi, new KhachHang(maKH));
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

	public VeTau getByMaVeTauChuyenTau(String maVeTau) {
		String sql = "SELECT * FROM VeTau WHERE maVeTau = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maVeTau);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				boolean loaiVe = resultSet.getBoolean("loaiVe");
				LocalDateTime ngayHetHan = resultSet.getTimestamp("ngayHetHan").toLocalDateTime();
				boolean daHuy = resultSet.getBoolean("daHuy");
				String maKH = resultSet.getString("maKH");
				boolean isKhuHoi = resultSet.getBoolean("isKhuHoi");

				GheTau gheTau = GheTau_DAOImpl.getInstance().getByMaGheTau(resultSet.getString("maGheTau"));
				ToaTau toaTau = ToaTau_DAOImpl.getInstance().getByMaToaTau(gheTau.getToaTau().getMaToaTau());
				Tau tau = Tau_DAOImpl.getInstance().getByMaTau(toaTau.getTau().getMaTau());
				ChuyenTau chuyenTau = ChuyenTau_DAOImpl.getInstance().getByMaChuyenTau(tau.getChuyenTau().getMaChuyenTau());
				return new VeTau(maVeTau, loaiVe, ngayHetHan, daHuy, gheTau, isKhuHoi, new KhachHang(maKH));
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

	public boolean themVeTau(VeTau veTau) {
		String sql = "INSERT INTO VeTau (maVeTau, loaiVe, ngayHetHan, daHuy, maGheTau, maKH) VALUES (?, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, veTau.getMaVeTau());
			statement.setBoolean(2, veTau.isLoaiVe());
			statement.setTimestamp(3, Timestamp.valueOf(veTau.getNgayHetHan()));
			statement.setBoolean(4, veTau.isDaHuy());
			statement.setString(5, veTau.getGheTau().getMaGheTau());
			statement.setString(6, veTau.getKhachHang().getMaKhachHang());
			int count = statement.executeUpdate();

			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean capNhatTrangThaiVeTau(String maKH, String maHoaDon) {
		Connection con = null;
		PreparedStatement statement = null;
		String sql = "UPDATE VeTau SET daHuy = 1 WHERE maKH = ? AND maVeTau IN (SELECT maVeTau FROM ChiTiet_HoaDon WHERE maHoaDon = ?) AND daHuy = 0";
		try {

			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maKH);
			statement.setString(2, maHoaDon);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public VeTau getByMaHoaDon(String maHoaDon) {
		String sql = "SELECT VeTau.maVeTau " + "FROM ChiTiet_HoaDon "
				+ "INNER JOIN VeTau ON ChiTiet_HoaDon.maVeTau = VeTau.maVeTau "
				+ "WHERE ChiTiet_HoaDon.maHoaDon = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Lấy thông tin cơ bản của VeTau
				String maVeTau = resultSet.getString("maVeTau");
				// Trả về đối tượng VeTau
				return new VeTau(maVeTau);
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

		return null; // Trả về null nếu không tìm thấy
	}
}

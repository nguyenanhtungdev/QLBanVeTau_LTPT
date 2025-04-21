package daos.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import model.Tau;
import model.ToaTau;

public class ToaTau_DAOImpl {

	private static ToaTau_DAOImpl instance;

	public static ToaTau_DAOImpl getInstance() {
		return instance == null ? instance = new ToaTau_DAOImpl() : instance;
	}

	public List<ToaTau> getAll() {
		String sql = "Select * FROM ToaTau";

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);

			List<ToaTau> list = new ArrayList<>();
			while (resultSet.next()) {
				String maToaTau = resultSet.getString("maToaTau");
				String tenToaTau = resultSet.getString("tenToaTau");
				int soThuTuToa = resultSet.getInt("soThuTuToa");
				String loaiToa = resultSet.getString("loaiToa");
				int soLuongGhe = resultSet.getInt("soLuongGhe");
				boolean trangThai = resultSet.getBoolean("trangThai");
				String maTau = resultSet.getString("maTau");

				Tau tau = new Tau(maTau);

				list.add(new ToaTau(maToaTau, tenToaTau, soThuTuToa, loaiToa, soLuongGhe, trangThai, tau));
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

	public ToaTau getByMaToaTau(String maToaTau) {
		String sql = "Select * FROM ToaTau WHERE maToaTau = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maToaTau);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String tenToaTau = resultSet.getString("tenToaTau");
				int soThuTuToa = resultSet.getInt("soThuTuToa");
				String loaiToa = resultSet.getString("loaiToa");
				int soLuongGhe = resultSet.getInt("soLuongGhe");
				boolean trangThai = resultSet.getBoolean("trangThai");
				String maTau = resultSet.getString("maTau");

				Tau tau = new Tau(maTau);

				return new ToaTau(maToaTau, tenToaTau, soThuTuToa, loaiToa, soLuongGhe, trangThai, tau);
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

	public ArrayList<ToaTau> getDsToaTau(String maTau) {
		ArrayList<ToaTau> toaTaus = new ArrayList<>();
		String sql = "SELECT * FROM ToaTau TT JOIN Tau T ON TT.maTau = T.maTau WHERE TT.maTau = ?";
		Connection con;

		try {
			con = Database.getInstance().getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maTau);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maToaTau = resultSet.getString("maToaTau");
				String tenToaTau = resultSet.getString("tenToaTau");
				int soThuTuToa = resultSet.getInt("soThuTuToa");
				String loaiToa = resultSet.getString("loaiToa");
				int soLuongGhe = resultSet.getInt("soLuongGhe");
				boolean trangThai = resultSet.getBoolean("trangThai");
				String maTauSQL = resultSet.getString("maTau");

				Tau tau = new Tau(maTauSQL);
				ToaTau toatau = new ToaTau(maToaTau, tenToaTau, soThuTuToa, loaiToa, soLuongGhe, trangThai, tau);
				toaTaus.add(toatau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toaTaus;
	}

	// get toaTau theo maTau
	public ArrayList<ToaTau> getToaTauTheoMaTau(String maTau) {
		ArrayList<ToaTau> toaTaus = new ArrayList<>();
		String sql = "SELECT * FROM ToaTau WHERE maTau = ?"; // Truy vấn lấy toa tàu theo mã tàu
		Connection con;

		try {
			con = Database.getInstance().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTau); // Thiết lập giá trị cho tham số maTau
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String maToaTau = resultSet.getString("maToaTau");
				String tenToaTau = resultSet.getString("tenToaTau");
				int soThuTuToa = resultSet.getInt("soThuTuToa");
				String loaiToa = resultSet.getString("loaiToa");
				int soLuongGhe = resultSet.getInt("soLuongGhe");
				boolean trangThai = resultSet.getBoolean("trangThai");

				Tau tau = new Tau(maTau);
				ToaTau toatau = new ToaTau(maToaTau, tenToaTau, soThuTuToa, loaiToa, soLuongGhe, trangThai, tau);
				toaTaus.add(toatau); // Thêm đối tượng toa tàu vào danh sách
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return toaTaus;
	}
}

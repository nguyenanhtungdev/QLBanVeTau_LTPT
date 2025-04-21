package daos.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectDB.Database;
import model.TaiKhoan;

public class TaiKhoan_DAOImpl {

	public static TaiKhoan_DAOImpl instance;

	public static TaiKhoan_DAOImpl getInstance() {
		return instance == null ? instance = new TaiKhoan_DAOImpl() : instance;
	}

	public ArrayList<TaiKhoan> getalltbTK() {

		ArrayList<TaiKhoan> taiKhoans = new ArrayList<>();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Database.getInstance();
			con = Database.getInstance().getConnection();
			String sql = "SELECT * FROM TaiKhoan";
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maTaiKhoan = resultSet.getString("maTaiKhoan");
				String tenDangNhap = resultSet.getString("tenDangNhap");
				String matKhau = resultSet.getString("matKhau");
				boolean trangThai = resultSet.getBoolean("trangThai");
				Timestamp timestamp = resultSet.getTimestamp("ngayTaoTaiKhoan");
				LocalDateTime ngayTaoTaiKhoan = timestamp.toLocalDateTime();
				String maNV = resultSet.getString("maNV");

				TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, tenDangNhap, matKhau, trangThai, ngayTaoTaiKhoan,
						NhanVien_DAOImpl.getInstance().getByMaNhanVien(maNV));
				taiKhoans.add(taiKhoan);
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

		return taiKhoans;
	}
	
	public boolean insertTaiKhoan(TaiKhoan tk) {
	    Connection con = null;
	    PreparedStatement preparedStatement = null;

	    String sql = "INSERT INTO TaiKhoan (maTaiKhoan, tenDangNhap, matKhau, maNV, ngayTaoTaiKhoan, trangThai) VALUES (?, ?, ?, ?, ?, ?)";

	    try {
	        con = Database.getInstance().getConnection();
	        preparedStatement = con.prepareStatement(sql);

	        preparedStatement.setString(1, tk.getMaTaiKhoan());
	        preparedStatement.setString(2, tk.getTenDangNhap());
	        preparedStatement.setString(3, tk.getMatKhau());
	        preparedStatement.setString(4, tk.getNhanVien().getMaNV()); 
	        preparedStatement.setTimestamp(5, java.sql.Timestamp.valueOf(tk.getNgayTaoTaiKhoan()));
	        preparedStatement.setBoolean(6, tk.isTrangThai());

	        int rowsInserted = preparedStatement.executeUpdate();
	        return rowsInserted > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public String getMaTKMax() {
		String sql = "SELECT MAX(maTaiKhoan) FROM TaiKhoan";
		Statement statement = null;
		ResultSet resultSet = null;
		String maTK = null;
		try {
			Connection con = Database.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				maTK = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maTK;
	}

}

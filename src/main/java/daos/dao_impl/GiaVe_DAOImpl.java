package daos.dao_impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import daos.dao_interface.GiaVe_DAO;
import lombok.Getter;
import model.GiaVe;
@Getter
public class GiaVe_DAOImpl extends UnicastRemoteObject implements GiaVe_DAO {

	public GiaVe_DAOImpl() throws RemoteException {
    }
	private static GiaVe_DAOImpl instance;

	public static GiaVe_DAOImpl getInstance() throws RemoteException {
		return instance == null ? instance = new GiaVe_DAOImpl() : instance;
	}

	public List<GiaVe> getAll() {
		String sql = "SELECT * FROM GiaVe";

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(sql);

			List<GiaVe> list = new ArrayList<>();
			while (resultSet.next()) {
				String maGiaVe = resultSet.getString(1);
				double giaVe = resultSet.getDouble(2);
				float tiLeTangGia = resultSet.getFloat(3);
				LocalDateTime ngayCapNhap = resultSet.getTimestamp(4).toLocalDateTime();
				String ghiChu = resultSet.getString(5);

				list.add(new GiaVe(maGiaVe, giaVe, tiLeTangGia, ngayCapNhap, ghiChu));
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

	public GiaVe getByMaGiaVe(String maGiaVe) {
		String sql = "SELECT * FROM GiaVe WHERE maGiaVe = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maGiaVe);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String maGiaVeResult = resultSet.getString("maGiaVe");
				double giaVeResult = resultSet.getDouble("giaVe");
				float tiLeTangGia = resultSet.getFloat("tiLeTangGia");
				LocalDateTime ngayCapNhap = resultSet.getTimestamp("ngayCapNhat").toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");

				return new GiaVe(maGiaVeResult, giaVeResult, tiLeTangGia, ngayCapNhap, ghiChu);
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

	public GiaVe getGiaVeTheoChuyenTau(String maGheTau, String maChuyenTau) {
		GiaVe gv = null;
		String sql = "SELECT GV.maGiaVe, GV.giaVe, GV.tiLeTangGia, GV.ngayCapNhat, GV.ghiChu " + "FROM dbo.GiaVe GV "
				+ "JOIN dbo.ChuyenTau CT ON GV.maGiaVe = CT.maGiaVe " + "JOIN dbo.Tau T ON T.maChuyenTau = CT.maChuyenTau "
				+ "JOIN dbo.ToaTau TT ON TT.maTau = T.maTau " + "JOIN dbo.GheTau GT ON GT.maToaTau = TT.maToaTau "
				+ "WHERE GT.maGheTau = ? AND CT.maChuyenTau = ?";
		Connection con;
		try {
			con = Database.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			// Thiết lập các tham số cho câu truy vấn
			stmt.setString(1, maGheTau);
			stmt.setString(2, maChuyenTau);

			ResultSet resultSet = stmt.executeQuery();

			// Lấy kết quả
			if (resultSet.next()) {
				String maGiaVe = resultSet.getString("maGiaVe");
				double giaVe = resultSet.getDouble("giaVe");
				float tiLeTangGia = resultSet.getFloat("tiLeTangGia");
				LocalDateTime ngayCapNhat = resultSet.getTimestamp("ngayCapNhat").toLocalDateTime();
				String ghiChu = resultSet.getString("ghiChu");

				gv = new GiaVe(maGiaVe, giaVe, tiLeTangGia, ngayCapNhat, ghiChu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gv;
	}

}

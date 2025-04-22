package daos.dao_impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.Database;
import daos.dao_interface.ThongTinTram_DAO;
import lombok.Getter;
import model.ThongTinTram;
@Getter
public class ThongTinTram_DAOImpl extends UnicastRemoteObject implements ThongTinTram_DAO {

	public ThongTinTram_DAOImpl() throws RemoteException{}
	private static ThongTinTram_DAOImpl instance;

	public static ThongTinTram_DAOImpl getInstance() throws RemoteException {
		return instance == null ? instance = new ThongTinTram_DAOImpl() : instance;
	}

	public ThongTinTram getByMaNhaGa(String maNhaGa) {
		String sql = "SELECT* FROM ThongTinTram WHERE maNhaGa = ?";

		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			con = Database.getInstance().getConnection();
			statement = con.prepareStatement(sql);
			statement.setString(1, maNhaGa);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String tenNhaGa = resultSet.getString("tenNhaGa");
				String diaChi = resultSet.getString("diaChi");
				String dienThoai = resultSet.getString("dienThoai");
				String email = resultSet.getString("email");
				String tenNganHang = resultSet.getString("tenNganHang");
				String soTaiKhoan = resultSet.getString("soTaiKhoan");
				String maSoThue = resultSet.getString("maSoThue");

				return new ThongTinTram(maNhaGa, tenNhaGa, diaChi, dienThoai, email, tenNganHang, soTaiKhoan, maSoThue);
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
}

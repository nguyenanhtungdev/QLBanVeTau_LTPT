package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.TaiKhoan;
import view.HomeView;
import view.Left_Menu;
import view.View;
import java.time.LocalTime;
import java.util.function.Predicate;

import model.CaLam;
import daos.dao_impl.CaLam_DAOImpl;

public class HienThi_Controller {

	private static HienThi_Controller instance;

	public static HienThi_Controller getInstance() {
		return instance == null ? instance = new HienThi_Controller() : instance;
	}

	private HomeView homeView = new HomeView();
	private TaiKhoan taiKhoan = new TaiKhoan();

	public HienThi_Controller() {

	}

	public void xuLyHienThi() {
		ArrayList<View> dsViewBanVe = BanVeTau_Controller.getInstance().getViewList();
		ArrayList<View> dsViewQuanLy = QuanLy_Controller.getInstance().getViewList();
//		ArrayList<View> dsViewThongKe = ThongKe_Controller.getInstance().getViewList();
		ArrayList<View> dsViewCaiDat = CaiDat_Controller.getInstance().getViewList();

		QuanLy_Controller.getInstance().addView(taiKhoan.getNhanVien().getTenChucVu().trim());
		BanVeTau_Controller.getInstance().setNhanVien(taiKhoan.getNhanVien());

		for (View view : dsViewBanVe) {
			homeView.addView(view.getName(), (JPanel) view.getContentPane());
		}
		for (View view : dsViewQuanLy) {
			if (taiKhoan.getNhanVien().getTenChucVu().trim().equals("NVBV")) {
				if (view.getName().equals("Hóa đơn") || view.getName().equals("Khách hàng")) {
					homeView.addView(view.getName(), (JPanel) view.getContentPane());
				}
			} else {
				homeView.addView(view.getName(), (JPanel) view.getContentPane());
			}
//			view.addView(page.getName(), (JPanel) page.getContentPane());
		}
//		for (View view : dsViewThongKe) {
//			homeView.addView(view.getName(), (JPanel) view.getContentPane());
//		}

		for (View page : dsViewCaiDat) {
			homeView.addView(page.getName(), (JPanel) page.getContentPane());
		}

		// Tạo Left_Menu và truyền vào Home
		Left_Menu left_Menu_BanVe = new Left_Menu(dsViewBanVe, homeView);
		Left_Menu left_Menu_QuanLy = new Left_Menu(dsViewQuanLy, homeView);
//		Left_Menu left_Menu_ThongKe = new Left_Menu(dsViewThongKe, homeView);
		Left_Menu left_Menu_CaiDat = new Left_Menu(dsViewCaiDat, homeView);

		// Thêm Left_Menu vào view
		homeView.addLeft_Menu("BanVe", left_Menu_BanVe.getLeft_Menu());
		homeView.addLeft_Menu("QuanLy", left_Menu_QuanLy.getLeft_Menu());
//		homeView.addLeft_Menu("ThongKe", left_Menu_ThongKe.getLeft_Menu());
		homeView.addLeft_Menu("CaiDat", left_Menu_CaiDat.getLeft_Menu());

		// Thêm listener cho menu
		homeView.addCustomerMenuListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();

				if (obj == homeView.getLbl_BanVe()) {
					homeView.showView(dsViewBanVe.get(0).getName());
					homeView.showLeft_Menu("BanVe");
				} else if (obj == homeView.getLbl_QuanLy()) {
					homeView.showView(dsViewQuanLy.get(0).getName());
					homeView.showLeft_Menu("QuanLy");
//				} else if (obj == homeView.getLbl_ThongKe()) {
//					homeView.showView(dsViewThongKe.get(0).getName());
//					homeView.showLeft_Menu("ThongKe");
//					// Xác định dữ liệu cần load
//					if (taiKhoan.getNhanVien().getTenChucVu().trim().equals("NVQL")) {
//                        try {
////                            ThongKe_Controller.getInstance().loadManagerData();
//                        } catch (RemoteException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    } else {
//						LocalTime now = LocalTime.now();
//						Predicate<CaLam> pdDetermineCaLam = p -> (p.getThoiGianBatDau().equals(now)
//								|| p.getThoiGianBatDau().isBefore(now)) && p.getThoiGianKetThuc().isAfter(now);
//                        CaLam caLam = null;
//                        try {
//                            caLam = CaLam_DAOImpl.getInstance().getAll().stream().filter(pdDetermineCaLam).findFirst()
//                                    .orElse(null);
//                        } catch (RemoteException ex) {ex.printStackTrace();
//                        }
//                        //                            ThongKe_Controller.getInstance().loadSaleStaffData(taiKhoan.getNhanVien().getMaNV(),
////                                    caLam.getThoiGianBatDau(), caLam.getThoiGianKetThuc().plusSeconds(1));
//                    }
				} else if (obj == homeView.getLbl_CaiDat()) {
					homeView.showView(dsViewCaiDat.get(0).getName());
					homeView.showLeft_Menu("CaiDat");
				}
			}
		});

		if (!taiKhoan.getNhanVien().getTenChucVu().trim().equals("NVBV")) {
			homeView.getLbl_BanVe().setVisible(false);
			homeView.showView(dsViewQuanLy.get(0).getName());
			homeView.showLeft_Menu("QuanLy");
		} else {
			homeView.showView("Home");
		}

		homeView.setNhanVien(taiKhoan.getNhanVien());
	}

	public void showView() {
		homeView.setVisible(true);
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public HomeView getHomeView() {
		return homeView;
	}

}

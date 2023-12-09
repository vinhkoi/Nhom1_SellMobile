package Trangchu;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dangnhap.GUI_Dangnhap;
import Dienthoai.GUI_Phone;
import HangDT.GUI_HangDT;
import Hoadon.GUI_ChitietHD;
import Hoadon.GUI_Hoadon;
import KhachHang.GUI_Khachhang;
import NhanVien.GUI_Nhanvien;
import Taikhoan.GUI_Taikhoan;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MenuAdmin frame = new GUI_MenuAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_MenuAdmin() {
		setTitle("Quản lý cửa hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1152, 665);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setJMenuBar(menuBar);
		
		JButton btnNewButton_7 = new JButton("Đăng xuất");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất không?", "Question",JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					dispose();
					GUI_Dangnhap f = new GUI_Dangnhap();
					f.show();
				}
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnNewButton_7);
		
		JMenu mnNewMenu_1_2 = new JMenu("");
		menuBar.add(mnNewMenu_1_2);
		
		JMenu mnNewMenu = new JMenu("");
		menuBar.add(mnNewMenu);
		
		JButton btnTaikhoan = new JButton("Tài khoản");
		btnTaikhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Taikhoan f = new GUI_Taikhoan();
				f.show();
			}
		});
		btnTaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnTaikhoan);
		
		JButton btnNhanvien = new JButton("Nhân viên");
		btnNhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Nhanvien f = new GUI_Nhanvien();
				f.show();
			}
		});
		btnNhanvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnNhanvien);
		
		JButton btnKhachhang = new JButton("Khách hàng");
		btnKhachhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Khachhang f = new GUI_Khachhang();
				f.show();
			}
		});
		btnKhachhang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnKhachhang);
		
		JButton btnSanpham = new JButton("Sản phẩm");
		btnSanpham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Phone f = new GUI_Phone();
				f.show();
			}
		});
		
		JButton btnHang = new JButton("Hãng Đt");
		btnHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GUI_HangDT f = new GUI_HangDT();
				f.show();
			}
		});
		btnHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnHang);
		btnSanpham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnSanpham);
		
		JButton btnHoadon = new JButton("Hóa đơn");
		btnHoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Hoadon f = new GUI_Hoadon();
				f.show();
			}
		});
		btnHoadon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnHoadon);
		
		JButton btnChiTitHd = new JButton("Chi tiết HD");
		btnChiTitHd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_ChitietHD f = new GUI_ChitietHD();
				f.show();
			}
		});
		btnChiTitHd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(btnChiTitHd);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bgian\\eclipse-workspace\\KTHP\\img\\Backg.png"));
		lblNewLabel.setBounds(0, 0, 1136, 600);
		contentPane.add(lblNewLabel);
	}
}

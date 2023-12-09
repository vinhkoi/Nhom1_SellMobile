package Hoadon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import KhachHang.GUI_Khachhang;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_Hoadon extends JFrame {

	private JPanel contentPane;
	private JTextField txtMahd;
	private JTextField txtNgay;
	private JTable tbDanhsach;

	private Vector tbHeader = new Vector();
	private Vector tbRow = new Vector();
	private Vector tbContent = new Vector();
	private DefaultTableModel Model = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Bill pb = new Process_Bill();

	public void getAllBill() {
		ArrayList<Bill> ls = pb.getListBill();
		for (int i = 0; i < ls.size(); i++) {
			Bill b = (Bill) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(b.getMaHD());
			tbRow.add(b.getTenKH());
			tbRow.add(b.getNhanvien());
			tbRow.add(b.getNgayban());

			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		tbDanhsach.setModel(Model);

	}

	public void getBill_byMaHD(String MaHD) {
		Model.setRowCount(0);
		ArrayList<Bill> ls = pb.getBill_byMaHD(MaHD);
		for (int i = 0; i < ls.size(); i++) {
			Bill b = (Bill) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(b.getMaHD());
			tbRow.add(b.getTenKH());
			tbRow.add(b.getNhanvien());
			tbRow.add(b.getNgayban());

			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		tbDanhsach.setModel(Model);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Hoadon frame = new GUI_Hoadon();
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
	public GUI_Hoadon() {

		setTitle("Thêm hóa đơn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 40, 496, 160);
		contentPane.add(panel);

		txtMahd = new JTextField();
		txtMahd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMahd.setColumns(10);
		txtMahd.setBounds(131, 15, 182, 20);
		panel.add(txtMahd);

		JComboBox cbNhanvien = new JComboBox();
		cbNhanvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbNhanvien.setBounds(131, 127, 182, 22);
		panel.add(cbNhanvien);
		try {
			Process_Bill pb = new Process_Bill();
			Connection cn = pb.getCon();
			String sql = "select Ho_ten_nv from tb_staff group by Ho_ten_nv";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String nv = rs.getString("Ho_ten_nv");
				cbNhanvien.addItem(nv);
			}

		} catch (Exception e) {
			System.out.println("null");
		}

		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNgay.setColumns(10);
		txtNgay.setBounds(131, 87, 182, 20);
		panel.add(txtNgay);

		JLabel lblNewLabel_3 = new JLabel("Ngày bán");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 84, 96, 27);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 9, 96, 27);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Nhân viên bán:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 122, 96, 27);
		panel.add(lblNewLabel_2);

		JButton btnThemKH = new JButton("Khách hàng mới");
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Khachhang f = new GUI_Khachhang();
				f.show();
			}
		});
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemKH.setBounds(335, 48, 140, 23);
		panel.add(btnThemKH);

		JButton btnTimkiem = new JButton("Tìm kiếm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				String ma = String.valueOf(txtMahd.getText());
				getBill_byMaHD(ma);
			}
		});
		btnTimkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimkiem.setBounds(335, 13, 140, 23);
		panel.add(btnTimkiem);

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_1.setBounds(10, 46, 111, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox cbKH = new JComboBox();
		cbKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbKH.setBounds(131, 46, 182, 22);
		panel.add(cbKH);

		JLabel lblNewLabel_4 = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(155, 0, 192, 38);
		contentPane.add(lblNewLabel_4);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 245, 496, 245);
		contentPane.add(scrollPane);

		tbDanhsach = new JTable();
		scrollPane.setViewportView(tbDanhsach);
		tbDanhsach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tbDanhsach.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = tbDanhsach.getSelectedRow();
				txtMahd.setText((String) (Model.getValueAt(index, 0)));
				cbKH.setSelectedItem((String) (Model.getValueAt(index, 1)));
				cbNhanvien.setSelectedItem((String) (Model.getValueAt(index, 2)));
				txtNgay.setText((String) (Model.getValueAt(index, 3)));
			}
		});
		JButton btnThemHD = new JButton("Thêm");
		btnThemHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemHD.setBounds(93, 211, 89, 23);
		contentPane.add(btnThemHD);

		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapnhat.setBounds(208, 211, 89, 23);
		contentPane.add(btnCapnhat);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(325, 211, 89, 23);
		contentPane.add(btnXoa);

		JButton btnXoatxt = new JButton("Làm mới");
		btnXoatxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int itemCount = cbKH.getItemCount();

				for(int i = 0; i < itemCount; i++){
				  cbKH.removeItemAt(0);
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllBill();
				try {
					Process_Bill pb = new Process_Bill();
					Connection cn = pb.getCon();
					String sql = "select Ho_ten_KH from tb_customer group by Ho_ten_KH";
					PreparedStatement ps = cn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String kh = rs.getString("Ho_ten_Kh");
						cbKH.addItem(kh);
					}

				} catch (Exception e1) {
					System.out.println("null");
				}
			}
		});
		btnXoatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoatxt.setBounds(412, 501, 89, 23);
		contentPane.add(btnXoatxt);

		JButton btnThemsp = new JButton("Thêm sản phẩm");
		btnThemsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_ChitietHD f = new GUI_ChitietHD();
				f.show();
				
				
			}
		});
		btnThemsp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThemsp.setBounds(263, 501, 139, 23);
		contentPane.add(btnThemsp);

		JLabel lbAlert = new JLabel("");
		lbAlert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAlert.setBounds(10, 501, 243, 19);
		contentPane.add(lbAlert);

		try {
			Process_Bill pb = new Process_Bill();
			Connection cn = pb.getCon();
			String sql = "select Ho_ten_KH from tb_customer group by Ho_ten_KH";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String kh = rs.getString("Ho_ten_Kh");
				cbKH.addItem(kh);
			}

		} catch (Exception e) {
			System.out.println("null");
		}

		columns.add("Mã hóa đơn");
		columns.add("Tên khách hàng");
		columns.add("Nhân viên bán");
		columns.add("Ngày bán");
		getAllBill();

		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mahd, tenkh, nguoiban, ngayban;
				mahd = (String) txtMahd.getText();
				tenkh = (String) cbKH.getSelectedItem();
				nguoiban = (String) cbNhanvien.getSelectedItem();
				ngayban = (String) txtNgay.getText();

				if (pb.insertBill(mahd, tenkh, nguoiban, ngayban)) {
					lbAlert.setForeground(Color.BLUE);
					lbAlert.setText("Thêm hóa đơn thành công!");
					Model.getDataVector().removeAllElements();
					Model.fireTableDataChanged();
					getAllBill();
				} else {
					lbAlert.setForeground(Color.RED);
					lbAlert.setText("Không thể thêm hóa đơn!");
				}
			}
		});
		btnCapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mahd, tenkh, nguoiban, ngayban;
				mahd = (String) txtMahd.getText();
				tenkh = (String) cbKH.getSelectedItem();
				nguoiban = (String) cbNhanvien.getSelectedItem();
				ngayban = (String) txtNgay.getText();

				if (mahd.isEmpty() || tenkh.isEmpty() || nguoiban.isEmpty() || ngayban.isEmpty()) {
					lbAlert.setText("Vui lòng nhập đầy đủ thông tin!");
					lbAlert.setForeground(Color.red);
				} else {
					if (pb.updateBill(mahd, tenkh, nguoiban, ngayban)) {
						lbAlert.setText("Cập nhật hóa đơn thành công!");
						lbAlert.setForeground(Color.blue);
						Model.getDataVector().removeAllElements();
						Model.fireTableDataChanged();
						getAllBill();
					} else {
						lbAlert.setText("Cập nhật hóa đơn không thành công!");
						lbAlert.setForeground(Color.red);
					}
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mhd = (String) txtMahd.getText();
				if (JOptionPane.showConfirmDialog(null, "Do you delete this product?", "Question",
						JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					if (pb.delBill(mhd)) {
						Model.getDataVector().removeAllElements();
						Model.fireTableDataChanged();
						getAllBill();
						lbAlert.setForeground(Color.BLUE);
						lbAlert.setText("Delete successfull!");
					}
				}
			}
		});
	}

}

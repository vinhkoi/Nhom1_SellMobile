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

public class GUI_ChitietHD extends JFrame {

	private JPanel contentPane;
	private JTable tbCTHD;
	private JTextField txtSoluong;
	private JTextField txtGia;
	private double tongtien = 0;

	private Vector tbHeader = new Vector();
	private Vector tbRow = new Vector();
	private Vector tbContent = new Vector();
	private DefaultTableModel Model = new DefaultTableModel();
	private Vector<String> columns = new Vector<String>();
	private Vector<Vector<Object>> rows = new Vector<>();
	private Process_Bill pb = new Process_Bill();
	private JTextField txtM;
	private JTextField txtPrice;

	public void getBillInfo_byMaHD(String MaHD) {
		Model.setRowCount(0);
		ArrayList<Bill> ls = pb.getBillInfo_byMaHD(MaHD);
		for (int i = 0; i < ls.size(); i++) {
			Bill b = (Bill) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(b.getMaHD());
			tbRow.add(b.getTenSP());
			tbRow.add(b.getSoluong());
			tbRow.add(b.getGiaban());
			tbRow.add(b.getThanhtien());
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		tbCTHD.setModel(Model);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChitietHD frame = new GUI_ChitietHD();
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
	public GUI_ChitietHD() {
		setTitle("Cập nhật hóa đơn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 593, 245);
		contentPane.add(scrollPane);

		tbCTHD = new JTable();
		scrollPane.setViewportView(tbCTHD);
		tbCTHD.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 40, 593, 160);
		contentPane.add(panel_1);

		JLabel lblNewLabel_5 = new JLabel("Mã hóa đơn:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 9, 96, 27);
		panel_1.add(lblNewLabel_5);

		JButton btnTimkiem_1 = new JButton("Tìm kiếm");
		btnTimkiem_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimkiem_1.setBounds(420, 11, 140, 23);
		panel_1.add(btnTimkiem_1);

		JLabel lblinThoi = new JLabel("Tên sản phẩm:");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblinThoi.setBounds(10, 46, 96, 27);
		panel_1.add(lblinThoi);

		JComboBox cbDT = new JComboBox();
		cbDT.setBounds(130, 50, 257, 22);
		panel_1.add(cbDT);

		txtSoluong = new JTextField();
		txtSoluong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSoluong.setColumns(10);
		txtSoluong.setBounds(130, 91, 257, 20);
		panel_1.add(txtSoluong);

		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(10, 84, 96, 27);
		panel_1.add(lblSLng);

		JLabel lblGiBn = new JLabel("Giá bán:");
		lblGiBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiBn.setBounds(10, 122, 96, 27);
		panel_1.add(lblGiBn);

		txtGia = new JTextField();
		txtGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGia.setColumns(10);
		txtGia.setBounds(130, 129, 257, 20);
		panel_1.add(txtGia);

		JComboBox cbMaHD = new JComboBox();
		cbMaHD.setBounds(130, 13, 257, 22);
		panel_1.add(cbMaHD);

		JButton btnThemHD_1 = new JButton("Thêm");
		btnThemHD_1.setBounds(420, 50, 140, 23);
		panel_1.add(btnThemHD_1);
		btnThemHD_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnCapnhat_1 = new JButton("Cập nhật");
		btnCapnhat_1.setBounds(420, 90, 140, 23);
		panel_1.add(btnCapnhat_1);
		btnCapnhat_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnXoa_1 = new JButton("Xóa");
		btnXoa_1.setBounds(420, 124, 140, 23);
		panel_1.add(btnXoa_1);
		btnXoa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_4 = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(211, 0, 219, 38);
		contentPane.add(lblNewLabel_4);

		txtM = new JTextField();
		txtM.setBounds(365, 12, -1, 20);
		contentPane.add(txtM);
		txtM.setColumns(10);

		JButton btnTinh = new JButton("Tính");
		btnTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTinh.setBounds(415, 532, 89, 23);
		contentPane.add(btnTinh);

		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLammoi.setBounds(514, 532, 89, 23);
		contentPane.add(btnLammoi);

		JLabel lblNewLabel = new JLabel("Tổng tiền");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(373, 504, 67, 17);
		contentPane.add(lblNewLabel);

		txtPrice = new JTextField();
		txtPrice.setBounds(450, 501, 153, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		JLabel lbAlert = new JLabel("");
		lbAlert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbAlert.setBounds(10, 532, 328, 23);
		contentPane.add(lbAlert);

		tbCTHD.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = tbCTHD.getSelectedRow();
				cbMaHD.setSelectedItem((String) (Model.getValueAt(index, 0)));
				cbDT.setSelectedItem((String) (Model.getValueAt(index, 1)));
				txtM.setText(String.valueOf(Model.getValueAt(index, 1)));
				txtSoluong.setText(String.valueOf(Model.getValueAt(index, 2)));
				txtGia.setText(String.valueOf(Model.getValueAt(index, 3)));
			}
		});

		columns.add("Mã hóa đơn");
		columns.add("Tên sản phẩm");
		columns.add("Số lượng");
		columns.add("Giá bán");
		columns.add("Thành tiền");

		try {
			Process_Bill pb = new Process_Bill();
			Connection cn = pb.getCon();
			String sql = "select MaHD from tb_bill group by MaHD";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String mhd = rs.getString("MaHD");
				cbMaHD.addItem(mhd);
			}

		} catch (Exception e) {
			System.out.println("null");
		}

		try {
			Process_Bill pb = new Process_Bill();
			Connection cn = pb.getCon();
			String sql = "select Name from tb_phone group by Name";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String dt = rs.getString("Name");
				cbDT.addItem(dt);
			}

		} catch (Exception e) {
			System.out.println("null");
		}

		btnTimkiem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				String mah = String.valueOf(cbMaHD.getSelectedItem());
				getBillInfo_byMaHD(mah);
			}
		});

		btnXoa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mhd = (String) cbMaHD.getSelectedItem();
				String m = (String) txtM.getText();
				if (JOptionPane.showConfirmDialog(null, "Do you delete this product?", "Question",
						JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
					if (pb.delBillInfo(mhd, m)) {
						Model.getDataVector().removeAllElements();
						Model.fireTableDataChanged();
						getBillInfo_byMaHD(mhd);
						lbAlert.setForeground(Color.BLUE);
						txtM.setText("");
						txtSoluong.setText("");
						txtGia.setText("");
						lbAlert.setText("Xoa thanh cong!");
					} else {
						lbAlert.setForeground(Color.RED);
						lbAlert.setText("Xoa khong thanh cong!");
					}
				}
			}
		});

		btnCapnhat_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mahd, tensp, ma;
				int soluong;
				Double giaban, thanhtien;
				mahd = (String) cbMaHD.getSelectedItem();
				tensp = (String) cbDT.getSelectedItem();
				soluong = Integer.parseInt(txtSoluong.getText());
				giaban = Double.parseDouble(txtGia.getText());
				ma = (String) txtM.getText();
				thanhtien = soluong * giaban;

				if (mahd.isEmpty() || tensp.isEmpty() || soluong < 0 || giaban < 0) {
					lbAlert.setText("Vui lòng nhập đầy đủ thông tin!");
					lbAlert.setForeground(Color.red);
				} else {
					if (pb.updateBillInfo(mahd, tensp, soluong, giaban, thanhtien, ma)) {
						lbAlert.setText("Cập nhật hóa đơn thành công!");
						lbAlert.setForeground(Color.blue);
						Model.getDataVector().removeAllElements();
						Model.fireTableDataChanged();
						String mah = String.valueOf(cbMaHD.getSelectedItem());
						getBillInfo_byMaHD(mah);
					} else {
						lbAlert.setText("Cập nhật hóa đơn không thành công!");
						lbAlert.setForeground(Color.red);
					}
				}
			}
		});

		btnThemHD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mahd, tensp, ma;
				int soluong;
				Double giaban, thanhtien;
				mahd = (String) cbMaHD.getSelectedItem();
				tensp = (String) cbDT.getSelectedItem();
				soluong = Integer.parseInt(txtSoluong.getText());
				giaban = Double.parseDouble(txtGia.getText());
				thanhtien = soluong * giaban;
//				ma = (String) txtM.getText();

				if (pb.insertBillInfo(mahd, tensp, soluong, giaban, thanhtien)) {
					lbAlert.setForeground(Color.BLUE);
					lbAlert.setText("Thêm hóa đơn thành công!");
					Model.getDataVector().removeAllElements();
					Model.fireTableDataChanged();
					getBillInfo_byMaHD(mahd);
					tongtien += thanhtien;
					txtPrice.setText((String.valueOf(tongtien)));
				} else {
					lbAlert.setForeground(Color.RED);
					lbAlert.setText("Thêm hóa đơn không thành công!");
				}
			}
		});

		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				txtM.setText("");
				txtSoluong.setText("");
				txtGia.setText("");
				txtPrice.setText("");
				tongtien = 0;
				lbAlert.setText("");
			}
		});
		
	}
}

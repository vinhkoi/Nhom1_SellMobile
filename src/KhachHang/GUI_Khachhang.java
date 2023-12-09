package KhachHang;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Hoadon.GUI_Hoadon;

public class GUI_Khachhang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaKH;
	private JTextField txtTKH;
	private JTextField txtDC;
	private JTextField txtSDT;

	DefaultTableModel  Model =  new DefaultTableModel();
	Vector vctData= new Vector<>();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_KH kh = new Process_KH();
	
	public void getAllKH() {
		 ArrayList<khachHang> ls =  kh.loadData();
		 for(int i=0;i<ls.size();i++) {
			 khachHang k = (khachHang) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(k.getMakh());
			 tbRow.add(k.getHoten());
			 tbRow.add(k.getDiachi());
			 tbRow.add(k.getSdt());
			 
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
	 	
	}
	
	public void getMaKH(String makh) {
		Model.setRowCount(0);
		ArrayList<khachHang> ls = kh.getKH_byMaKH(makh);
		for(int i= 0; i<ls.size();i++) {
			 khachHang k = (khachHang) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(k.getMakh());
			 tbRow.add(k.getHoten());
			 tbRow.add(k.getDiachi());
			 tbRow.add(k.getSdt());
			 
			 rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table.setModel(Model);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Khachhang frame = new GUI_Khachhang();
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
	public GUI_Khachhang() {
		setTitle("Quản lý khách hàng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 754, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 274, 140, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 718, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow !=-1) {
					Vector<Object> row=rows.get(selectedRow);
					txtMaKH.setText(row.get(0).toString());
					txtTKH.setText(row.get(1).toString());
					txtDC.setText(row.get(2).toString());
					txtSDT.setText(row.get(3).toString());
				}
			}
		});
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				String CID = String.valueOf(txtMaKH.getText());
				getMaKH(CID);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(451, 274, 103, 30);
		contentPane.add(btnSearch);
		
		JLabel lblId = new JLabel("Tên Khách hàng");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(41, 315, 108, 30);
		contentPane.add(lblId);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(191, 278, 197, 27);
		contentPane.add(txtMaKH);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(41, 359, 48, 30);
		contentPane.add(lblaCh);
		
		txtTKH = new JTextField();
		txtTKH.setColumns(10);
		txtTKH.setBounds(191, 319, 197, 27);
		contentPane.add(txtTKH);
		
		JLabel lblDanhSchKhch = new JLabel("Danh sách khách hàng");
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDanhSchKhch.setBounds(10, 49, 187, 30);
		contentPane.add(lblDanhSchKhch);
		
		txtDC = new JTextField();
		txtDC.setColumns(10);
		txtDC.setBounds(191, 363, 197, 27);
		contentPane.add(txtDC);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(191, 407, 197, 27);
		contentPane.add(txtSDT);
		
		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSdt.setBounds(41, 407, 48, 30);
		contentPane.add(lblSdt);
		
		JLabel lbl_Them = new JLabel("");
		lbl_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Them.setBounds(656, 314, 140, 30);
		contentPane.add(lbl_Them);
		
		JLabel lbl_Sua = new JLabel("");
		lbl_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Sua.setBounds(656, 359, 140, 30);
		contentPane.add(lbl_Sua);
		
		JLabel lbl_Xoa = new JLabel("");
		lbl_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Xoa.setBounds(656, 407, 140, 30);
		contentPane.add(lbl_Xoa);
		
		JButton btnInsert = new JButton("Thêm");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				kh.insertKH(txtMaKH.getText(),txtTKH.getText(),txtDC.getText(),txtSDT.getText());
				if(kh.insertKH(txtMaKH.getText(),txtTKH.getText(),txtDC.getText(),txtSDT.getText())){
					lbl_Them.setText("Thành công");
					lbl_Them.setForeground(Color.BLUE);
					txtMaKH.setText(null);
					txtTKH.setText(null);
					txtDC.setText(null);
					txtSDT.setText(null);
				}else {
					lbl_Them.setText("Thất bại");
					lbl_Them.setForeground(Color.RED);
				}
				
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllKH();
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.setBounds(451, 315, 103, 30);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kh.updateKH(txtMaKH.getText(),txtTKH.getText(),txtDC.getText(),txtSDT.getText())) {
					lbl_Sua.setText("Thành công");
					lbl_Sua.setForeground(Color.blue);
					txtMaKH.setText(null);
					txtTKH.setText(null);
					txtDC.setText(null);
					txtSDT.setText(null);
					
					
				}else {
					lbl_Sua.setText("Thất bại");
					lbl_Sua.setForeground(Color.red);
					
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllKH();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(451, 359, 103, 30);
		contentPane.add(btnUpdate);
		
		JOptionPane jOP_Check= new javax.swing.JOptionPane();
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane,"Bạn có chắc muốn xóa?","Xóa",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					if(kh.delKH((String)txtMaKH.getText())){
						lbl_Xoa.setText("Thành công");
						lbl_Xoa.setForeground(Color.BLUE);
						txtMaKH.setText(null);
						txtTKH.setText(null);
						txtDC.setText(null);
						txtSDT.setText(null);
						
						getAllKH();
					}else {
						lbl_Xoa.setText("Thất bại");
						lbl_Xoa.setForeground(Color.RED);
						getAllKH();
					}
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllKH();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(451, 403, 103, 30);
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton("Làm mới");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtMaKH.setText(null);
				txtTKH.setText(null);
				txtDC.setText(null);
				txtSDT.setText(null);
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllKH();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.setBounds(578, 274, 103, 30);
		contentPane.add(btnReset);
		
		JLabel lblQunKKhch = new JLabel("QUẢN KÝ KHÁCH HÀNG");
		lblQunKKhch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunKKhch.setBounds(232, 11, 234, 30);
		contentPane.add(lblQunKKhch);
		
		
		
		columns.add("Mã khách hàng");
		columns.add("Họ và tên");

		columns.add("Địa chỉ");
		columns.add("SDT");

		
		getAllKH();;
	}
}

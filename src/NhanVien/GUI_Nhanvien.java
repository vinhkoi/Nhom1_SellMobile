package NhanVien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class GUI_Nhanvien extends JFrame {

	private JPanel contentPane;
	private JTextField txt_id;
	private JTable table;
	private JTextField txt_Namestaff;
	private JTextField txt_Tellstaff;
	private JTextField txt_Salarystaff;
	
	DefaultTableModel  Model =  new DefaultTableModel();
	Vector vctData= new Vector<>();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_NV pc = new Process_NV();
	private JTextField txt_Addressstaff;

	public void getAllStaff() {
		 ArrayList<NhanVien> ls =  pc.LoadData();
		 for(int i=0;i<ls.size();i++) {
			 NhanVien c = (NhanVien) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(c.getManv());
			 tbRow.add(c.getHoten());
			 tbRow.add(c.getDiachi());
			 tbRow.add(c.getLuong());
			 tbRow.add(c.getSdt());
			 
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 table.setModel(Model);
	 	
	}
	//Insert
	public void getID_Staff(String id_staff) {
		Model.setRowCount(0);
		ArrayList<NhanVien> ls = pc.getStaff_byID(id_staff);
		for(int i= 0; i<ls.size();i++) {
			 NhanVien c = (NhanVien) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(c.getManv());
			 tbRow.add(c.getHoten());
			 tbRow.add(c.getDiachi());
			 tbRow.add(c.getLuong());
			 tbRow.add(c.getSdt());
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
					GUI_Nhanvien frame = new GUI_Nhanvien();
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
	public GUI_Nhanvien() {
		setTitle("Quản lý nhân viên");
		setFont(new Font("Tahoma", Font.PLAIN, 15));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 702, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 268, 666, 240);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow !=-1) {
					Vector<Object> row=rows.get(selectedRow);
					txt_id.setText(row.get(0).toString());
					txt_Namestaff.setText(row.get(1).toString());
					txt_Addressstaff.setText(row.get(2).toString());
					txt_Salarystaff.setText(row.get(3).toString());
					txt_Tellstaff.setText(row.get(4).toString());
				}
			}
		});
		scrollPane.setViewportView(table);
//Insert
		JLabel lbl_Insert = new JLabel("");
		lbl_Insert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Insert.setBounds(631, 372, 138, 33);
		contentPane.add(lbl_Insert);
		
		JButton btnInsert = new JButton("Thêm");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				pc.insertStaff(txt_id.getText(), txt_Namestaff.getText(),txt_Addressstaff.getText(),txt_Tellstaff.getText(),Double.parseDouble(txt_Salarystaff.getText())); 
//				
				if(pc.insertStaff(txt_id.getText(), txt_Namestaff.getText(),txt_Addressstaff.getText(),Double.parseDouble(txt_Salarystaff.getText()),txt_Tellstaff.getText())) {
					lbl_Insert.setText("Thành công");
					lbl_Insert.setForeground(Color.blue);
					
				}
				else {
					lbl_Insert.setText("Thất bại");
					lbl_Insert.setForeground(Color.red);
					
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllStaff();
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.setBounds(40, 198, 113, 27);
		contentPane.add(btnInsert);
		//Update
		JLabel lbl_Update = new JLabel("");
		lbl_Update.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Update.setBounds(631, 415, 138, 27);
		contentPane.add(lbl_Update);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!pc.updateStaff(txt_id.getText(), txt_Namestaff.getText(),txt_Addressstaff.getText(),txt_Tellstaff.getText(),Double.parseDouble(txt_Salarystaff.getText()))) {
					lbl_Update.setText("Thất bại");
					lbl_Update.setForeground(Color.red);
					
				}else {
					lbl_Update.setText("Thành công");
					lbl_Update.setForeground(Color.blue);
					
					
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllStaff();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(201, 198, 113, 27);
		contentPane.add(btnUpdate);
		//Delete
		JLabel lbl_Delete = new JLabel("");
		lbl_Delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_Delete.setBounds(631, 454, 138, 33);
		contentPane.add(lbl_Delete);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane,"Do you want to delete this room ?","Delete",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					if(pc.delStaff((String)txt_id.getText())){
						lbl_Delete.setText("Thành công");
						lbl_Delete.setForeground(Color.BLUE);
						txt_id.setText(null);
						txt_Namestaff.setText(null);
						txt_Addressstaff.setText(null);
						txt_Salarystaff.setText(null);
						txt_Tellstaff.setText(null);
						
						getAllStaff();
					}else {
						lbl_Delete.setText("Thất bại");
						lbl_Delete.setForeground(Color.RED);
					}
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllStaff();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(365, 198, 113, 27);
		contentPane.add(btnDelete);
		
		JButton btnTrV = new JButton("Làm mới");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllStaff();
				txt_id.setText(null);
				txt_Namestaff.setText(null);
				txt_Addressstaff.setText(null);
				txt_Salarystaff.setText(null);
				txt_Tellstaff.setText(null);
			}
		});
		btnTrV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTrV.setBounds(527, 198, 113, 27);
		contentPane.add(btnTrV);
		
		JLabel lblDanhSchNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblDanhSchNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDanhSchNhn.setBounds(224, 11, 221, 33);
		contentPane.add(lblDanhSchNhn);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 666, 131);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setBounds(10, 7, 113, 33);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Họ Tên");
		lblName.setBounds(10, 45, 80, 33);
		panel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setBounds(10, 82, 80, 33);
		panel.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_Addressstaff = new JTextField();
		txt_Addressstaff.setBounds(121, 85, 189, 27);
		panel.add(txt_Addressstaff);
		txt_Addressstaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Addressstaff.setColumns(10);
		
		txt_Namestaff = new JTextField();
		txt_Namestaff.setBounds(121, 48, 189, 27);
		panel.add(txt_Namestaff);
		txt_Namestaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Namestaff.setColumns(10);
		
		txt_id = new JTextField();
		txt_id.setBounds(121, 10, 189, 27);
		panel.add(txt_id);
		txt_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_id.setColumns(10);
		
		JLabel lblTell = new JLabel("Số điện thoại");
		lblTell.setBounds(356, 45, 101, 33);
		panel.add(lblTell);
		lblTell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_Tellstaff = new JTextField();
		txt_Tellstaff.setBounds(467, 48, 189, 27);
		panel.add(txt_Tellstaff);
		txt_Tellstaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Tellstaff.setColumns(10);
		
		txt_Salarystaff = new JTextField();
		txt_Salarystaff.setBounds(467, 82, 189, 27);
		panel.add(txt_Salarystaff);
		txt_Salarystaff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Salarystaff.setColumns(10);
		
		JLabel lblSalary = new JLabel("Lương");
		lblSalary.setBounds(356, 79, 80, 33);
		panel.add(lblSalary);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBounds(356, 11, 157, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				String CID = String.valueOf(txt_id.getText());
				getID_Staff(CID);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 243, 226, 27);
		contentPane.add(lblNewLabel_1);
		
		
		columns.add("ID");
		columns.add("Tên");
		columns.add("Địa chỉ");
		columns.add("Lương");
		columns.add("SĐT");
		getAllStaff();


	}

}

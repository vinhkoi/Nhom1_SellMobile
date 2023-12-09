package Dienthoai;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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

public class GUI_Phone extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtAmount;

	
	private DefaultTableModel dtm = new DefaultTableModel();
	private Vector tbHeader = new Vector ();
	private Vector tbContent = new Vector ();
	private Process_Phone pp = new Process_Phone();
	private ArrayList<List_Phone> lss;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	
	public void getAllPhone () {
		tbContent = new Vector();
		lss = pp.getListPhone();
		for (int i = 0; i < lss.size();i++) {
			List_Phone p = (List_Phone) lss.get(i);
			Vector tbRow = new Vector();
			tbRow.add(p.getID_Phone());
			tbRow.add(p.getName());
			tbRow.add(p.getPrice());
			tbRow.add(p.getAmount());
			tbRow.add(p.getColor());
			tbContent.add(tbRow);
		}
		dtm.setDataVector(tbContent, tbHeader);
		table.setModel(dtm);
	}
	
	public void getPhoneByCompany(String company) {
		dtm.setRowCount(0);
		if (company == "All") {
			lss=pp.getListPhone();
		}else {
			lss=pp.getPhone_byIDCompany(company);
			tbContent = new Vector();
			for (int i=0; i<lss.size(); i++) {
				List_Phone p = (List_Phone) lss.get(i);
				Vector tbRow = new Vector();
				tbRow.add(p.getID_Phone());
				tbRow.add(p.getName());
				tbRow.add(p.getPrice());
				tbRow.add(p.getAmount());
				tbRow.add(p.getColor());
				tbContent.add(tbRow);
			}
			dtm.setDataVector(tbContent, tbHeader);
			table.setModel(dtm);
		}
	}
	
	public boolean checkdelPhone (String ID) {
		tbContent = new Vector();
		boolean check = pp.delPhone(ID);
		if (check) return true;
		return false;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Phone frame = new GUI_Phone();
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
	public GUI_Phone() {
		setTitle("Quản lý danh sách điện thoại");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 749, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCompany = new JLabel("Hãng sản xuất");
		lbCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbCompany.setBounds(76, 55, 107, 19);
		contentPane.add(lbCompany);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Tên điện thoại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(29, 407, 96, 19);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(135, 406, 163, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(135, 445, 163, 20);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Giá tiền");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(29, 446, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(381, 371, 56, 19);
		contentPane.add(lblNewLabel_3);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(469, 370, 173, 20);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);
		
		JComboBox cbColor = new JComboBox();
		cbColor.setModel(new DefaultComboBoxModel(new String[] {"","Đen", "Trắng", "Vàng", "Xám","Bạc","Xanh dương","Xanh lá","Hồng","Tím"}));
		cbColor.setBounds(469, 405, 173, 22);
		contentPane.add(cbColor);
		
		JComboBox cbCompany = new JComboBox();
		cbCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCompany.setModel(new DefaultComboBoxModel(new String[] {"All", "Samsung", "Apple","Oppo","Realme","Xiaomi","Asus","Lenovo"}));
		cbCompany.setBounds(207, 55, 299, 22);
		contentPane.add(cbCompany);
		
		
		JLabel lblNewLabel_4 = new JLabel("Màu sắc");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(379, 407, 58, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(381, 442, 282, 22);
		contentPane.add(lblNewLabel_6);
		
		JButton btnInsert = new JButton("Thêm");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = (String) txtID.getText();
				String name = (String) txtName.getText();
				double price = Double.parseDouble( txtPrice.getText());
				double amount = Double.parseDouble( txtAmount.getText());
				String color= (String) cbColor.getSelectedItem();
				String company = (String) cbCompany.getSelectedItem();
				if (ID.isEmpty() || name.isEmpty() || color.isEmpty() || price < 0 || amount <0) {
					lblNewLabel_6.setText("Vui lòng nhập đầy đủ thông tin");
					lblNewLabel_6.setForeground(Color.RED);
				}
				else {
					if (Process_Phone.insertPhone(ID, name, price,amount, color, company)) {;
					Process_Phone.getListPhone();
					lblNewLabel_6.setText("Thêm thành công!");
					lblNewLabel_6.setForeground(Color.BLUE);
					dtm.getDataVector().removeAllElements();
					dtm.fireTableDataChanged();
					getPhoneByCompany(company);
				}else {
					lblNewLabel_6.setText("Thêm thất bại!");
					lblNewLabel_6.setForeground(Color.RED);
					}
				}
			}
		});
		btnInsert.setBounds(115, 487, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = (String) txtID.getText();
				String name = (String) txtName.getText();
				double price = Double.parseDouble( txtPrice.getText());
				double amount = Double.parseDouble( txtAmount.getText());
				String color= (String) cbColor.getSelectedItem();
				String company = (String) cbCompany.getSelectedItem();
				if (ID.isEmpty() || name.isEmpty() || color.isEmpty() || price < 0 || amount <0) {
					lblNewLabel_6.setText("Vui lòng nhập đầy đủ thông tin");
					lblNewLabel_6.setForeground(Color.RED);
				}else {
					if(Process_Phone.updatePhone(ID, name, price, amount, color, company)) {
						lblNewLabel_6.setText("Chỉnh sửa thành công!");
						lblNewLabel_6.setForeground(Color.BLUE);
						dtm.getDataVector().removeAllElements();
						dtm.fireTableDataChanged();
						getPhoneByCompany(company);
					}else {
						lblNewLabel_6.setText("Chỉnh sửa thất bại!");
						lblNewLabel_6.setForeground(Color.RED);
					}
				}
			}
		});
		btnUpdate.setBounds(243, 487, 89, 23);
		contentPane.add(btnUpdate);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Danh sách điện thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(29, 85, 141, 20);
		contentPane.add(lblNewLabel_5);
		
		JButton btnClear = new JButton("Làm mới");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtName.setText("");
				txtPrice.setText("");
				txtAmount.setText("");
				cbColor.setSelectedIndex(0);
			}
		});
		btnClear.setBounds(503, 487, 96, 23);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("ID Phone");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(29, 373, 78, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(135, 370, 163, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		scrollPane.setBounds(10, 106, 713, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index != -1) {
					txtID.setText((String) dtm.getValueAt(index, 0));
					txtName.setText((String) dtm.getValueAt(index, 1));
					txtPrice.setText(String.valueOf(dtm.getValueAt(index, 2)));
					txtAmount.setText(String.valueOf(dtm.getValueAt(index, 3)));
					cbColor.setSelectedItem((String) dtm.getValueAt(index, 4));
				}
			}
		});
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String company = (String) cbCompany.getSelectedItem();
				if (company == "All") {
					getAllPhone();
				}else {
				getPhoneByCompany(company);
				}
			}
		});
		btnSearch.setBounds(553, 55, 89, 23);
		contentPane.add(btnSearch);
		

		
		JButton btnDelete = new JButton("Xoá");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String company = (String) cbCompany.getSelectedItem();
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?","Congfig",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					if(pp.delPhone(txtID.getText())) {		
						lblNewLabel_6.setText("Xoá thành công!");
						lblNewLabel_6.setForeground(Color.BLUE);
						dtm.getDataVector().removeAllElements();
						dtm.fireTableDataChanged();
						getPhoneByCompany(company);
					}else {
						lblNewLabel_6.setText("Xoá thất bại!");
						lblNewLabel_6.setForeground(Color.RED);
					}
				}
			}
		});
		
		btnDelete.setBounds(369, 487, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_7 = new JLabel("QUẢN LÝ DANH SÁCH ĐIỆN THOẠI");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(194, 11, 361, 33);
		contentPane.add(lblNewLabel_7);
		
		tbHeader.add("ID Phone");
		tbHeader.add("Tên điện thoại");
		tbHeader.add("Giá tiền");
		tbHeader.add("Số lượng");
		tbHeader.add("Màu sắc");
		
		
	}

}

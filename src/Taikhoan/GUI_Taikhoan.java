package Taikhoan;

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

public class GUI_Taikhoan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_User ps = new Process_User();
	private JScrollPane scrollPane;
	private JTextField textField_2;

	private void getAllUser() {
		ArrayList<User> ls = ps.GetListUser();
		for (int i = 0; i < ls.size(); i++) {
			User s = (User) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getID());
			tbRow.add(s.getUserName());
			tbRow.add(s.getPassword());
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
					GUI_Taikhoan frame = new GUI_Taikhoan();
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
	public GUI_Taikhoan() {
		setTitle("Quản lý tài khoản");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 585, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lbAlert = new JLabel("");
		lbAlert.setBounds(10, 427, 316, 20);
		contentPane.add(lbAlert);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Danh sách tài khoản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 204, 151, 21);
		contentPane.add(lblNewLabel_2);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 545, 182);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				textField_2.setText((String) Model.getValueAt(index, 0));
				textField.setText((String) Model.getValueAt(index, 1));
				textField_1.setText((String) Model.getValueAt(index, 2));
			}
		});

		JButton btnLammoi = new JButton("Làm mới");
		btnLammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllUser();
			}
		});
		btnLammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLammoi.setBounds(435, 421, 120, 26);
		contentPane.add(btnLammoi);

		JPanel panel = new JPanel();
		panel.setBounds(10, 63, 545, 130);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("Mã tài khoản");
		lblId.setBounds(33, 21, 102, 21);
		panel.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(33, 54, 102, 21);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setBounds(33, 86, 102, 21);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField = new JTextField();
		textField.setBounds(145, 57, 219, 19);
		panel.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(145, 24, 219, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(145, 89, 219, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(408, 86, 105, 21);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int kq = JOptionPane.showConfirmDialog(null, "Do you want to Delete ?", "Congfig",
						JOptionPane.YES_NO_OPTION);
				if (kq == 0) {
					if (ps.Delete((String) textField.getText())) {

						lbAlert.setText("Delete Sucessful");
						lbAlert.setForeground(Color.BLUE);
						textField.setText("");
						textField_1.setText("");
						getAllUser();
					}
				}
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllUser();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setBounds(408, 54, 105, 21);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName, PassWord, ID;
				ID = (String) textField_2.getText();
				UserName = (String) textField.getText();
				PassWord = (String) textField_1.getText();
				if (UserName.isEmpty() || PassWord.isEmpty()) {
					lbAlert.setText("Please enter information!");
					lbAlert.setForeground(Color.red);
				} else {
					if (ps.updateUser(ID, UserName, PassWord)) {
						lbAlert.setText("Update Sucessful");
						lbAlert.setForeground(Color.BLUE);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						Model.getDataVector().removeAllElements();
						Model.fireTableDataChanged();
						getAllUser();
					} else {
						lbAlert.setText("Update failed!");
						lbAlert.setForeground(Color.red);
					}
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBounds(408, 21, 105, 21);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName, PassWord, ID;
				ID = (String) textField_2.getText();
				UserName = (String) textField.getText();
				PassWord = (String) textField_1.getText();
				if (UserName.isEmpty() || PassWord.isEmpty() || ID.isEmpty()) {
					lbAlert.setText("Please enter information!");
					lbAlert.setForeground(Color.red);
				} else {
					if (ps.InsertUser(ID, UserName, PassWord)) {
						lbAlert.setText("Insert Sucessful");
						lbAlert.setForeground(Color.BLUE);
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						Model.getDataVector().removeAllElements();
						Model.fireTableDataChanged();
						getAllUser();
					} else {
						lbAlert.setText("Insert failed!");
						lbAlert.setForeground(Color.red);
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_4 = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(175, 11, 215, 41);
		contentPane.add(lblNewLabel_4);

		columns.add("Mã tài khoản");
		columns.add("Tài khoản");
		columns.add("Mật khẩu");
		getAllUser();
	}

}

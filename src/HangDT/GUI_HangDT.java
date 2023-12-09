package HangDT;

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

public class GUI_HangDT extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;

	private JTable table;
	DefaultTableModel Model = new DefaultTableModel();
	Vector vctData = new Vector<>();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_BrandMobile pc = new Process_BrandMobile();

	public void getAllBrandMobile() {
		ArrayList<BrandMobile> ls = pc.loadData();
		for (int i = 0; i < ls.size(); i++) {
			BrandMobile s = (BrandMobile) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getID_Company());
			tbRow.add(s.getName());

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
					GUI_HangDT frame = new GUI_HangDT();
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
	public GUI_HangDT() {
		setTitle("Quản lý hãng điện thoại");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 588);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JOptionPane jOP_Check = new javax.swing.JOptionPane();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 449, 241);
		contentPane.add(scrollPane);

		table = new JTable();
//		CLICK
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				txtID.setText(String.valueOf(Model.getValueAt(index, 0)));
				txtName.setText(String.valueOf(Model.getValueAt(index, 1)));
			}
		});
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel = new JPanel();
		panel.setBounds(10, 63, 449, 156);
		contentPane.add(panel);
		panel.setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(89, 21, 215, 26);
		panel.add(txtID);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setColumns(10);

		JLabel lblMCngTy = new JLabel("Mã hãng:");
		lblMCngTy.setBounds(10, 11, 83, 45);
		panel.add(lblMCngTy);
		lblMCngTy.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("Tên hãng:");
		lblNewLabel.setBounds(10, 90, 76, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtName = new JTextField();
		txtName.setBounds(89, 99, 215, 28);
		panel.add(txtName);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(328, 21, 111, 33);
		panel.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				pc.insertBrandMobile(txtID.getText(), txtName.getText()); 
				if (txtID.getText().isEmpty() || txtName.getText().isEmpty()) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Vui lòng nhập đầy đủ thông tin");

				} else {
					if (pc.insertBrandMobile(txtID.getText(), txtName.getText())) {
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Bạn đã thêm thành công");

					} else {
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Thêm thất bại");

					}
					Model.getDataVector().removeAllElements();
					Model.fireTableDataChanged();
					getAllBrandMobile();
				}

			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnSua = new JButton("Cập nhật");
		btnSua.setBounds(328, 62, 111, 33);
		panel.add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtID.getText().isEmpty() || txtName.getText().isEmpty()) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Vui lòng nhập đầy đủ thông tin");

				} else {
					if (pc.updateBrandMobile(txtID.getText(), txtName.getText())) {
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Bạn đã sửa thành công");

					} else {
						JFrame f = new JFrame();
						JOptionPane.showMessageDialog(f, "Sửa thất bại");

					}
				}

				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllBrandMobile();
			}

		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(328, 100, 111, 33);
		panel.add(btnXoa);

		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtID.getText().isEmpty() || txtName.getText().isEmpty()) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Vui lòng nhập đầy đủ thông tin cần xóa");

				} else {
					int result = JOptionPane.showConfirmDialog(contentPane, "Do you want to delete this room ?",
							"Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						if (pc.delBrandMobile((String) txtID.getText())) {

							txtID.setText(null);
							txtName.setText(null);

							getAllBrandMobile();
						}
					}
					Model.getDataVector().removeAllElements();
					Model.fireTableDataChanged();
					getAllBrandMobile();
				}

			}
			//
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.getDataVector().removeAllElements();
				Model.fireTableDataChanged();
				getAllBrandMobile();
				txtID.setText(null);
				txtName.setText(null);
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLmMi.setBounds(348, 505, 111, 33);
		contentPane.add(btnLmMi);

		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ HÃNG ĐIỆN THOẠI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(92, 11, 284, 27);
		contentPane.add(lblNewLabel_1);

		columns.add("ID_Company");
		columns.add("Name");
		getAllBrandMobile();
	}
}

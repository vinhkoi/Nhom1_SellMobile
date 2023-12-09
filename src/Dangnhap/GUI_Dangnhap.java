package Dangnhap;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Trangchu.GUI_Menu;
import Trangchu.GUI_MenuAdmin;

public class GUI_Dangnhap extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Dangnhap frame = new GUI_Dangnhap();
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
	public GUI_Dangnhap() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 26, 128, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 89, 104, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 139, 78, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(137, 93, 215, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(137, 143, 215, 23);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName = textField.getText();
                String PassWord = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_phone","root", "G1234567");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select UserName, PassWord from tb_user where UserName=? and PassWord=?");

                    st.setString(1, UserName);
                    st.setString(2, PassWord);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                    	if(UserName.equals("admin")) {
                    		dispose();
                    		GUI_MenuAdmin f = new GUI_MenuAdmin();
                    		f.show();
                    	}else {
                    		dispose();
                    		GUI_Menu f = new GUI_Menu();
                    		f.show();
                    	}
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Tài khoản hoặc mật khẩu không chính xác!");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
			}
		);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(121, 194, 128, 38);
		contentPane.add(btnNewButton);
	}

}

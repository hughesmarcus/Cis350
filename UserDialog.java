import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;


public class UserDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idField;
	private JTextField fNameField;
	private JTextField lNameField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField insurField;
	private JTextField specField;
	private JTextField usernameField;
	private JTextField passField;
	private DBAccess DB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserDialog dialog = new UserDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserDialog() {//for the add user button
		DB = new DBAccess();
		
		setTitle("Add User");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\silas\\Dropbox\\Silas\\Java\\MediApp2\\mediicon.jpg"));
		setAlwaysOnTop(true);
		setBounds(100, 100, 405, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUserType.setBounds(10, 12, 70, 20);
		contentPanel.add(lblUserType);
		
		JComboBox userTypeBox = new JComboBox();
		userTypeBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				heightField.setEnabled(false);
				weightField.setEnabled(false);
				insurField.setEnabled(false);
				specField.setEnabled(false);
				idField.setEnabled(false);
				fNameField.setEnabled(false);
				lNameField.setEnabled(false);
				usernameField.setEnabled(false);
				passField.setEnabled(false);
				if(userTypeBox.getSelectedItem() == "Patient")
				{
					heightField.setEnabled(true);
					weightField.setEnabled(true);
					insurField.setEnabled(true);
					idField.setEnabled(true);
					fNameField.setEnabled(true);
					lNameField.setEnabled(true);
					usernameField.setEnabled(true);
					passField.setEnabled(true);
				}
				else if(userTypeBox.getSelectedItem() == "Doctor")
				{
					specField.setEnabled(true);
					idField.setEnabled(true);
					fNameField.setEnabled(true);
					lNameField.setEnabled(true);
					usernameField.setEnabled(true);
					passField.setEnabled(true);
				}
				else if(userTypeBox.getSelectedItem() == "Admin")
				{
					
					idField.setEnabled(true);
					fNameField.setEnabled(true);
					lNameField.setEnabled(true);
					usernameField.setEnabled(true);
					passField.setEnabled(true);
				}
			}
		});
		userTypeBox.setModel(new DefaultComboBoxModel(new String[] {"", "Patient", "Doctor", "Admin"}));
		userTypeBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		userTypeBox.setBounds(75, 12, 100, 20);
		contentPanel.add(userTypeBox);
		{
			JLabel idLbl = new JLabel("ID:");
			idLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			idLbl.setBounds(190, 12, 30, 20);
			contentPanel.add(idLbl);
		}
		
		idField = new JTextField();
		idField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idField.setEnabled(false);
		idField.setBounds(220, 12, 90, 20);
		contentPanel.add(idField);
		idField.setColumns(10);
		
		JLabel fNameLbl = new JLabel("First Name:");
		fNameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fNameLbl.setBounds(10, 45, 70, 20);
		contentPanel.add(fNameLbl);
		
		fNameField = new JTextField();
		fNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fNameField.setEnabled(false);
		fNameField.setBounds(85, 45, 110, 20);
		contentPanel.add(fNameField);
		fNameField.setColumns(10);
		
		JLabel lNameLbl = new JLabel("Last Name:");
		lNameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lNameLbl.setBounds(200, 45, 70, 20);
		contentPanel.add(lNameLbl);
		
		lNameField = new JTextField();
		lNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lNameField.setEnabled(false);
		lNameField.setBounds(275, 45, 110, 20);
		contentPanel.add(lNameField);
		lNameField.setColumns(10);
		
		JLabel heightLbl = new JLabel("Height:");
		heightLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		heightLbl.setBounds(10, 78, 40, 20);
		contentPanel.add(heightLbl);
		
		heightField = new JTextField();
		heightField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		heightField.setEnabled(false);
		heightField.setBounds(55, 78, 90, 20);
		contentPanel.add(heightField);
		heightField.setColumns(10);
		
		JLabel weightLbl = new JLabel("Weight:");
		weightLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		weightLbl.setBounds(155, 79, 45, 20);
		contentPanel.add(weightLbl);
		
		weightField = new JTextField();
		weightField.setEnabled(false);
		weightField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		weightField.setBounds(205, 79, 90, 20);
		contentPanel.add(weightField);
		weightField.setColumns(10);
		
		JLabel insurLbl = new JLabel("Insurance:");
		insurLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		insurLbl.setBounds(10, 111, 60, 20);
		contentPanel.add(insurLbl);
		
		insurField = new JTextField();
		insurField.setEnabled(false);
		insurField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		insurField.setBounds(75, 109, 100, 20);
		contentPanel.add(insurField);
		insurField.setColumns(10);
		
		JLabel specLbl = new JLabel("Specialization:");
		specLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		specLbl.setBounds(180, 110, 80, 20);
		contentPanel.add(specLbl);
		
		specField = new JTextField();
		specField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		specField.setEnabled(false);
		specField.setBounds(265, 111, 100, 20);
		contentPanel.add(specField);
		specField.setColumns(10);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameLbl.setBounds(10, 144, 60, 20);
		contentPanel.add(usernameLbl);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameField.setEnabled(false);
		usernameField.setBounds(75, 144, 100, 20);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passLbl.setBounds(180, 144, 60, 20);
		contentPanel.add(passLbl);
		
		JLabel messageLbl = new JLabel("");
		
		passField = new JTextField();
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passField.setEnabled(false);
		passField.setBounds(245, 144, 100, 20);
		contentPanel.add(passField);
		passField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String type = (String) userTypeBox.getSelectedItem();
						if(type.equals("Doctor"))
						{
							type = "D";
						}
						else if(type.equals("Patient"))
						{
							type = "P";
						}
						else if(type.equals("Admin"))
						{
							type = "A";
						}
						String fName = fNameField.getText();
						String lName = lNameField.getText();
						String height = heightField.getText();
						int h = 0;
						String weight = weightField.getText();
						int w = 0;
						int id = 0;
						try
						{
							id = Integer.parseInt(idField.getText());
							if(type.equals("P"))
							{
								if(!weight.equals("") || !weight.equals(null))
								{
									w = Integer.parseInt(weight);
								}
								if(!height.equals("") || !height.equals(null))
								{
									h = Integer.parseInt(height);
								}
							}
						}catch(NumberFormatException e)
						{
							
						}
						String insurance = insurField.getText();
						String specialization = specField.getText();
						String username = usernameField.getText();
						String password = passField.getText();
						
						boolean suc = false;
						if(id < 999)
						{
							messageLbl.setText("Invalid User ID");
						}
						else
						{
							suc = DB.addUser(type, id, fName, lName, h, w, insurance, specialization, username, password);	
						}
						
						if(suc)
						{
							System.out.println("successful insert");
							//return a successful insert
							setVisible(false);
							idField.setText("");
							fNameField.setText("");
							lNameField.setText("");
							heightField.setText("");
							weightField.setText("");
							messageLbl.setText("");
							insurField.setText("");
							specField.setText("");
							usernameField.setText("");
							passField.setText("");
						}
						else
						{
							messageLbl.setText("Insert Failed");
						}
					}
				});
				buttonPane.add(messageLbl);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
						idField.setText("");
						fNameField.setText("");
						lNameField.setText("");
						heightField.setText("");
						weightField.setText("");
						messageLbl.setText("");
						insurField.setText("");
						specField.setText("");
						usernameField.setText("");
						passField.setText("");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public UserDialog(String type, int id, String fName, String lName, int h, int w, String insur, String spec, String un, String pass) {//for the edit user button
		setTitle("Edit User");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\silas\\Dropbox\\Silas\\Java\\MediApp2\\mediicon.jpg"));
		setAlwaysOnTop(true);
		setBounds(100, 100, 405, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel idLbl = new JLabel("ID:");
		idLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idLbl.setBounds(190, 12, 30, 20);
		contentPanel.add(idLbl);
		
		idField = new JTextField(Integer.toString(id));
		idField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		idField.setEnabled(true);
		idField.setBounds(220, 12, 90, 20);
		contentPanel.add(idField);
		idField.setColumns(10);
		
		JLabel fNameLbl = new JLabel("First Name:");
		fNameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fNameLbl.setBounds(10, 45, 70, 20);
		contentPanel.add(fNameLbl);
		
		fNameField = new JTextField(fName);
		fNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fNameField.setEnabled(true);
		fNameField.setBounds(85, 45, 110, 20);
		contentPanel.add(fNameField);
		fNameField.setColumns(10);
		
		JLabel lNameLbl = new JLabel("Last Name:");
		lNameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lNameLbl.setBounds(200, 45, 70, 20);
		contentPanel.add(lNameLbl);
		
		lNameField = new JTextField(lName);
		lNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lNameField.setEnabled(true);
		lNameField.setBounds(275, 45, 110, 20);
		contentPanel.add(lNameField);
		lNameField.setColumns(10);
		
		JLabel heightLbl = new JLabel("Height:");
		heightLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		heightLbl.setBounds(10, 78, 40, 20);
		contentPanel.add(heightLbl);
		
		heightField = new JTextField(Integer.toString(h));
		heightField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		heightField.setEnabled(false);
		heightField.setBounds(55, 78, 90, 20);
		contentPanel.add(heightField);
		heightField.setColumns(10);
		
		JLabel weightLbl = new JLabel("Weight:");
		weightLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		weightLbl.setBounds(155, 79, 45, 20);
		contentPanel.add(weightLbl);
		
		weightField = new JTextField(Integer.toString(w));
		weightField.setEnabled(false);
		weightField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		weightField.setBounds(205, 79, 90, 20);
		contentPanel.add(weightField);
		weightField.setColumns(10);
		
		JLabel insurLbl = new JLabel("Insurance:");
		insurLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		insurLbl.setBounds(10, 111, 60, 20);
		contentPanel.add(insurLbl);
		
		insurField = new JTextField(insur);
		insurField.setEnabled(false);
		insurField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		insurField.setBounds(75, 109, 100, 20);
		contentPanel.add(insurField);
		insurField.setColumns(10);
		
		JLabel specLbl = new JLabel("Specialization:");
		specLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		specLbl.setBounds(180, 110, 80, 20);
		contentPanel.add(specLbl);
		
		specField = new JTextField(spec);
		specField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		specField.setEnabled(false);
		specField.setBounds(265, 111, 100, 20);
		contentPanel.add(specField);
		specField.setColumns(10);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameLbl.setBounds(10, 144, 60, 20);
		contentPanel.add(usernameLbl);
		
		usernameField = new JTextField(un);
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		usernameField.setEnabled(true);
		usernameField.setBounds(75, 144, 100, 20);
		contentPanel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passLbl = new JLabel("Password:");
		passLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passLbl.setBounds(180, 144, 60, 20);
		contentPanel.add(passLbl);
		
		passField = new JTextField(pass);
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passField.setEnabled(true);
		passField.setBounds(245, 144, 100, 20);
		contentPanel.add(passField);
		passField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		if(type.equals("P"))
		{
			heightField.setEnabled(true);
			weightField.setEnabled(true);
			insurField.setEnabled(true);
		}
		else if(type.equals("D"))
		{
			specField.setEnabled(true);
		}
	}
	
}


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.*;
import javax.swing.border.*;
import java.io.File;

class GUIApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    JFrame frame = new MyFrame();
                    frame.setVisible(true);
                }
            }
        );
    }
}

class MyFrame extends JFrame {
    int price;
    HotelManager hm;
    String customer_name;
    String phone_number;
    int room_number;
    String email_address;
    int num_of_nights;
    String check_in_date;
    String room_type;
    
    JPanel all_reservation_container;
    JPanel reservations_button_panel;
    JPanel reservation_area_panel;
    JPanel all_reservations_panel;
    JTextArea reservation_area;
    JButton all_reservations_button;
    JButton clear_reservations_button;
    
    JPanel tab1_outer_panel;
    JPanel tab1_inner_panel1;
    JPanel tab1_inner_panel2;
    JPanel tab1_inner_panel3;
    JPanel tab1_inner_panel4;
    JPanel tab1_inner_panel5;
    JPanel tab1_inner_panel6;
    
    JPanel textfieldpanel1;
    JPanel textfieldpanel2;
    JPanel textfieldpanel3;
    JPanel textfieldpanel4;
    JPanel textfieldpanel5;
    JPanel textfieldpanel6;
    
    JPanel tab1_button_panel;
    JPanel tab1_button_container;
    
    JLabel tab1_personal = new JLabel("Personal Information:");
    JLabel tab1_reservation = new JLabel("Reservation Information:");
    
    JLabel tab1_name_label = new JLabel("   Name:");
    JLabel tab1_phone_label = new JLabel("Phone #:");
    JLabel tab1_email_label = new JLabel("  E-Mail:");
    
    JLabel tab1_type_label = new JLabel("      Type of Room:");
    JLabel tab1_nights_label = new JLabel("Number of Nights:");
    JLabel tab1_date_label = new JLabel(" Date of Check-In:");
    
    JTextField tab1_name_field;
    JTextField tab1_phone_field;
    JTextField tab1_email_field;
    JTextField tab1_type_field;
    JTextField tab1_nights_field;
    JTextField tab1_date_field;
    
    JButton tab1_submit;
    JButton tab1_clear;
    //END TAB 1
    ///////////////////
    JPanel buttonPanel;
    String[] options = {"Select a Date", "1/1/2014", "1/2/2014"
, "1/3/2014", "1/4/2014", "1/5/2014", "1/6/2014", "1/7/2014", "1/8/2014", "1/9/2014", "1/10/2014", "1/11/2014", "1/12/2014"
, "1/13/2014", "1/14/2014", "1/15/2014", "1/16/2014", "1/17/2014", "1/18/2014", "1/19/2014", "1/20/2014", "1/21/2014", "1/22/2014"
, "1/23/2014", "1/24/2014", "1/25/2014", "1/26/2014", "1/27/2014", "1/28/2014", "1/29/2014", "1/30/2014", "1/31/2014", "2/1/2014"
, "2/2/2014", "2/3/2014", "2/4/2014", "2/5/2014", "2/6/2014", "2/7/2014", "2/8/2014", "2/9/2014", "2/10/2014", "2/11/2014"
, "2/12/2014", "2/13/2014", "2/14/2014", "2/15/2014", "2/16/2014", "2/17/2014", "2/18/2014", "2/19/2014", "2/20/2014", "2/21/2014"
, "2/22/2014", "2/23/2014", "2/24/2014", "2/25/2014", "2/26/2014", "2/27/2014", "2/28/2014", "3/1/2014", "3/2/2014", "3/3/2014"
, "3/4/2014", "3/5/2014", "3/6/2014", "3/7/2014", "3/8/2014", "3/9/2014", "3/10/2014", "3/11/2014", "3/12/2014", "3/13/2014"
, "3/14/2014", "3/15/2014", "3/16/2014", "3/17/2014", "3/18/2014", "3/19/2014", "3/20/2014", "3/21/2014", "3/22/2014", "3/23/2014"
, "3/24/2014", "3/25/2014", "3/26/2014", "3/27/2014", "3/28/2014", "3/29/2014", "3/30/2014", "3/31/2014", "4/1/2014", "4/2/2014"
, "4/3/2014", "4/4/2014", "4/5/2014", "4/6/2014", "4/7/2014", "4/8/2014", "4/9/2014", "4/10/2014", "4/11/2014", "4/12/2014"
, "4/13/2014", "4/14/2014", "4/15/2014", "4/16/2014", "4/17/2014", "4/18/2014", "4/19/2014", "4/20/2014", "4/21/2014", "4/22/2014"
, "4/23/2014", "4/24/2014", "4/25/2014", "4/26/2014", "4/27/2014", "4/28/2014", "4/29/2014", "4/30/2014", "5/1/2014", "5/2/2014"
, "5/3/2014", "5/4/2014", "5/5/2014", "5/6/2014", "5/7/2014", "5/8/2014", "5/9/2014", "5/10/2014", "5/11/2014", "5/12/2014"
, "5/13/2014", "5/14/2014", "5/15/2014", "5/16/2014", "5/17/2014", "5/18/2014", "5/19/2014", "5/20/2014", "5/21/2014", "5/22/2014"
, "5/23/2014", "5/24/2014", "5/25/2014", "5/26/2014", "5/27/2014", "5/28/2014", "5/29/2014", "5/30/2014", "5/31/2014", "6/1/2014"
, "6/2/2014", "6/3/2014", "6/4/2014", "6/5/2014", "6/6/2014", "6/7/2014", "6/8/2014", "6/9/2014", "6/10/2014", "6/11/2014"
, "6/12/2014", "6/13/2014", "6/14/2014", "6/15/2014", "6/16/2014", "6/17/2014", "6/18/2014", "6/19/2014", "6/20/2014", "6/21/2014"
, "6/22/2014", "6/23/2014", "6/24/2014", "6/25/2014", "6/26/2014", "6/27/2014", "6/28/2014", "6/29/2014", "6/30/2014", "7/1/2014"
, "7/2/2014", "7/3/2014", "7/4/2014", "7/5/2014", "7/6/2014", "7/7/2014", "7/8/2014", "7/9/2014", "7/10/2014", "7/11/2014"
, "7/12/2014", "7/13/2014", "7/14/2014", "7/15/2014", "7/16/2014", "7/17/2014", "7/18/2014", "7/19/2014", "7/20/2014", "7/21/2014"
, "7/22/2014", "7/23/2014", "7/24/2014", "7/25/2014", "7/26/2014", "7/27/2014", "7/28/2014", "7/29/2014", "7/30/2014", "7/31/2014"
, "8/1/2014", "8/2/2014", "8/3/2014", "8/4/2014", "8/5/2014", "8/6/2014", "8/7/2014", "8/8/2014", "8/9/2014", "8/10/2014"
, "8/11/2014", "8/12/2014", "8/13/2014", "8/14/2014", "8/15/2014", "8/16/2014", "8/17/2014", "8/18/2014", "8/19/2014", "8/20/2014"
, "8/21/2014", "8/22/2014", "8/23/2014", "8/24/2014", "8/25/2014", "8/26/2014", "8/27/2014", "8/28/2014", "8/29/2014", "8/30/2014"
, "8/31/2014", "9/1/2014", "9/2/2014", "9/3/2014", "9/4/2014", "9/5/2014", "9/6/2014", "9/7/2014", "9/8/2014", "9/9/2014"
, "9/10/2014", "9/11/2014", "9/12/2014", "9/13/2014", "9/14/2014", "9/15/2014", "9/16/2014", "9/17/2014", "9/18/2014", "9/19/2014"
, "9/20/2014", "9/21/2014", "9/22/2014", "9/23/2014", "9/24/2014", "9/25/2014", "9/26/2014", "9/27/2014", "9/28/2014", "9/29/2014"
, "9/30/2014", "10/1/2014", "10/2/2014", "10/3/2014", "10/4/2014", "10/5/2014", "10/6/2014", "10/7/2014", "10/8/2014", "10/9/2014"
, "10/10/2014", "10/11/2014", "10/12/2014", "10/13/2014", "10/14/2014", "10/15/2014", "10/16/2014", "10/17/2014", "10/18/2014", "10/19/2014"
, "10/20/2014", "10/21/2014", "10/22/2014", "10/23/2014", "10/24/2014", "10/25/2014", "10/26/2014", "10/27/2014", "10/28/2014", "10/29/2014"
, "10/30/2014", "10/31/2014", "11/1/2014", "11/2/2014", "11/3/2014", "11/4/2014", "11/5/2014", "11/6/2014", "11/7/2014", "11/8/2014"
, "11/9/2014", "11/10/2014", "11/11/2014", "11/12/2014", "11/13/2014", "11/14/2014", "11/15/2014", "11/16/2014", "11/17/2014", "11/18/2014"
, "11/19/2014", "11/20/2014", "11/21/2014", "11/22/2014", "11/23/2014", "11/24/2014", "11/25/2014", "11/26/2014", "11/27/2014", "11/28/2014"
, "11/29/2014", "11/30/2014", "12/1/2014", "12/2/2014", "12/3/2014", "12/4/2014", "12/5/2014", "12/6/2014", "12/7/2014", "12/8/2014"
, "12/9/2014", "12/10/2014", "12/11/2014", "12/12/2014", "12/13/2014", "12/14/2014", "12/15/2014", "12/16/2014", "12/17/2014", "12/18/2014"
, "12/19/2014", "12/20/2014", "12/21/2014", "12/22/2014", "12/23/2014", "12/24/2014", "12/25/2014", "12/26/2014", "12/27/2014", "12/28/2014"
, "12/29/2014", "12/30/2014", "12/31/2014"};
    
    String[] options1 = {"Select a Room Type", "Single - $29.99", "Double - $39.99", 
    "Suite - $49.99", "Honeymoon Suite - $44.99"};
    JPanel new_reservation;
    JComboBox datebox;
    JComboBox typebox;
    JPanel cancel_reservation;
    JTextArea textArea;
    JButton reservation_button;
    JButton verify_button;
    JButton cancel_button;
    JButton clear_button;
    JLabel label;
    JPanel vert_button_panel;
    JScrollPane scroll;
    
    JButton select;
    JLabel name_label = new JLabel("   Name:");
    JLabel room_label = new JLabel("Room #:");
    JLabel phone_label = new JLabel("Phone #:");
    
    
    JTabbedPane tabbedPane;

    JTextField room_num;
    JTextField phone;
    JTextField name;
    
    JPanel reservation_field_panel;
    JLabel verify_label = new JLabel("Please fill the following fields:");
    JPanel label_panel;
    JPanel label_panel_1;
    JPanel label_panel_2;
    JButton res_conf_button;
    JButton res_canc_button;
    JPanel res_button_panel;
    JPanel res_container_panel;
    public MyFrame() {
        hm = new HotelManager();
        
        customer_name = "";
        phone_number = "";
        room_number = 0;
        email_address = "";
        num_of_nights = 0;
        check_in_date = "";
        room_type = "";
        
        int screenWidth = 775;
        int screenHeight = 500;
        setTitle("Hotel Reservation System");
        pack();
        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent e) {
                    hm.close();
                    System.exit(0); 
                }
            }
        );
        reservation_field_panel = new JPanel();
        label_panel = new JPanel();
        label_panel_1 = new JPanel();
        label_panel_2 = new JPanel();
        res_button_panel = new JPanel();
        res_container_panel = new JPanel();
        vert_button_panel = new JPanel();
        vert_button_panel.setLayout(new GridLayout(3,1));
        
        phone = new JTextField(20);
        phone.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                phone_number = phone.getText();
            }
            public void removeUpdate(DocumentEvent e) {
                phone_number = phone.getText();
            }
            public void insertUpdate(DocumentEvent e) {
                phone_number = phone.getText();
            }
        }
        );
        
        name = new JTextField(20);
        name.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                customer_name = name.getText();
            }
            public void removeUpdate(DocumentEvent e) {
                customer_name = name.getText();
            }
            public void insertUpdate(DocumentEvent e) {
                customer_name = name.getText();
            }
        }
        );
        
        room_num = new JTextField(20);
        room_num.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (!room_num.getText().equals("")) {
                    try {
                        room_number = Integer.parseInt(room_num.getText());
                    }
                    catch (Exception ex) {}
                }
            }
            public void removeUpdate(DocumentEvent e) {
                if (!room_num.getText().equals("")) {
                    try {
                        room_number = Integer.parseInt(room_num.getText());
                    }
                    catch (Exception ex) {}
                }
            }
            public void insertUpdate(DocumentEvent e) {
                if (!room_num.getText().equals("")) {
                    try {
                        room_number = Integer.parseInt(room_num.getText());
                    }
                    catch (Exception ex) {}
                }
            }
        }
        );

        
        reservation_field_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        reservation_field_panel.setLayout(new GridLayout(3,1));
        
        
        label_panel.add(name_label);
        label_panel.add(name);
        
        label_panel_1.add(room_label);
        label_panel_1.add(room_num);
        
        label_panel_2.add(phone_label);
        label_panel_2.add(phone);
        
        reservation_field_panel.add(label_panel);
        reservation_field_panel.add(label_panel_1);
        reservation_field_panel.add(label_panel_2);
        
        clear_button = new JButton("Clear All");
        clear_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                room_num.setText("");
                phone.setText("");
                textArea.setText("");
            }
        }
        );
        
        res_conf_button = new JButton("Verify");
        res_conf_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reservation temp = hm.getReservation(customer_name, phone_number, room_number);
                if (temp != null) {
                    textArea.setText(temp.getInfo());
                } else {
                    textArea.setText("Reservation Not Found!");
                }
            }
        }
        );
        
        res_canc_button = new JButton("Delete");
        res_canc_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this reservation?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == JOptionPane.YES_OPTION) {
                    Reservation temp = hm.getReservation(customer_name, phone_number, room_number);
                    if (temp != null) {
                        hm.deleteReservation(temp);
                        textArea.setText("Reservation Deleted!");
                        name.setText("");
                        phone.setText("");
                        room_num.setText("");
                    } else {
                        textArea.setText("Reservation Not Found!");
                    }
                }
            }
        }
        );
               
        vert_button_panel.add(res_conf_button);
        vert_button_panel.add(res_canc_button);
        vert_button_panel.add(clear_button);
        res_button_panel.add(vert_button_panel);
        res_button_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        textArea = new JTextArea(18,60);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.gray));
        res_container_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        res_container_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        res_container_panel.add(verify_label);
        res_container_panel.add(reservation_field_panel);
        res_container_panel.add(res_button_panel);
        res_container_panel.add(textArea);
        
        
        //END TAB 2 
        
        
        textfieldpanel1 = new JPanel();
        textfieldpanel2 = new JPanel();
        textfieldpanel3 = new JPanel();
        textfieldpanel4 = new JPanel();
        textfieldpanel5 = new JPanel();
        textfieldpanel6 = new JPanel();
        
        tab1_button_panel = new JPanel();
        tab1_button_container = new JPanel();
        
        tab1_inner_panel6 = new JPanel();
        tab1_inner_panel5 = new JPanel();
        tab1_inner_panel4 = new JPanel();
        tab1_inner_panel3 = new JPanel();
        tab1_inner_panel2 = new JPanel();
        tab1_inner_panel1 = new JPanel();
        tab1_outer_panel = new JPanel();
        
        tab1_name_field = new JTextField(20);
        tab1_name_field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                customer_name = tab1_name_field.getText();
            }
            public void removeUpdate(DocumentEvent e) {
                customer_name = tab1_name_field.getText();
            }
            public void insertUpdate(DocumentEvent e) {
                customer_name = tab1_name_field.getText();
            }
        }
        );
        
        tab1_phone_field = new JTextField(20);
        tab1_phone_field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                phone_number = tab1_phone_field.getText();
            }
            public void removeUpdate(DocumentEvent e) {
                phone_number = tab1_phone_field.getText();
            }
            public void insertUpdate(DocumentEvent e) {
                phone_number = tab1_phone_field.getText();
            }
        }
        );
        
        tab1_email_field = new JTextField(20);
        tab1_email_field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                email_address = tab1_email_field.getText();
            }
            public void removeUpdate(DocumentEvent e) {
                email_address = tab1_email_field.getText();
            }
            public void insertUpdate(DocumentEvent e) {
                email_address = tab1_email_field.getText();
            }
        }
        );
        
        typebox = new JComboBox(options1);
        typebox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp = (String)typebox.getSelectedItem();
                String[] arr = temp.split(" - ");
                room_type = arr[0];
            }
        }
        );
        
        datebox = new JComboBox(options);
        datebox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                check_in_date = (String)datebox.getSelectedItem();
            }
        }
        );
        
        tab1_nights_field = new JTextField(10);
        tab1_nights_field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (!tab1_nights_field.getText().equals("")) {
                    try {
                        num_of_nights = Integer.parseInt(tab1_nights_field.getText());
                    } 
                    catch (Exception ex) {}
                }
            }
            public void removeUpdate(DocumentEvent e) {
                if (!tab1_nights_field.getText().equals("")) {
                    try {
                        num_of_nights = Integer.parseInt(tab1_nights_field.getText());
                    } 
                    catch (Exception ex) {}
                }
            }
            public void insertUpdate(DocumentEvent e) {
                if (!tab1_nights_field.getText().equals("")) {
                    try {
                        num_of_nights = Integer.parseInt(tab1_nights_field.getText());
                    } 
                    catch (Exception ex) {}
                }
            }
        }
        );
        
        tab1_submit = new JButton("Check Availability");
        tab1_submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] arr;
                String message = "Soonest Available Reservation: ";
                arr = hm.nextAvailable(room_type, check_in_date, 7, num_of_nights).split(":");
                message += arr[1] + "\n" + "Confirm?";
                Object[] options = { "OK", "CANCEL" };
                int i = JOptionPane.showConfirmDialog(null, message, "Confirm Reservation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (i == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, hm.addReservation(customer_name, phone_number, email_address,
                    room_type, check_in_date, num_of_nights));
                }
            }
        }
        );
        tab1_clear = new JButton("Clear All");
        tab1_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                datebox.setSelectedItem("Select a Date");
                typebox.setSelectedItem("Select a Room Type");
                tab1_email_field.setText("");
                tab1_name_field.setText("");
                tab1_phone_field.setText("");
                tab1_nights_field.setText("");
            }
        }
        );
        
        textfieldpanel1.add(tab1_name_label);
        textfieldpanel1.add(tab1_name_field);
        
        textfieldpanel2.add(tab1_phone_label);
        textfieldpanel2.add(tab1_phone_field);
        
        textfieldpanel3.add(tab1_email_label);
        textfieldpanel3.add(tab1_email_field);
        
        tab1_inner_panel2.setLayout(new GridLayout(3,1));
        tab1_inner_panel2.add(textfieldpanel1);
        tab1_inner_panel2.add(textfieldpanel2);
        tab1_inner_panel2.add(textfieldpanel3);
        tab1_inner_panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
        tab1_inner_panel1.add(tab1_inner_panel2);
        
        tab1_inner_panel3.add(tab1_personal);
        tab1_inner_panel3.add(tab1_inner_panel1);
        
        textfieldpanel4.add(tab1_type_label);
        textfieldpanel4.add(typebox);
        
        
        textfieldpanel5.add(tab1_nights_label);
        textfieldpanel5.add(tab1_nights_field);
        
        
        textfieldpanel6.add(tab1_date_label);
        textfieldpanel6.add(datebox);
        
        tab1_inner_panel4.setLayout(new GridLayout(3,1));
        tab1_inner_panel4.add(textfieldpanel4);
        tab1_inner_panel4.add(textfieldpanel6);
        tab1_inner_panel4.add(textfieldpanel5);
        
        tab1_inner_panel4.setBorder(BorderFactory.createLineBorder(Color.gray));
        tab1_inner_panel5.add(tab1_inner_panel4);
        tab1_inner_panel6.add(tab1_reservation);
        tab1_inner_panel6.add(tab1_inner_panel5);
        
        tab1_button_panel.add(tab1_submit);
        tab1_button_panel.add(tab1_clear);
        tab1_button_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        tab1_button_container.add(tab1_button_panel);
        
        tab1_outer_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        tab1_outer_panel.add(tab1_inner_panel3);
        tab1_outer_panel.add(tab1_inner_panel6);
        tab1_outer_panel.add(tab1_button_container);
        
        //END TAB 1
        
        all_reservation_container = new JPanel();
        reservation_area_panel = new JPanel();
        reservations_button_panel = new JPanel();
        all_reservations_panel = new JPanel();
        reservation_area = new JTextArea(22, 60);
        reservation_area.setEditable(false);
        reservation_area.setBorder(BorderFactory.createLineBorder(Color.gray));
        scroll = new JScrollPane(reservation_area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
        reservation_area_panel.add(scroll);
        
        all_reservations_button = new JButton("View All Reservations");
        all_reservations_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reservation_area.setText(hm.displayReservationList());
            }
        }
        );
        
        clear_reservations_button = new JButton("Clear All");
        clear_reservations_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reservation_area.setText("");
            }
        }
        );
        
        reservations_button_panel.add(all_reservations_button);
        reservations_button_panel.add(clear_reservations_button);
        reservations_button_panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        
        all_reservations_panel.add(reservations_button_panel);
        all_reservation_container.add(all_reservations_panel);
        all_reservation_container.add(reservation_area_panel);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("New Reservation", null, tab1_outer_panel, "Make a new reservation");
        tabbedPane.addTab("Verify/Delete Reservation", null, res_container_panel, "Verify or delete reservation");
        tabbedPane.addTab("View All Reservations", null, all_reservation_container, "View all reservations");
        
        add(tabbedPane, BorderLayout.CENTER);
    }
}
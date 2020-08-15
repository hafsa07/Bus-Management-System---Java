import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Bus_Management_System {

    // Objects

    static JFrame frame = new JFrame("BMS Hafsa Muhammad");
    static JPanel panel;
    static JButton button1,button2,button3,button4,button5,button6,button7,button8;
    static JLabel label1,label2,label3,label4,label5;
    static JTextField textField1,textField2,textField3,textField4,textField5;
    static JRadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6;

    // globals

    public static boolean gujrat[][] = new boolean[3][20];
    public static boolean multan[][] = new boolean[3][20];
    public static boolean lahore[][] = new boolean[3][20];
    public static long t;     // time
    public static int customers=0;
    public static long balance=0;
    public static boolean b;
    public static String name,pass;

    public static Color color = new Color(74,201,180);
    public static Color colorbuttonbc = new Color(65,96,157);

    // main menu

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(575,300);
        frame.setResizable(false);

        // making aall array false

        for (int r =0;r<3;r++){
            for (int c = 0 ; c<20;c++){
                gujrat[r][c]=false;
                multan[r][c]=false;
                lahore[r][c]=false;
            }
        }

        //############################################################## login file handling

        try {
            File f = new File("login.txt");
            if (!f.exists()) {
                f.createNewFile();
                PrintWriter pw = new PrintWriter(f);
                pw.println("harry");
                pw.println("hafsu");
                pw.close();
            }
        } catch (Exception e){}

        //##############################################################

        Login();
    }

    public static void Login() {

        //making panel
        panel = new JPanel();           panel.setBackground(color);
        panel.setLayout(null);

        //adding panel
        frame.add(panel);

        //creating objects
        label1 = new JLabel("Username");
        textField1 = new JTextField();          textField1.setBackground(Color.white);

        label2 = new JLabel("Password");
        textField2 = new JTextField();          textField1.setBackground(Color.white);

        button1 = new JButton("Login");     button1.setBackground(colorbuttonbc);       button1.setForeground(Color.white);

        //adding elements
        panel.add(label1);
        panel.add(textField1);

        panel.add(label2);
        panel.add(textField2);

        panel.add(button1);

        //setting location
        label1.setBounds(130,80,70,20);
        textField1.setBounds(230,80,150,20);

        label2.setBounds(130,110,70,20);
        textField2.setBounds(230,110,150,20);

        button1.setBounds(130,140,70,25);

        //############################################################## get username and pass from user

        try {
            File f = new File("login.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            name = br.readLine();
            pass = br.readLine();
            br.close();
        }catch (Exception e){}

        //##############################################################

        //making action to login button
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    if (textField1.getText().equals(name) && textField2.getText().equals(pass)){
                        Main_Menu();
                    }
                    else if (!textField1.getText().equals(name) && !textField2.getText().equals(pass)){
                        textField1.setBackground(Color.pink);
                        textField2.setBackground(Color.pink);
                    }
                    else if (textField1.getText().equals(name) && !textField2.getText().equals(pass)){
                        textField2.setBackground(Color.pink);
                    }
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
    }

    // PANNELS          ################################################################################################

    public static void Main_Menu_Panel() {

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();           panel.setBackground(color);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Book");
        button2 = new JButton("Cancel");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");
        button6 = new JButton("Change pass and username");

        label1 = new JLabel("Bus Management System");
        label2 = new JLabel("Hafsa Muhammad");

        //colors for main menu items
        button1.setBackground(colorbuttonbc);   button1.setForeground(Color.white);
        button2.setBackground(colorbuttonbc);   button2.setForeground(Color.white);
        button3.setBackground(colorbuttonbc);   button3.setForeground(Color.white);
        button4.setBackground(colorbuttonbc);   button4.setForeground(Color.white);
        button5.setBackground(colorbuttonbc);   button5.setForeground(Color.white);
        button6.setBackground(colorbuttonbc);   button6.setForeground(Color.white);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        panel.add(label1);
        panel.add(label2);

        //setting location
        button1.setBounds(20,20,100,25);
        button2.setBounds(20,70,100,25);
        button3.setBounds(20,120,100,25);
        button4.setBounds(20,170,100,25);
        button5.setBounds(20,220,100,25);
        button6.setBounds(230,200,200,25);

        label1.setBounds(260,80,300,50);
        label2.setBounds(280,   120,300,50);
    }

    public static void Book_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();           panel.setBackground(color);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Book");
        button2 = new JButton("Cancel");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");

        radioButton1 = new JRadioButton("Gujrat");
        radioButton2 = new JRadioButton("Multan");
        radioButton3 = new JRadioButton("Lahore");

        radioButton4 = new JRadioButton("Standard");
        radioButton5 = new JRadioButton("Executive");
        radioButton6 = new JRadioButton("Bussiness");

        ButtonGroup bt1 = new ButtonGroup();
        bt1.add(radioButton1);bt1.add(radioButton2);bt1.add(radioButton3);

        ButtonGroup bt2 = new ButtonGroup();
        bt2.add(radioButton4);bt2.add(radioButton5);bt2.add(radioButton6);


        label1 = new JLabel("Available Seat");
        label2 = new JLabel("Name");
        label3 = new JLabel("Date");
        label4 = new JLabel("CNIC");
        label5 = new JLabel("Price");

        textField1 = new JTextField();              textField1.setEditable(false);
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();

        button6 = new JButton("Check");         button6.setBackground(colorbuttonbc);       button6.setForeground(Color.white);    button6.setEnabled(false);
        button7 = new JButton("Book");          button7.setBackground(colorbuttonbc);       button7.setForeground(Color.white);    button7.setEnabled(false);
        button8 = new JButton("Back");          button8.setBackground(colorbuttonbc);       button8.setForeground(Color.white);

        //colors for main menu items
        button1.setBackground(color);           button1.setForeground(Color.white);
        button2.setBackground(colorbuttonbc);   button2.setForeground(Color.white);
        button3.setBackground(colorbuttonbc);   button3.setForeground(Color.white);
        button4.setBackground(colorbuttonbc);   button4.setForeground(Color.white);
        button5.setBackground(colorbuttonbc);   button5.setForeground(Color.white);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(radioButton4);
        panel.add(radioButton5);
        panel.add(radioButton6);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);

        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);
        panel.add(textField4);
        panel.add(textField5);

        panel.add(button6);
        panel.add(button7);
        panel.add(button8);

        //setting location
        button1.setBounds(20,20,100,25);
        button2.setBounds(20,70,100,25);
        button3.setBounds(20,120,100,25);
        button4.setBounds(20,170,100,25);
        button5.setBounds(20,220,100,25);

        radioButton1.setBounds(200,10,100,20);      radioButton1.setBackground(color);
        radioButton2.setBounds(300,10,100,20);      radioButton2.setBackground(color);
        radioButton3.setBounds(400,10,100,20);      radioButton3.setBackground(color);

        radioButton4.setBounds(200,40,100,20);      radioButton4.setBackground(color);
        radioButton5.setBounds(300,40,100,20);      radioButton5.setBackground(color);
        radioButton6.setBounds(400,40,100,20);      radioButton6.setBackground(color);

        label1.setBounds(200,80,100,20);
        textField1.setBounds(300,80,50,20);
        button6.setBounds(400,80,100,20);

        label2.setBounds(200,110,100,20);
        textField2.setBounds(300,110,200,20);

        label3.setBounds(200,140,100,20);
        textField3.setBounds(300,140,200,20);

        label4.setBounds(200,170,100,20);
        textField4.setBounds(300,170,200,20);

        label5.setBounds(200,200,100,20);
        textField5.setBounds(300,200,200,20);

        button7.setBounds(200,230,100,20);
        button8.setBounds(400,230,100,20);
    }

    public static void Cancel_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();           panel.setBackground(color);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Book");
        button2 = new JButton("Cancel");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");

        radioButton1 = new JRadioButton("Gujrat");
        radioButton2 = new JRadioButton("Multan");
        radioButton3 = new JRadioButton("Multan");

        radioButton4 = new JRadioButton("Standard");
        radioButton5 = new JRadioButton("Executive");
        radioButton6 = new JRadioButton("BUssiness");

        ButtonGroup bt1 = new ButtonGroup();
        bt1.add(radioButton1);bt1.add(radioButton2);bt1.add(radioButton3);

        ButtonGroup bt2 = new ButtonGroup();
        bt2.add(radioButton4);bt2.add(radioButton5);bt2.add(radioButton6);

        label1 = new JLabel("Seat No");

        textField1 = new JTextField();

        button6 = new JButton("Cancel");        button6.setBackground(colorbuttonbc);       button6.setForeground(Color.white);     button6.setEnabled(false);
        button7 = new JButton("Clear");         button7.setBackground(colorbuttonbc);       button7.setForeground(Color.white);
        button8 = new JButton("Back");          button8.setBackground(colorbuttonbc);       button8.setForeground(Color.white);

        //colors for main menu items
        button1.setBackground(colorbuttonbc);   button1.setForeground(Color.white);
        button2.setBackground(color);           button2.setForeground(Color.white);
        button3.setBackground(colorbuttonbc);   button3.setForeground(Color.white);
        button4.setBackground(colorbuttonbc);   button4.setForeground(Color.white);
        button5.setBackground(colorbuttonbc);   button5.setForeground(Color.white);

        radioButton1.setBackground(color);
        radioButton2.setBackground(color);
        radioButton3.setBackground(color);
        radioButton4.setBackground(color);
        radioButton5.setBackground(color);
        radioButton6.setBackground(color);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(radioButton4);
        panel.add(radioButton5);
        panel.add(radioButton6);

        panel.add(label1);

        panel.add(textField1);

        //setting location
        button1.setBounds(20,20,100,25);
        button2.setBounds(20,70,100,25);
        button3.setBounds(20,120,100,25);
        button4.setBounds(20,170,100,25);
        button5.setBounds(20,220,100,25);

        radioButton1.setBounds(200,60,100,20);
        radioButton2.setBounds(300,60,100,20);
        radioButton3.setBounds(400,60,100,20);

        radioButton4.setBounds(200,100,100,20);
        radioButton5.setBounds(300,100,100,20);
        radioButton6.setBounds(400,100,100,20);

        label1.setBounds(200,140,100,20);
        textField1.setBounds(300,140,200,20);

        button6.setBounds(200,180,100,20);
        button7.setBounds(300,180,100,20);
        button8.setBounds(400,180,100,20);
    }

    public static void Reserves_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();           panel.setBackground(color);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Book");
        button2 = new JButton("Cancel");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");

        button6 = new JButton("Standard");
        button7 = new JButton("Executive");
        button8 = new JButton("Bussiness");

        radioButton1 = new JRadioButton("Gujrat");      radioButton1.setBackground(color);
        radioButton2 = new JRadioButton("Multan");      radioButton2.setBackground(color);
        radioButton3 = new JRadioButton("Lahore");      radioButton3.setBackground(color);

        //colors for main menu items
        button1.setBackground(colorbuttonbc);   button1.setForeground(Color.white);
        button2.setBackground(colorbuttonbc);   button2.setForeground(Color.white);
        button3.setBackground(colorbuttonbc);   button3.setForeground(Color.white);
        button4.setBackground(color);           button4.setForeground(Color.white);
        button5.setBackground(colorbuttonbc);   button5.setForeground(Color.white);

        button6.setBackground(colorbuttonbc);   button6.setForeground(Color.white);
        button7.setBackground(colorbuttonbc);   button7.setForeground(Color.white);
        button8.setBackground(colorbuttonbc);   button8.setForeground(Color.white);

        //groupijng radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        //setting location
        button1.setBounds(20,20,100,25);
        button2.setBounds(20,70,100,25);
        button3.setBounds(20,120,100,25);
        button4.setBounds(20,170,100,25);
        button5.setBounds(20,220,100,25);

        button6.setBounds(200,140,95,25);
        button7.setBounds(300,140,95,25);
        button8.setBounds(400,140,95,25);

        radioButton1.setBounds(200,100,100,20);
        radioButton2.setBounds(300,100,100,25);
        radioButton3.setBounds(400,100,100,25);
    }

    public static void Accounts_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();           panel.setBackground(color);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Book");
        button2 = new JButton("Cancel");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");
        button6 = new JButton("Back");

        label1 = new JLabel("Customers");
        label2 = new JLabel("Balance");

        textField1 = new JTextField();      textField1.setEditable(false);
        textField2 = new JTextField();      textField2.setEditable(false);

        //colors for main menu items
        button1.setBackground(colorbuttonbc);   button1.setForeground(Color.white);
        button2.setBackground(colorbuttonbc);   button2.setForeground(Color.white);
        button3.setBackground(color);           button3.setForeground(Color.white);
        button4.setBackground(colorbuttonbc);   button4.setForeground(Color.white);
        button5.setBackground(colorbuttonbc);   button5.setForeground(Color.white);

        button6.setBackground(colorbuttonbc);   button6.setForeground(Color.white);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        panel.add(label1);
        panel.add(label2);
        panel.add(textField1);
        panel.add(textField2);
        panel.add(button6);

        //setting location
        button1.setBounds(20,20,100,25);
        button2.setBounds(20,70,100,25);
        button3.setBounds(20,120,100,25);
        button4.setBounds(20,170,100,25);
        button5.setBounds(20,220,100,25);

        label1.setBounds(200,80,100,20);
        textField1.setBounds(300,80,100,20);

        label2.setBounds(200,120,100,20);
        textField2.setBounds(300,120,100,20);

        button6.setBounds(200,160,100,25);
    }

    static void Generate_Bill_Panel(String r,String b,int s) {
        JFrame frame1 = new JFrame("Bill");
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        frame1.setVisible(true);

        //creating items
        JTable table = new JTable(7,2);
        table.setEnabled(false);

        //adding elemenets
        panel1.add(table);
        frame1.add(panel1);

        frame1.pack();

        //setting some values
        table.setValueAt("Name",0,0);
        table.setValueAt("Date",1,0);
        table.setValueAt("Cnic",2,0);
        table.setValueAt("Price",3,0);
        table.setValueAt("Route",4,0);
        table.setValueAt("Buss",5,0);
        table.setValueAt("Seat",6,0);

        table.setValueAt(textField2.getText(),0,1);
        table.setValueAt(textField3.getText(),1,1);
        table.setValueAt(textField4.getText(),2,1);
        table.setValueAt(textField5.getText(),3,1);
        table.setValueAt(r,4,1);
        table.setValueAt(b,5,1);
        table.setValueAt(Integer.toString(s),6,1);


        //##################################################### saving records #########################################

        try {
            File f = new File("record.txt");
            if (!f.exists())
                f.createNewFile();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
            pw.println(textField2.getText());
            pw.println(textField3.getText());
            pw.println(textField4.getText());
            pw.println(textField5.getText());
            pw.println(r);
            pw.println(b);
            pw.println(Integer.toString(s));
        }catch (Exception e1){}

        //####################################################################################
    }

    // METHODS          ################################################################################################

    public static void Main_Menu(){

        //adding panel
        Main_Menu_Panel();

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Book_Panel();
                    Book_Button();
                }
                else if (e.getSource()==button2){
                    Cancel_Panel();
                    Cancel_Button();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }
                else if (e.getSource()==button6){
                    panel.setVisible(false);
                    UserNamePassChange();
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
    }

    public static void Book_Button(){

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Book_Panel();
                    Book_Button();
                }
                else if (e.getSource()==button2){
                    Cancel_Panel();
                    Cancel_Button();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }

                //check button
                else if (e.getSource()==button6){
                    //gujrat is selected
                    if (radioButton1.isSelected()) {
                        if (radioButton4.isSelected()) {        //standard
                            for (int c = 0;c<20;c++){
                                if (!gujrat[0][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                        else if (radioButton5.isSelected()) {       //executive
                            for (int c = 0;c<20;c++){
                                if (!gujrat[1][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                        else if (radioButton6.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!gujrat[2][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                    }

                    //Multan is selected
                    else if (radioButton2.isSelected()){
                        if (radioButton4.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!multan[0][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                        else if (radioButton5.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!multan[1][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                        else if (radioButton6.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!multan[2][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                    }
                    else if (radioButton3.isSelected()) {
                        if (radioButton4.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!lahore[0][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                        else if (radioButton5.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!lahore[1][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                        else if (radioButton6.isSelected()) {
                            for (int c = 0;c<20;c++){
                                if (!lahore[2][c]){
                                    textField1.setText(Integer.toString(c+1));
                                    break;
                                }
                            }
                        }
                    }
                    button7.setEnabled(true);
                }

                //Book button
                else if (e.getSource()==button7) {
                    customers++;
                    String price = textField5.getText();

                    boolean b1 = Check_Integer(price);

                    if (b1) {

                        //adding price
                        balance+=Integer.parseInt(price);


                        //for billing
                        if (radioButton1.isSelected()) {
                            if (radioButton4.isSelected()) {
                                gujrat[0][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Gujrat","Standard",Integer.parseInt(textField1.getText()));
                            }
                            else if (radioButton5.isSelected()) {
                                gujrat[1][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Gujrat","Executive",Integer.parseInt(textField1.getText()));
                            }
                            else if (radioButton6.isSelected()) {
                                gujrat[2][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Gujrat","Bussiness",Integer.parseInt(textField1.getText()));
                            }
                        } else if (radioButton2.isSelected()) {
                            if (radioButton4.isSelected()) {
                                multan[0][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Multan","Standard",Integer.parseInt(textField1.getText()));
                            }
                            else if (radioButton5.isSelected()) {
                                multan[1][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Multan","Executive",Integer.parseInt(textField1.getText()));
                            }
                            else if (radioButton6.isSelected()) {
                                multan[2][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Multan","Bussiness",Integer.parseInt(textField1.getText()));
                            }
                        } else if (radioButton3.isSelected()) {
                            if (radioButton4.isSelected()) {
                                lahore[0][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Lahore","Standard",Integer.parseInt(textField1.getText()));
                            }
                            else if (radioButton5.isSelected()) {
                                lahore[1][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Lahore","Executive",Integer.parseInt(textField1.getText()));
                            }
                            else if (radioButton6.isSelected()) {
                                lahore[2][Integer.parseInt(textField1.getText()) - 1] = true;
                                Generate_Bill_Panel("Lahore","Bussiness",Integer.parseInt(textField1.getText()));
                            }
                        }
                    }
                    button7.setEnabled(false);
                }

                //back button
                else if (e.getSource()==button8){
                    Main_Menu_Panel();
                    Main_Menu();
                }

                //turning on off buttons
                else if (e.getSource()==radioButton1 || e.getSource()==radioButton2 || e.getSource()==radioButton3 || e.getSource()==radioButton4 || e.getSource()==radioButton5 || e.getSource()==radioButton6){
                    if ((radioButton1.isSelected() || radioButton2.isSelected() || radioButton3.isSelected()) && (radioButton4.isSelected() || radioButton5.isSelected() || radioButton6.isSelected())){
                        button6.setEnabled(true);
                    }
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);

        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);
        radioButton3.addActionListener(actionListener);
        radioButton4.addActionListener(actionListener);
        radioButton5.addActionListener(actionListener);
        radioButton6.addActionListener(actionListener);
    }

    public static void Cancel_Button(){

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //turning on off buttons
                if (e.getSource()==radioButton1 || e.getSource()==radioButton2 || e.getSource()==radioButton3 || e.getSource()==radioButton4 || e.getSource()==radioButton5 || e.getSource()==radioButton6){
                    if ((radioButton1.isSelected() || radioButton2.isSelected() || radioButton3.isSelected()) && (radioButton4.isSelected() || radioButton5.isSelected() || radioButton6.isSelected())){
                        button6.setEnabled(true);
                    }
                }



                if (e.getSource() == button1) {
                    Book_Panel();
                    Book_Button();
                } else if (e.getSource() == button2) {
                    Cancel_Panel();
                    Cancel_Button();
                } else if (e.getSource() == button3) {
                    Accounts_Panel();
                    Accounts();
                } else if (e.getSource() == button4) {
                    Reserves_Panel();
                    Reserves();
                } else if (e.getSource() == button5) {
                    panel.setVisible(false);
                    Login();
                }


                //cancel button
                else if (e.getSource() == button6) {

                    //getting value from system no
                    String string = textField1.getText();

                    //check for integer value
                    boolean b1 = Check_Integer(string);

                    int num = 0;

                    if (b1) {
                        //check seat is alredy free
                        num = Integer.parseInt(string) - 1;
                        //check system is alredy false
                        b1 =Check_Empty(num);
                    }

                    //if integer ---------------------------------
                    if (b1) {

                        //gujrat is selected
                        if (radioButton1.isSelected()) {
                            if (radioButton4.isSelected()) {
                                gujrat[0][Integer.parseInt(textField1.getText()) - 1] = false;
                            } else if (radioButton5.isSelected()) {
                                gujrat[1][Integer.parseInt(textField1.getText()) - 1] = false;
                            } else if (radioButton6.isSelected()) {
                                gujrat[2][Integer.parseInt(textField1.getText()) - 1] = false;
                            }
                        }

                        //Multan is selected
                        else if (radioButton2.isSelected()) {
                            if (radioButton4.isSelected()) {
                                multan[0][Integer.parseInt(textField1.getText()) - 1] = false;
                            } else if (radioButton5.isSelected()) {
                                multan[1][Integer.parseInt(textField1.getText()) - 1] = false;
                            } else if (radioButton6.isSelected()) {
                                multan[2][Integer.parseInt(textField1.getText()) - 1] = false;
                            }
                        }
                        //lahore is selected
                        else if (radioButton3.isSelected()) {
                            if (radioButton4.isSelected()) {
                                lahore[0][Integer.parseInt(textField1.getText()) - 1] = false;
                            } else if (radioButton5.isSelected()) {
                                lahore[1][Integer.parseInt(textField1.getText()) - 1] = false;
                            } else if (radioButton6.isSelected()) {
                                lahore[2][Integer.parseInt(textField1.getText()) - 1] = false;
                            }
                        }
                        JOptionPane.showMessageDialog(panel,"Seat is cancelled");
                    }
                }


                //clear action
                else if (e.getSource()==button7){
                    radioButton1.setSelected(false);
                    radioButton2.setSelected(false);
                    radioButton3.setSelected(false);
                    radioButton4.setSelected(false);
                    radioButton5.setSelected(false);
                    radioButton6.setSelected(false);
                    textField1.setText("");

                }
                else if (e.getSource()==button8){
                    Main_Menu_Panel();
                    Main_Menu();
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);

        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);
        radioButton3.addActionListener(actionListener);
        radioButton4.addActionListener(actionListener);
        radioButton5.addActionListener(actionListener);
        radioButton6.addActionListener(actionListener);
    }

    public static void Reserves(){

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == button1) {
                    Book_Panel();
                    Book_Button();
                } else if (e.getSource() == button2) {
                    Cancel_Panel();
                    Cancel_Button();
                } else if (e.getSource() == button3) {
                    Accounts_Panel();
                    Accounts();
                } else if (e.getSource() == button4) {
                    Reserves_Panel();
                    Reserves();
                } else if (e.getSource() == button5) {
                    panel.setVisible(false);
                    Login();
                }



                //standard button function
                else if (e.getSource() == button6) {
                    Show_Reserves(0);
                }
                else if (e.getSource() == button7) {
                    Show_Reserves(1);
                }
                else if (e.getSource() == button8) {
                    Show_Reserves(2);
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
    }

    public static void Accounts(){

        textField1.setText(Integer.toString(customers));
        textField2.setText(Long.toString(balance));

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Book_Panel();
                    Book_Button();
                }
                else if (e.getSource()==button2){
                    Cancel_Panel();
                    Cancel_Button();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }
                else if (e.getSource()==button6){
                    Main_Menu_Panel();
                    Main_Menu();
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
    }

    public static void UserNamePassChange(){
        panel = new JPanel();       panel.setBackground(color);
        panel.setLayout(null);

        //creating items
        button1 = new JButton("Ok");            button1.setBackground(colorbuttonbc);       button1.setForeground(Color.white);
        button2 = new JButton("Back");          button2.setBackground(colorbuttonbc);       button2.setForeground(Color.white);

        label1 = new JLabel("New name");
        label2 = new JLabel("New Pass");

        textField1 = new JTextField();
        textField2 = new JTextField();

        //adding to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(label1);
        panel.add(label2);
        panel.add(textField1);
        panel.add(textField2);

        //setting bounds
        label1.setBounds(130,80,70,20);
        textField1.setBounds(230,80,150,20);

        label2.setBounds(130,110,70,20);
        textField2.setBounds(230,110,150,20);

        button1.setBounds(130,140,70,25);
        button2.setBounds(230,140,70,25);

        //adding to frame
        frame.add(panel);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ actions @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){

                    //Writing to login file ############################################################################

                    try {
                        File f = new File("login.txt");
                        PrintWriter pw = new PrintWriter(f);
                        pw.println(textField1.getText());
                        pw.println(textField2.getText());
                        pw.close();
                    }catch (Exception e1){}

                    //##################################################################################################

                    JOptionPane.showMessageDialog(panel,"Successfully changed");
                    Main_Menu_Panel();
                    Main_Menu();
                }
                else if (e.getSource()==button2){
                    Main_Menu_Panel();
                    Main_Menu();
                }
            }
        };
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }

    //Checks ###########################################################################################################

    public static boolean Check_Empty(int num) {
        if (radioButton1.isSelected()) {
            if (radioButton4.isSelected()) {
                if (!gujrat[0][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            } else if (radioButton5.isSelected()) {
                if (!gujrat[1][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            } else if (radioButton6.isSelected()) {
                if (!gujrat[2][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            }
        }
        else if (radioButton2.isSelected()) {
            if (radioButton4.isSelected()) {
                if (!multan[0][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            } else if (radioButton5.isSelected()) {
                if (!multan[1][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            } else if (radioButton6.isSelected()) {
                if (!multan[2][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            }
        }
        else if (radioButton3.isSelected()) {
            if (radioButton4.isSelected()) {
                if (!lahore[0][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            } else if (radioButton5.isSelected()) {
                if (!lahore[1][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            } else if (radioButton6.isSelected()) {
                if (!lahore[2][num]) {
                    JOptionPane.showMessageDialog(panel, "Seat is already empty");
                    return false;
                }
            }
        }
        return true;
    }

    static boolean Check_Integer(String string){
        boolean b1 = true;

        if (string.equals("")){
            b1 = false;
            JOptionPane.showMessageDialog(panel,"Invalid input");
        }

        //if b1 is not empty string
        if (b1) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) < '0' || string.charAt(i) > '9' || string.charAt(i) == ' ') {
                    b1 = false;
                    JOptionPane.showMessageDialog(panel, "Invalid input");
                    break;
                }
            }
        }

        //if not integer
        if (!b1){
            Book_Panel();
            Book_Button();
            return false;
        }
        else
            return true;
    }

    static void Show_Reserves(int num){
        JFrame frame1 = new JFrame("Reservations");
        frame1.setVisible(true);
        frame1.setResizable(false);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        //making items
        JTable table = new JTable(20,2);
        table.setEnabled(false);

        //adding elements
        panel1.add(table);
        frame1.add(panel1);

        frame1.pack();

        //printing first column
        for (int i = 0 ; i <20 ;i++){
            table.setValueAt(("Seat"+" "+(i+1)),i,0);
        }

        //for second column
        for (int i = 0;i<20;i++) {
            if (radioButton1.isSelected()) {
                if (gujrat[num][i])
                    table.setValueAt("Book", i, 1);
                else
                    table.setValueAt("Empty", i, 1);
            }
            else if (radioButton2.isSelected()) {
                if (multan[num][i])
                    table.setValueAt("Book", i, 1);
                else
                    table.setValueAt("Empty", i, 1);
            }
            else if (radioButton3.isSelected()) {
                if (lahore[num][i])
                    table.setValueAt("Book", i, 1);
                else
                    table.setValueAt("Empty", i, 1);
            }
        }
    }
}

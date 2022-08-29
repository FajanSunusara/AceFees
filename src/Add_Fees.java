
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Add_Fees extends javax.swing.JFrame {

    /**
     * Creates new form Add_Fees
     */
    public Add_Fees() {
        initComponents();
        checkcash();
        fillcombox();
        fillcombox2();
        
        
        int receiptno = getReceiptNo();
        txt_receipt.setText(Integer.toString(receiptno));
    } 
    public void checkcash(){
       lbl_dd.setVisible(false);
       txt_dd.setVisible(false);
       lbl_cheque.setVisible(false);
       txt_cheque.setVisible(false);
       lbl_bankname.setVisible(false);
       txt_bankname.setVisible(false);
            }
    public  boolean validation()
{  
    if(txt_pnr.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "please enter Roll No ");
    return false;
    }
    if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("Cheque"))
    { 
    
     if(txt_cheque.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter Cheque Number");
    return false;
    }
    
    if( txt_bankname.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "please enter Bank Name ");
            return false;
    } 
        }
    
    
    if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("DD"))
    { 
    
     if(txt_dd.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this,"Please enter DD Number");
    return false;
    }
    
    if( txt_bankname.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "please enter Bank Name ");
            return false;
    } 
        }
    
    
    if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("Card"))
    { 
    if( txt_bankname.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "please enter Bank Name ");
            return false;
    } 
        }
    
    if(txt_name.getText().equals(""))
    {
        JOptionPane.showMessageDialog(this, "please enter Received From ");
    return false;
    }
    
    if(cb_branch.getSelectedItem().toString().equalsIgnoreCase("."))
    { 
    
    
        JOptionPane.showMessageDialog(this, "please enter Branch ");
            return false;
    
        }
    
  
    
    
    return true;
    
    }
 public void fillcombox()
 {
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select cname,cost from course");
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {cb_category.addItem(rs.getString("cname"));
        // txt_amount.setText(rs.getString("cost"));
         }
     
     
     
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
 
 public void fillcombox2()
 {
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select cname,cot from course1");
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {cb_course.addItem(rs.getString("cname"));
        // txt_amount.setText(rs.getString("cost"));
         }
     
     
     
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
  public void fillamount()
 {
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select * from course1 where cname =? ");
         pst.setString(1, cb_course.getSelectedItem().toString());
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {//cb_category.addItem(rs.getString("cname"));
         txt_amount.setText(rs.getString("cot"));
         }
     
     
     
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
  
 
  public void fillremaining()
 {
      String num1 = null;
       String rem1 = null;
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select * from course1 where cname =? ");
         pst.setString(1, cb_course.getSelectedItem().toString());
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {//cb_category.addItem(rs.getString("cname"));
         num1 = rs.getString("cot");
         int num2= Integer.parseInt(num1);
    int num3= Integer.parseInt(txt_amount.getText()); 
    int rem=num2-num3;
    rem1=Integer.toString(rem);
    txt_remaining.setText(rem1);
         
         }
     
     
     
     
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
  
  
  
 public void addAmount()
 {
      Float amnt = Float.parseFloat(txt_amount.getText());
                  Float cgst= (float)(amnt*0.09);
                  Float sgst= (float)(amnt*0.09);
                  txt_cgst.setText(cgst.toString());
                  txt_sgst.setText(sgst.toString());
                  
                  float total = amnt+cgst+sgst;
                  txt_total.setText(Float.toString(total));
                  //int i;
                  //i=(int)total;
                 // NumberToWordsConverter x = new NumberToWordsConverter();
                  //x.convert((int)total);
                 txt_totalwords.setText(NumberToWordsConverter.convert((int)total));
                 
                 
 }
 
 public void raim()
 {
    String u = txt_amount.getText();
    float k=Float.parseFloat(u);
    
            if(cb_category.getSelectedIndex()== 1)
         {
             float a = 120000 - k;
             String d = Float.toString(a);
             txt_remaining.setText(d);
            
         }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Sc/ST"))
         {
             float b = 20000 - k;
             String e = Float.toString(b);
             txt_remaining.setText(e);                             }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Obc/Ews"))
         {
                float c = 65000 - k;
             String f = Float.toString(c);
             txt_remaining.setText(f);                            } 
 }
 
 
 
 
 public int getReceiptNo()
 { 
     int ReceiptNo = 0;
     try {
         
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select max(reciept_no) from fees_details");
         ResultSet rs = pst.executeQuery();
         if (rs.next()== true)
         {
               ReceiptNo = rs.getInt(1);
         }
         
 }
     catch(Exception e)
 {
     e.printStackTrace();
 }
     
 
 return ReceiptNo +1;
 }
 public String insertData()
 {  
     String status =""; 
     int receipt = Integer.parseInt(txt_receipt.getText());
     String studentName =txt_name.getText();
      int rollNo = Integer.parseInt(txt_pnr.getText());
   String paymentMode =combo_paymentmode.getSelectedItem().toString();
   String chequeNo =txt_cheque.getText();
   String bankName =txt_bankname.getText();
   String ddNo =txt_dd.getText();
   String feesname =txt_feesname.getText();
   String branch =cb_branch.getSelectedItem().toString();
   String course =cb_course.getSelectedItem().toString();
   String category =cb_category.getSelectedItem().toString();
   SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
   String date =dateFormat.format(txt_date.getDate());
   float initialAmount=Float.parseFloat(txt_amount.getText());
     float totalAmount=Float.parseFloat(txt_total.getText());
  String totalwords =txt_totalwords.getText();
   float cgst=Float.parseFloat(txt_cgst.getText()); 
   float sgst=Float.parseFloat(txt_sgst.getText());
   String remark =txt_remark.getText();
    int year1 = Integer.parseInt(txt_y1.getText());
     int year2 = Integer.parseInt(txt_y2.getText());
     int remaining = Integer.parseInt(txt_remaining.getText());
      
     
     
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         
         pst.setInt(1,receipt);
         pst.setString(2, studentName);
         pst.setInt(3, rollNo);
         pst.setString(4, paymentMode);
         pst.setString(5, chequeNo);
         pst.setString(6,bankName);
         pst.setString(7, ddNo);
         pst.setString(8, course);
         pst.setString(9, branch);
         pst.setString(10, category);
         pst.setFloat(11,totalAmount);
         pst.setString(12, date);
         pst.setFloat(13, initialAmount);
         pst.setFloat(14, cgst);
         pst.setFloat(15,sgst );
         pst.setString(16, totalwords);
         pst.setString(17,remark );
         pst.setInt(18,year1);
         pst.setInt(19,year2);
         pst.setInt(20,remaining);
         
         int rowcount =pst.executeUpdate();
         if (rowcount==1 )
         {
             status="success";
         }
         else
         {
            status ="failed";
         }
        
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
   
 return status;  
 } 



   public void pnrData()
 {  
     String status =""; 
     int pnr  =Integer.parseInt(txt_pnr.getText());
     int sem =pnr/100000;
     if(sem == 1)
     {
        cb_course.setSelectedIndex(1);
     }
      
     
     
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select * from STUDENTDETAIL where PNR=?");
         pst.setInt(1, pnr);
         ResultSet rs = pst.executeQuery();
         
         while(rs.next())
         {//cb_category.addItem(rs.getString("cname"));
         
         txt_name.setText(rs.getString("NAME"));
         cb_branch.setSelectedItem(rs.getString("BRANCH"));
         cb_category.setSelectedItem(rs.getString("CATEGORY"));
         //txt_dob.setText(rs.getString("DOB"));
         }
         
         
        
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
   
 //return status;  
 } 
    
    
    
    
    
    
     
   /* */
         /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_parent = new javax.swing.JPanel();
        lbl_paymentmode = new javax.swing.JLabel();
        lbl_receipt = new javax.swing.JLabel();
        lbl_rollno = new javax.swing.JLabel();
        lbl_cheque = new javax.swing.JLabel();
        lbl_dd = new javax.swing.JLabel();
        lbl_bankname = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JTextField();
        combo_paymentmode = new javax.swing.JComboBox<>();
        txt_receipt = new javax.swing.JTextField();
        txt_cheque = new javax.swing.JTextField();
        txt_dd = new javax.swing.JTextField();
        pnl_child = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_y2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_y1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        remaining = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cb_branch = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_totalwords = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        lbl_receivedfrom = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_feesname = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        cb_course = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        txt_remaining = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl_date1 = new javax.swing.JLabel();
        txt_pnr = new javax.swing.JTextField();
        txt_date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_parent.setBackground(new java.awt.Color(0, 153, 153));
        pnl_parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_paymentmode.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_paymentmode.setText("Mode of  payment :");
        pnl_parent.add(lbl_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 150, -1));

        lbl_receipt.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_receipt.setText("Receipt  no : Sr-");
        pnl_parent.add(lbl_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 130, -1));

        lbl_rollno.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_rollno.setText("PNR No :");
        pnl_parent.add(lbl_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 70, -1));

        lbl_cheque.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_cheque.setText("cheque  no :");
        pnl_parent.add(lbl_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 100, -1));

        lbl_dd.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_dd.setText("DD no :");
        pnl_parent.add(lbl_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 100, -1));

        lbl_bankname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_bankname.setText("Bank name  :");
        pnl_parent.add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 100, -1));
        pnl_parent.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, -1));

        combo_paymentmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combo_paymentmode.setSelectedIndex(2);
        combo_paymentmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentmodeActionPerformed(evt);
            }
        });
        pnl_parent.add(combo_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 140, -1));
        pnl_parent.add(txt_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 80, -1));
        pnl_parent.add(txt_cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 200, -1));
        pnl_parent.add(txt_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 80, -1));

        pnl_child.setBackground(new java.awt.Color(0, 153, 153));
        pnl_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel19.setText("Remark :");
        pnl_child.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 70, -1));
        pnl_child.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 160, -1));
        pnl_child.add(txt_y2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 80, -1));

        jLabel21.setText("---");
        pnl_child.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 20, 20));
        pnl_child.add(txt_y1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 80, -1));
        pnl_child.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 720, 10));

        remaining.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        remaining.setText("Remaining Amount :");
        pnl_child.add(remaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 160, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel23.setText("Amount");
        pnl_child.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, -1));

        cb_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "__", "Computer Engineering", "Information Techonology", "Electrical and Telecomunication", "Mechanical", "Instrumental" }));
        cb_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_branchActionPerformed(evt);
            }
        });
        pnl_child.add(cb_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 220, -1));
        pnl_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 720, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel24.setText("Cast/Category :");
        pnl_child.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 120, -1));

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });
        pnl_child.add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 190, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel25.setText("Sr No :");
        pnl_child.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 60, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel26.setText("Head");
        pnl_child.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));
        pnl_child.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 250, -1));
        pnl_child.add(txt_totalwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 300, -1));

        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        pnl_child.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 160, -1));
        pnl_child.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 160, -1));

        lbl_receivedfrom.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_receivedfrom.setText("Received from  :");
        pnl_child.add(lbl_receivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 130, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel28.setText("CGST  9%");
        pnl_child.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, -1));
        pnl_child.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 160, 10));
        pnl_child.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 160, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel29.setText("The following payment in the college office  for the year ");
        pnl_child.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        txt_feesname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_feesnameActionPerformed(evt);
            }
        });
        pnl_child.add(txt_feesname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 260, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel30.setText("Total in words :");
        pnl_child.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 120, -1));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        pnl_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 350, 60));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel31.setText("Branch :");
        pnl_child.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 70, -1));

        btn_print.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        pnl_child.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 473, 110, 30));

        cb_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "." }));
        cb_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_courseActionPerformed(evt);
            }
        });
        pnl_child.add(cb_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 220, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel32.setText("Course :");
        pnl_child.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 70, -1));
        pnl_child.add(txt_remaining, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 160, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel27.setText("SGST  9%");
        pnl_child.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 130, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel33.setText("Total");
        pnl_child.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 100, -1));

        pnl_parent.add(pnl_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 910, 560));

        lbl_date1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_date1.setText("Date  :");
        pnl_parent.add(lbl_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 60, -1));

        txt_pnr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pnrActionPerformed(evt);
            }
        });
        pnl_parent.add(txt_pnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 110, -1));
        pnl_parent.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 120, -1));

        getContentPane().add(pnl_parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -10, 1000, 1010));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void combo_paymentmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paymentmodeActionPerformed
             if(combo_paymentmode.getSelectedIndex()==0)
             {
                 
       lbl_dd.setVisible(true);
       txt_dd.setVisible(true);
       lbl_cheque.setVisible(false);
       txt_cheque.setVisible(false);
       lbl_bankname.setVisible(true);
       txt_bankname.setVisible(true);
             } 
              if(combo_paymentmode.getSelectedIndex()==1)
             {
                 
       lbl_dd.setVisible(false);
       txt_dd.setVisible(false);
       lbl_cheque.setVisible(true);
       txt_cheque.setVisible(true);
       lbl_bankname.setVisible(true);
       txt_bankname.setVisible(true);
             }
                  
              if(combo_paymentmode.getSelectedIndex()==3)
             {
                 
       lbl_dd.setVisible(false);
       txt_dd.setVisible(false);
       lbl_cheque.setVisible(false);
       txt_cheque.setVisible(false);
       lbl_bankname.setVisible(true);
       txt_bankname.setVisible(true);
             }     if(combo_paymentmode.getSelectedIndex()==2)
             {
                 
       lbl_dd.setVisible(false);
       txt_dd.setVisible(false);
       lbl_cheque.setVisible(false);
       txt_cheque.setVisible(false);
       lbl_bankname.setVisible(false);
       txt_bankname.setVisible(false);
             }
              // TODO add your handling code here:
    }//GEN-LAST:event_combo_paymentmodeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
         if(validation()== true)  
         { 
             String result = insertData();
             if(result.equals("success"))
             {
                 JOptionPane.showMessageDialog(this, "Record inserted successfully");
                     Print_receipt x = new Print_receipt();
                   x.show();
                  this.dispose();
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(this, "Record inserted failed");
             }
             
         
         
         
             
                
                 
       
   
         
         }        // TODO add your handling code here:
    }//GEN-LAST:event_btn_printActionPerformed

    private void cb_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_branchActionPerformed
                          txt_feesname.setText(cb_course.getSelectedItem().toString()+""+cb_branch.getSelectedItem().toString()+" Tution Fees" );// TODO add your handling code here:
    }//GEN-LAST:event_cb_branchActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        fillremaining();        
        Float amnt = Float.parseFloat(txt_amount.getText());
                  Float cgst= (float)(amnt*0.09);
                  Float sgst= (float)(amnt*0.09);
                  txt_cgst.setText(cgst.toString());
                  txt_sgst.setText(sgst.toString());
                  
                  float total = amnt+cgst+sgst;
                  txt_total.setText(Float.toString(total));
                
                 txt_totalwords.setText(NumberToWordsConverter.convert((int)total));
                 String u = txt_amount.getText();
    float k=Float.parseFloat(u);
    
            if(cb_category.getSelectedIndex()== 1)
         {
             float a = 120000 - k;
             String d = Float.toString(a);
             txt_remaining.setText(d);
            
         }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Sc/ST"))
         {
             float b = 20000 - k;
             String e = Float.toString(b);
             txt_remaining.setText(e);                             }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Obc/Ews"))
         {
                float c = 65000 - k;
             String f = Float.toString(c);
             txt_remaining.setText(f);                            } 
                 //raim();
                 




// TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void cb_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_courseActionPerformed
          fillamount();
        txt_feesname.setText(cb_course.getSelectedItem().toString()+" "+cb_branch.getSelectedItem().toString()+" Tution Fees" );
        Float amnt = Float.parseFloat(txt_amount.getText());
                  Float cgst= (float)(amnt*0.09);
                  Float sgst= (float)(amnt*0.09);
                  txt_cgst.setText(cgst.toString());
                  txt_sgst.setText(sgst.toString());
                  
                  float total = amnt+cgst+sgst;
                  txt_total.setText(Float.toString(total));
                
                 txt_totalwords.setText(NumberToWordsConverter.convert((int)total));
                 String u = txt_amount.getText(); 
                  fillremaining();// TODO add your handling code here:
    }//GEN-LAST:event_cb_courseActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
          if(cb_category.getSelectedIndex()== 1)
         {
             txt_amount.setText("120000.00 ");
             addAmount();
             
         }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Sc/ST"))
         {txt_amount.setText("20000.00");
           addAmount();                                }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Obc/Ews"))
         {txt_amount.setText("65000.00");
            addAmount();                                }
     try {String u = txt_amount.getText();
    float l=Float.parseFloat(u);
    int k = (int)l;
    
            if(cb_category.getSelectedIndex()== 1)
         {
             int a = 120000 - k;
             String d =Integer.toString(a);
             txt_remaining.setText(d);
            
         }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Sc/ST"))
         {
             int b = 20000 - k;
             String e = Integer.toString(b);
             txt_remaining.setText(e);                             }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Obc/Ews"))
         {
                int c = 65000 - k;
             String f = Integer.toString(c);
             txt_remaining.setText(f);                            } }
     catch(NumberFormatException e){}
    // raim();
// TODO add your handling code here:
                                   // TODO add your handling code here:
      // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void txt_feesnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_feesnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_feesnameActionPerformed

    private void txt_pnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pnrActionPerformed
          pnrData();  
          if(cb_category.getSelectedIndex()== 1)
         {
             txt_amount.setText("120000.00 ");
             addAmount();
             
         }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Sc/ST"))
         {txt_amount.setText("20000.00");
           addAmount();                                }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Obc/Ews"))
         {txt_amount.setText("65000.00");
            addAmount();                                }
     try {String u = txt_amount.getText();
    float l=Float.parseFloat(u);
    int k = (int)l;
    
            if(cb_category.getSelectedIndex()== 1)
         {
             int a = 120000 - k;
             String d =Integer.toString(a);
             txt_remaining.setText(d);
            
         }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Sc/ST"))
         {
             int b = 20000 - k;
             String e = Integer.toString(b);
             txt_remaining.setText(e);                             }
     if(cb_category.getSelectedItem().toString().equalsIgnoreCase("Obc/Ews"))
         {
                int c = 65000 - k;
             String f = Integer.toString(c);
             txt_remaining.setText(f);                            } }
     catch(NumberFormatException e){}// TODO add your handling code here:
    }//GEN-LAST:event_txt_pnrActionPerformed

    
            
    /**
     * @param args the command line arguments
     */
    
     
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Fees().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> cb_branch;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_course;
    private javax.swing.JComboBox<String> combo_paymentmode;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_cheque;
    private javax.swing.JLabel lbl_date1;
    private javax.swing.JLabel lbl_dd;
    private javax.swing.JLabel lbl_paymentmode;
    private javax.swing.JLabel lbl_receipt;
    private javax.swing.JLabel lbl_receivedfrom;
    private javax.swing.JLabel lbl_rollno;
    private javax.swing.JPanel pnl_child;
    private javax.swing.JPanel pnl_parent;
    private javax.swing.JLabel remaining;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JTextField txt_feesname;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_pnr;
    private javax.swing.JTextField txt_receipt;
    private javax.swing.JTextField txt_remaining;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalwords;
    private javax.swing.JTextField txt_y1;
    private javax.swing.JTextField txt_y2;
    // End of variables declaration//GEN-END:variables

    private void NumberToWordsConverter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String NUmberToWordsConverter(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cb_course(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

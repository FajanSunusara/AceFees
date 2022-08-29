
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
public class Edit_print extends javax.swing.JFrame {

    /**
     * Creates new form Add_Fees
     */
    public Edit_print() {
        initComponents();
        checkcash();
        fillcombox();
        fillcombox2();
        updateData();
        
      //  int receiptno = getReceiptNo();
        //txt_receipt.setText(Integer.toString(receiptno));
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
    if(txt_rollno.getText().equals(""))
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
    
    if(txt_receivedfrom.getText().equals(""))
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
     String studentName =txt_receivedfrom.getText();
      int rollNo = Integer.parseInt(txt_rollno.getText());
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
         PreparedStatement pst = conn.prepareStatement("update  fees_details  set  STUDENT_NAME = ?,ROLL_NO=?,PAYMENT_MODE =? ,CHEQUE_NO =?,BANK_NAME =?,  DD_NO=?, COURSE_NAME =?,BRANCH_NAME =?,CCATEGORY =? ,TOTAL_AMOUNT =?,DATE =?,AMOUNT =?, CGST=?, SGST=?,TOTAL_IN_WORDS =?,REMARK =?, YEAR1=?,YEAR2 =?, REMIANING =? where RECIEPT_NO=? ");
         
         
         pst.setString(1, studentName);
         pst.setInt(2, rollNo);
         pst.setString(3, paymentMode);
         pst.setString(4, chequeNo);
         pst.setString(5,bankName);
         pst.setString(6, ddNo);
         pst.setString(7, course);
         pst.setString(8, branch);
         pst.setString(9, category);
         pst.setFloat(10,totalAmount);
         pst.setString(11, date);
         pst.setFloat(12, initialAmount);
         pst.setFloat(13, cgst);
         pst.setFloat(14,sgst );
         pst.setString(15, totalwords);
         pst.setString(16,remark );
         pst.setInt(17,year1);
         pst.setInt(18,year2);
         pst.setInt(19,remaining);
         pst.setInt(20,receipt);
         
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
 
 public void updateData()
 { try
        {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select * from fees_details order by reciept_no desc fetch first 1 rows only");
         ResultSet rs = pst.executeQuery();
         rs.next();
         txt_receipt.setText(rs.getString("reciept_no"));
         txt_receivedfrom.setText(rs.getString("student_name"));
         cb_branch.setSelectedItem(rs.getString("branch_name"));
         cb_course.setSelectedItem(rs.getString("course_name"));
         txt_rollno.setText(rs.getString("roll_no"));
         //txt_date.setText(rs.getString("date"));
         txt_amount.setText(rs.getString("amount"));
         txt_cgst.setText(rs.getString("cgst"));
         txt_sgst.setText(rs.getString("sgst"));
         txt_total.setText(rs.getString("total_amount"));
         txt_totalwords.setText(rs.getString("total_in_words"));
         txt_remaining.setText(rs.getString("remianing"));
         txt_remark.setText(rs.getString("remark"));
          cb_category.setSelectedItem(rs.getString("ccategory"));
         
         
        }
        catch(Exception e)
        {
        }
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

        pnl_sidebar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnl_parent = new javax.swing.JPanel();
        lbl_paymentmode = new javax.swing.JLabel();
        lbl_receipt = new javax.swing.JLabel();
        lbl_rollno = new javax.swing.JLabel();
        lbl_cheque = new javax.swing.JLabel();
        lbl_dd = new javax.swing.JLabel();
        lbl_bankname = new javax.swing.JLabel();
        txt_date = new com.toedter.calendar.JDateChooser();
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
        txt_receivedfrom = new javax.swing.JTextField();
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
        txt_rollno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_sidebar.setBackground(new java.awt.Color(0, 102, 102));
        pnl_sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/logout.png"))); // NOI18N
        jLabel1.setText("Logout");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/home.png"))); // NOI18N
        jLabel4.setText("Home");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 70));

        pnl_sidebar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 330, 70));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/home.png"))); // NOI18N
        jLabel2.setText("Home");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        pnl_sidebar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 330, 70));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/search2.png"))); // NOI18N
        jLabel3.setText("Search Record");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        pnl_sidebar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 330, 70));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/edit2.png"))); // NOI18N
        jLabel5.setText("Edit Course");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/home.png"))); // NOI18N
        jLabel6.setText("Home");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 70));

        pnl_sidebar.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 330, 70));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/view all record.png"))); // NOI18N
        jLabel9.setText("View Record");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));
        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/home.png"))); // NOI18N
        jLabel10.setText("Home");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 70));

        pnl_sidebar.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 330, 70));

        jPanel11.setBackground(new java.awt.Color(0, 102, 102));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/left-arrow.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/home.png"))); // NOI18N
        jLabel12.setText("Home");
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 70));

        pnl_sidebar.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 330, 70));

        getContentPane().add(pnl_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 1040));

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
        pnl_parent.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 120, -1));
        pnl_parent.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 200, -1));

        combo_paymentmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combo_paymentmode.setSelectedIndex(2);
        combo_paymentmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentmodeActionPerformed(evt);
            }
        });
        pnl_parent.add(combo_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 140, -1));

        txt_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiptActionPerformed(evt);
            }
        });
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

        cb_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "__", "Computer", "Information Techonology", "Electrical and Telecomunication", "Mechnaical", "Instrumental" }));
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
        pnl_child.add(txt_receivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 250, -1));
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
        pnl_parent.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 110, -1));

        getContentPane().add(pnl_parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, -20, 1000, 1010));

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

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
              Print_receipt pr =new Print_receipt();
                   pr.setVisible(true);
        this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
          this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
                   Home_page a = new Home_page();
                a.setVisible(true);
                 this.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

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
                 String u = txt_amount.getText(); // TODO add your handling code here:
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

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
            SearchRecord sr =new SearchRecord();
            sr.setVisible(true);
            this.setVisible(false);
            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      this.setVisible(false);   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
             ViewAllRecord vr = new  ViewAllRecord();
             vr.setVisible(true);
             this.setVisible(false);// TODO add your handling code here: AR
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        add_Course ac =new add_Course();
        ac.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
                  Print_receipt pr =new Print_receipt();
                   pr.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiptActionPerformed

    
            
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
            java.util.logging.Logger.getLogger(Edit_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_print().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> cb_branch;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_course;
    private javax.swing.JComboBox<String> combo_paymentmode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
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
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JLabel remaining;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque;
    private com.toedter.calendar.JDateChooser txt_date;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JTextField txt_feesname;
    private javax.swing.JTextField txt_receipt;
    private javax.swing.JTextField txt_receivedfrom;
    private javax.swing.JTextField txt_remaining;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollno;
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

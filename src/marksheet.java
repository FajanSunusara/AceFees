
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class marksheet extends javax.swing.JFrame {

    /**
     * Creates new form marksheet
     */
    public marksheet() {
        initComponents();
    }
    
    public void sem1()    
     {
     try
     {
         String status ="";
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("insert into SEM1(PNR,SNAME,S1M1,S1M2,S1O,S1P,S1TH,S1T,S2M1,S2M2,S2O,S2P,S2TH,S2T,S3M1,S3M2,S3O,S3P,S3TH,S3T,S4M1,S4M2,S4O,S4P,S4TH,S4T,S5M1,S5M2,S5O,S5P,S5TH,S5T,CGPA) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
         pst.setInt(1,Integer.parseInt(lbpnr.getText()));
         pst.setString(2,lbname.getText());
         pst.setInt(3,Integer.parseInt(s1m1.getText()));
         pst.setInt(4,Integer.parseInt(s1m2.getText()));
         pst.setInt(5,Integer.parseInt(s1o.getText()));
         pst.setInt(6,Integer.parseInt(s1p.getText()));
         pst.setInt(7,Integer.parseInt(s1th.getText()));
         pst.setInt(8,Integer.parseInt(s1t.getText()));
         pst.setInt(9,Integer.parseInt(s2m1.getText()));
         pst.setInt(10,Integer.parseInt(s2m2.getText()));
         pst.setInt(11,Integer.parseInt(s2o.getText()));
         pst.setInt(12,Integer.parseInt(s2p.getText()));
         pst.setInt(13,Integer.parseInt(s2th.getText()));
         pst.setInt(14,Integer.parseInt(s2t.getText()));
         pst.setInt(15,Integer.parseInt(s3m1.getText()));
         pst.setInt(16,Integer.parseInt(s3m2.getText()));
         pst.setInt(17,Integer.parseInt(s3o.getText()));
         pst.setInt(18,Integer.parseInt(s3p.getText()));
         pst.setInt(19 ,Integer.parseInt(s3th.getText()));
         pst.setInt(20,Integer.parseInt(s3t.getText()));
         pst.setInt(21,Integer.parseInt(s4m1.getText()));
         pst.setInt(22,Integer.parseInt(s4m2.getText()));
         pst.setInt(23,Integer.parseInt(s4o.getText()));
         pst.setInt(24,Integer.parseInt(s4p.getText()));
         pst.setInt(25,Integer.parseInt(s4th.getText()));
         pst.setInt(26,Integer.parseInt(s4t.getText()));
         pst.setInt(27,Integer.parseInt(s5m1.getText()));
         pst.setInt(28,Integer.parseInt(s5m2.getText()));
         pst.setInt(29,Integer.parseInt(s5o.getText()));
         pst.setInt(30,Integer.parseInt(s5p.getText()));
         pst.setInt(31,Integer.parseInt(s5th.getText()));
         pst.setInt(32,Integer.parseInt(s5t.getText()));
         pst.setFloat(33,Float.parseFloat(cgpa.getText()));
         
         
         int rowcount =pst.executeUpdate();
         if (rowcount==1 )
         {
             status="success";
             JOptionPane.showMessageDialog(this, "Record inserted successfully");
         }
         else
         {
            status ="failed";
            JOptionPane.showMessageDialog(this, "Record inserted unsuccessfull");
         }
        
         
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
    
    
   
     public void sem2()    
     {
     try
     {
         String status ="";
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("insert into SEM2(PNR,SNAME,S1M1,S1M2,S1O,S1P,S1TH,S1T,S2M1,S2M2,S2O,S2P,S2TH,S2T,S3M1,S3M2,S3O,S3P,S3TH,S3T,S4M1,S4M2,S4O,S4P,S4TH,S4T,S5M1,S5M2,S5O,S5P,S5TH,S5T,CGPA) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
         pst.setInt(1,Integer.parseInt(lbpnr.getText()));
         pst.setString(2,lbname.getText());
         pst.setInt(3,Integer.parseInt(s1m1.getText()));
         pst.setInt(4,Integer.parseInt(s1m2.getText()));
         pst.setInt(5,Integer.parseInt(s1o.getText()));
         pst.setInt(6,Integer.parseInt(s1p.getText()));
         pst.setInt(7,Integer.parseInt(s1th.getText()));
         pst.setInt(8,Integer.parseInt(s1t.getText()));
         pst.setInt(9,Integer.parseInt(s2m1.getText()));
         pst.setInt(10,Integer.parseInt(s2m2.getText()));
         pst.setInt(11,Integer.parseInt(s2o.getText()));
         pst.setInt(12,Integer.parseInt(s2p.getText()));
         pst.setInt(13,Integer.parseInt(s2th.getText()));
         pst.setInt(14,Integer.parseInt(s2t.getText()));
         pst.setInt(15,Integer.parseInt(s3m1.getText()));
         pst.setInt(16,Integer.parseInt(s3m2.getText()));
         pst.setInt(17,Integer.parseInt(s3o.getText()));
         pst.setInt(18,Integer.parseInt(s3p.getText()));
         pst.setInt(19 ,Integer.parseInt(s3th.getText()));
         pst.setInt(20,Integer.parseInt(s3t.getText()));
         pst.setInt(21,Integer.parseInt(s4m1.getText()));
         pst.setInt(22,Integer.parseInt(s4m2.getText()));
         pst.setInt(23,Integer.parseInt(s4o.getText()));
         pst.setInt(24,Integer.parseInt(s4p.getText()));
         pst.setInt(25,Integer.parseInt(s4th.getText()));
         pst.setInt(26,Integer.parseInt(s4t.getText()));
         pst.setInt(27,Integer.parseInt(s5m1.getText()));
         pst.setInt(28,Integer.parseInt(s5m2.getText()));
         pst.setInt(29,Integer.parseInt(s5o.getText()));
         pst.setInt(30,Integer.parseInt(s5p.getText()));
         pst.setInt(31,Integer.parseInt(s5th.getText()));
         pst.setInt(32,Integer.parseInt(s5t.getText()));
         pst.setFloat(33,Float.parseFloat(cgpa.getText()));
         
         
         int rowcount =pst.executeUpdate();
         if (rowcount==1 )
         {
             status="success";
             JOptionPane.showMessageDialog(this, "Record inserted in sem2 successfully");
         }
         else
         {
            status ="failed";
            JOptionPane.showMessageDialog(this, "Record inserted unsuccessfull");
         }
        
         
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }  
    public void sem3()    
     {
     try
     {
         String status ="";
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("insert into SEM3(PNR,SNAME,S1M1,S1M2,S1O,S1P,S1TH,S1T,S2M1,S2M2,S2O,S2P,S2TH,S2T,S3M1,S3M2,S3O,S3P,S3TH,S3T,S4M1,S4M2,S4O,S4P,S4TH,S4T,S5M1,S5M2,S5O,S5P,S5TH,S5T,CGPA) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
         pst.setInt(1,Integer.parseInt(lbpnr.getText()));
         pst.setString(2,lbname.getText());
         pst.setInt(3,Integer.parseInt(s1m1.getText()));
         pst.setInt(4,Integer.parseInt(s1m2.getText()));
         pst.setInt(5,Integer.parseInt(s1o.getText()));
         pst.setInt(6,Integer.parseInt(s1p.getText()));
         pst.setInt(7,Integer.parseInt(s1th.getText()));
         pst.setInt(8,Integer.parseInt(s1t.getText()));
         pst.setInt(9,Integer.parseInt(s2m1.getText()));
         pst.setInt(10,Integer.parseInt(s2m2.getText()));
         pst.setInt(11,Integer.parseInt(s2o.getText()));
         pst.setInt(12,Integer.parseInt(s2p.getText()));
         pst.setInt(13,Integer.parseInt(s2th.getText()));
         pst.setInt(14,Integer.parseInt(s2t.getText()));
         pst.setInt(15,Integer.parseInt(s3m1.getText()));
         pst.setInt(16,Integer.parseInt(s3m2.getText()));
         pst.setInt(17,Integer.parseInt(s3o.getText()));
         pst.setInt(18,Integer.parseInt(s3p.getText()));
         pst.setInt(19 ,Integer.parseInt(s3th.getText()));
         pst.setInt(20,Integer.parseInt(s3t.getText()));
         pst.setInt(21,Integer.parseInt(s4m1.getText()));
         pst.setInt(22,Integer.parseInt(s4m2.getText()));
         pst.setInt(23,Integer.parseInt(s4o.getText()));
         pst.setInt(24,Integer.parseInt(s4p.getText()));
         pst.setInt(25,Integer.parseInt(s4th.getText()));
         pst.setInt(26,Integer.parseInt(s4t.getText()));
         pst.setInt(27,Integer.parseInt(s5m1.getText()));
         pst.setInt(28,Integer.parseInt(s5m2.getText()));
         pst.setInt(29,Integer.parseInt(s5o.getText()));
         pst.setInt(30,Integer.parseInt(s5p.getText()));
         pst.setInt(31,Integer.parseInt(s5th.getText()));
         pst.setInt(32,Integer.parseInt(s5t.getText()));
         pst.setFloat(33,Float.parseFloat(cgpa.getText()));
         
         
         int rowcount =pst.executeUpdate();
         if (rowcount==1 )
         {
             status="success";
             JOptionPane.showMessageDialog(this, "Record inserted in sem3 successfully");
         }
         else
         {
            status ="failed";
            JOptionPane.showMessageDialog(this, "Record inserted unsuccessfull");
         }
        
         
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 } 
    
    
     public void sem4()    
     {
     try
     {
         String status ="";
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("insert into SEM4(PNR,SNAME,S1M1,S1M2,S1O,S1P,S1TH,S1T,S2M1,S2M2,S2O,S2P,S2TH,S2T,S3M1,S3M2,S3O,S3P,S3TH,S3T,S4M1,S4M2,S4O,S4P,S4TH,S4T,S5M1,S5M2,S5O,S5P,S5TH,S5T,CGPA) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
         pst.setInt(1,Integer.parseInt(lbpnr.getText()));
         pst.setString(2,lbname.getText());
         pst.setInt(3,Integer.parseInt(s1m1.getText()));
         pst.setInt(4,Integer.parseInt(s1m2.getText()));
         pst.setInt(5,Integer.parseInt(s1o.getText()));
         pst.setInt(6,Integer.parseInt(s1p.getText()));
         pst.setInt(7,Integer.parseInt(s1th.getText()));
         pst.setInt(8,Integer.parseInt(s1t.getText()));
         pst.setInt(9,Integer.parseInt(s2m1.getText()));
         pst.setInt(10,Integer.parseInt(s2m2.getText()));
         pst.setInt(11,Integer.parseInt(s2o.getText()));
         pst.setInt(12,Integer.parseInt(s2p.getText()));
         pst.setInt(13,Integer.parseInt(s2th.getText()));
         pst.setInt(14,Integer.parseInt(s2t.getText()));
         pst.setInt(15,Integer.parseInt(s3m1.getText()));
         pst.setInt(16,Integer.parseInt(s3m2.getText()));
         pst.setInt(17,Integer.parseInt(s3o.getText()));
         pst.setInt(18,Integer.parseInt(s3p.getText()));
         pst.setInt(19 ,Integer.parseInt(s3th.getText()));
         pst.setInt(20,Integer.parseInt(s3t.getText()));
         pst.setInt(21,Integer.parseInt(s4m1.getText()));
         pst.setInt(22,Integer.parseInt(s4m2.getText()));
         pst.setInt(23,Integer.parseInt(s4o.getText()));
         pst.setInt(24,Integer.parseInt(s4p.getText()));
         pst.setInt(25,Integer.parseInt(s4th.getText()));
         pst.setInt(26,Integer.parseInt(s4t.getText()));
         pst.setInt(27,Integer.parseInt(s5m1.getText()));
         pst.setInt(28,Integer.parseInt(s5m2.getText()));
         pst.setInt(29,Integer.parseInt(s5o.getText()));
         pst.setInt(30,Integer.parseInt(s5p.getText()));
         pst.setInt(31,Integer.parseInt(s5th.getText()));
         pst.setInt(32,Integer.parseInt(s5t.getText()));
         pst.setFloat(33,Float.parseFloat(cgpa.getText()));
         
         
         int rowcount =pst.executeUpdate();
         if (rowcount==1 )
         {
             status="success";
             JOptionPane.showMessageDialog(this, "Record inserted in sem3 successfully");
         }
         else
         {
            status ="failed";
            JOptionPane.showMessageDialog(this, "Record inserted unsuccessfull");
         }
        
         
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 } 
    
    
    
    
    
    
    
    
    
    
     
    
    
    private int IntToString(String a,String b) {
    int i = 0;
      int j = 0;        
    try {
        i = Integer.parseInt(a);
      j = Integer.parseInt(b);

        
    } catch (NumberFormatException e) {
        i = 0;
        j = 0;
        e.printStackTrace();
    }
    return i+j;
}
      
     public String average(String a, String b)
   { int kts =0;
     int lmt  =0;
     String ust = null ;
   try{
         String kt = a;
          kts = Integer.parseInt(kt);
         String lt = b;
          lmt = Integer.parseInt(lt);
         ust= Integer.toString((kts+lmt)/2);
          }
          catch (NumberFormatException e) {
        kts = 0;
        lmt = 0;
        e.printStackTrace();
    }
          return ust;
     }
     
     public String percentge(String a, String b ,String c,String d){
        String tl = null;
      try   { 
             int cl = Integer.valueOf(a);
    int dl = Integer.valueOf(b);
    int el = Integer.valueOf(c);
    int nl = Integer.valueOf(d);
    int jl =(cl+dl+el+nl) ;
     tl = Integer.toString(jl);
          
          return tl;}
      catch(NumberFormatException e){
          e.printStackTrace();
      }
      
      
      return tl;
     }
    
     //boolean dataEntry()
     //{
         
    // }
    

    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        m1 = new javax.swing.JLabel();
        m2 = new javax.swing.JLabel();
        mt = new javax.swing.JLabel();
        o = new javax.swing.JLabel();
        t = new javax.swing.JLabel();
        th = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        s1m2 = new javax.swing.JTextField();
        s1mt = new javax.swing.JTextField();
        s2m1 = new javax.swing.JTextField();
        s3m1 = new javax.swing.JTextField();
        s4m1 = new javax.swing.JTextField();
        s5m1 = new javax.swing.JTextField();
        s1th = new javax.swing.JTextField();
        s1o = new javax.swing.JTextField();
        s1p = new javax.swing.JTextField();
        s2m2 = new javax.swing.JTextField();
        s3m2 = new javax.swing.JTextField();
        s4m2 = new javax.swing.JTextField();
        s5m2 = new javax.swing.JTextField();
        s2mt = new javax.swing.JTextField();
        s3mt = new javax.swing.JTextField();
        s4mt = new javax.swing.JTextField();
        s5mt = new javax.swing.JTextField();
        s2o = new javax.swing.JTextField();
        s3o = new javax.swing.JTextField();
        s2p = new javax.swing.JTextField();
        s2th = new javax.swing.JTextField();
        s4o = new javax.swing.JTextField();
        s3p = new javax.swing.JTextField();
        s4p = new javax.swing.JTextField();
        s1t = new javax.swing.JTextField();
        s2t = new javax.swing.JTextField();
        s3t = new javax.swing.JTextField();
        s4t = new javax.swing.JTextField();
        s5t = new javax.swing.JTextField();
        cgpa = new javax.swing.JTextField();
        s3th = new javax.swing.JTextField();
        s4th = new javax.swing.JTextField();
        s5th = new javax.swing.JTextField();
        s5o = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        s1m1 = new javax.swing.JTextField();
        s5p = new javax.swing.JTextField();
        lbpnr = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        semname = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_main.setBackground(new java.awt.Color(0, 153, 153));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnl_main.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton2.setText("Enter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnl_main.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 640, 90, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 11, 69, -1));

        m1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        m1.setText("m1");
        jPanel1.add(m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 69, -1));

        m2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        m2.setText("m2");
        jPanel1.add(m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 11, 60, -1));

        mt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mt.setText("mt");
        jPanel1.add(mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 11, 69, -1));

        o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        o.setText("o");
        jPanel1.add(o, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 69, -1));

        t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t.setText("total");
        jPanel1.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 11, 69, -1));

        th.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        th.setText("th");
        jPanel1.add(th, new org.netbeans.lib.awtextra.AbsoluteConstraints(586, 11, 69, -1));

        p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        p.setText("pr");
        jPanel1.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 11, 60, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 10, 510));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 810, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 810, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 810, 10));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 810, 10));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 810, 10));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 810, 10));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 10, 510));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 10, 410));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 10, 410));

        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 10, 410));

        jSeparator12.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 10, 410));

        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 10, 410));

        s1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1.setText("s1");
        jPanel1.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, -1));

        s2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2.setText("s2");
        jPanel1.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 20));

        s3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3.setText("s3");
        jPanel1.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, -1));

        s4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4.setText("s4");
        jPanel1.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, -1));

        s5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5.setText("s5");
        jPanel1.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 90, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("cgpa");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 432, 40, 30));

        s1m2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s1m2MouseExited(evt);
            }
        });
        s1m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1m2ActionPerformed(evt);
            }
        });
        jPanel1.add(s1m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 70, -1));

        s1mt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1mt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1mtActionPerformed(evt);
            }
        });
        jPanel1.add(s1mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 70, -1));

        s2m1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2m1ActionPerformed(evt);
            }
        });
        jPanel1.add(s2m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 90, -1));

        s3m1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3m1ActionPerformed(evt);
            }
        });
        jPanel1.add(s3m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 90, 30));

        s4m1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s4m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 90, -1));

        s5m1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s5m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 90, -1));

        s1th.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s1thMouseExited(evt);
            }
        });
        s1th.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1thActionPerformed(evt);
            }
        });
        jPanel1.add(s1th, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 70, -1));

        s1o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1oActionPerformed(evt);
            }
        });
        jPanel1.add(s1o, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 70, -1));

        s1p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s1p, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 60, -1));

        s2m2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s2m2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s2m2MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                s2m2MouseReleased(evt);
            }
        });
        jPanel1.add(s2m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 70, -1));

        s3m2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s3m2MouseExited(evt);
            }
        });
        jPanel1.add(s3m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 70, -1));

        s4m2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s4m2MouseExited(evt);
            }
        });
        jPanel1.add(s4m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 70, -1));

        s5m2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5m2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s5m2MouseExited(evt);
            }
        });
        jPanel1.add(s5m2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 70, -1));

        s2mt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s2mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 70, -1));

        s3mt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3mt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3mtActionPerformed(evt);
            }
        });
        jPanel1.add(s3mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 70, -1));

        s4mt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4mt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4mtActionPerformed(evt);
            }
        });
        jPanel1.add(s4mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 70, -1));

        s5mt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5mt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5mtActionPerformed(evt);
            }
        });
        jPanel1.add(s5mt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 70, -1));

        s2o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s2o, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 70, -1));

        s3o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s3o, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 70, -1));

        s2p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s2p, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 60, -1));

        s2th.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s2thMouseExited(evt);
            }
        });
        jPanel1.add(s2th, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 70, -1));

        s4o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4oActionPerformed(evt);
            }
        });
        jPanel1.add(s4o, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 70, -1));

        s3p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3pActionPerformed(evt);
            }
        });
        jPanel1.add(s3p, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 60, -1));

        s4p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s4p, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 60, -1));

        s1t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s1tMouseExited(evt);
            }
        });
        s1t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1tActionPerformed(evt);
            }
        });
        jPanel1.add(s1t, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, 100, 30));

        s2t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s2tMouseExited(evt);
            }
        });
        s2t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2tActionPerformed(evt);
            }
        });
        jPanel1.add(s2t, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 100, -1));

        s3t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s3tMouseExited(evt);
            }
        });
        jPanel1.add(s3t, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 100, -1));

        s4t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s4tMouseExited(evt);
            }
        });
        s4t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4tActionPerformed(evt);
            }
        });
        jPanel1.add(s4t, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 100, -1));

        s5t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s5tMouseExited(evt);
            }
        });
        s5t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5tActionPerformed(evt);
            }
        });
        jPanel1.add(s5t, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 100, -1));

        cgpa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(cgpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 100, -1));

        s3th.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s3thMouseExited(evt);
            }
        });
        jPanel1.add(s3th, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 70, -1));

        s4th.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s4thMouseExited(evt);
            }
        });
        jPanel1.add(s4th, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 70, -1));

        s5th.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                s5thMouseExited(evt);
            }
        });
        jPanel1.add(s5th, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 70, -1));

        s5o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5o.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5oActionPerformed(evt);
            }
        });
        jPanel1.add(s5o, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 70, -1));

        jTextField35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField35.setText("jTextField1");
        jPanel1.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 60, -1));

        s1m1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(s1m1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 90, -1));

        s5p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5pActionPerformed(evt);
            }
        });
        jPanel1.add(s5p, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 60, -1));

        lbpnr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbpnr.setText("158");

        lbname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbname.setText("Name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("jLabel6");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("PNR:-");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Name:-");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Branch:-");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("SEM:-");

        semname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        semname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", " " }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbpnr, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lbname, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(semname, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbpnr)
                    .addComponent(lbname)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(semname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_main.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 860, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setBounds(420, 0, 966, 809);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void s1mtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1mtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1mtActionPerformed

    private void s2m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2m1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2m1ActionPerformed

    private void s1thActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1thActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1thActionPerformed

    private void s1oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1oActionPerformed

    private void s1tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1tActionPerformed

    private void s5oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5oActionPerformed

    private void s3m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3m1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3m1ActionPerformed

    private void s1m2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1m2ActionPerformed
 // TODO add your handling code here:
    }//GEN-LAST:event_s1m2ActionPerformed

    private void s3mtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3mtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3mtActionPerformed

    private void s4mtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4mtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4mtActionPerformed

    private void s5mtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5mtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5mtActionPerformed

    private void s4oActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4oActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4oActionPerformed

    private void s3pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3pActionPerformed
 // TODO add your handling code here:
    }//GEN-LAST:event_s3pActionPerformed

    private void s5pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5pActionPerformed

    private void s2tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2tActionPerformed

    private void s4tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4tActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      if (semname.getSelectedIndex()==0)
      {sem1(); 
      }
       if (semname.getSelectedIndex()==1)
      {sem2(); 
      }  
        if (semname.getSelectedIndex()==2 )
      {sem3(); 
      } 
        if (semname.getSelectedIndex()==3 )
      {sem4(); 
      }  // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void s2m2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s2m2MouseReleased
         // TODO add your handling code here:
    }//GEN-LAST:event_s2m2MouseReleased

    private void s2m2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s2m2MouseClicked
                 // TODO add your handling code here:
    }//GEN-LAST:event_s2m2MouseClicked

    private void s2m2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s2m2MouseExited
    // String ik = s2m1.getText();
    //String lk = s2m2.getText();
    
        s2mt.setText(average( s2m1.getText(), s2m2.getText()));
        // TODO add your handling code here:
    }//GEN-LAST:event_s2m2MouseExited

    private void s1thMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s1thMouseExited
  s1t.setText(percentge(s1mt.getText(),s1o.getText(),s1p.getText(),s1th.getText()));    
        
                   // TODO add your handling code here:
    }//GEN-LAST:event_s1thMouseExited

    private void s1m2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s1m2MouseExited
      String nqs = s1m1.getText();
       String fqs = s1m2.getText();
        s1mt.setText(average(nqs,fqs));
         // TODO add your handling code here:
    }//GEN-LAST:event_s1m2MouseExited

    private void s3m2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s3m2MouseExited
        String lmt =s3m1.getText();
        String lnt =s3m2.getText();
        s3mt.setText(average(lmt,lnt));
       // TODO add your handling code here:
    }//GEN-LAST:event_s3m2MouseExited

    private void s4m2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s4m2MouseExited
        s4mt.setText(average(s4m1.getText(),s4m2.getText()));
                 // TODO add your handling code here:
    }//GEN-LAST:event_s4m2MouseExited

    private void s5m2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s5m2MouseExited
        s5mt.setText(average(s5m1.getText(),s5m2.getText()));         
                // TODO add your handling code here:
    }//GEN-LAST:event_s5m2MouseExited

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
               // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseExited

    private void s3tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s3tMouseExited
                          // TODO add your handling code here:
    }//GEN-LAST:event_s3tMouseExited

    private void s4tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s4tMouseExited
           // TODO add your handling code here:  
    }//GEN-LAST:event_s4tMouseExited

    private void s5tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s5tMouseExited
        
            

         // TODO add your handling code here:
    }//GEN-LAST:event_s5tMouseExited

    private void s2tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s2tMouseExited
            // TODO add your handling code here:
    }//GEN-LAST:event_s2tMouseExited

    private void s1tMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s1tMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_s1tMouseExited

    private void s2thMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s2thMouseExited
           String qtr = s2o.getText();
            String qsr = s2p.getText();
             String qpr = s2th.getText();
       s2t.setText( percentge(s2mt.getText(),qtr  , qsr,qpr));                // TODO add your handling code here:
    }//GEN-LAST:event_s2thMouseExited

    private void s3thMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s3thMouseExited
                       String ltr = s3o.getText();
            String lsr = s3p.getText();
             String lpr = s3th.getText();
       s3t.setText( percentge(s3mt.getText(),ltr  , lsr,lpr));   // TODO add your handling code here:
    }//GEN-LAST:event_s3thMouseExited

    private void s4thMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s4thMouseExited
               String otr = s4o.getText();
            String osr = s4p.getText();
             String opr = s4th.getText();
       s4t.setText( percentge(s4mt.getText(),otr  , osr,opr)); // TODO add your handling code here:
    }//GEN-LAST:event_s4thMouseExited

    private void s5thMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s5thMouseExited
               String ktr = s5o.getText();
            String ksr = s5p.getText();
             String kpr = s5th.getText();
       s5t.setText( percentge(s5mt.getText(),ktr  , ksr,kpr)); // TODO add your handling code here:
    }//GEN-LAST:event_s5thMouseExited

    private void s5tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5tActionPerformed
           int i= 0;
           int j= 0;   
   int k= 0;   
   int l= 0;   
   int y=0;
   int m =0;
     try { i=Integer.parseInt(s1t.getText());
     j=Integer.parseInt(s2t.getText());
     k=Integer.parseInt(s3t.getText());
     l=Integer.parseInt(s4t.getText());
     y=Integer.parseInt(s5t.getText());
     m= (i+j+k+l+y+m)*100;
     String s = Integer.toString(m/625);
     cgpa.setText(s);
     }
     catch(NumberFormatException e){
         i= 0;
           j= 0;   
    k= 0;   
    l= 0;   
   y=0;
    m =0;
     e.printStackTrace();}  // TODO add your handling code here:
    }//GEN-LAST:event_s5tActionPerformed

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
            java.util.logging.Logger.getLogger(marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new marksheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cgpa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField35;
    public static javax.swing.JLabel lbname;
    public static javax.swing.JLabel lbpnr;
    private javax.swing.JLabel m1;
    private javax.swing.JLabel m2;
    private javax.swing.JLabel mt;
    private javax.swing.JLabel o;
    private javax.swing.JLabel p;
    private javax.swing.JPanel pnl_main;
    public static javax.swing.JLabel s1;
    private javax.swing.JTextField s1m1;
    private javax.swing.JTextField s1m2;
    private javax.swing.JTextField s1mt;
    private javax.swing.JTextField s1o;
    public javax.swing.JTextField s1p;
    private javax.swing.JTextField s1t;
    private javax.swing.JTextField s1th;
    public static javax.swing.JLabel s2;
    private javax.swing.JTextField s2m1;
    private javax.swing.JTextField s2m2;
    private javax.swing.JTextField s2mt;
    private javax.swing.JTextField s2o;
    private javax.swing.JTextField s2p;
    private javax.swing.JTextField s2t;
    private javax.swing.JTextField s2th;
    public static javax.swing.JLabel s3;
    private javax.swing.JTextField s3m1;
    private javax.swing.JTextField s3m2;
    private javax.swing.JTextField s3mt;
    private javax.swing.JTextField s3o;
    private javax.swing.JTextField s3p;
    private javax.swing.JTextField s3t;
    private javax.swing.JTextField s3th;
    public static javax.swing.JLabel s4;
    private javax.swing.JTextField s4m1;
    private javax.swing.JTextField s4m2;
    private javax.swing.JTextField s4mt;
    private javax.swing.JTextField s4o;
    private javax.swing.JTextField s4p;
    private javax.swing.JTextField s4t;
    private javax.swing.JTextField s4th;
    public static javax.swing.JLabel s5;
    private javax.swing.JTextField s5m1;
    private javax.swing.JTextField s5m2;
    private javax.swing.JTextField s5mt;
    private javax.swing.JTextField s5o;
    private javax.swing.JTextField s5p;
    private javax.swing.JTextField s5t;
    private javax.swing.JTextField s5th;
    public static javax.swing.JComboBox<String> semname;
    private javax.swing.JLabel t;
    private javax.swing.JLabel th;
    // End of variables declaration//GEN-END:variables
}

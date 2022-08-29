
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class ReportGenerate extends javax.swing.JFrame {

    /**
     * Creates new form ReportGenerate
     */
   // DefaultTableModel model;
    public ReportGenerate() {
        initComponents();
        fillcombox();
        fillTable();
        
    }
     //DefaultTableModel model;
    public void fillcombox()
 {
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select cname from course1");
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {combo_courseDetails.addItem(rs.getString("cname"));
         }
     
     
     
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tbl_feesDetails.getModel();
        model.setRowCount(1);
    }
    
    public void setRecordsToTable(){
        String cname = combo_courseDetails.getSelectedItem().toString();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String fromDate= dateFormat.format(DCfrom.getDate());
        String toDate= dateFormat.format(DCto.getDate());
        
        Float amountTotal = 0.0f;
        
        
    
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
            PreparedStatement pst = conn.prepareStatement("select * from FEES_DETAILS where DATE between ? and ? and COURSE_NAME = ?");
            pst.setString(1, fromDate);
            pst.setString(2,toDate);
            pst.setString(3, cname);
            
            
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                
                String ReceiptNo= rs.getString("RECIEPT_NO");
                String RollNo = rs.getString("ROLL_NO");
                String StudentName = rs.getString("STUDENT_NAME");
                String course = rs.getString("COURSE_NAME");
                Float amount = rs.getFloat("TOTAL_AMOUNT");
                String remark = rs.getString("REMARK");
                
               
               //String  s =Float.toString(amountTotal); 
                 Object Tdata[] = {ReceiptNo,RollNo,StudentName,course,amount,remark};
                
             
              DefaultTableModel sa;
                sa = (DefaultTableModel)tbl_feesDetails.getModel();
              sa.addRow(Tdata);
               amountTotal = amountTotal + amount;
              
            }
            lbl_course.setText(cname);
            String s = Float.toString(amountTotal);
            lbl_totalAmt.setText(s);
            lbl_totalWords.setText(NumberToWordsConverter.convert(amountTotal.intValue()));}

       catch (Exception e) {
            e.printStackTrace(); }

} 
    public void fillTable()    
     {
     try
     {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection conn =DriverManager.getConnection("jdbc:derby://localhost:1527/login","root","root");
         PreparedStatement pst = conn.prepareStatement("select * from FEES_DETAILS");
         ResultSet rs = pst.executeQuery();
         while(rs.next())
         {  
             String id =String.valueOf(rs.getString("RECIEPT_NO"));
             String name =rs.getString("STUDENT_NAME");
             String branch =rs.getString("BRANCH_NAME");
             String course =rs.getString("COURSE_NAME");
             String TotalAmount =rs.getString("TOTAL_AMOUNT");
             String remaining =rs.getString("REMARK");
             String remark =rs.getString("REMIANING");
              String category =rs.getString("CCATEGORY");
             
             
             String Tdata[]={id,name,branch,course,TotalAmount,remaining,remark,category};
             DefaultTableModel model = (DefaultTableModel)tbl_feesDetails.getModel();
                   model.addRow(Tdata);
             
         }
     
     
     
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
    public void createExcel()
    { XSSFWorkbook wb = new XSSFWorkbook();
      XSSFSheet ws = wb.createSheet(); 
      DefaultTableModel model = (DefaultTableModel)tbl_feesDetails.getModel();
    
      TreeMap<String,Object[]>map = new TreeMap<String,Object[]>();
      map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),
          model.getColumnName(4),model.getColumnName(5) 
      });
      
      for(int i= 1;i<model.getRowCount();i++)
      {
          map.put(Integer.toString(i),new Object[]{model.getValueAt(i, 0),model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3),
          model.getValueAt(i, 4),model.getValueAt(i, 5) 
      });
      }
      Set<String>id =map.keySet();
      XSSFRow fRow;
      int rowId =0;
      for (String Key:id)
      {
          fRow =ws.createRow(rowId++);
          Object []value =map.get(Key); 
          int cellId =0;
          for(Object object:value)
          {
          XSSFCell cell =fRow.createCell(cellId++);
          cell.setCellValue(object.toString());
          }
          
          try(FileOutputStream fos =new FileOutputStream(new File(jTextField1.getText()) ) )
          {
              wb.write(fos);
              JOptionPane.showMessageDialog(this, "File exported successfully"+jTextField1.getText());
          }catch(Exception e){e.printStackTrace();}
          
      }
      
      
      
      
      
      
      
    }
    
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
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        combo_courseDetails = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        DCto = new org.netbeans.modules.form.InvalidComponent();
        DCfrom = new org.netbeans.modules.form.InvalidComponent();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_feesDetails = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        lbl_course = new javax.swing.JLabel();
        lbl_totalWords = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_totalAmt = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

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

        pnl_sidebar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 330, 70));

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

        pnl_sidebar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 330, 70));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/search2.png"))); // NOI18N
        jLabel3.setText("Search Record");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        pnl_sidebar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 330, 70));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/edit2.png"))); // NOI18N
        jLabel5.setText("Edit Course");
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

        pnl_sidebar.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 330, 70));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/list_1.png"))); // NOI18N
        jLabel7.setText("Course List");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/home.png"))); // NOI18N
        jLabel8.setText("Home");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 330, 70));

        pnl_sidebar.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 330, 70));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/view all record.png"))); // NOI18N
        jLabel9.setText("View Record");
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

        pnl_sidebar.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 330, 70));

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

        pnl_sidebar.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 330, 70));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my icons/view all record.png"))); // NOI18N
        jLabel13.setText(" Report");
        pnl_sidebar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 310, 70));
        pnl_sidebar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 350, 20));

        getContentPane().add(pnl_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 730));

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("To :");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 40, 30));

        combo_courseDetails.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        combo_courseDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseDetailsActionPerformed(evt);
            }
        });
        jPanel13.add(combo_courseDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 200, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Select Course :");
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Select Date :");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("From :");
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 30));

        jPanel13.add(DCto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 180, 30));

        jPanel13.add(DCfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 160, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 170, 40));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 310, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton3.setText("Import To Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 240, 50));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 170, 40));

        tbl_feesDetails.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbl_feesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No.", "Roll No.", "Student Name", "Course", "Amount Paid", "No. of Installments", "Balance"
            }
        ));
        jScrollPane1.setViewportView(tbl_feesDetails);

        jPanel13.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 890, 330));

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(255, 255, 255), null, null));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_course.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        lbl_course.setText("Blank");
        jPanel14.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 130, 30));

        lbl_totalWords.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_totalWords.setForeground(new java.awt.Color(255, 255, 255));
        lbl_totalWords.setText("Blank");
        jPanel14.add(lbl_totalWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 380, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Course Selected :");
        jPanel14.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total Amount Collected :");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 40));

        lbl_totalAmt.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lbl_totalAmt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(lbl_totalAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Total Amount Collected in Words :");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 270, 40));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 370, 240));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 990, 710));

        setSize(new java.awt.Dimension(1367, 784));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        Home_page a = new Home_page();
        a.setVisible(true);
        this.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        Home_page a = new Home_page();
        a.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                JFileChooser fileChooser = new   JFileChooser ();
                fileChooser.showOpenDialog(this);
 SimpleDateFormat dateFormate = new  SimpleDateFormat ("YYY-MM-dd"); 
 String date = dateFormate.format(new Date()); 
try{
    File f = fileChooser.getSelectedFile();
    String path = f.getAbsolutePath();
    path = path+""+date+".xlsx";
    jTextField1.setText(path);
    
 
}catch(Exception e){}
 // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          createExcel();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
       String dateFrom = Date_Format.format(DCfrom.getDate());
       String dateTo = Date_Format.format(DCto.getDate());
       
       MessageFormat header= new MessageFormat("Report From " + dateFrom + " To" +dateTo);
       MessageFormat footer= new MessageFormat("page{0,number,integer}");
       try 
{
tbl_feesDetails.print(JTable.PrintMode.FIT_WIDTH, header, footer);
}
catch (Exception e){
e.getMessage();
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    clearTable();
    setRecordsToTable();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_courseDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_courseDetailsActionPerformed

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
            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportGenerate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportGenerate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.netbeans.modules.form.InvalidComponent DCfrom;
    private org.netbeans.modules.form.InvalidComponent DCto;
    private javax.swing.JComboBox<String> combo_courseDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_totalAmt;
    private javax.swing.JLabel lbl_totalWords;
    private javax.swing.JPanel pnl_sidebar;
    private javax.swing.JTable tbl_feesDetails;
    // End of variables declaration//GEN-END:variables
}

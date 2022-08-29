/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class att1 extends javax.swing.JFrame {

    /**
     * Creates new form att1
     */
    public att1() {
        initComponents();
    }
    void subject()
    {
     if (cb_sem.getSelectedIndex()==0)
        {
            s1.setText("EM-1");
            s2.setText("EP-1");
            s3.setText("EC-1");
            s4.setText("BEE");
            s5.setText("Mech");
        }
        if (cb_sem.getSelectedIndex()==1)
        {
            s1.setText("EM-2");
            s2.setText("EP-2");
            s3.setText("EC-2");
            s4.setText("EG");
            s5.setText("PCE-1");
        }
        if (cb_sem.getSelectedIndex()==2)
        {
            String b = txt_branch.getText();
            if (b=="Computer")
            {
                s1.setText("EM-3");
                s2.setText("DSGT");
                s3.setText("DS");
                s4.setText("DLCA");
                s5.setText("CG");
            }
            if (b=="Electrical")
            {
                s1.setText("EM-3");
                s2.setText("EDC");
                s3.setText("DSD");
                s4.setText("NT");
                s5.setText("EICS");
            }
            if (b=="Mechanical")
            {
                s1.setText("EM-3");
                s2.setText("SM");
                s3.setText("PP");
                s4.setText("M&M");
                s5.setText("Thermo");
            }
            if (b=="It")
            {
                s1.setText("EM-3");
                s2.setText("DS&AA");
                s3.setText("OOPM");
                s4.setText("A&AC");
                s5.setText("DBMS");
                
            }
            if(b=="AI&DS")
            {
                s1.setText("DM");
                s2.setText("DS&A");
                s3.setText("OOP");
                s4.setText("CS&CV");
                s5.setText("OS");
                
            }
        }
        if (cb_sem.getSelectedIndex()==3)
        {
            String b= txt_branch.getText();
            if(b=="Computer")
            {
                s1.setText("EM-4");
                s2.setText("AOA");
                s3.setText("DBMS");
                s4.setText("OS");
                s5.setText("MP");
                
            }
            if (b=="Electrical")
            {
                s1.setText("EM-4");
                s2.setText("MC");
                s3.setText("LIC");
                s4.setText("S&S");
                s5.setText("POCE");
                
            }
            if (b=="Mechanical")
            {
                s1.setText("EM-4");
                s2.setText("FM");
                s3.setText("KM");
                s4.setText("CAD/CAM");
                s5.setText("IE");
            }
            if (b=="It")
            {
                s1.setText("EM-4");
                s2.setText("CN");
                s3.setText("COA");
                s4.setText("AT");
                s5.setText("WP");
            }
            if (b=="Ai&DS")
            {
                s1.setText("STATS");
                s2.setText("IOT");
                s3.setText("SE");
                s4.setText("DBMS");
                s5.setText("MIS");
            }
        }
        if (cb_sem.getSelectedIndex()==4)
        {
            String b=txt_branch.getText();
            if (b=="Computer")
            {
                s1.setText("TCS");
                s2.setText("SE");
                s3.setText("CN");
                s4.setText("DW&M");
                s5.setText("DLOC-1");
            }
            if (b=="Electrical")
            {
                s1.setText("EACM-2");
                s2.setText("EPS-2");
                s3.setText("CS");
                s4.setText("EF&W");
                s5.setText("DLOC-1");
                
            }
            if (b=="Mechanical")
            {
                s1.setText("ICE");
                s2.setText("MM&C");
                s3.setText("HT");
                s4.setText("DOM");
                s5.setText("DLOC-1");
                
                
            }
            if (b=="It")
            {
                s1.setText("IP");
                s2.setText("CNS");
                s3.setText("E&E-B");
                s4.setText("SE");
                s5.setText("DLOC-1");
                
            }
            if (b=="AI&DS")
            {
                
            }
        if (cb_sem.getSelectedIndex()==5)
        {
            String c=txt_branch.getText();
            if (c=="Computer")
            {
                s1.setText("SP&CC");
                s2.setText("C&SS");
                s3.setText("Mc");
                s4.setText("Ai");
                s5.setText("DLOC-2");
            }
            if (c=="Electrical")
            {
                s1.setText("BVLSID");
                s2.setText("EME");
                s3.setText("CCN");
                s4.setText("ES&RTOS");
                s5.setText("DLOC-2");
                
            }
            if (c=="MEchanical")
            {
                
           
                s1.setText("MD");
                s2.setText("TM");
                s3.setText("HVAC&R");
                s4.setText("A&AI");
                s5.setText("DLOC-2");
                
            }
            if (c=="It")
            {
                s1.setText("DM&BI");
                s2.setText("WX.0");
                s3.setText("WT");
                s4.setText("AI&DS-1");
                s5.setText("DLOC-2");
            }
            if(c=="AI&DS")
            {
                
            }
        }
        if (cb_sem.getSelectedIndex()==6)
        {
            String c=txt_branch.getText();
            if (c=="Computer")
            {
                s1.setText("DS&IP");
                s2.setText("MC&C");
                s3.setText("AI&SC");
                s4.setText("DLOC");
                s5.setText("ILOC-1");
                
            }if ( c=="ELectrical")
            {
                s1.setText("PS-3");
                s2.setText("D&C");
                s3.setText("HVDTC");
                s4.setText("DLOC-3");
                s5.setText("ILOC-1");
                
            }
            if (c=="Mechanical")
            {
                s1.setText("MD-2");
                s2.setText("PP&C");
                s3.setText("DlOC-3");
                s4.setText("CAD");
                s5.setText("ILOC-1");
                
            }
            if (c=="It")
            {
                s1.setText("END");
                s2.setText("IS");
                s3.setText("AI");
                s4.setText("DLOC-3");
                s5.setText("ILOC-1");
            }
            
        }
        if (cb_sem.getSelectedIndex()==7)
        {
            String d= txt_branch.getText();
            if (d== "Computer")
            {
                s1.setText("HMI");
                s2.setText("DC");
                s3.setText("DlOC-4");
                s4.setText("ILOC-2");
                s5.setText("");
                
            }
            if (d=="Electrical")
            {
                s1.setText("DM&AES");
                s2.setText("FACTS");
                s3.setText("DLOC-4");
                s4.setText("ILOC-2");
                s5.setText("");
                
            }
            if ( d== "Mechanical")
            {
                s1.setText("DOMS");
                s2.setText("IE&M");
                s3.setText("PE");
                s4.setText("DLOC-4");
                s5.setText("ILOC-2");
            }
            if (d== "It")
            {
                s1.setText("BDA");
                s2.setText("IOE");
                s3.setText("DLOC-4");
                s4.setText("ILOC-2");
                s5.setText("");
                
            }
        }
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_branch = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_sem = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_pnr = new javax.swing.JLabel();
        txt_name = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        s1 = new javax.swing.JLabel();
        s2 = new javax.swing.JLabel();
        s3 = new javax.swing.JLabel();
        s4 = new javax.swing.JLabel();
        s5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        s2l = new javax.swing.JTextField();
        s3l = new javax.swing.JTextField();
        s4l = new javax.swing.JTextField();
        s5l = new javax.swing.JTextField();
        s1p = new javax.swing.JTextField();
        s2p = new javax.swing.JTextField();
        s3p = new javax.swing.JTextField();
        s4p = new javax.swing.JTextField();
        s5p = new javax.swing.JTextField();
        s1t = new javax.swing.JTextField();
        s2t = new javax.swing.JTextField();
        s3t = new javax.swing.JTextField();
        s4t = new javax.swing.JTextField();
        att = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        s1l1 = new javax.swing.JTextField();
        s5t1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Back");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Sem :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 70, 40));

        txt_branch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_branch.setText(".");
        jPanel1.add(txt_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 160, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 70, 40));

        cb_sem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_sem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem 1", "Sem 2", "Sem 3", "Sem 3", "Sem 4", "Sem 5", "Sem 6", "Sem 7", "Sem 8" }));
        cb_sem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_semActionPerformed(evt);
            }
        });
        jPanel1.add(cb_sem, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 120, 90, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Branch :");
        jLabel4.setToolTipText("");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 80, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("PNR :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 60, 40));

        lbl_pnr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pnr.setText(".");
        jPanel1.add(lbl_pnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, 40));

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_name.setText(".");
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 280, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 830, 20));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 10, 420));

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 10, 420));

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 10, 490));

        jSeparator5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 830, 10));

        jSeparator6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 830, 20));

        jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 830, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 830, 10));

        jSeparator9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 830, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Attendance");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 150, 50));

        s1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1.setText("s1");
        jPanel2.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 50));

        s2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2.setText("s2");
        jPanel2.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 120, 50));

        s3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3.setText("s3");
        jPanel2.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 120, 50));

        s4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4.setText("s4");
        jPanel2.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, 50));

        s5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5.setText("s5");
        jPanel2.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 120, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Subject");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Total No. of Lectures");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 210, 50));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Total No. of Practicals");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 200, 50));

        s2l.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2lActionPerformed(evt);
            }
        });
        jPanel2.add(s2l, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 130, 50));

        s3l.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3lActionPerformed(evt);
            }
        });
        jPanel2.add(s3l, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 130, 50));

        s4l.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4lActionPerformed(evt);
            }
        });
        jPanel2.add(s4l, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 130, 50));

        s5l.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5lActionPerformed(evt);
            }
        });
        jPanel2.add(s5l, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 130, 50));

        s1p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1pActionPerformed(evt);
            }
        });
        jPanel2.add(s1p, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 130, 50));

        s2p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2pActionPerformed(evt);
            }
        });
        jPanel2.add(s2p, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 130, 50));

        s3p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3pActionPerformed(evt);
            }
        });
        jPanel2.add(s3p, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 130, 50));

        s4p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4pActionPerformed(evt);
            }
        });
        jPanel2.add(s4p, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 130, 50));

        s5p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5pActionPerformed(evt);
            }
        });
        jPanel2.add(s5p, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 130, 50));

        s1t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1tActionPerformed(evt);
            }
        });
        jPanel2.add(s1t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 130, 50));

        s2t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s2t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2tActionPerformed(evt);
            }
        });
        jPanel2.add(s2t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 130, 50));

        s3t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s3t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3tActionPerformed(evt);
            }
        });
        jPanel2.add(s3t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 130, 50));

        s4t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s4t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4tActionPerformed(evt);
            }
        });
        jPanel2.add(s4t, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 130, 50));

        att.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        att.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attActionPerformed(evt);
            }
        });
        jPanel2.add(att, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, 130, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Total");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 120, 50));

        s1l1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s1l1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1l1ActionPerformed(evt);
            }
        });
        jPanel2.add(s1l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 130, 50));

        s5t1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s5t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5t1ActionPerformed(evt);
            }
        });
        jPanel2.add(s5t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 130, 50));

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Calculate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 120, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 830, 490));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Save");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 700, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_semActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_semActionPerformed
        subject();
    }//GEN-LAST:event_cb_semActionPerformed

    private void s2lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2lActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2lActionPerformed

    private void s3lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3lActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3lActionPerformed

    private void s4lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4lActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4lActionPerformed

    private void s5lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5lActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5lActionPerformed

    private void s1pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1pActionPerformed

    private void s2pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2pActionPerformed

    private void s3pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3pActionPerformed

    private void s4pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4pActionPerformed

    private void s5pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5pActionPerformed

    private void s1tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1tActionPerformed

    private void s2tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2tActionPerformed

    private void s3tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3tActionPerformed

    private void s4tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4tActionPerformed

    private void attActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_attActionPerformed

    private void s1l1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1l1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1l1ActionPerformed

    private void s5t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5t1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        double t1= Double.parseDouble(s1t.getText());
        double t2= Double.parseDouble(s2t.getText());
        double t3=Double.parseDouble(s3t.getText());
        double t4=Double.parseDouble(s4t.getText());
        double t5=Double.parseDouble(s5t1.getText());

        double avg = (t1+t2+t3+t4+t5)/100;

        att.setText(Double.toString(avg));

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(att1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(att1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(att1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(att1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new att1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField att;
    public static javax.swing.JComboBox<String> cb_sem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public static javax.swing.JLabel lbl_pnr;
    private javax.swing.JLabel s1;
    private javax.swing.JTextField s1l1;
    private javax.swing.JTextField s1p;
    private javax.swing.JTextField s1t;
    private javax.swing.JLabel s2;
    public javax.swing.JTextField s2l;
    private javax.swing.JTextField s2p;
    private javax.swing.JTextField s2t;
    private javax.swing.JLabel s3;
    private javax.swing.JTextField s3l;
    private javax.swing.JTextField s3p;
    private javax.swing.JTextField s3t;
    private javax.swing.JLabel s4;
    private javax.swing.JTextField s4l;
    private javax.swing.JTextField s4p;
    private javax.swing.JTextField s4t;
    private javax.swing.JLabel s5;
    private javax.swing.JTextField s5l;
    private javax.swing.JTextField s5p;
    private javax.swing.JTextField s5t1;
    public static javax.swing.JLabel txt_branch;
    public static javax.swing.JLabel txt_name;
    // End of variables declaration//GEN-END:variables
}

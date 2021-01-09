/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import ThongTin.DanhSachSanPham;
import ThongTin.LoaiSanPham;
import ThongTin.SanPham;
import java.awt.CardLayout;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ASUS
 */
public class ThongKeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeJPanel
     */
    public ThongKeJPanel() {
        
        initComponents();
        Setup();
        DanhMucXem.setVisible(true);

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
        BieuDoJPanel = new javax.swing.JPanel();
        DanhMucXem = new javax.swing.JComboBox<>();
        NutSanPham = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout BieuDoJPanelLayout = new javax.swing.GroupLayout(BieuDoJPanel);
        BieuDoJPanel.setLayout(BieuDoJPanelLayout);
        BieuDoJPanelLayout.setHorizontalGroup(
            BieuDoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        BieuDoJPanelLayout.setVerticalGroup(
            BieuDoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );

        DanhMucXem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DanhMucXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DanhMucXemActionPerformed(evt);
            }
        });

        NutSanPham.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NutSanPham.setText("Sản phẩm");
        NutSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NutSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NutSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(DanhMucXem, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BieuDoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NutSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DanhMucXem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BieuDoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DanhMucXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DanhMucXemActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DanhSachSanPham danhsachSP = new DanhSachSanPham().getInstance();

        if ("Tất cả".equals(DanhMucXem.getSelectedItem().toString()))
            for (SanPham sp: danhsachSP.DanhSachSP)        
                dataset.addValue(sp.SoLuong, sp.TenSanPham, sp.TenSanPham);           
        else  
            for (int i=0; i< danhsachSP.getDanhSachSP().size(); i++)           
                if (DanhMucXem.getSelectedItem().toString() == danhsachSP.getDanhSachSP().get(i).loaiSanPham.toString())             
                    dataset.addValue(danhsachSP.getDanhSachSP().get(i).SoLuong, danhsachSP.getDanhSachSP().get(i).TenSanPham, danhsachSP.getDanhSachSP().get(i).TenSanPham);                         
        
        JFreeChart bieudo = ChartFactory.createBarChart("Biểu đồ thống kê sản phẩm", "Tên sản phẩm", "Số lượng", dataset, PlotOrientation.HORIZONTAL, true, false , false);
        ChartPanel chartPanel = new ChartPanel(bieudo);
        chartPanel.setPreferredSize(new Dimension(BieuDoJPanel.getWidth(), 321));

        BieuDoJPanel.removeAll();
        BieuDoJPanel.setLayout(new CardLayout());
        BieuDoJPanel.add(chartPanel);
        BieuDoJPanel.validate();
        BieuDoJPanel.repaint();
    }//GEN-LAST:event_DanhMucXemActionPerformed

    private void NutSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NutSanPhamActionPerformed
        // TODO add your handling code here:
        DanhMucXem.setVisible(true);

    }//GEN-LAST:event_NutSanPhamActionPerformed

    void Setup()
    {
        DanhMucXem.addItem("Tất cả");

        for (LoaiSanPham value : LoaiSanPham.values()) 
            DanhMucXem.addItem(value.toString());
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BieuDoJPanel;
    private javax.swing.JComboBox<String> DanhMucXem;
    private javax.swing.JButton NutSanPham;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

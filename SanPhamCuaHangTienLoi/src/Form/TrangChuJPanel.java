/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import FormInput.DoiMatKhau;
import ThongTin.DanhSachNhaCungCap;
import ThongTin.DanhSachNhanVien;
import ThongTin.DanhSachSanPham;
import ThongTin.DanhSachTK;
import ThongTin.Logined;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author ASUS
 */
public class TrangChuJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrangChuJPanel
     */
    Timer timer;
    public TrangChuJPanel() {
        initComponents();
        String Hello = "Xin chào " + new DanhSachTK().getInstance().DanhSachTK.get(new Logined().getInstance().getIdLogin()).getUser();
        HelloText.setText(Hello.toUpperCase());
        
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss" + " dd/MM/yyyy");
                String time = timeFormat.format(date);
                TimeText.setText(time);
                
                if (date.getHours()>=4 && date.getHours()<=10)
                {
                    CauChucLabel.setText("CHÀO BUỔI SÁNG!");
                    CauNhacNhoLabel.setText("CHÚC MỘT NGÀY MỚI TỐT ĐẸP!");
                }
                else if (date.getHours()>10 && date.getHours()<=13)
                {
                    CauChucLabel.setText("CHÀO BUỔI TRƯA!");    
                    CauNhacNhoLabel.setText("ĐỪNG BỎ BỮA TRƯA VÀ NHỚ NGHỈ TRƯA MỘT TÍ!");
                }
                else if (date.getHours()>13 && date.getHours()<=18)
                {
                    CauChucLabel.setText("CHÀO BUỔI CHIỀU!");                
                    CauNhacNhoLabel.setText("CỐ GẮNG LÀM VIỆC HIỆU QUẢ!");
                }
                else if (date.getHours()>18 && date.getHours()<=22)
                {
                    CauChucLabel.setText("CHÀO BUỔI TỐI!");          
                    CauNhacNhoLabel.setText("NHỚ ĐỪNG BỎ BỮA TỐI NHÉ!");
                }
                else if (date.getHours()>22 || date.getHours()<=4)
                {
                    CauChucLabel.setText("CHÚC NGỦ NGON!");  
                    CauNhacNhoLabel.setText("NẾU BẠN CÓ Ý ĐỊNH LÀM VIỆC XUYÊN ĐÊM THÌ BỎ ĐI NHÉ!");
                }
                
            }
        };
        
        timer = new Timer(1000, actionListener);
        timer.setInitialDelay(0);
        timer.start();
        
        String SoLuongSanPham = String.valueOf(new DanhSachSanPham().getInstance().DanhSachSP.size());
        String SoLuongNhanVien = String.valueOf(new DanhSachNhanVien().getInstance().DanhSachNV.size());
        String SoLuongNhaCungCap = String.valueOf(new DanhSachNhaCungCap().getInstance().DanhSachNCC.size());
        
        SLSanPhamText.setText(SoLuongSanPham);
        SLNhanVienText.setText(SoLuongNhanVien);
        SLNCCText.setText(SoLuongNhaCungCap);
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
        RePassButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        HelloText = new javax.swing.JLabel();
        TimeText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NVLabel = new javax.swing.JLabel();
        SLNhanVienText = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SLSanPhamText = new javax.swing.JLabel();
        SPLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        SLNCCText = new javax.swing.JLabel();
        NCCLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        CauChucLabel = new javax.swing.JLabel();
        CauNhacNhoLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 585));

        RePassButton.setBackground(new java.awt.Color(240, 210, 175));
        RePassButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        RePassButton.setText("Đổi mật khẩu");
        RePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RePassButtonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));

        HelloText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        HelloText.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HelloText.setText("Xin chào");

        TimeText.setFont(new java.awt.Font("Trajan Pro", 2, 20)); // NOI18N
        TimeText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        TimeText.setText("0:0:0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HelloText, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TimeText, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(HelloText, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addComponent(TimeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/NhanVien.png"))); // NOI18N

        NVLabel.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        NVLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NVLabel.setText("NHÂN VIÊN");

        SLNhanVienText.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        SLNhanVienText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLNhanVienText.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SLNhanVienText, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(NVLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NVLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(SLNhanVienText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iconfinder_product_4172167.png"))); // NOI18N

        SLSanPhamText.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        SLSanPhamText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLSanPhamText.setText("0");

        SPLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        SPLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SPLabel.setText("SẢN PHẨM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SLSanPhamText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(SLSanPhamText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/NhaCungCap.png"))); // NOI18N

        SLNCCText.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        SLNCCText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SLNCCText.setText("0");

        NCCLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        NCCLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCCLabel.setText("NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SLNCCText, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(NCCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(NCCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(SLNCCText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));

        CauChucLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CauChucLabel.setForeground(new java.awt.Color(255, 102, 102));
        CauChucLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CauChucLabel.setText("CÂU CHÚC");

        CauNhacNhoLabel.setBackground(new java.awt.Color(255, 102, 102));
        CauNhacNhoLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CauNhacNhoLabel.setForeground(new java.awt.Color(255, 102, 102));
        CauNhacNhoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CauNhacNhoLabel.setText("CÂU NHẮC NHỞ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CauChucLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CauNhacNhoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CauChucLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CauNhacNhoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RePassButton))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(RePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RePassButtonActionPerformed
        // TODO add your handling code here:
        new DoiMatKhau().getInstance().show();
    }//GEN-LAST:event_RePassButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CauChucLabel;
    private javax.swing.JLabel CauNhacNhoLabel;
    private javax.swing.JLabel HelloText;
    private javax.swing.JLabel NCCLabel;
    private javax.swing.JLabel NVLabel;
    private javax.swing.JButton RePassButton;
    private javax.swing.JLabel SLNCCText;
    private javax.swing.JLabel SLNhanVienText;
    private javax.swing.JLabel SLSanPhamText;
    private javax.swing.JLabel SPLabel;
    private javax.swing.JLabel TimeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables

    private String String(int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

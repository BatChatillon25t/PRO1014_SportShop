/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package poly.edu.Panels;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.ParseException;
import java.util.ArrayList;
import poly.edu.Model.NhanVien;
import poly.edu.View.Login;
import poly.edu.service.NhanVienService;

/**
 *
 * @author Admin
 */
public class bottom extends javax.swing.JPanel {

    private boolean rootPaneCheckingEnabled;

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        try {
            this.doiten();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private float alpha;

    /**
     * Creates new form Header
     */
    public bottom() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(65, 152, 216));
        loadKH();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        g2.setColor(getBackground());
        g2.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);
        super.paint(g);
    }

    void loadKH() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        NhanVienService nvs = new NhanVienService();
        listNV = nvs.getAllEmTheoMa(Login.tk);
        for (NhanVien nv : listNV) {
            lblMaNV.setText(nv.getMaNV());
            lblChucVu.setText(nv.getVaiTro() == 1 ? "Admin" : "Nhân viên");
            System.out.println(nv.getMaNV());
        }

    }

    private void doiten() throws ParseException {
        Login dangNhap = new Login(null, rootPaneCheckingEnabled);

        // Assuming getMaNV is a method, call it using parentheses
        // Adjust the method name if needed
        lblMaNV.setText(dangNhap.getMaNV());
        lblChucVu.setText(dangNhap.getVaiTro());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new poly.edu.uitility.ImageAvatar();
        lblChucVu = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/1.jpg"))); // NOI18N

        lblChucVu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblChucVu.setForeground(new java.awt.Color(195, 195, 195));
        lblChucVu.setText("Admin");

        lblMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(231, 231, 231));
        lblMaNV.setText("BoySiTinh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChucVu)
                    .addComponent(lblMaNV))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMaNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblChucVu))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private poly.edu.uitility.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblMaNV;
    // End of variables declaration//GEN-END:variables
}

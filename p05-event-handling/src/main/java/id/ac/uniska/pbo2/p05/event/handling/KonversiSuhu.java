package id.ac.uniska.pbo2.p05.event.handling;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ItemEvent;

public class KonversiSuhu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(KonversiSuhu.class.getName());

    public KonversiSuhu() {
        initComponents();
        
        // Kode tambahan: placeholder dan gaya huruf FlatLaf
        celsiusField.putClientProperty("JTextField.placeholderText", "Contoh: 36.5");
        hasilLabel.putClientProperty("FlatLaf.styleClass", "h3");
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isiPanel = new javax.swing.JPanel();
        celciusLabel = new javax.swing.JLabel();
        celsiusField = new javax.swing.JTextField();
        satuanLabel = new javax.swing.JLabel();
        satuanCombo = new javax.swing.JComboBox<>();
        konversiButton = new javax.swing.JButton();
        hasilLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Konversi Suhu\n");

        isiPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        isiPanel.setLayout(new java.awt.GridLayout(0, 1, 0, 6));

        celciusLabel.setText("Suhu Dalam Celsius");
        isiPanel.add(celciusLabel);

        celsiusField.setColumns(12);
        celsiusField.addActionListener(this::celsiusFieldActionPerformed);
        celsiusField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                celsiusFieldKeyReleased(evt);
            }
        });
        isiPanel.add(celsiusField);

        satuanLabel.setText("Konversi Ke");
        isiPanel.add(satuanLabel);

        satuanCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fahrenheit", "Celcius", "Reamur", " " }));
        satuanCombo.addItemListener(this::satuanComboItemStateChanged);
        isiPanel.add(satuanCombo);

        konversiButton.setText("Konversi");
        konversiButton.addActionListener(this::konversiButtonActionPerformed);
        isiPanel.add(konversiButton);
        isiPanel.add(hasilLabel);

        getContentPane().add(isiPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void konversiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konversiButtonActionPerformed
       konversi();
    }//GEN-LAST:event_konversiButtonActionPerformed

    private void celsiusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celsiusFieldActionPerformed

        konversi();
    }//GEN-LAST:event_celsiusFieldActionPerformed

    private void celsiusFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celsiusFieldKeyReleased

        konversi();
    }//GEN-LAST:event_celsiusFieldKeyReleased

    private void satuanComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_satuanComboItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
        konversi();
        }
    }//GEN-LAST:event_satuanComboItemStateChanged
    
    private void konversi() {
        String teks = celsiusField.getText().trim().replace(',', '.');
        if (teks.isEmpty()) {
            hasilLabel.setText("Hasil akan tampil di sini");
        return;
    }
    try {
        double celsius = Double.parseDouble(teks);
        String satuan = (String) satuanCombo.getSelectedItem();
        double hasil = switch (satuan) {
            case "Fahrenheit" -> KonverterSuhu.keFahrenheit(celsius);
            case "Kelvin" -> KonverterSuhu.keKelvin(celsius);
            default -> KonverterSuhu.keReamur(celsius);
        };
        hasilLabel.setText(String.format("%.2f %s", hasil, satuan));
    } catch (NumberFormatException ex) {
        hasilLabel.setText("Masukkan angka yang valid");
    }
}
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new KonversiSuhu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel celciusLabel;
    private javax.swing.JTextField celsiusField;
    private javax.swing.JLabel hasilLabel;
    private javax.swing.JPanel isiPanel;
    private javax.swing.JButton konversiButton;
    private javax.swing.JComboBox<String> satuanCombo;
    private javax.swing.JLabel satuanLabel;
    // End of variables declaration//GEN-END:variables
}

/*
 * Hello Minecraft!.
 * Copyright (C) 2013  huangyuhui <huanghongxun2008@126.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
package org.jackhuang.hellominecraft.util.ui;

import java.io.PrintStream;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.jackhuang.hellominecraft.util.C;
import org.jackhuang.hellominecraft.util.logging.HMCLog;
import org.jackhuang.hellominecraft.util.logging.Level;
import org.jackhuang.hellominecraft.util.func.NonFunction;
import org.jackhuang.hellominecraft.util.DoubleOutputStream;
import org.jackhuang.hellominecraft.util.Utils;

/**
 *
 * @author huangyuhui
 */
public class LogWindow extends javax.swing.JFrame {
    
    boolean movingEnd;
    NonFunction<Boolean> listener;
    Runnable terminateGameListener;

    /**
     * Creates new form LogWindow
     */
    public LogWindow() {
        initComponents();
        
        movingEnd = true;
        
        DoubleOutputStream out = new DoubleOutputStream(new LogWindowOutputStream(this, Level.INFO), System.out);
        System.setOut(new PrintStream(out));
        DoubleOutputStream err = new DoubleOutputStream(new LogWindowOutputStream(this, Level.ERROR), System.err);
        System.setErr(new PrintStream(err));
        
        SwingUtilities.invokeLater(() -> {
            setLocationRelativeTo(null);
            txtLog.setEditable(false);
        });
    }
    
    public static final LogWindow INSTANCE = new LogWindow();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        lblCrash = new javax.swing.JLabel();
        btnMCBBS = new javax.swing.JButton();
        btnTieBa = new javax.swing.JButton();
        btnMCF = new javax.swing.JButton();
        btnTerminateGame = new javax.swing.JButton();
        btnGitHub = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(C.i18n("logwindow.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnClear.setText(C.i18n("ui.button.clear")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnClose.setText(C.i18n("ui.button.close")); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnCopy.setText(C.i18n("ui.button.copy")); // NOI18N
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        lblCrash.setText(C.i18n("ui.label.crashing")); // NOI18N

        btnMCBBS.setText("MCBBS");
        btnMCBBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCBBSActionPerformed(evt);
            }
        });

        btnTieBa.setText(C.i18n("logwindow.tieba")); // NOI18N
        btnTieBa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTieBaActionPerformed(evt);
            }
        });

        btnMCF.setText("Minecraft Forum");
        btnMCF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMCFActionPerformed(evt);
            }
        });

        btnTerminateGame.setText(C.i18n("logwindow.terminate_game")); // NOI18N
        btnTerminateGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminateGameActionPerformed(evt);
            }
        });

        btnGitHub.setText("GitHub");
        btnGitHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGitHubActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTieBa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMCBBS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMCF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGitHub)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTerminateGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose))
                    .addComponent(lblCrash, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCrash)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnClose)
                    .addComponent(btnCopy)
                    .addComponent(btnMCBBS)
                    .addComponent(btnTieBa)
                    .addComponent(btnMCF)
                    .addComponent(btnTerminateGame)
                    .addComponent(btnGitHub))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (listener != null && listener.apply() && terminateGameListener != null)
            terminateGameListener.run();
        SwingUtils.exitIfNoWindow(this, true);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clean();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        Utils.setClipborad(this.txtLog.getText());
    }//GEN-LAST:event_btnCopyActionPerformed

    private void btnMCBBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCBBSActionPerformed
        SwingUtils.openLink(C.URL_PUBLISH);
    }//GEN-LAST:event_btnMCBBSActionPerformed

    private void btnTieBaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTieBaActionPerformed
        SwingUtils.openLink(C.URL_TIEBA);
    }//GEN-LAST:event_btnTieBaActionPerformed

    private void btnMCFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMCFActionPerformed
        SwingUtils.openLink(C.URL_MINECRAFTFORUM);
    }//GEN-LAST:event_btnMCFActionPerformed

    private void btnTerminateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminateGameActionPerformed
        if (terminateGameListener != null)
            terminateGameListener.run();
    }//GEN-LAST:event_btnTerminateGameActionPerformed

    private void btnGitHubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGitHubActionPerformed
        SwingUtils.openLink(C.URL_GITHUB);
    }//GEN-LAST:event_btnGitHubActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (listener != null && listener.apply() && terminateGameListener != null)
            terminateGameListener.run();
        SwingUtils.exitIfNoWindow(this);
    }//GEN-LAST:event_formWindowClosing
    
    public synchronized void log(String status, Level c) {
        status = status.replace("\t", "    ");
        Document d = txtLog.getStyledDocument();
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setForeground(sas, c.COLOR);
        try {
            d.insertString(d.getLength(), status, sas);
        } catch (Exception ex) {
            HMCLog.err("Failed to insert \"" + status + "\" to " + d.getLength(), ex);
        }
        
        if (movingEnd) {
            int position = d.getLength();
            txtLog.setCaretPosition(position);
        }
    }
    
    public void setExit(NonFunction<Boolean> exit) {
        this.listener = exit;
    }
    
    public void setTerminateGame(Runnable l) {
        this.terminateGameListener = l;
    }
    
    public void clean() {
        txtLog.setText("");
    }
    
    public boolean getMovingEnd() {
        return movingEnd;
    }
    
    public void setMovingEnd(boolean b) {
        movingEnd = b;
    }
    
    @Override
    public void setVisible(boolean b) {
        lblCrash.setVisible(false);
        btnMCBBS.setVisible(false);
        btnTieBa.setVisible(false);
        btnMCF.setVisible(false);
        super.setVisible(b);
    }
    
    public void showAsCrashWindow(boolean out_date) {
        if (out_date) {
            lblCrash.setVisible(false);
            btnMCBBS.setVisible(false);
            btnTieBa.setVisible(false);
            btnMCF.setVisible(false);
            lblCrash.setText(C.i18n("ui.label.crashing_out_dated"));
        } else {
            lblCrash.setVisible(true);
            btnMCBBS.setVisible(true);
            btnTieBa.setVisible(true);
            btnMCF.setVisible(true);
            lblCrash.setText(C.i18n("ui.label.crashing"));
        }
        
        super.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnGitHub;
    private javax.swing.JButton btnMCBBS;
    private javax.swing.JButton btnMCF;
    private javax.swing.JButton btnTerminateGame;
    private javax.swing.JButton btnTieBa;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCrash;
    private javax.swing.JTextPane txtLog;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.GridEnergyStorageRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.GridEnergyStorageOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderShipRequest;
import Business.WorkQueue.PowerAdminEnrollmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MALHARocKr
 */
public class ManagePowerAdminRequestJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private GridEnergyStorageOrganization organization;
   
    /**
     * Creates new form ManageManufacturerRequestJPanel
     */
    public ManagePowerAdminRequestJPanel(JPanel userProcessContainer,UserAccount userAccount,Enterprise enterprise) {    //Enterprise enterprise
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        organization = (GridEnergyStorageOrganization)enterprise.getOrganizationDirectory().getOrganization(Organization.Type.GridEnergyStorage);
     
        populateRequestTable();
        
                                                         
    }
    
    
     private void populateRequestTable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel)workRequestJTable.getModel();
        defaultTableModel.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList())
        {
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee();
            row[2] = request.getReceiver() == null?null:request.getReceiver().getEmployee();
            row[3] = request.getStatus();
            defaultTableModel.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        processRequestJButton = new javax.swing.JButton();
        assignToMeJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        processRequestJButton.setText("Process Request");
        processRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processRequestJButtonActionPerformed(evt);
            }
        });

        assignToMeJButton.setText("Assign To Me");
        assignToMeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Power Station Admin Enrollment Request");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(assignToMeJButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(processRequestJButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(refreshJButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 740, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(refreshJButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignToMeJButton)
                    .addComponent(processRequestJButton))
                .addGap(147, 147, 147)
                .addComponent(backJButton)
                .addContainerGap(248, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignToMeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeJButtonActionPerformed
        // TODO add your handling code here:
         int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(this, "No row selected");
            return;
        }
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateRequestTable();
    }//GEN-LAST:event_assignToMeJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void processRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processRequestJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow < 0)
        {
            JOptionPane.showMessageDialog(this, "No row selected");
            return;
        }
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getStatus().equalsIgnoreCase("Completed"))
        {
            JOptionPane.showMessageDialog(this, "request is already completed");
            return;
        }
        if(request.getReceiver()  == null || request.getReceiver() != userAccount)
        {
            JOptionPane.showMessageDialog(this, "Request not assigned to me");
            return;
        }
        request.setStatus("Processing");
        if(request instanceof PowerAdminEnrollmentWorkRequest)
        {
        ProcessEnrollmentRequestJPanel processEnrolmentRequestJPanel = new ProcessEnrollmentRequestJPanel(userProcessContainer,(PowerAdminEnrollmentWorkRequest)request);
        userProcessContainer.add("processEnrolmentRequestJPanel",processEnrolmentRequestJPanel);
        ((CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
        }
        else
        {
        ProcessOrderRequestJPanel processOrderRequestJPanel = new ProcessOrderRequestJPanel(userProcessContainer,(OrderShipRequest)request,enterprise);
        userProcessContainer.add("processOrderRequestJPanel",processOrderRequestJPanel);
        ((CardLayout)userProcessContainer.getLayout()).next(userProcessContainer);
        }
    }//GEN-LAST:event_processRequestJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToMeJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processRequestJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}

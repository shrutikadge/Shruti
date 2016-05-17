/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ProviderRole;


import Business.Electricity.Electricity;
import Business.Enterprise.EnergyEnterprise;
import Business.Enterprise.Enterprise;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.ProviderOrganization;

import Business.Organization.Organization;
import Business.Organization.PowerStationOrganization;
import Business.Organization.GridEnergyStorageOrganization;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderShipRequest;

import java.awt.CardLayout;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
//import javafx.scene.shape.Path;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class BrowseElectricityForAppliancesJPanel extends javax.swing.JPanel {
   private JPanel userProcessContainer;
 
   private ProviderOrganization organization;
   Boolean isCheckOut = false;
   private EnergyEnterprise enterprise;
   private UserAccount userAccount;
     Order order=null;

    
    

    
    public BrowseElectricityForAppliancesJPanel(JPanel userProcessContainer,UserAccount userAccount,ProviderOrganization organization,Enterprise enterprise){  //Enterprise enterprise
        initComponents();
        this.userProcessContainer = userProcessContainer;          
        this.userAccount = userAccount;
        this.enterprise = (EnergyEnterprise)enterprise;
        organization = (ProviderOrganization)organization;  
        order = new Order();
        
      
        if(isCheckOut == true)
        {
            order = new Order();
        }
    
    
        populateProductTable();
    

    }
    
    

    
    private void populateProductTable(){         
        DefaultTableModel tableModel = (DefaultTableModel)powerStationElectricityJTable.getModel();
        tableModel.setRowCount(0);
        for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            System.out.println(o.getName());
           if(o instanceof PowerStationOrganization)  {
        
        for(Electricity e : o.getElectricityDirectory().getElecCatalog()){ 
           
           
            Object[] row = new Object[4];
            row[0] = e;
            row[1] = e.getCurrentNumber();
            row[2] = e.getAvailability();
            row[3] = e.getNonPeakHourPrice();
            
            tableModel.addRow(row);
        }
    }
        }
    }
    
    private void populateTable(String keyWord){
        DefaultTableModel tableModel = (DefaultTableModel)powerStationElectricityJTable.getModel();
        tableModel.setRowCount(0);
        for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            System.out.println(o.getName());
            if(o instanceof PowerStationOrganization) {
        
        for(Electricity v : o.getElectricityDirectory().getElecCatalog()){ 
            System.out.println(o.getName());
            if(v.getElectricitySource().equals(keyWord)){
                 Object[] row = new Object[4];
                    row[0] = v;
                    row[1] = v.getCurrentNumber();
                    row[2] = v.getAvailability();
                    row[3] = v.getNonPeakHourPrice();
            
                    tableModel.addRow(row);
            }
        }
    }
    }
    }
    
    private void populateOrderTable(){
        DefaultTableModel tableModel = (DefaultTableModel)itemsToCartJTable.getModel();
        tableModel.setRowCount(0);
        for(OrderItem orderItem: order.getOrderItemList())
            
            
        {
            Object[] row = new Object[4];
            row[0] = orderItem;
            row[1] = orderItem.getElectricity().getNonPeakHourPrice();
            row[2] = orderItem.getQuantity();
            row[3] = orderItem.getSalesPrice();
            tableModel.addRow(row);
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
        powerStationElectricityJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemsToCartJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        quantityJSpinner = new javax.swing.JSpinner();
        AddElectricityJButton = new javax.swing.JButton();
        quantityJTextField = new javax.swing.JTextField();
        removeJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        checkOutJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        modifyJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        path_attach = new javax.swing.JTextField();
        attachJButton = new javax.swing.JButton();
        emailJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        powerStationElectricityJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "CurrentFlowNumber", "Availability", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(powerStationElectricityJTable);

        itemsToCartJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Price", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(itemsToCartJTable);

        jLabel2.setText("Quantity");

        AddElectricityJButton.setText("Add Electricity");
        AddElectricityJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddElectricityJButtonActionPerformed(evt);
            }
        });

        quantityJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityJTextFieldActionPerformed(evt);
            }
        });

        removeJButton.setText("Remove ");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        checkOutJButton.setText("Check Out");
        checkOutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        modifyJButton.setText("Modify Quantity");
        modifyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyJButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("POWER ADMIN ELECTRICITY CATALOG");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("BROWSE ELECTRICITY TO ORDER");

        path_attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                path_attachActionPerformed(evt);
            }
        });

        attachJButton.setText("ATTACH");
        attachJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachJButtonActionPerformed(evt);
            }
        });

        emailJButton.setText("E-mail Bill");
        emailJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(path_attach)
                                    .addGap(27, 27, 27)
                                    .addComponent(attachJButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(quantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(modifyJButton)
                                    .addGap(169, 169, 169)
                                    .addComponent(checkOutJButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(backJButton)
                                    .addGap(98, 98, 98)
                                    .addComponent(removeJButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(refreshJButton))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 797, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(AddElectricityJButton)))
                .addContainerGap(659, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(AddElectricityJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyJButton)
                    .addComponent(checkOutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(path_attach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attachJButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(emailJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(removeJButton)
                    .addComponent(refreshJButton))
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void AddElectricityJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddElectricityJButtonActionPerformed
        // TODO add your handling code here:
         
     isCheckOut = false;
        int selectedItem = powerStationElectricityJTable.getSelectedRow();
        int quantity = (Integer)quantityJSpinner.getValue();
        if(selectedItem < 0)
        {
            JOptionPane.showMessageDialog(this, "No Product selected");
            return;
        }
        Electricity electricity = (Electricity)powerStationElectricityJTable.getValueAt(selectedItem, 0);
        
        if(quantity <= 0 || quantity > electricity.getAvailability())
        {
         JOptionPane.showMessageDialog(this, "Quantity is incorrect");
         return;
        }
        boolean isNewProduct = true;
        ArrayList<OrderItem> orderList = order.getOrderItemList();
        for(OrderItem orderItem:orderList)
        {
            if(orderItem.getElectricity().equals(electricity))
            {
                int oldQuantity = orderItem.getQuantity();
                int newQuantity = quantity;
                orderItem.setQuantity(newQuantity);
                
                isNewProduct = false;
            }
        }
        if(isNewProduct)
        {  
            OrderItem orderItem = order.addOrderItem(electricity, quantity);
        }
        electricity.setAvailability(electricity.getAvailability() - quantity);
        String caption = "You have added the product: "+electricity+" with quantity "+quantity;
        JOptionPane.showMessageDialog(this, caption);
        
        populateOrderTable();
        
    }//GEN-LAST:event_AddElectricityJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
         int selectedItem = itemsToCartJTable.getSelectedRow();
            if(selectedItem < 0)
            {
                JOptionPane.showMessageDialog(this, "No Order selected");
                return;
            }
            OrderItem orderItem = (OrderItem)itemsToCartJTable.getValueAt(selectedItem, 0);
            order.removeOrderItem(orderItem);
            populateOrderTable();
       
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateOrderTable();
       
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void checkOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutJButtonActionPerformed
        // TODO add your handling code here:
        // enterprise.getMasterOrderCatalog().getOrderCatalog().add(order);
       // masterOrderCatalog.addOrder(order);
      
        for(OrderItem oi:order.getOrderItemList())
        {
            Electricity p=oi.getElectricity();
            p.setSoldQuantity(p.getSoldQuantity()+oi.getQuantity());
            
            
        
        
        
    }
        for(OrderItem oi:order.getOrderItemList())
        {
            try{
        List<String> lines = Arrays.asList("Your bill for the transaction","Name: "+userAccount.getUsername(),"Product: "+oi.getElectricity().getElectricitySource(), "Total Amount: "+oi.getSalesPrice(),"Total Quantity: "+oi.getQuantity());
        Path file = Paths.get(userAccount.getUsername()+"'s bill.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }
        OrderShipRequest orderShipRequest = new OrderShipRequest();
        orderShipRequest.setMessage("Order Submitted");
        orderShipRequest.setOrder(order);
        orderShipRequest.setSender(userAccount);
        orderShipRequest.setStatus("Pending");
        userAccount.getWorkQueue().getWorkRequestList().add(orderShipRequest);
 //enterprise      
        GridEnergyStorageOrganization wo = (GridEnergyStorageOrganization)enterprise.getOrganizationDirectory().getOrganization(Organization.Type.GridEnergyStorage);
        wo.getWorkQueue().getWorkRequestList().add(orderShipRequest);
        order = new Order();
        populateOrderTable();
       
    
        isCheckOut = true;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_checkOutJButtonActionPerformed

    private void modifyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyJButtonActionPerformed
        // TODO add your handling code here:
        String quantityText = quantityJTextField.getText();
        try
        {
            int modifyQuantity = Integer.parseInt(quantityText);
            if(modifyQuantity < 1)
            {
                JOptionPane.showMessageDialog(this, "invalid entry");
                return;
            }
            int selectedItem = itemsToCartJTable.getSelectedRow();
            if(selectedItem < 0)
            {
                JOptionPane.showMessageDialog(this, "No Order selected");
                return;
            }
            OrderItem orderItem = (OrderItem)itemsToCartJTable.getValueAt(selectedItem, 0);
            if(modifyQuantity > orderItem.getQuantity())
            {
                int modifiedValue = modifyQuantity - orderItem.getQuantity();
                if(orderItem.getElectricity().getAvailability()<modifiedValue)
                {
                    JOptionPane.showMessageDialog(this, "requested quntity is not available;");
                    return;
                }

                orderItem.setQuantity(modifyQuantity);
                orderItem.getElectricity().setAvailability(orderItem.getElectricity().getAvailability() - modifiedValue);
            }
            else
            {
                int modifiedValue =  orderItem.getQuantity() - modifyQuantity;

                orderItem.setQuantity(modifyQuantity);
                orderItem.getElectricity().setAvailability(orderItem.getElectricity().getAvailability() + modifiedValue);
            }
            populateOrderTable();

        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "invalid entry");
            return;
        }

    }//GEN-LAST:event_modifyJButtonActionPerformed

    private void quantityJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityJTextFieldActionPerformed

    private void path_attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_path_attachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_path_attachActionPerformed

    private void attachJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachJButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        path_attach.setText(filename);
    }//GEN-LAST:event_attachJButtonActionPerformed

    private void emailJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailJButtonActionPerformed
        // TODO add your handling code here:
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.auth","true");

        props.put("mail.smtp.socketFactory.fallback","true");

        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new javax.mail.PasswordAuthentication("shrutiik33@gmail.com", "AEDFinalProject");
            }
        }

        );

        try{
            Multipart multipart=new MimeMultipart();
          //  BodyPart body = new MimeBodyPart();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shrutikadge@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("kadge.s@husky.neu.edu"));
            message.setSubject("Status check for supply chain");
            message.setText("Give the current status");
          // body.setText("Dear Customer,"+"\n"+"Please find your generated bill");
           JFileChooser chooser = new JFileChooser();
           chooser.showOpenDialog(null);
           File f = chooser.getSelectedFile();
           String fileName=f.getAbsolutePath();
        //   multipart.addBodyPart(body);
          // String s1="";
           BodyPart body=new MimeBodyPart();
        
           DataSource source=new FileDataSource(fileName);
           body.setDataHandler(new DataHandler(source));
           body.setFileName("bill");
           multipart.addBodyPart(body);
           message.setContent(multipart);
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "message sent");
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);

        }
    }//GEN-LAST:event_emailJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddElectricityJButton;
    private javax.swing.JButton attachJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton checkOutJButton;
    private javax.swing.JButton emailJButton;
    private javax.swing.JTable itemsToCartJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modifyJButton;
    private javax.swing.JTextField path_attach;
    private javax.swing.JTable powerStationElectricityJTable;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JTextField quantityJTextField;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton removeJButton;
    // End of variables declaration//GEN-END:variables

}
/*
 * Copyright (C) 2022 marin
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cooperativa.vistas;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import cooperativa.objetos.Crédito;
import cooperativa.objetos.Débito;
import cooperativa.objetos.Movimiento;
import static cooperativa.principal.Base.refrescaVista;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class CrearDébito extends javax.swing.JPanel {
    
    private int lastId = -1;
    private ArrayList<Débito> Débitos = new ArrayList();
    private ArrayList<Movimiento> Movimientos = new ArrayList();
    
    /**
     * Creates new form Inicio
     */
    public CrearDébito() {
        
        initComponents();
        
        fechaVal.setText(java.time.LocalDate.now().toString());
        
        CSVReader origen, origenMovimiento;
        
        try {
            origen = new CSVReader(new FileReader("debitos.csv"));
            String[] linea = null;
            try {
                while ((linea = origen.readNext()) != null) {
                    Débitos.add(new Débito(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), linea[3]));
                }
            } catch (IOException | CsvValidationException ex) {
                Logger.getLogger(CrearDébito.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearDébito.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            origenMovimiento = new CSVReader(new FileReader("movimientos.csv"));
            String[] linea = null;
            try {
                while ((linea = origenMovimiento.readNext()) != null) {
                    comboIdMovimiento.addItem(linea[0]);
                }
            } catch (IOException | CsvValidationException ex) {
                Logger.getLogger(CrearMovimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CrearMovimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Débito tipo : Débitos) {
            if(lastId < tipo.getIdDebito()) {
                lastId = tipo.getIdDebito();
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

        grupoRadio = new javax.swing.ButtonGroup();
        Panel = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        fechaVal = new javax.swing.JTextField();
        status = new javax.swing.JLabel();
        statusVal = new javax.swing.JRadioButton();
        statusVal1 = new javax.swing.JRadioButton();
        statusVal2 = new javax.swing.JRadioButton();
        statusVal3 = new javax.swing.JRadioButton();
        comboIdMovimiento = new javax.swing.JComboBox<>();
        IdMovimiento = new javax.swing.JLabel();
        Título = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(710, 580));
        setMinimumSize(new java.awt.Dimension(710, 580));
        setPreferredSize(new java.awt.Dimension(710, 580));

        fecha.setText("Fecha");

        status.setText("Estado");

        grupoRadio.add(statusVal);
        statusVal.setSelected(true);
        statusVal.setText("Inactivo");
        statusVal.setActionCommand("0");
        statusVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusValActionPerformed(evt);
            }
        });

        grupoRadio.add(statusVal1);
        statusVal1.setText("Revisión");
        statusVal1.setActionCommand("1");

        grupoRadio.add(statusVal2);
        statusVal2.setText("Activo");
        statusVal2.setActionCommand("2");
        statusVal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusVal2ActionPerformed(evt);
            }
        });

        grupoRadio.add(statusVal3);
        statusVal3.setText("Bloqueado");
        statusVal3.setActionCommand("3");

        comboIdMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIdMovimientoActionPerformed(evt);
            }
        });

        IdMovimiento.setText("Movimiento");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaVal)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha)
                            .addComponent(status)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(statusVal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusVal1)
                                .addGap(12, 12, 12)
                                .addComponent(statusVal2)
                                .addGap(12, 12, 12)
                                .addComponent(statusVal3)))
                        .addGap(0, 325, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(IdMovimiento)
                        .addGap(325, 325, 325))
                    .addComponent(comboIdMovimiento, 0, 630, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(fecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdMovimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboIdMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusVal)
                    .addComponent(statusVal1)
                    .addComponent(statusVal2)
                    .addComponent(statusVal3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Título.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Título.setText("Crear débito");

        btnCrear.setText("Crear débito");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar y volver");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(Título, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                                .addComponent(btnCancelar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrear)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelar)
                    .addComponent(Título))
                .addGap(11, 11, 11)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(btnCrear)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statusValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusValActionPerformed
    }//GEN-LAST:event_statusValActionPerformed

    private void statusVal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusVal2ActionPerformed
    }//GEN-LAST:event_statusVal2ActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        if(fechaVal.getText().equals("") || comboIdMovimiento.getModel().getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Uno de los campos se encuentra vacío, verifica de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String statusId = "";
            String idMovimiento = (String)comboIdMovimiento.getSelectedItem();
            
            for (Enumeration<AbstractButton> buttons = grupoRadio.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    statusId = button.getActionCommand();
                }
            }
            
            Débitos.add(new Débito(lastId + 1, fechaVal.getText(), Integer.parseInt(idMovimiento), statusId));
            
            try {
                CSVWriter destino = new CSVWriter(new FileWriter("debitos.csv", false));
                
                for (Débito tipo : Débitos) {
                    String [] datos = tipo.getArray();
                    destino.writeNext(datos);
                }
                
                destino.close();
                
                JOptionPane.showMessageDialog(null, "El débito se ha guardado exitosamente");
                
                refrescaVista(new VerDébitos(), "", "");
                
            } catch (IOException ex) {
                Logger.getLogger(CrearDébito.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        refrescaVista(new VerDébitos(), "", "");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void comboIdMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIdMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboIdMovimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdMovimiento;
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel Título;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> comboIdMovimiento;
    private javax.swing.JLabel fecha;
    private javax.swing.JTextField fechaVal;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JLabel status;
    private javax.swing.JRadioButton statusVal;
    private javax.swing.JRadioButton statusVal1;
    private javax.swing.JRadioButton statusVal2;
    private javax.swing.JRadioButton statusVal3;
    // End of variables declaration//GEN-END:variables
}

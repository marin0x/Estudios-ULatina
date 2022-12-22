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
import cooperativa.objetos.Concepto;
import cooperativa.objetos.TipoPersona;
import static cooperativa.principal.Base.cuerpoContenedor;
import static cooperativa.principal.Base.refrescaVista;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marin
 */
public class VerConceptos extends javax.swing.JPanel {
    
    private int idColumna = -1;
    private ArrayList<Concepto> Conceptos = new ArrayList();
    private int lineas = 0;
    
    /**
     * Creates new form Inicio
     */
    public VerConceptos() {
        
        try {
            initComponents();
            
            CSVReader origen = new CSVReader(new FileReader("conceptos.csv"));
            String[] linea = null;
            
            while((linea = origen.readNext()) != null) {
                lineas++;
                Conceptos.add(new Concepto(Integer.parseInt(linea[0]), linea[1], linea[2]));
            }
            
            origen.close();
            TxtResultados.setText(String.valueOf(lineas));
            
            String list[][] = new String[lineas][3];
            
            for (int i = 0; i < Conceptos.size(); i++){
                
                list[i][0] = String.valueOf(Conceptos.get(i).getIdConcepto());
                list[i][1] = Conceptos.get(i).getNombreConcepto();
                switch(Conceptos.get(i).getStatus()) {
                    case "0":
                        list[i][2] = "Inactivo";
                        break;
                    case "1":
                        list[i][2] = "Revisión";
                        break;
                    case "2":
                        list[i][2] = "Activo";
                        break;
                    case "3":
                        list[i][2] = "Bloqueado";
                        break;
                }
            }
            
            Tabla.setModel(new javax.swing.table.DefaultTableModel(list, new String [] {
                "idConcepto", "NombreConcepto", "status"})
            );
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VerConceptos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(VerConceptos.class.getName()).log(Level.SEVERE, null, ex);
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

        Título = new javax.swing.JLabel();
        TablaContenedor = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnCrear = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        Título1 = new javax.swing.JLabel();
        TxtResultados = new javax.swing.JLabel();
        BtnVolver = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(710, 580));
        setMinimumSize(new java.awt.Dimension(710, 580));
        setPreferredSize(new java.awt.Dimension(710, 580));

        Título.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Título.setText("Conceptos");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idConcepto", "NombreConcepto", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.setColumnSelectionAllowed(true);
        Tabla.getTableHeader().setReorderingAllowed(false);
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        Tabla.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TablaPropertyChange(evt);
            }
        });
        TablaContenedor.setViewportView(Tabla);
        Tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        BtnCrear.setText("Crear nuevo concepto");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar concepto");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        Título1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Título1.setText("Resultados");

        TxtResultados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TxtResultados.setText("0");

        BtnVolver.setText("Volver a movimientos");
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCrear))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TablaContenedor)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Título, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Título1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Título)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(Título1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addComponent(TablaContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCrear)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnVolver))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if(this.idColumna == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una línea, verifica de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel)Tabla.getModel();
            Conceptos.remove(idColumna);
            try {
                CSVWriter destino = new CSVWriter(new FileWriter("conceptos.csv", false));
                for (Concepto tipo : Conceptos) {
                    String[] datos = tipo.getArray();
                    destino.writeNext(datos);
                }
                
                destino.close();
                
                JOptionPane.showMessageDialog(null, "El concepto se ha eliminado exitosamente");

                refrescaVista(new VerConceptos(), "", "");
            } catch (IOException ex) {
                Logger.getLogger(VerConceptos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        refrescaVista(new CrearConcepto(), "", "");
    }//GEN-LAST:event_BtnCrearActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        refrescaVista(new VerMovimientos(), "", "");
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void TablaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TablaPropertyChange
    }//GEN-LAST:event_TablaPropertyChange

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        this.idColumna = Tabla.getSelectedRow();
    }//GEN-LAST:event_TablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrear;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTable Tabla;
    private javax.swing.JScrollPane TablaContenedor;
    private javax.swing.JLabel TxtResultados;
    private javax.swing.JLabel Título;
    private javax.swing.JLabel Título1;
    // End of variables declaration//GEN-END:variables
}

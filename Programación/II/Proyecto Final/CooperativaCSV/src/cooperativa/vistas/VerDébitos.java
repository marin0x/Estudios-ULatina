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
public class VerDébitos extends javax.swing.JPanel {
    
    private int idColumna = -1;
    private ArrayList<Débito> Débitos = new ArrayList();
    private int lineas = 0;

    /**
     * Creates new form Inicio
     */
    public VerDébitos() {
        try {
            initComponents();
            
            CSVReader origen = new CSVReader(new FileReader("debitos.csv"));
            String[] linea = null;
            
            while((linea = origen.readNext()) != null) {
                lineas++;
                Débitos.add(new Débito(Integer.parseInt(linea[0]), linea[1], Integer.parseInt(linea[2]), linea[3]));
            }
            
            origen.close();
            TxtResultados.setText(String.valueOf(lineas));
            
            String list[][] = new String[lineas][8];
            
            for (int i = 0; i < Débitos.size(); i++){
                
                list[i][0] = String.valueOf(Débitos.get(i).getIdDebito());
                list[i][2] = Débitos.get(i).getFecha();
                list[i][1] = String.valueOf(Débitos.get(i).getIdMovimiento());
                switch(Débitos.get(i).getStatus()) {
                    case "0":
                        list[i][3] = "Inactivo (0)";
                        break;
                    case "1":
                        list[i][3] = "Revisión (1)";
                        break;
                    case "2":
                        list[i][3] = "Activo (2)";
                        break;
                    case "3":
                        list[i][3] = "Bloqueado (3)";
                        break;
                }
            }
            
            Tabla.setModel(new javax.swing.table.DefaultTableModel(list, new String [] {
                "idDebito", "Fecha", "idMovimiento", "status"})
            );
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VerDébitos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | CsvValidationException ex) {
            Logger.getLogger(VerDébitos.class.getName()).log(Level.SEVERE, null, ex);
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
        Título1 = new javax.swing.JLabel();
        TxtResultados = new javax.swing.JLabel();
        TablaContenedor = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        BtnCrear = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnVerTiposPersonas = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(710, 580));
        setMinimumSize(new java.awt.Dimension(710, 580));
        setPreferredSize(new java.awt.Dimension(710, 580));

        Título.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Título.setText("Débitos");

        Título1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Título1.setText("Resultados");

        TxtResultados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TxtResultados.setText("0");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDebito", "Fecha", "idMovimiento", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.getTableHeader().setReorderingAllowed(false);
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        TablaContenedor.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        BtnCrear.setText("Crear débito");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar débito");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnVerTiposPersonas.setText("Ver movimientos de débitos");
        BtnVerTiposPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerTiposPersonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnVerTiposPersonas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnCrear))
                    .addComponent(TablaContenedor)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Título, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Título1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE)))
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
                    .addComponent(BtnVerTiposPersonas))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if(this.idColumna == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una línea, verifica de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel model = (DefaultTableModel)Tabla.getModel();
            Débitos.remove(idColumna);
            try {
                CSVWriter destino = new CSVWriter(new FileWriter("debitos.csv", false));
                for (Débito tipo : Débitos) {
                    String[] datos = tipo.getArray();
                    destino.writeNext(datos);
                }
                
                destino.close();
                
                JOptionPane.showMessageDialog(null, "El débito se ha eliminado exitosamente");

                refrescaVista(new VerDébitos(), "", "");
                
            } catch (IOException ex) {
                Logger.getLogger(VerDébitos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed
        refrescaVista(new CrearDébito(), "", "");
    }//GEN-LAST:event_BtnCrearActionPerformed

    private void BtnVerTiposPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerTiposPersonasActionPerformed
        refrescaVista(new VerMovimientosDébito(), "", "");
    }//GEN-LAST:event_BtnVerTiposPersonasActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        this.idColumna = Tabla.getSelectedRow();
    }//GEN-LAST:event_TablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrear;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnVerTiposPersonas;
    private javax.swing.JTable Tabla;
    private javax.swing.JScrollPane TablaContenedor;
    private javax.swing.JLabel TxtResultados;
    private javax.swing.JLabel Título;
    private javax.swing.JLabel Título1;
    // End of variables declaration//GEN-END:variables
}

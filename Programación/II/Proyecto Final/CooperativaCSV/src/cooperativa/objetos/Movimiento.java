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
package cooperativa.objetos;

/**
 *
 * @author marin
 */
public class Movimiento {
    
    private int idMovimiento, idPersona, idConcepto;
    private String Fecha, Detalle, status;
    private double Importe;

    public Movimiento(int idMovimiento, String Fecha, int idPersona, int idConcepto, String Detalle, double Importe, String status) {
        this.idMovimiento = idMovimiento;
        this.Fecha = Fecha;
        this.idPersona = idPersona;
        this.idConcepto = idConcepto;
        this.Detalle = Detalle;
        this.Importe = Importe;
        this.status = status;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double Importe) {
        this.Importe = Importe;
    }
    
    public String[] getArray() {
        String[] datos = {String.valueOf(idMovimiento), Fecha, String.valueOf(idPersona), String.valueOf(idConcepto), Detalle, String.valueOf(Importe), status};
        return datos;
    }
    
}

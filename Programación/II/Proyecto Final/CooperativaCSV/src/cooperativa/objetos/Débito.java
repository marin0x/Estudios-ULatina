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
public class Débito {
    
    private int idDebito, idMovimiento;
    private String Fecha, status;

    public Débito(int idDebito, String Fecha, int idMovimiento, String status) {
        this.idDebito = idDebito;
        this.Fecha = Fecha;
        this.idMovimiento = idMovimiento;
        this.status = status;
    }

    public int getIdDebito() {
        return idDebito;
    }

    public void setIdDebito(int idCredito) {
        this.idDebito = idCredito;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String[] getArray() {
        String[] datos = {String.valueOf(idDebito), Fecha, String.valueOf(idMovimiento), status};
        return datos;
    }
    
}

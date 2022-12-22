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
public class MovimientoDébito {
    
    private int idMovxDébito, idMovimiento, idDebito;
    private String status;

    public MovimientoDébito(int idMovxDébito, int idMovimiento, int idDebito, String status) {
        this.idMovxDébito = idMovxDébito;
        this.idMovimiento = idMovimiento;
        this.idDebito = idDebito;
        this.status = status;
    }

    public int getIdMovxDebito() {
        return idMovxDébito;
    }

    public void setIdMovxDebito(int idMovxDébito) {
        this.idMovxDébito = idMovxDébito;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdDebito() {
        return idDebito;
    }

    public void setIdDebito(int idDebito) {
        this.idDebito = idDebito;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String[] getArray() {
        String[] datos = {String.valueOf(idMovxDébito), String.valueOf(idMovimiento), String.valueOf(idDebito), status};
        return datos;
    }
    
}

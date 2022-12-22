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
public class MovimientoCrédito {
    
    private int idMovxCredito, idMovimiento, idCredito;
    private String status;

    public MovimientoCrédito(int idMovxCredito, int idMovimiento, int idCredito, String status) {
        this.idMovxCredito = idMovxCredito;
        this.idMovimiento = idMovimiento;
        this.idCredito = idCredito;
        this.status = status;
    }

    public int getIdMovxCredito() {
        return idMovxCredito;
    }

    public void setIdMovxCredito(int idMovxCredito) {
        this.idMovxCredito = idMovxCredito;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdCredito() {
        return idCredito;
    }

    public void setIdCredito(int idCredito) {
        this.idCredito = idCredito;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String[] getArray() {
        String[] datos = {String.valueOf(idMovxCredito), String.valueOf(idMovimiento), String.valueOf(idCredito), status};
        return datos;
    }
    
}

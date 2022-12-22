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
public class Concepto {
    private int idConcepto;
    private String NombreConcepto, status;

    public Concepto(int idConcepto, String NombreConcepto, String status) {
        this.idConcepto = idConcepto;
        this.NombreConcepto = NombreConcepto;
        this.status = status;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombreConcepto() {
        return NombreConcepto;
    }

    public void setNombreConcepto(String NombreConcepto) {
        this.NombreConcepto = NombreConcepto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String[] getArray() {
        String[] datos = {String.valueOf(idConcepto), NombreConcepto, status};
        return datos;
    }
}

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
public class TipoPersona {
    private int idTipoPersona;
    private String NombreTipoPersona, status;

    public TipoPersona(int idTipoPersona, String NombreTipoPersona, String status) {
        this.idTipoPersona = idTipoPersona;
        this.NombreTipoPersona = NombreTipoPersona;
        this.status = status;
    }

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return NombreTipoPersona;
    }

    public void setNombreTipoPersona(String NombreTipoPersona) {
        this.NombreTipoPersona = NombreTipoPersona;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String[] getArray() {
        String[] datos = {String.valueOf(idTipoPersona), NombreTipoPersona, status};
        return datos;
    }
}
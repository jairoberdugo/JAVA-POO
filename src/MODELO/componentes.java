/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


public class componentes {
    private String idpf, nombrefabripf, modelopf, tipopf, tipoconpf, nompf;
    private int preciopf;

    public componentes(String idpf, String nompf, String nombrefabripf, String modelopf, String tipopf, String tipoconpf, int preciopf) {
        this.idpf = idpf;
        this.nombrefabripf = nombrefabripf;
        this.modelopf = modelopf;
        this.tipopf = tipopf;
        this.tipoconpf = tipoconpf;
        this.preciopf = preciopf;
        this.nompf=nompf;
    }
    public componentes(){
        
    }

    @Override
    public String toString() {
        return "componentes{" + "idpf=" + idpf + ", nombrefabripf=" + nombrefabripf + ", modelopf=" + modelopf + ", tipopf=" + tipopf + ", tipoconpf=" + tipoconpf + ", preciopf=" + preciopf + '}';
    }

    public void setNompf(String nompf) {
        this.nompf = nompf;
    }

    public String getNompf() {
        return nompf;
    }
    

    public void setIdpf(String idpf) {
        this.idpf = idpf;
    }

    public void setNombrefabripf(String nombrefabripf) {
        this.nombrefabripf = nombrefabripf;
    }

    public void setModelopf(String modelopf) {
        this.modelopf = modelopf;
    }

    public void setTipopf(String tipopf) {
        this.tipopf = tipopf;
    }

    public void setTipoconpf(String tipoconpf) {
        this.tipoconpf = tipoconpf;
    }

    public void setPreciopf(int preciopf) {
        this.preciopf = preciopf;
    }
    

    public String getIdpf() {
        return idpf;
    }

    public String getNombrefabripf() {
        return nombrefabripf;
    }

    public String getModelopf() {
        return modelopf;
    }

    public String getTipopf() {
        return tipopf;
    }

    public String getTipoconpf() {
        return tipoconpf;
    }

    public int getPreciopf() {
        return preciopf;
    }
    
}

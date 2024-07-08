/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;


public class cpu {
     private String idcpu, nombref_cpu, modelocpu, tipocpu,procesador_cpu, disco_cpu;
     private int precio_cpu;

    public cpu(String idcpu, String nombref_cpu, String modelocpu, String procesador_cpu, String disco_cpu, int precio_cpu) {
        this.idcpu = idcpu;
        this.nombref_cpu = nombref_cpu;
        this.modelocpu = modelocpu;
        //this.tipocpu = tipocpu;
        this.procesador_cpu = procesador_cpu;
        this.disco_cpu = disco_cpu;
        this.precio_cpu = precio_cpu;
    }
    
    public cpu(){
        
    }

    @Override
    public String toString() {
        return "cpu{" + "idcpu=" + idcpu + ", nombref_cpu=" + nombref_cpu + ", modelocpu=" + modelocpu + ", tipocpu=" + tipocpu + ", procesador_cpu=" + procesador_cpu + ", disco_cpu=" + disco_cpu + ", precio_cpu=" + precio_cpu + '}';
    }
    

    public void setIdcpu(String idcpu) {
        this.idcpu = idcpu;
    }

    public void setNombref_cpu(String nombref_cpu) {
        this.nombref_cpu = nombref_cpu;
    }

    public void setModelocpu(String modelocpu) {
        this.modelocpu = modelocpu;
    }

    public void setTipocpu(String tipocpu) {
        this.tipocpu = tipocpu;
    }

    public void setProcesador_cpu(String procesador_cpu) {
        this.procesador_cpu = procesador_cpu;
    }

    public void setDisco_cpu(String disco_cpu) {
        this.disco_cpu = disco_cpu;
    }

    public void setPrecio_cpu(int precio_cpu) {
        this.precio_cpu = precio_cpu;
    }
    
    public String getIdcpu() {
        return idcpu;
    }

    public String getNombref_cpu() {
        return nombref_cpu;
    }

    public String getModelocpu() {
        return modelocpu;
    }

    public String getTipocpu() {
        return tipocpu;
    }

    public String getProcesador_cpu() {
        return procesador_cpu;
    }

    public String getDisco_cpu() {
        return disco_cpu;
    }

    public int getPrecio_cpu() {
        return precio_cpu;
    }
     
}

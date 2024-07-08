
package RUN;

import VISTA.vista;
import MODELO.*;
import CONTROLADOR.control;

public class main {
    public static void main(String[] args){
        
        
        vista vis =  new vista();
        
        
        componentes com = new componentes();
        componentes_dentrada comp_d = new componentes_dentrada();
        componentes_dsalida comp_dss = new componentes_dsalida();
        componentes_dimpresora comp_dii = new componentes_dimpresora();
        componente_mixto comp_mi = new componente_mixto();
        cpu c = new cpu();
        
        
        
        control con = new control(vis,com,comp_d,comp_dss,comp_dii,comp_mi,c);
        con.iniciar();
       
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import MODELO.*;
import VISTA.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class control implements ActionListener {

    private vista vist;
    private componentes comp;
    private componentes_dentrada comp_de;
    private componentes_dsalida comp_ds;
    private componentes_dimpresora comp_di;
    private componente_mixto comp_mix;
    private cpu cp_u;
    public static String texto = "";
    public static int totalcomp = 0;
    public static int cont_componentes = 0;
    public static int cont_cpu = 0;

    public static boolean sw = false;
    public static String text0 = "";
    public static String txtfinal = "";

    ArrayList<cpu> ArrayCpu = new ArrayList();
    ArrayList<componentes_dsalida> ArrayDs = new ArrayList();
    ArrayList<componentes_dimpresora> ArrayDi = new ArrayList();
    ArrayList<componentes> ArrayComp = new ArrayList();
    ArrayList<componentes_dentrada> ArrayDe = new ArrayList();
    ArrayList<componente_mixto> ArrayMix = new ArrayList();

    public control(vista vis, componentes com, componentes_dentrada comp_d, componentes_dsalida comp_dss, componentes_dimpresora comp_dii, componente_mixto comp_mi, cpu cp) {
        vist = vis;
        comp = com;
        comp_de = comp_d;
        comp_ds = comp_dss;
        comp_di = comp_dii;
        comp_mix = comp_mi;
        cp_u = cp;

        vist.btn_aggcpu.addActionListener(this);

        vist.btn_aggpf.addActionListener(this);
        vist.btn_buscaridpf.addActionListener(this);

        vist.btn_deletepf.addActionListener(this);
        vist.btn_editarcpu.addActionListener(this);
        vist.btn_editarpf.addActionListener(this);
        vist.btn_fresh_cpu.addActionListener(this);
        vist.btn_freshpf.addActionListener(this);
        vist.btn_impf.addActionListener(this);
        vist.btn_limpiar_txtpc.addActionListener(this);
        vist.btn_pagar.addActionListener(this);
        vist.btn_proc_venta.addActionListener(this);
        vist.btn_remov_cpu.addActionListener(this);
        vist.cbx_tipocon_pf.addActionListener(this);
        vist.cbx_tipopf.addActionListener(this);
        vist.btn_buscaridcpu.addActionListener(this);
        vist.btn_pagar.addActionListener(this);
        vist.btn_proc_venta.addActionListener(this);

    }

    public void iniciar() {
        vist.setVisible(true);
        vist.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BTN AGREGAR PERIFERICO
        if (e.getSource() == vist.btn_aggpf) {
            if (vist.cbx_tipopf.getSelectedItem() == "TECLADO" || vist.cbx_tipopf.getSelectedItem() == "MOUSE" || vist.cbx_tipopf.getSelectedItem() == "TABLETA GARFICA" || vist.cbx_tipopf.getSelectedItem() == "LAPIZ OPTICO") {
                //String tipo = "ENTRADA";

                comp = new componentes(vist.txt_idpf.getText(), vist.txt_nomp.getText(), vist.txt_fabripf.getText(), vist.txt_modelopf.getText(), (String) vist.cbx_tipopf.getSelectedItem() + "_ENTRADA", (String) vist.cbx_tipocon_pf.getSelectedItem(), Integer.parseInt(vist.txt_preciopf.getText()));
                comp_de = new componentes_dentrada(vist.txt_idpf.getText(), vist.txt_nomp.getText(), vist.txt_fabripf.getText(), vist.txt_modelopf.getText(), vist.cbx_tipopf.getSelectedItem() + "_ENTRADA", (String) vist.cbx_tipocon_pf.getSelectedItem(), Integer.parseInt(vist.txt_preciopf.getText()));
                ArrayComp.add(comp);
                ArrayDe.add(comp_de);

            }
            if (vist.cbx_tipopf.getSelectedItem() == "IMPRESORA LASER" || vist.cbx_tipopf.getSelectedItem() == "IMPRESORA INYECCION" || vist.cbx_tipopf.getSelectedItem() == "PANTALLA" || vist.cbx_tipopf.getSelectedItem() == "PARLANTE") {
                //String tipo = "SALIDA";

                comp = new componentes(vist.txt_idpf.getText(), vist.txt_nomp.getText(), vist.txt_fabripf.getText(), vist.txt_modelopf.getText(), (String) vist.cbx_tipopf.getSelectedItem() + "_SALIDA", (String) vist.cbx_tipocon_pf.getSelectedItem(), Integer.parseInt(vist.txt_preciopf.getText()));
                comp_ds = new componentes_dsalida(vist.txt_idpf.getText(), vist.txt_nomp.getText(), vist.txt_fabripf.getText(), vist.txt_modelopf.getText(), (String) vist.cbx_tipopf.getSelectedItem() + "_SALIDA", (String) vist.cbx_tipocon_pf.getSelectedItem(), Integer.parseInt(vist.txt_preciopf.getText()));
                ArrayComp.add(comp);
                ArrayDs.add(comp_ds);
            }

            if (vist.cbx_tipopf.getSelectedItem() == "PANTALLA TACTIL") {
                //String tipo = "MIXTO";

                comp = new componentes(vist.txt_idpf.getText(), vist.txt_nomp.getText(), vist.txt_fabripf.getText(), vist.txt_modelopf.getText(), (String) vist.cbx_tipopf.getSelectedItem() + "_MIXTO", (String) vist.cbx_tipocon_pf.getSelectedItem(), Integer.parseInt(vist.txt_preciopf.getText()));
                comp_ds = new componentes_dsalida(vist.txt_idpf.getText(), vist.txt_nomp.getText(), vist.txt_fabripf.getText(), vist.txt_modelopf.getText(), (String) vist.cbx_tipopf.getSelectedItem() + "_MIXTO", (String) vist.cbx_tipocon_pf.getSelectedItem(), Integer.parseInt(vist.txt_preciopf.getText()));
                ArrayComp.add(comp);
                ArrayDs.add(comp_ds);

            }
            JOptionPane.showMessageDialog(null, "¡PERIFERICO GUARDADO CORRECTAMENTE!");

        }

        if (e.getSource() == vist.btn_freshpf) {
            String colum[] = {"ID PF", "NOMBRE PF.", "MODELO", "PRECIO PF.", "TIPO PF.", "CONECTOR", "FABRICANTE"};
            String matriz[][] = new String[(ArrayComp.size())][7];

            for (int i = 0; i < matriz.length; i++) {
                matriz[i][0] = ArrayComp.get(i).getIdpf();
                matriz[i][1] = ArrayComp.get(i).getNompf();
                matriz[i][2] = ArrayComp.get(i).getModelopf();
                matriz[i][3] = Integer.toString(ArrayComp.get(i).getPreciopf());
                matriz[i][4] = ArrayComp.get(i).getTipopf();
                matriz[i][5] = ArrayComp.get(i).getTipoconpf();
                matriz[i][6] = ArrayComp.get(i).getNombrefabripf();

            }

            vist.Jtable_pf.setModel(new DefaultTableModel(matriz, colum));

        }
        // REMOVE COMP
        if (e.getSource() == vist.btn_deletepf) {
            int fila = vist.Jtable_pf.getSelectedRow();
            ArrayComp.remove(fila);

//            ArrayDe.remove(fila);
//            ArrayDs.remove(fila);
//            ArrayMix.remove(fila);
            DefaultTableModel x = (DefaultTableModel) vist.Jtable_pf.getModel();
            x.removeRow(fila);

            JOptionPane.showMessageDialog(null, "¡ELIMINACION DE PERIFERICO CORRECTA!");
        }

        // CPU AGG
        if (e.getSource() == vist.btn_aggcpu) {

            cp_u = new cpu(vist.txt_idcpu.getText(), vist.txt_fabricpu.getText(), vist.txt_modelocpu.getText(), vist.txt_proces_cpu.getText(), (String) vist.cbx_discocpu.getSelectedItem(), Integer.parseInt(vist.txt_preciocpu.getText()));
            ArrayCpu.add(cp_u);

            JOptionPane.showMessageDialog(null, "¡CPU GUARDADO CORRECTAMENTE!");
        }
        // CPU FRESH
        if (e.getSource() == vist.btn_fresh_cpu) {

            String colum1[] = {"ID CPU", "NOMBRE F.", "MODELO", "PRECIO CPU", "PROCESADOR", "DISCO",};
            String matriz1[][] = new String[(ArrayCpu.size())][7];

            for (int i = 0; i < matriz1.length; i++) {
                matriz1[i][0] = ArrayCpu.get(i).getIdcpu();
                matriz1[i][1] = ArrayCpu.get(i).getNombref_cpu();
                matriz1[i][2] = ArrayCpu.get(i).getModelocpu();
                matriz1[i][3] = Integer.toString(ArrayCpu.get(i).getPrecio_cpu());
                matriz1[i][4] = ArrayCpu.get(i).getProcesador_cpu();
                matriz1[i][5] = ArrayCpu.get(i).getDisco_cpu();

            }

            vist.Jtable_cpu.setModel(new DefaultTableModel(matriz1, colum1));
        }
        // CPU REMOV
        if (e.getSource() == vist.btn_remov_cpu) {
            int fila = vist.Jtable_cpu.getSelectedRow();
            ArrayCpu.remove(fila);
            DefaultTableModel x = (DefaultTableModel) vist.Jtable_cpu.getModel();
            x.removeRow(fila);
            JOptionPane.showMessageDialog(null, "¡ELIMINACION DE CPU CORRECTA!");
        }

        // BUSCAR DETALLE DE PERIFERICOS POR ID
        if (e.getSource() == vist.btn_buscaridpf) {
            String id = vist.txt_idpf_pc.getText();
            for (int i = 0; i < ArrayComp.size(); i++) {
                if (ArrayComp.get(i).getIdpf().equalsIgnoreCase(id)) {
                    System.out.println("");
                    // vist.lbl_total_compra.setText((Integer.parseInt(vist.lbl_total_compra.getText()) + ArrayComp.get(i).getPreciopf()) + "");
                    String txt = "ID: " + ArrayComp.get(i).getIdpf() + "\n"
                            + "NOMBRE:  " + ArrayComp.get(i).getNompf() + "\n"
                            + " NOMBRE FABRICANTE: " + ArrayComp.get(i).getNombrefabripf() + "\n"
                            + "MODELO: " + ArrayComp.get(i).getModelopf() + "\n"
                            + "PRECIO VENTA: " + ArrayComp.get(i).getPreciopf() + "\n"
                            + "TIPO:  " + ArrayComp.get(i).getTipopf() + "\n"
                            + "TIPO CONECTOR: " + ArrayComp.get(i).getTipoconpf() + "\n";

                    vist.jtext_dtpf.setText(txt);
                    totalcomp = totalcomp + ArrayComp.get(i).getPreciopf();
                    // AÑADIR COMPONENTE A COMPUTADOR
                    text0 = vist.jtext_dtpf.getText();
                    vist.jtext_dtpc.setText(vist.jtext_dtpc.getText() + text0);
                    vist.lbl_total_compra.setText(totalcomp + "");
                    break;
                }

            }
            cont_componentes++;
        }

        // LIMPIAR TXT COMPUTADOR
        if (e.getSource() == vist.btn_limpiar_txtpc) {
            vist.jtext_dtpc.setText("");
        }

        // BUSCAR POR ID DE CPU
        if (e.getSource() == vist.btn_buscaridcpu) {
            String idd = vist.txt_idcpu_pc.getText();
            for (int i = 0; i < ArrayCpu.size(); i++) {
                if (ArrayCpu.get(i).getIdcpu().equalsIgnoreCase(idd)) {
                    System.out.println("");

                    String txtt = "ID: " + ArrayCpu.get(i).getIdcpu() + "\n"
                            + "NOMBRE FABRICANTE " + ArrayCpu.get(i).getNombref_cpu() + "\n"
                            + "MODELO: " + ArrayCpu.get(i).getModelocpu() + "\n"
                            + "PRECIO VENTA: " + ArrayCpu.get(i).getPrecio_cpu() + "\n"
                            + "TIPO:  " + ArrayCpu.get(i).getTipocpu() + "\n"
                            + "DISCO: " + ArrayCpu.get(i).getDisco_cpu() + "\n"
                            + "PROCESADOR: " + ArrayCpu.get(i).getProcesador_cpu() + "\n";
                    vist.jtext_dtcpu.setText(txtt);
                    totalcomp = totalcomp + ArrayCpu.get(i).getPrecio_cpu();

                    // AGREGAR CPU A PC
                    text0 = (String) vist.jtext_dtcpu.getText();
                    vist.jtext_dtpc.setText(vist.jtext_dtpc.getText() + "\n" + text0);
                    vist.lbl_total_compra.setText(totalcomp + "");
                    break;
                }
            }
            cont_cpu++;
        }
        if (e.getSource() == vist.btn_proc_venta) {
            if (cont_componentes < 2) {
                JOptionPane.showMessageDialog(null, "LO SENTIMOS, AUN NO TIENES LOS COMPONENTES COMPLETOS.");
            } else if (cont_cpu < 1) {
                JOptionPane.showMessageDialog(null, "LO SENTIMOS, AUN NO TIENES POR LO MENOS UNA CPU.");
            } else {
                vist.lbl_subtotfin.setText(totalcomp + "");
                txtfinal = vist.jtext_dtpc.getText();
                vist.Jtext_dtventa.setText(txtfinal);
                JOptionPane.showMessageDialog(null, "PERFECTO, PROCEDAMOS CON LA COMPRA!");
            }

        }

        if (e.getSource() == vist.btn_pagar) {
            vist.lbl_subtotfin.setText(totalcomp + "");
            String vlr_modi = vist.txt_modiprecio.getText();
            if (vlr_modi.equalsIgnoreCase("")) {

                vist.txt_totalfin.setText(totalcomp + "");
                if (vist.txt_montopago.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR LLENE LOS CAMPOS");
                } else {

                }
            } else {
                int p = Integer.parseInt(vlr_modi);
                vist.txt_totalfin.setText(p + "");

            }

            int q = Integer.parseInt(vist.txt_montopago.getText());
            if (q < totalcomp) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE PAGO MAYOR AL FACTURADO");
            } else {
                JOptionPane.showMessageDialog(null, "PPAGO APROBADO!");
            }

        }

    }
}

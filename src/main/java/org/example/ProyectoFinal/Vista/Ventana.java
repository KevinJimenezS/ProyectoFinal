package org.example.ProyectoFinal.Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private JLabel lblId;
    private JLabel lblPersonaje;
    private JLabel lblSeriePelicula;
    private JLabel lblAnio;
    private JLabel lblEstatura;
    private JLabel lblUrl;
    private JLabel imagen;
    private JLabel lblDelete;
    private JTextField txtId;
    private JTextField txtPersonaje;
    private JTextField txtSeriePelicula;
    private JTextField txtAnio;
    private JTextField txtEstatura;
    private JTextField txtUrl;
    private JTextField txtActualizar;
    private JTextArea txaActualizar;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnDelete;
    private JButton btnActualizar;
    private JTable tblAnime;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(1100, 950);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //PANEL 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(64, 255, 255));
        lblId = new JLabel("ID");
        lblPersonaje = new JLabel("PERSONAJE");
        lblSeriePelicula = new JLabel("SERIE/PELICULA");
        lblAnio = new JLabel("AÑO LANZAMIENTO");
        lblEstatura = new JLabel("ESTATURA");
        lblUrl = new JLabel("URL");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtPersonaje = new JTextField(10);
        txtSeriePelicula = new JTextField(15);
        txtAnio = new JTextField(3);
        txtEstatura = new JTextField(10);
        txtUrl = new JTextField(25);
        btnAgregar = new JButton("AGREGAR");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblPersonaje);
        panel1.add(txtPersonaje);
        panel1.add(lblSeriePelicula);
        panel1.add(txtSeriePelicula);
        panel1.add(lblAnio);
        panel1.add(txtAnio);
        panel1.add(lblEstatura);
        panel1.add(txtEstatura);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);


        //PANEL 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(108, 197, 63));
        btnCargar = new JButton("CARGAR");
        panel2.add(btnCargar);
        tblAnime = new JTable();
        scrollPane = new JScrollPane(tblAnime);
        panel2.add(scrollPane);


        //PANEL 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(70, 10, 10));
        imagen = new JLabel("...");
        panel3.add(imagen);


        //PANEL 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(197, 140, 17));
        lblDelete = new JLabel("SELECCIONE EL PERSONAJE QUE QUIERA ELIMINAR");
        btnDelete = new JButton("BORRAR");
        txaActualizar = new JTextArea("ACTUALIZAR:" + "\n1.ESCRIBA UN VALOR NUEVO." +
                "\n 2.SELECCIONE EL DATO QUE QUIERE ACTUALIZAR" + " \n 3.PRESIONE ACTUALIZAR");
        txaActualizar.setBackground(null);
        txtActualizar = new JTextField(14);
        btnActualizar = new JButton("ACTUALIZAR");
        panel4.add(lblDelete);
        panel4.add(btnDelete);
        panel4.add(txaActualizar);
        panel4.add(txtActualizar);
        panel4.add(btnActualizar);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblPersonaje() {
        return lblPersonaje;
    }

    public void setLblPersonaje(JLabel lblPersonaje) {
        this.lblPersonaje = lblPersonaje;
    }

    public JLabel getLblSeriePelicula() {
        return lblSeriePelicula;
    }

    public void setLblSeriePelicula(JLabel lblSeriePelicula) {
        this.lblSeriePelicula = lblSeriePelicula;
    }

    public JLabel getLblAnio() {
        return lblAnio;
    }

    public void setLblAnio(JLabel lblAnio) {
        this.lblAnio = lblAnio;
    }

    public JLabel getLblEstatura() {
        return lblEstatura;
    }

    public void setLblEstatura(JLabel lblEstatura) {
        this.lblEstatura = lblEstatura;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtPersonaje() {
        return txtPersonaje;
    }

    public void setTxtPersonaje(JTextField txtPersonaje) {
        this.txtPersonaje = txtPersonaje;
    }

    public JTextField getTxtSeriePelicula() {
        return txtSeriePelicula;
    }

    public void setTxtSeriePelicula(JTextField txtSeriePelicula) {
        this.txtSeriePelicula = txtSeriePelicula;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public void setTxtAnio(JTextField txtAnio) {
        this.txtAnio = txtAnio;
    }

    public JTextField getTxtEstatura() {
        return txtEstatura;
    }

    public void setTxtEstatura(JTextField txtEstatura) {
        this.txtEstatura = txtEstatura;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public JTextField getTxtActualizar() {
        return txtActualizar;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblAnime() {
        return tblAnime;
    }

    public void setTblAnime(JTable tblLibro) {
        this.tblAnime = tblLibro;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public void limpiar() {
        txtPersonaje.setText("");
        txtSeriePelicula.setText("");
        txtAnio.setText("");
        txtEstatura.setText("");
        txtUrl.setText("");

    }
}

package com.mycompany.graficadora;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlanoCuadratico extends javax.swing.JFrame {

    private JPanel p;
    private int w;
    private int h;
    private int cont = 0;
    private Funcion f = new Funcion();
    
    public PlanoCuadratico() {
        initComponents();
    }
    
    public PlanoCuadratico (JPanel p) {
        this.p = p;
        this.w = p.getWidth();
        this.h = p.getHeight();
    }
    
    public void Dibujar(int cont) {
        int decimas = 1, contDecimas = 1, divisiones;
        
        for(divisiones = (int) f.getExtremoLineal(); divisiones > 10; divisiones /= 10, decimas *= 10, contDecimas++);
        
        Graphics2D g = (Graphics2D) p.getGraphics();
        
        // Limpiar si ya hay un plano previo
        if (cont > 1) {
            g.clearRect(0, 0, w, h);
        }
        
        //JOptionPane.showMessageDialog(rootPane, divisiones);
        int incremento = 200/divisiones;
        int medio = 200;
        
        for (int i = 1; i < 10; i++) {
            // Dibujar las lineas verticales del plano cartesiano desde el medio hasta la derecha
            g.drawLine(medio+i*incremento, 0, medio+i*incremento, h);
            g.drawLine(medio+(-i)*incremento, 0, medio+(-i)*incremento, h);
            // Dibujar los numeros segun las decimas
            g.drawString(Integer.toString(i*decimas), medio+i*incremento+4*contDecimas, medio+10);
            g.drawString(Integer.toString((-i)*decimas), medio+(-i)*incremento+4*contDecimas, medio+10);
        }
        
        for (int i = 1; i < 10; i++) {
            // Dibujar las lineas horizontales del plano cartesiano
            g.drawLine(0, medio+i*incremento, w,  medio+i*incremento);
            g.drawLine(0, medio+(-i)*incremento, w, medio+(-i)*incremento);
            // Dibujar los numeros segun las decimas
            g.drawString(Integer.toString(i*decimas), medio+i*incremento+4*contDecimas, medio+10);
            g.drawString(Integer.toString((-i)*decimas), medio+(-i)*incremento+4*contDecimas, medio+10);
        }
        
        // Hacer lineas en forma de puntos
        float[] dashingPattern = {2f, 2f};
        Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 1.0f, dashingPattern, 2.0f);
        
        // Diferenciar lineas del medio
        g.setStroke(stroke);
        g.setColor(Color.blue);
        
        g.drawLine(w/2, 0, w/2, h);
        g.drawLine(0, h/2, w, h/2);
        
    }
    
    /*public void dibujarPunto (float x, float y) {
        Graphics2D g = (Graphics2D) p.getGraphics();
        // Coordenadas desde donde se dibujara el punto
        // Se le multiplica la escala para que el punto quede en la posicion correcta
        int pX = (int) (w/2 + x*e);
        int pY = (int) (h/2 - y*e);
        
        // Dibujar el punto
        // Se le resta el radio del ancho/alto para que el punto quede centrado
        g.fillOval(pX - 3, pY - 3, 6, 6);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plano = new javax.swing.JPanel();
        graficarBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        aTxt = new javax.swing.JTextField();
        aLabel = new javax.swing.JLabel();
        bLabel = new javax.swing.JLabel();
        bTxt = new javax.swing.JTextField();
        cLabel = new javax.swing.JLabel();
        cTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Graficadora Cuadrática");

        plano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        plano.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout planoLayout = new javax.swing.GroupLayout(plano);
        plano.setLayout(planoLayout);
        planoLayout.setHorizontalGroup(
            planoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        planoLayout.setVerticalGroup(
            planoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        graficarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        graficarBtn.setText("GRAFICAR");
        graficarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graficarBtnMouseClicked(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(204, 204, 204));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setText("VOLVER");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        aTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aTxtKeyTyped(evt);
            }
        });

        aLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aLabel.setText("A:");

        bLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bLabel.setText("B:");

        bTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bTxtKeyTyped(evt);
            }
        });

        cLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cLabel.setText("C:");

        cTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cTxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(154, 154, 154)
                                .addComponent(graficarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(aLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(aTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(aLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(graficarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graficarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graficarBtnMouseClicked
        
        cont = cont + 1;
        PlanoCuadratico pC = new PlanoCuadratico(this.plano);
        
        String s1, s2, s3;
        int a, b, c;

        
        s1 = aTxt.getText();
        s2 = bTxt.getText();
        s3 = cTxt.getText();
        
        if (s1.isEmpty()) {
            a = 0;
        }
        else {
            a = Integer.parseInt(s1); 

        }
        
        if (s2.isEmpty()) {
            b = 0;
        }
        else {
            b = Integer.parseInt(s2);
        }
        
        if (s3.isEmpty()) {
            c = 0;
        }
        else {
            c = Integer.parseInt(s3);
        }
        
        f.setCuadratica(a, b, c);
        pC.Dibujar(cont);
        //f.DibujarCuadratica(pC);
    }//GEN-LAST:event_graficarBtnMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        this.setVisible(false);
        Graficadora g = new Graficadora();
        g.setVisible(true);
    }//GEN-LAST:event_backBtnMouseClicked

    private void bTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bTxtKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Solo ingrese números");
        }
    }//GEN-LAST:event_bTxtKeyTyped

    private void aTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aTxtKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Solo ingrese números");
        }
    }//GEN-LAST:event_aTxtKeyTyped

    private void cTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cTxtKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(rootPane, "Solo ingrese números");
        }
    }//GEN-LAST:event_cTxtKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField aTxt;
    private javax.swing.JLabel bLabel;
    private javax.swing.JTextField bTxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel cLabel;
    private javax.swing.JTextField cTxt;
    private javax.swing.JButton graficarBtn;
    private javax.swing.JPanel plano;
    // End of variables declaration//GEN-END:variables
}

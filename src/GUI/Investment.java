package GUI;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author Jake
 */
public class Investment extends javax.swing.JPanel {
    
    
    // Name of the investment
    private String name;
    // Original cost of the investment
    private int cost;
    // An array of the total returns on the investment
    private int[] returns;
    // The total return on investment over entire game
    private int ROI; 
    // The other benefits of the investment
    private StringBuilder benefits;
    // A reference to the parent MainGUI class;
    private MainGUI parent;

    /**
     * Creates new form Investment
     */
    public Investment() {
        initComponents();
    }
    
    // Settup all the custom fields
    public void setup( String name, int cost, int[] returns, String benefits){
        this.name = name;
        this.cost = cost;
        this.returns = returns;
        ROI = 0;
        for (int i:returns){
            ROI += i;
        }
        ROI *=100;
        ROI /= this.cost;
        this.benefits = new StringBuilder(benefits);
        cbInvest.setText(this.name);
        lblCost.setText(this.cost + "");
        lblROI.setText(this.ROI + "%");
    }

    public JCheckBox getCbName() {
        return cbInvest;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
        ROI = 0;
        for (int i:returns){
            ROI += i;
        }
        ROI *=100;
        ROI /= this.cost;
        lblCost.setText(this.cost + "");
        lblROI.setText(this.ROI + "%");
        parent.onUpdate();
    }
    
    
    
    public boolean isSelected(){
        return cbInvest.isSelected();
    }

    @Override
    public String getName() {
        return name;
    }
   
    

    public void setParent(MainGUI parent) {
        this.parent = parent;
    }
    
    public void onUpdate(){
        if (cbInvest.isSelected());
        else if ((MainGUI.getProN().getVar() < cost)) cbInvest.setEnabled(false);
        else cbInvest.setEnabled(true);
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbInvest = new javax.swing.JCheckBox();
        lblCost = new javax.swing.JLabel();
        lblROI = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(300, 23));
        setPreferredSize(new java.awt.Dimension(200, 21));
        setLayout(new java.awt.GridLayout(1, 3));

        cbInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInvestActionPerformed(evt);
            }
        });
        add(cbInvest);

        lblCost.setText("jLabel1");
        add(lblCost);

        lblROI.setText("jLabel2");
        add(lblROI);
    }// </editor-fold>//GEN-END:initComponents

    private void cbInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInvestActionPerformed
        
        if (MainGUI.getProN().getVar() < cost) {
            cbInvest.setSelected(false);
        }
        parent.onUpdate();
    }//GEN-LAST:event_cbInvestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbInvest;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblROI;
    // End of variables declaration//GEN-END:variables
}

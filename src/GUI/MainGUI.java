package GUI;

import Handler.*;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

/**
 *
 * @author Jake
 */
public final class MainGUI extends javax.swing.JFrame {
    
        
    // An array that holds all investments
    private static Investment[][] Investments;
    // An array that holds all Vars
    private static Var[] vars;
    
    
    
    // Private vars for non-relationship points
    private final static Var ProN = new Var("ProN");
    private final static Var ArmySize = new Var("Army Size");
    private final static Var ArmyQuality = new Var("Army Quality");
    
    private final static Var Duplicates = new Var("Duplicates");
    private final static Var SimonAnger = new Var("Simon Anger");
    private final static Var EntityCohesion = new Var("Entity Cohesion");
    
    // Private vars for secret stats
    // Simon's stats
    private final static Var Economy = new Var("Economy");
    private final static Var Social = new Var("Social");
    private final static Var Religion = new Var("Religion");
    // Country stats
    private final static Var Yhilin = new Var("Yhilin");
    private final static Var Aram = new Var("Aram");
    private final static Var Ardoheim = new Var("Ardoheim");
    private final static Var Eustrin = new Var("Eustrin");
    private final static Var Ghenalon = new Var("Ghenalon");
    private final static Var Zirantia = new Var("Zirantia");
    private final static Var Darghelon = new Var("Darghelon");
    private final static Var Gheldaron = new Var("Gheldaron");
    private final static Var Tatseni = new Var("Tatseni");
    private final static Var Stenai = new Var("Stenai");
    private final static Var OrgasmicEmpire = new Var("Orgasmic Empire");
    private final static Var ChaliceStates = new Var("Chalice States");
    private final static Var NewGivini = new Var("New Givini");
    private final static Var Takkan = new Var("Tak'Kan");
    private final static Var Erosia = new Var("Erosia");
    private final static Var Rodak = new Var("Rodak");
    
    // Other
    private final static Var Poverty = new Var("Yhilin Poverty");
    
    
    
    
    // Private vars that correspond to in-game vars
    // Relationship points for each character
    // Harem
    // Combat
    private final static Var Aka = new Var("Aka");
    private final static Var Altina = new Var("Altina");
    private final static Var Carina = new Var("Carina");
    private final static Var Ginasta = new Var("Ginasta");
    private final static Var Hilstara = new Var("Hilstara");
    private final static Var Nalili = new Var("Nalili");
    private final static Var Qum = new Var("Qum");
    private final static Var Riala = new Var("Riala");
    private final static Var Robin = new Var("Robin");
    private final static Var Uyae = new Var("Uyae");
    private final static Var Varia = new Var("Varia");
    private final static Var Yarra = new Var("Yarra");
    
    // Non-combat
    private final static Var Megail = new Var("Megail");
    private final static Var Trin = new Var("Trin");
    private final static Var Balia = new Var("Balia");
    private final static Var Dari = new Var("Dari");
    private final static Var Wynn = new Var("Wynn");
    private final static Var Iris = new Var("Iris");
    
    // Leaders
    private final static Var Janine = new Var("Janine");
    private final static Var Sarai = new Var("Sarai");
    private final static Var Fheliel = new Var("Fheliel");
    private final static Var Lynine = new Var("Lynine");
    private final static Var Orilise = new Var("Orilise");
    private final static Var Neranda = new Var("Neranda");
    
    // Other
    private final static Var Wendis = new Var("Wendis");
    private final static Var Sabitha = new Var("Sabitha");
    private final static Var Tertia = new Var("Tertia");
    
    // Allies
    private final static Var Elleani = new Var("Elleani");
    private final static Var Esthera = new Var("Esthera");
    private final static Var Mestan = new Var("Mestan");
    
    
    
    // Constants to represent the time code stamps for each check
    private final int CHP1_CHECK1_FOURSOME = 0;
    
    
    
    // Investment related time checks
    private final int CHP1_INVEST1_BEFORE_MEGAIL = 1;
    private final int CHP1_INVEST2_ROUND1 = 2;
    
    
    // Other
    private final String PRON_STINEFORD_REASON = "for converting ProN to Sx in Stineford.";
    
    // An array that holds all scroll panes;
    private JScrollPane[] scrollPanes;

    // Getter for ProN
    public static Var getProN() {
        return ProN;
    }
    
    
    

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        // Setup invest elements
        Investments = new Investment[][]{
        /*R1*/    {invR1AriGarda,invR1ArmsDealer,invR1Bank,invR1Bridge,invR1Cache,invR1Corruption,
        invR1DustyHorde,invR1IronCudgel,invR1Mine,invR1Public,invR1Shrine,invR1Supplier,invR1Steel,invR1Magicshop}
        };
        initMainGUIRef(Investments);
        // Init PRoN;
        CalculateStats(ProN);
        // Round 1
        invR1AriGarda.setup("AriGarda", 25000, new int[]{0,-75000}, "Saves Carina's soldiers.\n" +
        "Horde Battle\nBattle of Yhilin.\nIncreases rewards from clearing the House Rose Warehouse in chapter 4.");
        // Arms dealer is locked on
        invR1ArmsDealer.setup("Yhilini Arms Dealer", 100000, new int[]{200000,700000,115000,20000,20000,20000,20000,20000}, "");
        invR1ArmsDealer.getCbName().setSelected(true);
        invR1ArmsDealer.getCbName().setEnabled(false);
        invR1Bank.setup("Yhilin Bank", 50000, new int[]{5000,5000,200000}, "+5 Economy\n+1 Yhilin");
        invR1Bridge.setup("Bridge Repair", 10000, new int[]{0}, "Cheaper investment.\nBattle of Yhilin\n+1 Economy\n+2 Yhilin");
        invR1Cache.setup("Cache excavation", 10000, new int[]{0,25000}, "A few items, equipment for succubi and a cache of corruption for Simon.");
        invR1Corruption.setup("Anti-corruption campaign", 10000, new int[]{0}, "May affect the amount of ProN received from Bank investment" +
        " during Megail's route.\n+1 Social\n+1 Yhilin");
        invR1DustyHorde.setup("Dusty Horde", 15000, new int[]{0,-45000},"Saves Carina's soldiers.\nHorde Battle\nBattle of Yhilin");
        invR1IronCudgel.setup("Iron Cudgel", 10000, new int[]{0,-30000}, "Saves Carina's soldiers.\nHorde Battle\nThird Arclent War\n" +
        "Makes Iron Cudgel available for service at HQ in chapter 4.");
        invR1Mine.setup("Mine Processing", 25000, new int[]{10000,200000,200000,100000,100000,100000,100000,100000}, "Processor\n" +
        "Battle of Yhilin\n+2 Economy\n+2 Yhilin");
        invR1Public.setup("Yhilini Public Works", 5000, new int[]{0}, "+1 Yhilin");
        invR1Shrine.setup("Shrine renovation", 10000, new int[]{0}, "+1 Religion");
        invR1Supplier.setup("Gift to Megail", 25000, new int[]{0, 25000,25000,25000,25000,25000,25000,25000},"Supplier\n" +
        "Battle of Yhilin\n+2 Economy");
        invR1Steel.setup("Premium Steel", 20000, new int[]{0,100000},"Manufacturer\n10% shop discount.\n" +
        "Custom Equipment\nBattle of Yhilin\n+1 Economy");
        invR1Magicshop.setup("Stineford Magic Shop", 10000, new int[]{0,25000,25000,25000,25000,25000,25000,25000},"20% shop discount.");
        
        
        
        // Setup scroll panes to be faster
        scrollPanes = new JScrollPane[]{jScrollPaneDetails,jScrollPaneMain,jScrollPaneVars,jScrollPaneIntro,jScrollPaneVarsHeader};
        for (JScrollPane j:scrollPanes){
            j.getVerticalScrollBar().setUnitIncrement(16);
        }
        // Setup an array of all Vars
        Field[] fields = this.getClass().getDeclaredFields();
        // Works up to 100 vars
        Var[] vTemp = new Var[100];
        int i = 0;
        for (Field f :fields){
            try {
                if (f.getGenericType().toString().equals("class Handler.Var")){
                    vTemp[i] = (Var)f.get(null);
                    i++;
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        vars = new Var[i];
        for (int c=0;c<i;c++){
            vars[c] = vTemp[c];
        }
    }
    
    // Pass a reference to all investments
    public void initMainGUIRef(Investment[][] inv) {
        for (Investment[] iR : inv) {
            for (Investment i : iR) {
                i.setParent(this);
            }
        }
    }
    // Update all investments in one round based on remaining money
    public void updateInvestments(Investment [] inv){
        for (Investment i:inv){
            i.onUpdate();
        }
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupC1 = new javax.swing.ButtonGroup();
        jScrollPaneDetails = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        jScrollPaneVarsHeader = new javax.swing.JScrollPane();
        jListVarsHeader = new javax.swing.JList<>();
        jScrollPaneVars = new javax.swing.JScrollPane();
        jListVars = new javax.swing.JList<>();
        jScrollPaneMain = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPaneIntro = new javax.swing.JScrollPane();
        txtIntro = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();
        labelChp1 = new javax.swing.JLabel();
        labelChoice1 = new javax.swing.JLabel();
        btnC1Yarra = new javax.swing.JRadioButton();
        btnC1Qum = new javax.swing.JRadioButton();
        btnC1Aka = new javax.swing.JRadioButton();
        labelChoice2 = new javax.swing.JLabel();
        cbC2HighClass = new javax.swing.JCheckBox();
        cbC2YhiliniBastard = new javax.swing.JCheckBox();
        cbC2Zirantian = new javax.swing.JCheckBox();
        cbC2Exotic = new javax.swing.JCheckBox();
        cbC2BunnyBefore = new javax.swing.JCheckBox();
        cbC2BunnyAfter = new javax.swing.JCheckBox();
        labelChoice3 = new javax.swing.JLabel();
        cbC3Whored = new javax.swing.JCheckBox();
        labelChoice4 = new javax.swing.JLabel();
        jComboBoxProNCon = new javax.swing.JComboBox<>();
        labelChp1Invest = new javax.swing.JLabel();
        labelProNR1 = new javax.swing.JLabel();
        labelCost = new javax.swing.JLabel();
        labelROI = new javax.swing.JLabel();
        invR1ArmsDealer = new GUI.Investment();
        invR1Mine = new GUI.Investment();
        invR1Bank = new GUI.Investment();
        invR1Supplier = new GUI.Investment();
        invR1Steel = new GUI.Investment();
        invR1Cache = new GUI.Investment();
        invR1IronCudgel = new GUI.Investment();
        invR1DustyHorde = new GUI.Investment();
        invR1AriGarda = new GUI.Investment();
        invR1Corruption = new GUI.Investment();
        invR1Public = new GUI.Investment();
        invR1Bridge = new GUI.Investment();
        invR1Shrine = new GUI.Investment();
        invR1Magicshop = new GUI.Investment();
        labelChoice5 = new javax.swing.JLabel();
        cb5ProNCon = new javax.swing.JCheckBox();
        labelChoice6 = new javax.swing.JLabel();
        cb6CopyBank = new javax.swing.JCheckBox();
        labelCopyCount = new javax.swing.JLabel();
        cbR1TakeFunds = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choices And Checks");
        setName("Choices And Checks"); // NOI18N

        txtDetails.setEditable(false);
        txtDetails.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        txtDetails.setColumns(20);
        txtDetails.setLineWrap(true);
        txtDetails.setRows(5);
        txtDetails.setText("Enter the choices you want to make during your playthrough below and see the results. The simulator assumes you have maxed out anything possible to max out that isn't a choice.");
        txtDetails.setWrapStyleWord(true);
        txtDetails.setBorder(null);
        txtDetails.setFocusable(false);
        txtDetails.setOpaque(false);
        jScrollPaneDetails.setViewportView(txtDetails);

        jListVarsHeader.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Relationship Points", "Countries", "Secret Stats", "All" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListVarsHeader.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListVarsHeaderValueChanged(evt);
            }
        });
        jScrollPaneVarsHeader.setViewportView(jListVarsHeader);

        jListVars.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ProN", "Aka", "Altina", "Carina", "Ginasta", "Hilstara", "Nalili", "Qum", "Riala", "Robin", "Uyae", "Varia", "Yarra", "Megail", "Trin", "Balia", "Dari", "Wynn", "Iris", "Janine", "Sarai", "Fheliel", "Lynine", "Orilise", "Neranda", "Wendis", "Sabitha", "Tertia", "Elleani", "Esthera", "Mestan" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListVars.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListVarsValueChanged(evt);
            }
        });
        jScrollPaneVars.setViewportView(jListVars);

        jScrollPaneMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneMain.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtIntro.setEditable(false);
        txtIntro.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        txtIntro.setColumns(20);
        txtIntro.setLineWrap(true);
        txtIntro.setRows(5);
        txtIntro.setText("Enter the choices you want to make during your playthrough below and see the results. The simulator assumes you have maxed out anything possible to max out that isn't a choice.");
        txtIntro.setWrapStyleWord(true);
        txtIntro.setBorder(null);
        txtIntro.setFocusable(false);
        txtIntro.setOpaque(false);
        jScrollPaneIntro.setViewportView(txtIntro);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        labelChp1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelChp1.setText("Chapter 1: Soldier");

        labelChoice1.setText("Choice 1: Who to rescue first at merchant camp?");

        btnGroupC1.add(btnC1Yarra);
        btnC1Yarra.setText("Yarra");
        btnC1Yarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC1YarraActionPerformed(evt);
            }
        });

        btnGroupC1.add(btnC1Qum);
        btnC1Qum.setText("Qum");
        btnC1Qum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC1QumActionPerformed(evt);
            }
        });

        btnGroupC1.add(btnC1Aka);
        btnC1Aka.setText("Aka");
        btnC1Aka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC1AkaActionPerformed(evt);
            }
        });

        labelChoice2.setText("Choice 2: Which prostitutes, if any, to sleep with in Stineford.");

        cbC2HighClass.setText("High-class Prostitute");
        cbC2HighClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbC2HighClassActionPerformed(evt);
            }
        });

        cbC2YhiliniBastard.setText("Yhilini Bastard Prostitute");
        cbC2YhiliniBastard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbC2YhiliniBastardActionPerformed(evt);
            }
        });

        cbC2Zirantian.setText("Zirantian Prostitute");
        cbC2Zirantian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbC2ZirantianActionPerformed(evt);
            }
        });

        cbC2Exotic.setText("Exotic Prostitute");

        cbC2BunnyBefore.setText("Bunny-ears Prostitute (Pre-reveal)");
        cbC2BunnyBefore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbC2BunnyBeforeActionPerformed(evt);
            }
        });

        cbC2BunnyAfter.setText("Bunny-ears Prostitute (Post-reveal)");
        cbC2BunnyAfter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbC2BunnyAfterActionPerformed(evt);
            }
        });

        labelChoice3.setText("Choice 3: Whether or not to whore Qum out.");

        cbC3Whored.setText("Qum whored out");
        cbC3Whored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbC3WhoredActionPerformed(evt);
            }
        });

        labelChoice4.setText("Choice 4: How much ProN to convert to Sx in Stineford");

        jComboBoxProNCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 ProN", "2500 ProN", "5000 ProN", "7500 ProN", "10000 ProN", "12500 ProN", "15000 ProN" }));
        jComboBoxProNCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProNConActionPerformed(evt);
            }
        });

        labelChp1Invest.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelChp1Invest.setText("Round 1 Investments");

        labelProNR1.setText("ProN: 80000");

        labelCost.setText("Cost");

        labelROI.setText("Return On Investment");

        labelChoice5.setText("Choice 5: Whether or not to have Megail convert ProN into Sx for you");

        cb5ProNCon.setText("10k ProN converted into 25k Sx");
        cb5ProNCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ProNConActionPerformed(evt);
            }
        });

        labelChoice6.setText("Choice 6: Whether or not to have Trin duplicate the Yhilin Bank Employee");

        cb6CopyBank.setText("Copy bank employee");
        cb6CopyBank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb6CopyBankActionPerformed(evt);
            }
        });

        labelCopyCount.setText("0/6 Duplicates");

        cbR1TakeFunds.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cbR1TakeFunds.setText("Take extra 25k from Megail");
        cbR1TakeFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbR1TakeFundsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPaneIntro, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelChp1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnC1Yarra)
                                .addGap(18, 18, 18)
                                .addComponent(btnC1Qum)
                                .addGap(18, 18, 18)
                                .addComponent(btnC1Aka))
                            .addComponent(cbC2HighClass)
                            .addComponent(cbC2BunnyBefore)
                            .addComponent(cbC2Zirantian))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbC2BunnyAfter)
                            .addComponent(cbC2Exotic)
                            .addComponent(cbC2YhiliniBastard)))
                    .addComponent(labelChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbC3Whored)
                    .addComponent(labelChoice3)
                    .addComponent(labelChoice4)
                    .addComponent(labelChoice5)
                    .addComponent(jComboBoxProNCon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb5ProNCon)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cb6CopyBank)
                            .addGap(18, 18, 18)
                            .addComponent(labelCopyCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(labelChoice6, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(invR1IronCudgel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(invR1Cache, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1DustyHorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1AriGarda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Steel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Corruption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Public, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Bridge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Shrine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Magicshop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Supplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Bank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelProNR1)
                                .addGap(102, 102, 102)
                                .addComponent(labelCost)
                                .addGap(56, 56, 56)
                                .addComponent(labelROI))
                            .addComponent(invR1ArmsDealer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invR1Mine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(labelChp1Invest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbR1TakeFunds)))
                .addContainerGap(795, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneIntro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelChp1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelChp1Invest, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbR1TakeFunds))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelChoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnC1Qum)
                            .addComponent(btnC1Yarra)
                            .addComponent(btnC1Aka))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelChoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbC2Zirantian)
                                    .addComponent(cbC2Exotic)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbC2HighClass)
                                .addComponent(cbC2YhiliniBastard)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbC2BunnyBefore)
                            .addComponent(cbC2BunnyAfter))
                        .addGap(18, 18, 18)
                        .addComponent(labelChoice3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbC3Whored)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelChoice4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProNCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelChoice5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb5ProNCon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelChoice6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb6CopyBank)
                            .addComponent(labelCopyCount)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelProNR1)
                            .addComponent(labelCost)
                            .addComponent(labelROI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1ArmsDealer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Mine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Bank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Steel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Cache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1IronCudgel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1DustyHorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1AriGarda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Corruption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Public, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Bridge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Shrine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invR1Magicshop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(690, 690, 690))
        );

        jScrollPaneMain.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneVarsHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneVars, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 1025, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneDetails)
                    .addComponent(jScrollPaneVars)
                    .addComponent(jScrollPaneVarsHeader))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnC1YarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC1YarraActionPerformed

    }//GEN-LAST:event_btnC1YarraActionPerformed

    private void btnC1QumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC1QumActionPerformed

    }//GEN-LAST:event_btnC1QumActionPerformed

    private void btnC1AkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC1AkaActionPerformed

    }//GEN-LAST:event_btnC1AkaActionPerformed

    private void cbC2HighClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbC2HighClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbC2HighClassActionPerformed

    private void cbC2BunnyBeforeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbC2BunnyBeforeActionPerformed
        cbC2BunnyAfter.setSelected(false);
    }//GEN-LAST:event_cbC2BunnyBeforeActionPerformed

    private void cbC2BunnyAfterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbC2BunnyAfterActionPerformed
        cbC2BunnyBefore.setSelected(false);
    }//GEN-LAST:event_cbC2BunnyAfterActionPerformed

    private void jListVarsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListVarsValueChanged
        onUpdate();
    }//GEN-LAST:event_jListVarsValueChanged

    private void cbC3WhoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbC3WhoredActionPerformed
        // ProN cannot drop below 50k here.
        if (CalculateStats(ProN,CHP1_INVEST1_BEFORE_MEGAIL) < 50000) jComboBoxProNCon.setSelectedIndex(0);
    }//GEN-LAST:event_cbC3WhoredActionPerformed

    private void cbC2ZirantianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbC2ZirantianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbC2ZirantianActionPerformed

    private void cbC2YhiliniBastardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbC2YhiliniBastardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbC2YhiliniBastardActionPerformed

    private void jComboBoxProNConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProNConActionPerformed
        // ProN cannot drop below 50k here.
        if (CalculateStats(ProN,CHP1_INVEST1_BEFORE_MEGAIL) < 50000) jComboBoxProNCon.setSelectedIndex(0);
    }//GEN-LAST:event_jComboBoxProNConActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        onUpdate();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cb5ProNConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ProNConActionPerformed
        if (CalculateStats(ProN,CHP1_INVEST2_ROUND1) < 10000) cb5ProNCon.setSelected(false);
    }//GEN-LAST:event_cb5ProNConActionPerformed

    private void cb6CopyBankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb6CopyBankActionPerformed
        int i = CalculateStats(Duplicates);
        StringBuilder sb = new StringBuilder(Duplicates.toString()).append("/").append(i).append(" Duplicates");
        labelCopyCount.setText(sb.toString());
        if (cb6CopyBank.isSelected()) invR1Bank.setCost(25000);
        else invR1Bank.setCost(50000);
    }//GEN-LAST:event_cb6CopyBankActionPerformed

    private void cbR1TakeFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbR1TakeFundsActionPerformed
        onUpdate();
    }//GEN-LAST:event_cbR1TakeFundsActionPerformed

    private void jListVarsHeaderValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListVarsHeaderValueChanged
        updateHeader();
    }//GEN-LAST:event_jListVarsHeaderValueChanged
    
    
    
    public void onUpdate() {
        // Update the ProN figures
        CalculateStats(ProN,CHP1_INVEST2_ROUND1);
        labelProNR1.setText(new StringBuilder("ProN: ").append(ProN.getVar()).toString());
        try {
            // Update the details on the selected var
            boolean supported = false;
            for (Var v : vars) {
                if (v.getName().equals(jListVars.getSelectedValue())) {
                    System.out.println("Found var");
                    CalculateStats(v);
                    v.getSb().append("\n").append(v).append(" = ").append(v.getName()).append(" Total Value.");
                    txtDetails.setText(v.getSb().toString());
                    supported = true;
                    break;
                }

                if (!supported) {
                    txtDetails.setText("That value has not been implemented yet.");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void updateHelper(Var v) {
        v.getSb().append("\n").append(v).append(" = ").append(v.getName()).append(" Total Value.");
        txtDetails.setText(v.getSb().toString());
    }
    
    private void updateHeader(){
        DefaultListModel model = new DefaultListModel();
        try {
            // Update the details on the selected var
            switch (jListVarsHeader.getSelectedValue()) {
                case "Relationship Points":
                    model.addElement(Aka.getName());
                    model.addElement(Altina.getName());
                    model.addElement(Balia.getName());
                    model.addElement(Carina.getName());
                    model.addElement(Dari.getName());
                    model.addElement(Elleani.getName());
                    model.addElement(Esthera.getName());
                    model.addElement(Fheliel.getName());
                    model.addElement(Ginasta.getName());
                    model.addElement(Hilstara.getName());
                    model.addElement(Iris.getName());
                    model.addElement(Janine.getName());
                    model.addElement(Lynine.getName());
                    model.addElement(Megail.getName());
                    model.addElement(Mestan.getName());
                    model.addElement(Nalili.getName());
                    model.addElement(Neranda.getName());
                    model.addElement(Orilise.getName());
                    model.addElement(Qum.getName());
                    model.addElement(Riala.getName());
                    model.addElement(Robin.getName());
                    model.addElement(Sabitha.getName());
                    model.addElement(Sarai.getName());
                    model.addElement(Tertia.getName());
                    model.addElement(Trin.getName());
                    model.addElement(Uyae.getName());
                    model.addElement(Varia.getName());
                    model.addElement(Wendis.getName());
                    model.addElement(Wynn.getName());
                    model.addElement(Yarra.getName());
                    break;
                case "Countries":
                    model.addElement(Aram.getName());
                    model.addElement(Ardoheim.getName());
                    model.addElement(ChaliceStates.getName());
                    model.addElement(Darghelon.getName());
                    model.addElement(Erosia.getName());
                    model.addElement(Eustrin.getName());
                    model.addElement(Gheldaron.getName());
                    model.addElement(Ghenalon.getName());
                    model.addElement(NewGivini.getName());
                    model.addElement(OrgasmicEmpire.getName());
                    model.addElement(Rodak.getName());
                    model.addElement(Stenai.getName());
                    model.addElement(Takkan.getName());
                    model.addElement(Tatseni.getName());
                    model.addElement(Yhilin.getName());
                    model.addElement(Zirantia.getName());
                    break;
                case "Secret Stats":
                    model.addElement(Economy.getName());
                    model.addElement(Social.getName());
                    model.addElement(Religion.getName());
                    break;
                case "Aka RP":
                    
                    break;
                case "Hilstara RP":
                    
                    break;
                case "Robin RP":
                    
                    break;
                case "Megail RP":
                    
                    break;
                case "Janine RP":
                    
                    break;
                case "Carina RP":
                    
                    break;
                case "Sarai RP":
                    
                    break;
                case "All":
                    for (Var v:vars){
                        model.addElement(v.getName());
                    }
                    break;
                default:
                    txtDetails.setText("That value has not been implemented yet.");
            }
            jListVars.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
    
    // Calculate stats combined method
    public int CalculateStats(Var v, int endTime){
        v.Reset();
        if (v.equals(ProN)) CalculateStatsProN(endTime);
        else if (v.equals(Economy)) CalculateStatsEconomy(endTime);
        else if (v.equals(Social)) CalculateStatsSocial(endTime);
        else if (v.equals(Religion)) CalculateStatsReligion(endTime);
        // Special case, returns duplicate total
        else if (v.equals(Duplicates)) return CalculateStatsDuplicates(endTime);
        else if (v.equals(Aka)) CalculateStatsAka(endTime);
        else if (v.equals(Carina)) CalculateStatsCarina(endTime);
        else if (v.equals(Hilstara)) CalculateStatsHilstara(endTime);
        else if (v.equals(Janine)) CalculateStatsJanine(endTime);
        else if (v.equals(Megail)) CalculateStatsMegail(endTime);
        else if (v.equals(Qum)) CalculateStatsQum(endTime);
        else if (v.equals(Robin)) CalculateStatsRobin(endTime);
        else if (v.equals(Sarai)) CalculateStatsSarai(endTime);
        else if (v.equals(Trin)) CalculateStatsTrin(endTime);
        else if (v.equals(Yarra)) CalculateStatsYarra(endTime);
        return v.getVar();
    }
    // If no endTime, call with -1
    public int CalculateStats(Var v){
        return CalculateStats(v, -1);
    }
    
    
    // Non RP calcs
    public int CalculateStatsProN (int endTime) {
        // ProN starts at 60k if you do all the quests
        ProN.Change(60000, "ProN Base Value.");
        // Gain 5k ProN if you whore out Qum
        if (cbC3Whored.isSelected()) ProN.Change(5000, "for whoring out Qum.");
        // Spend up to 15k converting to Sx in Stineford
        switch (jComboBoxProNCon.getSelectedItem().toString()){
            case "0 ProN":
                break;
            case "2500 ProN":
                ProN.Change(-2500, PRON_STINEFORD_REASON);
                break;
            case "5000 ProN":
                ProN.Change(-5000, PRON_STINEFORD_REASON);
                break;
            case "7500 ProN":
                ProN.Change(-7500, PRON_STINEFORD_REASON);
                break;
            case "10000 ProN":
                ProN.Change(-10000, PRON_STINEFORD_REASON);
                break;
            case "12500 ProN":
                ProN.Change(-12500, PRON_STINEFORD_REASON);
                break;
            case "15000 ProN":
                ProN.Change(-15000, PRON_STINEFORD_REASON);
                break;
        }
        // First investment end, gives all ProN to Megail upon leaving stineford to further invest.
        if (endTime == CHP1_INVEST1_BEFORE_MEGAIL) return ProN.getVar();
        // Base ProN now gets multiplied by 3 thanks to Megail
        ProN.setVar(ProN.getVar() * 3);
        ProN.getSb().append("\n*3 from Megail");
        // Round 1 of investments starts here
        // Can choose to take 25k extra from Megail
        if (cbR1TakeFunds.isSelected()) ProN.Change(25000, " for taking extra funds from Megail.");
        // Special convert from ProN to Sx with Megail
        if (cb5ProNCon.isSelected()) ProN.Change(-10000, "for having Megail convert ProN to Sx. (pre-reunion)");
        for (Investment i:Investments[0]){
            if (i.getCbName().isSelected()) ProN.Change(-i.getCost(), new StringBuilder("for the ").append(i.getName()).append(".").toString());
        }
        // Chapter 2
        // Bank gives 5k if invested in before the start of round 2
        if (invR1Bank.isSelected()) ProN.Change(5000, "from the Yhilin Bank at the start of chapter 2.");
        // Update the GUI of all investments based on the amount of money you now have
        updateInvestments(Investments[0]);
        if (endTime == CHP1_INVEST2_ROUND1) return ProN.getVar();
        
        
        return ProN.getVar();
    }
    public int CalculateStatsEconomy(int endTime){
        // Chapter 1
        Economy.Change(0, "Economy Base Value.");
        // +1 getting Robin's potions license.
        Economy.Change(1, "for getting Robin's potions license.");
        // +2 investing in Megail's secret investment right after you rescue her.
        if (invR1Supplier.isSelected()) Economy.Change(2, "for investing in Megail's secret investment right after you rescue her.");
        // 5 investing in Yhilin Bank by the start of chapter 2.
        if (invR1Bank.isSelected()) Economy.Change(5, "for investing in Yhilin Bank by the start of chapter 2.");
        // 1 investing in Premium Steel by the start of chapter 2.
        if (invR1Steel.isSelected()) Economy.Change(1, "for investing in Premium Steel by the start of chapter 2.");
        // +1 investing in Bridge Repair by the start of chapter 2.
        if (invR1Bridge.isSelected()) Economy.Change(1, "for investing in Bridge Repair by the start of chapter 2.");
        // +2 investing in Mine Processing by the start of chapter 2.
        if (invR1Mine.isSelected()) Economy.Change(2, "for investing in Mine Processing by the start of chapter 2.");
        // Chapter 2
        return Economy.getVar();
    }
    public int CalculateStatsSocial(int endTime){
        // Chapter 1
        Social.Change(0, "Social Base Value.");
        // +1 investing in Anti-corruption campaign by the start of chapter 2.
        if (invR1Corruption.isSelected()) Social.Change(1, "for investing in Anti-corruption campaign by the start of chapter 2.");
        // +1 finishing Noble figurines quest.
        Social.Change(1, "for finishing Noble figurines quest.");
        // Chapter 2
        return Social.getVar();
    }
    public int CalculateStatsReligion(int endTime){
        // Chapter 1
        Religion.Change(0, "Religion Base Value.");
        // +2 finishing Slavery in Stineford quest.
        Religion.Change(2, "for finishing Slavery in Stineford quest.");
        // +1 investing in Shrine Renovation by the start of chapter 2.
        if (invR1Shrine.isSelected()) Religion.Change(1, "for investing in Shrine Renovation by the start of chapter 2.");
        // Chapter 2
        return Religion.getVar();
    }
    public int CalculateStatsDuplicates(int endTime) {
        if (cb6CopyBank.isSelected()) Duplicates.Change(1, "for copying the Yhilin Bank employee.");
        int DuplicateTotal = 6;
        int TrinRP = CalculateStats(Trin);
        if (TrinRP >=50) DuplicateTotal+=2;
        else if (TrinRP >=30) DuplicateTotal+=1;
        return DuplicateTotal;
    }
    // RP calcs
    public int CalculateStatsYarra (int endTime){
        // Chapter 1
        // Yarra is introduced with a base value of 30
        Yarra.Change(30, "Yarra Base Value.");
        // Up to +2 from doing as much as possible to persuade Simon as Yarra in Feroholm.
        Yarra.Change(2, "from doing as much as possible to persuade Simon as Yarra in Feroholm.");
        // +1 if you completely clear the trail to the merchant camp of logs and enemies (except slimes; they're optional).
        Yarra.Change(1, "if you completely clear the trail to the merchant camp of logs and enemies.");
        // +5 helping her in the merchant camp meeting hall, OR +10 if you help her first.
        if (btnC1Yarra.isSelected())Yarra.Change(10, "for helping her first in the merchant camp meeting hall.");
        else Yarra.Change(5, "for helping her in the merchant camp meeting hall.");
        // +5 high-class prostitute, +5 Yhilini bastard prostitute, +5 Zirantian prostitute, 
        // +2 bunny-ears prostitute (pre-reveal), +1 bunny-ears prostitute (post-reveal), +5 exotic prostitute.
        if (cbC2HighClass.isSelected()) Yarra.Change(5, "for sleeping with the high-class prostitute.");
        if (cbC2YhiliniBastard.isSelected()) Yarra.Change(5, "for sleeping with the Yhilini bastard prostitute.");
        if (cbC2Zirantian.isSelected()) Yarra.Change(5, "for sleeping with the Zirantian prostitute.");
        if (cbC2Exotic.isSelected()) Yarra.Change(5, "for sleeping with the exotic prostitute.");
        if (cbC2BunnyBefore.isSelected()) Yarra.Change(2, "for sleeping with the bunny-ears prostitute (pre-reveal).");
        else if (cbC2BunnyAfter.isSelected()) Yarra.Change(1, "for sleeping with the bunny-ears prostitute (post-reveal).");
        // +10 talking to Yarra admirer in Succubus Hideout.
        Yarra.Change(10, "for talking to Yarra admirer in Succubus Hideout.");
        // First check, foursome on leaving Stineford (requires 130 total affection between Yarra, Qum, and Aka)
        if (endTime == CHP1_CHECK1_FOURSOME) return Yarra.getVar();
        // +5 earning the foursome on leaving Stineford (requires 130 total harem affection)
        if (CalculateStats(Yarra,CHP1_CHECK1_FOURSOME)+CalculateStats(Qum,CHP1_CHECK1_FOURSOME)+CalculateStats(Aka,CHP1_CHECK1_FOURSOME)>=130){
            Yarra.Change(5, "for earning the foursome on leaving Stineford (requires 130 total harem affection).");
        }
        // +1 talking twice to Simon as Yarra in Devil's Pass.
        Yarra.Change(1, "for talking twice to Simon as Yarra in Devil's Pass.");
        // +5 talking to Yarra about Robin immediately after the Yhilin coup sequence (before getting ProN from Megail).
        Yarra.Change(5, "for talking to Yarra about Robin immediately after the Yhilin coup sequence (before getting ProN from Megail).");
        // +5 investing in cache excavation. (pre-reunion)
        if (invR1Cache.isSelected()) Yarra.Change(5, "for investing in cache excavation. (pre-reunion)");
        // +5 hiring at least one mercenary company. (pre-reunion)
        if (invR1AriGarda.isSelected()||invR1DustyHorde.isSelected()||invR1IronCudgel.isSelected()) 
            Yarra.Change(5, "for hiring at least one mercenary company. (pre-reunion)");
        // +5 from having Megail convert ProN to Sx. (pre-reunion)
        // Convert changes 10k Pron into 25k Sx. Can only be done once.
        if (cb5ProNCon.isSelected()) Yarra.Change(5, "for having Megail convert ProN to Sx. (pre-reunion)");
        // Chapter 2
        return Yarra.getVar();
    }
    public int CalculateStatsQum (int endTime){
        // Chapter 1
        // Qum is introduced with a base value of 50
        Qum.Change(50, "Qum Base Value.");
        // +1 if you completely clear the trail to the merchant camp of logs and enemies (except slimes; they're optional).
        Qum.Change(1, "if you completely clear the trail to the merchant camp of logs and enemies.");
        // +5 helping her in the merchant camp meeting hall, OR +10 if you help her first.
        if (btnC1Qum.isSelected()) Qum.Change(10, "for helping her first in the merchant camp meeting hall.");
        else Qum.Change(5, "for helping her in the merchant camp meeting hall.");
        // +5 for refusing to whore her out, OR -10 for accepting to whore her out (plus ongoing penalties thereafter).
        if (cbC3Whored.isSelected()) Qum.Change(-10, "for whoring her out.");
        else Qum.Change(5, "for not whoring her out.");
        // +5 for talking to Yarra's admirer in Succubus Hideout.
        Qum.Change(5, "for talking to Yarra's admirer in Succubus Hideout.");
        // First check, foursome on leaving Stineford (requires 130 total affection between Yarra, Qum, and Aka)
        if (endTime == CHP1_CHECK1_FOURSOME) return Qum.getVar();
        // +5 for getting the Stineford Orgy sex scene IF you refused to whore her, 
        // OR +2 IF you whored her.(requires 130 total harem affection)
        if (CalculateStats(Yarra,CHP1_CHECK1_FOURSOME)+CalculateStats(Qum,CHP1_CHECK1_FOURSOME)+CalculateStats(Aka,CHP1_CHECK1_FOURSOME)>=130){
            if (cbC3Whored.isSelected()) Qum.Change(2, "for earning the foursome on leaving Stineford (requires 130 total harem affection) after whoring Qum.");
            else Qum.Change(5, "for earning the foursome on leaving Stineford (requires 130 total harem affection).");
        }
        // +5 for investing in Cache excavation (pre-reunion).
        if (invR1Cache.isSelected()) Qum.Change(5, "for investing in cache excavation. (pre-reunion)");
        // Chapter 2
        return Qum.getVar();
    }
    public int CalculateStatsAka (int endTime){
        // Chapter 1
        // Aka is introduced with a base value of 20
        Aka.Change(20, "Aka Base Value.");
        // +1 if you completely clear the trail to the merchant camp of logs and enemies (except slimes; they're optional).
        Aka.Change(1, "if you completely clear the trail to the merchant camp of logs and enemies.");
        // +5 helping her in the merchant camp meeting hall, OR +10 if you help her first.
        if (btnC1Aka.isSelected()) Aka.Change(10, "for helping her first in the merchant camp meeting hall.");
        else Aka.Change(5, "for helping her in the merchant camp meeting hall.");
        // -2 high-class prostitute, -6 Yhilini bastard prostitute, -7 Zirantian prostitute, 
        // -1 bunny-ears prostitute (pre-reveal), -6 exotic prostitute. (no loss for bunny-ears prostitute post-reveal)
        if (cbC2HighClass.isSelected()) Aka.Change(-2, "for sleeping with the high-class prostitute.");
        if (cbC2YhiliniBastard.isSelected()) Aka.Change(-6, "for sleeping with the Yhilini bastard prostitute.");
        if (cbC2Zirantian.isSelected()) Aka.Change(-7, "for sleeping with the Zirantian prostitute.");
        if (cbC2Exotic.isSelected()) Aka.Change(-6, "for sleeping with the exotic prostitute.");
        if (cbC2BunnyBefore.isSelected()) Aka.Change(-1, "for sleeping with the bunny-ears prostitute (pre-reveal).");
        // +10 from making Aka's Custom Knife.
        Aka.Change(10, "for making Aka's Custom Knife.");
        // +1 for each 2500 ProN converted to Sx at Stineford bank, OR +5 for 10k at once. (So up to +7, if you whore Qum.)
        switch (jComboBoxProNCon.getSelectedItem().toString()){
            case "0 ProN":
                break;
            case "2500 ProN":
                Aka.Change(1, PRON_STINEFORD_REASON);
                break;
            case "5000 ProN":
                Aka.Change(2, PRON_STINEFORD_REASON);
                break;
            case "7500 ProN":
                Aka.Change(3, PRON_STINEFORD_REASON);
                break;
            case "10000 ProN":
                Aka.Change(5, PRON_STINEFORD_REASON);
                break;
            case "12500 ProN":
                Aka.Change(6, PRON_STINEFORD_REASON);
                break;
            case "15000 ProN":
                Aka.Change(7, PRON_STINEFORD_REASON);
                break;
        }
        // First check, foursome on leaving Stineford (requires 130 total affection between Yarra, Qum, and Aka)
        if (endTime == CHP1_CHECK1_FOURSOME) return Aka.getVar();
        // +5 earning the foursome on leaving Stineford (requires 130 total harem affection)
        if (CalculateStats(Yarra,CHP1_CHECK1_FOURSOME)+CalculateStats(Qum,CHP1_CHECK1_FOURSOME)+CalculateStats(Aka,CHP1_CHECK1_FOURSOME)>=130){
            Aka.Change(5, "for earning the foursome on leaving Stineford (requires 130 total harem affection).");
        }
        // +5 investing in Premium Steel. (pre-reunion)
        if (invR1Steel.isSelected()) Aka.Change(5, "for investing in Premium Steel. (pre-reunion)");
        // +5 from having Megail convert ProN to Sx.
        if (cb5ProNCon.isSelected()) Aka.Change(5, "for having Megail convert ProN to Sx. (pre-reunion)");
        // Chapter 2
        return Aka.getVar();
    }
    public int CalculateStatsHilstara (int endTime){
        // Chapter 1
        // Hilstara is introduced with a base value of 25
        Hilstara.Change(25, "Hilstara Base Value.");
        // Up to +5 from Yarra's efforts in Devil's Pass.
        Hilstara.Change(5, "for Yarra's efforts in Devil's Pass.");
        // +5 bathing with her after Yhilin coup sequence.
        Hilstara.Change(5, "for bathing with her after Yhilin coup sequence.");
        // +5 hiring at least one mercenary company.
        if (invR1AriGarda.isSelected()||invR1DustyHorde.isSelected()||invR1IronCudgel.isSelected()) 
            Hilstara.Change(5, "for hiring at least one mercenary company. (pre-reunion)");
        // +5 investing in Premium Steel.
        if (invR1Steel.isSelected()) Hilstara.Change(5, "for investing in Premium Steel. (pre-reunion)");
        // +5 from having Megail convert ProN to Sx. (pre-reunion)
        if (cb5ProNCon.isSelected()) Hilstara.Change(5, "for having Megail convert ProN to Sx. (pre-reunion)");
        // Chapter 2
        return Hilstara.getVar();
    }
    public int CalculateStatsRobin (int endTime){
        // Chapter 1
        // Robin is introduced with a base value of 80
        Robin.Change(80, "Robin Base Value.");
        // +2 for acquiring her potion license.
        Robin.Change(2, "for acquiring her potion license.");
        // Chapter 2
        return Robin.getVar();
    }
    public int CalculateStatsMegail (int endTime){
        // Chapter 1
        // Megail is introduced with a base value of 20
        Megail.Change(20, "Megail Base Value.");
        // +3 for exceeding ProN requirement in Stineford, OR +10 for exceeding by at least 10,000 ProN.
        Megail.Change(10, "for exceeding ProN requirement in Stineford by at least 10k ProN");
        // +5 for investing in mystery investment after her rescue.
        if (invR1Supplier.isSelected()) Megail.Change(5, "for investing in mystery investment after her rescue.");
        // +5 for investing in Yhilin Bank.
        if (invR1Bank.isSelected()) Megail.Change(5, "for investing in Yhilin Bank.");
        // +5 for investing in Mine Processing (chapter 1 or late chapter 2).
        if (invR1Mine.isSelected()) Megail.Change(5, "or investing in Mine Processing.");
        // Chapter 2
        return Megail.getVar();
    }
    public int CalculateStatsCarina (int endTime){
        // Chapter 1
        // Carina is introduced with a base value of 20
        Carina.Change(20, "Carina Base Value.");
        // +10 handling Stineford slavers.
        Carina.Change(10, "for handling Stineford slavers.");
        // +20 funding shrine renovation.
        if (invR1Shrine.isSelected()) Carina.Change(20, "for funding shrine renovation.");
        // +5 funding Rebel's Pass bridge repair (Chapter 1 or early Chapter 2)
        if (invR1Bridge.isSelected()) Carina.Change(5, "for funding Rebel's Pass bridge repair");
        // Chapter 2
        return Carina.getVar();
    }
    public int CalculateStatsJanine (int endTime){
        // Chapter 1
        // Janine is introduced with a base value of 50
        Janine.Change(50, "Janine Base Value.");
        // +5 for being especially thorough in the investigation prior to talking to Trin in the Outskirts.
        Janine.Change(5, "for being especially thorough in the investigation prior to talking to Trin in the Outskirts.");
        // +10 for investing in Anti-corruption campaign.
        if (invR1Corruption.isSelected()) Janine.Change(10, "for investing in Anti-corruption campaign.");
        // +5 for investing in Bridge Repair (pre-reunion).
        if (invR1Bridge.isSelected()) Janine.Change(5, "for investing in Bridge Repair (pre-reunion).");
        // +5 for investing in Yhilini Public Works (chapter 1 or post-reunion).
        if (invR1Public.isSelected()) Janine.Change(5, "for investing in Yhilini Public Works (chapter 1 or post-reunion).");
        // +5 for NOT talking to her about her husband by the start of Chapter 2.
        Janine.Change(5, "for NOT talking to her about her husband by the start of Chapter 2.");
        // Chapter 2
        return Janine.getVar();
    }
    public int CalculateStatsSarai (int endTime){
        // Chapter 1
        // Sarai is introduced with a base value of 40
        Sarai.Change(50, "Sarai Base Value.");
        // +5 for investing in Anti-corruption campaign.
        if (invR1Corruption.isSelected()) Sarai.Change(10, "for investing in Anti-corruption campaign.");
        // -5 for investing in Shrine renovation.
        if (invR1Shrine.isSelected()) Sarai.Change(-5, "for funding shrine renovation.");
        // Chapter 2
        return Sarai.getVar();
    }
    public int CalculateStatsTrin (int endTime){
        // Chapter 1
        // Trin is introduced with a base value of 10
        Trin.Change(10, "Trin Base Value.");
        // +5 for copying the Yhilin Bank employee.
        if (cb6CopyBank.isSelected()) Trin.Change(5, "for copying the Yhilin Bank employee.");
        // Chapter 2
        return Trin.getVar();
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnC1Aka;
    private javax.swing.JRadioButton btnC1Qum;
    private javax.swing.JRadioButton btnC1Yarra;
    private javax.swing.ButtonGroup btnGroupC1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cb5ProNCon;
    private javax.swing.JCheckBox cb6CopyBank;
    private javax.swing.JCheckBox cbC2BunnyAfter;
    private javax.swing.JCheckBox cbC2BunnyBefore;
    private javax.swing.JCheckBox cbC2Exotic;
    private javax.swing.JCheckBox cbC2HighClass;
    private javax.swing.JCheckBox cbC2YhiliniBastard;
    private javax.swing.JCheckBox cbC2Zirantian;
    private javax.swing.JCheckBox cbC3Whored;
    private javax.swing.JCheckBox cbR1TakeFunds;
    private GUI.Investment invR1AriGarda;
    private GUI.Investment invR1ArmsDealer;
    private GUI.Investment invR1Bank;
    private GUI.Investment invR1Bridge;
    private GUI.Investment invR1Cache;
    private GUI.Investment invR1Corruption;
    private GUI.Investment invR1DustyHorde;
    private GUI.Investment invR1IronCudgel;
    private GUI.Investment invR1Magicshop;
    private GUI.Investment invR1Mine;
    private GUI.Investment invR1Public;
    private GUI.Investment invR1Shrine;
    private GUI.Investment invR1Steel;
    private GUI.Investment invR1Supplier;
    private javax.swing.JComboBox<String> jComboBoxProNCon;
    private javax.swing.JList<String> jListVars;
    private javax.swing.JList<String> jListVarsHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneDetails;
    private javax.swing.JScrollPane jScrollPaneIntro;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JScrollPane jScrollPaneVars;
    private javax.swing.JScrollPane jScrollPaneVarsHeader;
    private javax.swing.JLabel labelChoice1;
    private javax.swing.JLabel labelChoice2;
    private javax.swing.JLabel labelChoice3;
    private javax.swing.JLabel labelChoice4;
    private javax.swing.JLabel labelChoice5;
    private javax.swing.JLabel labelChoice6;
    private javax.swing.JLabel labelChp1;
    private javax.swing.JLabel labelChp1Invest;
    private javax.swing.JLabel labelCopyCount;
    private javax.swing.JLabel labelCost;
    private javax.swing.JLabel labelProNR1;
    private javax.swing.JLabel labelROI;
    private javax.swing.JTextArea txtDetails;
    private javax.swing.JTextArea txtIntro;
    // End of variables declaration//GEN-END:variables
}

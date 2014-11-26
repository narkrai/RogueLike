package view;

import controller.Game;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.IStrategy;
import model.OptionData;

/**
 * Frame Option qui va afficher et mettre à jour OptionData en fonction des choix de l'utilisateur.
 * @author : Nicolas Nguyen
 */
public class IHM_Options  extends JFrame{

    OptionData op = OptionData.getInstance();           // On récupère l'OptionData
    // Pseudo
    private     JTextField          pTextField;
    // Strategy
    private     JComboBox<String>   strategyComboBox;
    // Depth
    private     JSlider             dSlider;
    private     JTextField          dTextField;
    // Max Door
    private     JSlider             maxDSlider;
    private     JTextField          maxDTextField;
    // X
    private     JSlider             xSlider;
    private     JTextField          xTextField;
    // Y
    private     JSlider             ySlider;
    private     JTextField          yTextField;
    
    /**
     * Constructeur de la framme Option
     */
    
    public IHM_Options(){
        this.setTitle("Option");
        this.setSize(300,300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        // Panel principal
        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        
        // Panel Option
        JPanel panOption = new JPanel();
        panOption.setLayout(new GridLayout(3,2, 10, 10));
        Border b = BorderFactory.createEmptyBorder(5,5,5,5);
        panOption.setBorder(b);

        // Panel pour le pseudo
        JPanel pseudoPan = new JPanel();
        pseudoPan.setLayout(new GridLayout(2,0));
        JLabel pLabel = new JLabel("Pseudo : ");
        pTextField = new JTextField(op.getPlayerName());
        pseudoPan.add(pLabel);
        pseudoPan.add(pTextField);
        panOption.add(pseudoPan);
        
        // Panel pour la stratégie, POS 2 dans panOption
        JPanel stratPan = new JPanel();
        stratPan.setLayout(new GridLayout(2,0));
        JLabel sLabel = new JLabel("Strategy : ");
        strategyComboBox = new JComboBox<String>();
        for (Object s : op.getListStrategy()) {
            strategyComboBox.addItem(s.toString());
        }
        
        stratPan.add(sLabel);
        stratPan.add(strategyComboBox);
        panOption.add(stratPan);
        
        // Panel pour la profondeur, POS 3 dans panOption
        JPanel dPan = new JPanel();
        dPan.setLayout(new GridLayout(3,0));
        JLabel dSliderLabel = new JLabel("Max depth");
        dSlider = new JSlider(0,5);
        dSlider.setValue(op.getDepthmax());
        dTextField = new JTextField(Integer.toString(op.getDepthmax()));
        dTextField.setEditable(false);
        dSlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        dTextField.setText(Integer.toString(dSlider.getValue()));
                                }
                        });
        dPan.add(dSliderLabel);
        dPan.add(dSlider);
        dPan.add(dTextField);
        panOption.add(dPan);
        
        // Panel pour doorMax, POS 4 dans panOption
        
        JPanel maxDPan = new JPanel();
        maxDPan.setLayout(new GridLayout(3,0));
        JLabel maxDSliderLabel = new JLabel("Max door per room");
        maxDSlider = new JSlider(1,5);
        maxDSlider.setValue(op.getDepthmax());
        maxDTextField = new JTextField(Integer.toString(op.getDepthmax()));
        maxDTextField.setEditable(false);
        maxDSlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        maxDTextField.setText(Integer.toString(maxDSlider.getValue()));
                                }
                        });
        maxDPan.add(maxDSliderLabel);
        maxDPan.add(maxDSlider);
        maxDPan.add(maxDTextField);
        panOption.add(maxDPan);
        
        // Panel pour le x, POS 5 dans panOption
        JPanel xPan = new JPanel();
        xPan.setLayout(new GridLayout(3,0));
        JLabel xSliderLabel = new JLabel("Max number of rows");
        xSlider = new JSlider(2,10);
        xSlider.setValue(op.getTailleXRoom());
        xTextField = new JTextField(Integer.toString(op.getTailleXRoom()));
        xTextField.setEditable(false);
        xSlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        xTextField.setText(Integer.toString(xSlider.getValue()));
                                }
                        });
        xPan.add(xSliderLabel);
        xPan.add(xSlider);
        xPan.add(xTextField);
        panOption.add(xPan);
        
        // Panel pour le y, POS 6 dans panOption
        JPanel yPan = new JPanel();
        yPan.setLayout(new GridLayout(3,0));
        JLabel ySliderLabel = new JLabel("Max number of lines");
        ySlider = new JSlider(2,10);
        ySlider.setValue(op.getTailleYRoom());
        yTextField = new JTextField(Integer.toString(op.getTailleYRoom()));
        yTextField.setEditable(false);
        yTextField.setOpaque(false);
        yTextField.setBackground( null );
        ySlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        yTextField.setText(Integer.toString(ySlider.getValue()));
                                }
                        });
        yPan.add(ySliderLabel);
        yPan.add(ySlider);
        yPan.add(yTextField);
        panOption.add(yPan);
        
        // Ajout du panOption sur le panel de la frame, au CENTRE
        this.add(panOption, BorderLayout.CENTER);
        
        // Panel bouton, dans le south du panel principal
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bSave = new JButton("Save");
        JButton bClose = new JButton("Cancel");
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = new Insets(10,10,10,10);
        c1.gridx = 0;
        c1.gridy = 0;
        pButton.add(bSave,c1);
        c1.gridx = 1;
        c1.gridy = 0;
        pButton.add(bClose,c1);
        bSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                changeOptions();
                setVisible(false);
                IHM_Board.getInstance().refresh();
                IHM_Recap.getInstance().refresh();
            }
        });      
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                cancelOption();
                setVisible(false);
            }
        });
        this.add(pButton, BorderLayout.SOUTH); 
    }
    
    /**
     * Methode appelée lorsque l'utilisateur appuie sur le bouton OK
     * Va mettre à jour l'OptionData et ferme la fenêtre
     */
    public void changeOptions() { 
        op.setPlayerName(pTextField.getText());
        op.setStrategy(op.getListStrategy().get(strategyComboBox.getSelectedIndex()));
        op.setDepthmax(dSlider.getValue());
        op.setDoormax(maxDSlider.getValue());
        op.setTailleXRoom(xSlider.getValue());
        op.setTailleYRoom(ySlider.getValue());
        Game.getInstance().restart();
        IHM_Controls.getInstance().setPlayable(true);
    }
    
    /**
     * Methode appelée lorsque l'utilisateur appuie sur le bouton CANCEL
     * Refresh les valeurs avec celles de l'OptionData, pour remettre les anciennes valeurs. Ferme ensuite la fenêtre
     */
    public void cancelOption() { 
        refreshValue();
    }
    
    /**
     * Methode qui va refresh les values avec ceux dans OptionData
     */
    public void refreshValue() {
        strategyComboBox.setSelectedItem(op.getStrategy());
        pTextField.setText(op.getPlayerName());
        maxDSlider.setValue(op.getDoormax());
        maxDTextField.setText(Integer.toString(op.getDoormax()));
        dSlider.setValue(op.getDepthmax());
        dTextField.setText(Integer.toString(op.getDepthmax()));
        xSlider.setValue(op.getTailleXRoom());
        xTextField.setText(Integer.toString(op.getTailleXRoom()));
        ySlider.setValue(op.getTailleYRoom());
        yTextField.setText(Integer.toString(op.getTailleYRoom()));
    }
    

}

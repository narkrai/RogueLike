package view;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.OptionData;

public class IHM_Options  extends JFrame{

    OptionData op = OptionData.getDataInstance();
    
    
    private JPanel pan = null;
    private JPanel panOption = null;
    // Strategy
    private JLabel sLabel =null;
    private JComboBox<String> strategyComboBox = null;
    // Depth
    private JLabel dSliderLabel = null;
    private JSlider dSlider = null;
    private JTextField dTextField = null;
    // X
    private JLabel xSliderLabel = null;
    private JSlider xSlider = null;
    private JTextField xTextField = null;
    // Y
    private JLabel ySliderLabel = null;
    private JSlider ySlider = null;
    private JTextField yTextField = null;
    
    public IHM_Options(){
        this.setTitle("Option");
        this.setSize(300,240);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        // Panel principal
        pan = new JPanel();
        pan.setLayout(new BorderLayout());
        
        
        // Panel Option
        panOption = new JPanel();
        panOption.setLayout(new GridLayout(2,2, 10, 10));
        Border b = BorderFactory.createEmptyBorder(5,5,5,5);
        panOption.setBorder(b);

        
        // Panel pour la stratégie, POS 1 dans panOption
        
        JPanel stratPan = new JPanel();
        stratPan.setLayout(new GridLayout(2,0));
        sLabel = new JLabel("Strategy : ");
        strategyComboBox = new JComboBox<String>();
        strategyComboBox.addItem("Idiot");
        strategyComboBox.addItem("Nice");
        stratPan.add(sLabel);
        stratPan.add(strategyComboBox);
        panOption.add(stratPan);
        
        // Panel pour la profondeur, POS 2 dans panOption
        JPanel dPan = new JPanel();
        dPan.setLayout(new GridLayout(3,0));
        dSliderLabel = new JLabel("Max depth");
        dSlider = new JSlider(0,10);
        dTextField = new JTextField("5");
        dSlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        dTextField.setText(Integer.toString(dSlider.getValue()));
                                }
                        });
        dTextField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        String typed = dTextField.getText();
                        dSlider.setValue(0);
                        if(!typed.matches("\\d+") || typed.length() > 3) {
                            return;
                        }
                        int value = Integer.parseInt(typed);
                        dSlider.setValue(value);
                    }
                });
        dPan.add(dSliderLabel);
        dPan.add(dSlider);
        dPan.add(dTextField);
        panOption.add(dPan);
        
        // Panel pour le x, POS 3 dans panOption
        JPanel xPan = new JPanel();
        xPan.setLayout(new GridLayout(3,0));
        xSliderLabel = new JLabel("Max number of rows");
        xSlider = new JSlider(0,20);
        xTextField = new JTextField("10");
        xSlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        xTextField.setText(Integer.toString(xSlider.getValue()));
                                }
                        });
        xTextField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        String typed = xTextField.getText();
                        xSlider.setValue(0);
                        if(!typed.matches("\\d+") || typed.length() > 3) {
                            return;
                        }
                        int value = Integer.parseInt(typed);
                        xSlider.setValue(value);
                    }
                });
        xPan.add(xSliderLabel);
        xPan.add(xSlider);
        xPan.add(xTextField);
        panOption.add(xPan);
        
        // Panel pour le y, POS 4 dans panOption
        JPanel yPan = new JPanel();
        yPan.setLayout(new GridLayout(3,0));
        ySliderLabel = new JLabel("Max number of lines");
        ySlider = new JSlider(0,20);
        yTextField = new JTextField("10");
        ySlider.addChangeListener(new ChangeListener() {
                                @Override
                                public void stateChanged(ChangeEvent e) {
                                        yTextField.setText(Integer.toString(ySlider.getValue()));
                                }
                        });
        yTextField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyReleased(KeyEvent ke) {
                        /**
                         * @TODO : ne pas autoriser le -
                         */
                        String typed = yTextField.getText();
                        ySlider.setValue(0);
                        if(!typed.matches("\\d+") || typed.length() > 3) {
                            return;
                        }
                        int value = Integer.parseInt(typed);
                        ySlider.setValue(value);
                    }
                });
        yPan.add(ySliderLabel);
        yPan.add(ySlider);
        yPan.add(yTextField);
        panOption.add(yPan);
        
        this.add(panOption, BorderLayout.CENTER);
        
        // Panel bouton, dans le south du panel principal
        JPanel pButton = new JPanel(new GridBagLayout());
        JButton bSave = new JButton("Save");
        JButton bClose = new JButton("Close");
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
                /**
                 * @TODO : REFRESH
                 */
            }
        });      
        bClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                /**
                 * @TODO : REMETTRE LES VALUE
                 */
                setVisible(false);
            }
        });
        this.add(pButton, BorderLayout.SOUTH); 
        
    
    }

    public void CngeOption() {
    }
}

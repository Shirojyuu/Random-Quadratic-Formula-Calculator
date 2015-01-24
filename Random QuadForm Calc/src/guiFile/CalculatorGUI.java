/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiFile;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import random.quadform.calc.FormulaGuts;
import static random.quadform.calc.FormulaGuts.QuadraticFormula;

/**
 *
 * @author Owner
 */
public class CalculatorGUI
{
    private JFrame window;
    private Insets marginInsets;
    private JPanel workspace;
    private JPanel calcSpace;
    private JLabel answer;
    
    private JLabel aLabel;
    private JLabel bLabel;
    private JLabel cLabel;
    private JEditorPane aField;
    private JEditorPane bField;
    private JEditorPane cField;
    private JButton calculateButton;
    public static double[] returnedArray = new double[2];
    public CalculatorGUI()
    {
        
    }
    public void startUI()
    {
        // SETUP THE WINDOW
        initWindow();
        
        // SETUP THE FIRST GUI SCREEN
        initCalculator();
        
        // AND OPEN THE WINDOW
        window.setVisible(true);
    }
    
    private void initWindow()
    {
        window = new JFrame();
        window.setBounds(0, 0, 640, 320);
        
         // ASK THE EVENT HANDLER TO PROVIDE A RESPONSE WHEN THE
        // USER CLICKS THE WINDOW'S TOP-RIGHT 'X'
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initCalculator()
    {
        marginInsets = new Insets(0,0,0,0);
        workspace = new JPanel();
        calcSpace = new JPanel();
        answer = new JLabel();
        
        aField = new JEditorPane();
        bField = new JEditorPane();
        cField = new JEditorPane();
        
        aLabel = new JLabel("a:");
        bLabel = new JLabel("b:");
        cLabel = new JLabel("c:");
        
        calculateButton = new JButton();
        calculateButton.setMargin(marginInsets);
        calculateButton.setText("Calculate!");
        calculateButton.addActionListener(
        new ActionListener()
            {@Override
             public void actionPerformed(ActionEvent ae)
                {
                   if(aField.getText().equals(""))
                   {
                       aField.setText("0");
                   }
                   
                   if(bField.getText().equals(""))
                   {
                       bField.setText("0");
                   }
                                      
                   if(cField.getText().equals(""))
                   {
                       cField.setText("0");
                   }
                    returnedArray = FormulaGuts.QuadraticFormula(Double.parseDouble(aField.getText()),
                            Double.parseDouble(bField.getText()), Double.parseDouble(cField.getText()));
                    
                    update("Roots: " + returnedArray[0] + " , " + returnedArray[1]);
                }
            });
        
        workspace.add(aLabel);
        workspace.add(aField);
        workspace.add(bLabel);
        workspace.add(bField);
        workspace.add(cLabel);
        workspace.add(cField);
        
        calcSpace.add(calculateButton);
        calcSpace.add(answer);
        window.add(workspace, BorderLayout.NORTH);
        window.add(calcSpace, BorderLayout.SOUTH);
    }
    
    public void update(Object args)
    {
        if(args instanceof String)
        {
            answer.setText((String)args);
        }
    }
}

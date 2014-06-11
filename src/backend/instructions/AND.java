/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.instructions;

import backend.ScanFile;
import frontend.FrontEnd;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author NIkhil
 */
public class AND implements InsInterface4
{
    static Integer no, no2, no3;
    static int operand_2;

    @Override
    public void execute(String ins, String token2, String token3, String token4)
      {
        

      

        no = backend.Register.convertRegister(token2);
          no2 = backend.Register.convertRegister(token3);
            int modified = checkmod.modify(ins, token4);
        if (no > -1)
        {

          
           if(no2>-1)
           {

                try
                {
                    backend.StepRun.callbbeq = false;
                    backend.Register.r[no].b = backend.Register.r[no2].b & modified;
                } catch (Exception e)
                {
                    FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR(" +ScanFile.current_line+ ")" + "Failed To Execute AND Instruction" + "\n",Color.RED);
//                    frontend.FrontEnd.statuswindow.append("ERROR in line " + backend.ScanFile.current_line + ":" + "AND operation failed");
                    //frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                }

            } 
        else 
            {
               // FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR(" + ScanFile.current_line + ")" + "Invalid Destination Register" + token2 + "\n",Color.RED);
//                frontend.FrontEnd.statuswindow.append("ERROR in line " + backend.ScanFile.current_line + ":" + "The destination operand of AND should be a register and " + token2 + " isnot a valid register.");
                //frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
               FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR(" +ScanFile.current_line+ ")" + " Invalid Ist Source Register For AND Instruction\n",Color.RED);
            }

        
      }
        else 
          {
            FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR(" + backend.ScanFile.current_line + "): Invalid Destination Register For AND Instruction  \n",Color.RED);

          }
}
}
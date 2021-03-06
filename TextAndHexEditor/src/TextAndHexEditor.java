
import java.awt.print.PrinterException;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

/* Create global variable */


/**
 *
 * @author Akshay
 */
public class TextAndHexEditor extends javax.swing.JFrame {
    
    String programName = "Textditor";
    String filename = "";
    String holdText;
    String fn;
    String dir;
    String fileName;
    boolean textChanged = false;
    Clipboard clip = getToolkit().getSystemClipboard();
    int fontSize = 14;
    UndoManager undo = new UndoManager();
    /**
     * Creates new form TextAndHexEditor
     */
    public TextAndHexEditor() {
        initComponents();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        dialogColor = new javax.swing.JDialog();
        colorChooser = new javax.swing.JColorChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        saveasMenu = new javax.swing.JMenuItem();
        printMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        color = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        fontInc = new javax.swing.JMenuItem();
        fontDec = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dialogColorLayout = new javax.swing.GroupLayout(dialogColor.getContentPane());
        dialogColor.getContentPane().setLayout(dialogColorLayout);
        dialogColorLayout.setHorizontalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogColorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dialogColorLayout.setVerticalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        jMenu3.setText("File");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        newMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenu.setText("New");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        jMenu3.add(newMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText("Open");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu3.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setText("Save");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu3.add(saveMenu);

        saveasMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveasMenu.setText("Save As...");
        saveasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveasMenuActionPerformed(evt);
            }
        });
        jMenu3.add(saveasMenu);

        printMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        printMenu.setText("Print");
        printMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMenuActionPerformed(evt);
            }
        });
        jMenu3.add(printMenu);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu3.add(exitMenu);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cut");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Copy");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Paste");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Undo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Redo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        color.setText("Text color");
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });
        jMenu4.add(color);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("Format");

        fontInc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, java.awt.event.InputEvent.CTRL_MASK));
        fontInc.setText("fontsize ++");
        fontInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontIncActionPerformed(evt);
            }
        });
        jMenu1.add(fontInc);

        fontDec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, java.awt.event.InputEvent.CTRL_MASK));
        fontDec.setText("fontsize --");
        fontDec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontDecActionPerformed(evt);
            }
        });
        jMenu1.add(fontDec);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        // TODO add your handling code here:
         newFile();
    }//GEN-LAST:event_newMenuActionPerformed

    private void printMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMenuActionPerformed
        // TODO add your handling code here:
        try {
            textArea.print();
        } 
        catch (PrinterException e) {
            System.err.format("NO PRINTER FOUND",e.getMessage());
        }
    }//GEN-LAST:event_printMenuActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        // TODO add your handling code here:
        if(filename.equals(""))
            saveAs();
        else
            save(filename);
    }//GEN-LAST:event_saveMenuActionPerformed

    private void saveasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveasMenuActionPerformed
        // TODO add your handling code here:
        saveAs();
    }//GEN-LAST:event_saveasMenuActionPerformed

    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        // TODO add your handling code here:
        if(textArea.getText().length() < 1){
        FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
        fd.show();
        if (fd.getFile() != null) {
            fileName = fd.getDirectory() + fd.getFile();
            setTitle(fileName);
            try {
                checkFile();
            } catch (IOException ex) {
                Logger.getLogger(TextAndHexEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        textArea.requestFocus();
     }
     else if(!textChanged){
        FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
        fd.show();
        if (fd.getFile() != null) {
            fileName = fd.getDirectory() + fd.getFile();
            setTitle(fileName);
            try {
                checkFile();
            } catch (IOException ex) {
                Logger.getLogger(TextAndHexEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        textArea.requestFocus();
     }
     else{
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save befor exiting this program?", "Notepad",JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm==JOptionPane.YES_OPTION)
            {
                if("".equals(filename)){
                saveAs();
                }
                else{
                    save(filename);
                }
            FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
            fd.show();
            if (fd.getFile() != null) {
                fileName = fd.getDirectory() + fd.getFile();
                setTitle(fileName);
                    try {
                        checkFile();
                    } catch (IOException ex) {
                        Logger.getLogger(TextAndHexEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            textArea.requestFocus();

            }
            else if(confirm == JOptionPane.NO_OPTION){
                FileDialog fd = new FileDialog(this, "Choose File", FileDialog.LOAD);
                fd.show();
                if (fd.getFile() != null) {
                    fileName = fd.getDirectory() + fd.getFile();
                    setTitle(fileName);
                    try {
                        checkFile();
                    } catch (IOException ex) {
                        Logger.getLogger(TextAndHexEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                textArea.requestFocus();
            }

        }

    }//GEN-LAST:event_openMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        
    if("".equals(textArea.getText())){
        System.exit(0);
    }
    else if(!textChanged){
        System.exit(0);
    }
    else{
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to save befor exiting this program?");
        if (confirm==JOptionPane.YES_OPTION){
            if(filename.equals(""))
                saveAs();
            else
                save(filename);
        }
        if (confirm==JOptionPane.NO_OPTION)
        {
            System.exit(0);
        }
        
    }//GEN-LAST:event_exitMenuActionPerformed
}
    private void fontIncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontIncActionPerformed
        // TODO add your handling code here:
        textArea.setFont(new java.awt.Font("Monospaced", 0, ++fontSize));
    }//GEN-LAST:event_fontIncActionPerformed

    private void fontDecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontDecActionPerformed
        // TODO add your handling code here:
        textArea.setFont(new java.awt.Font("Monospaced", 0, --fontSize));
    }//GEN-LAST:event_fontDecActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        textArea.cut();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        textArea.copy();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        textArea.paste();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            undo.undo();
        } catch (CannotRedoException cre) {
            cre.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undo.addEdit(e.getEdit());
                }
});
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         if("".equals(textArea.getText())){
        System.exit(0);
    }
    else if(!textChanged){
        System.exit(0);
    }
    else{
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to save befor exiting this program?");
        if (confirm==JOptionPane.YES_OPTION){
            if(filename.equals(""))
                saveAs();
            else
                save(filename);
        }
        if (confirm==JOptionPane.NO_OPTION)
        {
            System.exit(0);
        }
    }
    }//GEN-LAST:event_formWindowClosing

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
        Color c = colorChooser.showDialog(null, "Color Dialog", textArea.getForeground());
        textArea.setForeground(c);
    }//GEN-LAST:event_colorActionPerformed
    
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
            java.util.logging.Logger.getLogger(TextAndHexEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextAndHexEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextAndHexEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextAndHexEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TextAndHexEditor().setVisible(true);
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem color;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JDialog dialogColor;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem fontDec;
    private javax.swing.JMenuItem fontInc;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JMenuItem printMenu;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JMenuItem saveasMenu;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
private void save(String fn){
        setTitle(programName+" "+filename);
        try
        {
            FileWriter out;
            out = new FileWriter(fn);
            out.write(textArea.getText());
            out.close();
        }
        catch(Exception err)
        {
            System.out.println("Error: " + err);
        }
        textChanged=false;
        saveMenu.setEnabled(false);

    }

    //function sava as
    private void saveAs() {
        FileDialog fd = new FileDialog(TextAndHexEditor.this, "Save", FileDialog.SAVE);
        fd.show();
        if (fd.getFile() != null) {

            fn=fd.getFile();
            dir=fd.getDirectory();
            filename = dir + fn +".txt";

            setTitle(filename);
            try
            {
                DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                holdText = textArea.getText();
                BufferedReader br = new BufferedReader(new StringReader(holdText));
                while ((holdText = br.readLine()) != null)
                {
                    d.writeBytes(holdText + "\r\n");
                    d.close();
                }
            }
            catch (Exception e)
            {
                System.out.println("File note found");
            }
            textArea.requestFocus();
            save(filename);
        }
    }

    private void newFile() {

        if(textArea.getText().length() < 1){
            setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged=false;
        }
        else if(!textChanged){
            setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged=false;
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to save befor exiting this program?", "Notepad",JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm==JOptionPane.YES_OPTION)
            {
                if("".equals(filename)){
                saveAs();
                }
                else{
                    save(filename);
                }
                setTitle(programName);
                filename="";
                textArea.setText("");
                textChanged=false;

            }
            else if(confirm == JOptionPane.NO_OPTION){
                setTitle(programName);
                textArea.setText("");
                textChanged=false;
            }
            /*setTitle("Untitled-"+programName);
            textArea.setText("");
            textChanged=false; */
        }
    }
    public void checkFile() throws IOException {
        BufferedReader read;
        StringBuffer sb = new StringBuffer();
        try {
            read = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = read.readLine()) != null) {
                sb.append(line + "\n");
            }
            textArea.setText(sb.toString());
            read.close();
        } catch(FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch(IOException ioe) {
            
        }
    }
}

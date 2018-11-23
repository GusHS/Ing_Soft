import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComponent;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Vector;


public class ReadsGUI extends JFrame implements ActionListener, ListSelectionListener{
    private JPanel panel1,panelDatos;
    private JLabel lImg;
    private JTextArea taReads;
    private JButton bLeer;
    private ContentGUI cont;
    private JList lContenido;
    private Vector vectorContenido;
    private GUI core;
    private LecturasAD lecturasAD;
    String lecturaElegida="";


    public ReadsGUI(LecturasAD lect){
        super("Contenidos");
        bLeer  = new JButton("Leer");
        panel1 = new JPanel();
        panelDatos = new JPanel();
        lecturasAD = lect;
		
		bLeer.addActionListener(this);
        panel1.setLayout(new FlowLayout());

        lContenido = new JList<>();
        lContenido.addListSelectionListener(this);

        panelDatos.add(lContenido);
        panel1.add(panelDatos);
        panel1.add(bLeer);
    }
    public void setContenido(){
        lContenido = new JList<>(lecturasAD.getContenido());
        lContenido.addListSelectionListener(this);
        panelDatos.add(lContenido);
        panel1.setVisible(false);
        panel1.removeAll();
        panel1.add(panelDatos);
        panel1.add(bLeer);
        panel1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
    	String user="";
    	
    	if(e.getSource() == bLeer){
    		setVisible(false);
    		setSize(600,700);
            remove(panel1);
            System.out.println("COT: " + lecturasAD.getListaContenido().size());
            try {
                cont = new ContentGUI(lecturasAD.getListaContenido(),lecturaElegida);
    		    panel1 = cont.getPanel();
            } catch (Exception ex) {
                System.out.println("Exception " +ex);
            }
    		add(panel1);
        	setVisible(true);
    	}
    }
    public void valueChanged(ListSelectionEvent lse){
        if (lse.getValueIsAdjusting() == true) {
            if (lse.getSource()== lContenido) {
                lecturaElegida = (String)lContenido.getSelectedValue().toString();
                System.out.println("COT: "+lecturaElegida);
            }
        }
    }
    
    public JPanel getPanel(){
    	return panel1;
    }
    
}
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class ContentGUI extends JFrame implements ActionListener{
    private JPanel panel1, panel2, panel3, panel4, panel5, pImg;
    private JLabel lImg, lTit;
    private JTextArea taCont;
    private JButton bDown;
    private ContenidoDP content;
    private Boolean leido = false;
    
    public ContentGUI(LinkedList<ContenidoDP> listaContenido, String titulo){
        super("Lectura");
        for (int i = 0; i < listaContenido.size(); i++) {
            if ((((ContenidoDP)listaContenido.get(i)).getTitulo()).equals(titulo)) {
                System.out.println("CONTROL TI: " +(((ContenidoDP)listaContenido.get(i)).getTitulo()));
                System.out.println("CONTROL TITLE: "+titulo);
                content = (ContenidoDP)listaContenido.get(i);
            }
        }
        lTit   = new JLabel(content.getTitulo());
        taCont = new JTextArea(40,40);
        taCont.setLineWrap(true);
        taCont.setText(content.getTexto());
        taCont.setEditable(false);
        bDown  = new JButton("Descargar");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		pImg   = new JPanel();
		
		bDown.addActionListener(this);
		
		panel1.setLayout(new GridLayout(2,1));
		panel3.setLayout(new GridLayout(2,1));
		panel2.setLayout(new FlowLayout());
		panel5.setLayout(new FlowLayout());
		panel4.setLayout(new BorderLayout());
		
		pImg.add(new JLabel(content.getImage()));
		panel1.add(new JScrollPane(taCont));
		panel1.add(pImg);
        
        
        panel2.add(bDown);
        
        panel3.add(panel1);
        
        panel3.add(panel2);
        
        lTit.setFont(new Font("Serif", Font.BOLD, 26));
        
        panel5.add(lTit);
        
        panel4.add(panel5, BorderLayout.NORTH);
        panel4.add(panel3, BorderLayout.CENTER);
    }
    
    public void actionPerformed(ActionEvent e){
    	String user="";
    	
    	if(e.getSource() == bDown){
            if (leido == false) {
                content.setDescargas(content.addDescarga());
            }
            JOptionPane.showMessageDialog(null, "Descarga Exitosa");
            JOptionPane.showMessageDialog(null, "Numero de Descargas: "+ content.getDescargas());
            leido = true;
    	}
    }
    
    public JPanel getPanel(){
    	return panel4;
    }
    
    public static void main(String args[]){
    }
}
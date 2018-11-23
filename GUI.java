import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener {
    public LecturasAD lecturasAD = new LecturasAD();
    private ReadsGUI   reads;

    private JTextField tfUser;
    private JPasswordField jFPass;
    private JButton    bLogin;
    private JPanel     panel1, panel2, panel3;
    
    public GUI(){
        super("Prototipo");
		tfUser = new JTextField(12);
        jFPass = new JPasswordField(12);
		bLogin = new JButton("Login");
		panel1 = new JPanel();
		panel2 = new JPanel();
        panel3 = new JPanel();

        reads = new ReadsGUI(lecturasAD);
        
        jFPass.setEchoChar('*');
		bLogin.addActionListener(this);
		
		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new GridLayout(2,1));
		
		panel1.add(new JLabel("Usuario: "));
        panel1.add(tfUser);
        panel1.add(new JLabel("Password: "));
        panel1.add(jFPass);
        
        panel2.add(panel1);
        panel2.add(bLogin);
        
        panel3.add(panel2);
        
        add(panel3);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == bLogin){
            String respuesta="";
            respuesta = lecturasAD.verificarCredenciales(tfUser.getText(), new String(jFPass.getPassword()));
            if (respuesta.equals("VALIDADO")) {
                setVisible(false);
                remove(panel3);
                reads.setContenido();
                panel3 = reads.getPanel();
                add(panel3);
                setSize(600,400);
                setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "ERROR: "+ respuesta);
            }
    	}
    }
    public LecturasAD getLecturasAD(){
        return this.lecturasAD;
    }
    public static void main(String args[]){
        new GUI();
    }
}
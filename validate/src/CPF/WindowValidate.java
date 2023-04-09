package CPF;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class WindowValidate extends JFrame {

	public WindowValidate() {
		
		setSize(856, 480);
		setTitle("Validar Number");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		Font fontMain = new Font("Serif", Font.PLAIN, 24);
		
		JLabel titulo = new JLabel("Por Favor Digite Um CPF:");
		titulo.setFont(fontMain);
		titulo.setLocation(50,50);
		titulo.setSize(350, 50);
		
		JFormattedTextField caixaDeEntrada = new JFormattedTextField(Mascara("###.###.###-##"));
		caixaDeEntrada.setFont(fontMain);
		caixaDeEntrada.setLocation(400, 50);
		caixaDeEntrada.setSize(250, 50);
		
		JLabel label = new JLabel("Seu Resultado");
		label.setFont(fontMain);
		label.setLocation(400, 110);
		label.setSize(250, 50);
		
		JButton btnVerificarCPF = new JButton("verirficar CPF");
		btnVerificarCPF.setLocation(50, 110);
		btnVerificarCPF.setSize(330,50);
		btnVerificarCPF.addActionListener((ae) -> {
			boolean res =  ControllerValidateCPF.isValideCPF(caixaDeEntrada.getText());
			label.setText(res ? "Cpf valido" : "Cpf invalido");
			
		});
		
		add(titulo);
		add(caixaDeEntrada);
		add(label);
		add(btnVerificarCPF);
		
		
		JLabel tituloCNPJ = new JLabel("Por Favor Digite Um CNPJ:");
		tituloCNPJ.setFont(fontMain);
		tituloCNPJ.setLocation(50,200);
		tituloCNPJ.setSize(350, 50);
		
		JFormattedTextField caixaDeEntradaCNPJ = new JFormattedTextField(Mascara("##.###.###/####-##"));
		caixaDeEntradaCNPJ.setFont(fontMain);
		caixaDeEntradaCNPJ.setLocation(400, 200);
		caixaDeEntradaCNPJ.setSize(250, 50);
		
		JLabel labelCNPJ = new JLabel("Seu Resultado");
		labelCNPJ.setFont(fontMain);
		labelCNPJ.setLocation(400, 260);
		labelCNPJ.setSize(250, 50);
		
		JButton btnVerificarCNPJ = new JButton("verirficar CNPJ");
		btnVerificarCNPJ.setLocation(50, 260);
		btnVerificarCNPJ.setSize(330,50);
		btnVerificarCNPJ.addActionListener((ae) -> {
			boolean res =  ControllerValidateCNPJ.isValideCNPJ(caixaDeEntradaCNPJ.getText());
			labelCNPJ.setText(res ? "Cnpj valido" : "Cnpj invalido");
		});
		
		add(tituloCNPJ);
		add(caixaDeEntradaCNPJ);
		add(labelCNPJ);
		add(btnVerificarCNPJ);
		
	}
	
	public MaskFormatter Mascara(String Mascara){
	        
	        MaskFormatter F_Mascara = new MaskFormatter();
	        try{
	            F_Mascara.setMask(Mascara); //Atribui a mascara
	            //F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
	        }
	        catch (Exception excecao) {
	        excecao.printStackTrace();
	        } 
	        return F_Mascara;
	 } 
}

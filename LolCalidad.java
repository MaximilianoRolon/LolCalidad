import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
public class LolCalidad extends JFrame implements ActionListener {
	ImageIcon image = new ImageIcon("C:/Users/Javier/Desktop/lol-logo.png");
	
	String nombre;
	float vfarmtiempo,vfarm,vtiempojugado,vkill,vdeath,vassist,vkda,vjugador1,vkdacalidad=0,vfarmcalidad=0;
	JLabel jlabelnombre,jlabeltiempo,jlabelminions,jlabelkills,jlabelassists,jlabeldeaths,jlabelestadisticas,jlabelnombres,jlabelkda,jlabelfarm,jlabelestadisticas1,jlabelkda1,jlabelfarm1;
	JButton jbuttoncalcular;
	JTextField jtextfieldnombre,jtextfieldtiempo,jtextfieldminions,jtextfieldkills,jtextfieldassists,jtextfielddeaths,jtextfieldestadisticas;
	public LolCalidad(){
		setResizable(false);
		setTitle("Lol Calidad v0.3 - Closed Beta");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
/////////////////////////////////////////////////////////////////////////////////////////////NOMBRE
		jlabelnombre=new JLabel("Ingrese el nombre de invocador");
		jlabelnombre.setBounds(10,10,200,15);
		add(jlabelnombre);
		jtextfieldnombre=new JTextField("");
		jtextfieldnombre.setBounds(220,10,100,20);
		add(jtextfieldnombre);
/////////////////////////////////////////////////////////////////////////////////////////////TIEMPO		
		jlabeltiempo=new JLabel("Ingrese el tiempo jugado");
		jlabeltiempo.setBounds(10,40,200,15);
		add(jlabeltiempo);
		jtextfieldtiempo=new JTextField("");
		jtextfieldtiempo.setBounds(220,40,100,20);
		add(jtextfieldtiempo);
/////////////////////////////////////////////////////////////////////////////////////////////MINIONS
		jlabelminions=new JLabel("Ingrese la cantidad de minions");
		jlabelminions.setBounds(10,70,200,15);
		add(jlabelminions);
		jtextfieldminions=new JTextField("");
		jtextfieldminions.setBounds(220,70,100,20);
		add(jtextfieldminions);
/////////////////////////////////////////////////////////////////////////////////////////////KILLS
		jlabelkills=new JLabel("Ingrese la cantidad de kills");
		jlabelkills.setBounds(10,100,200,15);
		add(jlabelkills);
		jtextfieldkills=new JTextField("");
		jtextfieldkills.setBounds(220,100,100,20);
		add(jtextfieldkills);
/////////////////////////////////////////////////////////////////////////////////////////////ASSISTS		
		jlabelassists=new JLabel("Ingrese la cantidad de assists");
		jlabelassists.setBounds(10,160,200,15);
		add(jlabelassists);
		jtextfieldassists=new JTextField("");
		jtextfieldassists.setBounds(220,160,100,20);
		add(jtextfieldassists);
		setLayout(null);
/////////////////////////////////////////////////////////////////////////////////////////////DEATHS		
		jlabeldeaths=new JLabel("Ingrese la cantidad de deaths");
		jlabeldeaths.setBounds(10,130,200,15);
		add(jlabeldeaths);
		jtextfielddeaths=new JTextField("");
		jtextfielddeaths.setBounds(220,130,100,20);
		add(jtextfielddeaths);
/////////////////////////////////////////////////////////////////////////////////////////////ESTADISTICAS	
		jlabelnombres=new JLabel("");
		jlabelnombres.setBounds(10,200,200,15);
		add(jlabelnombres);
		jlabelfarm=new JLabel("Mi farmeo es:");
		jlabelfarm.setBounds(10,220,200,15);
		add(jlabelfarm);
		jlabelkda=new JLabel("Mi kda es:");
		jlabelkda.setBounds(10,240,200,15);
		add(jlabelkda);
		jlabelestadisticas=new JLabel("Del 1 al 10 mi puntuacion es:");
		jlabelestadisticas.setBounds(10,260,200,15);
		add(jlabelestadisticas);
		jlabelfarm1=new JLabel("");
		jlabelfarm1.setBounds(200,220,200,15);
		add(jlabelfarm1);
		jlabelkda1=new JLabel("");
		jlabelkda1.setBounds(200,240,200,15);
		add(jlabelkda1);
		jlabelestadisticas1=new JLabel("");
		jlabelestadisticas1.setBounds(200,260,200,15);
		add(jlabelestadisticas1);
/////////////////////////////////////////////////////////////////////////////////////////////CALCULAR
		jbuttoncalcular=new JButton ("CALCULAR");
		jbuttoncalcular.setBounds(340,15,250,160);
		add(jbuttoncalcular);
		jbuttoncalcular.addActionListener(this);
	}
	public void actionPerformed(ActionEvent tocar){
		if(tocar.getSource()==jbuttoncalcular){
			String nombre =jtextfieldnombre.getText();
			jlabelnombres.setText(nombre);
			String tiempo =jtextfieldtiempo.getText();
			int itiempo=Integer.parseInt(tiempo);
			String minions =jtextfieldminions.getText();
			int iminions=Integer.parseInt(minions);
			String kills =jtextfieldkills.getText();
			int ikills=Integer.parseInt(kills);
			String assists =jtextfieldassists.getText();
			int iassists=Integer.parseInt(assists);
			String deaths =jtextfielddeaths.getText();
			int ideaths=Integer.parseInt(deaths);
			vfarmtiempo=(iminions/itiempo);
			if(ideaths!=0){
				vkda=(float)((ikills+iassists)/ideaths);
			}else{
				vkda=(float)((ikills+iassists)/1);
			}
			String vkdas=String.valueOf(vkda);
/////////////////////////////////////////////////////////////////      CALCULO DE 
/////////////////////////////////////////////////////////////////       MINIONS
			if(vfarmtiempo<4){
				jlabelfarm1.setText("muy malo");
				vfarmcalidad=10/6;
			}
			if(vfarmtiempo>=4 && vfarmtiempo<5.3){
				jlabelfarm1.setText("malo");
				vfarmcalidad=10/3;
			}
			if(vfarmtiempo>=5.3 && vfarmtiempo<=6){
				jlabelfarm1.setText("normal");
				vfarmcalidad=5;
			}
			if(vfarmtiempo>6 && vfarmtiempo<=6.8){
				jlabelfarm1.setText("bueno");
				vfarmcalidad=40/6;
			}
			if(vfarmtiempo>6.8 && vfarmtiempo<=7.5){
				jlabelfarm1.setText("muy bueno");
				vfarmcalidad=50/6;
			}
			if(vfarmtiempo>7.5){
				jlabelfarm1.setText("excelente");
				vfarmcalidad=10;
			}
/////////////////////////////////////////////////////////////////      CALCULO DE 
/////////////////////////////////////////////////////////////////         KDA
			if(vkda<1.1){
				jlabelkda1.setText(vkdas+" y es muy malo");
				vkdacalidad=10/6;
			}
			if(vkda>=1.1 && vkda<2){
				jlabelkda1.setText(vkdas+" y es malo");
				vkdacalidad=10/3;
			}
			if(vkda>=2 && vkda<3){
				jlabelkda1.setText(vkdas+" y es normal");
				vkdacalidad=5;
			}
			if(vkda>=3 && vkda<4.5){
				jlabelkda1.setText(vkdas+" y es bueno");
				vkdacalidad=40/6;
			}
			if(vkda>=4.5 && vkda<7.5){
				jlabelkda1.setText(vkdas+" y es muy bueno");
				vkdacalidad=50/6;
			}
			if(vkda>7.5){
				jlabelkda1.setText(vkdas+" y es excelente");
				vkdacalidad=10;
			}
/////////////////////////////////////////////////////////////////      CALCULO DE 
/////////////////////////////////////////////////////////////////       JUGADOR
vjugador1=(float) (((vkdacalidad*0.65)+vfarmcalidad*0.35));
String vjugador=String.valueOf(vjugador1);
jlabelestadisticas1.setText(vjugador);
}
		}
	public static void main(String[]ar){
		LolCalidad formu=new LolCalidad();
		formu.setBounds(0,0,640,350);
		formu.setVisible(true);
	}
}

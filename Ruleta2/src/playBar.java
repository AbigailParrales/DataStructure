import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class playBar extends JPanel implements ActionListener{
	private JRadioButton back,
					forward,
					play;
	
	protected String accion;
	Reproductor player;
	
	public playBar(Reproductor player) {
		super();
		
		this.setPreferredSize(new Dimension(400,100));
		this.setBackground(Color.WHITE);
		
		this.back = new JRadioButton(new ImageIcon("back.png"));
		this.back.setOpaque(false);
		this.back.addActionListener(this);
		this.add(this.back);
		
		this.play = new JRadioButton(new ImageIcon("play.png"));
		this.play.setOpaque(false);
		this.play.addActionListener(this);
		this.add(this.play);
		
		this.forward = new JRadioButton(new ImageIcon("forward.png"));
		this.forward.setOpaque(false);
		this.forward.addActionListener(this);
		this.add(this.forward);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(this.back);
		bg.add(this.play);
		bg.add(this.forward);
		
		this.accion="";
		this.player=player;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (this.back.isSelected()) {
			this.player.ejecutarAccion("back");
		}
		else if(e.getSource()==this.play) {
			this.player.ejecutarAccion("play");
		}
		else if(e.getSource()==this.forward) {
			this.player.ejecutarAccion("forward");
		}
	}
}

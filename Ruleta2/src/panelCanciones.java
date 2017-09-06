import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class panelCanciones extends JPanel implements ActionListener{
	JRadioButton cn1,
	cn2,
	cn3,
	cn4,
	cn5,
	cn6;
	
	Reproductor player;
	
	public panelCanciones(Reproductor player) {
		super(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		this.setPreferredSize(new Dimension(600, 500));
		this.setBackground(new Color(204, 153, 255));

		//Cancion 1
		this.cn1 = new JRadioButton(new ImageIcon("born_again.JPG"));
		this.cn1.setBackground(new Color(204, 153, 255));
		this.cn1.addActionListener(this);
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.cn1,c);

		//Cancion 2
		this.cn2 = new JRadioButton(new ImageIcon("feeling_low.JPG"));
		this.cn2.setBackground(new Color(204, 153, 255));
		this.cn2.addActionListener(this);
		c.gridx = 1;
		c.gridy = 0;
		this.add(this.cn2,c);

		//Cancion 3
		this.cn3 = new JRadioButton(new ImageIcon("r45.JPG"));
		this.cn3.setBackground(new Color(204, 153, 255));
		this.cn3.addActionListener(this);
		c.gridx = 0;
		c.gridy = 1; 
		this.add(this.cn3,c);

		//Cancion 4
		this.cn4 = new JRadioButton(new ImageIcon("rivers_and_robots.JPG"));
		this.cn4.setBackground(new Color(204, 153, 255));
		this.cn4.addActionListener(this);
		c.gridx = 1;
		c.gridy = 1; 
		this.add(this.cn4,c);

		//Cancion 5
		this.cn5 = new JRadioButton(new ImageIcon("love_never_fails.JPG"));
		this.cn5.setBackground(new Color(204, 153, 255));
		this.cn5.addActionListener(this);
		c.gridx = 0;
		c.gridy = 2; 
		this.add(this.cn5,c);

		//Cancion 6
		this.cn6 = new JRadioButton(new ImageIcon("the_art_of_celebration.JPG"));
		this.cn6.setBackground(new Color(204, 153, 255));
		this.cn6.addActionListener(this);
		c.gridx = 1;
		c.gridy = 2; 
		this.add(this.cn6,c);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(cn1);
		bg.add(cn2);
		bg.add(cn3);
		bg.add(cn4);
		bg.add(cn5);
		bg.add(cn6);
		
		this.player = new Reproductor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this.cn1) {
			this.player.agregarCancion("born_again");
		}
		else if (e.getSource()==this.cn2) {
			this.player.agregarCancion("feeling_low");
		}
		else if (e.getSource()==this.cn3) {
			this.player.agregarCancion("r45");
		}
		else if (e.getSource()==this.cn4) {
			this.player.agregarCancion("rivers_and_robots");
		}
		else if (e.getSource()==this.cn5) {
			this.player.agregarCancion("love_never_fails");
		}
		else if (e.getSource()==this.cn6) {
			this.player.agregarCancion("the_art_of_celebration");
		}
				
	}

}

package a11;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import a10.CopyPreviousOpponent;
import a10.RandomOpponent;

/**
 * @author Holden
 *Class creates buttons component with basic plant option or cow option.
 */
public class PlantRadioButtons extends JPanel implements ActionListener {
	private String selectedPlant = "basicPlant";

	private JRadioButton basicPlant = new JRadioButton("Chicken!");
	private JRadioButton cowPlant = new JRadioButton("The Cow!");

	public PlantRadioButtons() {
		basicPlant.addActionListener(this);
		cowPlant.addActionListener(this);
		
		add(basicPlant);
		add(cowPlant);
		setLayout(new GridLayout(2, 1));

		ButtonGroup group = new ButtonGroup();
		basicPlant.setSelected(true);
		group.add(basicPlant);
		group.add(cowPlant);
	}

	/**
	 * This method changes the String in the selectedPlant field. This value gets used to determine which plant to place.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cowPlant) {
			selectedPlant = new String("cowPlant");
		} else {
			selectedPlant = new String("basicPlant");
		}
	}
	
	public String getSelectedPlant() {
		return selectedPlant;
	}
}

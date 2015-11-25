package grim3212.java.smitehelper.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import grim3212.java.smitehelper.BasicGod;
import grim3212.java.smitehelper.SmiteData;
import grim3212.java.smitehelper.SmiteHelper;
import grim3212.java.smitehelper.util.Constants;
import grim3212.java.smitehelper.util.EnumGamemodes;
import grim3212.java.smitehelper.util.EnumPantheon;
import grim3212.java.smitehelper.util.EnumRole;

public class SmiteHelperGUI {

	private JFrame frmSmiteHelper;
	private JTable pantheonTable;
	private JTable roleTable;
	private JTable gamemodeTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SmiteHelper.createGodData();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmiteHelperGUI window = new SmiteHelperGUI();
					window.frmSmiteHelper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SmiteHelperGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		frmSmiteHelper = new JFrame();
		frmSmiteHelper.setTitle(Constants.APPLICATION_NAME + " | " + Constants.HOME_NAME);
		frmSmiteHelper.setResizable(false);
		frmSmiteHelper.setBounds(100, 100, 640, 500);
		frmSmiteHelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmiteHelper.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel cardContainer = new JPanel();
		cardContainer.setBounds(0, 0, 622, 453);
		frmSmiteHelper.getContentPane().add(cardContainer, "cardContainer");
		cardContainer.setLayout(new CardLayout(0, 0));

		JPanel homeContainer = new JPanel();
		cardContainer.add(homeContainer, "homeCard");
		homeContainer.setLayout(new BorderLayout(0, 0));

		JLabel lblSmiteHelper = new JLabel("SMITE Helper");
		homeContainer.add(lblSmiteHelper, BorderLayout.NORTH);
		lblSmiteHelper.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmiteHelper.setFont(new Font("Tahoma", Font.BOLD, 50));

		JPanel buttons = new JPanel();
		homeContainer.add(buttons);
		buttons.setLayout(new GridLayout(4, 1, 50, 30));

		JButton button = new JButton("Stats");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) cardContainer.getLayout();
				cl.show(cardContainer, (String) "statsCard");
			}
		});
		buttons.add(button);

		JButton button_1 = new JButton("Randomizer");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) cardContainer.getLayout();
				cl.show(cardContainer, (String) "randomCard");
			}
		});
		buttons.add(button_1);

		JButton button_2 = new JButton("God Info");
		buttons.add(button_2);

		JButton button_3 = new JButton("Settings");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) cardContainer.getLayout();
				cl.show(cardContainer, (String) "settingsCard");
			}
		});
		buttons.add(button_3);

		JPanel leftPanel = new JPanel();
		homeContainer.add(leftPanel, BorderLayout.WEST);
		FlowLayout fl_leftPanel = (FlowLayout) leftPanel.getLayout();
		fl_leftPanel.setHgap(50);

		JPanel rightPanel = new JPanel();
		homeContainer.add(rightPanel, BorderLayout.EAST);
		FlowLayout fl_rightPanel = (FlowLayout) rightPanel.getLayout();
		fl_rightPanel.setHgap(50);
		frmSmiteHelper.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblSmiteHelper, buttons }));

		JPanel statsContainer = new JPanel();
		cardContainer.add(statsContainer, "statsCard");
		statsContainer.setLayout(new BorderLayout(0, 0));

		JLabel lblStats = new JLabel("Stats");
		lblStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblStats.setFont(new Font("Tahoma", Font.BOLD, 50));
		statsContainer.add(lblStats, BorderLayout.NORTH);

		JPanel stats = new JPanel();
		statsContainer.add(stats, BorderLayout.CENTER);
		stats.setLayout(null);

		JLabel lblPantheons = new JLabel("Pantheons");
		lblPantheons.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPantheons.setBounds(433, 13, 121, 48);
		lblPantheons.setHorizontalAlignment(SwingConstants.CENTER);
		stats.add(lblPantheons);

		pantheonTable = new JTable();
		pantheonTable.setBorder(new LineBorder(new Color(0, 0, 0)));

		HashMap<EnumPantheon, ArrayList<BasicGod>> pantheonInfo = SmiteData.numPantheons;
		pantheonTable.setModel(
				new DefaultTableModel(new Object[][] { { EnumPantheon.Chinese, pantheonInfo.get(EnumPantheon.Chinese).size() }, { EnumPantheon.Egyptian, pantheonInfo.get(EnumPantheon.Egyptian).size() }, { EnumPantheon.Greek, pantheonInfo.get(EnumPantheon.Greek).size() }, { EnumPantheon.Hindu, pantheonInfo.get(EnumPantheon.Hindu).size() }, { EnumPantheon.Mayan, pantheonInfo.get(EnumPantheon.Mayan).size() }, { EnumPantheon.Norse, pantheonInfo.get(EnumPantheon.Norse).size() }, { EnumPantheon.Roman, pantheonInfo.get(EnumPantheon.Roman).size() }, }, new String[] { "Pantheons", "Number of Gods" }) {

					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] { false, true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		pantheonTable.getColumnModel().getColumn(0).setPreferredWidth(162);
		pantheonTable.setBounds(443, 59, 179, 112);
		stats.add(pantheonTable);

		JLabel lblOfGods = new JLabel("# of Gods");
		lblOfGods.setBounds(566, 30, 56, 16);
		stats.add(lblOfGods);

		JLabel lblNumGods = new JLabel("Number of Gods: " + SmiteData.gods.size());
		lblNumGods.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumGods.setBounds(12, 264, 165, 35);
		stats.add(lblNumGods);

		JLabel lblRoles = new JLabel("Roles");
		lblRoles.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRoles.setBounds(12, 23, 61, 29);
		stats.add(lblRoles);

		JLabel label = new JLabel("# of Gods");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(160, 30, 56, 16);
		stats.add(label);

		HashMap<EnumRole, ArrayList<BasicGod>> roleInfo = SmiteData.numRoles;
		roleTable = new JTable();
		roleTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		roleTable.setModel(new DefaultTableModel(new Object[][] { { EnumRole.Assassin, EnumRole.Assassin.getPowerType(), roleInfo.get(EnumRole.Assassin).size() }, { EnumRole.Guardian, EnumRole.Guardian.getPowerType(), roleInfo.get(EnumRole.Guardian).size() }, { EnumRole.Hunter, EnumRole.Hunter.getPowerType(), roleInfo.get(EnumRole.Hunter).size() }, { EnumRole.Mage, EnumRole.Mage.getPowerType(), roleInfo.get(EnumRole.Mage).size() }, { EnumRole.Warrior, EnumRole.Warrior.getPowerType(), roleInfo.get(EnumRole.Warrior).size() }, }, new String[] { "Role", "Power Type", "Number of Gods" }) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		roleTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		roleTable.setBounds(12, 59, 200, 80);
		stats.add(roleTable);

		JLabel lblPowerType = new JLabel("Power Type");
		lblPowerType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPowerType.setBounds(71, 30, 77, 16);
		stats.add(lblPowerType);

		JLabel lblNumberOfItems = new JLabel("Number of Items: " + SmiteData.items.size());
		lblNumberOfItems.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumberOfItems.setBounds(450, 268, 172, 26);
		stats.add(lblNumberOfItems);

		JLabel lblGamemodes = new JLabel("Gamemodes");
		lblGamemodes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamemodes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGamemodes.setBounds(256, 22, 121, 31);
		stats.add(lblGamemodes);

		gamemodeTable = new JTable();
		gamemodeTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		gamemodeTable.setModel(new DefaultTableModel(new Object[][] { { EnumGamemodes.Arena }, { EnumGamemodes.Assault }, { EnumGamemodes.Clash + " (BETA)" }, { EnumGamemodes.Conquest }, { EnumGamemodes.Joust }, { EnumGamemodes.MOTD }, { EnumGamemodes.Siege }, }, new String[] { "Gamemode" }) {

			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		gamemodeTable.getColumnModel().getColumn(0).setPreferredWidth(120);
		gamemodeTable.setBounds(256, 59, 121, 112);
		stats.add(gamemodeTable);

		JButton btnBack = new JButton("<-- Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) cardContainer.getLayout();
				cl.show(cardContainer, (String) "homeCard");
			}
		});
		btnBack.setBounds(12, 356, 136, 35);
		stats.add(btnBack);

		JPanel settingsContainer = new JPanel();
		cardContainer.add(settingsContainer, "settingsCard");
		settingsContainer.setLayout(new BorderLayout(0, 0));

		JLabel lblV_1 = new JLabel(Constants.VERSION + "  |  " + "By: Grim3212");
		lblV_1.setHorizontalAlignment(SwingConstants.CENTER);
		settingsContainer.add(lblV_1, BorderLayout.SOUTH);

		JPanel rp = new JPanel();
		FlowLayout fl_rp = (FlowLayout) rp.getLayout();
		fl_rp.setHgap(50);
		settingsContainer.add(rp, BorderLayout.EAST);

		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		settingsContainer.add(lblSettings, BorderLayout.NORTH);

		JPanel settings = new JPanel();
		settingsContainer.add(settings, BorderLayout.CENTER);
		settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Sounds Enabled");
		chckbxNewCheckBox.setVerticalAlignment(SwingConstants.BOTTOM);
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		settings.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);

		JCheckBox chckbxShowImages = new JCheckBox("Show Images");
		chckbxShowImages.setVerticalAlignment(SwingConstants.BOTTOM);
		chckbxShowImages.setAlignmentX(Component.CENTER_ALIGNMENT);
		chckbxShowImages.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxShowImages.setSelected(true);
		settings.add(chckbxShowImages);

		JButton button_4 = new JButton("<-- Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) cardContainer.getLayout();
				cl.show(cardContainer, (String) "homeCard");
			}
		});
		button_4.setVerticalAlignment(SwingConstants.BOTTOM);
		button_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		settings.add(button_4);

		JPanel lp = new JPanel();
		settingsContainer.add(lp, BorderLayout.WEST);
		lp.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 5));

		JPanel randomizerContainer = new JPanel();
		cardContainer.add(randomizerContainer, "randomCard");
		randomizerContainer.setLayout(new BorderLayout(0, 0));

		JLabel lblRandomizer = new JLabel("Randomizer");
		lblRandomizer.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomizer.setFont(new Font("Tahoma", Font.BOLD, 50));
		randomizerContainer.add(lblRandomizer, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		randomizerContainer.add(tabbedPane, BorderLayout.CENTER);

		JButton btnRandomizeallGods = new JButton("Randomize (All Gods)");
		btnRandomizeallGods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int godNum = rand.nextInt(SmiteData.gods.size());
				System.out.println("God Selected: " + SmiteData.gods.get(godNum).getName());
			}
		});
		tabbedPane.addTab("All Gods", null, btnRandomizeallGods, null);

		JPanel byPantheon = new JPanel();
		tabbedPane.addTab("By Pantheon", null, byPantheon, null);
		byPantheon.setLayout(new GridLayout(0, 1, 0, 0));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chinese");
		byPantheon.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setActionCommand("Chinese");

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Egyptian");
		byPantheon.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setActionCommand("Egyptian");

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Greek");
		byPantheon.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setActionCommand("Greek");

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Hindu");
		byPantheon.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setActionCommand("Hindu");

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Mayan");
		byPantheon.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setActionCommand("Mayan");

		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Norse");
		byPantheon.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setActionCommand("Norse");

		JRadioButton rdbtnRoman = new JRadioButton("Roman");
		byPantheon.add(rdbtnRoman);
		rdbtnRoman.setActionCommand("Roman");

		ButtonGroup pantheonGroup = new ButtonGroup();
		pantheonGroup.add(rdbtnNewRadioButton);
		pantheonGroup.add(rdbtnNewRadioButton_1);
		pantheonGroup.add(rdbtnNewRadioButton_2);
		pantheonGroup.add(rdbtnNewRadioButton_3);
		pantheonGroup.add(rdbtnNewRadioButton_4);
		pantheonGroup.add(rdbtnNewRadioButton_5);
		pantheonGroup.add(rdbtnRoman);

		JButton btnRandomizebyPantheon = new JButton("Randomize (By Pantheon)");
		btnRandomizebyPantheon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pantheonGroup.getSelection() != null) {

					Random rand = new Random();
					int godNum = rand.nextInt(SmiteData.numPantheons.get(EnumPantheon.valueOf(pantheonGroup.getSelection().getActionCommand())).size());
					System.out.println("God Selected: " + SmiteData.numPantheons.get(EnumPantheon.valueOf(pantheonGroup.getSelection().getActionCommand())).get(godNum).getName());

				} else {
					System.out.println("No panthoen selected!!");
				}
			}
		});
		byPantheon.add(btnRandomizebyPantheon);

		JPanel byRole = new JPanel();
		tabbedPane.addTab("By Role", null, byRole, null);
		byRole.setLayout(new GridLayout(0, 1, 0, 0));

		JRadioButton assassinRdb = new JRadioButton("Assassin");
		byRole.add(assassinRdb);
		assassinRdb.setActionCommand("Assassin");

		JRadioButton guardianRdb = new JRadioButton("Guardian");
		byRole.add(guardianRdb);
		guardianRdb.setActionCommand("Guardian");

		JRadioButton hunterRdb = new JRadioButton("Hunter");
		byRole.add(hunterRdb);
		hunterRdb.setActionCommand("Hunter");

		JRadioButton mageRdb = new JRadioButton("Mage");
		byRole.add(mageRdb);
		mageRdb.setActionCommand("Mage");

		JRadioButton warriorRdb = new JRadioButton("Warrior");
		byRole.add(warriorRdb);
		warriorRdb.setActionCommand("Warrior");

		ButtonGroup roleGroup = new ButtonGroup();
		roleGroup.add(assassinRdb);
		roleGroup.add(guardianRdb);
		roleGroup.add(hunterRdb);
		roleGroup.add(mageRdb);
		roleGroup.add(warriorRdb);

		JButton btnRandomizebyRole = new JButton("Randomize (By Role)");
		btnRandomizebyRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (roleGroup.getSelection() != null) {
					Random rand = new Random();
					int godNum = rand.nextInt(SmiteData.numRoles.get(EnumRole.valueOf(roleGroup.getSelection().getActionCommand())).size());
					System.out.println("God Selected: " + SmiteData.numRoles.get(EnumRole.valueOf(roleGroup.getSelection().getActionCommand())).get(godNum).getName());

				} else {
					System.out.println("No role selected!!");
				}
			}
		});
		byRole.add(btnRandomizebyRole);
	}
}

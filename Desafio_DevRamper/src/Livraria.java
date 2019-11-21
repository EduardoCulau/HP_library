import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.SpinnerNumberModel;
import java.util.ArrayList;


public class Livraria {

	private JFrame frmDesafioDevramper;
	private JSpinner n_hp1;
	private JSpinner n_hp2;
	private JSpinner n_hp3;
	private JSpinner n_hp4;
	private JSpinner n_hp5;
	private JSpinner n_hp6;
	private JSpinner n_hp7;
	
	private ArrayList<JSpinner> allSpinners =  new ArrayList<JSpinner>();
	
	//Update dos valores
	private int[] books = new int[BackEnd.N_TITLES];
	private JLabel val_totalPrice;
	private JLabel val_desconto;
	private JLabel val_valDesc;
	private JLabel val_finalPrice;
	private BackEnd backend = new BackEnd();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Livraria window = new Livraria();
					window.frmDesafioDevramper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Livraria() {
		initialize();
	}

	
	/*
	 * Update the Total Value
	 */
	public void updateTotalPrice() {
	}
	
	/*
	 * Update all values
	 */
	public void updateAllValues() {
		this.readAllInputs(); backend.computeAll(books);
		val_totalPrice.setText("R$ "+String.format("%.2f", backend.getTotalPrice())); val_desconto.setText(""+String.format("%.2f", backend.getDiscount()*100)+"%");
		val_valDesc.setText("- R$ "+String.format("%.2f", backend.getDiscountValue())); val_finalPrice.setText("R$ "+String.format("%.2f", backend.getFinalPrice()));
	}
	
	/*
	 * Read all inputs;
	 */
	public void readAllInputs() {
		int i = 0;
		for(JSpinner spinner : allSpinners) {
			books[i++] = (int) spinner.getValue();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDesafioDevramper = new JFrame();
		frmDesafioDevramper.setTitle("Desafio DevRamper");
		frmDesafioDevramper.setResizable(false);
		frmDesafioDevramper.setBounds(100, 100, 700, 480);
		frmDesafioDevramper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesafioDevramper.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Livraria do Harry Potter");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Californian FB", Font.ITALIC, 33));
		title.setBounds(10, 11, 604, 60);
		frmDesafioDevramper.getContentPane().add(title);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 434, 337);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		frmDesafioDevramper.getContentPane().add(scrollPane);
		
		JPanel panelVertical = new JPanel();
		scrollPane.setViewportView(panelVertical);
		panelVertical.setLayout(new BoxLayout(panelVertical, BoxLayout.Y_AXIS));
		
		JPanel panel_hp1 = new JPanel();
		panel_hp1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp1);
		panel_hp1.setLayout(new MigLayout("", "[350.00px][43.00px]", "[150px]"));
		
		JLabel lblHP1 = new JLabel("Harry Potter e a Pedra Filosofal");
		panel_hp1.add(lblHP1, "cell 0 0,alignx left,aligny top");
		lblHP1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHP1.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp1_pf.png")));
		
		n_hp1 = new JSpinner();
		n_hp1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp1.setPreferredSize(new Dimension(40, 30));
		panel_hp1.add(n_hp1, "cell 1 0,alignx center,aligny center");
		
		JPanel panel_hp2 = new JPanel();
		panel_hp2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp2);
		panel_hp2.setLayout(new MigLayout("", "[350.00px][43.00px]", "[150px]"));
		
		JLabel lblHP2 = new JLabel("Harry Potter e a C\u00E2mara Secreta");
		panel_hp2.add(lblHP2, "cell 0 0,alignx left,aligny top");
		lblHP2.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp2_cs.png")));
		
		n_hp2 = new JSpinner();
		n_hp2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp2.setPreferredSize(new Dimension(40, 30));
		panel_hp2.add(n_hp2, "cell 1 0,alignx center,aligny center");
		
		JPanel panel_hp3 = new JPanel();
		panel_hp3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp3);
		panel_hp3.setLayout(new MigLayout("", "[350.00px][43.00px]", "[150px]"));
		
		JLabel lblHP3 = new JLabel("Harry Potter e o Prisioneiro de Azkaban");
		panel_hp3.add(lblHP3, "cell 0 0,alignx left,aligny top");
		lblHP3.setBounds(0, 322, 98, 150);
		lblHP3.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp3_pa.png")));
		
		n_hp3 = new JSpinner();
		n_hp3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp3.setPreferredSize(new Dimension(40, 30));
		panel_hp3.add(n_hp3, "cell 1 0,alignx center,aligny center");
		
		JPanel panel_hp4 = new JPanel();
		panel_hp4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp4);
		panel_hp4.setLayout(new MigLayout("", "[350px][43px]", "[150px]"));
		
		JLabel lblHP4 = new JLabel("Harry Potter e o C\u00E1lice de Fogo");
		panel_hp4.add(lblHP4, "cell 0 0,alignx left,aligny top");
		lblHP4.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp4_cf.png")));
		
		n_hp4 = new JSpinner();
		n_hp4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp4.setPreferredSize(new Dimension(40, 30));
		panel_hp4.add(n_hp4, "cell 1 0,alignx center,aligny center");
		
		JPanel panel_hp5 = new JPanel();
		panel_hp5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp5);
		panel_hp5.setLayout(new MigLayout("", "[350px][43px]", "[150px]"));
		
		JLabel lblHP5 = new JLabel("Harry Potter e a Ordem da F\u00EAnix");
		panel_hp5.add(lblHP5, "cell 0 0,alignx left,aligny top");
		lblHP5.setBounds(0, 644, 98, 150);
		lblHP5.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp5_of.png")));
		
		n_hp5 = new JSpinner();
		n_hp5.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp5.setPreferredSize(new Dimension(40, 30));
		panel_hp5.add(n_hp5, "cell 1 0,alignx center,aligny center");
		
		JPanel panel_hp6 = new JPanel();
		panel_hp6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp6);
		panel_hp6.setLayout(new MigLayout("", "[350px][43px]", "[150px]"));
		
		JLabel lblHP6 = new JLabel("Harry Potter e o Enigma do Pr\u00EDncipe");
		panel_hp6.add(lblHP6, "cell 0 0,alignx left,aligny top");
		lblHP6.setBounds(0, 805, 98, 150);
		lblHP6.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp6_ep.png")));
		
		n_hp6 = new JSpinner();
		n_hp6.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp6.setPreferredSize(new Dimension(40, 30));
		panel_hp6.add(n_hp6, "cell 1 0,alignx center,aligny center");
		
		JPanel panel_hp7 = new JPanel();
		panel_hp7.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panelVertical.add(panel_hp7);
		panel_hp7.setLayout(new MigLayout("", "[350px][43px]", "[150px]"));
		
		JLabel lblHP7 = new JLabel("Harry Potter e as Rel\u00EDquias da Morte");
		panel_hp7.add(lblHP7, "cell 0 0,alignx left,aligny top");
		lblHP7.setBounds(0, 966, 98, 150);
		lblHP7.setIcon(new ImageIcon(Livraria.class.getResource("/capas_livros/hp7_rm.png")));
		
		n_hp7 = new JSpinner();
		n_hp7.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		n_hp7.setPreferredSize(new Dimension(40, 30));
		panel_hp7.add(n_hp7, "cell 1 0,alignx center,aligny center");
		
		JLabel lblNewLabel = new JLabel("LIVRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 82, 301, 20);
		frmDesafioDevramper.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QUANTIDADE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(321, 82, 105, 20);
		frmDesafioDevramper.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Calcular Desconto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAllValues();
			}
		});
		btnNewButton.setBounds(454, 103, 230, 42);
		frmDesafioDevramper.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(454, 156, 230, 284);
		frmDesafioDevramper.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel txt_desconto = new JLabel("Desconto    =");
		txt_desconto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_desconto.setBounds(0, 28, 96, 17);
		panel.add(txt_desconto);
		
		JLabel txt_totalPrice = new JLabel("Valor Parcial =");
		txt_totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_totalPrice.setBounds(0, 0, 96, 17);
		panel.add(txt_totalPrice);
		
		JLabel txt_valDesc = new JLabel("Valor Desc.  = ");
		txt_valDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_valDesc.setBounds(0, 56, 96, 17);
		panel.add(txt_valDesc);
		
		JLabel lblValorTotal = new JLabel("Valor Total  =");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorTotal.setBounds(0, 84, 96, 17);
		panel.add(lblValorTotal);
		
		val_totalPrice = new JLabel("R$ 0.00");
		val_totalPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		val_totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		val_totalPrice.setBounds(106, 3, 124, 17);
		panel.add(val_totalPrice);
		
		val_desconto = new JLabel("0.00%");
		val_desconto.setHorizontalAlignment(SwingConstants.RIGHT);
		val_desconto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		val_desconto.setBounds(106, 31, 124, 17);
		panel.add(val_desconto);
		
		val_valDesc = new JLabel("- R$ 0.00");
		val_valDesc.setHorizontalAlignment(SwingConstants.RIGHT);
		val_valDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		val_valDesc.setBounds(106, 59, 124, 17);
		panel.add(val_valDesc);
		
		val_finalPrice = new JLabel("R$ 0.00");
		val_finalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		val_finalPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		val_finalPrice.setBounds(106, 84, 124, 17);
		panel.add(val_finalPrice);
		
		allSpinners = new  ArrayList<JSpinner>();
		allSpinners.add(n_hp1);
		allSpinners.add(n_hp2);
		allSpinners.add(n_hp3);
		allSpinners.add(n_hp4);
		allSpinners.add(n_hp5);
		allSpinners.add(n_hp6);
		allSpinners.add(n_hp7);
	}
}

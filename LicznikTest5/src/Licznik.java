//package licznik;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Licznik {
	private int liczbazaokraglana;
	private Double moc;
	private Double cenakWh;
	private Double podatekVat; //dodane
	private Double akcyza; //dodane
	private Double podatkiIoplatyLokalne; //dodane
	private Double kosztyWlasneIspolkiDystrybucyjnej; //dodane
	private Double marzaSpolkiDystrybucyjnej; //dodane
	private Double kosztyZakupuUslugPrzesylowych; //dodane
	private Double czaspracytygodniowo;
	private Double zuzycieMiesiecznekWh;
	private Double kosztmiesieczny;
	public Double suma=0.0;
	public String name;

	private JFrame frame;
	private JTextArea oknomoc;
	private JTextArea oknocenakWh;
	private JTextArea oknopodatekVat; //dodane
	private JTextArea oknoakcyza; //dodane
	private JTextArea oknopodatkiIoplatyLokalne; //dodane
	private JTextArea oknokosztyWlasneIspolkiDystrybucyjnej; //dodane
	private JTextArea oknomarzaSpolkiDystrybucyjnej; //dodane
	private JTextArea oknokosztyZakupuUslugPrzesylowych; //dodane
	private JTextArea oknogodzinyPracyTygodniowo;
	private JTextArea oknozuzyciekWhmiesieczne;
	private JTextArea oknomiesiecznykoszt;
	private JTextArea textArea;
	private JTextField txtUrzdzenie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Licznik window = new Licznik();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Licznik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Kalkulator zuzycia energii");
		frame.setBounds(300, 00, 1500, 505);
		frame.setMinimumSize(new Dimension(1280, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 85, 276, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 24, 0, 30, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);
		
//		txtUrzdzenie = new JTextField();
//		txtUrzdzenie.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		GridBagConstraints gbc_txtUrzdzenie = new GridBagConstraints();
//		gbc_txtUrzdzenie.insets = new Insets(0, 0, 5, 5);
//		gbc_txtUrzdzenie.fill = GridBagConstraints.HORIZONTAL;
//		gbc_txtUrzdzenie.gridx = 1;
//		gbc_txtUrzdzenie.gridy = 0;
//		frame.getContentPane().add(txtUrzdzenie, gbc_txtUrzdzenie);
//		txtUrzdzenie.setColumns(10);

		JLabel lblMocw = new JLabel("Moc [W]");
		lblMocw.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblMocw = new GridBagConstraints();
		gbc_lblMocw.fill = GridBagConstraints.BOTH;
		gbc_lblMocw.insets = new Insets(0, 0, 5, 5);
		gbc_lblMocw.gridx = 0;
		gbc_lblMocw.gridy = 1;
		frame.getContentPane().add(lblMocw, gbc_lblMocw);

		JLabel lblCenaKilowatogodziny = new JLabel("Cena kilowatogodziny [zl/kWh]\r\n");
		lblCenaKilowatogodziny.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblCenaKilowatogodziny = new GridBagConstraints();
		gbc_lblCenaKilowatogodziny.insets = new Insets(0, 0, 5, 5);
		gbc_lblCenaKilowatogodziny.gridx = 1;
		gbc_lblCenaKilowatogodziny.gridy = 1;
		frame.getContentPane().add(lblCenaKilowatogodziny, gbc_lblCenaKilowatogodziny);
		
		//dodane

				JLabel lblPodatekVat = new JLabel("Podatek Vat [zl/kWh]\r\n");
				lblPodatekVat.setFont(new Font("Times New Roman", Font.BOLD, 16));
				GridBagConstraints gbc_lblPodatekVat = new GridBagConstraints();
				gbc_lblPodatekVat.insets = new Insets(0, 0, 5, 5);
				gbc_lblPodatekVat.gridx = 0;
				gbc_lblPodatekVat.gridy = 3;
				frame.getContentPane().add(lblPodatekVat, gbc_lblPodatekVat);
				
				JLabel lblAkcyza = new JLabel("Akcyza [zl/kWh]\r\n");
				lblAkcyza.setFont(new Font("Times New Roman", Font.BOLD, 16));
				GridBagConstraints gbc_lblAkcyza = new GridBagConstraints();
				gbc_lblAkcyza.insets = new Insets(0, 0, 5, 5);
				gbc_lblAkcyza.gridx = 1;
				gbc_lblAkcyza.gridy = 3;
				frame.getContentPane().add(lblAkcyza, gbc_lblAkcyza);

				JLabel lblpodatkiIoplatyLokalne = new JLabel("Podatki i oplaty lokalne [zl/kWh]\r\n");
				lblpodatkiIoplatyLokalne.setFont(new Font("Times New Roman", Font.BOLD, 16));
				GridBagConstraints gbc_lblpodatkiIoplatyLokalne = new GridBagConstraints();
				gbc_lblpodatkiIoplatyLokalne.insets = new Insets(0, 0, 5, 5);
				gbc_lblpodatkiIoplatyLokalne.gridx = 2;
				gbc_lblpodatkiIoplatyLokalne.gridy = 3;
				frame.getContentPane().add(lblpodatkiIoplatyLokalne, gbc_lblpodatkiIoplatyLokalne);
				
				JLabel lblkosztyWlasneIspolkiDystrybucyjnej = new JLabel("Koszty wlasne i spolki dystrybucyjnej [zl/kWh]\r\n");
				lblkosztyWlasneIspolkiDystrybucyjnej.setFont(new Font("Times New Roman", Font.BOLD, 16));
				GridBagConstraints gbc_lblkosztyWlasneIspolkiDystrybucyjnej = new GridBagConstraints();
				gbc_lblkosztyWlasneIspolkiDystrybucyjnej.insets = new Insets(0, 0, 5, 5);
				gbc_lblkosztyWlasneIspolkiDystrybucyjnej.gridx = 3;
				gbc_lblkosztyWlasneIspolkiDystrybucyjnej.gridy = 3;
				frame.getContentPane().add(lblkosztyWlasneIspolkiDystrybucyjnej, gbc_lblkosztyWlasneIspolkiDystrybucyjnej);
				
				JLabel lblmarzaSpolkiDystrybucyjnej = new JLabel("Marza spoki dystrybucyjnej [zl/kWh]\r\n");
				lblmarzaSpolkiDystrybucyjnej.setFont(new Font("Times New Roman", Font.BOLD, 16));
				GridBagConstraints gbc_lblmarzaSpolkiDystrybucyjnej = new GridBagConstraints();
				gbc_lblmarzaSpolkiDystrybucyjnej.insets = new Insets(0, 0, 5, 5);
				gbc_lblmarzaSpolkiDystrybucyjnej.gridx = 4;
				gbc_lblmarzaSpolkiDystrybucyjnej.gridy = 3;
				frame.getContentPane().add(lblmarzaSpolkiDystrybucyjnej, gbc_lblmarzaSpolkiDystrybucyjnej);
				
				JLabel lblkosztyZakupuUslugPrzesylowych = new JLabel("Koszty zakupu uslug przesylowych [zl/kWh]\r\n");
				lblkosztyZakupuUslugPrzesylowych.setFont(new Font("Times New Roman", Font.BOLD, 16));
				GridBagConstraints gbc_lblkosztyZakupuUslugPrzesylowych = new GridBagConstraints();
				gbc_lblkosztyZakupuUslugPrzesylowych.insets = new Insets(0, 0, 5, 5);
				gbc_lblkosztyZakupuUslugPrzesylowych.gridx = 5;
				gbc_lblkosztyZakupuUslugPrzesylowych.gridy = 3;
				frame.getContentPane().add(lblkosztyZakupuUslugPrzesylowych, gbc_lblkosztyZakupuUslugPrzesylowych);
				
				// koniec dodanych
				
		

		JLabel lblIloGodzinPracy = new JLabel("Czas pracy tygodniowo [h]");
		lblIloGodzinPracy.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblIloGodzinPracy = new GridBagConstraints();
		gbc_lblIloGodzinPracy.insets = new Insets(0, 0, 5, 5);
		gbc_lblIloGodzinPracy.gridx = 2;
		gbc_lblIloGodzinPracy.gridy = 1;
		frame.getContentPane().add(lblIloGodzinPracy, gbc_lblIloGodzinPracy);

		JLabel lblZuycieMiesieczneW = new JLabel("Miesieczne zuzycie energii [kWh] \r\n");
		lblZuycieMiesieczneW.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblZuycieMiesieczneW = new GridBagConstraints();
		gbc_lblZuycieMiesieczneW.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuycieMiesieczneW.gridx = 3;
		gbc_lblZuycieMiesieczneW.gridy = 1;
		frame.getContentPane().add(lblZuycieMiesieczneW, gbc_lblZuycieMiesieczneW);

		JLabel lblRocznyKosztZuycia = new JLabel("Miesieczny koszt zuzycia energii [zl]");
		lblRocznyKosztZuycia.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblRocznyKosztZuycia = new GridBagConstraints();
		gbc_lblRocznyKosztZuycia.insets = new Insets(0, 0, 5, 5);
		gbc_lblRocznyKosztZuycia.gridx = 4;
		gbc_lblRocznyKosztZuycia.gridy = 1;
		frame.getContentPane().add(lblRocznyKosztZuycia, gbc_lblRocznyKosztZuycia);
		
		oknomoc = new JTextArea();
		oknomoc.setFont(new Font("Monospaced", Font.BOLD, 16));
		GridBagConstraints gbc_oknomoc = new GridBagConstraints();
		gbc_oknomoc.insets = new Insets(0, 0, 5, 5);
		gbc_oknomoc.fill = GridBagConstraints.BOTH;
		gbc_oknomoc.gridx = 0;
		gbc_oknomoc.gridy = 2;
		frame.getContentPane().add(oknomoc, gbc_oknomoc);
		
		//dodane
		
				oknopodatekVat = new JTextArea();
				oknopodatekVat.setFont(new Font("Monospaced", Font.BOLD, 16));
				GridBagConstraints gbc_oknopodatekVat = new GridBagConstraints();
				gbc_oknopodatekVat.insets = new Insets(0, 0, 5, 5);
				gbc_oknopodatekVat.fill = GridBagConstraints.BOTH;
				gbc_oknopodatekVat.gridx = 0;
				gbc_oknopodatekVat.gridy = 4;
				frame.getContentPane().add(oknopodatekVat, gbc_oknopodatekVat);
				
				oknoakcyza = new JTextArea();
				oknoakcyza.setFont(new Font("Monospaced", Font.BOLD, 16));
				GridBagConstraints gbc_oknoakcyza = new GridBagConstraints();
				gbc_oknoakcyza.insets = new Insets(0, 0, 5, 5);
				gbc_oknoakcyza.fill = GridBagConstraints.BOTH;
				gbc_oknoakcyza.gridx = 1;
				gbc_oknoakcyza.gridy = 4;
				frame.getContentPane().add(oknoakcyza, gbc_oknoakcyza);
				
				oknopodatkiIoplatyLokalne = new JTextArea();
				oknopodatkiIoplatyLokalne.setFont(new Font("Monospaced", Font.BOLD, 16));
				GridBagConstraints gbc_oknopodatkiIoplatyLokalne = new GridBagConstraints();
				gbc_oknopodatkiIoplatyLokalne.insets = new Insets(0, 0, 5, 5);
				gbc_oknopodatkiIoplatyLokalne.fill = GridBagConstraints.BOTH;
				gbc_oknopodatkiIoplatyLokalne.gridx = 2;
				gbc_oknopodatkiIoplatyLokalne.gridy = 4;
				frame.getContentPane().add(oknopodatkiIoplatyLokalne, gbc_oknopodatkiIoplatyLokalne);
				
				oknokosztyWlasneIspolkiDystrybucyjnej = new JTextArea();
				oknokosztyWlasneIspolkiDystrybucyjnej.setFont(new Font("Monospaced", Font.BOLD, 16));
				GridBagConstraints gbc_oknokosztyWlasneIspolkiDystrybucyjnej = new GridBagConstraints();
				gbc_oknokosztyWlasneIspolkiDystrybucyjnej.insets = new Insets(0, 0, 5, 5);
				gbc_oknokosztyWlasneIspolkiDystrybucyjnej.fill = GridBagConstraints.BOTH;
				gbc_oknokosztyWlasneIspolkiDystrybucyjnej.gridx = 3;
				gbc_oknokosztyWlasneIspolkiDystrybucyjnej.gridy = 4;
				frame.getContentPane().add(oknokosztyWlasneIspolkiDystrybucyjnej, gbc_oknokosztyWlasneIspolkiDystrybucyjnej);
				
				oknomarzaSpolkiDystrybucyjnej = new JTextArea();
				oknomarzaSpolkiDystrybucyjnej.setFont(new Font("Monospaced", Font.BOLD, 16));
				GridBagConstraints gbc_oknomarzaSpolkiDystrybucyjnej = new GridBagConstraints();
				gbc_oknomarzaSpolkiDystrybucyjnej.insets = new Insets(0, 0, 5, 5);
				gbc_oknomarzaSpolkiDystrybucyjnej.fill = GridBagConstraints.BOTH;
				gbc_oknomarzaSpolkiDystrybucyjnej.gridx = 4;
				gbc_oknomarzaSpolkiDystrybucyjnej.gridy = 4;
				frame.getContentPane().add(oknomarzaSpolkiDystrybucyjnej, gbc_oknomarzaSpolkiDystrybucyjnej);
				
				oknokosztyZakupuUslugPrzesylowych = new JTextArea();
				oknokosztyZakupuUslugPrzesylowych.setFont(new Font("Monospaced", Font.BOLD, 16));
				GridBagConstraints gbc_oknokosztyZakupuUslugPrzesylowych = new GridBagConstraints();
				gbc_oknokosztyZakupuUslugPrzesylowych.insets = new Insets(0, 0, 5, 5);
				gbc_oknokosztyZakupuUslugPrzesylowych.fill = GridBagConstraints.BOTH;
				gbc_oknokosztyZakupuUslugPrzesylowych.gridx = 5;
				gbc_oknokosztyZakupuUslugPrzesylowych.gridy = 4;
				frame.getContentPane().add(oknokosztyZakupuUslugPrzesylowych, gbc_oknokosztyZakupuUslugPrzesylowych);
				
				
				//koniec dodane

		oknocenakWh = new JTextArea();
		oknocenakWh.setFont(new Font("Monospaced", Font.BOLD, 16));
		GridBagConstraints gbc_oknocenakWh = new GridBagConstraints();
		gbc_oknocenakWh.insets = new Insets(0, 0, 5, 5);
		gbc_oknocenakWh.fill = GridBagConstraints.BOTH;
		gbc_oknocenakWh.gridx = 1;
		gbc_oknocenakWh.gridy = 2;
		frame.getContentPane().add(oknocenakWh, gbc_oknocenakWh);

		oknogodzinyPracyTygodniowo = new JTextArea();
		oknogodzinyPracyTygodniowo.setFont(new Font("Monospaced", Font.BOLD, 16));
		GridBagConstraints gbc_oknogodzinyPracyTygodniowo = new GridBagConstraints();
		gbc_oknogodzinyPracyTygodniowo.insets = new Insets(0, 0, 5, 5);
		gbc_oknogodzinyPracyTygodniowo.fill = GridBagConstraints.BOTH;
		gbc_oknogodzinyPracyTygodniowo.gridx = 2;
		gbc_oknogodzinyPracyTygodniowo.gridy = 2;
		frame.getContentPane().add(oknogodzinyPracyTygodniowo, gbc_oknogodzinyPracyTygodniowo);

		oknozuzyciekWhmiesieczne = new JTextArea();
		oknozuzyciekWhmiesieczne.setFont(new Font("Monospaced", Font.BOLD, 16));
		GridBagConstraints gbc_oknozuzyciekWhmiesieczne = new GridBagConstraints();
		gbc_oknozuzyciekWhmiesieczne.insets = new Insets(0, 0, 5, 5);
		gbc_oknozuzyciekWhmiesieczne.fill = GridBagConstraints.BOTH;
		gbc_oknozuzyciekWhmiesieczne.gridx = 3;
		gbc_oknozuzyciekWhmiesieczne.gridy = 2;
		frame.getContentPane().add(oknozuzyciekWhmiesieczne, gbc_oknozuzyciekWhmiesieczne);

		oknomiesiecznykoszt = new JTextArea();
		oknomiesiecznykoszt.setFont(new Font("Monospaced", Font.BOLD, 16));
		GridBagConstraints gbc_oknomiesiecznykoszt = new GridBagConstraints();
		gbc_oknomiesiecznykoszt.insets = new Insets(0, 0, 5, 5);
		gbc_oknomiesiecznykoszt.fill = GridBagConstraints.BOTH;
		gbc_oknomiesiecznykoszt.gridx = 4;
		gbc_oknomiesiecznykoszt.gridy = 2;
		frame.getContentPane().add(oknomiesiecznykoszt, gbc_oknomiesiecznykoszt);
		
		
		JButton btnObliczzuzycie1 = new JButton("Oblicz miesieczne zuzycie energii.\r\n");
		btnObliczzuzycie1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					moc = Double.parseDouble(oknomoc.getText());
					cenakWh = Double.parseDouble(oknocenakWh.getText());
					czaspracytygodniowo = Double.parseDouble(oknogodzinyPracyTygodniowo.getText());
					zuzycieMiesiecznekWh = (moc * czaspracytygodniowo * 4) / 1000; // zuzycie roczne w kWh
					//dodane
					podatekVat = Double.parseDouble(oknopodatekVat.getText());
					akcyza = Double.parseDouble(oknoakcyza.getText());
					podatkiIoplatyLokalne = Double.parseDouble(oknopodatkiIoplatyLokalne.getText());
					kosztyWlasneIspolkiDystrybucyjnej = Double.parseDouble(oknokosztyWlasneIspolkiDystrybucyjnej.getText());
					marzaSpolkiDystrybucyjnej = Double.parseDouble(oknomarzaSpolkiDystrybucyjnej.getText());
					kosztyZakupuUslugPrzesylowych = Double.parseDouble(oknokosztyZakupuUslugPrzesylowych.getText());
					//koniec dodane
					
					
					kosztmiesieczny = zuzycieMiesiecznekWh *  (cenakWh /*dodane*/ + podatekVat + akcyza + 
					podatkiIoplatyLokalne + kosztyWlasneIspolkiDystrybucyjnej + marzaSpolkiDystrybucyjnej + 
					kosztyZakupuUslugPrzesylowych );
					System.out.println(kosztmiesieczny);
					// wywalanie tekstu na okienka
					oknozuzyciekWhmiesieczne.setText("");
					oknozuzyciekWhmiesieczne.setText(Double.toString(zuzycieMiesiecznekWh));

					kosztmiesieczny *= 100;
					kosztmiesieczny = (double) Math.round(kosztmiesieczny);
					kosztmiesieczny /= 100;
					System.out.println(kosztmiesieczny);
			
					name =txtUrzdzenie.getText();

					oknomiesiecznykoszt.setText("");
					oknomiesiecznykoszt.setText(Double.toString(kosztmiesieczny));
//					textArea.append(Double.toString(kosztmiesieczny));
					suma+=kosztmiesieczny;
					suma *= 100;
					suma = (double) Math.round(suma);
					suma /= 100;
					System.out.println(suma);
					textArea.append("Moc[W]:" + " " + moc + "   " + "Cena kWh [zl]" + "   " + cenakWh + "   "
							+ "Miesieczne zuzycie energii [kWh]" + "   " + zuzycieMiesiecznekWh + "   " +"Miesieczny koszt zuzycia energii [zl]" + kosztmiesieczny + " suma:"+suma+ "" +/*" Urzdzenie" +*/" "+name +
					"Podatek Vat [zl/kWh]" + " " + podatekVat + " " + "Akcyza [zl/kWh]" + " " + akcyza + " "
			+ "Podateki i oplaty lokalne [zl/kWh]" + " " + podatkiIoplatyLokalne + " "
	+"Kosty wlasne i splki dystrybucyjnej [zl/kWh]" + " " + kosztyWlasneIspolkiDystrybucyjnej + " "
    +"Marza spoki dystrybucyjnej [zl/kWh]" + " " + marzaSpolkiDystrybucyjnej + " "
	+"Koszty zakupu uslug przesylowych [zl/kWh]" + " " + kosztyZakupuUslugPrzesylowych +
							"\n");

							
						
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sprawdz poprawnosc wprowadzonych danych.");
					e.printStackTrace();
				}
			}
		});
		btnObliczzuzycie1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_btnObliczzuzycie1 = new GridBagConstraints();
		gbc_btnObliczzuzycie1.gridheight = 2;
		gbc_btnObliczzuzycie1.fill = GridBagConstraints.BOTH;
		gbc_btnObliczzuzycie1.insets = new Insets(0, 0, 5, 0);
		gbc_btnObliczzuzycie1.gridx = 5;
		gbc_btnObliczzuzycie1.gridy = 1;
		frame.getContentPane().add(btnObliczzuzycie1, gbc_btnObliczzuzycie1);

    //	textArea = new JTextArea();
	//	textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
	//	textArea.setLineWrap(true); //zawijanie wierszy
	//	GridBagConstraints gbc_textArea = new GridBagConstraints();
	//	gbc_textArea.gridwidth = 6;
	//	gbc_textArea.fill = GridBagConstraints.BOTH;
	//	gbc_textArea.gridx = 0;
    //	gbc_textArea.gridy = 3;
	//	frame.getContentPane().add(textArea, gbc_textArea);
		
	}

	public JTextArea getMoc() {
		return oknomoc;
	}

	public JTextArea getCenakWh() {
		return oknocenakWh;
	}
	
	//dodane
		public JTextArea getpodatekVat() {
			return oknopodatekVat;
		}
		
		public JTextArea getAkcyza() {
			return oknoakcyza;
		}
		
		public JTextArea getpodatkiIoplatyLokalne() {
			return oknopodatkiIoplatyLokalne;
		}
		
		public JTextArea getkosztyWlasneIspolkiDystrybucyjnej() {
			return oknokosztyWlasneIspolkiDystrybucyjnej;
		}
		
		public JTextArea getmarzaSpolkiDystrybucyjnej() {
			return oknomarzaSpolkiDystrybucyjnej;
		}
		
		public JTextArea getkosztyZakupuUslugPrzesylowych() {
			return oknokosztyZakupuUslugPrzesylowych;
		}
		
		//koniec dodane

	public JTextArea getGodzinyPracyTygodniowo() {
		return oknogodzinyPracyTygodniowo;
	}

	public JTextArea getZuzyciekWhroczne() {
		return oknozuzyciekWhmiesieczne;
	}

	public JTextArea getRocznykoszt() {
		return oknomiesiecznykoszt;
	}


	public JTextArea getTextArea() {
		return textArea;
	}

	public JTextField getTxtUrzdzenie() {
		return txtUrzdzenie;
	}
}
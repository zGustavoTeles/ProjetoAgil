package com.medicacao;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Button;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.ListBox;
import totalcross.ui.ProgressBar;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class Medicacao extends totalcross.ui.Window {
	

	private Button						 btnVoltar;
	private Button						 btnAlterar;
	private Button						 btnRemover;
	public ImageControl 		         imgMedicacao;
	private ListBox 					 lstLog;
	
	public  static Grid					 gridAnimais;
	public static String				 codigoRebanho;
	public static String				 quantidadeRebanho;
	
	public ProgressBar 					 pBAftosa;
	public ProgressBar 					 pBRaiva;
	
	public static double 				 qntVacinadosAftosa = 0.0;
	public static double 				 qntVacinadosRaiva = 0.0;
	public static double 			     qntNaoVacinadosAftosa = 0.0;
	public static double 			     qntNaoVacinadosRaiva = 0.0;
	
	public static double 			     qntTotalVacinadosAftosa = 0.0;
	public static double 				 qntTotalVacinadosRaiva = 0.0;
	
	public static int 			     	 qntTotalVacinadosAftosaInt = 0;
	public static int 				 	 qntTotalVacinadosRaivaInt = 0;
	
	public static int 			     	 qntTotalAftosa = 0;
	public static int 				 	 qntTotalRaiva  = 0;
	
	public Medicacao() {
		super("Medicação", TAB_ONLY_BORDER);
		setBackColor(0x1c355d);
		initUI();

	}

	public void initUI() {

		try {

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);

			int gridWidths[] = new int[4];
			gridWidths[0] = 200;
			gridWidths[1] = 200;
			gridWidths[2] = 200;
			gridWidths[3] = 200;

			String[] caps = {"DESCRIÇÃO","RAÇA", "AFTOSA", "RAIVA" };
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT};
			gridAnimais = new Grid(caps, gridWidths, aligns, false);
			add(gridAnimais);
			gridAnimais.enableColumnResize = true;
			gridAnimais.secondStripeColor = Color.getRGB(255, 255, 255);
			gridAnimais.setBackColor(Auxiliares.backColorGridNovo);
			gridAnimais.setForeColor(Auxiliares.defaultForeColorGridNovo);
			gridAnimais.transparentBackground = false;
			gridAnimais.setBorderStyle(totalcross.ui.Container.BORDER_NONE);
			gridAnimais.verticalLineStyle = totalcross.ui.Grid.VERT_LINE;
			gridAnimais.drawCheckBox = true;
			gridAnimais.disableSort = false;
			gridAnimais.boldCheck = false;
			gridAnimais.captionsBackColor = Auxiliares.captionsBackColorNovo;
			gridAnimais.checkColor = Auxiliares.checkColorNovo;
			gridAnimais.firstStripeColor = Auxiliares.firstStripeColorNovo;
			gridAnimais.enableColumnResize = false;
			gridAnimais.setFont(Auxiliares.getFontNormal().asBold());
			gridAnimais.secondStripeColor = Auxiliares.secondStripeColorNovo;
			gridAnimais.setCellController(new CellController6());
			gridAnimais.setRect(Grid.LEFT + 15, TOP + 20, SCREENSIZE + 40, SCREENSIZE + 90, btnVoltar);
			
			pBAftosa = new ProgressBar();
			pBAftosa.vertical = false;
			pBAftosa.suffix = " %";
			pBAftosa.prefix = "Animais vacindados contra Aftosa... ";
			pBAftosa.textColor = Color.BLACK;
			pBAftosa.setForeColor(0xfcd462);
			pBAftosa.setBackColor(Color.WHITE);
			add(pBAftosa, AFTER + 30, SAME, SCREENSIZEMAX + 50, SCREENSIZE + 7, gridAnimais);
			
			pBRaiva = new ProgressBar();
			pBRaiva.vertical = false;
			pBRaiva.suffix = " %";
			pBRaiva.prefix = "Animais vacindados contra Raiva... ";
			pBRaiva.textColor = Color.BLACK;
			pBRaiva.setBackColor(Color.WHITE);
			pBRaiva.setForeColor(0x27a2db);
			add(pBRaiva, SAME, AFTER + 10, SCREENSIZEMAX + 50, SCREENSIZE + 7, pBAftosa);
			
			imgMedicacao = new ImageControl(new Image("img/medicacaoCapa.png"));
			imgMedicacao.scaleToFit = true;
			imgMedicacao.centerImage = true;
	        add(imgMedicacao, RIGHT - 40, AFTER + 20, SCREENSIZE + 50, SCREENSIZE + 50, pBRaiva);

			reposition();
			
			buscaAnimaisCadastrados();
			pBAftosa.setValue(qntTotalVacinadosAftosaInt);
			pBRaiva.setValue(qntTotalVacinadosRaivaInt);

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao construir tela menu\n" + e);

		}

	}
	
	public void reposition() {	
		super.reposition();
		repaintNow();
	}
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				}
			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação do menu\n" + e);
		}

	}
	
	public static void buscaAnimaisCadastrados() {
		
		String sql 		     = "";
		LitebasePack lb		 = null;
		ResultSet rs		 = null;

		try {
			try {

				gridAnimais.removeAllElements();

				lb = new LitebasePack();

				if (lb.exists("REBANHO")) {
					sql = " SELECT * FROM REBANHO";

					rs = lb.executeQuery(sql);
					rs.first();
					
					if (rs.getRowCount() > 0) {

						/*
						 * Primeiro zero os valores
						 */

						qntVacinadosAftosa 			= 0.0;
						qntVacinadosRaiva 			= 0.0;
						qntNaoVacinadosAftosa 		= 0.0;
						qntNaoVacinadosRaiva 		= 0.0;
						qntTotalVacinadosAftosa 	= 0.0;
						qntTotalVacinadosRaiva 		= 0.0;
						qntTotalVacinadosAftosaInt 	= 0;
						qntTotalVacinadosRaivaInt 	= 0;

						for (int i = 0; rs.getRowCount() > i; i++) {
							String[] b = new String[4];
							b[0] = rs.getString("DESCRICAO");
							b[1] = rs.getString("RACA");
							b[2] = rs.getString("AFTOSA");
							b[3] = rs.getString("RAIVA");
							gridAnimais.add(b);

							/*
							 * calculo os valor de vacinados e não vacinados
							 */

							if (rs.getString("AFTOSA").equals("VACINOU")) {
								qntVacinadosAftosa++;

							} else {
								qntNaoVacinadosAftosa++;
							}

							if (rs.getString("RAIVA").equals("VACINOU")) {
								qntVacinadosRaiva++;

							} else {
								qntNaoVacinadosRaiva++;
							}

							rs.next();
						}

						/*
						 * calculo a porcentagem de vacinados e não vacinados
						 */

						qntTotalAftosa = (int) (qntNaoVacinadosAftosa + qntVacinadosAftosa);
						qntTotalVacinadosAftosa = (qntVacinadosAftosa * 100 / qntTotalAftosa);

						qntTotalRaiva = (int) (qntNaoVacinadosRaiva + qntVacinadosRaiva);
						qntTotalVacinadosRaiva = (qntVacinadosRaiva * 100 / qntTotalRaiva);

						qntTotalVacinadosAftosaInt = Convert.toInt(Convert.toString(qntTotalVacinadosAftosa)
								.substring(0, Convert.toString(qntTotalVacinadosAftosa).indexOf(".")));
						qntTotalVacinadosRaivaInt = Convert.toInt(Convert.toString(qntTotalVacinadosRaiva).substring(0,
								Convert.toString(qntTotalVacinadosRaiva).indexOf(".")));

					}
				}

			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO",
					"Erro buscaAnimaisCadastrados\n" + e);
		}

	}
}

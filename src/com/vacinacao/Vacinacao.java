package com.vacinacao;

import com.auxiliares.Auxiliares;
import com.baseContainer.BaseContainer;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.litebase.LitebasePack;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Bar;
import totalcross.ui.Button;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.ListBox;
import totalcross.ui.ProgressBar;
import totalcross.ui.Window;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class Vacinacao extends totalcross.ui.Window {
	

	private Button						 btnVoltar;
	private Button						 btnAlterar;
	private Button						 btnRemover;
	public ImageControl 		         imgAnimais;
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
	
	public Vacinacao() {
		super("VACINAÇÃO", TAB_ONLY_BORDER);
		setBackColor(0x1c355d);
		initUI();

	}

	public void initUI() {

		try {

			imgAnimais = new ImageControl(new Image("img/vacinacaoCapa.png"));
			imgAnimais.scaleToFit = true;
			imgAnimais.centerImage = true;
	        add(imgAnimais, CENTER, TOP, SCREENSIZE + 30, SCREENSIZE + 30);

			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
			
//			pBRaiva = new ProgressBar();
//			pBRaiva.vertical = false;
//			pBRaiva.suffix = " %";
//			pBRaiva.prefix = "Animais vacindados contra Raiva... ";
//			pBRaiva.textColor = Color.BLACK;
//			pBRaiva.setBackColor(Color.WHITE);
//			pBRaiva.setForeColor(0x27a2db);
//			add(pBRaiva, LEFT + 15, BOTTOM - 30, SCREENSIZEMAX + 50, SCREENSIZE + 7);
//
//			pBAftosa = new ProgressBar();
//			pBAftosa.vertical = false;
//			pBAftosa.suffix = " %";
//			pBAftosa.prefix = "Animais vacindados contra Aftosa... ";
//			pBAftosa.textColor = Color.BLACK;
//			pBAftosa.setForeColor(0xfcd462);
//			pBAftosa.setBackColor(Color.WHITE);
//			add(pBAftosa, LEFT + 15, BEFORE - 20, SCREENSIZEMAX + 50, SCREENSIZE + 7, pBRaiva);

			int gridWidths[] = new int[14];
			gridWidths[0] = 5;
			gridWidths[1] = 200;
			gridWidths[2] = 200;
			gridWidths[3] = 200;
			gridWidths[4] = 100;
			gridWidths[5] = 200;
			gridWidths[6] = 50;
			gridWidths[7] = 300;
			gridWidths[8] = 100;
			gridWidths[9] = 100;
			gridWidths[10] = 100;
			gridWidths[11] = 200;
			gridWidths[12] = 200;
			gridWidths[13] = 200;

			String[] caps = { "CODIGO", "DESCRIÇÃO", "QUANTIDADE.", "IDADE", "SEXO.", "RAÇA", "PESO", "DATA COMPRA",
					"PREÇO COMPRA", "PREÇO ATUAL", "STATUS", "PASTAGEM", "AFTOSA", "RAIVA" };
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT,
					Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT };
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
			gridAnimais.setRect(Grid.CENTER + 1, TOP + 200, SCREENSIZE + 100, SCREENSIZE + 50, btnVoltar);

			reposition();
			
			buscaAnimaisCadastrados();
//			pBAftosa.setValue(qntTotalVacinadosAftosaInt);
//			pBRaiva.setValue(qntTotalVacinadosRaivaInt);

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

//					/*
//					 * Primeiro zero os valores
//					 */
//
//					qntVacinadosAftosa 			= 0.0;
//					qntVacinadosRaiva 			= 0.0;
//					qntNaoVacinadosAftosa 		= 0.0;
//					qntNaoVacinadosRaiva 		= 0.0;
//					qntTotalVacinadosAftosa 	= 0.0;
//					qntTotalVacinadosRaiva 		= 0.0;
//					qntTotalVacinadosAftosaInt  = 0;
//					qntTotalVacinadosRaivaInt   = 0;

					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[14];
						b[0] = Convert.toString(rs.getInt("CODIGO"));
						b[1] = rs.getString("DESCRICAO");
						b[2] = Convert.toString(rs.getInt("QUANTIDADE"));
						b[3] = rs.getString("IDADE");
						b[4] = rs.getString("SEXO");
						b[5] = rs.getString("RACA");
						b[6] = rs.getString("PESO");
						b[7] = rs.getString("DATACOMPRA");
						b[8] = rs.getString("PRECOCOMPRA");
						b[9] = rs.getString("PRECOATUAL");
						b[10] = rs.getString("STATUS");
						b[11] = rs.getString("PASTAGEM");
						b[12] = rs.getString("AFTOSA");
						b[13] = rs.getString("RAIVA");
						gridAnimais.add(b);

//						/*
//						 * calculo os valor de vacinados e não vacinados
//						 */
//
//						if (rs.getString("AFTOSA").equals("VACINOU")) {
//							qntVacinadosAftosa++;
//
//						} else {
//							qntNaoVacinadosAftosa++;
//						}
//
//						if (rs.getString("RAIVA").equals("VACINOU")) {
//							qntVacinadosRaiva++;
//
//						} else {
//							qntNaoVacinadosRaiva++;
//						}

						rs.next();
					}

//					/*
//					 * calculo a porcentagem de vacinados e não vacinados
//					 */
//
//					qntTotalAftosa = (int) (qntNaoVacinadosAftosa + qntVacinadosAftosa);
//					qntTotalVacinadosAftosa = (qntVacinadosAftosa * 100 / qntTotalAftosa);
//
//					qntTotalRaiva = (int) (qntNaoVacinadosRaiva + qntVacinadosRaiva);
//					qntTotalVacinadosRaiva = (qntVacinadosRaiva * 100 / qntTotalRaiva);
//
//					qntTotalVacinadosAftosaInt = Convert.toInt(Convert.toString(qntTotalVacinadosAftosa).substring(0,
//							Convert.toString(qntTotalVacinadosAftosa).indexOf(".")));
//					qntTotalVacinadosRaivaInt = Convert.toInt(Convert.toString(qntTotalVacinadosRaiva).substring(0,
//							Convert.toString(qntTotalVacinadosRaiva).indexOf(".")));

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

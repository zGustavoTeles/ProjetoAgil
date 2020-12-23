package com.tabelaDeAnimais;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.litebase.LitebasePack;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;

import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class TabelaDeAnimais extends totalcross.ui.Window {
	

	private Button						 btnVoltar;
	private Button						 btnAlterar;
	private Button						 btnRemover;
	
	public ImageControl 		         imgAnimais;
	
	public  static Grid					 gridAnimais;
	public static String				 codigoRebanho;
	public static String				 quantidadeRebanho;

	public TabelaDeAnimais() {
		super("TABELA DE ANIMAIS", TAB_ONLY_BORDER);
		setBackColor(0x1c355d);
		initUI();
		buscaAnimaisCadastrados();

	}

	public void initUI() {

		try {

			imgAnimais = new ImageControl(new Image("img/animais.png"));
			imgAnimais.scaleToFit = true;
			imgAnimais.centerImage = true;
	        add(imgAnimais, CENTER, TOP, SCREENSIZE + 20, SCREENSIZE + 20);

	        btnAlterar = BottomImg.imageWithText(new Image("img/alterar.png"), "Alterar", Button.BOTTOM);
			add(btnAlterar, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnAlterar.setBackColor(0x1c355d);
			btnAlterar.setForeColor(Color.WHITE);
			
			btnRemover = BottomImg.imageWithText(new Image("img/remover.png"), "Remover", Button.BOTTOM);
			add(btnRemover, AFTER, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnRemover.setBackColor(0x1c355d);
			btnRemover.setForeColor(Color.WHITE);
			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
			
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

			String[] caps = { "CODIGO", "DESCRIÇÃO", "QUANTIDADE.", "IDADE", "SEXO.", "RAÇA", "PESO", "DATA COMPRA", "PREÇO COMPRA", "PREÇO ATUAL", "STATUS", "PASTAGEM", "AFTOSA", "RAIVA" };
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT};
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
			gridAnimais.setRect(Grid.CENTER + 1, BEFORE - 5, SCREENSIZE + 100, SCREENSIZE + 65, btnVoltar);
		
			reposition();
			
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao construir tela menu\n" + e);

		}

	}
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnAlterar) {
					
					if (gridAnimais.getSelectedItem() != null) {
						
						codigoRebanho 					= gridAnimais.getSelectedItem()[0];
						quantidadeRebanho 	 			= gridAnimais.getSelectedItem()[2];
						AlterarAnimal alterarAnimal 	= new AlterarAnimal();
						alterarAnimal.popup();

					} else {

						Auxiliares.messagebox("AGIL", "Deve-se selecionar um cadastro para alterar!");
					}
				} else if (evt.target == btnRemover) {
					
					if (gridAnimais.getSelectedItem() != null) {

						codigoRebanho	  	 			= gridAnimais.getSelectedItem()[0];
						quantidadeRebanho 	 			= gridAnimais.getSelectedItem()[2];
						RemoverAnimal removerAnimal 	= new RemoverAnimal();
						removerAnimal.popup();

					} else {

						Auxiliares.messagebox("AGIL", "Deve-se selecionar um cadastro para remover!");
					}
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
		String dataCompra	 = "";

		try {
			try {
				
				gridAnimais.removeAllElements();
				
				lb = new LitebasePack();
				
				if (lb.exists("REBANHO")) {
					sql = " SELECT * FROM REBANHO";

					rs = lb.executeQuery(sql);
					rs.first();

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
						b[9] = rs.getString("PRECOVENDA");
						b[10] = rs.getString("STATUS");
						b[11] = rs.getString("PASTAGEM");
						b[12] = rs.getString("AFTOSA");
						b[13] = rs.getString("RAIVA");
						gridAnimais.add(b);
						rs.next();
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

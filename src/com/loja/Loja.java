package com.loja;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.litebase.LitebasePack;
import com.menu.Menu;

import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class Loja extends totalcross.ui.Window{
	
	private Label 							lblAnimal;
	private Label							lblCodigo;
	private Button							btnBuscarAnimal;
	private Button							btnBuscaCodigo;
	private Edit							editBuscarAnimal;
	private Edit							editBuscaCodigo;
	private Button 						    btnVoltar;
	public Button							btnInserirAnimalCarrinho;
	
	public static Grid					    gridAnimais;
	public static Button					btnCarrinho;
	public static String					codigo = "";
	public static String					produto = "";
	public static String					quantidade = "";
	public static String				    valor = "";
	public static String					categoria = "";
	public static String					marca = "";
	public static String  					descricao;
	
	public Loja(){
		 setBackColor(0x1c355d); 
		 initUI();
		 buscaAnimaisCadastrados();
	}
	
	public void initUI() {
		
		try {
					
//			lblCategoria = new Label("CATEGORIA:");
//			add(lblCategoria);
//			lblCategoria.setRect(LEFT, TOP + 5, PREFERRED, PREFERRED);
//			lblCategoria.setBackColor(0x003366);
//			lblCategoria.setForeColor(Color.WHITE);
//			
//			cmbCategoria = new ComboBox();
//			add(cmbCategoria);
//			cmbCategoria.setRect(LEFT, AFTER + 5, FILL + 5, PREFERRED, lblCategoria);
			
			lblAnimal = new Label("ANIMAL");
			add(lblAnimal);
			lblAnimal.setRect(LEFT, TOP + 5, PREFERRED, PREFERRED);
			lblAnimal.setBackColor(0x003366);
			lblAnimal.setForeColor(Color.WHITE);
			
			editBuscarAnimal = new Edit();
			add(editBuscarAnimal);
			editBuscarAnimal.capitalise = (Edit.ALL_UPPER);
			editBuscarAnimal.setRect(LEFT, AFTER + 5, SCREENSIZE + 80, PREFERRED, lblAnimal);
			editBuscarAnimal.setBackColor(Color.WHITE);
			editBuscarAnimal.setForeColor(0x003366);

			btnBuscarAnimal = new Button("BUSCAR");
			add(btnBuscarAnimal);
			btnBuscarAnimal.setRect(AFTER + 1, SAME, SCREENSIZE + 20, PREFERRED, editBuscarAnimal);
			btnBuscarAnimal.setBackColor(0x003366);
	        btnBuscarAnimal.setForeColor(Color.WHITE);
	        
	        lblCodigo = new Label("CÓDIGO");
			add(lblCodigo);
			lblCodigo.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, editBuscarAnimal);
			lblCodigo.setBackColor(0x003366);
			lblCodigo.setForeColor(Color.WHITE);
			
			editBuscaCodigo = new Edit();
			add(editBuscaCodigo);
			editBuscaCodigo.capitalise = (Edit.ALL_UPPER);
			editBuscaCodigo.setRect(LEFT, AFTER + 5, SCREENSIZE + 80, PREFERRED, lblCodigo);
			editBuscaCodigo.setBackColor(Color.WHITE);
			editBuscaCodigo.setForeColor(0x003366);
			editBuscaCodigo.setValidChars("0123456789");

			btnBuscaCodigo = new Button("BUSCAR");
			add(btnBuscaCodigo);
			btnBuscaCodigo.setRect(AFTER + 1, SAME, SCREENSIZE + 20, PREFERRED, editBuscaCodigo);
			btnBuscaCodigo.setBackColor(0x003366);
			btnBuscaCodigo.setForeColor(Color.WHITE);
			
			btnInserirAnimalCarrinho = BottomImg.imageWithText(new Image("img/adicionarCarrinho.png"), "Inserir", Button.BOTTOM);
			add(btnInserirAnimalCarrinho, LEFT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnInserirAnimalCarrinho.setBackColor(0x1c355d);
			btnInserirAnimalCarrinho.setForeColor(Color.WHITE);
			
			btnCarrinho = BottomImg.imageWithText(new Image("img/carrinho.png"), "Carrinho", Button.BOTTOM);
			add(btnCarrinho, AFTER, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 15);
			btnCarrinho.setBackColor(0x1c355d);
			btnCarrinho.setForeColor(Color.WHITE);
			btnCarrinho.setEnabled(false);
			
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
			editBuscarAnimal.requestFocus();
			
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO","Erro ao construir a tela venda\n" + e);
			
		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:
				
			if(evt.target == btnVoltar) {
				unpop();
			}

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela venda\n" + e);
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

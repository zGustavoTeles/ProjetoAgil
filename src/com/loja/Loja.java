package com.loja;

import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class Loja extends totalcross.ui.Window {

	private Label 						lblAnimal;
	private Label 						lblCodigo;
	private Button 						btnBuscaAnimal;
	private Button 						btnBuscaCodigo;
	private Edit 						editBuscarAnimal;
	private Edit 						editBuscaCodigo;
	private Button 						btnVoltar;
	public Button 						btnInserirAnimalCarrinho;

	public static Grid 					gridAnimais;
	public static Button 				btnCarrinho;
	
	public static String 				codigo = "";

	public Loja() {
		setBackColor(0x1c355d);
		initUI();
		habilitaCarrinho();
	}

	public void initUI() {

		try {

			lblAnimal = new Label("BUSCAR POR ANIMAL:");
			add(lblAnimal);
			lblAnimal.setRect(LEFT, TOP + 5, PREFERRED, PREFERRED);
			lblAnimal.setBackColor(0x1c355d);
			lblAnimal.setForeColor(Color.WHITE);

			editBuscarAnimal = new Edit();
			add(editBuscarAnimal);
			editBuscarAnimal.capitalise = (Edit.ALL_UPPER);
			editBuscarAnimal.setRect(LEFT, AFTER + 5, SCREENSIZE + 80, PREFERRED, lblAnimal);
			editBuscarAnimal.setBackColor(Color.WHITE);
			editBuscarAnimal.setForeColor(0x1c355d);
			editBuscarAnimal.setValidChars("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 1 2 3 4 5 6 7 8 9 0");

			btnBuscaAnimal = new Button("BUSCAR");
			add(btnBuscaAnimal);
			btnBuscaAnimal.setRect(AFTER + 15, SAME, SCREENSIZE + 15, PREFERRED, editBuscarAnimal);
			btnBuscaAnimal.setBackColor(0x003366);
			btnBuscaAnimal.setForeColor(Color.WHITE);

			lblCodigo = new Label("BUSCAR POR CÓDIGO:");
			add(lblCodigo);
			lblCodigo.setRect(LEFT, AFTER + 5, PREFERRED, PREFERRED, editBuscarAnimal);
			lblCodigo.setBackColor(0x1c355d);
			lblCodigo.setForeColor(Color.WHITE);

			editBuscaCodigo = new Edit();
			add(editBuscaCodigo);
			editBuscaCodigo.capitalise = (Edit.ALL_UPPER);
			editBuscaCodigo.setRect(LEFT, AFTER + 5, SCREENSIZE + 80, PREFERRED, lblCodigo);
			editBuscaCodigo.setBackColor(Color.WHITE);
			editBuscaCodigo.setForeColor(0x1c355d);
			editBuscaCodigo.setValidChars("0123456789");

			btnBuscaCodigo = new Button("BUSCAR");
			add(btnBuscaCodigo);
			btnBuscaCodigo.setRect(AFTER + 15, SAME, SCREENSIZE + 15, PREFERRED, editBuscaCodigo);
			btnBuscaCodigo.setBackColor(0x003366);
			btnBuscaCodigo.setForeColor(Color.WHITE);

			btnInserirAnimalCarrinho = BottomImg.imageWithText(new Image("img/adicionarCarrinho.png"), "Inserir",
					Button.BOTTOM);
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

			String[] caps = { "CODIGO", "DESCRIÇÃO", "QUANTIDADE.", "IDADE", "SEXO.", "RAÇA", "PESO", "DATA COMPRA",
					"PREÇO COMPRA", "PREÇO VENDA", "STATUS", "PASTAGEM", "AFTOSA", "RAIVA" };
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
			gridAnimais.setRect(Grid.CENTER + 1, BEFORE - 5, SCREENSIZE + 100, SCREENSIZE + 65, btnVoltar);

			reposition();
			editBuscarAnimal.requestFocus();

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao construir a tela venda\n" + e);

		}

	}

	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnBuscaAnimal) {
					gridAnimais.removeAllElements();
					buscaAnimalPorDescricao();

				} else if (evt.target == btnBuscaCodigo) {
					gridAnimais.removeAllElements();
					buscaAnimalPorCodigo();

				} else if (evt.target == btnInserirAnimalCarrinho) {

					if (gridAnimais.getSelectedItem() != null) {
						
						boolean animalInseridoCarrinho = false;
						animalInseridoCarrinho = validaAnimalCarrinho(animalInseridoCarrinho);

						if (animalInseridoCarrinho == false) {
							
							InserirAnimalCarrinho insereAnimalCarrinho = new InserirAnimalCarrinho();
							insereAnimalCarrinho.popup();

						} else {

							Auxiliares.messagebox("AGIL",
									"Este animal encontra-se no carrinho. Por favor finalize a venda para inseri-lo novamente!");
						}

					} else {
						Auxiliares.messagebox("AGIL", "Deve-se selecionar um animal!");
					}

				} else if (evt.target == btnCarrinho) {
					
					gridAnimais.removeAllElements();
					
					Carrinho carrinho = new Carrinho();
					carrinho.popup();
					
				}
				break;

			case ControlEvent.FOCUS_IN:

			}
			switch (evt.type) {
			case GridEvent.SELECTED_EVENT:
				if (evt.target == gridAnimais) {

					try {
						
					    codigo						= gridAnimais.getSelectedItem()[0];
						
					} catch (Exception e) {
						Auxiliares.messagebox("AGIL", "Clique em um animal!");
					}

				}

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela Loja\n" + e);
		}

	}

	public void buscaAnimalPorDescricao() {

		String sql 				= "";
		LitebasePack lb 		= null;
		ResultSet rs 			= null;

		try {
			try {

				gridAnimais.removeAllElements();

				lb = new LitebasePack();

				if (editBuscarAnimal.getText().equals("")) {

					sql = "SELECT * FROM REBANHO";

				} else {

					sql = " SELECT * FROM REBANHO WHERE DESCRICAO LIKE " + "'%" + editBuscarAnimal.getText() + "%'"
							+ " OR IDADE LIKE " + "'%" + editBuscarAnimal.getText() + "%'" + "OR RACA LIKE " + "'%"
							+ editBuscarAnimal.getText() + " %'" + "OR PASTAGEM LIKE " + "'%" + editBuscarAnimal.getText()
							+ " %'" + " OR STATUS LIKE " + "'%" + editBuscarAnimal.getText() + "%'";
				}

				editBuscarAnimal.setText("");
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
			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao buscaAnimalPorDescricao\n" + e);
			editBuscarAnimal.setText("");

		}

	}

	public void buscaAnimalPorCodigo() {

		String sql 				= "";
		LitebasePack lb 		= null;
		ResultSet rs 			= null;

		try {
			try {

				gridAnimais.removeAllElements();

				lb = new LitebasePack();

				if (editBuscaCodigo.getText().equals("")) {

					sql = "SELECT * FROM REBANHO";

				} else {
					
					sql = " SELECT * FROM REBANHO WHERE CODIGO = " + editBuscaCodigo.getText();

//					sql = " SELECT * FROM REBANHO WHERE CODIGO = " + editBuscaCodigo.getText()
//							+ " OR IDADE LIKE " + "'%" + editBuscarAnimal.getText() + "%'" + "OR RACA LIKE " + "'%"
//							+ editBuscarAnimal.getText() + " %'" + "OR PASTAGEM LIKE " + "'%" + editBuscarAnimal.getText()
//							+ " %'" + " OR STATUS LIKE " + "'%" + editBuscarAnimal.getText() + "%'" + " OR DESCRICAO LIKE " + "'%"
//							+ editBuscarAnimal.getText() + "%'";
				}

				editBuscaCodigo.setText("");
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
			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO",
					"Erro ao buscaAnimalPorCodigo\n" + e + "\nPor favor digite um código válido!");
			editBuscaCodigo.setText("");
		}

	}

	public boolean validaAnimalCarrinho(boolean animalInseridoCarrinho) {

		String sql 				= "";
		LitebasePack lb 		= null;
		ResultSet rs 			= null;

		try {

			try {

				lb = new LitebasePack();

				sql = "SELECT * FROM VENDAANIMALTEMP WHERE CODIGOANIMAL = " + codigo;

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					return animalInseridoCarrinho = false;

				} else {

					return animalInseridoCarrinho = true;
				}

			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro validaAnimalCarrinho\n" + e);
		}
		return animalInseridoCarrinho;

	}

	public void habilitaCarrinho() {

		String sql 				= "";
		LitebasePack lb 		= null;
		ResultSet rs 			= null;

		try {

			try {

				lb = new LitebasePack();

				sql = "SELECT * FROM VENDAANIMALTEMP";

				rs = lb.executeQuery(sql);
				rs.first();

				if (rs.getRowCount() == 0) {
					return;

				} else {
					btnCarrinho.setEnabled(true);
				}

			} finally {
				if (lb != null) {
					lb.closeAll();
				}
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao habilitaCarrinho\n" + e);
		}

	}

}

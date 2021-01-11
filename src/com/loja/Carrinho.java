package com.loja;


import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.cellcontroller6.CellController6;
import com.litebase.LitebasePack;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.ui.Button;
import totalcross.ui.Edit;
import totalcross.ui.Grid;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.event.GridEvent;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class Carrinho extends totalcross.ui.Window{
	
	private Label							lblQuantidade;
	private Label							lblTotal;
	private Edit							editQntAnimais;
	private Edit							editTotalVenda;
	private Button 							btnVoltar;
	private Button							btnVender;
	private Button							btnAlterar;
	private Button							btnRemover;
	public Grid							    gridCarrinho;
	public ImageControl					    imgCarrinho;
	
	public int 						        qntEstoqueCalculo = 0;
	public int  				 			quantidadeVendida = 0;
	public int								quantidadeCarrinho = 0;
	public double							precoVendaAnimal;
	public double							totalCarrinho = 0.0;
	
	public int	 						 	codigoVendaInfo = 0;
	public int	 				 			codigoAnimalInfo = 0;
	public String 				 			descricaoInfo = "";
	public String	 			 			idadeInfo = "";
	public String 				 			sexoInfo = "";
	public String 				 			racaInfo = "";
	public String 				 			pesoInfo = "";
	public String 				 			dataDaCompraInfo = "";
	public String 				 			precocompraInfo = "";
	public String 				 			precoVendaInfo = "";
	public String 				 			statusInfo = "";
	public String 				 			pastagemInfo = "";
	public String 				 			aftosaInfo = "";
	public String 				 			raivaInfo = "";
	public int	 				 			quantidadeVendidaInfo = 0;
	public String 				 			dataVendaInfo = "";
	public String 				 			tipopagamentoInfo = "";
	public String 				 			totalInfo = "";
	public double 				 			totalInfoCalc = 0.00;
	
	public int								qntDeAnimaisVendidos = 0;
	public double							valorTotalDevendas = 0.00;
	
	
	public static String					codigoVenda = "";
	public static String					codigoAnimal = "";
	
	public Carrinho(){
		 super("CARRINHO", TAB_ONLY_BORDER);
		 setBackColor(0x1c355d);
		 initUI();
		 
	}
	
	public void initUI() {
		
		try {
					
//			lblQuantidade = new Label("");
//			add(lblQuantidade);
//			lblQuantidade.setRect(LEFT + 2, TOP + 5, PREFERRED, PREFERRED);
//			lblQuantidade.setBackColor(0x1c355d);
//			lblQuantidade.setForeColor(Color.WHITE);
//			
//			lblTotal = new Label("");
//			add(lblTotal);
//			lblTotal.setRect(LEFT + 2, AFTER + 5, PREFERRED, PREFERRED, lblQuantidade);
//			lblTotal.setBackColor(0x1c355d);
//			lblTotal.setForeColor(Color.WHITE);
			
			editQntAnimais = new Edit();
			add(editQntAnimais);
			editQntAnimais.setEditable(false);
			editQntAnimais.setRect(LEFT + 10, TOP + 10, SCREENSIZE + 40, PREFERRED);
			editQntAnimais.setBackColor(0x1c355d);
			editQntAnimais.setForeColor(Color.BLACK);
			
			editTotalVenda = new Edit();
			add(editTotalVenda);
			editTotalVenda.setEditable(false);
			editTotalVenda.setRect(LEFT + 10, AFTER + 15, SCREENSIZE + 40, PREFERRED, editQntAnimais);
			editTotalVenda.setBackColor(0x1c355d);
			editTotalVenda.setForeColor(Color.BLACK);
			
			imgCarrinho = new ImageControl(new Image("img/carrinhoCapa.png"));
			imgCarrinho.scaleToFit = true;
			imgCarrinho.centerImage = true;
			add(imgCarrinho, RIGHT + 10, TOP, SCREENSIZE + 15, SCREENSIZE + 15);
            
			btnVender = BottomImg.imageWithText(new Image("img/confirmar.png"), "Vender", Button.BOTTOM);
			add(btnVender, LEFT, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnVender.setBackColor(0x1c355d);
			btnVender.setForeColor(Color.WHITE);

			btnAlterar = BottomImg.imageWithText(new Image("img/alterar.png"), "Alterar", Button.BOTTOM);
			add(btnAlterar, AFTER + 8, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnAlterar.setBackColor(0x1c355d);
			btnAlterar.setForeColor(Color.WHITE);

			btnRemover = BottomImg.imageWithText(new Image("img/remover.png"), "Remover", Button.BOTTOM);
			add(btnRemover, AFTER + 8, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnRemover.setBackColor(0x1c355d);
			btnRemover.setForeColor(Color.WHITE);
			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 18, SCREENSIZE + 10);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);

			int gridWidths[] = new int[18];
			
			gridWidths[0]  = 5;
			gridWidths[1]  = 200;
			gridWidths[2]  = 200;
			gridWidths[3]  = 200;
			gridWidths[4]  = 100;
			gridWidths[5]  = 200;
			gridWidths[6]  = 50;
			gridWidths[7]  = 300;
			gridWidths[8]  = 100;
			gridWidths[9]  = 100;
			gridWidths[10] = 100;
			gridWidths[11] = 200;
			gridWidths[12] = 200;
			gridWidths[13] = 200;
			gridWidths[14] = 200;
			gridWidths[15] = 200;
			gridWidths[16] = 200;
			gridWidths[17] = 200;

			String[] caps = { "CÓDIGO VENDA", "CÓDIGO ANIMAL", "DESCRIÇÃO", "IDADE", "SEXO", "RAÇA", "PESO", "DATA COMPRA",
					"PREÇO COMPRA", "PREÇO VENDA", "STATUS", "PASTAGEM", "AFTOSA", "RAIVA", "QUANTIDADE VENDIDA", "DATA DA VENDA", "TIPO PAGAMENTO", "TOTAL" };
			
			int[] aligns = { Grid.LEFT, Grid.CENTER, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT,
					Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT, Grid.LEFT };
			
			gridCarrinho = new Grid(caps, gridWidths, aligns, false);
			add(gridCarrinho);
			gridCarrinho.enableColumnResize = true;
			gridCarrinho.secondStripeColor = Color.getRGB(255, 255, 255);
			gridCarrinho.setBackColor(Auxiliares.backColorGridNovo);
			gridCarrinho.setForeColor(Auxiliares.defaultForeColorGridNovo);
			gridCarrinho.transparentBackground = false;
			gridCarrinho.setBorderStyle(totalcross.ui.Container.BORDER_NONE);
			gridCarrinho.verticalLineStyle = totalcross.ui.Grid.VERT_LINE;
			gridCarrinho.drawCheckBox = true;
			gridCarrinho.disableSort = false;
			gridCarrinho.boldCheck = false;
			gridCarrinho.captionsBackColor = Auxiliares.captionsBackColorNovo;
			gridCarrinho.checkColor = Auxiliares.checkColorNovo;
			gridCarrinho.firstStripeColor = Auxiliares.firstStripeColorNovo;
			gridCarrinho.enableColumnResize = false;
			gridCarrinho.setFont(Auxiliares.getFontNormal().asBold());
			gridCarrinho.secondStripeColor = Auxiliares.secondStripeColorNovo;
			gridCarrinho.setCellController(new CellController6());
			gridCarrinho.setRect(Grid.CENTER + 1, BEFORE - 30, SCREENSIZE + 100, SCREENSIZE + 66, btnVoltar);
			
			reposition();
			
            carregaGridCarrinho();
            calculaAnimaisCarrinho();
            
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO","Erro ao construir a tela carrinho\n" + e);

		}
		
	}
	
	
	public void onEvent(Event evt) {
		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				} else if (evt.target == btnVender) {
					String[] ArtButtonArray = { "Sim", "Não" };
					
					int i = Auxiliares.messageBox("AGIL",
							"Deseja finalizar a venda?\n" + "\n" + editQntAnimais.getText() + "\n" + editTotalVenda.getText(),
							ArtButtonArray);

					if (i == 1) {
						return;
						
					} else {

						salvaInfoVenda();
						atualizaRebanho();
						
						Auxiliares.messagebox("AGIL",
								"Venda efetuada com sucesso!\n" + "\n" + editQntAnimais.getText() + "\n" + editTotalVenda.getText());

						Loja.btnCarrinho.setEnabled(false);
						unpop();
					}
				}else if(evt.target == btnAlterar) {
					if (gridCarrinho.getSelectedItem() != null) {						
						
						AlterarAnimalCarrinho alterarAnimalCarrinho = new AlterarAnimalCarrinho();
						alterarAnimalCarrinho.popup();
							
					} else {
						
						Auxiliares.messagebox("AGIL", "Deve-se selecionar um animal para alterar!");
					}
				}else if(evt.target == btnRemover) {
					
					if (gridCarrinho.getSelectedItem() != null) {						
						
						RemoverAnimalCarrinho removeAnimalCarrinho = new RemoverAnimalCarrinho();
						removeAnimalCarrinho.popup();

					} else {
						Auxiliares.messagebox("AGIL", "Deve-se selecionar um animal para remover!");
					}

				}

			}
			switch (evt.type) {
			case GridEvent.SELECTED_EVENT:
				if (evt.target == gridCarrinho) {

					try {

						codigoVenda 			 = gridCarrinho.getSelectedItem()[0];
						codigoAnimal			 = gridCarrinho.getSelectedItem()[1];

					} catch (Exception e) {
						Auxiliares.messagebox("AGIL", "Clique em um animal!");
					}

				}

			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela carrinho\n" + e);
		}

	}
	
	public void carregaGridCarrinho() {
		
		String sql 			 = "";
		LitebasePack lb		 = null;
		ResultSet rs 		 = null;

		try {
			try {
				gridCarrinho.removeAllElements();
				
				lb = new LitebasePack();
				
				sql = " SELECT * FROM VENDAANIMALTEMP";

				rs = lb.executeQuery(sql);
				rs.first();
				
				for (int i = 0; rs.getRowCount() > i; i++) {
					
					String[] b = new String[18];
					
					b[0]  = Convert.toString(rs.getInt("CODIGOVENDA"));
					b[1]  = Convert.toString(rs.getInt("CODIGOANIMAL"));
					b[2]  = rs.getString("DESCRICAO");
					b[3]  = rs.getString("IDADE");
					b[4]  = rs.getString("SEXO");
					b[5]  = rs.getString("RACA");
					b[6]  = rs.getString("PESO");
					b[7]  = rs.getString("DATACOMPRA");
					b[8]  = rs.getString("PRECOCOMPRA");
					b[9]  = rs.getString("PRECOVENDA");
					b[10] = rs.getString("STATUS");
					b[11] = rs.getString("PASTAGEM");
					b[12] = rs.getString("AFTOSA");
					b[13] = rs.getString("RAIVA");
					b[14] = Convert.toString(rs.getInt("QUANTIDADE"));
					b[15] = rs.getString("DATAVENDA");
					b[16] = rs.getString("TIPOPAGAMENTO");
					b[17] = rs.getString("TOTALVENDA");
					
					gridCarrinho.add(b);
					
					rs.next();
				}
				
			} finally {
				if (lb != null)
					lb.closeAll();

			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao carregaGridProdutos carrinho\n" + e);

		}

	}
	
	public void atualizaRebanho() {
		
		String sql 			= "";
		LitebasePack lb     = null;
		ResultSet rs 		= null;

		try {

			try {
				
				lb = new LitebasePack();
				
				sql = "SELECT * FROM VENDAANIMALTEMP";
				
				rs = lb.executeQuery(sql);
				rs.beforeFirst();
				
				while(rs.next()) {
					
					sql = " UPDATE REBANHO " 
						+ " SET QUANTIDADE = " + rs.getInt("QUANTIDADE")
				        + " WHERE CODIGO = " + rs.getInt("CODIGOANIMAL");

					lb.executeUpdate(sql);
					
				}

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro atualizaRebanho\n" + e);
		}
	}
	
	public void salvaInfoVenda() {
		
		String sql 				= "";
		LitebasePack lb 		= null;
		ResultSet rs 			= null;

		try {

			try {
				
				lb = new LitebasePack();
				
				sql = "SELECT * FROM VENDAANIMALTEMP";
				
				rs = lb.executeQuery(sql);
				rs.beforeFirst();
				
				while(rs.next()) {
					
					  codigoVendaInfo 					= rs.getInt("CODIGOVENDA");
					  codigoAnimalInfo 					= rs.getInt("CODIGOANIMAL");
					  descricaoInfo 					= rs.getString("DESCRICAO");
					  idadeInfo 						= rs.getString("IDADE");
					  sexoInfo 							= rs.getString("SEXO");
					  racaInfo 							= rs.getString("RACA");
					  pesoInfo 							= rs.getString("PESO");
					  dataDaCompraInfo 					= rs.getString("DATACOMPRA");
					  precocompraInfo 					= rs.getString("PRECOCOMPRA");
					  precoVendaInfo 					= rs.getString("PRECOVENDA");
					  statusInfo 						= rs.getString("STATUS");
					  pastagemInfo 						= rs.getString("PASTAGEM");
					  aftosaInfo 						= rs.getString("AFTOSA");
					  raivaInfo 						= rs.getString("RAIVA");
					  quantidadeVendidaInfo				= rs.getInt("QUANTIDADE");
					  dataVendaInfo 					= rs.getDate("DATAVENDA").toString(Settings.DATE_YMD);
					  tipopagamentoInfo 				= rs.getString("TIPOPAGAMENTO");
					  totalInfoCalc 					= Convert.toDouble(rs.getString("TOTALVENDA").replace(",", "."));
					  totalInfo							= Convert.toCurrencyString(totalInfoCalc, 2);
									
					  qntDeAnimaisVendidos 				+= rs.getInt("QUANTIDADE");
					  valorTotalDevendas      			+= Convert.toDouble(rs.getString("TOTALVENDA").replace(",", "."));
					  
					  sql = "INSERT INTO VENDAANIMAL " + "("
								+ " CODIGOANIMAL, DESCRICAO, IDADE, SEXO, RACA, PESO, DATACOMPRA, "
								+ " PRECOCOMPRA, PRECOVENDA, STATUS, PASTAGEM, AFTOSA, RAIVA, CODIGOVENDA, TOTALVENDA, QUANTIDADE, "
								+ " TIPOPAGAMENTO, DATAVENDA " + ")" + " VALUES " + "( '" + codigoAnimalInfo + "' , '"
								+ descricaoInfo + "', '" + idadeInfo + "', '" + sexoInfo + "', '" + racaInfo + "','" + pesoInfo + "','"
								+ dataDaCompraInfo + "', '" + precocompraInfo + "', '" + precoVendaInfo + "', '" + statusInfo + "', '"
								+ pastagemInfo + "', '" + aftosaInfo + "', '" + raivaInfo + "', '" + codigoVendaInfo + "', '"
								+ totalInfoCalc + "', '" + quantidadeVendidaInfo + "', '"
								+ tipopagamentoInfo + "', '" + dataVendaInfo + "'" + ")";
						
						lb.executeUpdate(sql);
				}


			} finally {
				
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro salvaInfoVenda\n" + e);
		}
	}
	
	public void calculaAnimaisCarrinho() throws Exception {
		String sql = "";
		LitebasePack lb = null;
		ResultSet rs = null;

		try {

			try {

				lb  = new LitebasePack();
				
				sql = "SELECT QUANTIDADE, TOTALVENDA FROM VENDAANIMALTEMP ";

				rs = lb.executeQuery(sql);
				rs.beforeFirst();
				
				totalCarrinho 		= 0.0;
				quantidadeCarrinho	= 0;
				
				while (rs.next()) {

					quantidadeCarrinho += rs.getInt("QUANTIDADE");
					totalCarrinho += Convert.toDouble(rs.getString("TOTALVENDA"));

				}
				
				editQntAnimais.setText("QUANTIDADE DE ANIMAIS: " + Convert.toString(quantidadeCarrinho));
				editTotalVenda.setText("TOTAL DA VENDA: R$" + Convert.toCurrencyString(totalCarrinho, 2));

			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro calculaItensCarrinho\n" + e);
			}

		} finally {
			if (lb != null) {
				lb.closeAll();
			}
		}

	}
	
}

package com.loja;

import java.util.Random;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.litebase.LitebasePack;
import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import litebase.ResultSet;
import totalcross.sys.Convert;
import totalcross.ui.Edit;
import totalcross.ui.ImageControl;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.Event;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;
import totalcross.util.Date;

public class RemoverAnimalCarrinho extends totalcross.ui.Window {

	private Edit				 editDescricao;
	private Edit				 editIdade;
	private Edit				 editPastagem;
	private Edit				 editRaca;
	private Edit 				 editStatus;
	private Edit 				 editQuantidadeVendida;
	private Edit				 editDataDaCompra;
	private Edit 				 editValor;
	private Edit				 editQuantidade;
	private Edit 				 editTotal;
	
	private Button	 			 btnRemover;
	private Button 				 btnVoltar;
	
	private ComboBox			 cmbTipoPagamento;
	private ImageControl		 imgRemoveAnimalCarrinho;
	
	public double 				 valorAnimal = 0.0;
	public double				 total = 0.0;
	public String				 totalVendaAnimal = "";
	public int				     qntRebanhoFinal = 0;
	public int 				     quantidade = 0;
	public int 					 quantidadeEstoque = 0;
	public int 					 qntEstoqueCalculo = 0;
	public int 					 rebanho = 0;
	public String 				 quantidadeVendida = "";
	public String 				 quantidadeInserida = "";
	
	public int	 				 codigoVenda = 0;
	public int	 				 codigoAnimal = 0;
	public String 				 descricao = "";
	public String	 			 idade = "";
	public String 				 sexo = "";
	public String 				 raca = "";
	public String 				 peso = "";
	public String 				 dataDaCompra = "";
	public String 				 precocompra = "";
	public String 				 precoVenda = "";
	public String 				 status = "";
	public String 				 pastagem = "";
	public String 				 aftosa = "";
	public String 				 raiva = "";
	public int	 				 quantidadeVendidaInfo = 0;
	public String 				 dataVenda = "";
	public String 				 tipopagamento = "";
	public String 				 totalInfo = "";


	public RemoverAnimalCarrinho() {
		super("REMOVER ANIMAL DO CARRINHO", TAB_ONLY_BORDER);
		setBackColor(0x1c355d);
		carregaInfoAnimal();
		initUI();
	}

	public void initUI() {

		try {
			
			carregaInfoAnimal();
			
			imgRemoveAnimalCarrinho = new ImageControl(new Image("img/removeAnimalCarrinho.png"));
			imgRemoveAnimalCarrinho.scaleToFit = true;
			imgRemoveAnimalCarrinho.centerImage = true;
			add(imgRemoveAnimalCarrinho, LEFT + 20, TOP + 60, SCREENSIZE + 35, SCREENSIZE + 55);
			
//			lblCategoria = new Label("CATEGORIA:   ");
//			add(lblCategoria);
//			lblCategoria.setRect(LEFT + 5, AFTER - 30, PREFERRED, PREFERRED, imgInserirProdutoCarrinho);
//			lblCategoria.setBackColor(0x1c355d);
//			lblCategoria.setForeColor(Color.WHITE);

			editDescricao = new Edit();
			add(editDescricao);
			editDescricao.setRect(CENTER + 190, TOP + 80, SCREENSIZE + 50, SCREENSIZE + 6, imgRemoveAnimalCarrinho);
			editDescricao.setBackColor(Color.WHITE);
			editDescricao.setForeColor(0x1c355d);
			editDescricao.setText(descricao);
			editDescricao.setEditable(false);
			
//			lblMarca = new Label("MARCA:          ");
//			add(lblMarca);
//			lblMarca.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, editCategoria);
//			lblMarca.setBackColor(0x1c355d);
//			lblMarca.setForeColor(Color.WHITE);

			editRaca = new Edit();
			add(editRaca);
			editRaca.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editDescricao);
			editRaca.setBackColor(Color.WHITE);
			editRaca.setForeColor(0x1c355d);
			editRaca.setText(raca);
			editRaca.setEditable(false);


			editPastagem = new Edit();
			add(editPastagem);
			editPastagem.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editRaca);
			editPastagem.setBackColor(Color.WHITE);
			editPastagem.setForeColor(0x1c355d);
			editPastagem.setText(pastagem);
			editPastagem.setEditable(false);

//			lblCodigo = new Label("CÓDIGO:          ");
//			add(lblCodigo);
//			lblCodigo.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, editProduto);
//			lblCodigo.setBackColor(0x1c355d);
//			lblCodigo.setForeColor(Color.WHITE);

			editStatus = new Edit();
			add(editStatus);
			editStatus.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editPastagem);
			editStatus.setBackColor(Color.WHITE);
			editStatus.setForeColor(0x1c355d);
			editStatus.setText(status);
			editStatus.setEditable(false);

//			lblEstoque = new Label("ESTOQUE:       ");
//			add(lblEstoque);
//			lblEstoque.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, editCodigo);
//			lblEstoque.setBackColor(0x1c355d);
//			lblEstoque.setForeColor(Color.WHITE);

			editDataDaCompra = new Edit();
			add(editDataDaCompra);
			editDataDaCompra.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editStatus);
			editDataDaCompra.setBackColor(Color.WHITE);
			editDataDaCompra.setForeColor(0x1c355d);
			editDataDaCompra.setText(dataDaCompra);
			editDataDaCompra.setEditable(false);
			
			editQuantidadeVendida = new Edit();
			add(editQuantidadeVendida);
			editQuantidadeVendida.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editDataDaCompra);
			editQuantidadeVendida.setBackColor(Color.WHITE);
			editQuantidadeVendida.setForeColor(0x1c355d);
			editQuantidadeVendida.setText(Convert.toString(quantidadeVendidaInfo));
			editQuantidadeVendida.setEditable(false);

//			lblQuantidade = new Label("QUANTIDADE: ");
//			add(lblQuantidade);
//			lblQuantidade.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, lblEstoque);
//			lblQuantidade.setBackColor(0x1c355d);
//			lblQuantidade.setForeColor(Color.WHITE);
			
			editTotal = new Edit();
			add(editTotal);
			editTotal.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editQuantidadeVendida);
			editTotal.setBackColor(Color.WHITE);
			editTotal.setForeColor(0x1c355d);
			editTotal.setValidChars("0 1 2 3 4 5 6 7 8 9");
			editTotal.setText(totalInfo);
			
			editQuantidade = new Edit();
			add(editQuantidade);
			editQuantidade.setRect(CENTER + 190, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editTotal);
			editQuantidade.setBackColor(Color.WHITE);
			editQuantidade.setForeColor(0x1c355d);
			editQuantidade.setValidChars("0 1 2 3 4 5 6 7 8 9");
			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
            
            btnRemover = BottomImg.imageWithText(new Image("img/remover.png"), "Remover", Button.BOTTOM);
			add(btnRemover, LEFT, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnRemover.setBackColor(0x1c355d);
			btnRemover.setForeColor(Color.WHITE);
			
			reposition();
			
			editQuantidade.requestFocus();
			
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO","Erro ao construir a tela InserirAnimalCarrinho\n" + e);

		}

	}

	public void onEvent(Event evt) {

		try {
			switch (evt.type) {
			case ControlEvent.PRESSED:

				if (evt.target == btnVoltar) {
					unpop();

				}
				if (evt.target == btnRemover) {

					if (editQuantidade.getText().equals("")) {
						
						Auxiliares.messagebox("AGIL", "Por favor digite uma quantidade!");
						return;

					} else if (Convert.toInt(editQuantidade.getText()) == 0) {
						
						Auxiliares.messagebox("AGIL", "Quantidade inválida!");
						editQuantidade.setText("");
						return;

					} else if (Convert.toInt(editQuantidadeVendida.getText()) < 0) {
						Auxiliares.messagebox("AGIL", "Quantidade inserida maior que a quantidade no carrinho!");
						
						editQuantidade.setText("");
						editQuantidadeVendida.setText(Convert.toString(quantidadeVendidaInfo));
						editTotal.setText(totalInfo);
						
						editQuantidade.requestFocus();

						return;

					}else {

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja remover " + editQuantidade.getText()
								+ " unidade(s) deste animal do carrinho?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							boolean menssagemUm 	= false;
							menssagemUm 			= removeAnimalCarrinho(menssagemUm);

							if (menssagemUm) {

								Auxiliares.messagebox("AGIL", "Animal(s) removido do carrinho!");

								unpop();
								unpop();

							} else {

								Auxiliares.messagebox("AGIL",
										"Animal(s) removido do carrinho!\nCarrinho sem esse animal(s)!");

								if (existeAnimalCarrinho() == false) {
									
									Auxiliares.messagebox("AGIL", "Carrinho vazio!");
									
									Loja.btnCarrinho.setEnabled(false);
									unpop();
									unpop();
									
								} else {
									
									unpop();
									unpop();

								}

							}

						}
					}
				}
				if (editQuantidade.getText().length() > 0) {
					calculaTotalAnimal();

				} else if (editQuantidade.getText().length() == 0) {
					editQuantidadeVendida.setText(Convert.toString(quantidadeVendidaInfo));
					editTotal.setText("");
				}
			}
		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro na validação da tela inserir\n" + e);
		}

	}

	public void calculaTotalAnimal() {

		try {

			quantidadeInserida = editQuantidade.getText();
			qntRebanhoFinal = quantidadeVendidaInfo - Convert.toInt(quantidadeInserida);

			valorAnimal = Convert.toDouble(precoVenda.replace(",", "."));
			quantidade = qntRebanhoFinal;

			total = valorAnimal * quantidade;
			totalVendaAnimal = Convert.toString(total, 2);
			editTotal.setText(Convert.toCurrencyString(total, 2));
			editQuantidadeVendida.setText(Convert.toString(qntRebanhoFinal));

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro no calculo do produto\n" + e);
		}

	}
	
	public boolean existeAnimalCarrinho() {
		{
			
			String sql 				= "";
			LitebasePack lb 		= null;
			ResultSet rs 			= null;

			try {
				
			
				try {
					
					lb = new LitebasePack();

					sql = " SELECT * FROM VENDAANIMALTEMP ";

					rs = lb.executeQuery(sql);
					rs.first();

					if (rs.getRowCount() == 0) {
						return false;

					} else {

						return true;
					}

				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro ao existeAnimalCarrinhos\n" + e);

				return true;
			}

		}
	}
	
	public void buscaEstoqueRebanho() {
		{
			String sql 				= "";
			LitebasePack lb 		= null;
			ResultSet rs 			= null;

			try {
				try {

					lb = new LitebasePack();
					
					sql = " SELECT QUANTIDADE FROM REBANHO " 
					    + " WHERE CODIGO = " + codigoAnimal;

					rs = lb.executeQuery(sql);
					rs.first();

					if (rs.getRowCount() > 0) {

						rebanho = rs.getInt("CODIGOVENDA");

					}

				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro buscaEstoqueRebanho\n" + e);

			}

		}
	}
	
	public void carregaInfoAnimal() {
		{
			String sql 				= "";
			LitebasePack lb 		= null;
			ResultSet rs 			= null;

			try {
				try {

					lb = new LitebasePack();
					
					sql = " SELECT * FROM VENDAANIMALTEMP " 
					    + " WHERE CODIGOVENDA = " + Carrinho.codigoVenda
					    + " AND CODIGOANIMAL = " + Carrinho.codigoAnimal;

					rs = lb.executeQuery(sql);
					rs.first();

					if (rs.getRowCount() > 0) {
						
						codigoVenda 				= rs.getInt("CODIGOVENDA");
						codigoAnimal 				= rs.getInt("CODIGOANIMAL");
						descricao 					= rs.getString("DESCRICAO");
						idade 						= rs.getString("IDADE");
						sexo 						= rs.getString("SEXO");
						raca 						= rs.getString("RACA");
						peso 						= rs.getString("PESO");
						dataDaCompra 				= rs.getString("DATACOMPRA");
						precocompra 				= rs.getString("PRECOCOMPRA");
						precoVenda 					= rs.getString("PRECOVENDA");
						status 						= rs.getString("STATUS");
						pastagem 					= rs.getString("PASTAGEM");
						aftosa 						= rs.getString("AFTOSA");
						raiva 						= rs.getString("RAIVA");
						quantidadeVendidaInfo		= rs.getInt("QUANTIDADE");
						dataVenda 					= rs.getString("DATAVENDA");
						tipopagamento 				= rs.getString("TIPOPAGAMENTO");
						totalInfo 					= rs.getString("TOTALVENDA");
					}

				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaInfoAnimal\n" + e);

			}

		}
	}
	
	public boolean removeAnimalCarrinho(boolean menssagemUm) {

		LitebasePack lb 	= null;
		String sql 			= "";

		try {

			try {

				lb = new LitebasePack();
				
				if(Convert.toInt(editQuantidadeVendida.getText()) == 0 ) {
					
					
				sql = " DELETE VENDAANIMALTEMP " 
				    + " WHERE CODIGOANIMAL = " + codigoAnimal;

				lb.executeUpdate(sql);
				
				 return false;
				 
				}
				
				
				sql = " UPDATE VENDAANIMALTEMP " 
				    + " SET QUANTIDADE = " + editQuantidadeVendida.getText() 
				    + " WHERE CODIGOANIMAL = " + codigoAnimal;

				lb.executeUpdate(sql);
				
				sql = " UPDATE VENDAANIMALTEMP " 
					+ " SET TOTALVENDA = " + totalVendaAnimal
					+ " WHERE CODIGOANIMAL = " + codigoAnimal;

				lb.executeUpdate(sql);
				
				return true;
					

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro removeAnimalCarrinho\n" + e);
			return true;
		}

	}

}

package com.loja;

import java.util.Random;
import com.auxiliares.Auxiliares;
import com.bottom.BottomImg;
import com.carrinho.Carrinho;
import com.litebase.LitebasePack;
import com.venda.Loja;

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

public class RemoveAnimalCarrinho extends totalcross.ui.Window {

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
	public double				 totalVendaAnimal = 0.0;
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


	public RemoveAnimalCarrinho() {
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
			add(imgRemoveAnimalCarrinho, LEFT + 10, TOP + 35, SCREENSIZE + 30, SCREENSIZE + 50);
			
//			lblCategoria = new Label("CATEGORIA:   ");
//			add(lblCategoria);
//			lblCategoria.setRect(LEFT + 5, AFTER - 30, PREFERRED, PREFERRED, imgInserirProdutoCarrinho);
//			lblCategoria.setBackColor(0x1c355d);
//			lblCategoria.setForeColor(Color.WHITE);

			editDescricao = new Edit();
			add(editDescricao);
			editDescricao.setRect(CENTER + 150, TOP + 60, SCREENSIZE + 50, SCREENSIZE + 6, imgRemoveAnimalCarrinho);
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
			editRaca.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editDescricao);
			editRaca.setBackColor(Color.WHITE);
			editRaca.setForeColor(0x1c355d);
			editRaca.setText(raca);
			editRaca.setEditable(false);
			
//			lblDescricao = new Label("DESCRIÇÃO:   ");
//			add(lblDescricao);
//			lblDescricao.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, editMarca);
//			lblDescricao.setBackColor(0x1c355d);
//			lblDescricao.setForeColor(Color.WHITE);

			editIdade = new Edit();
			add(editIdade);
			editIdade.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editRaca);
			editIdade.setBackColor(Color.WHITE);
			editIdade.setForeColor(0x1c355d);
			editIdade.setText(idade);
			editDescricao.setEditable(false);		

//			lblProduto = new Label("PRODUTO:      ");
//			add(lblProduto);
//			lblProduto.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, editDescricao);
//			lblProduto.setBackColor(0x1c355d);
//			lblProduto.setForeColor(Color.WHITE);

			editPastagem = new Edit();
			add(editPastagem);
			editPastagem.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editDescricao);
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
			editStatus.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editPastagem);
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
			editDataDaCompra.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editStatus);
			editDataDaCompra.setBackColor(Color.WHITE);
			editDataDaCompra.setForeColor(0x1c355d);
			editDataDaCompra.setText(dataDaCompra);
			editDataDaCompra.setEditable(false);
			
			editQuantidadeVendida = new Edit();
			add(editQuantidadeVendida);
			editQuantidadeVendida.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editDataDaCompra);
			editQuantidadeVendida.setBackColor(Color.WHITE);
			editQuantidadeVendida.setForeColor(0x1c355d);
			editQuantidadeVendida.setText(Convert.toString(quantidadeVendidaInfo));
			editQuantidadeVendida.setEditable(false);

//			lblQuantidade = new Label("QUANTIDADE: ");
//			add(lblQuantidade);
//			lblQuantidade.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, lblEstoque);
//			lblQuantidade.setBackColor(0x1c355d);
//			lblQuantidade.setForeColor(Color.WHITE);

			editQuantidade = new Edit();
			add(editQuantidade);
			editQuantidade.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editQuantidadeVendida);
			editQuantidade.setBackColor(Color.WHITE);
			editQuantidade.setForeColor(0x1c355d);
			editQuantidade.setValidChars("0 1 2 3 4 5 6 7 8 9");

//			lblValor = new Label("VALOR:            ");
//			add(lblValor);
//			lblValor.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, lblQuantidade);
//			lblValor.setBackColor(0x1c355d);
//			lblValor.setForeColor(Color.WHITE);

			editValor = new Edit();
			add(editValor);
			editValor.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editQuantidade);
			editValor.setBackColor(Color.WHITE);
			editValor.setForeColor(0x1c355d);
			editValor.setText(precoVenda);
			editValor.setEditable(false);

//			lblTotal = new Label("TOTAL:            ");
//			add(lblTotal);
//			lblTotal.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, editValor);
//			lblTotal.setBackColor(0x1c355d);
//			lblTotal.setForeColor(Color.WHITE);

			editTotal = new Edit();
			add(editTotal);
			editTotal.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editValor);
			editTotal.setBackColor(Color.WHITE);
			editTotal.setForeColor(0x1c355d);
			editTotal.setText("0.00");
			editTotal.setEditable(false);
			editTotal.setText(totalInfo);
			
			cmbTipoPagamento = new ComboBox();
			add(cmbTipoPagamento);
			cmbTipoPagamento.setRect(CENTER + 170, AFTER + 50, SCREENSIZE + 20, PREFERRED, editTotal);
			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
            
            btnRemover = BottomImg.imageWithText(new Image("img/adicionarCarrinho.png"), "Inserir", Button.BOTTOM);
			add(btnRemover, LEFT, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnRemover.setBackColor(0x1c355d);
			btnRemover.setForeColor(Color.WHITE);
			
			reposition();
			
			carregaCmbTipoPagamento();
//			cmbTipoPagamento.setSelectedIndex(0);
			
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
						edit.setText(Carrinho.quantidadeProduto);
						editTotal.setText(Carrinho.totalProduto);
						
						editQuantidade.requestFocus();

						return;

					}else {

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("SOLUCAO", "Deseja remover " + editQuantidade.getText()
								+ " unidade(s) deste produto\ndo carrinho?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							removeProdutoCarrinho();

							if (Convert.toInt(editQntCarrinho.getText()) == 0
									|| Convert.toInt(editQntCarrinho.getText()) < 0) {

								deletaProdutoCarrinho();

								boolean existeProdutoCarrinho = false;
								existeProdutoCarrinho = existeProdutoCarrinho(existeProdutoCarrinho);

								if (existeProdutoCarrinho) {
									Auxiliares.messagebox("SOLUCAO", "Produto removido do carrinho!");

									unpop();
									unpop();
								} else {
									Auxiliares.messagebox("SOLUCAO", "Produto removido do carrinho!\nCarrinho vazio!");
									Loja.btnCarrinho.setEnabled(false);
									unpop();
									unpop();
								}

							} else {
								Auxiliares.messagebox("SOLUCAO", "Produto removido do carrinho!");

								unpop();
								unpop();
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

			String quantidadeString = "";
			quantidadeString = editQuantidade.getText();
			valorAnimal = Convert.toDouble(precoVenda.replace(",", "."));
			quantidade = Convert.toInt(quantidadeString);

			total = valorAnimal * quantidade;
			totalVendaAnimal = total;
			editTotal.setText(Convert.toCurrencyString(total, 2));
			editQuantidadeVendida.setText(Convert.toString(qntRebanhoFinal));

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro no calculo do produto\n" + e);
		}

	}
	
	public boolean existeAnimalCarrinho(boolean existeAnimalCarrinho) {
		{
			String sql = "";
			LitebasePack lb = null;
			ResultSet rs = null;

			try {
				try {
					lb = new LitebasePack();

					sql = " SELECT * FROM VENDAANIMALTEMP "
						+ " WHERE CODIGOANIMAL = " + codigoAnimal;

					rs = lb.executeQuery(sql);
					rs.first();

					if (rs.getRowCount() == 0) {
						return existeAnimalCarrinho = false;

					} else {

						return existeAnimalCarrinho = true;
					}

				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro ao carregaCmbMarca\n" + e);

				return existeAnimalCarrinho;
			}

		}
	}
	
	public void carregaCmbTipoPagamento() {
		{
			String sql 				= "";
			LitebasePack lb 		= null;
			ResultSet rs 			= null;

			try {
				try {
					
					lb = new LitebasePack();
					sql = " SELECT DESCRICAO FROM TIPOPAGAMENTO";

					rs = lb.executeQuery(sql);
					rs.first();
					for (int i = 0; rs.getRowCount() > i; i++) {
						String[] b = new String[1];
						b[0] = rs.getString("DESCRICAO");
						cmbTipoPagamento.add(b);
						rs.next();
					}

					sql = " SELECT TIPOPAGAMENTO FROM VENDAANIMALTEMP " 
					    + " WHERE CODIGOVENDA = " + Carrinho.codigoVenda;

					rs = lb.executeQuery(sql);
					rs.first();

					if (rs.getString("TIPOPAGAMENTO").equals("DINHEIRO")) {
						
						cmbTipoPagamento.setSelectedIndex(0);
						
					} else if (rs.getString("TIPOPAGAMENTO").equals("CARTAO")) {
						
						cmbTipoPagamento.setSelectedIndex(1);

					} else if (rs.getString("TIPOPAGAMENTO").equals("CHEQUE")) {
						
						cmbTipoPagamento.setSelectedIndex(2);
					}

				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbTipoPagamento\n" + e);

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
					    + " WHERE CODIGOVENDA = " + Carrinho.codigoVenda;

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
	
	public void removeAnimalCarrinho() {

		LitebasePack lb 	= null;
		String sql 			= "";

		try {

			try {

				lb = new LitebasePack();
				
				sql = " UPDATE VENDAANIMALTEMP " 
				    + " SET QUANTIDADE = " + editQuantidadeVendida.getText() 
				    + " WHERE CODIGOANIMAL = " + codigoAnimal;

				lb.executeUpdate(sql);
				
				sql = " UPDATE VENDAANIMALTEMP " 
					+ " SET TOTALVENDA = " + editTotal.getText() 
					+ " WHERE CODIGOANIMAL = " + codigoAnimal;

				lb.executeUpdate(sql);
					

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro removeAnimalCarrinho\n" + e);
		}

	}

}

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

public class InserirAnimalCarrinho extends totalcross.ui.Window {

	private Edit				 editDescricao;
	private Edit				 editIdade;
	private Edit				 editPastagem;
	private Edit				 editRaca;
	private Edit 				 editStatus;
	private Edit 				 editRebanho;
	private Edit				 editDataDaCompra;
	private Edit 				 editValor;
	private Edit				 editQuantidade;
	private Edit 				 editTotal;
	
	private Button	 			 btnInserir;
	private Button 				 btnVoltar;
	
	private ComboBox			 cmbTipoPagamento;
	private ImageControl		 imgInserirAnimalCarrinho;
	
	public double 				 valorAnimal = 0.0;
	public double				 total = 0.0;
	public double				 totalVendaAnimal = 0.0;
	public int				     qntRebanhoFinal = 0;
	public int 				     quantidade = 0;
	public int 					 quantidadeEstoque = 0;
	public int 					 qntEstoqueCalculo = 0;
	public String 				 quantidadeVendida = "";
	public String 				 quantidadeInserida = "";
	
	public int	 				 codigoAnimal = 0;
	public String 				 descricao = "";
	public int	 				 rebanho = 0;
	public String 				 idade = "";
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


	public InserirAnimalCarrinho() {
		setBackColor(0x1c355d);
		initUI();
	}

	public void initUI() {

		try {
			
			carregaInfoAnimal();
			
			imgInserirAnimalCarrinho = new ImageControl(new Image("img/inserirAnimalCarrinho.png"));
			imgInserirAnimalCarrinho.scaleToFit = true;
			imgInserirAnimalCarrinho.centerImage = true;
			add(imgInserirAnimalCarrinho, LEFT + 10, TOP + 35, SCREENSIZE + 30, SCREENSIZE + 50);
			
//			lblCategoria = new Label("CATEGORIA:   ");
//			add(lblCategoria);
//			lblCategoria.setRect(LEFT + 5, AFTER - 30, PREFERRED, PREFERRED, imgInserirProdutoCarrinho);
//			lblCategoria.setBackColor(0x1c355d);
//			lblCategoria.setForeColor(Color.WHITE);

			editDescricao = new Edit();
			add(editDescricao);
			editDescricao.setRect(CENTER + 150, TOP + 60, SCREENSIZE + 50, SCREENSIZE + 6, imgInserirAnimalCarrinho);
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
			
			editRebanho = new Edit();
			add(editRebanho);
			editRebanho.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editDataDaCompra);
			editRebanho.setBackColor(Color.WHITE);
			editRebanho.setForeColor(0x1c355d);
			editRebanho.setText(Convert.toString(rebanho));
			editRebanho.setEditable(false);

//			lblQuantidade = new Label("QUANTIDADE: ");
//			add(lblQuantidade);
//			lblQuantidade.setRect(LEFT + 5, AFTER + 15, PREFERRED, PREFERRED, lblEstoque);
//			lblQuantidade.setBackColor(0x1c355d);
//			lblQuantidade.setForeColor(Color.WHITE);

			editQuantidade = new Edit();
			add(editQuantidade);
			editQuantidade.setRect(CENTER + 150, AFTER, SCREENSIZE + 50, SCREENSIZE + 6, editRebanho);
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
			
			cmbTipoPagamento = new ComboBox();
			add(cmbTipoPagamento);
			cmbTipoPagamento.setRect(CENTER + 170, AFTER + 50, SCREENSIZE + 20, PREFERRED, editTotal);
			
			btnVoltar = BottomImg.imageWithText(new Image("img/sair.png"), "Voltar", Button.BOTTOM);
			add(btnVoltar, RIGHT - 2, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnVoltar.setBackColor(0x1c355d);
			btnVoltar.setForeColor(Color.WHITE);
            
            btnInserir = BottomImg.imageWithText(new Image("img/adicionarCarrinho.png"), "Inserir", Button.BOTTOM);
			add(btnInserir, LEFT, BOTTOM, SCREENSIZE + 25, PREFERRED + 10);
			btnInserir.setBackColor(0x1c355d);
			btnInserir.setForeColor(Color.WHITE);
			
			reposition();
			
			carregaCmbTipoPagamento();
			cmbTipoPagamento.setSelectedIndex(0);
			
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
				if (evt.target == btnInserir) {

					if (editQuantidade.getText().length() == 0) {
						Auxiliares.messagebox("AGIL", "Por favor insira uma quantidade!");
						return;
					}

					if (editQuantidade.getText().length() > 0) {

						rebanho = Convert.toInt(editRebanho.getText());
						quantidadeInserida = editQuantidade.getText();

						if (Convert.toInt(quantidadeInserida) > rebanho) {
							Auxiliares.messagebox("AGIL", "Quantidade inserida maior que o rebanho diusponível !");
							
							editQuantidade.setText("");
							editRebanho.setText(Convert.toString(rebanho));
							editTotal.setText("0.00");
							
							editQuantidade.requestFocus();
							return;

						}

						String[] ArtButtonArray = { "Sim", "Não" };

						int i = Auxiliares.messageBox("AGIL", "Deseja inserir " + editQuantidade.getText()
								+ " animal(s) no carrinho?", ArtButtonArray);

						if (i == 1) {
							return;

						} else {

							InsereAnimalCarrinho();

							Auxiliares.messagebox("AGIL", "Animal(s) inserido no carrinho!");

							Loja.btnCarrinho.setEnabled(true);
							unpop();
						}
					}

				}
				if (editQuantidade.getText().length() > 0) {
					calculaTotalAnimal();

				} else if (editQuantidade.getText().length() == 0) {
					editRebanho.setText(Convert.toString(rebanho));
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
			qntRebanhoFinal = rebanho - Convert.toInt(quantidadeInserida);

			String quantidadeString = "";
			quantidadeString = editQuantidade.getText();
			valorAnimal = Convert.toDouble(precoVenda.replace(",", "."));
			quantidade = Convert.toInt(quantidadeString);

			total = valorAnimal * quantidade;
			totalVendaAnimal = total;
			editTotal.setText(Convert.toCurrencyString(total, 2));
			editRebanho.setText(Convert.toString(qntRebanhoFinal));

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro no calculo do produto\n" + e);
		}

	}
	
	public void InsereAnimalCarrinho() {

		String sql				= "";
		LitebasePack lb 		= null;
		ResultSet rs 			= null;

		try {
			try {
				
				lb = new LitebasePack();
				
				sql = "SELECT CODIGOVENDA FROM VENDAANIMALTEMP";
				rs = lb.executeQuery(sql);
				rs.first();
				
				if (rs.getRowCount() == 0) {

					Random random 		    = new Random();
					int codigoVendaNova 	= random.nextInt(900);
					Date year 				= new Date();
					Date month 				= new Date();
					Date day 				= new Date();
					
					String dataVenda;

					dataVenda = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());

					sql = "INSERT INTO VENDAANIMALTEMP " + "("
							+ " CODIGOANIMAL, DESCRICAO, IDADE, SEXO, RACA, PESO, DATACOMPRA, "
							+ " PRECOCOMPRA, PRECOVENDA, STATUS, PASTAGEM, AFTOSA, RAIVA, CODIGOVENDA, TOTALVENDA, QUANTIDADE, "
							+ " TIPOPAGAMENTO, DATAVENDA " + ")" + " VALUES " + "( '" + codigoAnimal + "' , '"
							+ descricao + "', '" + idade + "', '" + sexo + "', '" + raca + "','" + peso + "','"
							+ dataDaCompra + "', '" + precocompra + "', '" + precoVenda + "', '" + status + "', '" + pastagem + "', '"
							+ aftosa + "', '" + raiva + "', '" + codigoVendaNova + "', '" + totalVendaAnimal + "', '"
							+ editQuantidade.getText() + "', '" + cmbTipoPagamento.getSelectedItem() + "', '"
							+ dataVenda + "'" + ")";

					lb.executeUpdate(sql);

				} else {

					int codigoVendaCarrinho = rs.getInt("CODIGOVENDA");
					String dataVenda;
					Date year = new Date();
					Date month = new Date();
					Date day = new Date();

					dataVenda = Date.formatDate(day.getDay(), month.getMonth(), year.getYear());

					sql = "INSERT INTO VENDAANIMALTEMP " + "("
							+ " CODIGOANIMAL, DESCRICAO, IDADE, SEXO, RACA, PESO, DATACOMPRA, "
							+ " PRECOCOMPRA, PRECOVENDA, STATUS, PASTAGEM, AFTOSA, RAIVA, CODIGOVENDA, TOTALVENDA, QUANTIDADE, "
							+ " TIPOPAGAMENTO, DATAVENDA " + ")" + " VALUES " + "( '" + codigoAnimal + "' , '"
							+ descricao + "', '" + idade + "', '" + sexo + "', '" + raca + "','" + peso + "','"
							+ dataDaCompra + "', '" + precocompra + "', '" + precoVenda + "', '" + status + "', '"
							+ pastagem + "', '" + aftosa + "', '" + raiva + "', '" + codigoVendaCarrinho + "', '"
							+ totalVendaAnimal + "', '" + editQuantidade.getText() + "', '"
							+ cmbTipoPagamento.getSelectedItem() + "', '" + dataVenda + "'" + ")";
					
					lb.executeUpdate(sql);

				}

			} finally {
				if (lb != null)
					lb.closeAll();
			}

		} catch (Exception e) {
			Auxiliares.messagebox("ERRO", "Erro ao inserir produto estoque\n" + e);
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
				} finally {
					if (lb != null)
						lb.closeAll();

				}
			} catch (Exception e) {
				Auxiliares.messagebox("ERRO", "Erro carregaCmbTipoPagamento\n" + e);

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
					
					sql = " SELECT * FROM REBANHO " 
					    + " WHERE CODIGO = " + Loja.codigo;

					rs = lb.executeQuery(sql);
					rs.first();

					if (rs.getRowCount() > 0) {
						codigoAnimal 			= rs.getInt("CODIGO");
						descricao 				= rs.getString("DESCRICAO");
						rebanho					= rs.getInt("QUANTIDADE");
						idade					= rs.getString("IDADE");
						sexo 					= rs.getString("SEXO");
						raca 					= rs.getString("RACA");
						peso 					= rs.getString("PESO");
						dataDaCompra 			= rs.getString("DATACOMPRA");
						precocompra				= rs.getString("PRECOCOMPRA");
						precoVenda 				= rs.getString("PRECOVENDA");
						status 					= rs.getString("STATUS");
						pastagem 				= rs.getString("PASTAGEM");
						aftosa 					= rs.getString("AFTOSA");
						raiva 					= rs.getString("RAIVA");

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

}
